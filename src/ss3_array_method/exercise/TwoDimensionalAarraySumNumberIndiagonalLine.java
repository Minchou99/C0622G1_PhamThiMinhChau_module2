package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDimensionalAarraySumNumberIndiagonalLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.print("Input Array Length: ");
        int num = Integer.parseInt(scanner.nextLine());

        double[][] array = new double[num][num];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("Input Element %d Of %d ", (j + 1), (i + 1));
                array[i][j] = Integer.parseInt(scanner.nextLine());
                if (j == i) {
                    sum += array[i][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(array));
        System.out.print(sum);
    }
}
