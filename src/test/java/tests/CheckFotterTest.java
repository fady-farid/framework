package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class CheckFotterTest extends TestBase{

	HomePage homeObject ;
	ProductsPage productsObject;

	String userName ="standard_user";
	String Password = "secret_sauce";


	@Test
	public void CheckFooter()
	{
		homeObject = new HomePage(driver);
		homeObject.Login(userName, Password);
		productsObject = new ProductsPage(driver);
		Assert.assertTrue(productsObject.productsLbl.getText().contains("Products"));
		productsObject = new ProductsPage(driver);
		productsObject.Scroll();
		Assert.assertTrue(productsObject.fotterLbl.getText().contains("Terms of Service | Privacy Policy"));
		productsObject.logout();
	}

}

