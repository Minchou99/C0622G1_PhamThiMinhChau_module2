package ss14_sort_algorithm.exercise;

public class InstallInsertionSortAlgorithm {
    public static void main(String[] args) {
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int[] arr = {2, 28, 33, 69, 34, 56, 32, 17, 89, 23};

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }
}
