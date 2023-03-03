
package io.credable.loanmanagementsystem.customerclasses;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
    "createdAt",
    "createdDate",
    "customerNumber",
    "dob",
    "email",
    "firstName",
    "gender",
    "id",
    "idNumber",
    "idType",
    "lastName",
    "middleName",
    "mobile",
    "monthlyIncome",
    "status",
    "updatedAt"
})
public class Customer {

    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "createdAt", namespace = "http://credable.io/cbs/customer")
    protected XMLGregorianCalendar createdAt;


    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "createdDate", namespace = "http://credable.io/cbs/customer")
    protected XMLGregorianCalendar createdDate;

    @XmlElement(name = "customerNumber", namespace = "http://credable.io/cbs/customer")
    protected String customerNumber;

    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "dob", namespace = "http://credable.io/cbs/customer")
    protected XMLGregorianCalendar dob;

    @XmlElement(name = "email", namespace = "http://credable.io/cbs/customer")
    protected String email;

    @XmlElement(name = "firstName", namespace = "http://credable.io/cbs/customer")
    protected String firstName;

    @XmlElement(name = "gender", namespace = "http://credable.io/cbs/customer")
    @XmlSchemaType(name = "string")
    protected Gender gender;

    @XmlElement(name = "id", namespace = "http://credable.io/cbs/customer")
    protected Long id;

    @XmlElement(name = "idNumber", namespace = "http://credable.io/cbs/customer")
    protected String idNumber;
    @XmlSchemaType(name = "string")
    @XmlElement(name = "idType", namespace = "http://credable.io/cbs/customer")
    protected IdType idType;

    @XmlElement(name = "lastName", namespace = "http://credable.io/cbs/customer")
    protected String lastName;

    @XmlElement(name = "middleName", namespace = "http://credable.io/cbs/customer")
    protected String middleName;

    @XmlElement(name = "mobile", namespace = "http://credable.io/cbs/customer")
    protected String mobile;

    @XmlElement(name = "monthlyIncome", namespace = "http://credable.io/cbs/customer")
    protected double monthlyIncome;

    @XmlElement(name = "status", namespace = "http://credable.io/cbs/customer")
    @XmlSchemaType(name = "string")
    protected Status status;


    @XmlElement(name = "updatedAt", namespace = "http://credable.io/cbs/customer")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedAt;

    /**
     * Gets the value of the createdAt property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

    /**
     * Gets the value of the createdDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }


    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

    /**
     * Gets the value of the dob property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDob() {
        return dob;
    }

    /**
     * Sets the value of the dob property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDob(XMLGregorianCalendar value) {
        this.dob = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the firstName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the gender property.
     *
     * @return
     *     possible object is
     *     {@link Gender }
     *
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     *
     * @param value
     *     allowed object is
     *     {@link Gender }
     *
     */
    public void setGender(Gender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the idNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the value of the idNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdNumber(String value) {
        this.idNumber = value;
    }

    /**
     * Gets the value of the idType property.
     *
     * @return possible object is
     * {@link IdType }
     */
    public IdType getIdType() {
        return idType;
    }

    /**
     * Sets the value of the idType property.
     *
     * @param value
     *     allowed object is
     *     {@link IdType }
     *
     */
    public void setIdType(IdType value) {
        this.idType = value;
    }

    /**
     * Gets the value of the lastName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the middleName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the mobile property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the monthlyIncome property.
     *
     */
    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * Sets the value of the monthlyIncome property.
     *
     */
    public void setMonthlyIncome(double value) {
        this.monthlyIncome = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the updatedAt property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the value of the updatedAt property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setUpdatedAt(XMLGregorianCalendar value) {
        this.updatedAt = value;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "createdAt=" + createdAt +
                ", createdDate=" + createdDate +
                ", customerNumber='" + customerNumber + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender=" + gender +
                ", id=" + id +
                ", idNumber='" + idNumber + '\'' +
                ", idType=" + idType +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", status=" + status +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
