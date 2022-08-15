package ss11_dsa_stack_queue.exersice.reverse_element_in_interger_array;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReserveIntegerElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stack<Integer> integerStack = new Stack<>();
        int i;
        for (i = 0; i < arr.length; i++) {
            integerStack.push(arr[i]);
        }
        System.out.print("Phần tử trong mảng trước khi đảo: ");
        System.out.println(integerStack);

        int j;
        for (j = 0; j < arr.length; j++) {
            arr[j] = integerStack.pop();
        }

        System.out.print("Phần tử trong mảng sau khi đảo: ");
        System.out.println(Arrays.toString(arr));
    }
}
