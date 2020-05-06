
package com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}requestId"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}service_ID"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}requestType"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}langID" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}requestSource"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}timeStamp"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}param" maxOccurs="unbounded" minOccurs="0"/>
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
    "requestId",
    "serviceID",
    "requestType",
    "langID",
    "requestSource",
    "timeStamp",
    "param"
})
@XmlRootElement(name = "Request")
public class Request {

    @XmlElement(required = true)
    protected String requestId;
    @XmlElement(name = "service_ID", required = true)
    protected String serviceID;
    @XmlElement(required = true)
    protected String requestType;
    protected String langID;
    @XmlElement(required = true)
    protected String requestSource;
    @XmlElement(required = true)
    protected String timeStamp;
    protected List<Param> param;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the serviceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * Sets the value of the serviceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceID(String value) {
        this.serviceID = value;
    }

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestType(String value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the langID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangID() {
        return langID;
    }

    /**
     * Sets the value of the langID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangID(String value) {
        this.langID = value;
    }

    /**
     * Gets the value of the requestSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestSource() {
        return requestSource;
    }

    /**
     * Sets the value of the requestSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestSource(String value) {
        this.requestSource = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the param property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the param property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Param }
     * 
     * 
     */
    public List<Param> getParam() {
        if (param == null) {
            param = new ArrayList<Param>();
        }
        return this.param;
    }

}
