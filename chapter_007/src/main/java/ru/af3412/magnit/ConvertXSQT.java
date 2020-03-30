package ru.af3412.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * The type Convert xsqt.
 */
public class ConvertXSQT {

    private static final Logger LOG = LogManager.getLogger(ConvertXSQT.class.getName());

    /**
     * Convert.
     *
     * @param source the source
     * @param dest   the dest
     * @param scheme the scheme
     */
    public void convert(File source, File dest, File scheme) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(scheme);
            Transformer transformer = factory.newTransformer(xslt);
            Source xml = new StreamSource(source);
            transformer.transform(xml, new StreamResult(dest));
        } catch (TransformerException e) {
            LOG.error("Error {} convert files {} to {} with scheme {}",
                    e.getMessage(), source.getName(), dest.getName(), scheme.getName());
        }
    }

}
