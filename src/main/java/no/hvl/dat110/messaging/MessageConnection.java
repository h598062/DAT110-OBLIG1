package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;

/**
 *
 */
public class MessageConnection {

	/**
	 * for writing bytes to the underlying TCP connection
	 */
	private DataOutputStream outStream;
	/**
	 * for reading bytes from the underlying TCP connection
	 */
	private DataInputStream inStream;
	/**
	 * socket for the underlying TCP connection
	 */
	private Socket socket;

	/**
	 *
	 * @param socket
	 */
	public MessageConnection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream(socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * encapsulate the data contained in the Message and write to the output stream
	 * @param message The message to be sent to the output stream
	 */
	public void send(Message message) {

		byte[] data;

		// TODO - START
		// encapsulate the data contained in the Message and write to the output stream

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

	}

	/**
	 * read a segment from the input stream and decapsulate data into a Message
	 * @return the resulting Message
	 */
	public Message receive() {

		Message message = null;
		byte[] data;

		// TODO - START
		// read a segment from the input stream and decapsulate data into a Message

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return message;

	}

	/**
	 * close the connection by closing streams and the underlying socket
	 */
	public void close() {

		try {

			outStream.close();
			inStream.close();

			socket.close();

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
