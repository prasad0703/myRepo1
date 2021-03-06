package myPackage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.MDC;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class BaseClass {
	CustomSoftAssert sAssert;
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest(ITestContext context) {
		ITestNGMethod[] arrMethods = context.getAllTestMethods();
		for(ITestNGMethod arrMethod : arrMethods) {
			System.out.println(arrMethod.getMethodName());
		}
		//context.setAttribute("driverInstance", driver);
		//initialize log4j
		System.setProperty("testMethodName", context.getCurrentXmlTest().getName());
		System.setProperty("logfilename", ""+System.currentTimeMillis());
		DOMConfigurator.configure("src\\MyResources\\log4j.xml");
		System.out.println(System.getProperties());
	}
	@BeforeClass
	public void beforeClass(ITestContext context) {
		String strBrowserName = context.getCurrentXmlTest().getParameter("browserName");
		if(strBrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Tech\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(strBrowserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Tech\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=cJqCWsqbMq-dX57HgZgL");
	}
	@BeforeMethod
	public void beforeMethod(Object[] testArgs) {
		//initialize assert
		sAssert = new CustomSoftAssert(driver);
		HashMap<String, String> testDataMap = (HashMap<String, String>) testArgs[0]; 
		System.out.println("Test Description: "+testDataMap.get("TEST DESCRIPTION"));
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
		
	}
	@AfterTest
	public void afterTest(ITestContext context) {
		
		Collection<ITestNGMethod> passedTestMethods = context.getPassedTests().getAllMethods();
		System.out.println("This is it***********************");
		System.out.println("Passed Tests: ");
		for(ITestNGMethod passedTestMethod : passedTestMethods) {
			System.out.println("\t"+passedTestMethod.getQualifiedName());
		}
		System.out.println();
		Collection<ITestNGMethod> failedTestMethods = context.getFailedTests().getAllMethods();
		System.out.println("Failed Tests: ");
		for(ITestNGMethod failedTestMethod : failedTestMethods) {
			System.out.println("\t"+failedTestMethod.getQualifiedName());
		}
	}
	
	
	@DataProvider(name="myTestDataProvider")
	public Object[][] testDataProvider(Method m) throws FilloException{
		String testCaseName = m.getName();
		MDC.put("testMethodName", testCaseName);
		Fillo f = new Fillo();
		System.out.println("Funky Class Name:");
		System.out.println(this.getClass().getName());
		//using above class name get path of test data sheet
		Connection con = f.getConnection("src\\TestData\\Test_Data.xlsx");
		Recordset rs = con.executeQuery("Select * from TestData where Test_Case_Name = '"+testCaseName+"'");
		List<HashMap<String, String>> testDataList = new ArrayList<HashMap<String, String>>();
		int colSize = rs.getFieldNames().size();
		while(rs.hasNext()) {
			rs.moveNext();
			HashMap<String, String> testDataMap = new HashMap<String, String>();
			for(int i = 0; i<colSize; i++) {
				String key = rs.getField(i).name();
				String val = rs.getField(i).value();
				testDataMap.put(key, val);
			}
			testDataList.add(testDataMap);
		}
		Object[][] resultArray = new Object[testDataList.size()][]; 
		for(int i=0; i<testDataList.size(); i++) {
			resultArray[i] = new Object[] {testDataList.get(i)};
		}
		return resultArray;
	}
	
	
}
