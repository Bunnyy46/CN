package cnlab;
import java.util.Scanner;

public class five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int n = sc.nextInt();

        int[][] net = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                net[i][j] = sc.nextInt();

        boolean[] vis = new boolean[n];
        vis[0] = true; // Start from vertex 0
        int cost = 0;

        System.out.println("\nEdges in the Minimum Spanning Tree:");
        for (int e = 0; e < n - 1; e++) {
            int min = 999, a = -1, b = -1;

            for (int i = 0; i < n; i++) {
                if (vis[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!vis[j] && net[i][j] != 0 && net[i][j] < min) {
                            min = net[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }

            System.out.println(a + " - " + b + " : " + min);
            vis[b] = true;
            cost += min;
        }

        System.out.println("\nTotal cost of Minimum Spanning Tree: " + cost);
    }
}
