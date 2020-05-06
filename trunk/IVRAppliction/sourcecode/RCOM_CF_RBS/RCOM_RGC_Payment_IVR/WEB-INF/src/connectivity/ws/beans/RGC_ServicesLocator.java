/**
 * RGC_ServicesLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connectivity.ws.beans;

public class RGC_ServicesLocator extends org.apache.axis.client.Service implements connectivity.ws.beans.RGC_Services {

    public RGC_ServicesLocator() {
    }


    public RGC_ServicesLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RGC_ServicesLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RGC_ServicesSoap
    private java.lang.String RGC_ServicesSoap_address = "http://10.8.196.78/rgc_ivr_new/RGC_Services.asmx";

    public java.lang.String getRGC_ServicesSoapAddress() {
        return RGC_ServicesSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RGC_ServicesSoapWSDDServiceName = "RGC_ServicesSoap";

    public java.lang.String getRGC_ServicesSoapWSDDServiceName() {
        return RGC_ServicesSoapWSDDServiceName;
    }

    public void setRGC_ServicesSoapWSDDServiceName(java.lang.String name) {
        RGC_ServicesSoapWSDDServiceName = name;
    }

    public connectivity.ws.beans.RGC_ServicesSoap_PortType getRGC_ServicesSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RGC_ServicesSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRGC_ServicesSoap(endpoint);
    }

    public connectivity.ws.beans.RGC_ServicesSoap_PortType getRGC_ServicesSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            connectivity.ws.beans.RGC_ServicesSoap_BindingStub _stub = new connectivity.ws.beans.RGC_ServicesSoap_BindingStub(portAddress, this);
            _stub.setPortName(getRGC_ServicesSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRGC_ServicesSoapEndpointAddress(java.lang.String address) {
        RGC_ServicesSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (connectivity.ws.beans.RGC_ServicesSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                connectivity.ws.beans.RGC_ServicesSoap_BindingStub _stub = new connectivity.ws.beans.RGC_ServicesSoap_BindingStub(new java.net.URL(RGC_ServicesSoap_address), this);
                _stub.setPortName(getRGC_ServicesSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("RGC_ServicesSoap".equals(inputPortName)) {
            return getRGC_ServicesSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "RGC_Services");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "RGC_ServicesSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RGC_ServicesSoap".equals(portName)) {
            setRGC_ServicesSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
