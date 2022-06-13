package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelenidePage {
    SelenideElement wiki = $("#wiki-tab");
    public SelenidePage openPage() {
        Selenide.open("selenide/selenide");
        return this;
    }
    public SelenidePage wikiCLick() {
        wiki.click();
        return this;
    }
    public SelenidePage showMore() {
        $(".Box-row.wiki-more-pages-link").$(byText("Show 2 more pages…")).click();
        return this;
    }
    public SelenidePage softAssertionsClick() {
        $("#wiki-pages-box").$$("a").findBy(text("SoftAssertions")).click();
        return this;
    }
    public void checkJUnit() {
        $("#wiki-body").$$("h4").shouldHave(itemWithText("3. Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text("@ExtendWith"));
    }
}
