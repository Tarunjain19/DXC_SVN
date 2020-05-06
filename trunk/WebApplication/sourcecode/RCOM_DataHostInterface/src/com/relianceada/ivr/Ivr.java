
package com.relianceada.ivr;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * gSOAP 2.8.8 generated service definition
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ivr", targetNamespace = "http://ivr.relianceada.com", wsdlLocation = "file:/D:/Deba%20Projects/Reliance%20Telecom/OFU.WSDL")
public class Ivr
    extends Service
{

    private final static URL IVR_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.relianceada.ivr.Ivr.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.relianceada.ivr.Ivr.class.getResource(".");
            url = new URL(baseUrl, "file:/D:/Deba%20Projects/Reliance%20Telecom/OFU.WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/Deba%20Projects/Reliance%20Telecom/OFU.WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        IVR_WSDL_LOCATION = url;
    }

    public Ivr(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Ivr() {
        super(IVR_WSDL_LOCATION, new QName("http://ivr.relianceada.com", "ivr"));
    }

    /**
     * 
     * @return
     *     returns IvrPortType
     */
    @WebEndpoint(name = "ivr")
    public IvrPortType getIvr() {
        return super.getPort(new QName("http://ivr.relianceada.com", "ivr"), IvrPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IvrPortType
     */
    @WebEndpoint(name = "ivr")
    public IvrPortType getIvr(WebServiceFeature... features) {
        return super.getPort(new QName("http://ivr.relianceada.com", "ivr"), IvrPortType.class, features);
    }

}
