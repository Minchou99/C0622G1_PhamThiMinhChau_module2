package casestudy.services.impl;

import casestudy.controllers.FuramaController;
import casestudy.models.person.Employee;
import casestudy.services.IEmployeeService;
import casestudy.utils.exception.*;
import casestudy.utils.io_text_file.ReadAndWriteEmployee;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
   private static List<Employee> employees = new ArrayList<>();
   private static final String EMPLOYEE_PATH = "src\\casestudy\\data\\employee.csv";
    @Override
    public void displayListEmployee() {
        employees= ReadAndWriteEmployee.readEmployeeFile(EMPLOYEE_PATH);
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
        Employee employee = infoEmployee();
        employees.add(employee);
        ReadAndWriteEmployee.writeEmployeeFile(EMPLOYEE_PATH,employees,true);
        System.out.println("Thêm mới nhân viên thành công!");
        System.out.println("Danh sách sau khi thêm");
        ReadAndWriteEmployee.readEmployeeFile(EMPLOYEE_PATH);
        displayListEmployee();
    }

    public Employee infoEmployee() {
        String id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã nhân viên: ");
                id = scanner.nextLine();
                for (int i = 0; i < employees.size(); i++) {
                    if (id.equals(employees.get(i).getId())) {
                        throw new IdException("Mã nhân viên này đã tồn tại. Vui lòng nhập mã nhân viên mới.");
                    }
                }

                if (id.equals("")) {
                    throw new SpaceException("Vui lòng nhập mã nhân viên. Không được bỏ trống mục này.");
                }
                break;
            } catch (IdException e) {
                e.getMessage();
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập mã không đúng yêu cầu");
            }
        }

        String name;
        while (true) {
            try {
                System.out.println("Mời bạn nhập Họ và tên: ");
                name = scanner.nextLine();
                if (!(name.matches("^(\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*){5,50}$}"))) {
                    throw new NameException("Vui lòng nhập tên viết hoa chữ cái đầu và tên hơn 5 kí tự và nhỏ hơn 50 kí tụ.");
                }
                if (name.equals("")) {
                    throw new SpaceException("Vui lòng nhập họ và tên nhân viên. Không được bỏ trống mục này.");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
        }

        String dateOfBirth;
        String pattern = "dd/MM/YYYY";
        DateTimeFormatter dateTimeFormatter;
        LocalDate birthday;

        while (true) {
            try {
                System.out.println("Mời bạn nhập ngày tháng năm sinh: ");
                dateOfBirth = scanner.nextLine();
                if (dateOfBirth.matches("^\\W*$")) {
                    throw new AgeException("Vui lòng nhập số, không được nhập chữ.");
                }
                dateTimeFormatter = DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT);
                birthday = LocalDate.parse(dateOfBirth, dateTimeFormatter);

                int age = calculatePeriod(birthday);
                if (age <= 0 || age >= 100) {
                    throw new AgeException("Tuổi bạn nhập không hợp lệ. Vui lòng nhập tuổi lớn hơn 0 và nhỏ hơn 100.");
                }
                if (dateOfBirth.equals("")) {
                    throw new SpaceException("Vui lòng nhập ngày sinh nhân viên. Không được bỏ trống mục này.");
                }
                break;
            } catch (AgeException e) {
                System.out.println(e.getMessage());
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ngày sinh phải có định dạng là dd/MM/yyyy (với dd là ngày, MM là tháng, yyyy là năm)");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ. Vui lòng nhập lại.");
            }
        }

        String gender;
        while (true) {
            try {
                System.out.println("Mời bạn nhập giới tính: ");
                gender = scanner.nextLine();
                if (gender.matches("^\\W*$")) {
                    throw new GenderException("Vui lòng nhập giới tình là Nam, Nữ hoặc Khác. Không được nhập số");
                }
                if (gender.equals("")) {
                    throw new SpaceException("Vui lòng nhập giới tính khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String identityCard;
        while (true) {
            try {
                System.out.println("Mời bạn nhập CMND: ");
                identityCard = scanner.nextLine();
                if (!(identityCard.matches("^[0-9]{9}|[0-9]{12}$"))) {
                    throw new IdentityCardException("Vui lòng nhập số chứng minh nhân dân 9 số hoặc 12 số");
                }
                if (identityCard.equals("")) {
                    throw new SpaceException("Vui lòng nhập CMND khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (IdentityCardException e) {
                System.out.println(e.getMessage());
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai, vui lòng nhập lại.");
            }
        }

        String phoneNumber;
        while (true) {
            try {
                System.out.println("Mời bạn nhập số điện thoại: ");
                phoneNumber = scanner.nextLine();
                if (!(phoneNumber.matches("^\\([+][8][4]\\)[1-9][1-9]{8}$"))) {
                    throw new PhoneNumberException("Vui lòng nhập số điện thoại gồm 9 số với số đầu tiên không phải là số 0");
                }
                if (phoneNumber.equals("")) {
                    throw new SpaceException("Vui lòng nhập số điện thoại khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (PhoneNumberException e) {
                System.out.println(e.getMessage());
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String email;
        while (true) {
            try {
                System.out.println("Mời bạn nhập địa chỉ email: ");
                email = scanner.nextLine();
                if (!(email.matches("^[A-Za-z0-9]+\\@[A-Za-z0-9]+[.][A-Za-z]+$"))) {
                    throw new EmailException("Vui lòng nhập mail theo định dạng abc@gmail.com,ab@yahoo.com,abc@hotmail.com");
                }
                if (email.equals("")) {
                    throw new SpaceException("Vui lòng nhập email khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        System.out.println("Mời bạn nhập trình độ: ");
        String level = employeeLevel();

        System.out.println("Mời bạn nhập vị trí: ");
        String position = employeePosition();

        System.out.println("Mời bạn nhập lương: ");
        String salary = scanner.nextLine();

        Employee employee = new Employee(id, name, dateOfBirth, gender, identityCard, phoneNumber, email, level, position, salary);
        return employee;
    }

    public static int calculatePeriod(LocalDate localDate) {
        LocalDate now = LocalDate.now();
        int age = Period.between(localDate, now).getYears();
        return age;

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
        employees = ReadAndWriteEmployee.readEmployeeFile(EMPLOYEE_PATH);
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
                    employee.setPhoneNumber(getEditInfo("số điện thoại"));
                    break;
                case 7:
                    employee.setEmail(getEditInfo("địa chỉ email"));
                    break;
                case 8:
                    employee.setLevel(employeeLevel());
                    break;
                case 9:
                    employee.setPosition(employeePosition());
                    break;
                case 10:
                    employee.setSalary(getEditInfo("lương"));
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Chức năng bạn chọn không có trong menu!");
            }
            ReadAndWriteEmployee.writeEmployeeFile(EMPLOYEE_PATH,employees,false);
            System.out.println("Chỉnh sửa thành công!");
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.println("Vui lòng chọn 1(Có) - 2(Không)");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    public String getEditInfo(String editContent) {
        System.out.println("Vui lòng nhập " + editContent + " mới: ");
        return scanner.nextLine();
    }

    private Employee findEmployee() {
        employees= ReadAndWriteEmployee.readEmployeeFile(EMPLOYEE_PATH);
        System.out.println("Mời bạn nhập mã nhân viên: ");
        String id = scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                return employees.get(i);
            }
        }
        return null;
    }
}
