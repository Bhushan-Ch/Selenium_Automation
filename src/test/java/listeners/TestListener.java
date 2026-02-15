package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		Object testClass=result.getInstance();
		WebDriver driver=((base.BaseTest) testClass).driver;
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String testName = result.getName();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/" + testName + "_" + timestamp + ".png"));
            System.out.println("📸 Screenshot captured for failed test: " + testName);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
            
            
            @Override public void onStart(ITestContext context) {}
            @Override public void onFinish(ITestContext context) {}
            @Override public void onTestSuccess(ITestResult result) {}
            @Override public void onTestSkipped(ITestResult result) {}
        }
