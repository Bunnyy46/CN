import java.util.*;

public class DistanceVectorRouting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];

        System.out.println("Enter adjacency matrix (use 999 for infinity):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        // Initialize distance vectors
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = cost[i][j];

        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            updated = true;
                        }
                    }
                }
            }
        } while (updated); // Repeat until no change (convergence)

        // Print routing tables
        System.out.println("\nRouting tables (distance vector at each node):");
        for (int i = 0; i < n; i++) {
            System.out.println("From Node " + i + ":");
            for (int j = 0; j < n; j++)
                System.out.print(dist[i][j] + " ");
            System.out.println();
        }
    }
}
