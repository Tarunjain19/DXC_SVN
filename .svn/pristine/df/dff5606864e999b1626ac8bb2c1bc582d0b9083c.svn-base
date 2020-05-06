package com.servion.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LuhnAlgoImpl {

	    public boolean isValid(long number) {
	    	
	        int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
	        if ((total % 10 == 0) && (prefixMatched(number, 1) == true) && (getSize(number)>=13 ) && (getSize(number)<=16 )) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public static int getDigit(int number) {
	        if (number <= 9) {
	            return number;
	        } else {
	            int firstDigit = number % 10;
	            int secondDigit = (int) (number / 10);
	            return firstDigit + secondDigit;
	        }
	    }
	    public static int sumOfOddPlace(long number) {
	        int result = 0;
	        while (number > 0) {
	            result += (int) (number % 10);
	            number = number / 100;
	        }
	        return result;
	    }
 
	    public static int sumOfDoubleEvenPlace(long number) {
	        int result = 0;
	        long temp = 0;
	        while (number > 0) {
	            temp = number % 100;
	            result += getDigit((int) (temp / 10) * 2);
	            number = number / 100;
	        }
	        return result;
	    }

	    public static boolean prefixMatched(long number, int d) {

	        if ((getPrefix(number, d) == 4)
	                || (getPrefix(number, d) == 5)
	                || (getPrefix(number, d) == 3)) {
	            if (getPrefix(number, d) == 3) {
	                //System.out.println("\nVisa Card ");
	            } else if (getPrefix(number, d) == 5) {
	                //System.out.println("\nMaster Card ");
	            } else if (getPrefix(number, d) == 3) {
	                //System.out.println("\nAmerican Express Card ");
	            }

	            return true;

	        } else {
	            return false;
	        }
	    }

	    public static int getSize(long d) {
	        int count = 0;
	        while (d > 0) {
	            d = d / 10;
	            count++;
	        }
	        return count;

	    }

	    public static long getPrefix(long number, int k) {

	        if (getSize(number) < k) {
	            return number;
	        } else {

	            int size = (int) getSize(number);

	            for (int i = 0; i < (size - k); i++) {
	                number = number / 10;
	            }

	            return number;

	        }

	    }

	    public static void main(String[] args)
	    {
	    	Date dateBillGenDate = null;
	    	String strBillGenDate = "30-JUN-2015";
	    	Date callDate = new Date();
	    	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	    	
	    	try {
				dateBillGenDate = dateFormat.parse(strBillGenDate);
				
				Calendar cal = Calendar.getInstance();
				
				cal.setTime(dateBillGenDate);
				cal.add(Calendar.DATE, 4);
				dateBillGenDate = cal.getTime();
				
				if(dateBillGenDate.compareTo(callDate)<0){
					System.out.println("Y");
				}else{
					System.out.println("N");
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	   /* public static void main(String[] args) {
	        //System.out.print("Enter a credit card number as a long integer: ");
	        long input = 4575800000092932L;
	        if (isValid(input) == true) {
	            //System.out.println("\n" + input + " is Valid. ");
	        } else {
	            //System.out.println("\n" + input + " is Invalid. ");
	        }

	    }*/
	} 