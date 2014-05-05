
package de.dpunkt.myaktion.monitor.ws;

import de.dpunkt.myaktion.model.Donation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendDonation complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="sendDonation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://ws.monitor.myaktion.dpunkt.de/}donation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendDonation", propOrder = {
        "arg0",
        "arg1"
})
public class SendDonation {

    protected Long arg0;
    protected Donation arg1;

    /**
     * Gets the value of the arg0 property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setArg0(Long value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     *
     * @return possible object is
     * {@link Donation }
     */
    public Donation getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     *
     * @param value allowed object is
     *              {@link Donation }
     */
    public void setArg1(Donation value) {
        this.arg1 = value;
    }

}
