package no.hvl.dat110.rpc;


/**
 * RPC server-side method implementations must extend this class
 */
public abstract class RPCRemoteImpl {

	/**
	 *
	 * @param rpcid
	 * @param rpcserver
	 */
	public RPCRemoteImpl(byte rpcid, RPCServer rpcserver) {
		rpcserver.register(rpcid, this);
	}

	/**
	 * method that will be invoked by the server
	 *
	 * @param params marshalled parameter for the method
	 * @return marshalled return value
	 */
	public abstract byte[] invoke(byte[] params);

}
