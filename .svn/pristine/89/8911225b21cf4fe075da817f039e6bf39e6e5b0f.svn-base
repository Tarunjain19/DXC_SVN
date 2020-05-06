package com.servion.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


/*
 * This class loads the property files.
 * It reads the key entered and returns its values
 */
public class LoadProperty {

	static Logger logger = Logger.getLogger(LoadProperty.class);

	private static Properties ivrconfigProp=new Properties();

	private static long previousLastModifiedTimeivrconfigProp=0;

	private static File ivrconfigPropertyFile=null;

	private  static String ivrconfigPropertyFileName="";



	@SuppressWarnings("static-access")
	public LoadProperty(String ivrconfigPropertyFileName){

		try{

			this.ivrconfigPropertyFileName = ivrconfigPropertyFileName;


			LoadFilePath(ivrconfigPropertyFileName);
			loadivrconfigProperty();


		}
		catch(Exception e){
			logger.error("Error in loading the property files. Exception="+e);
		}
	}

	public static void LoadFilePath(String ivrconfigPropertyFileName){

		ivrconfigPropertyFile=new File(ivrconfigPropertyFileName);


	}


	private  static synchronized void reloadivrconfigPropertyIfChanged() {
		try{
			long currentLastModifiedTime=ivrconfigPropertyFile.lastModified(); 
			if(currentLastModifiedTime > previousLastModifiedTimeivrconfigProp && currentLastModifiedTime!=0) {           
				previousLastModifiedTimeivrconfigProp = currentLastModifiedTime;
				ivrconfigProp.clear();
				logger.info("IVR Config Property File changed and values will be re-loaded ");
				loadivrconfigProperty();
			}
		}
		catch(Exception e){
			logger.error("Exception:"+e);
		}
	}

	private static void loadivrconfigProperty(){
		FileInputStream ivrconfigStream=null;
		try{
			//Reading the ivrconfig properties
			logger.debug("Opening the property file:" + ivrconfigPropertyFileName);
			ivrconfigStream=new FileInputStream(ivrconfigPropertyFile);
			ivrconfigProp.load(ivrconfigStream);
		}
		catch(Exception e){
			logger.error("Error in accessing the property ivrconfigStream.Exception:"+e);
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
				logger.error("Error in closing the property ivrconfigStream.Exception="+e);
			}
		}
	}


	public static String getivrconfigProp(String key){

		if(ivrconfigProp.get(key)!=null){
			return (String) ivrconfigProp.get(key);
		}else{
			return "NA";
		}

	}

}
