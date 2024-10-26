package FileEncryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Encryption");
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the encryption key: ");
        int key = scanner.nextInt();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("The specified file does not exist.");
            return;
        }

        System.out.print("Do you want to (1.) Encrypt or (2.) Decrypt the file? Enter your choice : ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            try {
                encryptFile(file, key);
                System.out.println("File encrypted successfully.");
            } catch (IOException e) {
                System.out.println("Error encrypting the file: " + e.getMessage());
            }
        } else if (choice == 2) {
            try {
                decryptFile(file, key);
                System.out.println("File decrypted successfully.");
            } catch (IOException e) {
                System.out.println("Error decrypting the file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private static void encryptFile(File file, int key) throws IOException {
        processFile(file, key, "encrypted_" + file.getName());
    }

    private static void decryptFile(File file, int key) throws IOException {
        processFile(file, key, "decrypted_" + file.getName());
    }

    private static void processFile(File file, int key, String outputFileName) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(outputFileName);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ key);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}
