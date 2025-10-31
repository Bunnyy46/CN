package cnlab;



import java.util.*;

public class seven {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");

        String data = sc.nextLine();

        System.out.print("Enter a single character key: ");

        char key = sc.next().charAt(0);

        String encrypted = "", decrypted = "";

        // Encrypt

        for (int i = 0; i < data.length(); i++)

            encrypted += (char)(data.charAt(i) ^ key);

        // Decrypt

        for (int i = 0; i < encrypted.length(); i++)

            decrypted += (char)(encrypted.charAt(i) ^ key);

        System.out.println("\nOriginal  : " + data);

        System.out.println("Encrypted : " + encrypted);

        System.out.println("Decrypted : " + decrypted);

    }

}

