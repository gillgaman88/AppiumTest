package AppiumNew.AppiumAPIDemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class APIDemoDragAndDrop {

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
    
    //Drag and Drop
    System.out.println("Tap on the view button");
	Thread.sleep(1500);
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	Thread.sleep(2500);

	WebElement Gesture = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.view.View[1]"));
	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
     "elementId", ((RemoteWebElement) Gesture).getId(),
     "endX", 276,
     "endY", 260
    ));
	Thread.sleep(2500);
	String Output=driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
	System.out.println("The test is visible " + Output);

	Assert.assertEquals(Output, "Dropped!");
  

	}

}
