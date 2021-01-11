package UDP_SOCKET;

import java.io.*;
import java.net.*;
import java.net.InetAddress;


// Socket Is just like a DOOR
// Port is a Communication end point

// Socket : program need to connect local or wan , it uses a component called SOCKET..
// it allowing the data to be read and write over the network

// Packet : if is fixedSize of Unit Data

class UDPC {
	public static void main (String[] args) throws Exception {

		// BufferReader : it reads text from input stream
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader( System.in ) );

		// This is udp programme so we are creating a datagram socket
		DatagramSocket clientSocket = new DatagramSocket();

		// Here Our computer is managing both client and server , So our Computer ip Address stored in IPAddress Variable
		InetAddress IPAddress = InetAddress.getByName( "localhost" );

		byte[] sendData = new byte[ 1024 ];
		byte[] receiveData = new byte[ 1024 ];

		System.out.println( "Enter the sting to be converted in to Upper case" );

		// readLine() : Read a single line of text from the console
		String sentence = inFromUser.readLine();

		sendData = sentence.getBytes();

		// here we create a packet
		DatagramPacket sendPacket = new
				DatagramPacket( sendData, sendData.length, IPAddress, 9876 );

		// here we sending a packet
		clientSocket.send( sendPacket );

		// after server will convert and send it back to me , we need one more packet to receive , we created a receive packet
		DatagramPacket receivePacket = new DatagramPacket( receiveData, receiveData.length );

		// here we receiving the data from the server
		clientSocket.receive( receivePacket );

		// Here we extracted the data from the packet and storing in modifiedSentence
		String modifiedSentence = new String( receivePacket.getData() );

		System.out.println( "FROM SERVER:" + modifiedSentence );

		clientSocket.close();
	}
}
