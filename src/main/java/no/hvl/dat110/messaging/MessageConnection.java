package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;

/**
 *
 */
public class MessageConnection {

    /**
     * for writing bytes to the underlying TCP connection
     */
    private DataOutputStream outStream;
    /**
     * for reading bytes from the underlying TCP connection
     */
    private DataInputStream inStream;
    /**
     * socket for the underlying TCP connection
     */
    private Socket socket;

    /**
     * @param socket
     */
    public MessageConnection(Socket socket) {

        try {

            this.socket = socket;

            outStream = new DataOutputStream(socket.getOutputStream());

            inStream = new DataInputStream(socket.getInputStream());

        } catch (IOException ex) {

            System.out.println("Connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * encapsulate the data contained in the Message and write to the output stream
     *
     * @param message The message to be sent to the output stream
     */
    public void send(Message message) throws IOException {
        // encapsulate the data contained in the Message and write to the output stream

        byte[] data = MessageUtils.encapsulate(message);

        outStream.write(data);
    }

    /**
     * read a segment from the input stream and decapsulate data into a Message
     *
     * @return the resulting Message
     */
    public Message receive() throws IOException {
        // encapsulate the data contained in the Message and write to the output stream

        byte[] data = new byte[128];
        inStream.readFully(data);

        return MessageUtils.decapsulate(data);
    }

    /**
     * close the connection by closing streams and the underlying socket
     */
    public void close() {

        try {

            outStream.close();
            inStream.close();

            socket.close();

        } catch (IOException ex) {

            System.out.println("Connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
