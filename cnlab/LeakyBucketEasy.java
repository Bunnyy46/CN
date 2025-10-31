package cnlab;

import java.util.*;

public class LeakyBucketEasy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int bucket = 10;   // Maximum bucket capacity

        int rate = 3;      // Leakage (output) rate

        int store = 0;     // Current amount in the bucket

        System.out.print("Enter number of packets: ");

        int n = sc.nextInt();      // Total packets

        int[] pkt = new int[n];    // Array to store packet sizes

        System.out.println("Enter packet sizes:");

        for (int i = 0; i < n; i++) {

            pkt[i] = sc.nextInt(); // Input each packet size

        }

        // Processing each packet

        for (int i = 0; i < n; i++) {

            int p = pkt[i];

            System.out.println("\nIncoming packet size: " + p);

            // Check for overflow

            if (p + store > bucket) {

                System.out.println("⚠️ Overflow! Packet dropped.");

            } else {

                store += p; // Add to bucket if space available

                System.out.println("Packet accepted.");

            }

            System.out.println("Data in bucket before leak: " + store);

            // Leak (send) packets at fixed rate

            store = Math.max(0, store - rate);

            System.out.println("Data in bucket after leak: " + store);

        }

        sc.close();

    }

}

