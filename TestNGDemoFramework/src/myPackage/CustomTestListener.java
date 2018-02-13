package myPackage;

import java.util.Calendar;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomTestListener extends TestListenerAdapter {
	//instead of implementing ITestLister
	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test Method: "+tr.getTestClass().getName()+"."+tr.getMethod().getMethodName()+" Failed");
		System.out.println("************************************************");
	}
	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test Method: "+tr.getTestClass().getName()+"."+tr.getMethod().getMethodName()+" Passed Successfully");
		System.out.println("************************************************");
	}
	@Override
	public void onTestStart(ITestResult result) {
		Calendar cl = Calendar.getInstance();
		cl.setTimeInMillis(result.getStartMillis());
		System.out.println("Test Method: "+result.getTestClass().getName()+"."+result.getMethod().getMethodName()+" Started at: "+ cl.getTime().toString());
	}
}
