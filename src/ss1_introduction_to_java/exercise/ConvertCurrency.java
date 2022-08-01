package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class ConvertCurrency {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner number = new Scanner(System.in);
        System.out.print("Mời bạn nhập số tiền USD: ");
        usd = number.nextDouble();
        double convert = usd * vnd;
        System.out.println("Giá trị VNĐ: " + convert);
    }
}
