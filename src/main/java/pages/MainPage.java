package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static pages.OrderPage.COOKE_BUTTON;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements & locators

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By DROP_DOWN_ELEMENT_BUTTON =
            By.xpath(".//div[@data-accordion-component='AccordionItem']");
    private static final By DROP_DOWN_ELEMENT_TEXT_AFTER_OPEN =
            By.xpath(".//div[@data-accordion-component='AccordionItemPanel']");
    private static final By SCOOTER_ORDER_BUTTON =
            By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    // actions
    public MainPage open() {
        driver.get(PAGE_URL);
        return this;
    }


    public MainPage clickDropDown_checkTextAfterClick(String[] expectedTextboxAfterDropdown) {
        List<WebElement> webElements =
                driver.findElements(DROP_DOWN_ELEMENT_BUTTON);
        for (int i = 0; i < webElements.size(); i++) {
            WebElement button = webElements.get(i);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
            button.click();
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                    elementToBeClickable(button.findElement(DROP_DOWN_ELEMENT_TEXT_AFTER_OPEN)));
            String actualTextboxAfterDropdown = button.findElement(DROP_DOWN_ELEMENT_TEXT_AFTER_OPEN).getText();
            Assert.assertEquals(expectedTextboxAfterDropdown[i], actualTextboxAfterDropdown);
        }
        return this;
    }

    public MainPage scooterOrderButton(){
        driver.findElement(SCOOTER_ORDER_BUTTON).click();
        return this;
    }

    public MainPage checkCookeIsDisplayed(){
        if (driver.findElement(COOKE_BUTTON).isDisplayed()){
            driver.findElement(COOKE_BUTTON).click();
        }
        return this;
    }

}
