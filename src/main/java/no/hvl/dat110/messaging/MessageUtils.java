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

		byte[] segment = null;
		byte[] data;

		// TODO - START

		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END
		return segment;

	}

	/**
	 * decapsulate segment and put received payload data into a message
	 *
	 * @param segment A byte array segment
	 * @return The message
	 */
	public static Message decapsulate(byte[] segment) {

		Message message = null;

		// TODO - START
		// decapsulate segment and put received payload data into a message

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return message;

	}

}
