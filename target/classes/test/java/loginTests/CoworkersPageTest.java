package loginTests;

import org.junit.Assert;
import org.junit.Test;
import parentTests.AbstractParentTest;

public class CoworkersPageTest extends AbstractParentTest {
    private String workerSurname = "Ivanenko";
    private String workerName = "Ivan";
    private String workerMiddleName = "Ivanovich";
    private String workerPhone = "1223456";

    @Test
    public void addRecord() {
        loginPage.loginToPage(user, password);
        checkExpectedResult("Avatar is displayed", parentPage.isAvatarDisplayed());

        coworkers.tableView();
        int rawsBefore = coworkers.countTableRows();
        coworkers.addTableRecord(workerSurname, workerName, workerMiddleName, workerPhone);
        int rawsAfter = coworkers.countTableRows();
        Assert.assertEquals(rawsBefore + 1, rawsAfter);

        String actualRecord = spareParts.getTableRecord(rawsAfter - 1);
        String expectedRecord = workerSurname + " " + workerName + " " + workerMiddleName + " " + workerPhone;
        Assert.assertTrue("Table record wasn't updated", actualRecord.contains(expectedRecord));
    }
}
