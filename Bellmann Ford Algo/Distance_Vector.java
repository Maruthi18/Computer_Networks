import java.util.*;
import java.util.Scanner;
import java.io.*;

class Distance_Vector {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dmat[][]; // Cost Matrix = Distance Cost
        int via[][]; // From
        int dist[][]; // Src to Dest
        int n, i = 0, j = 0, k = 0, count = 0;

        System.out.println("Enter Number of Nodes :");
        n = s.nextInt();

        dmat = new int[n][n];
        dist = new int[n][n];
        via = new int[n][n];

        System.out.println("Enter The Cost Matrix : ");
        for (i = 0; i < n; i++) {   // Row Matrix
            for (j = 0; j < n; j++) { // Column Matrix
                dmat[i][j] = s.nextInt(); // Read Cost Matrix
                dmat[i][i] = 0; // initial position = 0
                dist[i][j] = dmat[i][j]; // initial pos from all nodes
                via[i][j] = k; // from node to node intermediate
            }
        }

        do {
            count = 0;
            for (i = 0; i < n; i++) {  // Source node
                for (j = 0; j < n; j++) { // Destination node
                    for (k = 0; k < n; k++) { // Intermediate node
                        if ((dist[i][j]) > (dmat[i][k] + dist[k][j])) { // bellman ford formula
                            dist[i][j] = dist[i][k] + dist[k][j]; // updating the values
                            via[i][j] = k;
                            count++;
                        }
                    }
                }
            }
        } while (count != 0);

        for (i = 0; i < n; i++) {
            System.out.println("State Value of Router " + i + " is");
            for (j = 0; j < n; j++) {
                System.out.println("To " + j + " Via " + via[i][j] + " Distance " + dist[i][j]);
            }
        }
    }
}