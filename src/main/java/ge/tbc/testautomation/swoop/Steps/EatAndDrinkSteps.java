package ge.tbc.testautomation.swoop.Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.swoop.Pages.EatAndDrinkPage;
import io.qameta.allure.Step;
import ge.tbc.testautomation.Util.GuestNumberUtil;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class EatAndDrinkSteps  {

    EatAndDrinkPage eatAndDrinkPage = new EatAndDrinkPage();

    SoftAssert softAssert = new SoftAssert();

    @Step("choose 'number of guests' filter")
    public EatAndDrinkSteps chooseNumberOfGuests() {
        eatAndDrinkPage.numberOfGuestsFilter.scrollIntoView("{block: 'center'}").click();
        return this;
    }



    @Step("validate number of guests in offers")
    public EatAndDrinkSteps ValidateTitlesWithRange()  {

        String filtertext = eatAndDrinkPage.filterText.getText();

        String[] guestRange = filtertext.split("-");
        int minGuests = Integer.parseInt(guestRange[0].trim());
        int maxGuests = Integer.parseInt(guestRange[1].replaceAll("[^0-9]", "").trim());

        List<String> validTitles = new ArrayList<>();

        eatAndDrinkPage.offerTitles.first().shouldBe(Condition.visible);

        for (SelenideElement title : eatAndDrinkPage.offerTitles) {
            String titleText = title.getText();

            List<Integer> extractedNumbers = GuestNumberUtil.extractAllNumbers(titleText);


            boolean isValid = extractedNumbers.stream()
                    .anyMatch(number -> minGuests <= number && number <= maxGuests);

            if (isValid) {
                validTitles.add(titleText);
            } else {
                System.out.println(Constants.INVALID_TITLE_IS + titleText + Constants.NUMBERS_IS + extractedNumbers + Constants.BRACKET);
            }
        }

//          System.out.println("Valid titles: " + validTitles);
          softAssert.assertAll();
          return this;
    }

}


