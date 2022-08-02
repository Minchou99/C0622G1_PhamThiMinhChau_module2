package ss2_loop_in_java.exercise.array;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Number: ");
        int num = scanner.nextInt();
        System.out.print("Input Index: ");
        int index = scanner.nextInt();
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = num;
        System.out.println(Arrays.toString(arr));
    }
}

