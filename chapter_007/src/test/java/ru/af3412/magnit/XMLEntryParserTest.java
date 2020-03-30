package ru.af3412.magnit;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.is;


/**
 * The type Xml entry parser test.
 */
public class XMLEntryParserTest {

    /**
     * When parse xml entries that return list values.
     */
    @Test
    public void whenParseXMLEntriesThatReturnListValues() {
        List<Entry> entryList = List.of(new Entry(1), new Entry(2), new Entry(3));
        StoreXML storeXML = new StoreXML(new File("xmlEntries.xml"));
        File xml = storeXML.save(entryList);
        File xmlQuotes = new File("xmlQuotes.xml");
        File scheme = new File("scheme.xsl");
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(xml, xmlQuotes, scheme);

        XMLEntryParser parser = new XMLEntryParser();
        int result = parser.calculateSumEntriesFromXMLFile(xmlQuotes);
        int expected = 6;

        Assert.assertThat(expected, is(result));
    }

}