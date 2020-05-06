/**
 * RGC_ServicesSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface RGC_ServicesSoap extends java.rmi.Remote {
    public String validateCustomer(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public String accountBalance(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean accountInUse(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strNafNumber, int intServiceType, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public String changePIN(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean cardChange(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strInstOneTime, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean registration(java.lang.String strAuthKey, java.lang.String strEduid, java.lang.String strCsrid, int intInteractionType, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strProductCode, java.lang.String strInstOneTime, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean pinlessPayment(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strNafNumber, int intServiceType, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean calculateTax(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, double dblAmount, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean getCallRates(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, int intSCCode, int intDCCode, int intFetchFlag, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean CCDCAuthentication(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean rechargeAccount(java.lang.String strAuthKey, java.lang.String strEduid, int intInteractionType, java.lang.String strRegisteredNumber, java.lang.String strPinNumber, int intServiceType, int intValidateType, java.lang.String strRechargeMode, double dblAmount, java.lang.String strUseCard, java.lang.String strInstNumber, java.lang.String strInstExpiryDate, java.lang.String strInstCode, java.lang.String strInstType, java.lang.String strInstOneTime, java.lang.String strProductCode, javax.xml.rpc.holders.StringHolder strMessage, javax.xml.rpc.holders.StringHolder strResponseXml) throws java.rmi.RemoteException;
    public boolean validatePhysicalCCPin(java.lang.String authKey, java.lang.String pinNumber, javax.xml.rpc.holders.StringHolder message, javax.xml.rpc.holders.StringHolder IVRResponseXml) throws java.rmi.RemoteException;
}
