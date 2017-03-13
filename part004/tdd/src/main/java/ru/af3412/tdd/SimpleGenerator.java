package ru.af3412.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Filatov Alexander
 * @since 09.03.2017
 */
public class SimpleGenerator implements Template {

    public void testRegex(String str) {
        // "Hello, ${name}.
        Pattern pt = Pattern.compile("(\\$)(\\{)((\\w)*?)(\\})");
        Matcher m = pt.matcher(str);
        boolean st = m.matches();
        System.out.println("Regex is: " + st);

        System.out.println(str.replaceAll("", "IAMGROOT"));

        String str2 = new String("Добро пожаловать на ProgLang.su");

        System.out.print("Возвращаемое значение: ");
        System.out.println(str2.replaceAll("(.*)ProgLang(.*)", "IAMGROOT"));

        System.out.print("Возвращаемое значение: ");
        System.out.println(str2.replaceAll("ProgLang.su", "сайт посвященный программированию!"));



    }

    @Override
    public String generate(String template, Map<String, String> data) {
        return null;
    }

}
