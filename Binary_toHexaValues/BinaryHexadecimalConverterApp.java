package Binary_toHexaValues;

import java.util.Scanner;

public class BinaryHexadecimalConverterApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Binary Hexadecimal Converter App");
        System.out.println("\nConvert Your decimals to binary and hexadecimals.");

        System.out.print("Enter a number: ");
        int inputMaxValue = scanner.nextInt();

        int[] decimals = new int[inputMaxValue];
        String[] binaryValues = new String[inputMaxValue];
        String[] hexadecimalValues = new String[inputMaxValue];

        for (int i = 0; i < inputMaxValue; i++) {
            int num = i + 1;
            decimals[i] = num;
            binaryValues[i] = Integer.toBinaryString(num);
            hexadecimalValues[i] = Integer.toHexString(num);
        }

        System.out.println("Processing the conversions.. .");
        System.out.println("First, we will show you a slice of the numbers\n");

        System.out.print("Please enter a starting number: ");
        int lower = scanner.nextInt();

        System.out.print("Please enter an ending number: ");
        int higher = scanner.nextInt();

        System.out.println("\nA sample of Binary Values");
        for (int i = lower; i < higher; i++) {
            System.out.println(binaryValues[i]);
        }

        System.out.println("\nA sample of Hexadecimal Values");
        for (int i = lower; i < higher; i++) {
            System.out.println(hexadecimalValues[i]);
        }

        System.out.print("Press enter to view the complete list of values: ");
        scanner.nextLine(); // consume the leftover newline
        scanner.nextLine(); // wait for enter key

        System.out.println("Decimals - - Binary - -  Hexadecimals");
        for (int i = 0; i < inputMaxValue; i++) {
            System.out.printf("%d   %s    %s%n", decimals[i], binaryValues[i], hexadecimalValues[i]);
        }

        System.out.println("\nThank you!");
        scanner.close();
    }
}
