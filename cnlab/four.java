package cnlab;
import java.util.*;
public class four {
    public static void Main (String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of vertices:");
        int n=sc.nextInt();
        int[][]g=new int [n][n];
        System.out.println("Enter the Adjacency Matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                g[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the starting vertex");
        int s=sc.nextInt();

        int [] d=new int[n];
        boolean[] vis=new boolean[n];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[s]=0;

        for(int i=0;i<n-1;i++){
            int u=-1;
         for(int j=0;j<n;j++){
            if(!vis[j] && (u==-1 || d[j]<d[u])){
                u=j;
            }
         }
            vis[u]=true;
            for(int v=0;v<n;v++){
                if(g[u][v]!=0 && d[u]+g[u][v]<d[v]){
                    d[v]=d[u]+g[u][v];
                }
            }
         }

        System.out.println("\nShortest Distance from Source");
        for(int i=0;i<n;i++){
            System.out.println(s+" -> "+i+" = "+d[i]);
        }
    }
}



