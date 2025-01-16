package ge.tbc.testautomation.saucedemo;


import ge.tbc.testautomation.Util.TestConfig;
import ge.tbc.testautomation.Util.UserDataHelper;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.saucedemo.Steps.InventorySteps;
import ge.tbc.testautomation.saucedemo.Steps.LoginSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.data.Constants.LOCKED_OUT_USER;
import static ge.tbc.testautomation.data.Constants.STANDART_USER;

@Test(groups = {"SauceDemoLogin"})
@Epic("Sauce Demo UI Testing")
@Feature("User Authentication")
public class LoginTests extends TestConfig {

    @BeforeMethod
    public void startUp() {
        open(Constants.SAUCEDEMO_URL);
    }

    LoginSteps loginSteps = new LoginSteps();
    InventorySteps inventorySteps = new InventorySteps();

    @Test
    @Story("User Login")
    @Description("Verify that a standard user can log in successfully.")
    public void successfulLoginTest() {

        String username = STANDART_USER;
        String[] credentials = UserDataHelper.getUserCredentials(username);

        String password = credentials[1];


        loginSteps
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        inventorySteps
                .validateAllImagesAreLoaded();

    }

    @Test
    @Story("User Login with Incorrect credentials")
    @Description("Verify that a banned user cannot log in and sees the appropriate error message.")
    public void bannedUserLoginTest(){

        String username = LOCKED_OUT_USER;
        String[] credentials = UserDataHelper.getUserCredentials(username);
        String password = credentials[1];

        loginSteps
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin()
                .validateErrorMessage()
                .validateErrorIcon();

    }

    @Test
    @Story("User Logout")
    @Description("Verify that a standard user can log out successfully.")
    public void logOutTest(){

        String username = STANDART_USER;
        String[] credentials = UserDataHelper.getUserCredentials(username);

        String password = credentials[1];

        loginSteps
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        inventorySteps
                .clickOnThreeLineButton()
                .logOut();
        loginSteps
                .validateEmptyFields();

    }
}