package ss10_dsa_mvc.exercise1.service.impl;

import ss10_dsa_mvc.exercise1.model.Student;
import ss10_dsa_mvc.exercise1.service.IStudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Châu", "1/1/1999", "Nam", 7, "C06"));
        students.add(new Student(2, "Ngọc", "2/2/1999", "Nữ", 8, "C06"));
        students.add(new Student(3, "Nga", "3/2/1999", "Nữ", 9, "C06"));
        students.add(new Student(4, "Hồng", "4/2/1999", "Nữ", 10, "C06"));
    }

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

    @Override
    public void editStudent() {
        Student student = findStudent();
        int choose;
        do {
            System.out.println("Học viên cần chỉnh sửa: ");
            System.out.println(student.toString());
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. ID");
            System.out.println("2. Tên học viên");
            System.out.println("3. Ngày sinh");
            System.out.println("4. Giới tính");
            System.out.println("5. Điểm");
            System.out.println("6. Lớp học");
            System.out.println("7. Thoát");
            System.out.println("Chọn nội dung cần chỉnh sửa 1 -> 7: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    student.setId(Integer.parseInt(getEditInfo("ID")));
                    break;
                case 2:
                    student.setName(getEditInfo("Tên Học Viên"));
                    break;
                case 3:
                    student.setDateOfBirth(getEditInfo("Ngày sinh"));
                    break;
                case 4:
                    student.setGender(getEditInfo("Giới tính"));
                    break;
                case 5:
                    student.setPoint(Integer.parseInt(getEditInfo("1")));
                    break;
                case 6:
                    student.setNameClass(getEditInfo("Lớp học"));
                    break;
                case 7:
                    return;
            }
            System.out.println("Chỉnh sửa thành công!");
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.println("Vui lòng chọn 1 (Có) - 2 (Không)");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    @Override
    public void searchIdStudent() {
        System.out.print("Vui lòng nhập id cần tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                System.out.println(students.get(i));
                break;
            }
        }
    }

    @Override
    public void searchNameStudent() {
        System.out.print("Vui lòng nhập name cần tìm kiếm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().contains(name)) {
                System.out.println(students.get(i));
                break;
            }
        }
    }

    @Override
    public void arrangeNameStudent() {
        String temp;
        String[] str = new String[students.size()];
        for (int i = 0; i < students.size(); i++) {
            str[i] = students.get(i).getName();
        }
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (str[i].compareTo(str[j]) > 0) {
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (str[i].equals(students.get(j).getName())) {
                    str[i] = String.valueOf(students.get(j));
                }
            }
        }
        System.out.println(Arrays.toString(str));
    }

    public String getEditInfo(String editContent) {
        System.out.print("Vui lòng nhập " + editContent + " mới: ");
        return scanner.nextLine();
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
        double point = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        Student student = new Student(id, name, dateOfBirth, gender, point, nameClass);
        return student;
    }
}
