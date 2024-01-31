package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

/**
 *
 */
public class DisplayStub extends RPCLocalStub {

	/**
	 *
	 * @param rpcclient
	 */
	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}

	/**
	 *
	 * @param message
	 */
	public void write(String message) {
		// implement marshalling, call and unmarshalling for write RPC method

		// Marshall string
		byte[] request = RPCUtils.marshallString(message);

		// call for å skrive, bruker WRITE_RPCID for å sende hvilke metode som skal brukes
		byte[] response = rpcclient.call((byte)Common.WRITE_RPCID, request);

		// Unmarshall responsen
		RPCUtils.unmarshallString(response);
	}
}
