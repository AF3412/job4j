package ru.af3412.magnit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The type Entry.
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    private int field;

    /**
     * Instantiates a new Entry.
     */
    public Entry() {
    }

    /**
     * Instantiates a new Entry.
     *
     * @param field the field
     */
    public Entry(int field) {
        this.field = field;
    }

    /**
     * Gets field.
     *
     * @return the field
     */
    public int getField() {
        return field;
    }
}
