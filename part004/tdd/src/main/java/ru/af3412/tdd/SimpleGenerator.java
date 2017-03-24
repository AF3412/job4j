package ru.af3412.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Филатов on 23.03.2017.
 */
public class SimpleGenerator implements Template {

    private final String PATTERN = "\\$\\{(\\w+)(\\})";

    @Override
    public String generate(String template, Map<String, String> data) {

        Matcher matcher = Pattern.compile(PATTERN).matcher(template);
        StringBuffer stringBuffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, data.get(matcher.group(1)));
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }



}
