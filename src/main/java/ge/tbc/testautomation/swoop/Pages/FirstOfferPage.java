package ge.tbc.testautomation.swoop.Pages;

import com.codeborne.selenide.SelenideElement;;

import static com.codeborne.selenide.Selenide.$x;

public class FirstOfferPage {

    public SelenideElement location = $x("//button/p[contains(text(), 'მდებარეობა')]"),
            map = $x("//div[@style='position: relative;' and @tabindex='0']");
}
