package loginTests;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import parentTests.AbstractParentTest;

import java.util.List;

public class SparePartsPageTest extends AbstractParentTest {

    private String name = "Andrey";
    private String address = "Kiyv";
    private String phone = "0675099466";

    @Test
    public void addRecord() {
        loginPage.loginToPage(user, password);
        checkExpectedResult("Avatar is displayed", parentPage.isAvatarDisplayed());

        spareParts.tableView();
        int rawsBefore = spareParts.countTableRows();
        spareParts.addTableRecord(name, address, phone);
        int rawsAfter = spareParts.countTableRows();
        Assert.assertEquals(rawsBefore + 1, rawsAfter);

        String actualRecord = spareParts.getTableRecord(rawsAfter - 1);
        String expectedRecord = name + " " + address + " " + phone;
        Assert.assertTrue("Table record wasn't updated", actualRecord.contains(expectedRecord));
    }

    @Test
    public void deleteRecord() {
        loginPage.loginToPage(user, password);
        checkExpectedResult("Avatar is displayed", parentPage.isAvatarDisplayed());

        spareParts.tableView();
        int rawsBefore = spareParts.countTableRows();
        spareParts.addTableRecord(name, address, phone);
        int rawsAfterAdding = spareParts.countTableRows();
        Assert.assertEquals("Record wasn't added to table", rawsBefore + 1, rawsAfterAdding);

        spareParts.removeTableRecord(rawsAfterAdding);
        int rawsAfterDeleting = spareParts.countTableRows();
        Assert.assertEquals("Record wasn't deleted from table", rawsAfterAdding - 1, rawsAfterDeleting);
    }

    private void deleteTableRecord(int rawsAfterAdding) {
    }

    @Test
    public void updateRecord() {
        loginPage.loginToPage(user, password);
        checkExpectedResult("Avatar is displayed", parentPage.isAvatarDisplayed());

        spareParts.tableView();
        int rawsBefore = spareParts.countTableRows();
        spareParts.addTableRecord(name, address, phone);
        int rawsAfterAdding = spareParts.countTableRows();
        Assert.assertEquals("Record wasn't added", rawsBefore + 1, rawsAfterAdding);

        String newName = "Adam";
        String newAddress = "Donetsk";
        String newPhone = "0672356788";

        spareParts.updateTableRecord(rawsAfterAdding, newName, newAddress, newPhone);
        String actualRecord = spareParts.getTableRecord(rawsAfterAdding - 2);
        String expectedRecord = newName + " " + newAddress + " " + newPhone;
        Assert.assertTrue("Table record wasn't updated", actualRecord.contains(expectedRecord));
    }



    private void updateTableRecord(int rawsAfterAdding, String newName, String newAddress, String newPhone) {
    }
    

}



