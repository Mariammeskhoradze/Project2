package ge.tbc.testautomation.saucedemo.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement usernameField = $("#user-name"),
    passwordField=$("#password"),
    loginButton = $("#login-button"),

    //bannedUserLoginTest
    errorMessage = $(".error-message-container"),
    errorIcon = $(".error-button");


}
