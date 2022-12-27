		package Demo;
		
		import java.awt.AWTException;
		import java.awt.Robot;
		import java.awt.event.KeyEvent;
		import java.util.Set;
		
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.Point;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.interactions.Actions;
		
		public class screenshot 
		{
			public static void main(String[] args) throws InterruptedException, AWTException 
			{
				System.setProperty("webdriver.gecko.driver","./Software/geckodriver.exe");
				WebDriver driver=new FirefoxDriver();
				driver.get("https://www.facebook.com");
				WebElement ele = driver.findElement(By.xpath("//a[.='தமிழ்']"));
				{
					Point loc = ele.getLocation();
					int x = loc.getX();
					int y = loc.getY();
					Thread.sleep(2000);
					JavascriptExecutor jse =(JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy("+x+","+y+")");
					Thread.sleep(2000);
		
		
		
					Actions act=new Actions(driver);
					act.contextClick(ele).perform();
					Thread.sleep(2000);	
		
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_T);
					r.keyRelease(KeyEvent.VK_T);
					Thread.sleep(2000);
					String P_id = driver.getWindowHandle();
					Thread.sleep(2000);
					Set<String> all_id = driver.getWindowHandles();
					for (String id:all_id)
					{
						id.equals(P_id);
						driver.switchTo().window(id);
						r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_TAB);
						r.keyRelease(KeyEvent.VK_CONTROL);
						r.keyRelease(KeyEvent.VK_TAB);
		
					}
					Thread.sleep(2000);
					driver.findElement(By.id("email")).sendKeys("khanmanoj451@gmail.com");
					Thread.sleep(2000);
					driver.findElement(By.id("pass")).sendKeys("Manoj@2254");
					Thread.sleep(2000);
					driver.findElement(By.name("login")).click();
					TakesScreenshot tss = (TakesScreenshot)driver;
					tss.getScreenshotAs(OutputType.FILE);
		
		
				}
			}
		}
