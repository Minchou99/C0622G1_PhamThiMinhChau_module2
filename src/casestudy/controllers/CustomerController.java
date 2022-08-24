package casestudy.controllers;

import casestudy.services.ICustomerService;
import casestudy.services.impl.CustomerService;
import casestudy.utils.exception.CustomerException;

import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static ICustomerService customerService = new CustomerService();

    public static void managementCustomer(){
        while (true) {
            int choice;
            while (true) {
                try {
                    System.out.println("--------------------------------------");
                    System.out.println("Chào mừng bạn đến với hệ thống quản lí khách hàng của FURAMA");
                    System.out.println("1. Hiển thị danh sách khách hàng");
                    System.out.println("2. Thêm mới khách hàng");
                    System.out.println("3. Chỉnh sửa khách hàng");
                    System.out.println("4. Trở về hệ thống quản lí chính");
                    System.out.println("Mời bạn nhập chức năng 1 -> 4: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 4) {
                        throw new CustomerException("Bạn nhập sai. Vui lòng nhập số lớn hơn 0 và nhỏ hơn 5");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập không đúng yêu cầu. Vui lòng nhập số.");
                } catch (CustomerException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Bạn nhập không hợp lệ.");
                }
            }

            switch (choice) {
                case 1:
                    customerService.displayListCustomer();
                    break;
                case 2:
                    customerService.addNewCustomer();
                    break;
                case 3:
                    customerService.editCustomer();
                    break;
                case 4:
                    customerService.returnMainMenu();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng.");
            }
        }
    }
}
