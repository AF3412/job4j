package ru.af3412.magnit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * The type Entries.
 */
@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entries {

    @XmlElement(name = "entry")
    private List<Entry> entryList;

    /**
     * Instantiates a new Entries.
     */
    public Entries() {
    }

    /**
     * Instantiates a new Entries.
     *
     * @param entryList the entry list
     */
    public Entries(List<Entry> entryList) {
        this.entryList = entryList;
    }

    /**
     * Sets entry list.
     *
     * @param entryList the entry list
     */
    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    /**
     * Gets entry list.
     *
     * @return the entry list
     */
    public List<Entry> getEntryList() {
        return entryList;
    }
}
