
package com.relianceada.ivr;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ivrPortType", targetNamespace = "http://ivr.relianceada.com")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IvrPortType {


    /**
     * 
     * @param source
     * @param transId
     * @param imdn
     * @param requestType
     * @param date
     * @return
     *     returns com.relianceada.ivr.Offers
     */
    @WebMethod
    @WebResult(name = "response", partName = "response")
    public Offers getOffers(
        @WebParam(name = "request_type", partName = "request_type")
        String requestType,
        @WebParam(name = "source", partName = "source")
        String source,
        @WebParam(name = "imdn", partName = "imdn")
        String imdn,
        @WebParam(name = "date", partName = "date")
        String date,
        @WebParam(name = "trans_id", partName = "trans_id")
        String transId);

}
