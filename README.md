<h1 >Проект по автоматизации тестирования мобильного приложения <a href="https://github.com/wikimedia/apps-android-wikipedia/">Wikipedia</a></h1>
<p align="center">  
<img src="media/logo/WikiLogo.png" alt="MainLogo" width="950"/></a>  
</p>





## :scroll: Содержание:

- <a href="#tools">Технологии и инструменты</a>
- <a href="#checking">Список проверок, реализованных в автоматизированных тест-кейсах</a>
- <a href="#console">Запуск тестов (Из терминала)</a>

[//]: # (- <a href="#jenkins">Сборка в Jenkins</a>)

[//]: # (- <a href="#allureReport">Allure-отчет</a>)

[//]: # (- <a href="#allure">Интеграция с Allure TestOps</a>)

[//]: # (- <a href="#jira">Интеграция с Jira</a>)

[//]: # (- <a href="#tg"> Уведомление в Telegram о результатах выполнения автоматизированных тестов</a>)

[//]: # (- <a href="#movie">Видеопример прохождения тестов Browserstack</a>)

____
<a id="tools"></a>

## 🔨 Технологии и инструменты:
<p align="center">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java.svg"></a>
<a href="https://appium.io/docs/en/2.4/"><img width="6%" title="Appium" src="media/logo/Appium.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logo/Allure.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logo/Allure_TO.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/Junit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg"></a>
<a href="https://web.telegram.org/a/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="media/logo/Jira.svg"></a>
<a href="https://www.browserstack.com/"><img width="6%" title="BrowserStack" src="media/logo/Browserstack.svg"></a>
</p>

## 🏁 Реализованные проверки:

### При запуске локально (local) на эмуляторе:

- ✓ *Проверка 4 стартовых страниц wiki*
- ✓ *Проверка добавления языка*
- ✓ *Проверка поиска конкретной статьи*
- ✓ *Проверка отображения иконки страници при поисковом запросе*



### При запуске удаленно (remote) на Browserstack:

- ✓ *Проверка появления результатов поиска при выдаче*
- ✓ *Проверка отображения значка ошибки при переходе на статью*
- ✓ *Проверка наличия заголовка*



## 🚀 Команда для запуска автотестов из терминала

Запуск локально (local) на эмуляторе:
```bash 
gradle clean local_test -DdeviceHost=local
```
> Для запуска локальных тестов на компьютере должны быть установлены Android Studio, Appium Server и Appium

Запуск удаленно (remote) на Browserstack:
```bash 
gradle clean remote_test -DdeviceHost=remote
```
