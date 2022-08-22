package untils.io_text_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {
    public static List<String> readFile(String path) {

        List<String> stringList = new ArrayList<>();
//        bufferedReader.readLine();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không đọc được file hoặc file không tồn tại.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
