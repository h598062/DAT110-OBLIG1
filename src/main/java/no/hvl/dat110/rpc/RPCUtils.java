package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

/**
 *
 */
public class RPCUtils {

	/**
	 * @param rpcid - ID til metode som skal kjøre ved hjelp av RPC
	 * @param payload - Byte[] med data
	 * @return
	 */
	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = new  byte[payload.length + 1];
		rpcmsg[0] = rpcid;

        for (int i = 1; i < rpcmsg.length; i++) {
            rpcmsg[i] = payload[i - 1];
        }
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format

		return rpcmsg;
	}

	/**
	 * @param rpcmsg
	 * @return
	 */
	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] payload = null;

		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax


		return payload;

	}

	/**
	 * convert String to byte array
	 *
	 * @param str Stringen som skal marshalles
	 * @return En marshalled byte array representasjon av den gitte Stringen
	 */
	public static byte[] marshallString(String str) {

		byte[] encoded = null;

		// TODO - START

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return encoded;
	}

	/**
	 * convert byte array to a String
	 *
	 * @param data En marshalled byte array representasjon av en String
	 * @return Stringen som er lagret i den oppgitte byte arrayen
	 */
	public static String unmarshallString(byte[] data) {

		String decoded = null;

		// TODO - START 

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return decoded;
	}

	/**
	 * @return
	 */
	public static byte[] marshallVoid() {

		byte[] encoded = null;

		// TODO - START 

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return encoded;

	}

	/**
	 * @param data
	 */
	public static void unmarshallVoid(byte[] data) {

		// TODO

		if (true)
			throw new UnsupportedOperationException(TODO.method());

	}

	/**
	 * convert boolean to a byte array representation
	 *
	 * @param b Boolean som skal marshalles
	 * @return En marshalled byte array representasjon av den gitte boolean
	 */
	public static byte[] marshallBoolean(boolean b) {

		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else {
			encoded[0] = 0;
		}

		return encoded;
	}

	/**
	 * convert byte array to a boolean representation
	 *
	 * @param data En marshalled byte array representasjon av en boolean
	 * @return Boolean som er lagret i den oppgitte byte arrayen
	 */
	public static boolean unmarshallBoolean(byte[] data) {

		return (data[0] > 0);

	}

	/**
	 * integer to byte array representation
	 *
	 * @param x Integer som skal marshalles
	 * @return En marshalled byte array representasjon av den gitte integeren
	 */
	public static byte[] marshallInteger(int x) {
		byte[] encoded = new byte[4];
		ByteBuffer b = ByteBuffer.wrap(encoded);
		b.putInt(x);
		return b.array();
	}

	/**
	 * byte array representation to integer
	 *
	 * @param data En marshalled byte array representasjon av en integer
	 * @return Integeren som er lagret i den oppgitte byte arrayen
	 */
	public static int unmarshallInteger(byte[] data) {
		ByteBuffer b = ByteBuffer.wrap(data);
		return b.getInt();
	}
}
