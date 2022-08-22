package ss12_java_collection_framework.controller;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);

    public void menuManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với hệ thống quản lí sản phẩm của MinChou");
            System.out.println("1. Quản lí xe đạp");
            System.out.println("2. Quản lí xe máy");
            System.out.print("Mời bạn nhập chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BikeController.managementBike();
                    break;
                case 2:
                    MotoBikeController.managementMotoBike();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
