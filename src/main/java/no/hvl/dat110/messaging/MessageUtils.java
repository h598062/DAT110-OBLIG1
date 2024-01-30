package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

/**
 * Helper methods for Encapsulating and Decapsulating Messages
 */
public class MessageUtils {

	public static final int SEGMENTSIZE = 128;
	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";

	/**
	 * encapulate/encode the payload data of the message and form a segment
	 * according to the segment format for the messaging layer
	 *
	 * @param message The message
	 * @return byte array segment
	 */
	public static byte[] encapsulate(Message message) {

		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();

		segment[0] = (byte)data.length;

        for (int i = 1; i <= data.length; i++) {
			segment[i] = data[i-1];
        }

		return segment;
	}

	/**
	 * decapsulate segment and put received payload data into a message
	 *
	 * @param segment A byte array segment
	 * @return The message
	 */
	public static Message decapsulate(byte[] segment) {

		int header = segment[0];
		byte[] data = new byte[header];

		for (int i = 1; i <= data.length; i++) {
			data[i-1] = segment[i];
		}

		return new Message(data);
	}

}
