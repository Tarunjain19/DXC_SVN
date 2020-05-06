
package com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.ObjectFactory;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CssInfoPort", targetNamespace = "http://xmlns.example.com/1272370141776/CssInfoImpl/BusinessUseCases/StarterServices")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CssInfoPort {


    /**
     * 
     * @param part1
     * @return
     *     returns com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response
     */
    @WebMethod(operationName = "CssInfo", action = "/BusinessUseCases/StarterServices/CSS_SOAP_Receiver")
    @WebResult(name = "Response", targetNamespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", partName = "part1")
    public Response cssInfo(
        @WebParam(name = "Request", targetNamespace = "http://www.tibco.com/schemas/CSS_GW/SharedResources/Schema/Private/CSS_Schema.xsd", partName = "part1")
        Request part1);

}