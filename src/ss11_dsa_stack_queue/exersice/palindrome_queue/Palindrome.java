package ss11_dsa_stack_queue.exersice.palindrome_queue;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        String wordStr = "able was I ere I saw elba";
        Stack<String> stringStack = new Stack<>();
        Queue<String> stringQueue = new LinkedList<>();
        String[] words = wordStr.split("");
        int count = 0;

        int i;
        for (i = 0; i < words.length; i++) {
            stringStack.push(words[i]);
            stringQueue.add(words[i]);
        }
        System.out.println(stringStack);
        System.out.println(stringQueue);

        int k;
        for (k = 0; k < stringQueue.size(); k++) {
            if (!stringStack.pop().equals(stringQueue.poll())) {
                count++;
            }
        }

        if (count != 0) {
            System.out.println("String is not a Palindrome");
        } else {
            System.out.println("String is a Palindrome");
        }
    }
}
