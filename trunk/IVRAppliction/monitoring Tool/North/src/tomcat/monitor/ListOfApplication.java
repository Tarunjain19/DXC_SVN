package tomcat.monitor;

import java.util.ArrayList;
import java.util.List;

public class ListOfApplication {
	
	static List<String> myList = new ArrayList<String>();
	
	
	public static List<String> applicationList() {
		
		String Applicationnameseperatedwithcomma=Readprop.Proper("ApplicationName");
		 for (String Listofapp: Applicationnameseperatedwithcomma.split(",")){
	         //System.out.println("ListOfIP"+Listofapp);
		
		myList.add(Listofapp);
		 }
		/*
		myList.add("RCOM_PREPAID");
		myList.add("RCOM_POSTPAID");
		myList.add("RCOM_TVP");
		myList.add("RCOM_CF_RDTV_IVR");
		*/
		return myList;
	}

}
