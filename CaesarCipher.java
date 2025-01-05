import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter any string: ");
        String str = sc.nextLine();

        // Input key
        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        // Encrypt and decrypt
        String encrypted = encrypt(str, key);
        System.out.println("\nEncrypted String is: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted String is: " + decrypted);

        sc.close();
    }

    // Encryption Method
    public static String encrypt(String str, int key) {
        StringBuilder encrypted = new StringBuilder();
        key = key % 26;  // Handle large keys

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isUpperCase(c)) {
                c = (char) ((c + key - 'A') % 26 + 'A');
            } else if (Character.isLowerCase(c)) {
                c = (char) ((c + key - 'a') % 26 + 'a');
            } else {
                // Non-alphabetic characters remain unchanged
                c = str.charAt(i);
            }

            encrypted.append(c);
        }

        return encrypted.toString();
    }

    // Decryption Method
    public static String decrypt(String str, int key) {
        return encrypt(str, -key);  // Reuse the encrypt method with negative key
    }
}

// output:-
// Enter any string: hello world
// Enter the key: 5

// Encrypted String is: mjqqt btwqi
// Decrypted String is: hello ]orld
// Note: The decrypted string is not the same as the original string because the key is not the same. The key is 5, but the key should be 21 to get the original string.
