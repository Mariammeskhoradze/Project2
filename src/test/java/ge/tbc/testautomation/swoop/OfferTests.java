package ge.tbc.testautomation.swoop;


import ge.tbc.testautomation.Util.TestConfig;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.swoop.Steps.*;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;


@Test(groups = {"SwoopRegression"})
@Epic("Swoop UI Testing")
@Feature("Offer Management")
public class OfferTests extends TestConfig {

    HomeSteps homeSteps = new HomeSteps();
    CommonSteps commonSteps = new CommonSteps();


    @BeforeMethod
    public void startUp() {

        open(Constants.SWOOP_URL);
    }

    @DataProvider(name = "searchData")
    public Object[][] searchDataProvider() {
        return new Object[][]{
                {"რუსთავი", true},
                {"ჰოტელი", true},
                {"xyz12345", false},
                {"jxjz", false}
        };
    }


    @Test(dataProvider = "searchData", priority=1)
    @Story("Search Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test search functionality with valid and invalid keywords")
    public void searchTest(String keyword, boolean isValid) {
            homeSteps.searchKeyword(keyword);

        if (isValid) {
            commonSteps.validateSearchResults(keyword);
        } else {
            commonSteps.validateNoResultsMessage();
        }
    }


    PaginationSteps paginationSteps = new PaginationSteps();

    @Test(priority = 2)
    @Description("Test pagination functionality for offers")
    @Story("Pagination")
    @Severity(SeverityLevel.MINOR)
    public void paginationTest() {
        homeSteps
                .goOnCategory()
                .hoverAnyCategory()
                .chooseSubcategory();

        paginationSteps
                .collectFirstPageOffers()
                .navigateToSecondPage()
                .collectSecondPageOffers()
                .navigateToThirdPage()
                .CollectThirdPageOffers()
                .validateOffers()
                .clickOnNextButton()
                .collectNextPageOffers()
                .clickOnPreviousButton()
                .validateNextAndPreviousOffers();
    }

    FirstOfferSteps firstOfferSteps = new FirstOfferSteps();

    @Test(priority = 3)
    @Description("Test map location in first offer")
    @Story("First Offer")
    @Severity(SeverityLevel.NORMAL)
    public void offerLocationTest() {
        homeSteps
                .goOnCategory()
                .hoverAnyCategory()
                .chooseSubcategory();

        paginationSteps
                .clickOnFirstOffer();

        try {
            firstOfferSteps
                    .clickOnLocationAndValidateMap();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    EatAndDrinkSteps eatAndDrinkSteps = new EatAndDrinkSteps();

    @Test(priority = 4)
    @Description("Test number of guests filter functionality in Eat and Drink section")
    @Story("Filter in 'Eat and Drink'")
    @Severity(SeverityLevel.CRITICAL)
    public void numberOfGuestsTest() {
        homeSteps
                .goToeatAndDrink();


        eatAndDrinkSteps
                .chooseNumberOfGuests()
                .ValidateTitlesWithRange();

    }

    @Test(priority = 5)
    @Description("Switch between English and Georgian and validate UI text updates correctly")
    @Story("Language Switch")
    @Severity(SeverityLevel.BLOCKER)
    public void changeLanguageTest() {
        homeSteps
                .switchToEnglish()
                .validateEnglishUI()
                .switchToGeorgian()
                .validateGeorgianUI();
    }
}








