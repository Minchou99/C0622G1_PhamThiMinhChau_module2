package ss19_string_regex.exercise.phone_number;

public class PhoneNumberTest {
    private static PhoneNumber phoneNumber;
    private static final String[] validate = new String[] {"(84)-(0978489648)"};
    private static final String[] inValidate = new String[] {"(a8)-(22222222)"};
    public static void main(String[] args) {
        phoneNumber = new PhoneNumber();

        for (String number : validate) {
            boolean isValid = phoneNumber.validate(number);
            System.out.println("Phone number " + number + " is valid: " + isValid);
        }

        for (String number : inValidate ){
            boolean isValid = phoneNumber.validate(number);
            System.out.println("Phone number " + number + " is valid: " + isValid);
        }
    }
}
