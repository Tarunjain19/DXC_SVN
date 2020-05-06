package com.servion.rcom.hostinterface.util;



import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/*
 * Created by: Venkat  Date: June 24, 2014. 
 * 
 * Modification history: 
 * 
 * DD-MMM-YYYY, Name of developer: (Task/CR) Explain changes
 */
/**
 * This program generates a AES key, retrieves its raw bytes, and then
 * reinstantiates a AES key from the key bytes. The reinstantiated key is used
 * to initialize a AES cipher for encryption and decryption.
 */

public class AESCryptoService  {

	private static KeyGenerator kgen = null;


	static{
		try {
			if(null != kgen){
				//getting AES encrypter instance
				kgen = KeyGenerator.getInstance("AES");
				//initializing with 128 bits
				kgen.init(128);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String generateSalt(String input) {
		String salt = null;
		int len = 16;
		try {
			if (input != null && input.length() > 0) {
				if (input.length() >= len) {
					salt = input.substring(0, len);
				} else {
					salt = input
					+ "Reliance Tech Services Private Limited".substring(0,
							len - input.length());
				}
			} else {
				salt = "Reliance Tech Services Private Limited".substring(0,len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salt;
	}



	/** Converts the given array of bytes to a hex String */
	private static String toHex(byte[] buf) {
		String res = "";
		for (int i=0; i<buf.length; i++) {
			int b = buf[i];
			if (b<0) {
				res = res.concat("-");
				b = -b;
			}
			if (b<16) {
				res = res.concat("0");
			}
			res = res.concat(Integer.toHexString(b).toUpperCase());
		}
		return res;
	}

	public static String encrypt(String text) {

		byte[] encrypted = null;
		byte[] salt = null;
		Cipher cipher = null;
		SecretKeySpec skeySpec =null;

		try {	
			/* KeyGenerator kgen = KeyGenerator.getInstance("AES");
		       kgen.init(128); 
		       SecretKey skey = kgen.generateKey();
		       byte[] raw = skey.getEncoded();
		       SecretKeySpec skeySpec =  new SecretKeySpec(raw, "AES");*/
			//setting application specific encoding bytes
			salt = generateSalt("gRcRbSdDpPmP").getBytes();
			//creating cypher key specification
			skeySpec = new SecretKeySpec(salt, "AES");
			//getting cypher instance
			cipher = Cipher.getInstance("AES");
			//initializing cypher in encrypt mode
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			encrypted = cipher.doFinal(text.getBytes());			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toHex(encrypted);
	}

	public static String decrypt(String encryptedText) {

		byte[] encrypted = null;
		byte[] original = null;
		Cipher cipher = null;
		byte[] salt = null;
		String originalString=null;
		SecretKeySpec skeySpec =null;
		try {

			/*KeyGenerator kgen = KeyGenerator.getInstance("AES");
	       kgen.init(128); 
	       SecretKey skey = kgen.generateKey();
	       byte[] raw = skey.getEncoded();
	       SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");*/
			//salt = generateSalt("gcbdpm=RRSDMA").getBytes();
			salt = generateSalt("gRcRbSdDpPmP").getBytes();

			//creating cypher key specification
			skeySpec = new SecretKeySpec(salt, "AES");
			cipher = Cipher.getInstance("AES");
			//initializing cypher in encrypt mode
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			encrypted = toByteArray(encryptedText);
			original = cipher.doFinal(encrypted);
			originalString = new String(original);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return originalString;
	}
	private static byte[] toByteArray(String hex) {
		java.util.Vector res = new java.util.Vector();
		String part;
		int pos = 0;
		int len = 0;
		while (pos<hex.length()) {
			len = ((hex.substring(pos,pos+1).equals("-")) ? 3 : 2);
			part = hex.substring(pos,pos+len);
			pos += len;
			int test = Integer.parseInt(part,16);
			res.add(new Byte((byte)test));
		}
		if (res.size()>0) {
			byte[] b = new byte[res.size()];
			for (int i=0; i<res.size(); i++) {
				Byte a = (Byte)res.elementAt(i);
				b[i] = a.byteValue();
			}
			return b;
		}
		else
			return null;
	}

	/*public static void main(String[] args) {


		//String input=		"-5B61-0B77-5C-3C77-73-57-64-3D-30-803E2D-37201D-780748-2355-70782A-2D-36-02-6F-64-102D5377-6077-77-5E470D4110-2C54-4B4F3A-5D064215-7A-4B-4016-0174-7F-2533-43-45-80660B720F-281D-6A3676-1C0F14-13-6D-61-26-1415-015F3A-35-6850-5A-56-33502B-2B-7F056C32-5E5C1D2B-5C4C-053E29-1C-33-7448-1A597E-6326-0E-71-05-3A-6D34-62042E-4A-580D-6802-28-6F5F-15525F44-125D-3E64-74-70-36-6075-420A-5F31-15-4C-7A0E-80-4D-44-0A2853-7B-32-367F663646226F-4B-28-08-2C-70134C696F-6F-46-5F-5F-16-343D4C0E-16-7922-5C731B0B25-56077411511C524A-0E1110-6B-7F6C460F6577-39576319041113-5E-6E-39-217C3057-7519177C46-0C-567A-0C2A4F-41-39-586E3A7A-133E-073A7425-6A1D4B-5C-4A736B41-696F1B5C0845-1F-2B7D7D-33-5E-3F4C-6A53-7411-4C10-0D-39761E-016408-48-59-45-60706117-76-07-53-01483557-094101-327D3C-511850771F06-4815-34-5B-5E-12-58-49-42-2C-464E4C520113310F-4A-473F-38047B-2B-492D-3C-2C140B-410629-2A5D2F-1A0B5C2B47-03-0F-25144E-69-3840-78-42-564A-7723-7C00-45-0D-5A6C-38-63003153-75-610359-26037D-27-30-59-4A-0C-5133-34-3C53-0D-2B-0A-2E-0B";


		//System.out.println(":::"+new AESCryptoService().decrypt(input));


		String input = "abcdefghijklmnopqures";
		
		String encText = new AESCryptoService().encrypt(input);
		
		System.out.println("Encrypted Text : " +encText);
		
		System.out.println("Decrypted Text : " +new AESCryptoService().decrypt(encText));
		
	}*/

}