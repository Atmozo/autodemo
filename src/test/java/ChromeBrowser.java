import io.github.bonigarcia.wdm.WebDriverManager;   
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ChromeBrowser{
 WebDriver driver; 
@Test
 public void startChromeBrowser(){
  WebDriverManager.chromedriver().setup();
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://www.saucedemo.com/");
  driver.findElement(By.id("user-name")).sendKeys("standard_user");
  driver.findElement(By.id("password")).sendKeys("secret_sauce");
  driver.findElement(By.id("login-button")).click();

  
 }

}
