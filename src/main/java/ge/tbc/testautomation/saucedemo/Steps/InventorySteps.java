package ge.tbc.testautomation.saucedemo.Steps;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.saucedemo.Pages.InventoryPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.visible;


public class InventorySteps {

    InventoryPage inventoryPage = new InventoryPage();
    SoftAssert softAssert = new SoftAssert();

    @Step("Validate all images are loaded on the landing page")
    public boolean validateAllImagesAreLoaded() {

        inventoryPage.images.first().shouldBe(visible);

        for (var image : inventoryPage.images) {
            softAssert.assertTrue(image.isDisplayed(), Constants.IMG_ASSERTION_MESSAGE);
        }

        softAssert.assertAll();

        return true;
    }

    @Step("click on threelinebutton")
    public InventorySteps clickOnThreeLineButton() {
       inventoryPage.threeLineButton.click();
        return this;
    }

    @Step("log out")
    public InventorySteps logOut() {
       inventoryPage.logOutButton.click();
      
        return this;
    }

}
