package irctcautomationscript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
//
import java.time.Duration;
//
import org.openqa.selenium.By;
public class Irctcbookingscript{
	public WebDriver driver;
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Page title:"+driver.getTitle());
//		
	}
	
	public void searchIrctc(String query) throws InterruptedException {
		WebElement searchresult=driver.findElement(By.name("q"));
		searchresult.sendKeys(query);
		searchresult.submit();
		System.out.println("Page title after search:"+ driver.getTitle());
		Thread.sleep(2000);
	}
	
	
	 public void Clickfirstlink() throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(800));  
//
//	        // Click the first search result that links to IRCTC
	        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//a[contains(@href, 'irctc.co.in')]")
	        ));
	        firstResult.click();
	        System.out.println("Clicked on the first search result.");
//
//	        // Wait for the login button and click it
	        Thread.sleep(2000); // Allow page to load
	        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[1]")
	        ));
	        loginBtn.click();
	        System.out.println("Clicked on the LOGIN button.");
	    }
//
//	 
	 public void Irctclogin(String username,String password) throws InterruptedException {
    	Thread.sleep(9000);
		 WebElement username1= driver.findElement(By.xpath("//input[@formcontrolname='userid']"))	;
		 WebElement password1=driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		 WebElement submit=driver.findElement(By.xpath("//button[text()='SIGN IN']"));
		 username1.sendKeys(username);
		 Thread.sleep(9000);
		 password1.sendKeys(password);
		 Thread.sleep(7000);
		 submit.click()	; 
		 System.out.print("details filled and logged in successfully!!");
	 }
//	 
////	 public void Irctclogin(String username, String password) {
////	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
////
////	        
////	        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
////	        		By.cssSelector("input[formcontrolname='userid']")));
////	        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
////	        		By.cssSelector("input[formcontrolname='password']")));
////	        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
////	                By.xpath("//button[contains(text(),'Sign in')]")));
////
////	        usernameField.sendKeys(username);
////	        passwordField.sendKeys(password);
////	        submitButton.click();
////
////	        System.out.println("Login details filled and submitted.");
////	    }
	public static void main(String args[]) throws InterruptedException {
		Irctcbookingscript script=new Irctcbookingscript();
		script.setup();
		script.searchIrctc("irctc");
		script.Clickfirstlink();
		Thread.sleep(1000);
		script.Irctclogin("agalyas", "Agal@2003");
			
		}
}


