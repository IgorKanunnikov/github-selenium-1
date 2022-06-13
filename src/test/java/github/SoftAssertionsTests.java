package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class SoftAssertionsTests extends TestBase {

    @DisplayName("Checking the JUnit5 code example on the SoftAssertions page")
    @Test
    void checkSoftAssert() {
        selenidePage.openPage()
                .wikiCLick()
                .showMore()
                .softAssertionsClick()
                .checkJUnit();
    }

    @Disabled
    @DisplayName("Drag&Drop") // it works
    @Test
    void dragAndDrop() {
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }

    @Disabled
    @DisplayName("Drag&Drop with Selenide.actions") // it doesn't work
    @Test
    void dragAndDropActions() {
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        Selenide.actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300, 200).release().perform();
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
