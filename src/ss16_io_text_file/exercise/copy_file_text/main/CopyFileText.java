package ss16_io_text_file.exercise.copy_file_text.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn file nguồn: ");
        String filePath = scanner.nextLine();
        List<String> names = readNameFile(filePath);

        System.out.println("Nhập đường dẫn file đích: ");
        String targetPath = scanner.nextLine();
        writeNameFile(targetPath, names);
    }

    public static List<String> readNameFile(String nameFilePath) {
        List<String> names = new ArrayList<>();

        try {
            File nameFile = new File(nameFilePath);

            if (!nameFile.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader(nameFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    names.add(line);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại or nội dung có lỗi.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    public static void writeNameFile(String nameFilePath, List<String> names) {
        try {
            int sum = 0;
            File nameFile = new File(nameFilePath);

            if (nameFile.exists()) {
                throw new Exception();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFilePath));

            for (String name : names) {
                for (int i = 0; i < name.length(); i++) {
                    sum += 1;
                }
                bufferedWriter.write(name);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Tổng kí tự có trong file là: " + sum);
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("File đã tồn tại!");
        }
    }
}
