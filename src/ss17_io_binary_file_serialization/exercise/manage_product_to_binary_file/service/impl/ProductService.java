package ss17_io_binary_file_serialization.exercise.manage_product_to_binary_file.service.impl;

import ss17_io_binary_file_serialization.exercise.manage_product_to_binary_file.model.Product;
import ss17_io_binary_file_serialization.exercise.manage_product_to_binary_file.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    public static final String path = "src\\ss17_io_binary_file_serialization\\exercise\\manage_product_to_binary_file\\data\\product.dat";
    List<Product> products = new ArrayList<>(0);

    public static void writeFile(String path, List<Product> products) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readFile(String path) {
        List<Product> products = new ArrayList<>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                products = (List<Product>) objectInputStream.readObject();
                objectInputStream.close();

                return products;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public void displayProduct() {
        products = readFile(path);
        System.out.println("Danh sách sản phẩm");

        if (products.size() == 0) {
            System.out.println("Danh sách rỗng");
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void addNewProduct() {
        products = readFile(path);
        Product product = this.infoProduct();
        products.add(product);
        System.out.println("Thêm mới sản phẩm thành công!");
        System.out.println("Danh sách sản phẩm sau khi thêm mới");
        writeFile(path, products);
        displayProduct();
    }

    public Product infoProduct() {
        System.out.println("Mời bạn nhập mã sản phẩm: ");
        String productCode = scanner.nextLine();
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.println("Mời bạn nhập hãng sản phẩm: ");
        String manufacturer = scanner.nextLine();
        System.out.println("Mời bạn nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(productCode, productName, manufacturer, price);
        return product;
    }

    @Override
    public void findProduct() {
        products = readFile(path);
        System.out.println("Mời bạn nhập mã sản phẩm: ");
        String productCode = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductCode().equals(productCode)) {
                System.out.println(products.get(i).toString());
                break;
            }
        }
    }
}
