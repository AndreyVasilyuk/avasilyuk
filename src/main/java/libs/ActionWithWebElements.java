package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionWithWebElements {


    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextToText(WebElement element, String text) {

        try {
            element.clear();
            element.sendKeys(text);
            logger.info("");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
        }
    }

    public void clickButton(WebElement element) {
        try {
            element.click();
            logger.info("");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
        }
    }

    public void clickButton(By element){
        try {
            webDriver.findElement(element).click();
            logger.info("");
        } catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }


    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }

    public void setCheckBox(WebElement element, boolean state) {
        try {
            if (element.isSelected() == state) {

            } else {
                element.click();
            }
            logger.info("");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
        }
    }

    private void selectElementFromDD(String element, String itemName) {
        Select dropDownValue = new Select(webDriver.findElement(By.xpath(element)));
        try {
            dropDownValue.selectByVisibleText(itemName);
            dropDownValue.selectByVisibleText(itemName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
        }


    }

    public void selectValueFromSelector(WebElement element, String text) {
        Select dropDownValue = new Select(element);
        try {
            dropDownValue.selectByVisibleText(text);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
        }

    }
}





