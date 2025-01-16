package ge.tbc.testautomation.swoop.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public SelenideElement
            //searchTest

            searchInput =  $x("//div[@class='relative w-full']/input"),
            //paginationTest , offerLocationTest

            categoryDropDown = $x("//p[contains(text(), 'კატეგორიები')]/parent::button"),
            restCategory = $x("//h4[contains(text(), 'დასვენება')]"),
            mountainResorts = $x("//h4[contains(text(), 'მთის კურორტები')]/parent::a"),
            //numberOfGuestsTest

            eatAndDrinkButton = $x("//img[@alt='კვება']"),

            //changeLanguageTest
            languageSwitcher = $x("//div/img[@alt='cart']"),
                    englishOption = $x("//p[contains(text(), 'English')]"),
                    georgianOption = $x("//p[contains(text(), 'Georgian')]");
    public ElementsCollection uiTextElements =
            $$x("//div[@class='flex  justify-start items-start items-center gap-6 laptop:gap-6 laptop:justify-between']/child::a/child::p");
}
