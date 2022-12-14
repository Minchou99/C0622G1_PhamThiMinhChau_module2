package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDimensionalAarraySumNumberIndiagonalLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int i;
        int j;
        int k;

        System.out.print("Input Array Length: ");
        int num = Integer.parseInt(scanner.nextLine());

        double[][] array = new double[num][num];

        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                System.out.printf("Input Element %d Of %d ", (j + 1), (i + 1));
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }

        for (k = 0; k < array.length; k++) {
            sum += array[k][k];
        }

        System.out.println(Arrays.deepToString(array));
        System.out.print(sum);
    }
}
