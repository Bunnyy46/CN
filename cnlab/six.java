package cnlab;
import java.util.Scanner;
public class six {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter no of nodes");
        int n=sc.nextInt();
        int[][] cost=new int[n][n];
        System.out.println("Enter Adjacency matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j]=sc.nextInt();
            }
        }
       int [][] dist=new int[n][n];
       for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=cost[i][j];
            }
        }
        for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i][k]+dist[k][j]<dist[i][j]){
                    dist[i][j]=dist[i][k]+dist[k][j];
                }
            }
        }
    }
     System.out.print("Routing table");
      for(int i=0;i<n;i++){
        System.out.println("From node "+i+" :");
        for(int j=0;j<n;j++){
            System.out.println(dist[i][j]+" ");
        }
        System.out.println();
      }
    }
}



