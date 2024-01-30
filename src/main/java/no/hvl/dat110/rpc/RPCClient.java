package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

import java.io.IOException;

/**
 *
 */
public class RPCClient {

	/**
	 * underlying messaging client used for RPC communication
	 */
	private MessagingClient msgclient;

	/**
	 * underlying messaging connection used for RPC communication
	 */
	private MessageConnection connection;

	/**
	 *
	 * @param server
	 * @param port
	 */
	public RPCClient(String server, int port) {

		msgclient = new MessagingClient(server, port);
	}

	/**
	 * connect using the RPC client
	 */
	public void connect()
	throws IOException {

		connection =  msgclient.connect();
	}

	/**
	 * disconnect by closing the underlying messaging connection
	 */
	public void disconnect() {

		connection.close();
	}

	/**
	 * Make a remote call om the method on the RPC server by sending an RPC request message and receive an RPC reply message
	 *
	 * @param rpcid rpcid is the identifier on the server side of the method to be called
	 * @param param param is the marshalled parameter of the method to be called
	 * @return The RPC reply message as a byte array segment
	 */
	public byte[] call(byte rpcid, byte[] param) {

		/*

		The rpcid and param must be encapsulated according to the RPC message format

		The return value from the RPC call must be decapsulated according to the RPC message format

		*/

		byte[] encapsulated = RPCUtils.encapsulate(rpcid, param);

		Message resp;

		try {
			connection.send(new Message(encapsulated));
			resp = connection.receive();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return RPCUtils.decapsulate(resp.getData());
	}

}
