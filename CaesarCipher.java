// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class CaesarCipher {
   public CaesarCipher() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("Enter any string: ");
      String var2 = var1.nextLine();
      System.out.print("Enter the key: ");
      int var3 = var1.nextInt();
      String var4 = encrypt(var2, var3);
      System.out.println("\nEncrypted String is: " + var4);
      String var5 = decrypt(var4, var3);
      System.out.println("Decrypted String is: " + var5);
      var1.close();
   }

   public static String encrypt(String var0, int var1) {
      StringBuilder var2 = new StringBuilder();
      var1 %= 26;

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         char var4 = var0.charAt(var3);
         if (Character.isUpperCase(var4)) {
            var4 = (char)((var4 + var1 - 65) % 26 + 65);
         } else if (Character.isLowerCase(var4)) {
            var4 = (char)((var4 + var1 - 97) % 26 + 97);
         } else {
            var4 = var0.charAt(var3);
         }

         var2.append(var4);
      }

      return var2.toString();
   }

   public static String decrypt(String var0, int var1) {
      return encrypt(var0, -var1);
   }
}
