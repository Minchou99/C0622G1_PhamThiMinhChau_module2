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
        System.out.println("Danh s??ch s???n ph???m");

        if (products.size() == 0) {
            System.out.println("Danh s??ch r???ng");
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
        System.out.println("Th??m m???i s???n ph???m th??nh c??ng!");
        System.out.println("Danh s??ch s???n ph???m sau khi th??m m???i");
        writeFile(path, products);
        displayProduct();
    }

    public Product infoProduct() {
        System.out.println("M???i b???n nh???p m?? s???n ph???m: ");
        String productCode = scanner.nextLine();
        System.out.println("M???i b???n nh???p t??n s???n ph???m: ");
        String productName = scanner.nextLine();
        System.out.println("M???i b???n nh???p h??ng s???n ph???m: ");
        String manufacturer = scanner.nextLine();
        System.out.println("M???i b???n nh???p gi?? s???n ph???m: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(productCode, productName, manufacturer, price);
        return product;
    }

    @Override
    public void findProduct() {
        products = readFile(path);
        System.out.println("M???i b???n nh???p m?? s???n ph???m: ");
        String productCode = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductCode().equals(productCode)) {
                System.out.println(products.get(i).toString());
                break;
            }
        }
    }
}
