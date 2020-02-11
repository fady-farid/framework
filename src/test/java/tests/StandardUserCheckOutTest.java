package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductsPage;

public class StandardUserCheckOutTest extends TestBase{
	
	HomePage homeObject ;
	ProductsPage productsObject;
	CartPage cartObject;
	CheckOutPage checkOutObject;

	String userName ="standard_user";
	String Password = "secret_sauce";
	String fName = "fady";
	String lName = "farid";
	String postalCode = "123";

	@Test
	public void StandardUSerCanCheckOut()
	{
		homeObject = new HomePage(driver);
		homeObject.Login(userName, Password);
		productsObject = new ProductsPage(driver);
		Assert.assertTrue(productsObject.productsLbl.getText().contains("Products"));
		productsObject.AddToCart();
		driver.navigate().to("https://www.saucedemo.com/cart.html");
		cartObject = new CartPage(driver);
		cartObject.CheckOut();
		checkOutObject = new CheckOutPage(driver);
		checkOutObject.ContinueCheckOut(fName, lName, postalCode);
		Assert.assertTrue(checkOutObject.successLbl.getText().contains("THANK YOU FOR YOUR ORDER"));
		productsObject.logout();
	}

}
