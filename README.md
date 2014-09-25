yandex-weather
==============

Simple tests for yandex-weather service with help of Selenium tool.

Cases
-----
# Checking today weather report
# Checking short forecast
# Checking detailed forecast
# Search custom city
# Checking links to other Yandex services

Requirements
------------
Java 7+, Maven 3.+

Execution
---------
To execute tests run the following commands:

    mvn clean test # run the test
    mvn site # generate Allure report

Test report will be located in target/site/allure-maven-plugin/index.html
