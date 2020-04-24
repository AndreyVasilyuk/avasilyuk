package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparatPage extends ParentPage {

    private Logger LOG = Logger.getLogger(getClass());

    @FindBy(xpath = "//i[@class='fa fa-book']")
    private WebElement dictionaryTab;

    @FindBy(id = "apparat")
    private WebElement apparatTab;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    private WebElement addButton;

    @FindBy(xpath = "//section[@class='content']")
    private WebElement contentTable;

    @FindBy(xpath = "//input[@id='apparat_apparatNumber']")
    private WebElement apparatNumber;

    @FindBy(xpath = "//input[@id='apparat_apparatComment']")
    private WebElement apparatComment;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement createButton;

    public ApparatPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public void addTableRecord() {
        actionWithWebElements.clickButton(dictionaryTab);
        actionWithWebElements.clickButton(apparatTab);

        try {
            new Thread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actionWithWebElements.clickButton(addButton);





//        actionWithWebElements.
    }
//
//    public boolean isAvatarDisplayed () {
//        return actionWithWebElements.isElementDisplayed(avatar);
//    }
//
//    public void checkIsAvatarPresent () {
//        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
//    }
//
//    public void clickOnSubmenuProviders () {
//        actionWithWebElements.clickButton(submenuProviders);
//    }


}
