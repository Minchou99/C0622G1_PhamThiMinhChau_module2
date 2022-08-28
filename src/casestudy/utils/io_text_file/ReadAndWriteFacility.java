package casestudy.utils.io_text_file;

import casestudy.models.facility.Facility;
import casestudy.models.facility.House;
import casestudy.models.facility.Room;
import casestudy.models.facility.Villa;

import java.io.*;
import java.util.*;

public class ReadAndWriteFacility {
    public static Map<Facility, Integer> readFacilityFile(String path) {
        Map<Facility, Integer> facilities = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                if (info.length == 10) {
                    facilities.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8])), Integer.parseInt(info[9]));
                } else if (info.length == 9) {
                    facilities.put(new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
                } else if (info.length == 8) {
                    facilities.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilities;
    }

    public static void writeFacilityFile(String path, Map<Facility, Integer> facilities, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Facility> facilitySet = facilities.keySet();
        for (Facility facility : facilitySet) {
            stringList.add(facility.toString() + "," + facilities.get(facility));
        }
        File file = new File(path);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
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
