package ge.tbc.testautomation.saucedemo.Steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.saucedemo.Pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    SoftAssert softAssert = new SoftAssert();


    @Step("Enter Username")
    public LoginSteps enterUsername(String username) {
        loginPage.usernameField.setValue(username);
        return this;
    }

    @Step("Enter Password")
    public LoginSteps enterPassword(String password) {
        loginPage.passwordField.setValue(password);
        return this;
    }

    @Step("click on login button")
    public LoginSteps clickLogin() {
        loginPage.loginButton.click();
        return this;
    }

    @Step("Validate Error Message appear")
    public LoginSteps validateErrorMessage() {

        String errorMessage = loginPage.errorMessage.getText();
        softAssert.assertTrue(errorMessage.contains(Constants.ERROR_TEXT),
                Constants.ERROR_TEXT_MESSAGE + errorMessage);

        loginPage.errorMessage.should(Condition.appear);

        softAssert.assertAll();

        return this;
    }


    @Step("Validate error Icon is visible")
    public LoginSteps validateErrorIcon() {
        assertTrue(loginPage.errorIcon.isDisplayed(), Constants.ERROR_ICON_MESSAGE);
        return this;
    }


    @Step("Validate that fields are empty after logout")
    public LoginSteps validateEmptyFields() {

        softAssert.assertTrue(loginPage.usernameField.getValue().isEmpty(), Constants.USERNAME_FIELD_MESSAGE);
        softAssert.assertTrue(loginPage.passwordField.getValue().isEmpty(), Constants.PASSWORD_FIELD_MESSAGE);

        softAssert.assertAll();
        System.out.println("amit sheikmneba meore konflikti");
        return this;
    }
}

