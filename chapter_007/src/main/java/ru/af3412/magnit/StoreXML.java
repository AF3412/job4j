package ru.af3412.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * The type Store xml.
 */
public class StoreXML {
    private static final Logger LOG = LogManager.getLogger(StoreXML.class.getName());
    private File target;

    /**
     * Instantiates a new Store xml.
     *
     * @param target the target
     */
    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Save file.
     *
     * @param list the list
     * @return the file
     */
    public File save(List<Entry> list) {
        Entries entries = new Entries(list);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entries, target);
        } catch (JAXBException e) {
            LOG.error("Convert objects to XML error. {}", e.getMessage(), e);
        }
        return target;
    }

}
