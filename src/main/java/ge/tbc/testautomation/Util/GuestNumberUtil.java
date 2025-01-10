package ge.tbc.testautomation.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuestNumberUtil {

    public static List<Integer> extractAllNumbers(String text) {
        List<Integer> numbers = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            System.out.println("Empty or null text: " + text);
            return numbers;
        }

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }

        return numbers;
    }
}

