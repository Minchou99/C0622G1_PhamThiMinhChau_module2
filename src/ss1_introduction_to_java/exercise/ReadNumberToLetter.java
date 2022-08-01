package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class ReadNumberToLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Number: ");
        int inputNumber = Integer.parseInt(scanner.nextLine());
        String units = " ";
        switch (inputNumber % 10) {
            case 1:
                units = "One";
                break;
            case 2:
                units = "Two";
                break;
            case 3:
                units = "Three";
                break;
            case 4:
                units = "Four";
                break;
            case 5:
                units = "Five";
                break;
            case 6:
                units = "Six";
                break;
            case 7:
                units = "Seven";
                break;
            case 8:
                units = "Eight";
                break;
            case 9:
                units = "Nine";
                break;
        }
        String dozens = " ";
        switch ((inputNumber / 10) % 10) {
            case 2:
                dozens = "Twenty";
                break;
            case 3:
                dozens = "Thirty";
                break;
            case 4:
                dozens = "Fourty";
                break;
            case 5:
                dozens = "Fifty";
                break;
            case 6:
                dozens = "Sixty";
                break;
            case 7:
                dozens = "Seventy";
                break;
            case 8:
                dozens = "Eighty";
                break;
            case 9:
                dozens = "Ninety";
                break;
        }
        String hundreds = " ";
        switch (inputNumber / 100) {
            case 1:
                hundreds = "One hundred";
                break;
            case 2:
                hundreds = "Two hundreds";
                break;
            case 3:
                hundreds = "Three hundreds";
                break;
            case 4:
                hundreds = "Four hundreds";
                break;
            case 5:
                hundreds = "Five hundreds";
                break;
            case 6:
                hundreds = "Six hundreds";
                break;
            case 7:
                hundreds = "Seven hundreds";
                break;
            case 8:
                hundreds = "Eight hundreds";
                break;
            case 9:
                hundreds = "Nine hundreds";
                break;
        }

        System.out.println("Số vừa nhập là: " + inputNumber);
        System.out.println("Đọc là: " + hundreds + " " + dozens + " " + units);
    }
}