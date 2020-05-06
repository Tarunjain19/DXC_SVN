package org.tempuri;

public class RGC_ServicesSoapProxy implements org.tempuri.RGC_ServicesSoap {
  private String _endpoint = null;
  private org.tempuri.RGC_ServicesSoap rGC_ServicesSoap = null;
  
  public RGC_ServicesSoapProxy() {
    _initRGC_ServicesSoapProxy();
  }
  
  public RGC_ServicesSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initRGC_ServicesSoapProxy();
  }
  
  private void _initRGC_ServicesSoapProxy() {
    try {
      rGC_ServicesSoap = (new org.tempuri.RGC_ServicesLocator()).getRGC_ServicesSoap();
      if (rGC_ServicesSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)rGC_ServicesSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)rGC_ServicesSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (rGC_ServicesSoap != null)
      ((javax.xml.rpc.Stub)rGC_ServicesSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.RGC_ServicesSoap getRGC_ServicesSoap() {
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap;
  }
  
  public String validateCustomer(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.validateCustomer(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strPinNumber, intServiceType, intValidateType, strProductCode, strMessage, strResponseXml);
  }
  
  public String accountBalance(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.accountBalance(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strPinNumber, intServiceType, intValidateType, strProductCode, strMessage, strResponseXml);
  }
  
  public boolean accountInUse(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strNafNumber, int intServiceType, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.accountInUse(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strNafNumber, intServiceType, strProductCode, strMessage, strResponseXml);
  }
  
  public String changePIN(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.changePIN(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strPinNumber, intServiceType, intValidateType, strProductCode, strMessage, strResponseXml);
  }
  
  public boolean cardChange(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strInstOneTime, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.cardChange(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strPinNumber, intServiceType, intValidateType, strInstNumber, strInstExpiryDate, strInstCode, strInstOneTime, strProductCode, strMessage, strResponseXml);
  }
  
  public boolean registration(java.lang.String strAuthKey, java.lang.String strEduid, java.lang.String strCsrid, int intInteractionType, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strProductCode, java.lang.String strInstOneTime, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.registration(strAuthKey, strEduid, strCsrid, intInteractionType, strInstNumber, strInstExpiryDate, strInstCode, strProductCode, strInstOneTime, strMessage, strResponseXml);
  }
  
  public String pinlessPayment(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strNafNumber, int intServiceType, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.pinlessPayment(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strNafNumber, intServiceType, strInstNumber, strInstExpiryDate, strInstCode, strProductCode, strMessage, strResponseXml);
  }
  
  public boolean calculateTax(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, double dblAmount, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.calculateTax(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strPinNumber, intServiceType, intValidateType, dblAmount, strInstNumber, strInstExpiryDate, strInstCode, strProductCode, strMessage, strResponseXml);
  }
  
  public boolean getCallRates(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, int intSCCode, int intDCCode, int intFetchFlag, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.getCallRates(strAuthKey, strEduid, intInteractionType, intSCCode, intDCCode, intFetchFlag, strProductCode, strMessage, strResponseXml);
  }
  
  public boolean CCDCAuthentication(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.CCDCAuthentication(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strPinNumber, intServiceType, intValidateType, strInstNumber, strInstExpiryDate, strInstCode, strProductCode, strMessage, strResponseXml);
  }
  
  public boolean rechargeAccount(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strRechargeMode, double dblAmount, java.lang.String strUseCard, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strInstType, java.lang.String strInstOneTime, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.rechargeAccount(strAuthKey, strEduid, intInteractionType, strRegisteredNumber, strPinNumber, intServiceType, intValidateType, strRechargeMode, dblAmount, strUseCard, strInstNumber, strInstExpiryDate, strInstCode, strInstType, strInstOneTime, strProductCode, strMessage, strResponseXml);
  }
  
  public boolean validatePhysicalCCPin(java.lang.String authKey, java.lang.String pinNumber, javax.xml.rpc.holders.StringHolder message, javax.xml.rpc.holders.StringHolder IVRResponseXml) throws java.rmi.RemoteException{
    if (rGC_ServicesSoap == null)
      _initRGC_ServicesSoapProxy();
    return rGC_ServicesSoap.validatePhysicalCCPin(authKey, pinNumber, message, IVRResponseXml);
  }
  
  
}