package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePartsPage extends ParentPage {

    @FindBy(xpath = "//i[@class='fa fa-book']")
    private WebElement dictionaryTab;

    @FindBy(id = "prov_cus")
    private WebElement sparePartsTab;

    @FindBy(xpath = "//div[@class='box-tools']")
    private WebElement addButton;

    @FindBy(id = "prov_cus_proCustName")
    private WebElement customerNameField;

    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement customerAddressField;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement customerPhoneField;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement privatePersonCheckbox;

    @FindBy(name = "add")
    private WebElement createButton;

    @FindBy(xpath = "//table[@id='device_list']//tbody")
    private WebElement table;

    @FindBy(name = "delete")
    private WebElement deleteButton;

    @FindBy(name = "save")
    private WebElement saveButton;

    public SparePartsPage(WebDriver webDriver){
        super(webDriver);
    }

    public void tableView(){
        actionWithWebElements.clickButton(dictionaryTab);
        actionWithWebElements.clickButton(sparePartsTab);
    }

    public int countTableRows(){
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size();
    }

    public void removeTableRecord(int index){
        actionWithWebElements.clickButton(getEditIcon(index));
        actionWithWebElements.clickButton(deleteButton);
    }

    private By getEditIcon(int index){
        return By.xpath("//tr[" + (index-1) + "]//td[4]");
    }

    public void updateTableRecord(int index, String name, String address, String phone){
        actionWithWebElements.clickButton(getEditIcon(index));
        actionWithWebElements.enterTextToText(customerNameField, name);
        actionWithWebElements.enterTextToText(customerAddressField,address);
        actionWithWebElements.enterTextToText(customerPhoneField,phone);
        actionWithWebElements.clickButton(saveButton);
    }

    public String getTableRecord (int index){
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.get(index).getText();
    }

    public void addTableRecord(String name, String address, String phone){
        actionWithWebElements.clickButton(addButton);
        actionWithWebElements.enterTextToText(customerNameField,name);
        actionWithWebElements.enterTextToText(customerAddressField,address);
        actionWithWebElements.enterTextToText(customerPhoneField,phone);
        actionWithWebElements.clickButton(privatePersonCheckbox);
        actionWithWebElements.clickButton(createButton);
    }
}