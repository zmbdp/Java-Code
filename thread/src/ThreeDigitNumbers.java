import java.util.Scanner;

public class ThreeDigitNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.close();

        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                for (int k = 100; k <= 999; k++) {
                    if (isValid(i, j, k) && satisfiesRatio(i, j, k, A, B, C)) {
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }

    private static boolean isValid(int a, int b, int c) {
        int[] digits = new int[9];
        return !hasDuplicate(a, digits) && !hasDuplicate(b, digits) && !hasDuplicate(c, digits);
    }

    private static boolean hasDuplicate(int number, int[] digits) {
        while (number > 0) {
            int digit = number % 10;
            if (digits[digit]++ == 1) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    private static boolean satisfiesRatio(int a, int b, int c, int A, int B, int C) {
        return a * B * C == b * A * C && b * A * C == c * A * B;
    }
}