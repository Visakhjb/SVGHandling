package AutoGraph.Graphs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGClass {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> graphBars = driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']"));
		System.out.println(graphBars.size());
		
		Actions a = new Actions(driver);
		for(WebElement m:graphBars)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
			a.moveToElement(m);
			Thread.sleep(500);
		}
		
		driver.quit();
	}


}
