yandex-weather
==============

Simple tests for yandex-weather service with help of Selenium tool. Only Mozilla Firefox supported by now.

Cases
-----
- [x] Checking today weather report
- [x] Checking brief forecast
- [x] Checking detailed forecast
- [x] Search custom city
- [x] Checking links to other Yandex services

Requirements
------------
Java 7+, Maven 3.+, Mozilla Firefox 31+

Execution
---------
To execute tests run the following commands:

    mvn clean test # run the test
    mvn site # generate Allure report

Test report will be located in target/site/allure-maven-plugin/index.html
