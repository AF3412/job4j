package ru.af3412.magnit;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * The type Convert xsqt test.
 */
public class ConvertXSQTTest {


    /**
     * When convert xml entries with scheme that result file exist and not empty.
     */
    @Test
    public void whenConvertXMLEntriesWithSchemeThatResultFileExistAndNotEmpty() {
        List<Entry> entryList = List.of(new Entry(1), new Entry(2), new Entry(3));
        StoreXML storeXML = new StoreXML(new File("xmlEntries.xml"));
        File xml = storeXML.save(entryList);
        File result = new File("xmlQuotes.xml");
        File scheme = new File("scheme.xsl");
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(xml, result, scheme);

        Assert.assertTrue(result.exists());
        Assert.assertTrue(result.length() > 0);
    }

}