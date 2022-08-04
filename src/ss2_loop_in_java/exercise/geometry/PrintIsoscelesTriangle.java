package ss2_loop_in_java.exercise.geometry;

import java.util.Scanner;

public class PrintIsoscelesTriangle {
    public static void main(String[] args) {
        Scanner inputNumber = new Scanner(System.in);
        System.out.print("Input Height: ");
        int height = Integer.parseInt(inputNumber.nextLine());
        int width = height * 2 - 1;
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j <= (width / 2 - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (i * 2 - 1); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}