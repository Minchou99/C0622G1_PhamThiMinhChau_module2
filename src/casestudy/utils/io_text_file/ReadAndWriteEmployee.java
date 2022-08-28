package casestudy.utils.io_text_file;

import casestudy.models.person.Customer;
import casestudy.models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployee {
    public static List<Employee> readEmployeeFile(String path) {
        List<Employee> employees = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                employees.add(new Employee(info[0], info[1], info[2], info[3], info[4], Double.parseDouble(info[5]), info[6], info[7], info[8], info[9]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void writeEmployeeFile(String path, List<Employee> employees, boolean append) {
        File file = new File(path);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < employees.size(); i++) {
                bufferedWriter.write(String.valueOf(employees.get(i)));
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
