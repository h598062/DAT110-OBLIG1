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

		MessageConnection connection = null;

		// TODO - START
		// accept TCP connection on welcome socket and create messaging connection to be returned

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return connection;

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
