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
 *         &lt;element name="customer" type="{http://credable.io/cbs/customer}customer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */

@XmlRootElement(namespace = "http://credable.io/cbs/customer",name = "CustomerResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerResponse {

    @XmlElement(name = "customer", namespace = "http://credable.io/cbs/customer")
    protected Customer customer;

    /**
     * Gets the value of the customer property.
     *
     * @return possible object is
     * {@link Customer }
     */
  //  @XmlElement(name = "customer", namespace = "http://credable.io/cbs/customer")
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     *
     * @param value allowed object is
     *              {@link Customer }
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

}
