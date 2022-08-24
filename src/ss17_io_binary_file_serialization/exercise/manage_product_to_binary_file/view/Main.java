package ss17_io_binary_file_serialization.exercise.manage_product_to_binary_file.view;

import ss17_io_binary_file_serialization.exercise.manage_product_to_binary_file.controller.ProductController;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.managementProduct();
    }
}
