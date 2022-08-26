package casestudy.utils.io_text_file;

import assignment.exercise1.model.Student;
import untils.io_text_file.WriteFileUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    public void writeStudentFile(String path, List<Student> studentList) {
        String data = "id,name,dateOfBirth,gender,score,className\n";

        for (Student student : studentList) {
            data += student.toString() + "\n";
        }

        WriteFileUtil.writeFile(path, data);
    }
}
