package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCClientStopStub;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.system.display.DisplayDevice;
import no.hvl.dat110.system.display.DisplayImpl;
import no.hvl.dat110.system.sensor.SensorImpl;

import java.io.IOException;

/**
 * Hoved kontroller for programmet
 */
public class Controller {

	private static int N = 5;

	/**
	 *
	 * @param args
	 */
	/*
	Controller.java - here you have to complete the implementation
	of the controller (client) such that it connects to the sensor
	and display RPC servers and implement a finite loop in which
	the temperature is retrieved from the sensor (using the read method)
	and shown on the display (using the write method).
	 */
	public static void main(String[] args) {

		DisplayStub display;
		SensorStub sensor;

		RPCClient displayclient, sensorclient;

		System.out.println("Controller starting ...");

		// create RPC clients for the system
		displayclient = new RPCClient(Common.DISPLAYHOST, Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST, Common.SENSORPORT);

		// setup stop methods in the RPC middleware
		RPCClientStopStub stopdisplay = new RPCClientStopStub(displayclient);
		RPCClientStopStub stopsensor = new RPCClientStopStub(sensorclient);

		// TODO - START

		// create local display and sensor stub objects
		display = new DisplayStub(displayclient);
		sensor = new SensorStub(sensorclient);

		// connect to sensor and display RPC servers - using the RPCClients
        try {
            displayclient.connect();
			sensorclient.connect();
		} catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read value from sensor using RPC and write to display using RPC
		String temperatur = Integer.toString(sensor.read());
		display.write(temperatur);

		// TODO - END

		stopdisplay.stop();
		stopsensor.stop();

		displayclient.disconnect();
		sensorclient.disconnect();

		System.out.println("Controller stopping ...");

	}
}
