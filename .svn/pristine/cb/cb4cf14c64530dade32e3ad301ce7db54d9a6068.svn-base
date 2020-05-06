package com.servion.rcom.hostinterface.wrapper;

import com.servion.rcom.hostinterface.view.ReqAccountDetails;
import com.servion.rcom.hostinterface.view.ReqDuplicateBillRequest;
import com.servion.rcom.hostinterface.view.ReqLastPaymentDetails;
import com.servion.rcom.hostinterface.view.ReqLatestBillGenDetails;
import com.servion.rcom.hostinterface.view.ReqRegisterFireAndShockComplaint;
import com.servion.rcom.hostinterface.view.ReqRegisterNoSupplyComplaint;
import com.servion.rcom.hostinterface.view.ReqValidateAccountNumber;
import com.servion.rcom.hostinterface.view.ResAccountDetails;
import com.servion.rcom.hostinterface.view.ResDuplicateBillRequest;
import com.servion.rcom.hostinterface.view.ResLastPaymentDetails;
import com.servion.rcom.hostinterface.view.ResLatestBillGenDetails;
import com.servion.rcom.hostinterface.view.ResRegisterFireAndShockComplaint;
import com.servion.rcom.hostinterface.view.ResRegisterNoSupplyComplaint;
import com.servion.rcom.hostinterface.view.ResValidateAccountNumber;
import com.servion.util.IVRDataBean;


public interface IVRWebService {



	/**
	 * 
	 * @param ivrDataBean
	 * @param reqLatestBillGenDetails
	 * @return ResLatestBillGenDetails
	 */
	public ResLatestBillGenDetails getLatestBillGenerationDetails(IVRDataBean ivrDataBean, ReqLatestBillGenDetails reqLatestBillGenDetails);
	
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqDuplicateBillRequest
	 * @return ResDuplicateBillRequest
	 */
	public ResDuplicateBillRequest registerDuplicateBillRequest(IVRDataBean ivrDataBean, ReqDuplicateBillRequest reqDuplicateBillRequest);
	
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqLastPaymentDetails
	 * @return ResLastPaymentDetails
	 */
	public ResLastPaymentDetails getLastPaymentDetails(IVRDataBean ivrDataBean, ReqLastPaymentDetails reqLastPaymentDetails);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqValidateAccountNumber
	 * @return ResValidateAccountNumber
	 */
	public ResValidateAccountNumber validateAccountNumber(IVRDataBean ivrDataBean, ReqValidateAccountNumber reqValidateAccountNumber);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqRegisterFireAndShockComplaint
	 * @return ResRegisterFireAndShockComplaint
	 */
	public ResRegisterFireAndShockComplaint registerFireAndShockComplaint(IVRDataBean ivrDataBean, ReqRegisterFireAndShockComplaint reqRegisterFireAndShockComplaint);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqRegisterNoSupplyComplaint
	 * @return ResRegisterNoSupplyComplaint
	 */
	public ResRegisterNoSupplyComplaint registerNoSupplyComplaint(IVRDataBean ivrDataBean, ReqRegisterNoSupplyComplaint reqRegisterNoSupplyComplaint);
	
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqAccountDetails
	 * @return ResAccountDetails
	 */
	public ResAccountDetails getAccountDetails(IVRDataBean ivrDataBean, ReqAccountDetails reqAccountDetails);
}
