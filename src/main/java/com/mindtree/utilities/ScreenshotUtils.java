package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mindtree.reusableComponents.Base;

public class ScreenshotUtils extends Base{
	public void getScreenShot(String name) throws IOException {
		log.info("Taking Screenshot");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:\\Users\\M1074103\\eclipse-workspace\\HariDemo\\Screenshots\\" + name + ".png"));
	}
}
