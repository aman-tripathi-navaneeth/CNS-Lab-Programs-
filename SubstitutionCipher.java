import java.io.*;
import java.util.*;

public class SubstitutionCipher{
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // Define the alphabet and substitution
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";

        // Input from the user
        System.out.print("Enter any string: ");
        String str = br.readLine().toLowerCase();  // Convert to lowercase

        StringBuilder decrypt = new StringBuilder();
        char c;

        // Encryption loop
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            int j = a.indexOf(c);

            if (j != -1) {
                decrypt.append(b.charAt(j));  // Substitute if it's a letter
            } else {
                decrypt.append(c);  // Append as is if not a letter
            }
        }

        // Output the encrypted data
        System.out.println("The encrypted data is: " + decrypt);
    }
}

// output:-
// input string :- aeiou
// output:- zxvsl
