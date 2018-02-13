package myPackage;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*external jars required
1.All Selenium
2.All TestNG libs
3.All Apache - POI
4.All Apache - log4j
5.Fillo*/


@Listeners({CustomTestListener.class})
public class MyMain extends BaseClass {
	public static Logger logger = Logger.getLogger(MyMain.class);
	@Test(dataProvider = "myTestDataProvider")
	public void sampleTest1(HashMap<String, String> testDataMap) throws InterruptedException {
		for(Map.Entry entry : testDataMap.entrySet()) {
			System.out.println("Key-->"+ entry.getKey());
			System.out.println("Value-->"+ entry.getValue());
		}
		//Extract json data
		HashMap<String, String> inputDataMap = UtilsClass.getInputDataMap(testDataMap);
		System.out.println("InputDataMap--------------------------------->>>>");
		for(Map.Entry entry : inputDataMap.entrySet()) {
			System.out.println("Key-->"+ entry.getKey());
			System.out.println("Value-->"+ entry.getValue());
		}
		logger.info("This is my Test: SampleTest1");
		Thread.sleep(2000);
		sAssert.assertTrue(true);
		sAssert.assertAll();
	}
	@Test
	public void sampleTest2() throws InterruptedException {
		logger.info("This is my Test: SampleTest2");
		Thread.sleep(1000);
		sAssert.assertTrue(false, "This assertion is also failed");
		sAssert.assertTrue(false, "Again assert failed");
		sAssert.assertAll();
	}
	@Test
	public void sampleTest3() throws InterruptedException {
		logger.info("This is my Test: SampleTest3");
		Thread.sleep(1000);
		sAssert.fail("This is it");
		sAssert.assertAll();
	}
	

}
