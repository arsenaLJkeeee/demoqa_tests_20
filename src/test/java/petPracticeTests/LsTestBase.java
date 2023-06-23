package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class LsTestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://ft-mobbetru-crm-pay-01-k8s.app-ses.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "edge";
    }
}
