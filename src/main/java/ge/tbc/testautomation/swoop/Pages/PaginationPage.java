package ge.tbc.testautomation.swoop.Pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PaginationPage {
   public SelenideElement

              //pagionationTest
              secondPageButton =
                      $x("//div[contains(@class,'cursor-pointer text-md font-tbcx-medium') and contains(text(), '2')]"),
              thirdPageButton =
                      $x("//div[contains(@class,'cursor-pointer text-md font-tbcx-medium') and contains(text(), '3')]"),
              nextButton = $x("//img[@alt='right arrow']"),
              previousButton = $x("//img[@alt='left arrow']"),
              //offerLocationTest
              firstOffer = $x("//a[@class='group flex flex-col gap-3 cursor-pointer max-tablet:gap-2'][1]");
    public ElementsCollection results =
    $$x("//div[@class='flex  justify-start items-start flex-col gap-0.5 tablet:h-16 max-tablet:line-clamp-2 !flex']");

}


