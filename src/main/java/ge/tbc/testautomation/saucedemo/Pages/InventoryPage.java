package ge.tbc.testautomation.saucedemo.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {
    //successfulLoginTest
    public ElementsCollection images = $$(".inventory_item_img");
    //logOutTest
    public SelenideElement threeLineButton = $("#react-burger-menu-btn"),
                           logOutButton = $("#logout_sidebar_link");

}
