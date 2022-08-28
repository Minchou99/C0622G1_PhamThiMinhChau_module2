package casestudy.controllers;

import casestudy.services.IBookingService;
import casestudy.services.impl.BookingService;
import casestudy.utils.exception.BookingException;

import java.util.Scanner;

public class BookingController {
    private static Scanner scanner = new Scanner(System.in);
    private static IBookingService bookingService = new BookingService();

    public static void managementBooking() {
        while (true) {
            int choice;
            while (true) {
                try {
                    System.out.println("--------------------------------------");
                    System.out.println("Chào mừng bạn đến với hệ thống quản lí đặt phòng của FURAMA");
                    System.out.println("1. Thêm mới đặt phòng");
                    System.out.println("2. Hiển thị danh sách đặt phòng");
                    System.out.println("3. Tạo mới hợp đồng");
                    System.out.println("4. Hiển thị danh sách hợp đồng");
                    System.out.println("5. Chỉnh sửa hợp đồng");
                    System.out.println("6. Trở về hệ thống quản lí chính");
                    System.out.println("Mời bạn nhập chức năng 1 -> 6: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 6) {
                        throw new BookingException("Bạn nhập sai. Vui lòng nhập số lớn hơn 0 và nhỏ hơn 7");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập không đúng yêu cầu. Vui lòng nhập số.");
                } catch (BookingException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Bạn nhập không hợp lệ.");
                }
            }

            switch (choice) {
                case 1:
                    bookingService.addNewBooking();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    break;
                case 3:
                    bookingService.createNewConstracts();
                    break;
                case 4:
                    bookingService.displayListContracts();
                    break;
                case 5:
                    bookingService.editContracts();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng.");
            }
        }
    }
}
