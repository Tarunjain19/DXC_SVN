
package com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CSS__SOAP__Reciever", targetNamespace = "http://xmlns.example.com/1272370141776/CssInfoImpl/BusinessUseCases/StarterServices", wsdlLocation = "file:/D:/v2.1/23Mar2015/Prepaid%20and%20Postpaid%20WSDL/Twitter_Service.wsdl")
public class CSSSOAPReciever
    extends Service
{

    private final static URL CSSSOAPRECIEVER_WSDL_LOCATION;
    private final static WebServiceException CSSSOAPRECIEVER_EXCEPTION;
    private final static QName CSSSOAPRECIEVER_QNAME = new QName("http://xmlns.example.com/1272370141776/CssInfoImpl/BusinessUseCases/StarterServices", "CSS__SOAP__Reciever");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/v2.1/23Mar2015/Prepaid%20and%20Postpaid%20WSDL/Twitter_Service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CSSSOAPRECIEVER_WSDL_LOCATION = url;
        CSSSOAPRECIEVER_EXCEPTION = e;
    }

    public CSSSOAPReciever() {
        super(__getWsdlLocation(), CSSSOAPRECIEVER_QNAME);
    }

    public CSSSOAPReciever(WebServiceFeature... features) {
        super(__getWsdlLocation(), CSSSOAPRECIEVER_QNAME, features);
    }

    public CSSSOAPReciever(URL wsdlLocation) {
        super(wsdlLocation, CSSSOAPRECIEVER_QNAME);
    }

    public CSSSOAPReciever(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CSSSOAPRECIEVER_QNAME, features);
    }

    public CSSSOAPReciever(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CSSSOAPReciever(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CssInfoPort
     */
    @WebEndpoint(name = "CSSSoapReciever")
    public CssInfoPort getCSSSoapReciever() {
        return super.getPort(new QName("http://xmlns.example.com/1272370141776/CssInfoImpl/BusinessUseCases/StarterServices", "CSSSoapReciever"), CssInfoPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CssInfoPort
     */
    @WebEndpoint(name = "CSSSoapReciever")
    public CssInfoPort getCSSSoapReciever(WebServiceFeature... features) {
        return super.getPort(new QName("http://xmlns.example.com/1272370141776/CssInfoImpl/BusinessUseCases/StarterServices", "CSSSoapReciever"), CssInfoPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CSSSOAPRECIEVER_EXCEPTION!= null) {
            throw CSSSOAPRECIEVER_EXCEPTION;
        }
        return CSSSOAPRECIEVER_WSDL_LOCATION;
    }

}
