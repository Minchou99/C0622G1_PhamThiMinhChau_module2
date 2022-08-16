package ss12_collection.controller;

import ss12_collection.service.IBikeService;
import ss12_collection.service.impl.BikeService;

import java.util.Scanner;

public class BikeController {
    public static Scanner scanner = new Scanner(System.in);
    private static final IBikeService bikeService = new BikeService();

    public void menuManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với hệ thống quản lí xe đạp");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo id");
            System.out.println("3. Xóa sản phẩm theo id");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
            System.out.println("7. Exit");
            System.out.print("Mời bạn nhập chức năng 1->7: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bikeService.addBike();
                    break;
                case 2:
                    bikeService.editBike();
                    break;
                case 3:
                    bikeService.removeBike();
                    break;
                case 4:
                    bikeService.displayBike();
                    break;
                case 5:
                    bikeService.findBike();
                    break;
                case 6:
                    bikeService.arrangeBike();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
