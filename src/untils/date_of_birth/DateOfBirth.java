package untils.date_of_birth;

import java.time.LocalDate;
import java.time.Period;

public class DateOfBirth {
    public static int calculatePeriod(LocalDate localDate) {
        LocalDate now = LocalDate.now();
        int age = Period.between(localDate, now).getYears();
        return age;

    }
//
//    String studentDateOfBirth;
//    String pattern = "dd/MM/uuuu";
//    DateTimeFormatter dateTimeFormatter;
//    LocalDate birthday;
//
//
//     while (true) {
//        try {
//            System.out.println("Mời bạn nhập ngày tháng năm sinh của học sinh: ");
//            studentDateOfBirth = scanner.nextLine();
//            dateTimeFormatter = DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT);
//            birthday = LocalDate.parse(studentDateOfBirth, dateTimeFormatter);
//
//            int age = calculatePeriod(birthday);
//            if (age <= 0 || age >= 100) {
//                throw new AgeException("Tuổi hợp lệ phải lớn hơn 0 và nhỏ hơn 100");
//            }
//            break;
//        } catch (AgeException e) {
//            System.out.println(e.getMessage());
//        } catch (NumberFormatException e) {
//            System.out.println("Ngày sinh phải có định dạng dd/MM/yyyy");
//        } catch
//        (InputMismatchException e) {
//            System.out.println("Thông tin bạn nhập không hợp lệ, vui lòng nhập lại!");
//        } catch (Exception e) {
//            System.out.println("Thông tin bạn nhập không hợp lệ, vui lòng nhập lại!");
//        }
//    }
}
