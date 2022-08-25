package ss19_string_regex.exercise.name_of_class;

public class NameOfClassTest {
    private static NameOfClass nameOfClass;

    public static final String[] validAccount = new String[]{"C0318G"};
    public static final String[] invalidAccount = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        nameOfClass = new NameOfClass();

        for (String name : validAccount) {
            boolean isValid = nameOfClass.validate(name);
            System.out.println("Name " + name + " is valid: " + isValid);
        }

        for (String name : invalidAccount) {
            boolean isValid = nameOfClass.validate(name);
            System.out.println("Name " + name + " is invalid: " + isValid);
        }
    }
}
