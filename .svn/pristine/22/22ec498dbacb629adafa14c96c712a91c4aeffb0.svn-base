package com.hp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.avaya.sce.runtime.tracking.TraceInfo;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;

/**
 * Access the Properties file related to config.properties file.
 */
public class TVP_Properties{

	//Stores the Last Modified Time of the file.
	private static long lastModifiedTime = 0L;

	private static TVP_Properties uidaiProp = null;
	private static String configFileName = null;
	private static Properties storeProps = null;
	
	private TVP_Properties(SCESession session) {
		refresh(session);
	}
	
	public static TVP_Properties getInstance(String fName,SCESession session) {
		
		configFileName = fName;
		
		if (session!=null){
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "Setting the FileName :: "+fName, session);
		}
		
		return getInstance(session);
	}
	
	public static TVP_Properties getInstance(SCESession session) {
	
		if (uidaiProp == null){
			uidaiProp= new TVP_Properties(session);
			if (session!=null){
				TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "TVP Properties is NULL. So a new Instance is created.", session);
			}
		}
		
		return uidaiProp;
	}
	
	public String getProperty(SCESession session,String key) {
		
		refresh(session);
		
		if (storeProps==null){
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_ERROR, "PROPERTY IS NOT LOADED", session);
			return null;
		}
		
		return storeProps.getProperty(key);
	}
	

	public String getProperty(SCESession session, String key, String defaultValue) {
		
		refresh(session);
		
		if (storeProps==null){
			
			if (session!=null){
				TraceInfo.trace(ITraceInfo.TRACE_LEVEL_ERROR, "PROPERTY IS NOT LOADED", session);
			}
			return defaultValue;
		}
		
		return storeProps.getProperty(key,defaultValue);
	}
	
	private void refresh(SCESession session) {

		FileInputStream fis = null;
		long currentLastModifiedtime =0;
		
		try {
			
			File configFile = new File(configFileName);
			currentLastModifiedtime =configFile.lastModified();
			if (lastModifiedTime!=currentLastModifiedtime){
			
				synchronized (this) {
					
					if (lastModifiedTime<currentLastModifiedtime&& currentLastModifiedtime!=0){
						
						if (session!=null){
							TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "The config file has been changed. lastModifiedTime<"+lastModifiedTime+">!=configFile_lastModifiedTime<"+configFile.lastModified()+">", session);
							TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "Reloading the config file properties.", session);
						}
						fis = new FileInputStream(configFile);
						
						if (storeProps==null) {
							storeProps = new Properties();
						}
						else {
							storeProps.clear();
						}
						
						storeProps.load(fis);
						lastModifiedTime = configFile.lastModified();
					}
				}
			}
		}
		catch (Exception e) {
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_ERROR, "Exception stack Trace :: " ,e, session);
		}
		finally {
			
			if (fis!=null) {
				
				try {
					fis.close();
				}
				catch (Exception ex) {

				}
				finally{
					fis = null;
				}
			}
		}
	}	
}

