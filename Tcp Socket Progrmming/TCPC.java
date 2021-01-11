import java.net.*;
import java.io.*;

@SuppressWarnings("ALL")
public class TCPC {
    public static void main (String[] args) throws Exception {

        // Creating a Socket with IP Address And Port Number
        Socket sock = new Socket ("127.0.01", 4000);

        System.out.println ("Enter the filename");

        // here file sent to server , server will do search for the file and it will send content of the file , SERVER will sent me a content of the file
        // Java BufferedReader class is used to read the text from a character-based input stream.
        BufferedReader keyRead = new BufferedReader (new InputStreamReader (System.in));

        // Buffer Reader file stores in fname variable
        String fname = keyRead.readLine ();

        // Java FileOutputStream is an output stream used for writing data to a file.
        // character-oriented data, it is preferred to use FileWriter than FileOutputStream.
        OutputStream ostream = sock.getOutputStream ();

        // Print Writer  is used to print the formatted representation of objects to the text-output stream.
        PrintWriter pwrite = new PrintWriter (ostream, true);


        pwrite.println (fname);

        // Reading Socket input Ports
        InputStream istream = sock.getInputStream ();

        BufferedReader socketRead = new BufferedReader (new InputStreamReader (istream));

        String str;
        while ((str = socketRead.readLine ()) != null) {
            System.out.println (str);
        }

        pwrite.close ();
        socketRead.close ();
        keyRead.close ();
    }
}