package assignment.exercise1.service.impl;

import assignment.exercise1.model.Teacher;
import assignment.exercise1.service.ITeacherService;
import untils.exception.IdException;

import java.util.*;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

//    static {
//        teachers.add(new Teacher(1, "Hoàng", "12/12/1999", "Nam", "Hoa"));
//        teachers.add(new Teacher(2, "Ngọc", "13/12/1999", "Nữ", "Ly"));
//        teachers.add(new Teacher(3, "Thanh", "14/12/1999", "Nam", "Tin"));
//        teachers.add(new Teacher(4, "Huyền", "15/12/1999", "Nữ", "Anh"));
//        teachers.add(new Teacher(5, "Huyền", "19/12/1999", "Nam", "CD"));
//        teachers.add(new Teacher(6, "Huyền", "21/12/1999", "Nữ", "Anh"));
//    }

    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giảng viên thành công");
    }

    private Teacher infoTeacher() {
        String id;
        while (true) {
            try {
                System.out.print("Mời bạn nhập id: ");
                id = scanner.nextLine();

                for (int i = 0; i < teachers.size(); i++) {
                    if (teachers.get(i).getId() == id) {
                        throw new IdException("Id này đã tồn tại. Vui lòng nhập id khác.");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Vui lòng nhập lại.");
            } catch (IdException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh theo định dạng ngày/tháng/năm:  ");
                dateOfBirth = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không đúng định dạng. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String gender;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính: ");
                gender = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String specialize;
        while (true) {
            try {
                System.out.print("Mời bạn nhập chuyên môn: ");
                specialize = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

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
                    teacher.setId(getEditInfo("ID"));
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
        String id;
        while (true) {
            try {
                System.out.print("Vui lòng nhập id cần tìm kiếm: ");
                id = scanner.nextLine();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                System.out.println(teachers.get(i));
                break;
            }
        }
        System.out.println("Không tìm thấy id giáo viên");
    }

    @Override
    public void searchNameTeacher() {
        List<Teacher> foundTeacher = new LinkedList<>();
        System.out.print("Vui lòng nhập tên cần tìm kiếm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().contains(name)) {
                System.out.println(teachers.get(i));
            }
        }
        if (foundTeacher.isEmpty()) {
            System.out.println("Không tìm thấy tên giảng viên");
        } else {
            for (Teacher teacher : foundTeacher) {
                System.out.println(teacher.toString());
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
        String id = scanner.nextLine();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }
}
