package com.hpe.util;

import java.io.StringReader;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLParser {
	

	public String parseXML(String respXML, String attrib)
			{
	                            //     respXML = "<?xml version='1.0' encoding='UTF-8'?><Response><AuthKey>703A07A0EA77383BE340AA3279630EB94938260A03838E40</AuthKey><TransactionId>205414331</TransactionId><ProductCode>RGC</ProductCode><RequestedMethodName>IVR Account Balance</RequestedMethodName><Message>Success</Message><TFLandLineRate></TFLandLineRate><TFMobileRate></TFMobileRate><TALandLineRate></TALandLineRate><TAMobileRate></TAMobileRate><CustomerId>910000000006266</CustomerId><CutomerType>PREPAID</CutomerType><AccountBalance>79.31</AccountBalance><BucketBalance>0</BucketBalance><BalanceExpDate>9/3/2016 12:59:50 PM</BalanceExpDate><BucketBalExpDate></BucketBalExpDate><Currency>INR</Currency><RechargeMode></RechargeMode><RechargeMessage></RechargeMessage><BillAmount></BillAmount><TaxAmount></TaxAmount><TotalAmount></TotalAmount><LastCCDCNo></LastCCDCNo><LastCCDCType></LastCCDCType><LastBillAmount></LastBillAmount><LastTaxAmount></LastTaxAmount><RecieptNo></RecieptNo><UIPBalance></UIPBalance><UIPExpiryDate></UIPExpiryDate><UIPTAMin></UIPTAMin><UIPTFMin></UIPTFMin></Response>";
	                                String value = "";
	                                boolean bAccntBalance = false;
	                                try
	                                {
	                                                XMLInputFactory factory = XMLInputFactory.newInstance();
	                                                XMLEventReader eventRdr = factory.createXMLEventReader(new StringReader(respXML));
	                                                while(eventRdr.hasNext())
	                                                {
	                                                                XMLEvent event = eventRdr.nextEvent();
	                                                                switch(event.getEventType())
	                                                                {
	                                case XMLStreamConstants.START_ELEMENT:
	                                   StartElement startElement = event.asStartElement();
	                                   String qName = startElement.getName().getLocalPart();
	                                                if(qName.equalsIgnoreCase(attrib))
	                                                {
	                                                                bAccntBalance = true;
	                                                }
	                                                break;
	                                case XMLStreamConstants.CHARACTERS:
	                                    Characters characters = event.asCharacters();    
	                                                if(bAccntBalance)
	                                                {
	                                                               // TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"AccountBalance is - "+characters.getData(), mySession);
	                                                                bAccntBalance = false;
	                                                                
	                                                                value =  characters.getData();
	                                                                
	                                                }
	                                            break;    
	                                                                }     
	                                                                
	                                                }
	                                  return value;
	                                               
	                                }
	                                catch(XMLStreamException xmlEx)
	                                {
	                                	return xmlEx.getMessage();
	                                }
	                                catch(Exception ex)
	                                {
	                                	return ex.getMessage();
	                                }
	                

	}

}
