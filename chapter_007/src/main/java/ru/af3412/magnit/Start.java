package ru.af3412.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

/**
 * The type Start.
 */
public class Start {

    private static final Logger LOG = LogManager.getLogger(Start.class.getName());

    /**
     * Main.
     *
     * @param size the size
     */
    public static void main(int size) {
        Start start = new Start();
        LOG.info("Sum all elements: {}", start.process(size));
    }

    /**
     * Process int.
     *
     * @param size the size
     * @return the int
     */
    public int process(int size) {
        Config config = new Config();
        config.init();
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.generate(size);
        List<Entry> entries = storeSQL.load();
        File xml = new File("xmlEntries.xml");
        StoreXML storeXML = new StoreXML(xml);
        storeXML.save(entries);
        ConvertXSQT convertXSQT = new ConvertXSQT();
        File xmlAfterConvert = new File("xmlQuotes");
        File scheme = new File("scheme.xsl");
        convertXSQT.convert(xml, xmlAfterConvert, scheme);
        XMLEntryParser parser = new XMLEntryParser();
        return parser.calculateSumEntriesFromXMLFile(xmlAfterConvert);
    }

}
