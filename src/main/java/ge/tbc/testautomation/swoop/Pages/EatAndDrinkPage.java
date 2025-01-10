package ge.tbc.testautomation.swoop.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class EatAndDrinkPage {
   public SelenideElement numberOfGuestsFilter = $x("//input[@id='radio-სტუმრების რაოდენობა-2']"),
           filterText =  $x("//input[@id='radio-სტუმრების რაოდენობა-2']/following-sibling::span");
   public ElementsCollection offerTitles =
           $$x("//div[@class='flex  justify-start items-start flex-col gap-0.5 tablet:h-16 max-tablet:line-clamp-2 !flex']/h4");


}
