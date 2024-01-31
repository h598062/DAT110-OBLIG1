package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCRemoteImpl;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.rpc.RPCServer;

/**
 *
 */
public class DisplayImpl extends RPCRemoteImpl {

	/**
	 *
	 * @param rpcid
	 * @param rpcserver
	 */
	public DisplayImpl(byte rpcid, RPCServer rpcserver) {
		super(rpcid, rpcserver);
	}

	/**
	 *
	 * @param message
	 */
	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}

	/**
	 *
	 * @param param marshalled parameter for the method
	 * @return
	 */
	public byte[] invoke(byte[] param) {

		byte[] returnval = null;

		// TODO - START: 
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done in the SensorImpl class for the read method


		// TODO - END

		return returnval;
	}
}
