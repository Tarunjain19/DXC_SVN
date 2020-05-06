
package com.relianceada.si.crmgw.schemas.postpaid;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{http://www.relianceada.com/si/crmgw/schemas/Postpaid}ResponseStatus"/>
 *         &lt;element name="AccountDetails">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="account_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="accountBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="unbilledAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="balanceDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="creditLimit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseStatus",
    "accountDetails"
})
@XmlRootElement(name = "AccountDetailsResponse")
public class AccountDetailsResponse {

    @XmlElement(name = "ResponseStatus", required = true)
    protected ResponseStatus responseStatus;
    @XmlElement(name = "AccountDetails", required = true)
    protected AccountDetailsResponse.AccountDetails accountDetails;

    /**
     * Gets the value of the responseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the value of the responseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setResponseStatus(ResponseStatus value) {
        this.responseStatus = value;
    }

    /**
     * Gets the value of the accountDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AccountDetailsResponse.AccountDetails }
     *     
     */
    public AccountDetailsResponse.AccountDetails getAccountDetails() {
        return accountDetails;
    }

    /**
     * Sets the value of the accountDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountDetailsResponse.AccountDetails }
     *     
     */
    public void setAccountDetails(AccountDetailsResponse.AccountDetails value) {
        this.accountDetails = value;
    }


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
     *         &lt;element name="account_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="accountBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="unbilledAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="balanceDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="creditLimit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "accountId",
        "accountBalance",
        "unbilledAmount",
        "balanceDate",
        "creditLimit"
    })
    public static class AccountDetails {

        @XmlElement(name = "account_id", required = true)
        protected String accountId;
        protected BigDecimal accountBalance;
        protected BigDecimal unbilledAmount;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar balanceDate;
        protected BigDecimal creditLimit;

        /**
         * Gets the value of the accountId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountId() {
            return accountId;
        }

        /**
         * Sets the value of the accountId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountId(String value) {
            this.accountId = value;
        }

        /**
         * Gets the value of the accountBalance property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAccountBalance() {
            return accountBalance;
        }

        /**
         * Sets the value of the accountBalance property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAccountBalance(BigDecimal value) {
            this.accountBalance = value;
        }

        /**
         * Gets the value of the unbilledAmount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUnbilledAmount() {
            return unbilledAmount;
        }

        /**
         * Sets the value of the unbilledAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUnbilledAmount(BigDecimal value) {
            this.unbilledAmount = value;
        }

        /**
         * Gets the value of the balanceDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBalanceDate() {
            return balanceDate;
        }

        /**
         * Sets the value of the balanceDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBalanceDate(XMLGregorianCalendar value) {
            this.balanceDate = value;
        }

        /**
         * Gets the value of the creditLimit property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getCreditLimit() {
            return creditLimit;
        }

        /**
         * Sets the value of the creditLimit property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setCreditLimit(BigDecimal value) {
            this.creditLimit = value;
        }

    }

}
