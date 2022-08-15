package ss11_dsa_stack_queue.exersice.checking_bracket;

import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        String word = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        String[] words = word.split("");
        boolean check = false;
        String left = "";
        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("(")) {
                stringStack.push(words[i]);
            } else if (words[i].equals(")")) {
                if (stringStack.isEmpty()) {
                    check = false;
                    break;
                } else {
                    left = stringStack.pop();
                    if (!left.equals("(") || !words[i].equals(")")) {
                        check = false;
                        break;
                    }
                }
            }
            if (i == words.length - 1) {
                check = stringStack.isEmpty();
            }
        }
        System.out.println(check);
    }
}
