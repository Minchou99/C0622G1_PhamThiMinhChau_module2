package assignment.exercise1.utils;

import assignment.exercise1.model.Student;
import untils.io_text_file.ReadFileUtil;

import java.util.ArrayList;
import java.util.List;

public class ReadStudentFile {
    public List<Student> readStudentFile(String path) {
        List<String> strings = ReadFileUtil.readFile(path);
        List<Student> students = new ArrayList<>();

        String[] info;
        for (String line : strings) {
            info = line.split(",");
            students.add(new Student(info[0], info[1], info[2],
                    info[3], Double.parseDouble(info[4]), info[5]));
        }
        return students;
    }
}
