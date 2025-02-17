package zenpro.ZenTask10;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class Guvicls {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		   // Initialize WebDriver
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// // Navigate to the page with the guvi
		driver.get("https://www.guvi.in/");
		   // Initialize WebDriver
		driver.manage().window().maximize();
		
		//get the title of the page
		System.out.println("Title of the page is "+driver.getTitle());
		//sign up the guvi account
		//click the sign up button
		WebElement element=driver.findElement(By.xpath("//a[text()='Sign up']"));
		element.click();
		
		//write the name in the name field
		driver.findElement(By.id("name")).sendKeys("jeya");
		
		//write the email id in the email input field
	     WebElement email=	driver.findElement(By.id("email"));
		 email.sendKeys("ccsd43@kmail.com");
         
		 //create the password in the password input field
        driver.findElement(By.id("password")).sendKeys("Jeya234");
       
        //enter the mobile number in the mobile number input field
        driver.findElement(By.id("mobileNumber")).sendKeys("3417354677");
        Thread.sleep(1000);
        // click the buuton after entering all necessary field
        driver.findElement(By.id("signup-btn")).click();
        
        //get the text from next page and confirming your account has been created
        String txt=driver.findElement(By.xpath("//h3[text()='Your account has been created. Before you continue...']")).getText();
        System.out.println(txt);
        
        //using assert function check the text ara matching
        Assert.assertEquals("Your account has been created. Before you continue...", txt);
      /*  if(txt.equals("Your account has been created. Before you continue..."))
        {
        	System.out.println("Registered Successfully");
        }
        else {
        	System.out.println("Registration failed");
        }
        */
        
        //Tell us about yourself page
        //after confirming your account fill this form
     //get the text on the top of the  page
        String txt1=driver.findElement(By.xpath("//div/h2")).getText();
        System.out.println(txt1);
        
        //using dropdown select your profile
        WebElement profile=driver.findElement(By.id("profileDrpDwn"));
        Select myprofile=new Select(profile);
        myprofile.selectByVisibleText("Looking for a career");
        
        //select degree 
        WebElement degree=driver.findElement(By.id("degreeDrpDwn"));
        Select mydegree=new Select(degree);
        mydegree.selectByVisibleText("B.E. / B.Tech. Computer Science");
        
        //select passed year
        driver.findElement(By.id("year")).sendKeys("2012");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.id("details-btn")).click();
        
      
        
        //login the guvi with email and password
        
        driver.navigate().to("https://www.guvi.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("login-btn")).click();
        driver.findElement(By.id("email")).sendKeys("jeyasrie1991@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Jeyasri@2691");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("login-btn")).click();
         
        //handle alert
        
       driver.findElement(By.xpath("//button[text()='Later']")).click();
      
       
      
	}

}

//Output
//Title of the page is GUVI | Learn to code in your native language
//Your account has been created. Before you continue...
//Tell us about Yourself

