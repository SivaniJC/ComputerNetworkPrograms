import java.net.*;
import java.io.*; 

public class UDPClient {
	public static void main(String[] args) throws Exception
	{
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the IP address of the Stream:");
		String saddr = inFromUser.readLine();
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName(saddr);
		
		byte[] receiveData;
		byte[] sendData = new byte[200];
		String sentence = "Hello";
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,9876);
		clientSocket.send(sendPacket);
		
		while(true)
		{
			receiveData = new byte[200];
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			clientSocket.receive(receivePacket);
			String incomingData = new String(receivePacket.getData()); 		// getData() method returns the data buffer which is used to receive or send data
			InetAddress SAddress = receivePacket.getAddress();				//Returns the raw IP address of this InetAddress object.
			System.out.println("From Server" + "(" + SAddress.toString()+")"+incomingData);
		}	
	}
}
