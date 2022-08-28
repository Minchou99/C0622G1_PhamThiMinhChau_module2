package casestudy.services.impl;

import casestudy.controllers.FacilityController;
import casestudy.models.facility.Facility;
import casestudy.models.facility.House;
import casestudy.models.facility.Room;
import casestudy.models.facility.Villa;
import casestudy.services.IFacilityService;
import casestudy.utils.io_text_file.ReadAndWriteFacility;

import java.util.*;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PATH_VILLA = "src\\casestudy\\data\\villa.csv";
    private static final String PATH_HOUSE = "src\\casestudy\\data\\house.csv";
    private static final String PATH_ROOM = "src\\casestudy\\data\\room.csv";

    @Override
    public void displayListFacility() {
        int choice;
        do {
            while (true) {
                try {
                    System.out.println("Danh sách cơ sở vật chất");
                    System.out.println("1. Villa");
                    System.out.println("2. House");
                    System.out.println("3. Room");
                    System.out.println("4. Trở về menu chính");
                    System.out.print("Vui lòng chọn mục bạn muốn hiển thị (1->4): ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                }
            }

            switch (choice) {
                case 1:
                    Map<Facility, Integer> villas = ReadAndWriteFacility.readFacilityFile(PATH_VILLA);

                    if (villas.isEmpty()) {
                        System.out.println("Danh sách villa trống.");
                    } else {
                        for (Facility villa : villas.keySet()) {
                            System.out.println(villa + " được sử dụng là: " + villas.get(villa));
                        }
                    }
                    break;
                case 2:
                    Map<Facility, Integer> houses = ReadAndWriteFacility.readFacilityFile(PATH_HOUSE);
                    if (houses.isEmpty()) {
                        System.out.println("Danh sách house trống");
                    } else {
                        for (Facility house : houses.keySet()) {
                            System.out.println(house + " được sử dụng là: " + houses.get(house));
                        }
                    }
                    break;
                case 3:
                    Map<Facility, Integer> rooms = ReadAndWriteFacility.readFacilityFile(PATH_ROOM);
                    if (rooms.isEmpty()) {
                        System.out.println("Danh sách phòng trống");
                    } else {
                        for (Facility room : rooms.keySet()) {
                            System.out.println(room + " số lượng ");
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Số bạn chọn không đúng. Vui lòng nhập lại.");
            }
        } while (true);
    }

    @Override
    public void addNewFacility() {
        System.out.println("-----Dịch vụ-----");
        System.out.println("1. Thêm mới Villa");
        System.out.println("2. Thêm mới House");
        System.out.println("3. Thêm mới Room");
        System.out.println("4. Trở về menu chính");
        System.out.print("Vui lòng chọn dịch vụ muốn thêm mới (1->4): ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                FacilityController.managementFacility();
                break;

        }
    }

    private void addNewRoom() {
        Map<Facility, Integer> rooms = new LinkedHashMap<>();
        System.out.print("Mời bạn nhập mã dịch vụ phòng");
        String serviceCode = scanner.nextLine();
        System.out.print("Mời bạn nhập tên dịch vụ");
        String serviceName = scanner.nextLine();
        System.out.print("Mời bạn nhập diện tích phòng");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập giá phòng");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập số lượng người thuê");
        int amountOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập kiểu thuê ");
        String rentalType = scanner.nextLine();
        System.out.println("Mời bạn nhập dịch vụ miễn phí đi kèm");
        String freeStuff = scanner.nextLine();
        Room room = new Room(serviceCode, serviceName, area, price, amountOfPeople, rentalType, freeStuff);
        rooms.put(room, 1);
        ReadAndWriteFacility.writeFacilityFile(PATH_ROOM, rooms, true);
        System.out.println("Thêm mới phòng thành công");
    }

    private void addNewHouse() {
        Map<Facility, Integer> houses = new LinkedHashMap<>();
        System.out.print("Mời bạn nhập mã dịch vụ phòng");
        String serviceCode = scanner.nextLine();
        System.out.print("Mời bạn nhập tên dịch vụ");
        String serviceName = scanner.nextLine();
        System.out.print("Mời bạn nhập diện tích phòng");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập giá phòng");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập số lượng người thuê");
        int amountOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập kiểu thuê ");
        String rentalType = scanner.nextLine();
        System.out.println("Mời bạn nhập tiêu chuẩn phòng");
        String roomStandard = scanner.nextLine();
        System.out.println("Mời bạn nhập số tầng");
        int floor = Integer.parseInt(scanner.nextLine());
        House house = new House(serviceCode, serviceName, area, price, amountOfPeople, rentalType, roomStandard, floor);
        houses.put(house, 1);
        ReadAndWriteFacility.writeFacilityFile(PATH_HOUSE, houses, true);
        System.out.println("Thêm mới nhà thành công");
    }

    private void addNewVilla() {
        Map<Facility, Integer> villas = new LinkedHashMap<>();
        System.out.print("Mời bạn nhập mã dịch vụ phòng");
        String serviceCode = scanner.nextLine();
        System.out.print("Mời bạn nhập tên dịch vụ");
        String serviceName = scanner.nextLine();
        System.out.print("Mời bạn nhập diện tích phòng");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập giá phòng");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập số lượng người thuê");
        int amountOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập kiểu thuê ");
        String rentalType = scanner.nextLine();
        System.out.println("Mời bạn nhập tiêu chuẩn phòng");
        String roomStandard = scanner.nextLine();
        System.out.println("Mời bạn nhập diện tích hồ bơi");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập số tầng");
        int floor = Integer.parseInt(scanner.nextLine());
        Villa villa = new Villa(serviceCode, serviceName, area, price, amountOfPeople, rentalType, roomStandard, poolArea, floor);
        villas.put(villa, 1);
        ReadAndWriteFacility.writeFacilityFile(PATH_VILLA, villas, true);
        System.out.println("Thêm mới villa thành công");
    }


    @Override
    public void displayListFacilityMaintenance() {
        int choice;
        do {
            while (true) {
                try {
                    System.out.println("Danh sách cơ sở vật chất đang bảo trì");
                    System.out.println("1. Villa");
                    System.out.println("2. House");
                    System.out.println("3. Room");
                    System.out.println("4. Trở về menu chính");
                    System.out.println("Vui lòng chọn mục bạn muốn hiển thị");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                }
            }

            switch (choice) {
                case 1:
                    Map<Facility, Integer> villas = ReadAndWriteFacility.readFacilityFile(PATH_VILLA);
                    if (villas.isEmpty()) {
                        System.out.println("Không có villa nào đang được bảo trì");
                    } else {
                        for (Facility villa : villas.keySet()) {
                            if (villas.get(villa) > 4) {
                                System.out.println(villa + " được sử dụng: " + villas.get(villa));
                            } else {
                                System.out.println("Không có villa nào cần được bảo trì");
                            }
                        }
                    }
                    break;
                case 2:
                    Map<Facility, Integer> houses = ReadAndWriteFacility.readFacilityFile(PATH_HOUSE);
                    if (houses.isEmpty()) {
                        System.out.println("Không có house nào đang được bảo trì");
                    } else {
                        for (Facility house : houses.keySet()) {
                            if (houses.get(house) > 4) {
                                System.out.println(house + " được sử dụng: " + houses.get(house));
                            } else {
                                System.out.println("Không có house nào cần được bảo trì");
                            }
                        }
                    }
                    break;
                case 3:
                    Map<Facility, Integer> rooms = ReadAndWriteFacility.readFacilityFile(PATH_ROOM);
                    if (rooms.isEmpty()) {
                        System.out.println("Không có phòng nào đang được bảo trì");
                    } else {
                        for (Facility room : rooms.keySet()) {
                            if (rooms.get(room) > 4) {
                                System.out.println(room + " được sử dụng: " + rooms.get(room));
                            } else {
                                System.out.println("Không có phòng nào cần được bảo trì");
                            }
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không đúng. Vui lòng chọn lại");
            }
        } while (true);
    }
}
