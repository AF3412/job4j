package ru.af3412.magnit;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Sax handler.
 */
public class SaxHandler extends DefaultHandler {

    private final List<String> list = new ArrayList<>();

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) {
        if (qName.equals("entry")) {
            list.add(attr.getValue("field"));
        }
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<String> getList() {
        return list;
    }
}
