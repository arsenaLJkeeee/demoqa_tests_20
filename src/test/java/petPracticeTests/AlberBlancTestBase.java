package petPracticeTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class AlberBlancTestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://alberblanc.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "edge";
    }
}
