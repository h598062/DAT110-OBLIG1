package no.hvl.dat110.messaging;

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
		if (data == null || data.length < 1) {
			throw new NullPointerException("Data must have a value, cannot be null");
		}
		if (data.length > 127) {
			throw new IllegalArgumentException("Data has to be less than 127 bytes");
		}
		this.data = data;
	}

	/**
	 * Getter for the data in a Message
	 * @return The data in this Message, as a byte array
	 */
	public byte[] getData() {
		return this.data;
	}

}
