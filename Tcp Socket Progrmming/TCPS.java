import java.net.*;
import java.io.*;

@SuppressWarnings("ALL")
public class TCPS {
    public static void main (String[] args) throws Exception {

        // portNumber must be same in client & Server side to contact
        ServerSocket sersock = new ServerSocket(4000);

        System.out.println("Server ready for connection");

        // Every  Single Client Request We Create a One socket for the Client , and create a socket object
        Socket sock = sersock.accept();

        System.out.println("Connection Is successful and waiting for chatting");

        // Here We get a file name , file will get from port
        InputStream istream = sock.getInputStream();

        // Read the file from Socekt Input port
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));

        // Stores the buffer Reader information in a file (fname Variable)
        String fname = fileRead.readLine();

        // Here We are Reading a contents of the file (fname)
        BufferedReader ContentRead = new BufferedReader(new FileReader(fname));

        // Here sending it out to client
        OutputStream ostream = sock.getOutputStream();

        PrintWriter pwrite = new PrintWriter(ostream, true);

        String str;

        while ((str = ContentRead.readLine()) != null) {

            pwrite.println(str);

        }
        sock.close();
        sersock.close();
        pwrite.close();
        fileRead.close();
        ContentRead.close();
    }
}

