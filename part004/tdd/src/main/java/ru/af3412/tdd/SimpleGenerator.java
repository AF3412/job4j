package ru.af3412.tdd;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by af3412 on 23.03.2017.
 */
public class SimpleGenerator implements Template {

    private final String PATTERN = "\\$\\{(\\w+)(\\})";

    @Override
    public String generate(String template, Map<String, String> data) throws TemplateException {

        Matcher matcher = Pattern.compile(PATTERN).matcher(template);
        StringBuffer stringBuffer = new StringBuffer();

        Set<String> keys = data.keySet();
        for (String key : keys) {
            String tmpValue = new StringBuffer("$").append("{").append(key).append("}").toString();
            if (!template.contains(tmpValue)) {
                throw new TemplateException("Key not found");
            }
        }

        while (matcher.find()) {
            if (data.containsKey(matcher.group(1))) {
                matcher.appendReplacement(stringBuffer, data.get(matcher.group(1)));
            } else {
                throw new TemplateException("Key not found");
            }
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }


}
