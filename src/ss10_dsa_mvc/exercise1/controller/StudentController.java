package ss10_dsa_mvc.exercise1.controller;

import ss10_dsa_mvc.exercise1.service.IStudentService;
import ss10_dsa_mvc.exercise1.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    public static Scanner scanner = new Scanner(System.in);
    private static final IStudentService studentService = new StudentService();

    public static void managementStudent() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với hệ thống quản lí học viên");
            System.out.println("1. Hiển thị danh sách học viên");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Cập nhật thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Tìm học sinh");
            System.out.println("6. Exit");
            System.out.print("Mời bạn nhập chức năng 1->6: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentService.displayAllStudent();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.editStudent();
                    break;
                case 4:
                    studentService.removeStudent();
                    break;
                case 5:
                    studentService.searchIdStudent();
                    break;
                case 6:
                    studentService.searchNameStudent();
                    break;

                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
