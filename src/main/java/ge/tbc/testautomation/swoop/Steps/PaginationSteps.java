package ge.tbc.testautomation.swoop.Steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.swoop.Pages.PaginationPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

public class PaginationSteps {

    PaginationPage paginationPage = new PaginationPage();
    SoftAssert softAssert = new SoftAssert();

    List<String> firstPageOffers = new ArrayList<>();
    List<String> secondPageOffers = new ArrayList<>();
    List<String> thirdPageOffers = new ArrayList<>();
    List<String> nextPageOffers = new ArrayList<>();



    //paginationTest

    @Step("Navigate to first page and collect offers")
    public PaginationSteps collectFirstPageOffers() {

        paginationPage.nextButton.shouldBe(visible);

        for (SelenideElement element : paginationPage.results) {
            firstPageOffers.add(element.getText());
        }
        return this;
    }

    @Step("Navigate to second page")
    public PaginationSteps navigateToSecondPage(){

        paginationPage.secondPageButton.click();

        return this;
    }

    @Step("Collect offers from second page")
    public PaginationSteps collectSecondPageOffers() {

        paginationPage.nextButton.shouldBe(visible);

        for (SelenideElement element : paginationPage.results) {
            secondPageOffers.add(element.getText());
        }

        return this;
    }

    @Step("Navigate to third page")
    public PaginationSteps navigateToThirdPage(){
        paginationPage.thirdPageButton.click();

        return this;

    }

    @Step("Navigate to third page and collect offers")
    public PaginationSteps CollectThirdPageOffers() {

        paginationPage.nextButton.shouldBe(visible);

        for (SelenideElement element : paginationPage.results) {
            thirdPageOffers.add(element.getText());
        }

        return this;
    }


    @Step("validate that results differ from the first page")
    public PaginationSteps validateOffers() {
        for (String offer : firstPageOffers) {

            softAssert.assertTrue(!secondPageOffers.contains(offer), Constants.SECONDPAGEOFFERS_MESSAGE + offer);
            softAssert.assertTrue(!thirdPageOffers.contains(offer), Constants.THIRDPAGEOFFERS_MESSAGE + offer);
        }
        softAssert.assertAll();
        return this;
    }

    @Step("click on next button")
    public PaginationSteps clickOnNextButton(){
        paginationPage.nextButton.click();
        return this;
    }

    @Step("Collect next page offers")
    public PaginationSteps collectNextPageOffers(){

        paginationPage.nextButton.shouldBe(visible);

        for (SelenideElement element : paginationPage.results) {
            nextPageOffers.add(element.getText());
        }

        return this;
    }

    @Step("click on previous button")
    public PaginationSteps clickOnPreviousButton(){
        paginationPage.previousButton.click();
        return this;
    }

    @Step("Validate that next page and previous page offers are different")
    public PaginationSteps validateNextAndPreviousOffers() {
        for (String offer : nextPageOffers) {
            assertTrue(!thirdPageOffers.contains(offer), Constants.NEXTANDPREVIOUS_PAGE_MESSAGE + offer);
        }
        return this;
    }

    //offerLocationTest
    @Step("click on first offer from subcategory page")
    public PaginationSteps clickOnFirstOffer(){
        paginationPage.firstOffer.click();

        return this;
    }
}
