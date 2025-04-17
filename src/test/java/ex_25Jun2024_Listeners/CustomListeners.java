package ex_25Jun2024_Listeners;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomListeners implements IExecutionListener, ISuiteListener {

	@Override
	public void onExecutionStart() {
		System.out.println("onExecutionStart");
		long startTime = System.currentTimeMillis();
		System.out.println(" ***   *** Started Execution at - "+ startTime + "***  ***");
	}

	@Override
	public void onExecutionFinish() {
		long endTime = System.currentTimeMillis();
		System.out.println("***  *** Finished Execution at -"+ endTime + "***  ***");
		System.out.println("onExecutionFinish");
	}	
}