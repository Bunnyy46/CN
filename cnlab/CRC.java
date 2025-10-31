import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Data bits: ");
        String data = sc.next();
        System.out.print("Generator: ");
        String gen = sc.next();

        String rem = computeCRC(data, gen);
        String codeword = data + rem;
        System.out.println("Transmitted Codeword: " + codeword);

        System.out.print("Received codeword: ");
        String recv = sc.next();
        System.out.println(computeCRC(recv, gen).contains("1") ? "Error detected!" : "No error detected!");
    }

    static String computeCRC(String data, String gen) {
        int n = gen.length();
        StringBuilder dividend = new StringBuilder(data).append("0".repeat(n - 1));
        char[] genArr = gen.toCharArray();

        for (int i = 0; i <= dividend.length() - n; i++) {
            if (dividend.charAt(i) == '1') {
                for (int j = 0; j < n; j++)
                    dividend.setCharAt(i + j, dividend.charAt(i + j) == genArr[j] ? '0' : '1');
            }
        }
        return dividend.substring(dividend.length() - n + 1);
    }
}


