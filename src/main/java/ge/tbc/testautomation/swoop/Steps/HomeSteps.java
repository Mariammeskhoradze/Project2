package ge.tbc.testautomation.swoop.Steps;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.swoop.Pages.HomePage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;


public class HomeSteps {

    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();


    //searchTest
    @Step("Click on search bar and type keyword: {0}")
    public void searchKeyword(String keyword) {
        homePage.searchInput.click();
        homePage.searchInput.setValue(keyword).pressEnter();
    }

    //paginationTest, offerLocationTest
    @Step("go on 'კატეგორიები' ")
    public HomeSteps goOnCategory() {
        homePage.categoryDropDown.click();
        return this;
    }

    @Step("hover any category")
    public HomeSteps hoverAnyCategory() {
        Selenide.actions().moveToElement(homePage.restCategory).perform();
        return this;
    }

    @Step("choose any subcategory")
    public HomeSteps chooseSubcategory() {
        homePage.mountainResorts.click();
        return this;
    }

    //numberOfGuestsTest
    @Step("go to eat and drink")
    public HomeSteps goToeatAndDrink() {
        homePage.eatAndDrinkButton.click();
        return this;
    }


    //changeLanguageTest

    @Step("Switch to English")
    public HomeSteps
    switchToEnglish() {

        homePage.languageSwitcher.click();
        homePage.englishOption.click();


        homePage.uiTextElements.shouldBe(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : homePage.uiTextElements) {
            element.shouldHave(Condition.matchText(".*[a-zA-Z].*")).shouldBe(Condition.visible);

        }
        softAssert.assertAll();
        return this;
    }

    @Step("Switch to Georgian")
    public HomeSteps switchToGeorgian() {

        homePage.languageSwitcher.click();
        homePage.georgianOption.click();

        homePage.uiTextElements.shouldBe(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : homePage.uiTextElements) {
            element.shouldHave(Condition.matchText(".*[ა-ჰ].*")).shouldBe(Condition.visible);
        }
        softAssert.assertAll();
        return this;
    }


    @Step("Validate UI text for English")
    public HomeSteps validateEnglishUI() {

        for (SelenideElement element : homePage.uiTextElements) {
            String text = element.getText();
            assertTrue(text.matches(".*[a-zA-Z].*"), Constants.ENGLISHTEXT_MESSAGE + text);
        }

        return this;
    }


    @Step("Validate UI text for Georgian")
    public HomeSteps validateGeorgianUI() {

        for (SelenideElement element : homePage.uiTextElements) {
            String text = element.getText();
            assertTrue(text.matches(".*[ა-ჰ].*"), Constants.GEORGIANTEXT_MESSAGE + text);
        }

        return this;
    }
}

