package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class UserCanSelectFromDropDownMenuTest extends TestBase{
	
	HomePage homeObject;
	ProductsPage productsObject;
	
	String userName ="standard_user";
	String Password = "secret_sauce";
	
	@Test
	public void UserCanSelectFromDropDownMenu()
	{
		homeObject = new HomePage(driver);
		homeObject.Login(userName, Password);
		productsObject = new ProductsPage(driver);
		Assert.assertTrue(productsObject.productsLbl.getText().contains("Products"));
		productsObject.SelectfromDropDownMenu();
		Assert.assertTrue(!productsObject.price.getText().contains("49.99"));
		productsObject.logout();
	}

}
