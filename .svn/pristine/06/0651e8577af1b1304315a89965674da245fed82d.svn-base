package com.servion.rdtv.hostinterface;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DTH")
@XmlType(propOrder = {"TIBCO_MSG_TYPE", "SOURCE", "PIN_CODE", "CLI_NO", "COUNT"}) 
public class DTH {

	private String TIBCO_MSG_TYPE;
	private String SOURCE;
	private String PIN_CODE;
	private String CLI_NO;
	private String COUNT;
	
	@XmlElement
	public String getTIBCO_MSG_TYPE() {
		return TIBCO_MSG_TYPE;
	}
	public void setTIBCO_MSG_TYPE(String tIBCO_MSG_TYPE) {
		TIBCO_MSG_TYPE = tIBCO_MSG_TYPE;
	}
	@XmlElement
	public String getSOURCE() {
		return SOURCE;
	}
	public void setSOURCE(String sOURCE) {
		SOURCE = sOURCE;
	}
	@XmlElement
	public String getPIN_CODE() {
		return PIN_CODE;
	}
	public void setPIN_CODE(String pIN_CODE) {
		PIN_CODE = pIN_CODE;
	}
	@XmlElement
	public String getCLI_NO() {
		return CLI_NO;
	}
	public void setCLI_NO(String cLI_NO) {
		CLI_NO = cLI_NO;
	}
	public String getCOUNT() {
		return COUNT;
	}
	public void setCOUNT(String cOUNT) {
		COUNT = cOUNT;
	}
	@Override
	public String toString() {
		return "DTH :: TIBCO_MSG_TYPE=" + TIBCO_MSG_TYPE + ", SOURCE=" + SOURCE
				+ ", PIN_CODE=" + PIN_CODE + ", CLI_NO=" + CLI_NO + ", COUNT="
				+ COUNT + "]";
	}
	
	
}
