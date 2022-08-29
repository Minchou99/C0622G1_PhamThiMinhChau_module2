package casestudy.services.impl;

import casestudy.models.person.Customer;
import casestudy.services.ICustomerService;
import casestudy.utils.exception.*;
import casestudy.utils.io_text_file.ReadAndWriteCustomer;
import ss19_string_regex.exercise.phone_number.PhoneNumber;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.*;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customers = new LinkedList<>();
    private static final String CUSTOMER_PATH = "src\\casestudy\\data\\customer.csv";

    @Override
    public void displayListCustomer() {
        System.out.println("Danh sách khách hàng");
        customers = ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        if (customers.size() == 0) {
            System.out.println("Danh sách rỗng");
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void addNewCustomer() {
        Customer customer = this.infoCustomer();
        customers.add(customer);
        ReadAndWriteCustomer.writeCustomerFile(CUSTOMER_PATH, customers, true);
        System.out.println("Thêm mới khách hàng thành công!");
        System.out.println("Danh sách sau khi thêm");
        ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        displayListCustomer();
    }

    private Customer infoCustomer() {
        String id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã khách hàng: ");
                id = scanner.nextLine();
                for (int i = 0; i < customers.size(); i++) {
                    if (id.equals(customers.get(i).getId())) {
                        throw new IdException("Mã khách hàng này đã tồn tại. Vui lòng nhập mã khách hàng mới.");
                    }
                }

                if (id.equals("")) {
                    throw new SpaceException("Vui lòng nhập mã khách hàng. Không được bỏ trống mục này.");
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
                    throw new SpaceException("Vui lòng nhập họ và tên khách hàng. Không được bỏ trống mục này.");
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
                    throw new SpaceException("Vui lòng nhập ngày sinh khách hàng. Không được bỏ trống mục này.");
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

        System.out.println("Mời bạn nhập loại khách");
        String customerType = customerType();

        String address;
        while (true) {
            try {
                System.out.println("Mời bạn nhập địa chỉ");
                address = scanner.nextLine();
                if (address.equals("")) {
                    throw new SpaceException("Vui lòng nhập địa chỉ khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        Customer customer = new Customer(id, name, dateOfBirth, gender, identityCard, phoneNumber, email, customerType, address);
        return customer;
    }

    public static int calculatePeriod(LocalDate localDate) {
        LocalDate now = LocalDate.now();
        int age = Period.between(localDate, now).getYears();
        return age;

    }

    public String customerType() {
        int choice;
        while (true) {
            try {
                System.out.println("-----Loại khách-----");
                System.out.println("1. Diamond");
                System.out.println("2. Platinum");
                System.out.println("3. Gold");
                System.out.println("4. Silver");
                System.out.println("5. Member");
                System.out.print("Vui lòng chọn loại khách phù hợp (1->5): ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 5) {
                    throw new CustomerException("Vui lòng chọn chức năng từ 1->5");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (CustomerException e) {
                System.out.println(e.getMessage());
            }
        }

        String line = "";
        switch (choice) {
            case 1:
                line += "Diamond";
                break;
            case 2:
                line += "Platinum";
                break;
            case 3:
                line += "Gold";
                break;
            case 4:
                line += "Silver";
                break;
            case 5:
                line += "Member";
                break;
        }
        return line;

    }

    @Override
    public void editCustomer() {
        customers = ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        Customer customer = findCustomer();

        if (customer == null) {
            System.out.println("Khách hàng không tồn tại trong danh sách!");
            return;
        }

        do {
            System.out.println("Nhân viên cần chỉnh sửa");
            System.out.println(customer.toString());
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. Mã khách hàng");
            System.out.println("2. Họ và tên");
            System.out.println("3. Ngày tháng năm sinh");
            System.out.println("4. Giới tính");
            System.out.println("5. CMND");
            System.out.println("6. Số điện thoại");
            System.out.println("7. Địa chỉ email");
            System.out.println("8. Loại khách");
            System.out.println("9. Địa chỉ ");
            System.out.println("10. Thoát");
            System.out.println("Vui lòng chọn nội dung cần chỉnh sửa 1->10: ");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    customer.setId(getEditInfo("mã nhân viên"));
                    break;
                case 2:
                    customer.setName(getEditInfo("họ và tên"));
                    break;
                case 3:
                    customer.setDateOfBirth(getEditInfo("ngày tháng năm sinh"));
                    break;
                case 4:
                    customer.setGender(getEditInfo("giới tính"));
                    break;
                case 5:
                    customer.setIdentityCard(getEditInfo("CMND"));
                    break;
                case 6:
                    customer.setPhoneNumber(getEditInfo("số điện thoại"));
                    break;
                case 7:
                    customer.setEmail(getEditInfo("địa chỉ email"));
                    break;
                case 8:
                    customer.setCustomerType(customerType());
                    break;
                case 9:
                    customer.setAddress(getEditInfo("địa chỉ"));
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Chức năng bạn chọn không có trong menu!");
            }
            ReadAndWriteCustomer.writeCustomerFile(CUSTOMER_PATH, customers, false);
            System.out.println("Chỉnh sửa thành công!");
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.println("Vui lòng chọn 1(Có) - 2(Không)");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    private Customer findCustomer() {
        customers = ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        System.out.println("Mời bạn nhập mã khách hàng: ");
        String id = scanner.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(id)) {
                return customers.get(i);
            }
        }
        return null;
    }

    public String getEditInfo(String editContent) {
        System.out.println("Vui lòng nhập " + editContent + " mới: ");
        return scanner.nextLine();
    }
}
