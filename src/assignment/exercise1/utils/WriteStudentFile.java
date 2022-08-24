package assignment.exercise1.utils;

import assignment.exercise1.model.Student;
import untils.io_text_file.WriteFileUtil;

import java.util.List;

public class WriteStudentFile {
    public void writeStudentFile(String path, List<Student> studentList) {
        String data = "id,name,dateOfBirth,gender,score,className\n";

        for (Student student : studentList) {
            data += student.toString() + "\n";
        }

        WriteFileUtil.writeFile(path, data);
    }
}
