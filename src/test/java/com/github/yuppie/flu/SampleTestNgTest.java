package com.github.yuppie.flu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.yuppie.flu.pages.HomePage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

public class SampleTestNgTest extends TestNgTestBase {

    private HomePage homepage;

    @BeforeMethod
    public void initPageObjects() {
        driver.get(baseUrl);
        homepage = new HomePage(driver);
    }

    @Test
    public void testHomePageHasAHeader() {
        homepage.search("кострома");
        WebElement element = driver.findElement(By.className("b-navigation-city"));
        assertThat(element.getText(), startsWith("Погода в Костром"));
    }
}
