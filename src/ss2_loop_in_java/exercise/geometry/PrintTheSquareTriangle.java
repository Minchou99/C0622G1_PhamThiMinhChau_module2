package ss2_loop_in_java.exercise.geometry;

import java.util.Scanner;

public class PrintTheSquareTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Height: ");
        int height = Integer.parseInt(scanner.nextLine());
        int i;
        int j;
        for (i = height; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for (i = 1; i <= height; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        for (i = height; i >= 1; i--) {
            for (j = height; j >= 1; j--) {
                if (j - i > 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
        for (i = 1; i <= height; i++) {
            for (j = height; j >= 1; j--) {
                if (j - i > 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
