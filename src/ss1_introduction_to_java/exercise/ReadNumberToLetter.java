package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class ReadNumberToLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Number: ");
        int inputNumber = Integer.parseInt(scanner.nextLine());
        String dozens = "";
        String units = "";
        String hundreds = "";
        if (inputNumber < 10) {
            switch (inputNumber) {
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
            System.out.println(units);
        } else if (inputNumber < 20) {
            switch (inputNumber) {
                case 11:
                    dozens = "Eleven";
                    break;
                case 12:
                    dozens = "Twelve";
                    break;
                case 13:
                    dozens = "Thirteen";
                    break;
                case 14:
                    dozens = "Fourteen";
                    break;
                case 15:
                    dozens = "Fifteen";
                    break;
                case 16:
                    dozens = "Sixteen";
                    break;
                case 17:
                    dozens = "Eleventeen";
                    break;
                case 18:
                    dozens = "Eightteen";
                    break;
                case 19:
                    dozens = "Nineteen";
                    break;
            }
            System.out.println(dozens);
        } else if (inputNumber < 100) {
            switch (inputNumber / 10) {
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
            switch ((inputNumber % 10) % 10) {
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
            System.out.println(dozens + ' ' + units);
        } else if (inputNumber < 1000) {
            if (inputNumber % 100 == 0) {
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
                System.out.println(hundreds);
            } else {
                switch (inputNumber / 100) {
                    case 1:
                        hundreds = "One hundred and";
                        break;
                    case 2:
                        hundreds = "Two hundreds and";
                        break;
                    case 3:
                        hundreds = "Three hundreds and";
                        break;
                    case 4:
                        hundreds = "Four hundreds and";
                        break;
                    case 5:
                        hundreds = "Five hundreds and";
                        break;
                    case 6:
                        hundreds = "Six hundreds and";
                        break;
                    case 7:
                        hundreds = "Seven hundreds and";
                        break;
                    case 8:
                        hundreds = "Eight hundreds and";
                        break;
                    case 9:
                        hundreds = "Nine hundreds and";
                        break;
                }
                if ((inputNumber % 100) < 20) {
                    switch (inputNumber % 100) {
                        case 1:
                            dozens = "One";
                            break;
                        case 2:
                            dozens = "Two";
                            break;
                        case 3:
                            dozens = "Three";
                            break;
                        case 4:
                            dozens = "Four";
                            break;
                        case 5:
                            dozens = "Five";
                            break;
                        case 6:
                            dozens = "Six";
                            break;
                        case 7:
                            dozens = "Seven";
                            break;
                        case 8:
                            dozens = "Eight";
                            break;
                        case 9:
                            dozens = "Nine";
                            break;
                        case 10:
                            dozens = "Ten";
                            break;
                        case 11:
                            dozens = "Eleven";
                            break;
                        case 12:
                            dozens = "Twelve";
                            break;
                        case 13:
                            dozens = "Thirteen";
                            break;
                        case 14:
                            dozens = "Fourteen";
                            break;
                        case 15:
                            dozens = "Fifteen";
                            break;
                        case 16:
                            dozens = "Sixteen";
                            break;
                        case 17:
                            dozens = "Eleventeen";
                            break;
                        case 18:
                            dozens = "Eightteen";
                            break;
                        case 19:
                            dozens = "Nineteen";
                            break;
                    }
                    System.out.println(hundreds + " " + dozens);
                } else {
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
                    switch (inputNumber % 10) {
                        case 0:
                            units = " ";
                            break;
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
                    System.out.println(hundreds + ' ' + dozens + ' ' + units);
                }
            }
        }
    }
}