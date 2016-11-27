package ru.gubber.simple_dns.server;

import ru.gubber.simple_dns.packet.DnsPacket;
import ru.gubber.simple_dns.packet.DnsRequestParser;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by a.vashchenkov on 06.11.2016.
 */
public class ServerListenerThread extends Thread {
	private final static Logger logger = Logger.getLogger(ServerListenerThread.class.getName());

	@Override
	public void run() {
		try {
			DatagramSocket ds = new DatagramSocket(53);
			while (true) {
				byte[] buffer = new byte[512];
				DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
				ds.receive(incoming);
				byte[] data = incoming.getData();
				registerPacket(ds, incoming, data);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	private void registerPacket(DatagramSocket ds, DatagramPacket incoming, byte[] data) throws IOException {
		logger.log(Level.FINEST, String.format("Receive packet from %s:%d", incoming.getAddress(), incoming.getPort()));
		DnsPacket dnsPacket = DnsRequestParser.parseResponse(data);
		logger.log(Level.FINEST, String.format("Packet is %s", dnsPacket));
/*
		DnsRequest request = DnsRequestParser.parseResponse(data);
		ICommandReceiver command = CommandFactory.findCommand(request);
		byte[] response = command.execute(request);
		DatagramPacket out = new DatagramPacket(response, response.length,
				incoming.getAddress(),
				incoming.getPort());
		ds.send(out);
*/
	}
}