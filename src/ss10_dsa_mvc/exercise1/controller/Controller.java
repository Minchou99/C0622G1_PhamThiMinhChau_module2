package ss10_dsa_mvc.exercise1.controller;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);

    public void menuManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với hệ thống quản lí của codegym ĐN");
            System.out.println("1. Quản lí giảng viên");
            System.out.println("2. Quản lí học viên");
            System.out.print("Mời bạn nhập chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    TeacherController.managementTeacher();
                    break;
                case 2:
                    StudentController.managementStudent();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

}
