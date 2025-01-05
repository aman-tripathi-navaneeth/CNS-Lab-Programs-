import java.io.*;
import java.util.*;

public class HillCipher {

    static float[][] decrypt = new float[3][1];
    static float[][] a = new float[3][3];
    static float[][] b = new float[3][3];
    static float[][] mes = new float[3][1];
    static float[][] res = new float[3][1];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        getKeyAndMessage();

        // Encryption
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                res[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    res[i][j] += a[i][k] * mes[k][j];
                }
            }
        }

        System.out.print("\nEncrypted string is: ");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) (res[i][0] % 26 + 97));
        }

        // Inverse Matrix Calculation
        inverseMatrix();

        // Decryption
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                decrypt[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    decrypt[i][j] += b[i][k] * res[k][j];
                }
            }
        }

        System.out.print("\nDecrypted string is: ");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) (decrypt[i][0] % 26 + 97));
        }
        System.out.print("\n");
    }

    public static void getKeyAndMessage() throws IOException {
        System.out.println("Enter 3x3 matrix for key (It should be invertible): ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextFloat();
            }
        }

        System.out.print("\nEnter a 3-letter string: ");
        String msg = br.readLine();
        for (int i = 0; i < 3; i++) {
            mes[i][0] = msg.charAt(i) - 97;
        }
    }

    public static void inverseMatrix() {
        float p, q;
        float[][] c = new float[3][3];

        // Copy original matrix
        for (int i = 0; i < 3; i++) {
            System.arraycopy(a[i], 0, c[i], 0, 3);
        }

        // Initialize the identity matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = 0;
                }
            }
        }

        // Perform Gaussian elimination
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    p = c[i][k];
                    q = c[k][k];
                    for (int j = 0; j < 3; j++) {
                        c[i][j] = c[i][j] * q - p * c[k][j];
                        b[i][j] = b[i][j] * q - p * b[k][j];
                    }
                }
            }
        }

        // Normalize diagonal elements
        for (int i = 0; i < 3; i++) {
            float diag = c[i][i];
            for (int j = 0; j < 3; j++) {
                b[i][j] = b[i][j] / diag;
            }
        }

        // Print the inverse matrix
        System.out.println("\nInverse Matrix is: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
//  output:-

//  --> first  Enter 3x3 matrix for key (It should be invertible):
// 2 4 5
// 9 2 1
// 3 17 7

// Enter a 3-letter string: abc
 
