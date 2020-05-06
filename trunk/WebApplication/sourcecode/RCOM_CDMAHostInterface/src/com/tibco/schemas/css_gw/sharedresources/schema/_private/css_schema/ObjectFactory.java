
package com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TimeStamp_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "timeStamp");
    private final static QName _RequestId_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "requestId");
    private final static QName _ErrorMsg_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "errorMsg");
    private final static QName _RequestType_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "requestType");
    private final static QName _MsgText_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "msgText");
    private final static QName _Type_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "type");
    private final static QName _RequestSource_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "requestSource");
    private final static QName _Id_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "id");
    private final static QName _TokenId_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "TokenId");
    private final static QName _MsgCode_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "msgCode");
    private final static QName _Name_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "name");
    private final static QName _Msg_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "Msg");
    private final static QName _LangID_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "langID");
    private final static QName _ErrorCode_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "errorCode");
    private final static QName _Value_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "value");
    private final static QName _Action_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "action");
    private final static QName _ResponseFlag_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "responseFlag");
    private final static QName _ServiceID_QNAME = new QName("http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", "service_ID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Param }
     * 
     */
    public Param createParam() {
        return new Param();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link DataSet }
     * 
     */
    public DataSet createDataSet() {
        return new DataSet();
    }

    /**
     * Create an instance of {@link MsgTokens }
     * 
     */
    public MsgTokens createMsgTokens() {
        return new MsgTokens();
    }

    /**
     * Create an instance of {@link Token }
     * 
     */
    public Token createToken() {
        return new Token();
    }

    /**
     * Create an instance of {@link MsgParam }
     * 
     */
    public MsgParam createMsgParam() {
        return new MsgParam();
    }

    /**
     * Create an instance of {@link CSS }
     * 
     */
    public CSS createCSS() {
        return new CSS();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "timeStamp")
    public JAXBElement<String> createTimeStamp(String value) {
        return new JAXBElement<String>(_TimeStamp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "requestId")
    public JAXBElement<String> createRequestId(String value) {
        return new JAXBElement<String>(_RequestId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "errorMsg")
    public JAXBElement<String> createErrorMsg(String value) {
        return new JAXBElement<String>(_ErrorMsg_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "requestType")
    public JAXBElement<String> createRequestType(String value) {
        return new JAXBElement<String>(_RequestType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "msgText")
    public JAXBElement<String> createMsgText(String value) {
        return new JAXBElement<String>(_MsgText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "requestSource")
    public JAXBElement<String> createRequestSource(String value) {
        return new JAXBElement<String>(_RequestSource_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "TokenId")
    public JAXBElement<String> createTokenId(String value) {
        return new JAXBElement<String>(_TokenId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "msgCode")
    public JAXBElement<String> createMsgCode(String value) {
        return new JAXBElement<String>(_MsgCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "Msg")
    public JAXBElement<String> createMsg(String value) {
        return new JAXBElement<String>(_Msg_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "langID")
    public JAXBElement<String> createLangID(String value) {
        return new JAXBElement<String>(_LangID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "errorCode")
    public JAXBElement<String> createErrorCode(String value) {
        return new JAXBElement<String>(_ErrorCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "value")
    public JAXBElement<String> createValue(String value) {
        return new JAXBElement<String>(_Value_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "action")
    public JAXBElement<String> createAction(String value) {
        return new JAXBElement<String>(_Action_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "responseFlag")
    public JAXBElement<String> createResponseFlag(String value) {
        return new JAXBElement<String>(_ResponseFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", name = "service_ID")
    public JAXBElement<String> createServiceID(String value) {
        return new JAXBElement<String>(_ServiceID_QNAME, String.class, null, value);
    }

}
