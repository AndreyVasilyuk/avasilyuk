package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoworkersPage extends ParentPage {

    private Logger LOG = Logger.getLogger(getClass());

    @FindBy(xpath = "//i[@class='fa fa-book']")
    private WebElement dictionaryTab;

    @FindBy(css = "a[href='/dictionary/workers']")
    private WebElement workersTab;

    @FindBy(xpath = "//div[@class='col-md-12']")
    private WebElement usersTable;

    @FindBy(id = "workers_workerSurname")
    private WebElement workersSurnameField;

    @FindBy(id = "workers_workerName")
    private WebElement workersNameField;

    @FindBy(id = "workers_workerMiddleName")
    private WebElement workersMiddleNameField;

    @FindBy(id = "workers_workerPhone")
    private WebElement workersPhoneField;

    @FindBy(xpath = "//div[@class='box-tools']")
    private WebElement addButton;

    @FindBy(name = "add")
    private WebElement saveButton;

    public CoworkersPage(WebDriver webDriver) {super(webDriver);}

    public void tableView(){
        actionWithWebElements.clickButton(dictionaryTab);
        actionWithWebElements.clickButton(workersTab);
    }

    public int countTableRows(){
        List<WebElement> rows = usersTable.findElements(By.tagName("tr"));
        return rows.size();
    }

    public void addTableRecord(String workerSurname, String workerName, String workerMiddleName,String workerPhone){
        actionWithWebElements.clickButton(addButton);
        actionWithWebElements.enterTextToText(workersSurnameField, workerSurname);
        actionWithWebElements.enterTextToText(workersNameField, workerName);
        actionWithWebElements.enterTextToText(workersMiddleNameField, workerMiddleName);
        actionWithWebElements.enterTextToText(workersPhoneField, workerPhone);
        actionWithWebElements.clickButton(saveButton);
    }
}


