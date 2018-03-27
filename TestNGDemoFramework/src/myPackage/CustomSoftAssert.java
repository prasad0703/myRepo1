package myPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

public class CustomSoftAssert extends SoftAssert {
	WebDriver driver;
	public CustomSoftAssert(WebDriver driver) {
		this.driver = driver;
	}
	@Override
	public void onAssertFailure(IAssert a) {
		System.out.println("Failed Assertion: "+a.getMessage());
		try {
			System.out.println("Failure Screenshot: ");
			takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onAssertSuccess(IAssert a) {
		// TODO Auto-generated method stub
		System.out.println("Assertion Passed");
	}

	
	public void takeScreenshot() throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File f = tk.getScreenshotAs(OutputType.FILE);
		long timeStamp = System.currentTimeMillis();
		File f1 = new File("AutomationOutput\\"+timeStamp+".jpg");
		Files.move(f, f1);
		System.out.println("Screenshot placed at: "+f1.getAbsolutePath());
	}

	
}
