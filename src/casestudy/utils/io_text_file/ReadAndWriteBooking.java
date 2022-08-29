package casestudy.utils.io_text_file;

import casestudy.models.Booking;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReadAndWriteBooking {
    public static Set<Booking> readBookingFile(String path) {
        Set<Booking> bookings = new TreeSet<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                bookings.add(new Booking(info[0], LocalDate.parse(info[1]), LocalDate.parse(info[2]), info[3], info[4],
                        info[5]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public static void writeBookingFile(String path, Set<Booking> bookings, boolean append) {
        File file = new File(path);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        List<String> strings = new ArrayList<>();
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking: bookings) {
                strings.add(booking.toString());
            }
            for(String string: strings){
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
