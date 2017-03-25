package ru.af3412.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by af3412 on 23.03.2017.
 */
public class SimpleGenerator implements Template {

    /**
     * The constant regular expression.
     */
    private final String pattern = "\\$\\{(\\w+)(\\})";

    @Override
    public String generate(String template, Map<String, String> data) throws TemplateException {

        /**
         * Create regular expression for find.
         */

        Matcher matcher = Pattern.compile(pattern).matcher(template);
        StringBuffer stringBuffer = new StringBuffer();

        /**
         * Get all keys and check that used in the string. Else create exception.
         */
        for (String key : data.keySet()) {
            String tmpValue = new StringBuffer("${").append(key).append("}").toString();
            if (!template.contains(tmpValue)) {
                throw new TemplateException("Excess key");
            }
        }

        /**
         * Find all keys in string and replace to values from data.
         * If Map (data) does not contains value then create exception.
         */
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
