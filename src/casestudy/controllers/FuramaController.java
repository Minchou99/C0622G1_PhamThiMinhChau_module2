package casestudy.controllers;

import casestudy.utils.exception.FuramaException;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            int choice;
            while (true) {
                try {
                    System.out.println("--------------------------------");
                    System.out.println("Chào mừng bạn đến với hệ thống quản lí của khách sạn FURAMA Đà Nẵng");
                    System.out.println("1. Hệ thống quản lí nhân viên");
                    System.out.println("2. Hệ thống quản lí khách hàng");
                    System.out.println("3. Hệ thống quản lí cơ sở vật chất");
                    System.out.println("4. Hệ thống quản lí đặt vé");
                    System.out.println("5. Hệ thống quản lí chương trình khuyến mãi");
                    System.out.println("6. Thoát");
                    System.out.print("Mời bạn nhập chức năng 1-6: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 6) {
                        throw new FuramaException("Vui lòng nhập số từ 1->6");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập sai. Vui lòng nhập số.");
                } catch (FuramaException e) {
                    System.out.println(e.getMessage());
                }
            }

            switch (choice) {
                case 1:
                    EmployeeController.managementEmployee();
                    break;
                case 2:
                    CustomerController.managementCustomer();
                    break;
                case 3:
                    FacilityController.managementFacility();
                    break;
                case 4:
                    BookingController.managementBooking();
                    break;
                case 5:
                    PromotionController.managementPromotion();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không đúng.");
            }
        }
    }
}
