package casestudy.utils.io_text_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {
    public static List<String> readFile(String path) {

        List<String> strings = new ArrayList<>();
        String line;
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không đọc được file hoặc file không tồn tại.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
