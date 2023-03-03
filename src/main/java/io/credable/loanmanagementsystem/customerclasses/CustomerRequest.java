package io.credable.loanmanagementsystem.customerclasses;


import jakarta.xml.bind.annotation.*;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"customerNumber"})
@XmlRootElement(namespace = "http://credable.io/cbs/customer",name = "CustomerRequest")
public class CustomerRequest {

    @XmlElement(namespace = "http://credable.io/cbs/customer")
    protected String customerNumber;

    /**
     * Gets the value of the customerNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

}
