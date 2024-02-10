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
@Feature("Тесты мобильного приложения Википедия")
@Tag("remote")
public class AndroidRemoteTests extends TestBase {
    @Test
    @DisplayName("Проверка непустой выдачи при запросе")
    void successfulSearchTest() {
        step("Делаем поисковой запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Porsche");
        });

        step("Проверяем результат запроса", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка отображения значка об ошибке при переходе на статью")
    void checkErrorIconTest() {
        step("Делаем поисковой запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверяем результат запроса", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Нажимаем на первый элемент", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click());

        step("Убеждаемся, что на странице отображается значок ошибки", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_icon")).should(exist);
        });
    }
    @Test
    @DisplayName("Проверка наличия заголовка")
    void checkNewsHeaderTest() {
        step("Проверка наличия заголовка 'In the news' ", () -> {
            $(id("org.wikipedia.alpha:id/view_card_header_title")).shouldHave(text("In the news"));
        });
    }


}



