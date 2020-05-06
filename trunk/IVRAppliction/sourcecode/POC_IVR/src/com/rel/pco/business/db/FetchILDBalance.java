package com.rel.pco.business.db;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import com.servion.gcc.framework.common.CustomData;
import com.servion.gcc.framework.common.Logger;
import com.servion.gcc.framework.definer.decisiondefiner.DecisionInterface;
import com.servion.gcc.framework.util.ApplicationConstantInterface;

public class FetchILDBalance implements DecisionInterface{

	public String doExecute(Logger logger, CustomData cData,
			Map<String, Object> mapDecisionData,
			Map<String, Object> mapHostDetails) {
		String strExitState=ApplicationConstantInterface.ERROR;
		try{
			
		}catch(Exception e){
			StringWriter str=new StringWriter();
			e.printStackTrace(new PrintWriter(str));
			cData.addToLog(this.getClass().getName(),"Exception :"+str.toString());
		}
		return strExitState;
	}
}
