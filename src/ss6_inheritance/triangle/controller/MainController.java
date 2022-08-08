package ss6_inheritance.triangle.controller;

import ss6_inheritance.triangle.models.Triangle;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side1;
        double side2;
        double side3;
        String color;

        System.out.print("Color: ");
        color = scanner.nextLine();

        do {
            System.out.print("Side1: ");
            side1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Side2: ");
            side2 = Double.parseDouble(scanner.nextLine());
            System.out.print("Side3: ");
            side3 = Double.parseDouble(scanner.nextLine());

            if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side3 + side2) > side1) {
                break;
            } else {
                System.out.println("nhap lai");
            }
        } while (true);

        Triangle triangle = new Triangle(color, side1, side2, side3);
        System.out.println(triangle);
    }
}
