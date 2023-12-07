package AppiumNew.AppiumAPIDemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class LaunchApplication {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
        //@Test
        //public static void AppLaunch()throws InterruptedException, MalformedURLException{
		File App= new File("C:\\Users\\Gaman\\Downloads", "ApiDemo.apk");
		File Js=new File("C:\\Users\\Gaman\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js");
		
		AppiumDriverLocalService service= 
			new AppiumServiceBuilder()
		   .withAppiumJS(Js)
		   .withIPAddress("0.0.0.0")
		   .withArgument(GeneralServerFlag.BASEPATH, "wd/hub")
		   .usingPort(4723)
		   .build();
		service.start();
		
		DesiredCapabilities dc= new DesiredCapabilities();
		Thread.sleep(2000);
		dc.setCapability("App",App.getAbsolutePath());
		dc.setCapability("deviceName", "Android Device");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("autoGrantPermissions", "true");
		dc.setCapability("session-override", "true");

		
		Thread.sleep(2000);
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wb/hub"),dc);
	    System.out.println("Application Started");
	}

}
