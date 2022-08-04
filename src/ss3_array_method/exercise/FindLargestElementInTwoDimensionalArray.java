package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindLargestElementInTwoDimensionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Array Length:  ");
        int num = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Element Length: ");
        int num1 = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[num][num1];
        int i;
        int j;
        for (i = 0; i < num; i++) {
            for (j = 0; j < num1; j++) {
                System.out.print("Input Element " + (j + 1) + " Of " + (i + 1) + " : ");
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.print("Two-Dimensional Array: " + Arrays.deepToString(arr));
        double max = arr[0][0];
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println();
        System.out.print("Largest Element In Two Dimensional Array: " + max);
    }
}
