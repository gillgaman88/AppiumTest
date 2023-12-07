package AppiumNew.AppiumAPIDemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class APIDemoScroll {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

	File App= new File("C:\\Users\\Gaman\\Downloads", "ApiDemo.apk");
	File Js=new File("C:\\Users\\Gaman\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js");
	
	DesiredCapabilities dc= new DesiredCapabilities();
	Thread.sleep(2000);	
	 //Build the Appium service

    AppiumServiceBuilder builder = new AppiumServiceBuilder();

    builder = new AppiumServiceBuilder();

    builder.withIPAddress("127.0.0.1");

    builder.usingPort(4723);

    builder.withCapabilities(dc);

    builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
    
    builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");	
		
    //Start the server with the builder

    AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);

    service = AppiumDriverLocalService.buildService(builder);

    service.start();
    
    //Start adding the desired capabilities for the appium inspector
    dc.setCapability("noReset", "false");

    dc.setCapability("App",App.getAbsolutePath());

	dc.setCapability("deviceName", "Android Device");

	dc.setCapability("platformName", "Android");

	dc.setCapability("automationName", "UiAutomator2");

	dc.setCapability("autoGrantPermissions", "true");
	
	//Write the URL connection
	URL url = new URL("http://127.0.0.1:4723/wd/hub");

	Thread.sleep(2000);

    AndroidDriver driver=new AndroidDriver(dc);
    
    //need to maintain the longPress  
    System.out.println("Tap on the view button");
	Thread.sleep(1500);
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	//driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
	/*
	boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "Up",
		    "percent", 80.0
		));
	  System.out.println("Here's the scroll result "+ canScrollMore);
	  */

    driver.findElement(ByAndroidUIAutomatorAndroid("new UiScrollable(newUiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))")).click();
	
	}

	private static By ByAndroidUIAutomatorAndroid(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
