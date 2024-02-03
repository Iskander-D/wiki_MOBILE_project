package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
@Owner("Aleksandr Drozenko")
@Feature("Wikipedia BrowserStack Tests")
@Tag("remote")
public class AndroidRemoteTests extends TestBase {
    @Test
    @DisplayName("Checking for non-empty output when requesting")
    void successfulSearchTest() {
        step("Search query", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Porsche");
        });

        step("Checking output result", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Checking the display of an error icon when going to an article")
    void checkErrorIconTest() {
        step("Search query", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Checking output result", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Click on first element", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click());

        step("Check that the page displays to have an error icon", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_icon")).should(exist);
        });
    }
    @Test
    @DisplayName("Checking for header presence")
    void checkNewsHeaderTest() {
        step("Checking for header presence 'In the news' ", () -> {
            $(id("org.wikipedia.alpha:id/view_card_header_title")).shouldHave(text("In the news"));
        });
    }


}



