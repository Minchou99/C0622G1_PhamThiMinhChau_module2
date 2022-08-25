package casestudy.services.impl;

import casestudy.controllers.FuramaController;
import casestudy.models.person.Customer;
import casestudy.services.ICustomerService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customers = new LinkedList<>();

    static {
        customers.add(new Customer("12", "Nam", "29/09/23", "Nam", "1234567", 02345, "thavksjbc", "bâcn", "had noi"));
    }

    @Override
    public void displayListCustomer() {
        System.out.println("Danh sách khách hàng");

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
        System.out.println("Thêm mới khách hàng thành công!");
        System.out.println("Danh sách sau khi thêm");
        displayListCustomer();

    }

    private Customer infoCustomer() {
        System.out.println("Mời bạn nhập mã khách hàng: ");
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
        System.out.println("Mời bạn nhập loại khách");
        String customerType = customerType();
        System.out.println("Mời bạn nhập địa chỉ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, dateOfBirth, gender, identityCard, phoneNumber, email, customerType, address);
        return customer;
    }

    public String customerType() {
        System.out.println("-----Loại khách-----");
        System.out.println("1. Diamond");
        System.out.println("2. Platinum");
        System.out.println("3. Gold");
        System.out.println("4. Silver");
        System.out.println("5. Member");
        System.out.print("Vui lòng chọn loại khách phù hợp (1->5): ");
        int choice = Integer.parseInt(scanner.nextLine());
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
                    customer.setPhoneNumber(Integer.parseInt(getEditInfo("số điện thoại")));
                    break;
                case 7:
                    customer.setEmail(getEditInfo("địa chỉ email"));
                    break;
                case 8:
                    customer.setCustomerType(getEditInfo("loại khách"));
                    break;
                case 9:
                    customer.setAddress(getEditInfo("địa chỉ"));
                    break;
                case 10:
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

    private Customer findCustomer() {
        System.out.println("Mời bạn nhập mã khách hàng: ");
        String id = scanner.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(id)) {
                return customers.get(i);
            }
        }
        return null;
    }

    public String getEditInfo(String string) {
        System.out.println("Vui lòng nhập " + string + " mới: ");
        return scanner.nextLine();
    }

    @Override
    public void returnMainMenu() {
        FuramaController.displayMainMenu();
    }
}
