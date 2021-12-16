package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert b;
	
	
	public static  void launchChrome() {
		
		 WebDriverManager.chromedriver().setup();
	         driver = new ChromeDriver();
		  
	}
	
	public static void  loadUrl(String url){
		
		driver.get(url);
		}
	public static void winMax() {
		driver.manage().window().maximize();
	}
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	public static void printTitle() {
		
		System.out.println(driver.getTitle());
	}
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}
	public static void fill(WebElement ele,String value) {
		ele.sendKeys(value);
		
	}
	public static void btnClick(WebElement ele) {
		ele.click();
		
	}
	public static void browserClose() {
		driver.close();
	}
	public static void browserQuit() {
		driver.quit();
	}
	public static  void getTheText(WebElement ele) {
		
		String text = ele.getText();
		System.out.println(text);
	}
	public static void getTheAttribute(WebElement ele,String value) {
		String  att = ele.getAttribute(value);
		System.out.println(att);
	}
	public static void codeWait(long value) throws InterruptedException {
		Thread.sleep(value);
	}
	public static void moveElement(WebElement ele) {
		 a = new Actions(driver);
		a.moveToElement(ele).perform();
		
	}
	public static void dragdrop(WebElement src,WebElement des) {
		 a = new Actions(driver);
		a.dragAndDrop(src, des).perform();;
	}
	public static void clickDouble(WebElement ele) {
		a=new Actions(driver);
		a.doubleClick(ele).perform();;
	}
	public static void rightClick(WebElement ele) {
		a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	 
	public static void pressEnter() {
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void copy() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		
	}
	public static void paste() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		}
	public static void allow() {
		b=driver.switchTo().alert();
		b.accept();
	}
	public static void deny() {
		b=driver.switchTo().alert();
		b.dismiss();
	}
	public static void alertfill(String value) {
		b=driver.switchTo().alert();
		a.sendKeys(value);
				 }
	public static String getData(int rowNumber, int cellNumber) throws IOException {
		
		File f = new File("C:\\Users\\jebin\\eclipse-workspace\\CucumberAbi\\target\\userstory.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("userstory");
		 Row row = s.getRow(rowNumber);
		 Cell cell = row.getCell(cellNumber);
		 int cellType = cell.getCellType();
		 String value=" ";
        
        if (cellType==1) {
     	    value = cell.getStringCellValue();
			
		}else if (cellType==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
				sim.format(d);
			}
			else {
				double d = cell.getNumericCellValue();
				long l =(long)d;
				 value = String.valueOf(l);
			}
			
		}
        return value;
        
  }

	}
	
		  
	
	


