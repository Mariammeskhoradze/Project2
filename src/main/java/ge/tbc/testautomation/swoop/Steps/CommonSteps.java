package ge.tbc.testautomation.swoop.Steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.swoop.Pages.CommonPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.AssertJUnit.assertTrue;


public class CommonSteps {

    CommonPage commonPage = new CommonPage();
    SoftAssert softAssert = new SoftAssert();

    @Step("Validate that search results contain keyword: {0}")
    public void validateSearchResults(String keyword) {

        commonPage.valQuery.findBy(Condition.text(keyword)).should(visible);

        for (SelenideElement result : commonPage.valQuery) {
            softAssert.assertTrue(result.getText().contains(keyword), Constants.SEARCH_RESULT_MESSAGE + result.getText());
        }
        softAssert.assertAll();
    }


    @Step("Validate that 'No offer found' message is displayed")
    public void validateNoResultsMessage() {

       commonPage.notFound.shouldBe(visible);
        System.out.println("konflikti");
    }

}
