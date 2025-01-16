package ge.tbc.testautomation.Listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        failureScreenshot();
    }
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] failureScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

