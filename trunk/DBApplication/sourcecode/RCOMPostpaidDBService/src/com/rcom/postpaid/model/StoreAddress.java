package com.rcom.postpaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.rcom.postpaid.resource.Constants;

/**
 * 
 * @author deepanyuvaraja.r
 *
 */

@Entity(name = Constants.IVR_StoreDetails)
@NamedStoredProcedureQuery(name  = Constants.PROC_IVR_StoreDetails, procedureName = Constants.SP_IVR_StoreDetails, 
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.PINCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.StoreAddress, type = String.class)
})
public class StoreAddress {
	
	@Id
	@Column(name = Constants.PINCode)
	private String pinCode;
	@Column(name = Constants.StoreAddress)
	private String storeAddress;
	
	
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[PinCode:"+pinCode);
		builder.append(", StoreAddress:"+storeAddress+"]");
		return builder.toString();
	}
	

}
