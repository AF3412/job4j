package ru.af3412.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Xml entry parser.
 */
public class XMLEntryParser {

    private static final Logger LOG = LogManager.getLogger(XMLEntryParser.class.getName());

    /**
     * Calculate sum entries from xml file int.
     *
     * @param file the file
     * @return the int
     */
    public int calculateSumEntriesFromXMLFile(File file) {
        List<String> entries = parse(file);
        return entries.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private List<String> parse(File file) {
        List<String> result;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxHandler saxHandler = new SaxHandler();
            parser.parse(file, saxHandler);
            result = saxHandler.getList();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOG.error("Error {} with parse file: {}", e.getMessage(), file.getName(), e);
            result = new ArrayList<>(0);
        }
        return result;
    }

}
