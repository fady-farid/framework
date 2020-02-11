package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="CHECKOUT")
	WebElement checkOutBtn;
	
	public void CheckOut()
	{
		ClickBtn(checkOutBtn);
	}

}
