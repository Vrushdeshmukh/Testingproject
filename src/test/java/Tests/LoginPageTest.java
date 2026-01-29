package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTest;
import com.config.ConfigReader;
import com.pages.Loginpage;
import com.utility.ExcelUtils;

@Listeners(com.Listener.TestListener.class)
public class LoginPageTest extends BaseTest {
	Loginpage loginpage;
	SoftAssert soft;

	String path = System.getProperty("user.dir") + "/src/test/testdata/framework.xlsx";

	@Test(priority=1,enabled=false)
	public void check_LoginpageTitle() throws InterruptedException 
	{
		ExcelUtils.loadExcel(path);
		loginpage = new Loginpage(driver);// object of login page

		String expectedtitle = ExcelUtils.getData("data1", 1, 2);
		System.out.println(expectedtitle);

		String actualtitle = loginpage.getLoginPageTitle();
		System.out.println(actualtitle);
		
		Assert.assertNotEquals(actualtitle, expectedtitle);;
		Thread.sleep(5000);

	}
	@Test(priority=2,enabled=false)
	public void check_ValidLogin() throws InterruptedException
	{
		loginpage =new Loginpage(driver);
		boolean actualusernamefield=loginpage.isusernameDisplayed();
		
		Assert.assertTrue(actualusernamefield);
		System.out.println("actualusernamefield "+actualusernamefield );
		
		boolean actualpassfield=loginpage.isPasswordfieldDisplayed();
		Assert.assertTrue(actualpassfield);
		System.out.println("actualpassfield "+actualpassfield );
		
		boolean actualbtnfield=loginpage.isLoginBtnDisplayed();
		System.out.println("actualbtnfield "+actualbtnfield );
		Assert.assertTrue(actualbtnfield);
		loginpage.Login(ConfigReader.get("userid"),ConfigReader.get("pass"));
		Thread.sleep(5000);
		}
	
	@Test(priority=3,enabled=true)
	public void check_ValidLoginWithSoftassert() throws InterruptedException
	{
		soft= new SoftAssert();
		loginpage= new Loginpage(driver);
		
		boolean actualusernamefield=loginpage.isusernameDisplayed();
		soft.assertTrue(actualusernamefield);
		System.out.println("actualusernamefield "+actualusernamefield);
		
		boolean actualpasswordfield=loginpage.isPasswordfieldDisplayed();
		
		Assert.assertFalse(actualpasswordfield);//    failed 
		
		System.out.println("actualpasswordfield "+actualpasswordfield);
		
		loginpage.Login(ConfigReader.get("userid"),ConfigReader.get("pass"));
		soft.assertAll("assertion execute");
		Thread.sleep(5000);
		
	}
	
	@DataProvider
	public Object[][] getDataForInvalidLogin()
	{
		ExcelUtils.loadExcel(path);
		return ExcelUtils.getSheetData("data2");
	}
	
	@Test(priority=4,enabled=false,dataProvider="getDataForInvalidLogin")
	public void check_InvalidLogin_WithMultipleset(String username,String pass) throws InterruptedException
	{
		ExcelUtils.loadExcel(path);
		loginpage = new Loginpage(driver);
		loginpage.Login(username, pass);
		
	}
}
