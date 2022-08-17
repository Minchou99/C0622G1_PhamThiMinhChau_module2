package ss13_search_algorithm.exercise.find_the_longest_consecutive_string;

import java.util.LinkedList;
import java.util.Scanner;

public class LongestSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi: ");
        String string = scanner.nextLine();

        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

//        for (int i = 0; i < string.length(); i++) {
//            list.add(string.charAt(i));
//            for (int j = i + 1; j < string.length(); j++) {
//                if (string.charAt(j) > list.getLast()) {
//                    list.add(string.charAt(j));
//                } else {
//                    break;
//                }
//            }
//            if (list.size() > max.size()) {
//                max.clear();
//                max.addAll(list);
//            }
//            list.clear();
//        }

        for (int i = 0; i < string.length(); i++) {
            if (list.size() > 1 && string.charAt(i) <= list.getLast() && list.contains(string.charAt(i))) {
                list.clear();
            }
            list.add(string.charAt(i));

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }

        for (Character character : max) {
            System.out.print(character);
        }
        System.out.println();
    }
}
