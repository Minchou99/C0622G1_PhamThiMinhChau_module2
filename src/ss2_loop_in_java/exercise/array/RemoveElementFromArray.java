package ss2_loop_in_java.exercise.array;

import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Number: ");
        int num = scanner.nextInt();
        int index = 0;
        int i;
        for (i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                index = i;
            }
        }

        for (i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
