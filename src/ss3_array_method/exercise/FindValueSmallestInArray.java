package ss3_array_method.exercise;

import java.util.Scanner;

public class FindValueSmallestInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Array Length: ");
        int num = Integer.parseInt(scanner.nextLine());
        int[] array = new int[num];
        int i;
        for (i = 0; i < num; i++) {
            System.out.printf("Input Element %d : ", (i + 1));
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        int min = array[0];
        int j;
        for (j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        System.out.print("Smallest Value: " + min);
    }
}
