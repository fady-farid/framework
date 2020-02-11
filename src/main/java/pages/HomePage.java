package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id="user-name")
	WebElement userNameTxtBox;

	@FindBy(id="password")
	WebElement passwordTxtBox;

	@FindBy(css="input.btn_action")
	WebElement loginBtn;

	public void Login(String username, String password)
	{
		SetTextElement(userNameTxtBox, username);
		SetTextElement(passwordTxtBox, password);
		ClickBtn(loginBtn);
	}

}
