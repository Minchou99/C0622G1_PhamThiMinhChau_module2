package ss10_dsa_mvc.exercise1.service.impl;

import ss10_dsa_mvc.exercise1.model.Student;
import ss10_dsa_mvc.exercise1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();


    @Override
    public void displayAllStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Thêm mới học sinh thành công");
    }

    @Override
    public void removeStudent() {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + student.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Xóa thành công!");
            }
        }
    }

    private Student findStudent() {
        System.out.println("Mời bạn nhập vào id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
        return null;
    }

    public Student infoStudent() {
        System.out.print("Mời bạn nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        Student student = new Student(id, name, dateOfBirth, gender, point, nameClass);
        return student;
    }
}