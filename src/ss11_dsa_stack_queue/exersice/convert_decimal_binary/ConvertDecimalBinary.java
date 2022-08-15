package ss11_dsa_stack_queue.exersice.convert_decimal_binary;

import java.util.Stack;

public class ConvertDecimalBinary {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        int n = 123445;

        while (n != 0) {
            integerStack.push(n % 2);
            n /= 2;
        }

        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop());
        }
    }
}
