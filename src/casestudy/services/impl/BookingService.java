package casestudy.services.impl;

import casestudy.controllers.FuramaController;
import casestudy.models.Booking;
import casestudy.services.IBookingService;
import casestudy.services.ICustomerService;
import casestudy.services.IFacilityService;
import casestudy.utils.io_text_file.ReadAndWriteBooking;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingService implements IBookingService {
    private static Scanner scanner = new Scanner(System.in);
    private static ICustomerService customerService = new CustomerService();
    private static IFacilityService facilityService = new FacilityService();
    private static final String BOOKING_PATH = "src\\casestudy\\data\\booking.csv";

    @Override
    public void addNewBooking() {
        Set<Booking> bookings = new TreeSet<>();
        System.out.println("Nhập mã booking");
        String bookingId = scanner.nextLine();

        LocalDate startDay;
        while (true) {
            try {
                System.out.println("Nhập ngày bắt đầu");
                startDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Nhập sai định dạng");
            }
        }

        LocalDate endDay;
        while (true) {
            try {
                System.out.println("Nhập ngày kết thúc");
                endDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Nhập sai định dạng");
            }
        }

        System.out.println("Nhập mã khách hàng");
        String customerId = scanner.nextLine();

        System.out.println("Nhập tên dịch vụ");
        String serviceName = scanner.nextLine();

        System.out.println("Nhập loại dịch vụ");
        String serviceType = scanner.nextLine();

        bookings.add(new Booking(bookingId, startDay, endDay, customerId, serviceName, serviceType));
        ReadAndWriteBooking.writeBookingFile(BOOKING_PATH, bookings, true);
    }

    @Override
    public void displayListBooking() {
        Set<Booking> bookings = ReadAndWriteBooking.readBookingFile(BOOKING_PATH);
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    @Override
    public void createNewConstracts() {

    }

    @Override
    public void displayListContracts() {

    }

    @Override
    public void editContracts() {

    }
}
