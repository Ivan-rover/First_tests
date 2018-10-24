package mail.ru;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginMailRu {

	private static WebDriver driver;

	@BeforeClass
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.ru");
	}
	@Test
	public void userLogin()
	{
		WebElement loginField = driver.findElement(By.id("mailbox:login"));
		loginField.sendKeys("testingsto");
		WebElement passwordField = driver.findElement(By.id("mailbox:password"));
		passwordField.sendKeys("Acer0808");
		//WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
		WebElement loginButton = driver.findElement(By.id("mailbox:submit"));
		loginButton.click();
		new WebDriverWait(driver,2).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'/compose/')]")));
		WebElement mail = driver.findElement(By.id("PH_user-email"));
        Assert.assertEquals("testingsto@mail.ru",mail.getText());
	}


}
