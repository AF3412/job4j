package ru.af3412.tdd;

import java.util.Map;

/**
 * The interface Template.
 *
 * @author Filatov Alexander
 * @since 09.03.2017
 */
public interface Template {

    /**
     * Generate string.
     *
     * @param template the template
     * @param data     the data
     * @return the string
     * @throws TemplateException the template exception
     */
    String generate(String template, Map<String, String> data) throws TemplateException;

}
