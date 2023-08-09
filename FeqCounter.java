package JavaPgms.Sorting;

import java.util.Scanner;

public class FeqCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = scanner.nextLine();
        countFrequency(inputStr);
    }

    public static void countFrequency(String inputStr) {
        for (int i = 0; i < inputStr.length(); i++) {
            int count = 0;
            for (int j = i; j < inputStr.length(); j++) {
                if (inputStr.charAt(i) == inputStr.charAt(j)) {
                    count++;
                }
            }
            // Check if this character is already counted
            boolean alreadyCounted = false;
            for (int k = 0; k < i; k++) {
                if (inputStr.charAt(k) == inputStr.charAt(i)) {
                    alreadyCounted = true;
                    break;
                }
            }
            if (!alreadyCounted) {
                System.out.println("'" + inputStr.charAt(i) + "' occurs " + count + " times");
            }
        }
    }
}

