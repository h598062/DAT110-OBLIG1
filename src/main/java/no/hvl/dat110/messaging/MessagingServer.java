package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;

import no.hvl.dat110.TODO;

/**
 *
 */
public class MessagingServer {

	/**
	 * server-side socket for accepting incoming TCP connections
	 */
	private ServerSocket welcomeSocket;

	/**
	 *
	 * @param port
	 */
	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * accept an incoming connection from a client
	 * @return The new MessageConnection to the client
	 */
	public MessageConnection accept() {

		try {
			return new MessageConnection(welcomeSocket.accept());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Closes a connection
	 */
	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
