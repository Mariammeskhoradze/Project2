package ge.tbc.testautomation.swoop.Steps;

import ge.tbc.testautomation.swoop.Pages.FirstOfferPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

public class FirstOfferSteps {

    FirstOfferPage firstOfferPage = new FirstOfferPage();

    SoftAssert softAssert = new SoftAssert();

    @Step("click on location button and validate that map shown")
    public FirstOfferSteps clickOnLocationAndValidateMap() throws InterruptedException {
        firstOfferPage.location.scrollIntoView("{block: 'center'}").click();

        firstOfferPage.map.shouldBe(visible);
        softAssert.assertTrue(firstOfferPage.map.isDisplayed());
        softAssert.assertAll();
        System.out.println("konflikti2");
        return this;
    }
}
