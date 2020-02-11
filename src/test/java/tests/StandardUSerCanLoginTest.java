package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class StandardUSerCanLoginTest extends TestBase{

	HomePage homeObject ;
	ProductsPage productsObject;

	String userName ="standard_user";
	String Password = "secret_sauce";

	@Test
	public void StandardUSerCanLogin()
	{
		homeObject = new HomePage(driver);
		homeObject.Login(userName, Password);
		productsObject = new ProductsPage(driver);
		Assert.assertTrue(productsObject.productsLbl.getText().contains("Products"));
		productsObject.logout();
	}

}
