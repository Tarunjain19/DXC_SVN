package com.servion.rcom.hostinterface.wrapper;

import com.servion.rcom.hostinterface.TransAccountDetails;
import com.servion.rcom.hostinterface.TransDuplicateBillRequest;
import com.servion.rcom.hostinterface.TransLastPaymentDetails;
import com.servion.rcom.hostinterface.TransLatestBillGenDetails;
import com.servion.rcom.hostinterface.TransRegisterFireAndShockComplaint;
import com.servion.rcom.hostinterface.TransRegisterNoSupplyComplaint;
import com.servion.rcom.hostinterface.TransValidateAccountNumber;
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


public class IVRWebServiceImpl implements IVRWebService{

	@Override
	public ResLatestBillGenDetails getLatestBillGenerationDetails(IVRDataBean ivrDataBean, ReqLatestBillGenDetails reqLatestBillGenDetails) {
		
		TransLatestBillGenDetails transLatestBillGenDetails = new TransLatestBillGenDetails();
		return transLatestBillGenDetails.getHostInterface(ivrDataBean, reqLatestBillGenDetails);
		
	}

	@Override
	public ResDuplicateBillRequest registerDuplicateBillRequest(IVRDataBean ivrDataBean,ReqDuplicateBillRequest reqDuplicateBillRequest) {

		TransDuplicateBillRequest transDuplicateBillRequest = new TransDuplicateBillRequest();
		return transDuplicateBillRequest.getHostInterface(ivrDataBean, reqDuplicateBillRequest);
	}

	@Override
	public ResLastPaymentDetails getLastPaymentDetails(IVRDataBean ivrDataBean, ReqLastPaymentDetails reqLastPaymentDetails) {
		
		TransLastPaymentDetails transLastPaymentDetails = new TransLastPaymentDetails();
		return transLastPaymentDetails.getHostInterface(ivrDataBean, reqLastPaymentDetails);
	}

	@Override
	public ResValidateAccountNumber validateAccountNumber(IVRDataBean ivrDataBean, ReqValidateAccountNumber reqValidateAccountNumber) {
		
		TransValidateAccountNumber transValidateAccountNumber = new TransValidateAccountNumber();
		return transValidateAccountNumber.getHostInterface(ivrDataBean, reqValidateAccountNumber);
	}

	@Override
	public ResRegisterFireAndShockComplaint registerFireAndShockComplaint(IVRDataBean ivrDataBean, ReqRegisterFireAndShockComplaint reqRegisterFireAndShockComplaint) {

		TransRegisterFireAndShockComplaint transRegisterFireAndShockComplaint = new TransRegisterFireAndShockComplaint();
		return transRegisterFireAndShockComplaint.getHostInterface(ivrDataBean, reqRegisterFireAndShockComplaint);
	}

	@Override
	public ResRegisterNoSupplyComplaint registerNoSupplyComplaint(IVRDataBean ivrDataBean, ReqRegisterNoSupplyComplaint reqRegisterNoSupplyComplaint) {

		TransRegisterNoSupplyComplaint transRegisterNoSupplyComplaint = new TransRegisterNoSupplyComplaint();
		return transRegisterNoSupplyComplaint.getHostInterface(ivrDataBean, reqRegisterNoSupplyComplaint);
	}

	@Override
	public ResAccountDetails getAccountDetails(IVRDataBean ivrDataBean, ReqAccountDetails reqAccountDetails) {

		TransAccountDetails transAccountDetails = new TransAccountDetails();
		return transAccountDetails.getHostInterface(ivrDataBean, reqAccountDetails);
	}

	

	
}
