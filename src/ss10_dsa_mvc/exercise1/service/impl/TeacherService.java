package ss10_dsa_mvc.exercise1.service.impl;

import ss10_dsa_mvc.exercise1.model.Teacher;
import ss10_dsa_mvc.exercise1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "Hoàng", "12/12/1999", "Nam", "Hoa"));
        teachers.add(new Teacher(2, "Ngọc", "13/12/1999", "Nữ", "Ly"));
        teachers.add(new Teacher(3, "Thanh", "14/12/1999", "Nam", "Tin"));
        teachers.add(new Teacher(4, "Huyền", "15/12/1999", "Nữ", "Anh"));
    }

    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giảng viên thành công");
    }

    private Teacher infoTeacher() {
        System.out.print("Mời bạn nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập chuyên môn: ");
        String specialize = scanner.nextLine();
        Teacher teacher = new Teacher(id, name, dateOfBirth, gender, specialize);
        return teacher;
    }

    @Override
    public void removeTeacher() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + teacher.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Xóa thành công!");
            }
        }
    }

    @Override
    public void displayAllTeacher() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void editTeacher() {
        Teacher teacher = findTeacher();
        int choose;
        do {
            System.out.println("Giảng viên cần chỉnh sửa: ");
            System.out.println(teacher.toString());
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. ID");
            System.out.println("2. Tên giảng viên");
            System.out.println("3. Ngày sinh");
            System.out.println("4. Giới tính");
            System.out.println("5. Chuyên môn");
            System.out.println("6. Thoát");
            System.out.print("Chọn nội dung cần chỉnh sửa 1 -> 6: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    teacher.setId(Integer.parseInt(getEditInfo("ID")));
                    break;
                case 2:
                    teacher.setName(getEditInfo("Tên Giảng Viên"));
                    break;
                case 3:
                    teacher.setDateOfBirth(getEditInfo("Ngày sinh"));
                    break;
                case 4:
                    teacher.setGender(getEditInfo("Giới tính"));
                    break;
                case 5:
                    teacher.setSpecialize(getEditInfo("Chuyên môn"));
                    break;
                case 6:
                    return;
            }
            System.out.println("Chỉnh sửa thành công!");
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.print("Vui lòng chọn 1 (Có) - 2 (Không): ");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    @Override
    public void searchIdTeacher() {
        System.out.print("Vui lòng nhập id cần tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                System.out.println(teachers.get(i));
                break;
            }
        }
    }

    @Override
    public void searchNameTeacher() {
        System.out.print("Vui lòng nhập name cần tìm kiếm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().contains(name)) {
                System.out.println(teachers.get(i));
                break;
            }
        }
    }

    @Override
    public void arrangeNameTeacher() {
        boolean isSwap = true;
        Teacher temp;
        for (int i = 0; i < teachers.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < teachers.size() - 1 - i; j++) {
                if (teachers.get(j).getName().compareTo(teachers.get(j + 1).getName()) > 0) {
                    isSwap = true;
                    temp = teachers.get(j + 1);
                    teachers.set(j + 1, teachers.get(j));
                    teachers.set(j, temp);
                }
            }
        }
        displayAllTeacher();
    }

    public String getEditInfo(String editContent) {
        System.out.print("Vui lòng nhập " + editContent + " mới: ");
        return scanner.nextLine();
    }

    private Teacher findTeacher() {
        System.out.println("Mời bạn nhập vào id cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }
}
