package ss19_string_regex.exercise.name_of_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameOfClass {
    private static final String ACCOUNT_REGEX = "[CAP]?[0-9]{4}[GHIKLM]?";

    public NameOfClass() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
