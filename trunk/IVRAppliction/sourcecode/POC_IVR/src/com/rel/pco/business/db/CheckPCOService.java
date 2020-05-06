package com.rel.pco.business.db;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import com.rcom.smartphone.model.ILD_Check;
import com.rcom.smartphone.resource.IVRDBServiceInstance;
import com.servion.gcc.framework.common.CustomData;
import com.servion.gcc.framework.common.Logger;
import com.servion.gcc.framework.definer.decisiondefiner.DecisionInterface;
import com.servion.gcc.framework.util.ApplicationConstantInterface;
import com.servion.util.IVRDataBean;

public class CheckPCOService implements DecisionInterface {

	private static final String No="No";
	private static final String Yes="Yes";
	public String doExecute(Logger logger, CustomData cData,
			Map<String, Object> mapDecisionData,
			Map<String, Object> mapHostDetails) {
		String strExitState=ApplicationConstantInterface.ERROR;
		String strMDN = ApplicationConstantInterface.EMPTY;
		String resultFlag = ApplicationConstantInterface.EMPTY;
		IVRDataBean ivrDataBean=(IVRDataBean) cData.getSessionData(ApplicationConstantInterface.IVRDATABEAN);
		try{
			strMDN = (String)cData.getSessionData("S_STR_DNIS");
			cData.addToLog("MDN : ",strMDN);
			ILD_Check objILD_Check =new ILD_Check();
			objILD_Check.setMDN(strMDN);
			objILD_Check = IVRDBServiceInstance.getIVRDBInstance().getILD_Check(ivrDataBean,objILD_Check);
			
			resultFlag = objILD_Check.getresultFlag();
			cData.addToLog("Result Flag : ",resultFlag);
			if(No.equalsIgnoreCase(resultFlag)){
				strExitState=No;	
			}else{
				strExitState=Yes;
			}
			
		}catch(Exception e){
			StringWriter str=new StringWriter();
			e.printStackTrace(new PrintWriter(str));
			cData.addToLog(this.getClass().getName(),"Exception :"+str.toString());
		}
		return strExitState;
	}
	
}
