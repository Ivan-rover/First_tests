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

public class Login888 {

	private static WebDriver driver;

	@BeforeClass
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dev-bk-bet-site.tsed.orglot.office");
	}
	@Test
	public void userLogin()
	{
		WebElement loginEnter = driver.findElement(By.id("log-in"));
		loginEnter.click();
		//loginEnter.sendKeys("testingsto");
		WebElement loginField = driver.findElement(By.id("auth_login"));
		loginField.sendKeys("testingsto+110@mail.ru");
		WebElement passwordField = driver.findElement(By.id("auth_password"));
		passwordField.sendKeys("Parol123");
		//WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
		WebElement loginButton = driver.findElement(By.id("log-in-button"));
		loginButton.click();
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.id("topPanelWalletBalance")));
		WebElement walletBalance = driver.findElement(By.id("topPanelWalletBalance"));
        Assert.assertTrue("Баланс не отобразился",walletBalance.getText().matches("\\d+.\\d+"));

        //WebElement logoutButton
	}


}
