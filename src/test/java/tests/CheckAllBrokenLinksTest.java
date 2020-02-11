package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class CheckAllBrokenLinksTest extends TestBase{
	
	ProductsPage productsObject;
	HomePage homeObject;
	
	String userName ="problem_user";
	String Password = "secret_sauce";
	
	@Test
	public void CheckAllBrokenLinks() throws IOException
	{
		homeObject = new HomePage(driver);
		homeObject.Login(userName, Password);
		productsObject = new ProductsPage(driver);
		Assert.assertTrue(productsObject.productsLbl.getText().contains("Products"));
		productsObject.TestBrokenLinks();
		productsObject.logout();
	}

}
