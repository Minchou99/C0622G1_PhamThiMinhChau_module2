package casestudy.controllers;

import casestudy.services.IEmployeeService;
import casestudy.services.impl.EmployeeService;
import casestudy.utils.exception.EmployeeException;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static final IEmployeeService employeeService = new EmployeeService();

    public static void managementEmployee() {
        while (true) {
            int choice;
            while (true) {
                try {
                    System.out.println("--------------------------------------");
                    System.out.println("Chào mừng bạn đến với hệ thống quản lí nhân viên của FURAMA");
                    System.out.println("1. Hiển thị danh sách nhân viên");
                    System.out.println("2. Thêm mới nhân viên");
                    System.out.println("3. Chỉnh sửa nhân viên");
                    System.out.println("4. Trở về hệ thống quản lí chính");
                    System.out.println("Mời bạn nhập chức năng 1 -> 4: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 4) {
                        throw new EmployeeException("Bạn nhập sai. Vui lòng nhập số lớn hơn 0 và nhỏ hơn 5");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập không đúng yêu cầu. Vui lòng nhập số.");
                } catch (EmployeeException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Bạn nhập không hợp lệ.");
                }
            }

            switch (choice) {
                case 1:
                    employeeService.displayListEmployee();
                    break;
                case 2:
                    employeeService.addNewEmployee();
                    break;
                case 3:
                    employeeService.editEmployee();
                    break;
                case 4:
                   return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng.");
            }
        }
    }
}
