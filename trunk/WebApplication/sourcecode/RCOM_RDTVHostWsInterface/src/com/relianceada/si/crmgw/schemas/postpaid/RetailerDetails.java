package com.relianceada.si.crmgw.schemas.postpaid;

public class RetailerDetails {

	private String msgType;
	private String source;
	private String pinCode;
	private String cliNo;
	private String count;
	private String reponseCode;
	
	
	public String getReponseCode() {
		return reponseCode;
	}
	public void setReponseCode(String reponseCode) {
		this.reponseCode = reponseCode;
	}
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCliNo() {
		return cliNo;
	}
	public void setCliNo(String cliNo) {
		this.cliNo = cliNo;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "RetailerDetails :: msgType=" + msgType + ", source=" + source
				+ ", pinCode=" + pinCode + ", cliNo=" + cliNo + ", count="
				+ count + ", reponseCode=" + reponseCode + "]";
	}
	
	
}
