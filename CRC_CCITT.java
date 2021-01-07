import java.util.Scanner;
import java.util.*;



// length = Size of an array
// length = Number of character in a string

public class CRC_CCITT {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // ----------- INPUT DATA ---------

        System.out.print(" Enter The Message Bits : ");
        String message = s.nextLine();
        System.out.print(" Enter Generator : ");
        String generator = s.nextLine();

        int data[] = new int[message.length() + generator.length() - 1];
        int divisor[] = new int[generator.length()];

        for (int i=0; i<message.length(); i++) {
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }

        for (int i=0; i<generator.length(); i++) {
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");

        }

        // ----- CALCULATION OF CRC -----------

        for (int i=0; i<message.length();i++) {
            if(data[i] == 1){
                for (int j=0; j<divisor.length; j++) {
                    data[ i+j ] ^= divisor[ j ];          // here the result stored back to data only .....

                }
            }
        }

        // ------- DISPLAY CRC ---------------

        System.out.print(" The Checksum Code : ");
        for (int i=0; i<message.length(); i++) {
            data[i] = Integer.parseInt(message.charAt(i) + "");   // This is Remainder of the Sender Side
        }
        for (int i=0; i< data.length; i++){
            System.out.print( data[i] );
        }
        System.out.println();

        // ---------- CHECK FOR INPUT CRC CODE -------------

        System.out.print(" Enter The Checksum code : ");
            message = s.nextLine();
        System.out.print(" Enter Generator : ");
            generator = s.nextLine();

         data = new int[message.length() + generator.length() - 1];
         divisor = new int[generator.length()];

        for (int i=0; i<message.length(); i++) {
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }

        for (int i=0; i<generator.length(); i++) {
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");
        }

        // -------- CALCULATION OF REMAINDER -----------

        for (int i=0; i<message.length();i++) {
            if(data[i] == 1){
                for (int j=0; j<divisor.length; j++) {
                    data[ i+j] ^= divisor[j];

                }
            }
        }

        // --------- DISPLAY VALIDITY OF DATA -------------

        boolean valid = true;
        for (int i = 0; i < data.length; i++) {
            if ( data[i] == 1 ) {
                valid = false;
                break;
            }
        }

        if ( valid == true ) {
            System.out.println(" VALID ");
        }
        else {
            System.out.println(" CRC ERROR OCCURS ");
        }
    }
}
