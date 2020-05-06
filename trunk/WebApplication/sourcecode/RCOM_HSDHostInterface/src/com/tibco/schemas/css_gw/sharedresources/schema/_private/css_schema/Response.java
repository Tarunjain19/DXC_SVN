
package com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}langID" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}responseFlag" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}errorCode"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}errorMsg"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}msgCode"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}msgText" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}dataSet" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}MsgTokens" minOccurs="0"/>
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
    "langID",
    "responseFlag",
    "errorCode",
    "errorMsg",
    "msgCode",
    "msgText",
    "dataSet",
    "msgTokens"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(required = true)
    protected String requestId;
    protected String langID;
    protected String responseFlag;
    @XmlElement(required = true)
    protected String errorCode;
    @XmlElement(required = true)
    protected String errorMsg;
    @XmlElement(required = true)
    protected String msgCode;
    protected String msgText;
    protected DataSet dataSet;
    @XmlElement(name = "MsgTokens")
    protected MsgTokens msgTokens;

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
     * Gets the value of the responseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseFlag() {
        return responseFlag;
    }

    /**
     * Sets the value of the responseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseFlag(String value) {
        this.responseFlag = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Sets the value of the errorMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

    /**
     * Gets the value of the msgCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgCode() {
        return msgCode;
    }

    /**
     * Sets the value of the msgCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgCode(String value) {
        this.msgCode = value;
    }

    /**
     * Gets the value of the msgText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgText() {
        return msgText;
    }

    /**
     * Sets the value of the msgText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgText(String value) {
        this.msgText = value;
    }

    /**
     * Gets the value of the dataSet property.
     * 
     * @return
     *     possible object is
     *     {@link DataSet }
     *     
     */
    public DataSet getDataSet() {
        return dataSet;
    }

    /**
     * Sets the value of the dataSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSet }
     *     
     */
    public void setDataSet(DataSet value) {
        this.dataSet = value;
    }

    /**
     * Gets the value of the msgTokens property.
     * 
     * @return
     *     possible object is
     *     {@link MsgTokens }
     *     
     */
    public MsgTokens getMsgTokens() {
        return msgTokens;
    }

    /**
     * Sets the value of the msgTokens property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgTokens }
     *     
     */
    public void setMsgTokens(MsgTokens value) {
        this.msgTokens = value;
    }

}
