package zenpro.ZenTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Dateoickercls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	

        // Initialize WebDriver
        WebDriver driver= new ChromeDriver();

        // Initialize WebDriver
        driver.manage().window().maximize();

        // Navigate to the page with the jQuery Datepicker
        driver.get("https://jqueryui.com/datepicker/");
        System.out.println("The page title is "+driver.getTitle());
        // Wait for the datepicker to be visible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //frame
        WebElement frame=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);

        // Click on the datepicker input field to open the datepicker
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.click();

        // Click on the next month button
        WebElement nextMonthButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
        nextMonthButton.click();

        // Select a date from the next month
        WebElement date = driver.findElement(By.cssSelector("a[data-date='22']"));
        date.click();

        // Close the browser
       driver.quit();
    }

		
	}

//Outout
//The page title is Datepicker | jQuery UI
