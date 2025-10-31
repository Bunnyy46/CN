package cnlab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bucket = 10; // Max bucket capacity
        int rate = 3;    // Leakage/output rate
        int store = 0;   // Current stored data

        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();
        int[] pkt = new int[n];

        System.out.println("Enter packet sizes:");
        for (int i = 0; i < n; i++) pkt[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int p = pkt[i];
            System.out.println("\nIncoming packet size: " + p);

            if (p + store > bucket)
                System.out.println("Overflow! Packet dropped.");
            else {
                store += p;
                System.out.println("Packet accepted.");
            }

            System.out.println("Data in bucket before leak: " + store);
            store = Math.max(0, store - rate);
            System.out.println("Data in bucket after leak: " + store);
        }

        sc.close();
    }
}
