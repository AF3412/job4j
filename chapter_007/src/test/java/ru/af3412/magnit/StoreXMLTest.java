package ru.af3412.magnit;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * The type Store xml test.
 */
public class StoreXMLTest {

    /**
     * When save from list object then return file with not null size.
     */
    @Test
    public void whenSaveFromListObjectThenReturnFileWithNotNullSize() {
        List<Entry> entryList = List.of(new Entry(1), new Entry(2), new Entry(3));
        StoreXML storeXML = new StoreXML(new File("xmlEntries.xml"));

        File result = storeXML.save(entryList);

        Assert.assertTrue(result.exists());
        Assert.assertTrue(result.length() > 0);
    }

}