package ru.gubber.simple_dns;

import ru.gubber.simple_dns.server.ServerListenerThread;

import java.util.logging.Logger;

/**
 * Created by a.vashchenkov on 06.11.2016.
 */
public class SimpleDnsApp {
	private final static Logger logger = Logger.getLogger(SimpleDnsApp.class.getName());

	public static void main(String[] args) {
		ServerListenerThread serverThread = new ServerListenerThread();
		serverThread.start();
	}
}
