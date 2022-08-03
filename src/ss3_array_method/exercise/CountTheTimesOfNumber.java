package ss3_array_method.exercise;

import java.util.Scanner;

public class CountTheTimesOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "The Weather Is Bad";
        System.out.print("Input Char: ");
        char check = scanner.nextLine().charAt(0);
        int count = 0;
        int i;
        for (i = 0; i < str.length(); i++) {
            if (check == str.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
