package ru.af3412.tdd;

import java.util.Map;

/**
 * @author Filatov Alexander
 * @since 09.03.2017
 */
public interface Template {

    String generate(String template, Map<String, String> data);

}
