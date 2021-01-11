package UDP_SOCKET;

import java.net.*;
import java.net.InetAddress;


// Udp : No Connection b/w Client and server

class UDPS {
	public static void main (String args[]) throws Exception {

		// here we creating a socket for server side
		DatagramSocket serverSocket = new DatagramSocket ( 9876 );

		byte[] receiveData = new byte[ 1024 ];
		byte[] sendData = new byte[ 1024 ];

		while (true) {
			System.out.println ( "Server is Up" );

			DatagramPacket receivePacket = new DatagramPacket ( receiveData, receiveData.length );

			serverSocket.receive ( receivePacket );

			// after receiving a packet stores in sentence Variable
			String sentence = new String ( receivePacket.getData () );

			// we are printing what we got from the client side.
			System.out.println ( "RECEIVED:" + sentence );

			InetAddress IPAddress = receivePacket.getAddress ();

			int port = receivePacket.getPort ();

			// here we are converting into upperCase..
			String capitalizedSentence = sentence.toUpperCase ();

			// we are storing in a byte array
			sendData = capitalizedSentence.getBytes ();

			DatagramPacket sendPacket = new
					DatagramPacket ( sendData, sendData.length, IPAddress, port );


			serverSocket.send ( sendPacket );
		}
	}
}
