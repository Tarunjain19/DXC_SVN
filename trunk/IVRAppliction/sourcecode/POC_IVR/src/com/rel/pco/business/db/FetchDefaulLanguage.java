package com.rel.pco.business.db;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import com.rcom.smartphone.model.IVRRoutingInfo;
import com.rcom.smartphone.resource.IVRDBServiceInstance;
import com.servion.gcc.framework.common.CustomData;
import com.servion.gcc.framework.common.Logger;
import com.servion.gcc.framework.definer.decisiondefiner.DecisionInterface;
import com.servion.gcc.framework.util.ApplicationConstantInterface;
import com.servion.util.IVRDataBean;

public class FetchDefaulLanguage implements DecisionInterface{

	private static final String Success="Success";
	private static final String DEFAULT_LANG="DEFAULT_LANG";
	private static final String APPLICABLE_LANG="APPLICABLE_LANG";

	public String doExecute(Logger logger, CustomData cData,
			Map<String, Object> mapDecisionData,
			Map<String, Object> mapHostDetails) {
		String strExitState=ApplicationConstantInterface.ERROR;
		try{	
			getAppLanguage(logger, cData);
			
			strExitState=Success;
		}catch(Exception e){
			StringWriter str=new StringWriter();
			e.printStackTrace(new PrintWriter(str));
			cData.addToLog(this.getClass().getName(),"Exception :"+str.toString());
		}
		return strExitState;
	}


	/** Access Database to retrieve Applicable Languages, Circle ID
	 * @param logger
	 * @param cData
	 */
	public void getAppLanguage(Logger logger,CustomData cData){
		try{
			
			String strDNIS=(String) cData.getSessionData(ApplicationConstantInterface.S_STR_DNIS);
			IVRDataBean ivrDataBean=(IVRDataBean) cData.getSessionData(ApplicationConstantInterface.IVRDATABEAN);	
			IVRRoutingInfo beanIVRoutingInfo=new IVRRoutingInfo();
			beanIVRoutingInfo.setDnis(strDNIS);
			beanIVRoutingInfo=IVRDBServiceInstance.getIVRDBInstance().getIVRRoutingInfo(ivrDataBean,beanIVRoutingInfo);

			if(beanIVRoutingInfo!=null){
				String strDefaultLangauge=beanIVRoutingInfo.getDefaultLanguage();
				String strApplicableLanguages=beanIVRoutingInfo.getLanguage();
				cData.setSessionData(DEFAULT_LANG,strDefaultLangauge);
				cData.setSessionData(APPLICABLE_LANG,strApplicableLanguages);
				
				cData.addToLog("DEFAULT_LANG",strDefaultLangauge);
				cData.addToLog("APPLICABLE_LANG",strApplicableLanguages);
			}
		}catch(Exception e){
			cData.StackTrace(e);
		}
	}

}
