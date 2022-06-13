package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.SelenidePage;

public class TestBase {
    SelenidePage selenidePage = new SelenidePage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "3840x2160";
        // Configuration.holdBrowserOpen = true;
    }
}
