package test;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("Aleksandr Drozenko")
@Feature("Тесты мобильного приложения Википедия")
@DisplayName("Мобильные тесты Википедия на локальном эмуляторе")
@Tag("local")
public class AndroidLocalTest extends TestBase {

    @Test
    @DisplayName("Проверка онбординг-страниц ")
    void onBoardingPagesTest() {
        step("Первая страница", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Вторая страница", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Третья страница", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Четвертая страница", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
            $(AppiumBy.id("org.wikipedia.alpha:id/acceptButton")).click();
        });
    }

    @Test
    @DisplayName("Добавления нового языка")
    void addLanguageTest() {
        step("Закрываем экран настроек", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_action_negative")).click();
        });
        step("Переходим в языковое меню", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
            $$(AppiumBy.id("android:id/title")).findBy(text("Wikipedia languages")).click();
        });
        step("Добавляем русский язык", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title"))
                    .findBy(text("ADD LANGUAGE")).click();
            $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name"))
                    .findBy(text("Русский")).click();
        });
        step("Проверяем что русский язык добавлен ", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title"))
                        .filterBy(text("Russian")).shouldHave(size(1)));
    }

    @Test
    @DisplayName("Проверка поиска")
    void searchPageTest() {
        step("Закрываем экран настроек", () -> back());

        step("Переходим в меню поиска", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
            $$(AppiumBy.id("android:id/title")).findBy(text("Explore Feed")).click();
        });
        step("Проверяем, что результатов страницы поиска больше 1", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/feed_content_type_title"))
                        .shouldHave(sizeGreaterThan(1)));
    }

    @Test
    @DisplayName("Проверка иконки титульной страницы")
    void iconTitleTest() {
        step("Закрываем экран настроек", () -> back());

        step("Создаем поисковой запрос Porsche", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Porsche");
        });
        step("Открываем первый заголовок из поиска ", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("Проверяем наличия иконки на странице", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_page_header_image")).should(exist);
        });
    }
}


