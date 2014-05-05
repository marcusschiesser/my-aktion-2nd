
package de.dpunkt.myaktion.monitor.ws;

import de.dpunkt.myaktion.model.Donation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the de.dpunkt.myaktion.monitor.ws package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendDonation_QNAME = new QName("http://ws.monitor.myaktion.dpunkt.de/", "sendDonation");
    private final static QName _SendDonationResponse_QNAME = new QName("http://ws.monitor.myaktion.dpunkt.de/", "sendDonationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.dpunkt.myaktion.monitor.ws
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendDonationResponse }
     */
    public SendDonationResponse createSendDonationResponse() {
        return new SendDonationResponse();
    }

    /**
     * Create an instance of {@link SendDonation }
     */
    public SendDonation createSendDonation() {
        return new SendDonation();
    }

    /**
     * Create an instance of {@link Donation }
     */
    public Donation createDonation() {
        return new Donation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendDonation }{@code >}}
     */
    @XmlElementDecl(namespace = "http://ws.monitor.myaktion.dpunkt.de/", name = "sendDonation")
    public JAXBElement<SendDonation> createSendDonation(SendDonation value) {
        return new JAXBElement<SendDonation>(_SendDonation_QNAME, SendDonation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendDonationResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://ws.monitor.myaktion.dpunkt.de/", name = "sendDonationResponse")
    public JAXBElement<SendDonationResponse> createSendDonationResponse(SendDonationResponse value) {
        return new JAXBElement<SendDonationResponse>(_SendDonationResponse_QNAME, SendDonationResponse.class, null, value);
    }

}
