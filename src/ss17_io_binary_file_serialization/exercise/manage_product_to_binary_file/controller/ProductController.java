package ss17_io_binary_file_serialization.exercise.manage_product_to_binary_file.controller;

import ss17_io_binary_file_serialization.exercise.manage_product_to_binary_file.service.IProductService;
import ss17_io_binary_file_serialization.exercise.manage_product_to_binary_file.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    public static final IProductService productService = new ProductService();

    public void managementProduct() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với hệ thống quản lí sản phẩm của MinChou");
            System.out.println("1. Hiển thị sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Tìm kiếm thông tin sản phẩm ");
            System.out.println("4. Thoát ");
            System.out.print("Mời bạn nhập chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.displayProduct();
                    break;
                case 2:
                    productService.addNewProduct();
                    break;
                case 3:
                    productService.findProduct();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }

}
