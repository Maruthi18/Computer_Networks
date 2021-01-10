

import java.util.Scanner;
import java.util.*;


@SuppressWarnings("WrongPackageStatement")
public class ford {

    private int D[];

    private int number_of_Vertices;

    public static final int MAX_VALUE = 999;

    public ford (int number_of_Vertices) {

        this.number_of_Vertices = number_of_Vertices;

        D = new int[ number_of_Vertices + 1 ];

    }


    public void BellmanFordEvaluation (int source, int A[][]) {

        for (int node = 1; node <= number_of_Vertices; node++) {

            D[ node ] = MAX_VALUE;

        }


        D[ source ] = 0;


        for (int node = 1; node <= number_of_Vertices - 1; node++) {

            for (int source_node = 1; source_node <= number_of_Vertices; source_node++) {

                for (int destination_node = 1; destination_node <= number_of_Vertices; destination_node++) {

                    if ( A[ source_node ][ destination_node ] != MAX_VALUE ) {

                        if ( D[ destination_node ] > D[ source_node ] + A[ source_node ][ destination_node ] ) {
                            D[ destination_node ] = D[ source_node ] + A[ source_node ][ destination_node ];
                        }

                    }

                }

            }

        }


        for (int source_node = 1; source_node <= number_of_Vertices; source_node++) {

            for (int destination_node = 1; destination_node <= number_of_Vertices; destination_node++) {

                if ( A[ source_node ][ destination_node ] != MAX_VALUE ) {

                    if ( D[ destination_node ] > D[ source_node ] + A[ source_node ][ destination_node ] ) {
                        System.out.println("The Graph Contains Negative Edge Cycle");
                    }
                }

            }

        }


        for (int vertex = 1; vertex <= number_of_Vertices; vertex++) {

            System.out.println("Distance Of Source " + source + " to " + vertex + " is " + D[ vertex ]);

        }

    }


    public static void main (String[] args) {

        int number_of_Vertices = 0;

        int source;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices");

        number_of_Vertices = scanner.nextInt();


        int A[][] = new int[ number_of_Vertices + 1 ][ number_of_Vertices + 1 ];

        System.out.println("Enter The Adjacency Matrix");

        for (int source_node = 1; source_node <= number_of_Vertices; source_node++) {

            for (int destination_node = 1; destination_node <= number_of_Vertices; destination_node++) {

                A[ source_node ][ destination_node ] = scanner.nextInt();

                if ( source_node == destination_node ) {

                    A[ source_node ][ destination_node ] = 0;

                    continue;

                }

                if ( A[ source_node ][ destination_node ] == 0 ) {

                    A[ source_node ][ destination_node ] = MAX_VALUE;

                }

            }

        }
        System.out.println();


        System.out.println("Enter The Source Vertex");

        source = scanner.nextInt();

        ford b = new ford(number_of_Vertices);

        b.BellmanFordEvaluation(source, A);

        scanner.close();

    }

}