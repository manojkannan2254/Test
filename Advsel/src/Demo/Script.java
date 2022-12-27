package Demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class Script 
{
public static void main(String args[]) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com");
	Thread.sleep(3000);
	String title = driver.getTitle();
	System.out.println(title);

}
}
