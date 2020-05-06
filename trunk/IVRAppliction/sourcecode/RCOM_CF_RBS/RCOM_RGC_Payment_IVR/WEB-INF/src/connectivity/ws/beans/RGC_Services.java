/**
 * RGC_Services.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connectivity.ws.beans;

public interface RGC_Services extends javax.xml.rpc.Service {
    public java.lang.String getRGC_ServicesSoapAddress();

    public connectivity.ws.beans.RGC_ServicesSoap_PortType getRGC_ServicesSoap() throws javax.xml.rpc.ServiceException;

    public connectivity.ws.beans.RGC_ServicesSoap_PortType getRGC_ServicesSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
