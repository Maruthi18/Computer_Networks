package LeackyBucket;

import java.util.Scanner;
import java.lang.*;

public class LeackyBucket {
	public static void main (String[] args) {
		// i = Clock
		int i;
		int a[] = new int[ 20 ];
		int bucket_remaining = 0, bucket_capacity = 4, rate = 3, sent, received;
		Scanner in = new Scanner( System.in );
		System.out.println( "Enter the number of packets" );

		// n = number of packets
		int n = in.nextInt();
		System.out.println( "Enter the Packets" );

		// if i = 1 means we are storing a[i] value
		for ( i = 1; i <= n; i++ )
			a[ i ] = in.nextInt();

		System.out.println( "Clock \t Packet Size \t  Accept \t   Sent \t  Remaining" );
		for ( i = 1; i <= n; i++ ) {
			if ( a[ i ] != 0 ) {
				if ( bucket_remaining + a[ i ] > bucket_capacity ) {
					received = -1;
				}
				else {
					received = a[ i ];
					bucket_remaining += a[ i ];
				}
			}
			else {
				received = 0;
			}

			// Iter1 if 5 < 3 no so br = br - rate [ 5 = 5 - 3 ] = 2 br = 2
			// Iter2 br = 2 br send to sent and br set to ZERO
			if ( bucket_remaining != 0 ) {
				if ( bucket_remaining < rate ) {
					sent = bucket_remaining;
					bucket_remaining = 0;
				}
				else {
					sent = rate;
					bucket_remaining = bucket_remaining - rate;
				}
			}
			else {
				sent = 0;
			}
			if ( received == -1 ) {
				System.out.println( " "+i + "\t\t" + "\t" + a[ i ] + "  \t\t\t Dropped \t\t"  + sent + "\t\t\t" + bucket_remaining );
			}
			else {
				System.out.println( " "+i + "\t\t\t" + a[ i ] + "\t\t\t\t" + received + "\t\t" + "\t" + sent + "\t\t\t"  + bucket_remaining );
			}
		}
	}
}
