package flow;

import java.util.HashMap;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.IVariableField;
import com.dm.util.Constants;
import com.servion.validator.ConsList;
import com.servion.validator.ConsValidator;

/**
 * A basic servlet which allows a user to define their code, generate
 * any output, and to select where to transition to next.
 * Last generated by Orchestration Designer at: 2013-OCT-07  05:37:37 PM
 */
public class ConstraintListCheck extends com.avaya.sce.runtime.BasicServlet {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2013-OCT-07  05:37:37 PM
	 */
	public ConstraintListCheck() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * This method allows for custom integration with other Java components.
	 * You may use Java for sophisticated logic or to integrate with custom
	 * connectors (i.e. JMS, custom web services, sockets, XML, JAXB, etc.)
	 *
	 * Any custom code added here should work as efficiently as possible to prevent delays.
	 * It's important to design your callflow so that the voice browser (Voice Portal/IR)
	 * is not waiting too long for a response as this can lead to a poor caller experience.
	 * Additionally, if the response to the client voice browser exceeds the configured
	 * timeout, the platform may throw an "error.badfetch". 
	 *
	 * Using this method, you have access to all session variables through the 
	 * SCESession object.
	 *
	 * The code generator will *** NOT *** overwrite this method in the future.
	 * Last generated by Orchestration Designer at: 2013-OCT-07  05:37:37 PM
	 */
	public void servletImplementation(com.avaya.sce.runtimecommon.SCESession mySession) {

		IVariable promptCollectVar = (IVariable) mySession.getVariable(IProjectVariables.PROMPT_AND_COLLECT);
		IVariable inputVar = mySession.getVariable(IProjectVariables.INPUT_VARIABLES);
		String otherSlot = promptCollectVar.getComplexVariable().getField(IProjectVariables.PROMPT_AND_COLLECT_FIELD_OTHER__SLOT).getStringValue();
		String specificSlot = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_SPECIFIC_SLOTS).getStringValue();
		String contraintList = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_CONSTRAINT_LIST).getStringValue();
		String dialogName = inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_DIALOG_NAME).getStringValue();
		String privateData=inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_PRIVATE_DATA).getStringValue();
		// Specific Slots added in the Grammar
		if(!specificSlot.equalsIgnoreCase(Constants.NONE)){
			String[] slots = specificSlot.split(Constants.COMMA);
			HashMap<String,String> specificSlotsMap = new HashMap<String, String>();
			for (int j = 0; j < slots.length; j++) {
				specificSlotsMap.put(slots[j], promptCollectVar.getComplexVariable().getField(slots[j]).getStringValue());
				if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Slot["+j+"] :"+promptCollectVar.getComplexVariable().getField(slots[j]).getStringValue());}
			}
			mySession.getVariableField(IProjectVariables.OUTPUT__PARAMETERS,IProjectVariables.OUTPUT__PARAMETERS_FIELD_SPECIFIC_SLOTS).setValue(specificSlotsMap);
			if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Specific Slot :"+mySession.getVariableField(IProjectVariables.OUTPUT__PARAMETERS,IProjectVariables.OUTPUT__PARAMETERS_FIELD_SPECIFIC_SLOTS).getObjectValue());}	
		}
		IVariableField nextNode = mySession.getVariableField(IProjectVariables.STATIC_CONSTRAINT_RESULT);
		/*
		 * In order to use ConstraintList we need to:
		 * 
		 * 		- Have a voice input (no need to validate a dtmf input, at least for now).
		 * 
		 * 		- The grammar should return "CONSTRAINT" in the OTHER_SLOT slot, since that
		 * 			would mean the input was supposed to go thru the contraint list (no need
		 * 			to validate commands).
		 * 
		 * 		- constraintList should be != than NONE, which means we were able to retrieve
		 * 			it. 
		 * 
		 */
		try{

			if ((Constants.CONSTRAINT.equalsIgnoreCase(otherSlot)) && (!Constants.NONE.equalsIgnoreCase(contraintList))) {

				ConsList consList = ConsValidator.getInstance().getConstraintList(contraintList);

				if (consList != null) {
					String value = "";
					boolean isValidInput = false;
					boolean lastWasValid = true;

					value = promptCollectVar.getComplexVariable().getField(IProjectVariables.PROMPT_AND_COLLECT_FIELD_RESULT).getStringValue().toUpperCase();
					if (consList.isValueAllowed(value)) {
						isValidInput = true;
						lastWasValid = true;
						if (mySession.isAppTraceEnabled())
						{
							mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "### Input RESULT >found< in file: ");
						}
						nextNode.setValue("RESPONSE");
					} else {
						if (mySession.isAppTraceEnabled()) 
						{
							mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "### Input RESULT >NOT found< in file: ");
							mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "### Removing value from results");
						}
						nextNode.setValue("NOMATCH");
						lastWasValid = false;	
					}

					if (mySession.isAppTraceEnabled())
					{
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "### Value in operation Result: " + nextNode.getStringValue());
					}
				}
			} else 
			{
				if (mySession.isAppTraceEnabled()) 
				{
					mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_ERROR, "### Constraint List was not found!");
				}
			}
			//}
		}catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

	}
	/**
	 * Builds the list of branches that are defined for this servlet object.
	 * This list is built automatically by defining Goto nodes in the call flow editor.
	 * It is the programmer's responsibilty to provide at least one enabled Goto.<BR>
	 *
	 * The user should override updateBranches() to determine which Goto that the
	 * framework will activate.  If there is not at least one enabled Goto item, 
	 * the framework will throw a runtime exception.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.  To modify the list
	 * of branches for the flow item, override:
	 *     <code>updateBranches(Collection branches, SCESession mySession)</code>
	 *
	 * @return a Collection of <code>com.avaya.sce.runtime.Goto</code>
	 * objects that will be evaluated at runtime.  If there are no gotos
	 * defined in the Servlet node, then this returns null.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:32 PM
	 */
	public java.util.Collection getBranches(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Goto aGoto = null;
		list = new java.util.ArrayList(1);

		aGoto = new com.avaya.sce.runtime.Goto("DynamicConstraintListCheck", 0, true, "Default");
		list.add(aGoto);

		return list;
	}
}