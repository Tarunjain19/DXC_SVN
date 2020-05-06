package com.webworld.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/*
 * This class is used to load the config file.
 * This loading is done during the start up of
 * the application or server
 */
public class AppProperties {

	static Logger logger = Logger.getLogger(AppProperties.class);
	
	private static Properties ivrConfigProp=new Properties();
	private static long previousLastModifiedTimeivrConfigProp=0;
	private static File ivrConfigPropertyFile=null;
	private  static String ivrConfigPropertyFileName="";
		
	private static AppProperties loadProperty = null;
	private static String value;
	
	public static AppProperties getInstance(){

		if(loadProperty == null){
			loadProperty = new AppProperties();
		}

		return loadProperty;
	}


	public AppProperties() {
		
	}
	
	@SuppressWarnings("static-access")
	public AppProperties(String ivrconfigPropertyFileName){

		try{
			
			this.ivrConfigPropertyFileName = ivrconfigPropertyFileName;
			
			LoadFilePath(ivrconfigPropertyFileName);
			loadivrConfigProperty();		
		}
		catch(Exception e){
			logger.error("Error in loading the property files. Exception="+e);
		}
	}
	


	public static void LoadFilePath(String ivrconfigPropertyFileName){
		
		ivrConfigPropertyFile=new File(ivrconfigPropertyFileName);
		
	}
	
	
	private  static synchronized void reloadivrConfigPropertyIfChanged() {
		try{
			long currentLastModifiedTime=ivrConfigPropertyFile.lastModified(); 
			if(currentLastModifiedTime > previousLastModifiedTimeivrConfigProp && currentLastModifiedTime!=0) {           
				previousLastModifiedTimeivrConfigProp = currentLastModifiedTime;
				ivrConfigProp.clear();
				logger.info("IVR Config Property File changed and values will be re-loaded ");
				loadivrConfigProperty();
			}
		}
		catch(Exception e){
			logger.error("Exception:"+e);
		}
	}
	
	
	
	
	private static void loadivrConfigProperty(){
		FileInputStream ivrconfigStream=null;
		try{
			//Reading the ivrconfig properties
			logger.debug("Opening the config property file:" + ivrConfigPropertyFileName);
			ivrconfigStream=new FileInputStream(ivrConfigPropertyFile);
			ivrConfigProp.load(ivrconfigStream);
			
		}
		catch(Exception e){
			logger.error("Error in accessing the property ivrConfigStream.Exception:"+e);
		}
		finally{
			try{
				//Closing the properties				
				if(ivrconfigStream!=null){
					logger.debug("Closing the property file");
					ivrconfigStream.close();
				}

			}
			catch(Exception e){
				logger.error("Error in closing the property ivrConfigStream.Exception="+e);
			}
		}
	}
	
	public static String getivrconfigProp(String ivr){
		String custInfo="";
		try{
			reloadivrConfigPropertyIfChanged();
			if(ivrConfigProp.containsKey(ivr)){    			
				value=(String)ivrConfigProp.get(ivr);
				return value.trim();
			}
			else    			
			{
				return "N";
			}
		}
		catch(Exception e){
			logger.error("Exception in reading the ivrConfig property:"+e);
		}
		return custInfo;
	}
}
