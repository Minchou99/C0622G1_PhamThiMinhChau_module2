package assignment.exercise1.service.utils;

import assignment.exercise1.model.Student;
import untils.io_text_file.ReadFileUtil;
import java.util.ArrayList;
import java.util.List;

public class ReadStudentFile {
    public List<Student> readStudentFile(String path) {
        List<String> stringList = ReadFileUtil.readFile(path);
        List<Student> studentList = new ArrayList<>();

        String[] info;
        for (String string : stringList) {
            info = string.split(",");
            studentList.add(new Student(Integer.parseInt(info[0]), info[1], info[2], info[3], Double.parseDouble(info[4]), info[5]));
        }
        return studentList;
    }
}
