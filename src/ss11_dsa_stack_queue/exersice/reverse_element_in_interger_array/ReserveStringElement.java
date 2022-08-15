package ss11_dsa_stack_queue.exersice.reverse_element_in_interger_array;

import java.util.Arrays;
import java.util.Stack;

public class ReserveStringElement {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        String word = "The weather is bad!";
        String[] words = word.split("");

        int i;
        for (i = 0; i < words.length; i++) {
            stringStack.push(words[i]);
        }
        System.out.print("Chuỗi khi chưa đảo ngược: ");
        System.out.println(word);

        int j;
        for (j = 0; j < words.length; j++) {
            words[j] = stringStack.pop();
        }

        String wordRe = "";
        int k;
        for (k = 0; k < words.length; k++) {
            wordRe += words[k];
        }
        System.out.print("Chuỗi khi đảo ngược: ");
        System.out.println(wordRe);
    }
}
