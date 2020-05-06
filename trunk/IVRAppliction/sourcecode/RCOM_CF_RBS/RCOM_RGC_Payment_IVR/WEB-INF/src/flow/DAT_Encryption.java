package flow;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

import com.avaya.sce.runtime.tracking.TraceInfo;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hpe.util.AppConstant;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: 2016-APR-12  11:02:55 AM
 */
public class DAT_Encryption extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-APR-12  11:02:55 AM
	 */
	public DAT_Encryption() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	public static String EncryptString(String strToBeEncrypted) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException
    {
                    String modulusString = "qqoWhMwGrrEBRr92VYud3j+iIEm7652Fs20HvNckH3tRDJIL465TLy7Cil8VYxJre69zwny1aUAPYItybg5pSbSORmP+hMp6Jhs+mg3qRPvHfNIl23zynb4kAi4Mx/yEkGwsa6L946lZKY8f9UjDkLJY7yXevMML1LT+h/a0a38=";
                    String publicExponentString = "AQAB";

                    byte[] modulusBytes = Base64.decodeBase64(modulusString);
                    byte[] exponentBytes = Base64.decodeBase64(publicExponentString);
                    BigInteger modulus = new BigInteger(1, modulusBytes);
                    BigInteger publicExponent = new BigInteger(1, exponentBytes);

                    RSAPublicKeySpec rsaPubKey = new RSAPublicKeySpec(modulus, publicExponent);
                    KeyFactory fact = KeyFactory.getInstance("RSA");
                    PublicKey pubKey = fact.generatePublic(rsaPubKey);
                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
                    cipher.init(Cipher.ENCRYPT_MODE, pubKey);

                    byte[] plainBytes = strToBeEncrypted.getBytes("US-ASCII");
                    byte[] cipherData = cipher.doFinal(plainBytes);
                    String encryptedStringBase64 = Base64.encodeBase64String(cipherData);
                    
                    return encryptedStringBase64;
    }
	
	public void requestBegin(SCESession mySession)
	{
		String CVV = AppConstant.EMPTY_STRING,ExpDate = AppConstant.EMPTY_STRING, CC_Num = AppConstant.EMPTY_STRING;
		String enc_CVV = AppConstant.EMPTY_STRING,enc_ExpDate = AppConstant.EMPTY_STRING,enc_CC_Num = AppConstant.EMPTY_STRING;
		
	try
		{
		
		CVV = mySession.getVariableField(IProjectVariables.DM__GET__CC__VALIDATION__CODE,IProjectVariables.DM__GET__CC__VALIDATION__CODE_FIELD_VALUE).getStringValue();
		CC_Num = mySession.getVariableField(IProjectVariables.DM__GET__CC__NUMBER,IProjectVariables.DM__GET__CC__NUMBER_FIELD_VALUE).getStringValue();
		ExpDate = mySession.getVariableField(IProjectVariables.DM__GET__CC__VALIDITY,IProjectVariables.DM__GET__CC__VALIDITY_FIELD_VALUE).getStringValue();
		
		enc_CVV = EncryptString(CVV);
		enc_CC_Num = EncryptString(CC_Num);
		enc_ExpDate = EncryptString(ExpDate);
		
		mySession.getVariableField(IProjectVariables.WS__PAYMENT__REQUEST,IProjectVariables.WS__PAYMENT__REQUEST_FIELD_CVV).setValue(enc_CVV);
		mySession.getVariableField(IProjectVariables.WS__PAYMENT__REQUEST,IProjectVariables.WS__PAYMENT__REQUEST_FIELD_CC__NUMBER).setValue(enc_CC_Num);
		mySession.getVariableField(IProjectVariables.WS__PAYMENT__REQUEST,IProjectVariables.WS__PAYMENT__REQUEST_FIELD_CC__VALIDITY).setValue(enc_ExpDate);
      
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"encrypted CVV - "+enc_CVV, mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"encrypted CC Num - "+enc_CC_Num, mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"encrypted CC expiry date - "+enc_ExpDate, mySession);
        
		}
		catch(Exception e)
		{
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"Exception on encryption process"+e, mySession);
			mySession.getVariableField(IProjectVariables.FLAG__APPLICATION__ERROR).setValue(AppConstant.TRUE);	
		}
	}
	
	
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-OCT-21  01:08:49 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("DAT_WS_Payment_Operation", "Default");
		next.setDebugId(2954);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-OCT-21  01:08:49 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-OCT-21  01:08:49 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
