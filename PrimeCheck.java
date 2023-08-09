package JavaPgms.Sorting;

import java.util.Scanner;

public class PrimeCheck {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the starting number n: ");
        int n = sc.nextInt();

        System.out.print("Enter the ending number m: ");
        int m = sc.nextInt();

        System.out.println("Prime numbers between " + n + " and " + m + " are:");
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}

