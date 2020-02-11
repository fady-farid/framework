package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	Select select;
	JavascriptExecutor js;

	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public int invalidImageCount;
	
	protected static void ClickBtn(WebElement button)
	{
		button.click();
	}

	protected static void SetTextElement(WebElement textBox, String value)
	{
		textBox.sendKeys(value);
	}

	protected void ClearText(WebElement element)
	{
		element.clear();
	}
	
	public void ScrollToButtom()
	{
		js.executeScript("scrollBy(0,2500)");
	}
	
	public void VerfyLinks(String url) throws IOException
	{
		try {
			URL links = new URL(url);
			HttpURLConnection httpConnection = (HttpURLConnection) links.openConnection();
			httpConnection.setConnectTimeout(3000);
			httpConnection.connect();
			if(httpConnection.getResponseCode() != 200)
			{
				System.out.print(url + "***" + httpConnection.getResponseMessage());
			}
			else
			{
				System.out.println("Good URL" + "***" + httpConnection.getResponseMessage());
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void VerfyImage(WebElement img)
	{
		 HttpClient client = HttpClientBuilder.create().build();
		 HttpGet request = new HttpGet(img.getAttribute("src"));
		 try {
			HttpResponse response = client.execute(request);
			if(response.getStatusLine().getStatusCode() != 200)
			{
				invalidImageCount++;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
