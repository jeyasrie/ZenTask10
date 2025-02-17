package zenpro.ZenTask10;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;



public class Dropcls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    
		WebDriver  driver=new ChromeDriver();
		//get the url of the page
		driver.get("https://jqueryui.com/droppable/");
		
		//maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//get the current page title
	    System.out.println(driver.getTitle());
	    //find the frame 
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		//get the draggable box
		WebElement drag=driver.findElement(By.id("draggable"));
		
		//get the droppable box
		WebElement drop=driver.findElement(By.id("droppable"));
	
		//using actions drag the box
		Actions obj=new Actions(driver);
		obj.dragAndDrop(drag,drop).build().perform();
		
		//get the text from droppable box
		String msg=drop.getText();
		System.out.println(msg);
		Assert.assertEquals("Dropped!", msg);
		
		WebElement ele = driver.findElement(By.id("droppable"));
		//get the background color with rgba
		String col=ele.getCssValue("background-color");
		System.out.println(col);
		//convert the background color from rgba to hex #fffa90
		String hex=Color.fromString(col).asHex();
		System.out.println(hex);
		//Assert.assertEquals(hex,"#fffa90");
		//verified of drag and drop using background color
    if(hex.equalsIgnoreCase("#fffa90")) {
    	  System.out.println("dropped suceessfully");
      }
      else
      {
    	  System.out.println("error");
      }
	}

}

//Output
//Droppable | jQuery UI
//Dropped!
//rgba(255, 250, 144, 1)
//#fffa90
//dropped suceessfully
