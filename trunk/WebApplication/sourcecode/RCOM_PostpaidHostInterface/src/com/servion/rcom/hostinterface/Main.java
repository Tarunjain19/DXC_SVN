package com.servion.rcom.hostinterface;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.rcom.hostinterface.view.ReqActivateBooster;
import com.servion.rcom.hostinterface.view.ReqDuplicateBill;
import com.servion.rcom.hostinterface.view.ResActivateBooster;
import com.servion.rcom.hostinterface.view.ResDuplicateBill;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class Main {
	
	/*private static String bytes2String(byte[] bytes)
	{
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++)
		{
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}*/
	
	public static void main(String[] args)
	{
				
		Logger logger = Logger.getLogger(Main.class);
		AppProperties.setInstance("Postpaid_IVR_CONFIG", "C:\\RCOM\\Postpaid\\");
		
		
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		
		
		IVRDataBean ivrDataBean = new IVRDataBean();
		GetReportObject  getReportObject = new GetReportObject();
		getReportObject.setIvrreportdata(getReportObject.createIVRReportObject());
		ivrDataBean.setSessionID("1234");
		ivrDataBean.setLogger(logger);
		ivrDataBean.setGetReportObject(getReportObject);
		
		/*ReqAccountBalance req = new ReqAccountBalance();
		req.setMDN("9942530028");
		
		ResAccountBalance res = ivrWebService.executeAccountBalance(ivrDataBean, req);
		System.out.println("Response Code : " +res.getResponseCode());
		System.out.println("Account Balance : " +res.getAccBalance());
		System.out.println("Account Balance Expiry Date : "+res.getAccBalanceExpiryDate());*/
		
		/*ReqActivateVAS reqActivateVAS = new ReqActivateVAS();
		reqActivateVAS.setMDN("9942530028");
		reqActivateVAS.setPackCode("1003");
		
		ResActivateVAS resActivateVAS = ivrWebService.executeActivateVAS(ivrDataBean, reqActivateVAS);
		
		System.out.println(resActivateVAS.getResponseCode());
		System.out.println(resActivateVAS.getMessageText());*/
		
		/*ReqActivePackDetails reqActivePackDetails = new ReqActivePackDetails();
		reqActivePackDetails.setMDN("9942530028");
		
		ResActivePackDetails resActivePackDetails = ivrWebService.executeActivePackDetails(ivrDataBean, reqActivePackDetails);
		
		System.out.println(resActivePackDetails.getResponseCode());
		System.out.println(resActivePackDetails.getMessageText());*/
		
		/*ReqActivePlanDetails reqActivePlanDetails = new ReqActivePlanDetails();
		reqActivePlanDetails.setMDN("9942530028");
		
		ResActivePlanDetails resActivePlanDetails = ivrWebService.executeActivePlanDetails(ivrDataBean, reqActivePlanDetails);
		
		System.out.println(resActivePlanDetails.getResponseCode());
		ArrayList<PlanDetails> planDetailsList = resActivePlanDetails.getPlanDetailsList();
		System.out.println(planDetailsList);
		
		for(PlanDetails planDetails : planDetailsList)
		{
			System.out.println(planDetails.getRatePlan());
			System.out.println(planDetails.getMontlyRentalCharge());
		}*/
		
		
		/*ReqDataBalance reqDataBalance = new ReqDataBalance();
		reqDataBalance.setMDN("9942530028");
		
		ResDataBalance resDataBalance = ivrWebService.executeDataBalance(ivrDataBean, reqDataBalance);
		
		System.out.println(resDataBalance.getResponseCode());
		System.out.println("2G net balance : " +resDataBalance.getTwoGNetBalance());
		System.out.println("2G net balance Expiry Date : "+ resDataBalance.getTwoGNetBalanceExpiryDate());
		System.out.println("2G FU balance : " +resDataBalance.getTwoGFairUsageBalance());
		System.out.println("2G FU balance Expiry Date : "+ resDataBalance.getTwoGFairUsageBalanceExpiryDate());
		System.out.println("3G net balance : " +resDataBalance.getThreeGNetBalance());
		System.out.println("3G net balance Expiry Date : "+ resDataBalance.getThreeGNetBalanceExpiryDate());
		System.out.println("3G FU balance : " +resDataBalance.getThreeGFairUsageBalance());
		System.out.println("3G FU balance Expiry Date : "+ resDataBalance.getThreeGFairUsageBalanceExpiryDate());*/
		
		
		/*ReqGPRSSettingsDownload reqGPRSSettingsDownload = new ReqGPRSSettingsDownload();
		reqGPRSSettingsDownload.setMDN("99425300258");
		
		ResGPRSSettingsDownload resGPRSSettingsDownload = ivrWebService.executeGPRSSettingsDownload(ivrDataBean, reqGPRSSettingsDownload);
		
		System.out.println(resGPRSSettingsDownload.getResponseCode());*/
		
		
		/*ReqLastRechargeDetails reqLastRechargeDetails = new ReqLastRechargeDetails();
		reqLastRechargeDetails.setMDN("9942530028");
		
		ResLastRechargeDetails resLastRechargeDetails = ivrWebService.executeLastRechargeDetails(ivrDataBean, reqLastRechargeDetails);
		
		System.out.println("Response Code : " + resLastRechargeDetails.getResponseCode());
		ArrayList<RechargeDetails> rechargeDetailsList = resLastRechargeDetails.getRechargeDetailsList();
		
		for(RechargeDetails rechargeDetails : rechargeDetailsList)
		{
			System.out.println("Amount : " +rechargeDetails.getAmount());
			System.out.println("Date : " + rechargeDetails.getDate());
			System.out.println("Talktime : " +rechargeDetails.getTalktime());
			System.out.println("Type : " +rechargeDetails.getType());
			System.out.println("----------------------------------");
		}*/
		
		
		/*ReqNonActivePackDetails reqNonActivePackDetails = new ReqNonActivePackDetails();
		reqNonActivePackDetails.setMDN("9942530028");
		
		ResNonActivePackDetails resNonActivePackDetails = ivrWebService.executeNonActivePackDetails(ivrDataBean, reqNonActivePackDetails);
		
		System.out.println("Response Code : " +resNonActivePackDetails.getResponseCode());
		
		ArrayList<PackDetails> packDetailsList = resNonActivePackDetails.getPackDetailsList();
		
		for(PackDetails packDetails : packDetailsList)
		{
			System.out.println("Pack Name : " +packDetails.getName());
			System.out.println("Pack Code : " +packDetails.getCode());
			System.out.println("Pack Expiry Date : " +packDetails.getExpiryDate());
			System.out.println("Pack Validity : " + packDetails.getValidity());
			System.out.println("-----------------------------------------");
		}*/
		
		/*ReqPaymentUsingCoreBalance reqPaymentUsingCoreBalance = new ReqPaymentUsingCoreBalance();
		
		reqPaymentUsingCoreBalance.setMDN("9942530028");
		reqPaymentUsingCoreBalance.setPackName(null"ALTZEETALKIES");
		
		ResPaymentUsingCoreBalance resPaymentUsingCoreBalance = ivrWebService.executePaymentUsingCoreBalance(ivrDataBean, reqPaymentUsingCoreBalance);
		
		System.out.println("Response Code : " +resPaymentUsingCoreBalance.getResponseCode());
		System.out.println("Message Text : " +resPaymentUsingCoreBalance.getMessageText());
		*/
		
		/*ReqServiceRequestDetails reqServiceRequestDetails = new ReqServiceRequestDetails();
		reqServiceRequestDetails.setMDN("9942530028");
		
		ResServiceRequestDetails resServiceRequestDetails = ivrWebService.executeServiceRequestDetails(ivrDataBean, reqServiceRequestDetails);
		
		System.out.println("Response Code : " +resServiceRequestDetails.getResponseCode());
		System.out.println("Is SR Available : " +resServiceRequestDetails.isServiceRequestAvailable());
		System.out.println("SR ID : " +resServiceRequestDetails.getServiceRequestID());
		System.out.println("SR Status : " +resServiceRequestDetails.getServiceRequestStatus());
		System.out.println("SR Creation Date : " +resServiceRequestDetails.getServiceRequestCreationDate());
		System.out.println("SR Type : " +resServiceRequestDetails.getServiceRequestType());
		System.out.println("SR SLA Date : " +resServiceRequestDetails.getServiceRequestSLADate());*/
		
		
		/*ReqPaymentUsingCreditcard reqPaymentUsingCreditcard = new ReqPaymentUsingCreditcard();
		reqPaymentUsingCreditcard.setAmount("100");
		reqPaymentUsingCreditcard.setMDN("9942530028");
		reqPaymentUsingCreditcard.setMDNToBeRecharged("9942153546");
		reqPaymentUsingCreditcard.setOTP("3123");
		reqPaymentUsingCreditcard.setTopUpCode("TOPUP");
		
		CreditCardDetails cardDetails = new CreditCardDetails();
		cardDetails.setCardCVV("121");
		cardDetails.setCardExpiryDate("122017");
		cardDetails.setCardNumber("12345678912345678");
		cardDetails.setCardType("V");
		
		reqPaymentUsingCreditcard.setCreditCardDetails(cardDetails);
		
		ResPaymentUsingCreditcard resPaymentUsingCreditcard = ivrWebService.executePaymentUsingCreditcard(ivrDataBean, reqPaymentUsingCreditcard);
		
		System.out.println("Response Code : " +resPaymentUsingCreditcard.getResponseCode());
		System.out.println("Payment ID : " +resPaymentUsingCreditcard.getPaymentId());*/
		
		
		/*ReqTopUpAmountValidation reqTopUpAmountValidation = new ReqTopUpAmountValidation();
		reqTopUpAmountValidation.setMDN("9942530025");
		reqTopUpAmountValidation.setMDNToBeRecharged("9942530025");
		
		ResTopUpAmountValidation resTopUpAmountValidation = ivrWebService.executeTopUpAmountValidation(ivrDataBean, reqTopUpAmountValidation);
		
		System.out.println("Response code : " +resTopUpAmountValidation.getResponseCode());
		System.out.println("Current Top up amount talktime : " +resTopUpAmountValidation.getCurrentTopupAmountTalktime());
		System.out.println("Max Val : "+resTopUpAmountValidation.getMaxVal());
		System.out.println("Max Val Talk time : " +resTopUpAmountValidation.getMaxValTalktime());
		System.out.println("Min Val : " +resTopUpAmountValidation.getMinVal());
		System.out.println("Min Val Talk time : " +resTopUpAmountValidation.getMinValTalktime());*/
		
		/*ReqPushSMS reqPushSMS = new ReqPushSMS();
		reqPushSMS.setMDN("9978563214");
		reqPushSMS.setMessageText("MESSAGEMESSAGE");
		
		ResPushSMS resPushSMS = ivrWebService.executePushSMS(ivrDataBean, reqPushSMS);
		
		System.out.println("Response Code : " +resPushSMS.getResponseCode());*/
		
		
		/*ReqUnbilledInfo reqUnbilledInfo = new ReqUnbilledInfo();
		reqUnbilledInfo.setMDN("12355");
		
		ResUnbilledInfo resUnbilledInfo = ivrWebService.executeUnbilledInfo(ivrDataBean, reqUnbilledInfo);
		
		System.out.println("Response Code : " +resUnbilledInfo.getResponseCode());
		System.out.println("Unbilled Amount : " +resUnbilledInfo.getUnBilledAmount());
		System.out.println("Sys Date : "  + resUnbilledInfo.getSysDate());*/
		
		/*ReqItemisedBillActivation reqItemisedBillActivation = new ReqItemisedBillActivation();
		reqItemisedBillActivation.setMDN("9942530028");
		
		ResItemizedBillActivation resItemizedBillActivation = ivrWebService.executeItemisedBillActivation(ivrDataBean, reqItemisedBillActivation);
		
		System.out.println("Response Code : " +resItemizedBillActivation.getResponseCode());*/
		
		/*ReqFreeUnitInfo reqFreeUnitInfo = new ReqFreeUnitInfo();
		ResFreeUnitInfo resFreeUnitInfo = ivrWebService.executeFreeUnitInfo(ivrDataBean, reqFreeUnitInfo);
		
		System.out.println("Response Code : " +resFreeUnitInfo.getResponseCode());
		ArrayList<FreeUnitDetails> listFreeUnitDetails = resFreeUnitInfo.getFreeUnitDetailsList();
		
		for(FreeUnitDetails freeUnitDetails: listFreeUnitDetails)
		{
			System.out.println("Free Unit Category : " +freeUnitDetails.getFRU_Category());
		}*/
		
		/*try {
			String encryptedText = Utilities.getAESEncryptedText(logger, "1234567890123456", null);
			System.out.println(encryptedText);
			System.out.println(Utilities.getAESDecryptedText(logger, encryptedText, null));
			
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	/*	try {
			String encText = Utilities.getDESEncryptedText("creditcard", "kesavarao");
			System.out.println(encText);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | InvalidKeySpecException
				| IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			
			System.out.println("Error while encrytpting plain text : " + e);
			System.out.println("Error Message : " + e.getMessage());
			
		}*/
		
		/*try {
			
			String plainText = "creditcard";
			String key = "kesavrao";
			System.out.println(key.getBytes());
			Cipher cipher = Cipher.getInstance("DES");
			
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
			KeySpec keySpec = new DESKeySpec(key.getBytes());
			SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
			
			
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			
			String encryptedText = new BASE64Encoder().encode(cipher.doFinal(plainText.getBytes("UTF8")));
			System.out.println("Encrypted Text : " + encryptedText);
			
			
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			
			String decryptedText = new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(encryptedText)), "UTF8");
			
			System.out.println("Decrypted Text : " + decryptedText);
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		/*HostinterfaceProperties.load("D:/v2.1/ARCOM_Workspace/RCOM_HostInterface/config");
		
		IVRWebService webService = new IVRWebServiceImpl();
		
		
		ReqPaymentValidation req = new ReqPaymentValidation();
		
		CreditCardDetails creditCardDetails = new CreditCardDetails();
		creditCardDetails.setCardCVV("124");
		creditCardDetails.setCardExpiryDate("0616");
		creditCardDetails.setCardNumber("4564778942315556");
		creditCardDetails.setCardType("V");
		
		req.setAmount("100.00");
		req.setMDN("9942530028");
		req.setMDNToBeRecharged("9942530028");
		req.setOTP("4564");
		req.setTopUpCode("TOPUP");
		req.setUniqueId("s1e2s3s4i5o5n6");
		req.setCreditCardDetails(creditCardDetails);
		
		ResPaymentValidation res = webService.executePaymentValidation(req);
		System.out.println(res.getResponseCode());*/
		
		/*ERecharge eRecharge = (ERecharge) Utilities.getObjectFromXML(ERecharge.class, "<ERECHARGE><SESSIONID>string</SESSIONID><AMOUNT>string</AMOUNT><PAYMENTID>NA</PAYMENTID><ERRCODE>-1</ERRCODE><MESSAGE>message</MESSAGE><MINVAL>0</MINVAL><MAXVAL>10</MAXVAL></ERECHARGE>");
		
		System.out.println(eRecharge.toString());*/
		
		
		/*try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(ERecharge.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader("<ERECHARGE><SESSIONID>string</SESSIONID><AMOUNT>string</AMOUNT><PAYMENTID>NA</PAYMENTID><ERRCODE>-1</ERRCODE><MESSAGE>message</MESSAGE><MINVAL>0</MINVAL><MAXVAL>10</MAXVAL></ERECHARGE>");
			
			ERecharge eRecharge = (ERecharge) unmarshaller.unmarshal(reader);
			
			System.out.println(eRecharge.toString());
			
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*ERecharge eRecharge = new ERecharge();	
		
		eRecharge.setSESSIONID("11234564");
		eRecharge.setSOURCE_ID("IVR");
		eRecharge.setSTRMDN("9942530028");
		eRecharge.setUSERMDN("9942530028");
		eRecharge.setTOPUP("TOPUP");
		eRecharge.setCCTYPE("V");
		eRecharge.setCCNO("4556457877795642");
		eRecharge.setCVVNO("024");
		eRecharge.setEXPDATE("0616");
		eRecharge.setOTP("1123");
		eRecharge.setAMOUNT("100.00");
		
		String xmlHeader = "<?xml version=\'1.0\' encoding=\'UTF-8\'?>";
		
		String xml = Utilities.getXML(ERecharge.class, eRecharge, xmlHeader);
		System.out.println(xml);*/
		
		
		/*try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(ERecharge.class);
			
			Marshaller marshaller  = jaxbContext.createMarshaller();
			//marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			//marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			
			ERecharge ERECHARGE = new ERecharge();
			
			ERECHARGE.setSESSIONID("11234322");
			
			StringWriter writer = new StringWriter();
			writer.append("<?xml version=\'1.0\' encoding=\'UTF-8\'?>");
			marshaller.marshal(ERECHARGE, writer);
			
			System.out.println(writer.toString());
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*String URL = "http://97.253.38.9:8077/mvas?type=1&appid=16&channelid=21&mdn=%MDN%&action=1&pname=RBPO-IVR";
		
		
		String mdnMergedURL = URL.replaceFirst("%MDN%", "9942530028");
		System.out.println(mdnMergedURL);*/
		
		
		
		//System.out.println("1,-1".indexOf("-1"));
		/*HostinterfaceProperties.load("D:/v2.1/ARCOM_Workspace/RCOM_HostInterface/config");
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		ReqTopUpAmountValidation req = new ReqTopUpAmountValidation();
		
		req.setAmount("100");
		req.setMDN("45576");
		req.setMDNToBeRecharged("45564");
		
		ResTopUpAmountValidation res = ivrWebService.executeTopUpAmountValidation(new IVRDataBean(), req);
		System.out.println(res.getResponseCode());
		System.out.println(res.getCurrentTopupAmountTalktime());
		System.out.println(res.getMaxVal());
		System.out.println(res.getMaxValTalktime());
		System.out.println(res.getMinVal());
		System.out.println(res.getMinValTalktime());*/
		
		
		
		/*PropertiesBundle bundle = PropertiesBundle.getBundle("webservice");
		String format = bundle.getString(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT);
		
		System.out.println(Utilities.getTimeStamp(format));*/
		
		
		/*ReqURLHitNearestStoreToMDN req = new ReqURLHitNearestStoreToMDN();
		req.setMDN("1234");
		req.setMessageText("Store+Address");
		req.setUniqueId("Unique123123");
		webServiceManager.executeURLHitNearestStoreToMDN(req);
		
		ResURLHitNearestStoreToMDN res = webServiceManager.executeURLHitNearestStoreToMDN(req);
		System.out.println(res.getResponseCode());*/
		
		//IVRWebService ivrWebService = new IVRWebServiceImpl();
		
		/*ReqAccountBalance req = new ReqAccountBalance();
		req.setMDN("4553");
		req.setUniqueId("a24bcdeF");
		ResAccountBalance res = ivrWebService.executeAccountBalance(req);
		System.out.println(res.getResponseCode());
		System.out.println(res.getAccBalance());
		System.out.println(res.getAccBalanceExpiryDate());*/
		
		/*ReqLastRechargeDetails req = new ReqLastRechargeDetails();
		req.setMDN("4553");
		req.setUniqueId("a24bcdeF");
		ResLastRechargeDetails res = ivrWebService.executeLastRechargeDetails(req);
		
		System.out.println(res.getResponseCode());
		System.out.println(res.getLastRechargeAmount());
		System.out.println(res.getLastRechargeDate());*/
		
		/*ReqURLHitUpdateVAS req = new ReqURLHitUpdateVAS();
		req.setMDN("1234");
		req.setPackId("internet pack");
		req.setUrl("http://localhost:8080/URL_HIT_DEMO/LoginServlet");
		
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		ResURLHitUpdateVAS res = ivrWebService.executeURLHitUpdateVAS(req);
		System.out.println(res.getResponseCode());*/
		//URL HIT CHECK
		
		/*try {
			URL url = new URL("http://localhost:8080/URL_HIT_DEMO/LoginServlet?password=peacep&username=teresa");
			 URLConnection urlConnection = url.openConnection();
	         HttpURLConnection connection = null;
	         if(urlConnection instanceof HttpURLConnection)
	         {
	            connection = (HttpURLConnection) urlConnection;
	         }
	         else
	         {
	            System.out.println("Please enter an HTTP URL.");
	            return;
	         }
	         
	         System.out.println(connection.getResponseCode());
	         
	         InputStream inputStream = connection.getInputStream();
	         
	         
	         BufferedReader in = new BufferedReader(
	                 new InputStreamReader(connection.getInputStream()));
	                 String urlString = "";
	                 String current;
	                 while((current = in.readLine()) != null)
	                 {
	                    urlString += current;
	                 }
	                 System.out.println(urlString);


		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*ReqFreeUnitInfo reqFreeUnitInfo = new ReqFreeUnitInfo();
		ResFreeUnitInfo resFreeUnitInfo = ivrWebService.executeFreeUnitInfo(ivrDataBean, reqFreeUnitInfo);
		
		System.out.println("Response Code : " +resFreeUnitInfo.getResponseCode());
		ArrayList<FreeUnitDetails> listFreeUnitDetails = resFreeUnitInfo.getFreeUnitDetailsList();
		
		for(FreeUnitDetails freeUnitDetails: listFreeUnitDetails)
		{
			System.out.println("Free Unit Category : " +freeUnitDetails.getFRU_Category());
		}*/
		
		
		/*ReqBillInfo reqBillInfo = new ReqBillInfo();
		reqBillInfo.setMDN("8144166673");
		
		ivrWebService = new IVRWebServiceImpl();
		ResBillInfo resBillInfo = ivrWebService.executeBillInfo(ivrDataBean, reqBillInfo);
		
		System.out.println(resBillInfo.getResponseCode());*/
		/*if((resBillInfo.getResponseCode()).equals(Constants.zero)){
			
			strDueDate = resBillInfo.getPaymentDueDate();
			dueDate = dateFormat.parse(strDueDate);
			strBillDate = resBillInfo.getBillIssueDate();
			billDate = dateFormat.parse(strBillDate);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			strBillDate = dateFormat.format(billDate);
			strDueDate = dateFormat.format(dueDate);
			
			mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_ACCOUNT_BALANCE).setValue(resBillInfo.getAccountBalance());
			mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_DUE_DATE).setValue(strDueDate);
			mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_INVOICE_AMOUNT).setValue(resBillInfo.getInvoiceAmount());
			mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_ISSUE_DATE).setValue(strBillDate);
			*/
		
		/*ReqLastThreeTransactions reqLastThreeTransactions = new ReqLastThreeTransactions();
		reqLastThreeTransactions.setMDN("8144166673");
		
		ivrWebService = new IVRWebServiceImpl();
		ResLastThreeTransactions resLastThreeTransactions = ivrWebService.executeLastThreeTransactions(ivrDataBean, reqLastThreeTransactions);
		System.out.println(resLastThreeTransactions.getResponseCode());*/
		
		
		/*ReqDNCregistration req = new ReqDNCregistration();
		
		//MDN = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
		//trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Input for DNC Activation Host Service");
		//trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "MDN : " +MDN);
		req.setMDN("9025714681");
		
		ResDNCregistration res = ivrWebService.executeDNCregistration(ivrDataBean, req);
		
		System.out.println(res.getResponseCode());*/
		
		/*ReqActivateVAS reqActivateVAS = new ReqActivateVAS();
		reqActivateVAS.setMDN("9942530028");
		reqActivateVAS.setPackCode("1003");
		
		ResActivateVAS resActivateVAS = ivrWebService.executeActivateVAS(ivrDataBean, reqActivateVAS);
		
		System.out.println(resActivateVAS.getResponseCode());
		System.out.println(resActivateVAS.getMessageText());*/
		
		
		/*ReqServiceRequestDetails reqServiceRequestDetails = new ReqServiceRequestDetails();
		reqServiceRequestDetails.setMDN("8144166673");
		
		ResServiceRequestDetails resServiceRequestDetails = ivrWebService.executeServiceRequestDetails(ivrDataBean, reqServiceRequestDetails);
		
		System.out.println("Response Code : " +resServiceRequestDetails.getResponseCode());
		System.out.println("Is SR Available : " +resServiceRequestDetails.isServiceRequestAvailable());
		System.out.println("SR ID : " +resServiceRequestDetails.getServiceRequestID());
		System.out.println("SR Status : " +resServiceRequestDetails.getServiceRequestStatus());
		System.out.println("SR Creation Date : " +resServiceRequestDetails.getServiceRequestCreationDate());
		System.out.println("SR Type : " +resServiceRequestDetails.getServiceRequestType());
		System.out.println("SR SLA Date : " +resServiceRequestDetails.getServiceRequestSLADate());*/
		
		
		ReqActivateBooster reqActivateBooster = new ReqActivateBooster();
		reqActivateBooster.setMDN("7498018326");
		reqActivateBooster.setpackName("4GTOPUP_75_200MB");
		reqActivateBooster.setPackType("BOOSTER_PACK");
		
		ResActivateBooster resActivateBooster = ivrWebService.executeActivateBooster(ivrDataBean, reqActivateBooster);
		
		System.out.println(resActivateBooster.getResponseCode());
		System.out.println(resActivateBooster.getMessageText());
		
		
		/*ReqDuplicateBill reqDuplicateBill = new ReqDuplicateBill();
		reqDuplicateBill.setMDN("8144166673");
		ResDuplicateBill resDuplicateBill = ivrWebService.executeDuplicateBillRequest(ivrDataBean, reqDuplicateBill);
		System.out.println(resDuplicateBill.getResponseCode());*/
	}

}

