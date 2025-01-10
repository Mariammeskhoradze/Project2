package ge.tbc.testautomation.swoop.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class CommonPage {
    public SelenideElement
            notFound = $x("//h2");
    public ElementsCollection
            valQuery = $$x("//h4/following-sibling::div");
}
