package com.crm.automation.util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EmptyFileException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils extends Base {

	public void getScreenshot(String result, WebDriver driver, String descriptionLine) throws IOException {
		
		FileOutputStream out = null;
		String backupFilePath = null;
		try {
			String baseScreenshotPath = new File("src/test/resources/test_" + Configuration.DATE_TIME_STAMP).getAbsolutePath();
			String baseTemplatePath = new File("src/test/resources").getAbsolutePath();
			String templateFilePath = baseTemplatePath + "/template.docx";
			String outputFilePath = baseTemplatePath + "/screenshots.docx";
			backupFilePath = baseTemplatePath + "/testScreenshots_backup.docx";
			
			File f = new File(outputFilePath);
			
			if(f.exists()) {
				try {
					docx = new XWPFDocument(OPCPackage.open(outputFilePath, PackageAccess.READ_WRITE));
				} catch(EmptyFileException e) {
					FileUtils.copyFile(new File(templateFilePath), new File(outputFilePath));
					docx = new XWPFDocument(OPCPackage.open(outputFilePath, PackageAccess.READ_WRITE));
				}
				
			} else {
				FileUtils.copyFile(new File(templateFilePath), new File(outputFilePath));
				docx = new XWPFDocument(OPCPackage.open(outputFilePath, PackageAccess.READ_WRITE));
			}
			
			XWPFParagraph paragraph = docx.createParagraph();
			
			XWPFRun run = paragraph.createRun();
			out = new FileOutputStream(backupFilePath);
			
			captureScreenshot(docx, run, out, result, driver, baseScreenshotPath, descriptionLine);
			TimeUnit.SECONDS.sleep(1);
			
			docx.write(out);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
				docx.close();
				new File(backupFilePath).delete();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void captureScreenshot(XWPFDocument docx, XWPFRun run, FileOutputStream out, String result,
			WebDriver driver, String baseScreenshotPath, String descriptionLine) throws Exception {
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File(baseScreenshotPath + "/" + result + ".png"));
		
		ImageIO.write(image, "png", src);
		
		InputStream pic = new FileInputStream(baseScreenshotPath + "/" + result + ".png");
		
		run.addBreak();
		
		run.setText(descriptionLine);
		run.addBreak();
		run.setText("Result with Test Name ==> " + result);
		
		run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, result + ".png", Units.toEMU(500), Units.toEMU(350));
		
		pic.close();
		//src.delete(); // If we need to remove external images sotred in folder, then we can uncomment this line.
		
	}
}
