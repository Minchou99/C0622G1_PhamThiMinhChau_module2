package ss17_io_binary_file_serialization.exercise.copy_binary_file.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vui lòng nhập file nguồn: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Vui lòng nhập file đích: ");
        String destPath = scanner.nextLine();

        File inputStream = new File(sourcePath);
        List<String> files = readFile(sourcePath);
        writeFile(destPath, files);

        System.out.println("Chiều dài của file là: " + inputStream.length());
        System.out.println("Sao chép file thành công!");
    }

    public static void writeFile(String destPath, List<String> files) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(destPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(files);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String path) {
        List<String> files = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            files = (List<String>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return files;
    }
}
