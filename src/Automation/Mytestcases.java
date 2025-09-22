package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mytestcases extends mydata {
	WebDriver driver = new EdgeDriver();
	String url = "https://automationteststore.com/";

	@BeforeTest
	public void mysetup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test(priority = 1)
	public void signuptest() throws InterruptedException {
		// هاي بحالة ا انو افوت واختار log in or signup وبعدها اكبس continoue بعدها ادخل
		// بيانات
		/*
		 * String regpage="https://automationteststore.com/index.php?rt=account/login";
		 * driver.navigate().to(regpage); WebElement
		 * contbtn=driver.findElement(By.xpath("//button[@title='Continue']"));
		 * contbtn.click();
		 */

		// في حال اروح مباشرة لصفحة انشاء الحساب url غير
		String regpage = "https://automationteststore.com/index.php?rt=account/create";
		driver.navigate().to(regpage);
		WebElement fieldFN = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement fieldLN = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement fieldEmail = driver.findElement(By.id("AccountFrm_email"));
		WebElement fieldPhone = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement fieldFax = driver.findElement(By.id("AccountFrm_fax"));

	
		WebElement fieldZipcode = driver.findElement(By.id("AccountFrm_postcode"));

		WebElement fieldloginname = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement fieldPassword = driver.findElement(By.id("AccountFrm_password"));
		WebElement fieldPassconfirm = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement policybtn=driver.findElement(By.id("AccountFrm_agree"));
		WebElement contbtn=driver.findElement(By.cssSelector(".lock-on-click"));

		fieldFN.sendKeys(inputFn);
		fieldLN.sendKeys(inputLN);
		fieldEmail.sendKeys(inputEmail);
		fieldPhone.sendKeys(inputPhonenum);
		fieldFax.sendKeys(inputFaxnum);
		fieldloginname.sendKeys(loginNameInput);
		fieldPassword.sendKeys(passinput);
		fieldPassconfirm.sendKeys(passinput);
		fieldZipcode.sendKeys("415848521");
		if(subscribebtn==0)
			driver.findElement(By.id("AccountFrm_newsletter1")).click();
		else
			driver.findElement(By.id("AccountFrm_newsletter0")).click();
		
		// fill country then state then city then adress
		WebElement fieldCountry = driver.findElement(By.id("AccountFrm_country_id"));
		Select selectedCountry = new Select(fieldCountry);
		selectedCountry.selectByIndex(108);
		// state
		WebElement fieldState = driver.findElement(By.id("AccountFrm_zone_id"));
		Select selectedstate = new Select(fieldState);
		Thread.sleep(3000);
		selectedstate.selectByIndex(stateindex);

		// to save value for selcted state to useit in city and adrsee
		String state = selectedstate.getFirstSelectedOption().getText();
        // enter value of state to city and adress
		WebElement fieldCity = driver.findElement(By.id("AccountFrm_city"));
		fieldCity.sendKeys(state);
		WebElement fieldAdress1 = driver.findElement(By.id("AccountFrm_address_1"));
		fieldAdress1.sendKeys(state);

		policybtn.click();
		contbtn.click();

	}
	
	@ Test(priority = 2)
	public void logout() {
		WebElement logoutbtn=driver.findElement(By.linkText("Logoff"));
		logoutbtn.click();
		//String actualoutput=driver.findElement(By.className("maintext")).getText();
		//Assert.assertEquals(actualoutput, expectedresule);
	boolean actuallogoff=driver.getPageSource().contains(expectedresule);
	Assert.assertEquals(actuallogoff,true);
	System.out.print(false);
	}
	

	//
}
