package cnlab;

import java.util.*;

public class CRC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Data bits: "); 

        String data = sc.next();

        System.out.print("Generator: "); 

        String gen = sc.next();

        String codeword = data + computeCRC(data, gen);

        System.out.println("Transmitted Codeword: " + codeword);

        System.out.print("Received codeword: "); 

        String recv = sc.next();

        System.out.println(computeCRC(recv, gen).contains("1") ? "Error detected!" : "No error detected!");

    }

    static String computeCRC(String data, String gen) {

        int n = gen.length();

        String tmp = data + "0".repeat(n - 1);

        String div = tmp.substring(0, n);

        for (int i = n; i <= tmp.length(); i++, div = div.substring(1)) {

            if (div.charAt(0) == '1' && i < tmp.length()) div += tmp.charAt(i);

            div = xor(div, gen);

        }

        return div.substring(div.length() - n + 1);

    }

    static String xor(String a, String b) {

        StringBuilder res = new StringBuilder();

        for (int i = 1; i < b.length(); i++)

            res.append(a.charAt(i) == b.charAt(i) ? '0' : '1');

        return res.toString();

    }

}

