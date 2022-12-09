package com.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Base.BaseClass;

public class DriverUtils extends BaseClass{
	
	public  static String getScreenShort(String name) throws Exception{
		String path=System.getProperty("user.dir")+"/screenshort/"+name+".jpg";
		TakesScreenshot ts=(TakesScreenshot )driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des= new File(path);
		FileUtils.copyFile(src, des);
		return path;
	}

}
