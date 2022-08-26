package casestudy.services.impl;

import casestudy.controllers.FacilityController;
import casestudy.controllers.FuramaController;
import casestudy.models.facility.Facility;
import casestudy.models.facility.House;
import casestudy.models.facility.Room;
import casestudy.models.facility.Villa;
import casestudy.services.IFacilityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Facility> facilities = new ArrayList<>();
    private static List<Villa> villas = new ArrayList<>();
    private static List<House> houses = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();
    @Override
    public void displayListFacility() {
        System.out.println("Danh sách cơ sở vật chất");
        
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

        switch (choice){
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
        Room room = new Room(serviceCode,serviceName,area,price,amountOfPeople,rentalType,freeStuff);
        rooms.add(room);
        System.out.println("Thêm mới phòng thành công");
        System.out.println("Danh sách sau khi thêm");
        displayListFacility();
    }

    private void addNewHouse() {
    }

    private void addNewVilla() {
    }


    @Override
    public void displayListFacilityMaintenance() {

    }

    @Override
    public void returnMainMenu() {

    }
}
