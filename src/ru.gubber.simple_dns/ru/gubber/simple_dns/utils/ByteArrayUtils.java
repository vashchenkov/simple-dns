package ru.gubber.simple_dns.utils;

/**
 * Класс для преобразования примитивных типов в массив байтов
 * Created by a.vashchenkov on 28.01.2016.
 */
public class ByteArrayUtils {

	public static byte[] longToBytes(long l) {
		byte[] result = new byte[8];
		for (int i=7; i>=0; i--){
			result[i] = (byte)(l & 255);
			l >>>= 8;
		}
		return result;
	}

	public static long bytesToLong(byte[] bytes) {
		int max= Math.max(8, bytes.length) -1;
		long result = 0;
		for (int i=0; i< max; i++) {
			result = (result | ((long)bytes[i]&0xff));
			result <<=8;
		}
		result = (result | ((long)bytes[max]&0xff));
		return result;
	}

	public static byte[] intToBytes(int l) {
		byte[] result = new byte[4];
		for (int i=3; i>=0; i--){
			result[i] = (byte)(l & 255);
			l >>>= 8;
		}
		return result;
	}

	public static int bytesToInt(byte[] bytes) {
		int max= Math.max(4, bytes.length) -1;
		int result = 0;
		for (int i=0; i< max; i++) {
			result = (result | ((int)bytes[i]&0xff));
			result <<=8;
		}
		result = (result | ((int)bytes[max]&0xff));
		return result;
	}
}