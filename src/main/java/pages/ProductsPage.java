package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends PageBase{

	public ProductsPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(css="div.product_label")
	public WebElement productsLbl;

	@FindBy(xpath="//*[@id='menu_button_container']/div/div[3]/div/button")
	WebElement BurgerMenuBtn;

	@FindBy(linkText="Logout")
	WebElement logoutBtn;

	@FindBy(css="select.product_sort_container")
	WebElement dropDownMenu;

	@FindBy(xpath="//*[@id='inventory_container']/div/div[1]/div[3]/div")
	public WebElement price;

	@FindBy(xpath="//*[@id='inventory_container']/div/div[1]/div[3]/button")
	WebElement addToCartBtn1;

	@FindBy(xpath="//*[@id='inventory_container']/div/div[2]/div[3]/button")
	WebElement addToCartBtn2;

	@FindBy(css="div.footer_copy")
	public WebElement fotterLbl;

	@FindBy(tagName="a")
	List<WebElement> allLinks;

	@FindBy(tagName="img")
	List<WebElement> allImages;

	public void AddToCart()
	{
		ClickBtn(addToCartBtn1);
		ClickBtn(addToCartBtn2);
	}

	public void logout()
	{
		ClickBtn(BurgerMenuBtn);
		ClickBtn(logoutBtn);
	}

	public void SelectfromDropDownMenu()
	{
		select = new Select(dropDownMenu);
		select.selectByVisibleText("Price (high to low)");
	}

	public void Scroll()
	{
		ScrollToButtom();
	}

	public void TestBrokenLinks() throws IOException
	{
		System.out.println(allLinks.size());
		for(int i=0 ; i < allLinks.size(); i++)
		{
			WebElement link = allLinks.get(i);
			String url = link.getAttribute("href");
			VerfyLinks(url);
		}
	}

	public void TestBrokenImage()
	{
		for(WebElement img : allImages)
		{
			if(img != null)
			{
				VerfyImage(img);
			}
		}
		System.out.println("Broken images are: " + invalidImageCount);
	}

}
