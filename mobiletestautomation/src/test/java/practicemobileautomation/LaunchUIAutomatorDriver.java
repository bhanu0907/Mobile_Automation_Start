package practicemobileautomation;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class LaunchUIAutomatorDriver {
	@Test
	public void startTest() throws Exception {
		//AndriodDriver, IOSDRIVER
		//Appium code -> Appium Server-> Mobile
		
	/*  AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start(); */
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("BhanuPixel");
		//options.setApp("/Users/Bhanu/eclipse-workspace_MobileAutomationDemo/mobiletestautomation/src/test/resources/in.redbus.android.apk");

		options.setApp("/Users/Bhanu/eclipse-workspace_MobileAutomationDemo/mobiletestautomation/src/test/resources/app-release.apk");
		//  /Users/Bhanu/eclipse-workspace_MobileAutomationDemo/mobiletestautomation/src/test/resources/API Demos_4.0_apkcombo.com.apk

		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		//driver.quit();
		System.out.println("quit");

		//service.stop();
		//System.out.println("Stop");
	}
	

	//	@Test
	public void startTest1() {
		AppiumDriverLocalService service = null;
		AndroidDriver driver = null;

		try {
			// Start Appium server
			service = new AppiumServiceBuilder()
					.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
					.withIPAddress("127.0.0.1")
					.usingPort(4723)
					.build();
			service.start();

			// Set up Appium options for UiAutomator2
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("BhanuPixel");
			options.setApp("/Users/Bhanu/eclipse-workspace_MobileAutomationDemo/mobiletestautomation/src/test/resources/in.redbus.android.apk");

			// Initialize AndroidDriver
			driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

			// Add your test code here (e.g., interacting with the app)

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test setup or execution failed: " + e.getMessage());
		} finally {
			// Clean up resources
			if (driver != null) {
				driver.quit();
				System.out.println("Driver quit.");
			}
			if (service != null) {
				service.stop();
				System.out.println("Appium service stopped.");
			}
		}
	}


}
