
package com.relianceada.ivr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OfferInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OfferInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Campaign_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MRP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Campaign_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Validity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfferInfo", propOrder = {
    "campaignName",
    "mrp",
    "campaignText",
    "validity"
})
public class OfferInfo {

    @XmlElement(name = "Campaign_name", required = true)
    protected String campaignName;
    @XmlElement(name = "MRP", required = true)
    protected String mrp;
    @XmlElement(name = "Campaign_text", required = true)
    protected String campaignText;
    @XmlElement(name = "Validity", required = true)
    protected String validity;

    /**
     * Gets the value of the campaignName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Sets the value of the campaignName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignName(String value) {
        this.campaignName = value;
    }

    /**
     * Gets the value of the mrp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMRP() {
        return mrp;
    }

    /**
     * Sets the value of the mrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMRP(String value) {
        this.mrp = value;
    }

    /**
     * Gets the value of the campaignText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignText() {
        return campaignText;
    }

    /**
     * Sets the value of the campaignText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignText(String value) {
        this.campaignText = value;
    }

    /**
     * Gets the value of the validity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidity() {
        return validity;
    }

    /**
     * Sets the value of the validity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidity(String value) {
        this.validity = value;
    }

}
