package ss5_access_modifier_static_method_property.practise.oop.exercise_1;

import java.util.Scanner;

public class TestCandidate {
    public static void main(String[] args) {

        //Input amount of element by method
        int numbers;
        numbers = inputNumber("The number of student ");

        //Create OOP Candidate array. Input element in array by method
        Candidate[] array = new Candidate[numbers];
        inputElementForArray(array);

//        // Output infor of Candidate that have total score > 15 = foreach
//        for (Candidate element : array
//        ) {
//            if (element.getTotalScore() > 15) {
//                System.out.println(element.toString());
//            }
//        }

        // Output infor of Candidate that have total score > 15 = forindex
        for (int i = 0; i < array.length; i++) {
            if (array[i].getTotalScore() > 15) {
                System.out.println(array[i].toString());
            }
        }
    }

    // Nhập phần tử cho mảng số đối tượng thí sinh, truyền vào mảng cần nhập phần tử
    public static void inputElementForArray(Candidate[] arr) {
        Scanner scanner = new Scanner(System.in);

        String name;
        double mathScore;
        double literatureScore;
        double englishScore;
        int i;
        for (i = 0; i < arr.length; i++) {
            //Lấy thông tin tên, điểm 3 môn
            System.out.printf("No = %d , Candidate Name = ", i + 1);
            name = scanner.nextLine();

            mathScore = inputScore("Math Score");
            literatureScore = inputScore("Literature Score");
            englishScore = inputScore("English Score");

            //Tạo đối tượng với tên và điểm 3 môn
            Candidate candidate = new Candidate(name, mathScore, literatureScore, englishScore);

            //Đưa đối tượng vừa tạo vào mảng
            arr[i] = candidate;
        }
    }

    //Phương thức nhập vào độ dài danh sách thí sinh
    public static int inputNumber(String nameOfVariable) {
        Scanner scanner = new Scanner(System.in);

        int number;
        boolean numberIsInvalid;

        do {
            System.out.println("Enter " + nameOfVariable);
            number = Integer.parseInt(scanner.nextLine());
            numberIsInvalid = number < 0 || number > 20;

            if (numberIsInvalid) {
                System.out.printf("Invalid input value\n" +
                        "Retype %s >=0 and %s <=20\n", nameOfVariable, nameOfVariable);
            }

        } while (numberIsInvalid);
        return number;
    }

    //Phương thức kiểm nhập điểm, yêu cầu >=0 và <=10
    public static int inputScore(String nameOfVariable) {
        Scanner scanner = new Scanner(System.in);

        int number;
        boolean numberIsInvalid;

        do {
            System.out.print("Enter " + nameOfVariable);
            number = Integer.parseInt(scanner.nextLine());
            numberIsInvalid = number < 0 || number > 10;

            if (numberIsInvalid) {
                System.out.printf("Invalid input value\n" +
                        "Retype %s >=0 and %s <=10\n", nameOfVariable, nameOfVariable);
            }

        } while (numberIsInvalid);
        return number;
    }

}
