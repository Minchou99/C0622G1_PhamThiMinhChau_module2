package casestudy.utils.io_text_file;

import casestudy.models.person.Customer;

import java.io.*;

import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteCustomer {
    public static List<Customer> readCustomerFile(String path) {
        List<Customer> customers = new LinkedList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                customers.add(new Customer(info[0], info[1], info[2], info[3], info[4],
                        info[5], info[6], info[7], info[8]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void writeCustomerFile(String path, List<Customer> customers, boolean append) {
        File file = new File(path);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < customers.size(); i++) {
                bufferedWriter.write(String.valueOf(customers.get(i)));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
