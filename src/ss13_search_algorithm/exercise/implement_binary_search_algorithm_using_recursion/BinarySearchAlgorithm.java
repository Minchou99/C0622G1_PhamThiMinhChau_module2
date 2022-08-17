package ss13_search_algorithm.exercise.implement_binary_search_algorithm_using_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySearchAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài phần tử của mảng: ");
        int num = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Mảng của bạn đã nhập: " + Arrays.toString(arr));
        arrangeArr(arr);
        System.out.print("Mảng sau khi được sắp xếp là: ");
        show(arr);

        System.out.println();
        System.out.print("Nhập số bạn muốn tìm kiếm: ");
        int check = Integer.parseInt(scanner.nextLine());
        int arrArrange = binarySearch(arr, check, 0, arr.length);
        System.out.println("Vị trí cần tìm là: " + arrArrange);
    }

    public static void arrangeArr(int[] array) {
        int temp ;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int binarySearch(int[] arr, int k, int left, int right) {

        if (left <= right) {
            int mid = (left + right) / 2;

            if ((k == arr[mid])) {
                return mid;
            }

            if (k > arr[mid]) {
                return binarySearch(arr, k, mid + 1, right);
            }
            return binarySearch(arr, k, left, mid - 1);
        }

        return -1;
    }
}


