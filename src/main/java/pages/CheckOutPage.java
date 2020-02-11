package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="first-name")
	WebElement firstNameTxtBox;
	
	@FindBy(id="last-name")
	WebElement lastNameTxtBox;
	
	@FindBy(id="postal-code")
	WebElement postalCodeTxtBox;
	
	@FindBy(css="input.btn_primary.cart_button")
	WebElement continueBtn;
	
	@FindBy(linkText="FINISH")
	WebElement finishBtn;
	
	@FindBy(tagName="h2")
	public WebElement successLbl;
	
	public void ContinueCheckOut(String fName,String lName,String postalCode)
	{
		SetTextElement(firstNameTxtBox, fName);
		SetTextElement(lastNameTxtBox, lName);
		SetTextElement(postalCodeTxtBox, postalCode);
		ClickBtn(continueBtn);
		ClickBtn(finishBtn);
	}

}
