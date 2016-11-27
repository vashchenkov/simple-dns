package ru.gubber.simple_dns.packet;

import static ru.gubber.simple_dns.utils.ByteArrayUtils.bytesToInt;

/**
 * Класс, разбирающий ДНС пакет
 * Created by a.vashchenkov on 06.11.2016.
 */
public class DnsRequestParser {

	private static int HEADER_LENGTH = 12;

	//FIRST BYTE AFTER ID (2 BYTES)
	private final static byte QR_MASK = (byte) 128; //10000000
	private final static byte OPC_MASK = 120;       //01111000
	private final static byte AA_MASK = 4;          //00000100
	private final static byte TC_MASK = 2;          //00000010
	private final static byte RD_MASK = 1;          //00000001

	//SECOND BYTE AFTER ID (2 BYTES)
	private final static byte RA_MASK = (byte) 128; //10000000
	private final static byte RC_MASK = 15;         //00001111

	public static DnsPacket parseResponse(byte[] request) {
		DnsPacket packet = new DnsPacket();
		byte[] headerBytes = new byte[HEADER_LENGTH];
		System.arraycopy(request, 0, headerBytes, 0, HEADER_LENGTH);

		String str = "";
		for (int i = 0; i < headerBytes.length; i++) {
			byte headerByte = headerBytes[i];
			switch (i) {
				case 2:
				case 3:
				case 6:
				case 8:
				case 10:
				case 4: str += "|";
				default: str += String.format("%8s", Integer.toBinaryString(headerByte & 0xFF)).replace(' ', '0');
			}
		}

		packet.setRepresentation(str);

		byte[] idBytes = new byte[]{(byte)0,(byte)0,(byte)0,(byte)0};
		System.arraycopy(request, 0, idBytes, 0, 2);
		packet.setId(bytesToInt(idBytes));

		byte b = request[2]; //contains QR, OPCode, AA, TC, RD
		packet.setReq((b & QR_MASK) > 0);
		packet.setOpCode((byte) ((b & OPC_MASK) >> 3));
		packet.setAuthAnsw((b & AA_MASK) > 0);
		packet.setTruncated((b & TC_MASK) > 0);
		packet.setRecurtionDesired((b & RD_MASK) > 0);

		b = request[2]; //contains RA, Z, RCode
		packet.setRecurtionDesired((b & RA_MASK) > 0);
		packet.setResponseCode((byte) (b & RC_MASK));

		byte[] qdBytes = new byte[]{(byte)0,(byte)0,(byte)0,(byte)0};
		System.arraycopy(request, 4, qdBytes, 2, 2);
		packet.setQuestionCount(bytesToInt(qdBytes));

		byte[] anBytes = new byte[]{(byte)0,(byte)0,(byte)0,(byte)0};
		System.arraycopy(request, 6, anBytes, 2, 2);
		packet.setAnswersCount(bytesToInt(anBytes));

		byte[] nsBytes = new byte[]{(byte)0,(byte)0,(byte)0,(byte)0};
		System.arraycopy(request, 8, nsBytes, 2, 2);
		packet.setNsCount(bytesToInt(nsBytes));

		byte[] arBytes = new byte[]{(byte)0,(byte)0,(byte)0,(byte)0};
		System.arraycopy(request, 10, arBytes, 2, 2);
		packet.setAddRecordCount(bytesToInt(arBytes));

		return packet;
	}

}
