package ui.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ui.TestCases.BaseClass;

public class AutomationPageObjects extends BaseClass{
	//WebDriver driver;
	By searchbutton = By.xpath("//input[@class='search_query form-control ac_input']");
	By dressname= By.xpath("//h1[contains(text(),'Printed')]");
    By Submitbutton=By.xpath("//button[@name='submit_search']");
    By Searchdressvalidate= By.xpath("//span[@class='lighter']");
    By tshirtsection= By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]");
    By lbutton=By.xpath("//label[@for='layered_id_attribute_group_3']");
    By ContactusButton=By.xpath("//div[@id='contact-link']/a");
    By Choosefilebutton=By.xpath("//input[@name='fileUpload']");
    By addtocart=By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span");
    By noSearchText=By.xpath("//p[contains(text(),'No results were found for your search')]");
    By continuebutton=By.xpath("//span[@title='Continue shopping']");
    By cartbutton=By.xpath("//a[@title='View my shopping cart']");
    By totalprice=By.xpath("//span[@id='total_price']");
    
    
  public AutomationPageObjects(WebDriver driver) {
   this.driver=driver;	
   }
    
    public void clicksearchbutton() {
    	driver.findElement(searchbutton).click();
    }
    public void enterdressname(String arg1) {
    	driver.findElement(searchbutton).sendKeys(arg1);;
    }
    public void clickSubmitbutton() {
    	driver.findElement(Submitbutton).click();
    }
    public void clicktshirtsection() {
    	driver.findElement(tshirtsection).click();
    }
    public void clicklbutton() {
    	driver.findElement(lbutton).click();
    }
    public void clickContactusButton() {
    	driver.findElement(ContactusButton).click();
    }
    public void clickChoosefilebutton() {
    	driver.findElement(Choosefilebutton).sendKeys("C:\\Users\\Thumma Bhavana\\Documents\\helloselenium.txt");
    }
    public void clickaddtocart() throws InterruptedException {
    	for(int i=3;i<=7;i++)
    	{
        Actions a= new Actions(driver);
    	a.moveToElement(driver.findElement(By.xpath("//ul[@id='homefeatured']/li["+i+"]/div/div[2]/h5/a"))).perform();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//ul[@id='homefeatured']/li["+i+"]/div/div[2]/div[2]/a[1]/span")).click();
    	Thread.sleep(2000);
    	driver.findElement(continuebutton).click();
    	
    	}
    }
    public void clickcartbutton() {
    	driver.findElement(cartbutton).click();
    }
    public String gettotalprice() {
    	return driver.findElement(totalprice).getText();
    }
	public String Searchdressvalidate() {
    	return driver.findElement(Searchdressvalidate).getText();
    	  
    }
    public String Searchcharvalidate() {
    	return driver.findElement(noSearchText).getText();
    	  
    }
}
