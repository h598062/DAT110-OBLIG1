package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

/**
 *
 */
public class Message {

	/**
	 * the up to 127 bytes of data (payload) that a message can hold
	 */
	private byte[] data;

	/**
	 * construction a Message with the data provided
	 * @param data the data to be added in the message
	 */
	public Message(byte[] data) {

		// TODO - START

		if (true)
			throw new UnsupportedOperationException(TODO.constructor("Message"));

		// TODO - END
	}

	/**
	 * Getter for the data in a Message
	 * @return The data in this Message, as a byte array
	 */
	public byte[] getData() {
		return this.data;
	}

}
