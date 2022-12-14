package assignment.exercise1.controller;

import assignment.exercise1.service.ITeacherService;
import assignment.exercise1.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    public static Scanner scanner = new Scanner(System.in);
    private static final ITeacherService teacherService = new TeacherService();

    public static void managementTeacher() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với hệ thống quản lí giảng viên");
            System.out.println("1. Hiển thị danh sách giảng viên");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật thông tin giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Tìm giảng viên theo id");
            System.out.println("6. Tìm giảng viên theo tên");
            System.out.println("7. Sắp xếp theo tên");
            System.out.println("8. Thoát");
            System.out.print("Mời bạn nhập chức năng 1->8: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    teacherService.displayAllTeacher();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.editTeacher();
                    break;
                case 4:
                    teacherService.removeTeacher();
                    break;
                case 5:
                    teacherService.searchIdTeacher();
                    break;
                case 6:
                    teacherService.searchNameTeacher();
                    break;
                case 7:
                    teacherService.arrangeNameTeacher();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
