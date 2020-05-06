
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
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}TokenId" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}Msg" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd}MsgParam" minOccurs="0"/>
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
    "tokenId",
    "msg",
    "msgParam"
})
@XmlRootElement(name = "Token")
public class Token {

    @XmlElement(name = "TokenId")
    protected String tokenId;
    @XmlElement(name = "Msg")
    protected String msg;
    @XmlElement(name = "MsgParam")
    protected MsgParam msgParam;

    /**
     * Gets the value of the tokenId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * Sets the value of the tokenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenId(String value) {
        this.tokenId = value;
    }

    /**
     * Gets the value of the msg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the value of the msg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

    /**
     * Gets the value of the msgParam property.
     * 
     * @return
     *     possible object is
     *     {@link MsgParam }
     *     
     */
    public MsgParam getMsgParam() {
        return msgParam;
    }

    /**
     * Sets the value of the msgParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgParam }
     *     
     */
    public void setMsgParam(MsgParam value) {
        this.msgParam = value;
    }

}
