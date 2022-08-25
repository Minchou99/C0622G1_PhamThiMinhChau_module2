package casestudy.services.impl;

import casestudy.controllers.FuramaController;
import casestudy.models.person.Employee;
import casestudy.services.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
   private static List<Employee> employees = new ArrayList<>();
static {
    employees.add( new Employee("134","ứdrft","sdfg","fg","456788",234567,"dfg","fg","d","4567"));
}


    @Override
    public void displayListEmployee() {
        System.out.println("Danh sách nhân viên");

        if (employees.size() == 0) {
            System.out.println("Danh sách rỗng");
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void addNewEmployee() {
        Employee employee = this.infoEmployee();
        employees.add(employee);
        System.out.println("Thêm mới nhân viên thành công!");
        System.out.println("Danh sách sau khi thêm");
        displayListEmployee();
    }

    public Employee infoEmployee() {
        System.out.println("Mời bạn nhập mã nhân viên: ");
        String id = scanner.nextLine();
        System.out.println("Mời bạn nhập Họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày tháng năm sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Mời bạn nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Mời bạn nhập CMND: ");
        String identityCard = scanner.nextLine();
        System.out.println("Mời bạn nhập số điện thoại: ");
        double phoneNumber = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập địa chỉ email: ");
        String email = scanner.nextLine();
        System.out.println("Mời bạn nhập trình độ: ");
        String level = employeeLevel();
        System.out.println("Mời bạn nhập vị trí: ");
        String position = employeePosition();
        System.out.println("Mời bạn nhập lương: ");
        String salary = scanner.nextLine();

        Employee employee = new Employee(id, name, dateOfBirth, gender, identityCard, phoneNumber, email, level, position, salary);
        return employee;
    }

    public String employeeLevel() {
        System.out.println("-----Trình độ----- ");
        System.out.println("1. Trung cấp ");
        System.out.println("2. Cao đẳng ");
        System.out.println("3. Đại học ");
        System.out.println("4. Sau đại học ");
        System.out.println("Vui lòng chọn trình độ của nhân viên 1->4: ");
        int choice = Integer.parseInt(scanner.nextLine());
        String line = "";
        switch (choice) {
            case 1:
                line += "Trung cấp";
                break;
            case 2:
                line += "Cao đẳng";
                break;
            case 3:
                line += "Đại học";
                break;
            case 4:
                line += "Sau đại học";
                break;
            default:
                System.out.println("Lựa chọn của bạn không đúng!");
        }
        return line;
    }

    public String employeePosition() {
        System.out.println("-----Vị trí----- ");
        System.out.println("1. Lễ tân ");
        System.out.println("2. Phục vụ ");
        System.out.println("3. Chuyên viên ");
        System.out.println("4. Giám sát ");
        System.out.println("5. Quản lí ");
        System.out.println("6. Giám đốc ");
        System.out.println("Vui lòng chọn trình độ của nhân viên 1->4: ");
        int choice = Integer.parseInt(scanner.nextLine());
        String line = "";
        switch (choice) {
            case 1:
                line += "Lễ tân";
                break;
            case 2:
                line += "Phục vụ";
                break;
            case 3:
                line += "Chuyên viên";
                break;
            case 4:
                line += "Giám sát";
                break;
            case 5:
                line += "Quản lí";
                break;
            case 6:
                line += "Giám đốc";
                break;
            default:
                System.out.println("Lựa chọn của bạn không đúng!");
        }
        return line;
    }

    @Override
    public void editEmployee() {
        Employee employee = findEmployee();

        if (employee == null) {
            System.out.println("Nhân viên không tồn tại trong danh sách!");
            return;
        }

        do {
            System.out.println("Nhân viên cần chỉnh sửa");
            System.out.println(employee.toString());
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. Mã nhân viên");
            System.out.println("2. Họ và tên");
            System.out.println("3. Ngày tháng năm sinh");
            System.out.println("4. Giới tính");
            System.out.println("5. CMND");
            System.out.println("6. Số điện thoại");
            System.out.println("7. Địa chỉ email");
            System.out.println("8. Trình độ");
            System.out.println("9. Vị trí ");
            System.out.println("10. Lương ");
            System.out.println("11. Thoát");
            System.out.println("Vui lòng chọn nội dung cần chỉnh sửa 1->11: ");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    employee.setId(getEditInfo("mã nhân viên"));
                    break;
                case 2:
                    employee.setName(getEditInfo("họ và tên"));
                    break;
                case 3:
                    employee.setDateOfBirth(getEditInfo("ngày tháng năm sinh"));
                    break;
                case 4:
                    employee.setGender(getEditInfo("giới tính"));
                    break;
                case 5:
                    employee.setIdentityCard(getEditInfo("CMND"));
                    break;
                case 6:
                    employee.setPhoneNumber(Integer.parseInt(getEditInfo("số điện thoại")));
                    break;
                case 7:
                    employee.setEmail(getEditInfo("địa chỉ email"));
                    break;
                case 8:
                    employee.setLevel(getEditInfo("trình độ"));
                    break;
                case 9:
                    employee.setPosition(getEditInfo("vị trí"));
                    break;
                case 10:
                    employee.setSalary(getEditInfo("lương"));
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Chức năng bạn chọn không có trong menu!");
            }
            System.out.println("Chỉnh sửa thành công!");
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.println("Vui lòng chọn 1(Có) - 2(Không)");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    public String getEditInfo(String string) {
        System.out.println("Vui lòng nhập " + string + " mới: ");
        return scanner.nextLine();
    }

    private Employee findEmployee() {
        System.out.println("Mời bạn nhập mã nhân viên: ");
        String id = scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                return employees.get(i);
            }
        }
        return null;
    }

    @Override
    public void returnMainMenu() {
        FuramaController.displayMainMenu();
    }
}
