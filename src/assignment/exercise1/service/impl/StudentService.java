package assignment.exercise1.service.impl;

import assignment.exercise1.model.SortByNameComparator;
import assignment.exercise1.model.Student;
import assignment.exercise1.service.IStudentService;
import assignment.exercise1.utils.exception.NameClassException;
import assignment.exercise1.utils.exception.NameException;
import assignment.exercise1.utils.io_text_file.ReadStudentFile;
import assignment.exercise1.utils.io_text_file.WriteStudentFile;
import untils.exception.IdException;
import untils.exception.PointException;

import java.util.*;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String path = "src\\assignment\\exercise1\\data\\student.txt";
    ReadStudentFile readStudentFile = new ReadStudentFile();
    WriteStudentFile writeStudentFile = new WriteStudentFile();
    List<Student> students = new ArrayList<>();

//    static {
//        students.add(new Student(1, "Châu", "1/1/1999", "Nam", 7, "C06"));
//        students.add(new Student(2, "Ngọc", "2/2/1999", "Nữ", 8, "C06"));
//        students.add(new Student(3, "Nga", "3/2/1999", "Nữ", 9, "C06"));
//        students.add(new Student(4, "Hồng", "4/2/1999", "Nữ", 10, "C06"));
//        students.add(new Student(5, "Hồng", "6/2/1999", "Nữ", 10, "C06"));
//        students.add(new Student(6, "Hồng", "9/2/1999", "Nữ", 10, "C06"));
//    }

    @Override
    public void displayAllStudent() {
        System.out.println("Danh sách sinh viên");
        students = readStudentFile.readStudentFile(path);

        if (students.size() == 0) {
            System.out.println("Danh sách rỗng");
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void addStudent() {
        students = readStudentFile.readStudentFile(path);
        Student student = this.infoStudent();
        students.add(student);
        writeStudentFile.writeStudentFile(path, students);
        System.out.println("Thêm mới học sinh thành công!");
        System.out.println("Danh sách sinh viên");
        displayAllStudent();
    }

    @Override
    public void removeStudent() {
        students = readStudentFile.readStudentFile(path);
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
                writeStudentFile.writeStudentFile(path, students);
            } else {
                System.out.println("Xóa sinh viên không thành công!");
            }
        }
    }

    @Override
    public void editStudent() {
        students = readStudentFile.readStudentFile(path);
        Student student = findStudent();

        if (student == null) {
            System.out.println("ID không tồn tại trong danh sách!");
            return;
        }

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
                    student.setId(getEditInfo("ID"));
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
                default:
                    System.out.println("Chức năng bạn chọn không có trong menu!");
            }
            System.out.println("Chỉnh sửa thành công!");
            writeStudentFile.writeStudentFile(path, students);
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
        students = readStudentFile.readStudentFile(path);

        System.out.print("Vui lòng nhập id cần tìm kiếm: ");
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                System.out.println(students.get(i).toString());
                break;
            }
        }

        System.out.println("Không tìm thấy id học sinh");
    }

    @Override
    public void searchNameStudent() {
        students = readStudentFile.readStudentFile(path);
        List<Student> foundStudent = new LinkedList<>();
        System.out.print("Vui lòng nhập tên cần tìm kiếm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().contains(name)) {
                foundStudent.add(students.get(i));
            }
        }
        if (foundStudent.isEmpty()) {
            System.out.println("Không tìm thấy tên học sinh");
        } else {
            for (Student student : foundStudent) {
                System.out.println(student.toString());
            }
        }
    }

    public void sortStudentByName() {
        students = readStudentFile.readStudentFile(path);
        students.sort(new SortByNameComparator());
        writeStudentFile.writeStudentFile(path, students);
        displayAllStudent();
    }

//    public void sortStudentByScore() {
//        students = readStudentFile.readStudentFile(path);
//        students.sort(new SortByPointComparator());
//        writeStudentFile.writeStudentFile(path, students);
//        displayAllStudent();
//    }

//    @Override
//    public void arrangeNameStudent() {
//        boolean isSwap = true;
//        Student temp;
//        for (int i = 0; i < students.size() - 1 && isSwap; i++) {
//            isSwap = false;
//            for (int j = 0; j < students.size() - 1 - i; j++) {
//                if (students.get(j).getName().compareTo(students.get(j + 1).getName()) > 0) {
//                    isSwap = true;
//                    temp = students.get(j + 1);
//                    students.set(j + 1, students.get(j));
//                    students.set(j, temp);
//                }
//            }
//        }
//        displayAllStudent();
//    }

    public String getEditInfo(String editContent) {
        System.out.print("Vui lòng nhập " + editContent + " mới: ");
        return scanner.nextLine();
    }

    private Student findStudent() {
        students = readStudentFile.readStudentFile(path);
        System.out.println("Mời bạn nhập id : ");
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return students.get(i);
            }
        }
        return null;
    }

    public Student infoStudent() {
        String id;
        while (true) {
            try {
                System.out.print("Mời bạn nhập id: ");
                id = scanner.nextLine();

                for (int i = 0; i < students.size(); i++) {
                    if (id.equals(students.get(i).getId())) {
                        throw new IdException("Id này đã tồn tại. Vui lòng nhập id khác.");
                    }
                }
                break;
            } catch (IdException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String name;
        String regex = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                if (!(name.matches(regex))) {
                    throw new NameException("Vui lòng nhập tên không chứa kí tự đặc biệt và độ dài kí tự từ (5-50)");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
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

        double point;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Integer.parseInt(scanner.nextLine());
                if (point < 0 || point > 100) {
                    throw new PointException("Bạn không thể nhập điểm nhỏ hơn 0 và lớn hơn 100");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (PointException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String nameClass;
        String nameClassRegex = "^[AC][0-9]{4}[GI][1]$";
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên lớp: ");
                nameClass = scanner.nextLine();
                if (!(nameClass.matches(nameClassRegex))) {
                    throw new NameClassException("Vui lòng nhập tên theo đúng định dạng (A|C)XXXX(G|I)1 với X là các số từ 1->9");
                }
                break;
            } catch (NameClassException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }
        Student student = new Student(id, name, dateOfBirth, gender, point, nameClass);
        return student;
    }
}
