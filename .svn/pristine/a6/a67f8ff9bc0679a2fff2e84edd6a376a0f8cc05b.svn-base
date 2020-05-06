package com.rcom.hostinterface.util;
import javax.xml.parsers.*;

import org.xml.sax.InputSource;
import org.w3c.dom.*;

import com.rcom.hostinterface.view.ResActivePacks;

import java.io.*;

public class DOMParsing {

	@SuppressWarnings("finally")
	public ResActivePacks domParsing(ResActivePacks resActivePacks,String xmlRecords){
		// String xmlRecords ="<VAS_PACK><PACK><PACK_SOURCE>CP</PACK_SOURCE><PACK_TYPE>DATA</PACK_TYPE><PACK_CONSENT/><PACK_TRANS_ID/><PACK_RNWL_DATE/><PACK_NAME>Caller tunes</PACK_NAME><PACK_CODE>1003</PACK_CODE><PACK_VALIDITY>30</PACK_VALIDITY><PACK_AMOUNT>30</PACK_AMOUNT></PACK><CODE>0</CODE><MESSAGE>SUCCESS</MESSAGE></VAS_PACK>";
		 String code ="1";
		 String packName_list ="";
		 String packCode_list ="";
		 String responseMsg = "NA";
		 try{
			 DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			 InputSource is = new InputSource();
			 is.setCharacterStream(new StringReader(xmlRecords));
			 Document doc = db.parse(is);
			 NodeList node = doc.getElementsByTagName("CODE");
			 Element line = (Element) node.item(0);
			 code = getCharacterDataFromElement(line);
		 
			 System.out.println("Code: " + getCharacterDataFromElement(line));
       
			 if(code !=""&&code !="NA" && code !=null)
			 	{
				  	if(code.equalsIgnoreCase("0")){
        	           NodeList nodes = doc.getElementsByTagName("PACK");
        	           if(nodes.getLength()!=0){
        	        	   for (int i = 0; i < nodes.getLength(); i++) {
        	        		   Element element = (Element) nodes.item(i);

        	        		   NodeList name = element.getElementsByTagName("PACK_NAME");
        	        		   Element line1 = (Element) name.item(0);
        	        		   System.out.println("Pack Name: " + getCharacterDataFromElement(line1));
        	        		   packName_list = packName_list+getCharacterDataFromElement(line1)+"|";

        	        		   NodeList title = element.getElementsByTagName("PACK_CODE");
        	        		   line = (Element) title.item(0);
        	        		   System.out.println("PackCode: " + getCharacterDataFromElement(line));
        	        		   packCode_list = packCode_list+getCharacterDataFromElement(line)+",";
        	        	   }
        	        	   System.out.println("Pack Code list:"+packCode_list);
        	        	   System.out.println("packName_list:"+packName_list);
        	        	   packCode_list = packCode_list.substring(0,packCode_list.length()-1);
        	        	   System.out.println("packName_list after trimming:"+packCode_list);
        	        	   responseMsg = "Packs are available";
        	           }
        	           else{
        	        	   System.out.println("No packs are active");
        	        	   responseMsg = "No Packs Available";
        	        	   packCode_list ="NA";
        	        	   packName_list = "NA";
        	        	   
        	           }
        	 }
        	 else
        		 System.out.println("In valid Response");
         }
			
		 }
		 catch(Exception e){}
		finally
		{
			resActivePacks.setResponseCode(code);
			resActivePacks.setPackCodes(packCode_list);
			resActivePacks.setPackNames(packName_list);
			resActivePacks.setResponseMessage(responseMsg);
			return resActivePacks;
		}

	}
	 public static String getCharacterDataFromElement(Element e) {
		    Node child = e.getFirstChild();
		    if (child instanceof CharacterData) {
		       CharacterData cd = (CharacterData) child;
		       return cd.getData();
		    }
		    return "NA";
		  }
		}


