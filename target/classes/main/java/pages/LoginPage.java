package pages;

import org.junit.Assert;
import libs.ConfigClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    private Logger LOG = Logger.getLogger(getClass());

    @FindBy(name = "_username")
    private WebElement inputLoginName;

    @FindBy(name = "_password")
    private WebElement inputPasswordName;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement inputButtonXpath;

    @FindBy(xpath = ".//div[@class='login-box-body']")
    private WebElement loginBox;

    String url = "http://v3.test.itpmgroup.com";

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void openPageLogin(){
        try {
            webDriver.get(ConfigClass.getCfgValue("base_url")+"/login");
            logger.info("Page login was opened");

        } catch (Exception e) {
            logger.info("Can't open URL");
            Assert.fail ("Can't open URL");
        }

    }

    public void openPage(){
        try{
            webDriver.get(url);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void inputLogin(String login){
        actionWithWebElements.enterTextToText(inputLoginName, login);
    }

    public void inputPassword(String password){
        actionWithWebElements.enterTextToText(inputPasswordName, password);
    }

    public void clickSubmitButton(){
        actionWithWebElements.clickButton(inputButtonXpath);
    }

    public void loginToPage(String login, String password){
        openPageLogin();
        inputLogin(login);
        inputPassword(password);
        clickSubmitButton();
    }


    public boolean isLoginBoxDisplayed () {
        return actionWithWebElements.isElementDisplayed(loginBox);
    }

}