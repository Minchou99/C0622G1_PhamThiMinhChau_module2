package ss2_loop_in_java.exercise.geometry;

import java.util.Scanner;

public class PrintIsoscelesTriangle {
    public static void main(String[] args) {
        Scanner inputNumber = new Scanner(System.in);
        System.out.print("Input Height: ");
        int height = Integer.parseInt(inputNumber.nextLine());
        int width = height * 2 - 1;
        int i;
        int j;
        int k;
        for (i = 1; i <= height; i++) {
            for (j = 0; j <= (width / 2 - i); j++) {
                System.out.print(" ");
            }
            for (k = 1; k <= (i * 2 - 1); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}