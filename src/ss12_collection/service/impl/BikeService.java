package ss12_collection.service.impl;

import ss12_collection.model.Bike;
import ss12_collection.service.IBikeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BikeService implements IBikeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Bike> bikes = new ArrayList<>();

    static {
        Bike bike1 = new Bike("1", "Xe tập đi", "Xanh", "Thái Lan", "Yamaha", 2000);
        Bike bike2 = new Bike("2", "Xe cho bé 5 tuổi", "Xanh", "Thái Lan", "Yamaha", 3000);
        Bike bike3 = new Bike("3", "Xe cho bé 10 tuổi", "Xanh", "Thái Lan", "Yamaha", 5000);

        bikes.add(bike1);
        bikes.add(bike2);
        bikes.add(bike3);
    }

    @Override
    public void addBike() {
        Bike bike = this.infoBike();
        bikes.add(bike);
        System.out.println("Thêm mới sản phẩm thành công");
    }

    private Bike infoBike() {
        System.out.print("Mời bạn nhập id: ");
        String id = scanner.nextLine();
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập màu: ");
        String color = scanner.nextLine();
        System.out.print("Mời bạn nhập nguồn gốc: ");
        String origin = scanner.nextLine();
        System.out.print("Mời bạn nhập hãng: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Mời bạn nhập giá: ");
        int price = Integer.parseInt(scanner.nextLine());
        Bike bike = new Bike(id, name, color, origin, manufacturer, price);
        return bike;
    }

    @Override
    public void editBike() {
        Bike bike = findBikeInList();
        int choose;
        do {
            System.out.println("Sản phẩm cần chỉnh sửa: ");
            System.out.println(bike.toString());
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. ID");
            System.out.println("2. Tên sản phẩm");
            System.out.println("3. Màu sắc");
            System.out.println("4. Nguồn gốc");
            System.out.println("5. Hãng");
            System.out.println("6. Giá");
            System.out.println("7. Thoát");
            System.out.println("Chọn nội dung cần chỉnh sửa 1 -> 7: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    bike.setId(getEditInfo("ID"));
                    break;
                case 2:
                    bike.setName(getEditInfo("Tên Sản phẩm"));
                    break;
                case 3:
                    bike.setColor(getEditInfo("Màu sắc"));
                    break;
                case 4:
                    bike.setOrigin(getEditInfo("Nguồn gốc"));
                    break;
                case 5:
                    bike.setManufacturer(getEditInfo("Hãng"));
                    break;
                case 6:
                    bike.setPrice(Integer.parseInt(getEditInfo("Giá")));
                    break;
                case 7:
                    return;
            }
            System.out.println("Chỉnh sửa thành công!");
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.println("Vui lòng chọn 1 (Có) - 2 (Không)");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    private String getEditInfo(String content) {
        System.out.print("Vui lòng nhập " + content + " mới: ");
        return scanner.nextLine();
    }

    @Override
    public void removeBike() {
        Bike bike = this.findBikeInList();
        if (bike == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + bike.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                bikes.remove(bike);
                System.out.println("Xóa thành công!");
            }
        }
    }

    @Override
    public void displayBike() {
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
    }

    @Override
    public void findBike() {
        System.out.println("Mời bạn nhập vào id cần tìm");
        String idFind = scanner.nextLine();

        for (Bike bike : bikes) {
            if (bike.getId().equals(idFind)) {
                System.out.println(bike.toString());
            }
        }
    }

    public Bike findBikeInList() {
        System.out.println("Mời bạn nhập vào id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < bikes.size(); i++) {
            if (bikes.get(i).getId().equals(id)) {
                return bikes.get(i);
            }
        }
        return null;
    }

    @Override
    public void arrangeBike() {
        System.out.print("Bạn muốn sắp xếp theo giảm dần hay tăng dần? \n Vui lòng chọn 1 (Tăng dần) - 2 (Giảm dần): ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Collections.sort(bikes, new BikeComparator());
                System.out.println("Sắp xếp thành công!");
                break;
            case 2:
                Collections.sort(bikes, new BikeComparator().reversed());
                System.out.println("Sắp xếp thành công!");
                break;
        }
    }
}
