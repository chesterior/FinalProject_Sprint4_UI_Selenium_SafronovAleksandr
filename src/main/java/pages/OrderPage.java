package pages;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Parameterized.class)
public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    // Elements & locators
    private static final By FIELD_NAME = By.cssSelector("[placeholder='* Имя']");
    private static final By FIELD_SURNAME = By.cssSelector("[placeholder='* Фамилия']");
    private static final By FIELD_ADDRESS = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    private static final By FIELD_METRO_BUTTON = By.cssSelector("[placeholder='* Станция метро']");
    private static final By FIELD_METRO = By.cssSelector(".select-search__row");
    private static final By FIELD_PHONE_NUMBER = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    private static final By NEXT_BUTTON_FORM = By.xpath(".//button[text()='Далее']");
    private static final By FIELD_WHEN_TO_BRING = By.cssSelector("[placeholder='* Когда привезти самокат']");
    private static final By FIELD_CHOOSE_DATA = By.cssSelector(".react-datepicker__day--017");
    private static final By FIELD_RENTAL_PERIOD = By.cssSelector(".Dropdown-placeholder");
    private static final By RENTAL_PERIOD_BUTTON = By.xpath(".//div[text()='трое суток']");
    private static final By FIELD_COLOR_SCOOTER = By.xpath(".//label[text()='чёрный жемчуг']");
    private static final By FIELD_COMMENT_FOR_COURIER = By.cssSelector("[placeholder='Комментарий для курьера']");
    private static final By MAKE_ORDER_YES_BUTTON = By.xpath(".//button[text()='Да']");
    private static final By SCOOTER_ORDER_FORM_BUTTON =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private static final By FORM_TEXT_ORDER_IS_PLACED = By.cssSelector(".Order_ModalHeader__3FDaJ");

    protected static final By COOKE_BUTTON = By.xpath(".//button[text()='да все привыкли']");

    // actions
    public OrderPage fillingOutFormForWhomScooter(String firstName, String lastName, String address,
                                                  String phoneNumber, String commentForCourier) {
        driver.findElement(FIELD_NAME).sendKeys(firstName);
        driver.findElement(FIELD_SURNAME).sendKeys(lastName);
        driver.findElement(FIELD_ADDRESS).sendKeys(address);
        driver.findElement(FIELD_METRO_BUTTON).click();
        driver.findElement(FIELD_METRO).click();
        driver.findElement(FIELD_PHONE_NUMBER).sendKeys(phoneNumber);
        driver.findElement(NEXT_BUTTON_FORM).click();
        driver.findElement(FIELD_WHEN_TO_BRING).click();
        driver.findElement(FIELD_CHOOSE_DATA).click();
        driver.findElement(FIELD_RENTAL_PERIOD).click();
        driver.findElement(RENTAL_PERIOD_BUTTON).click();
        driver.findElement(FIELD_COLOR_SCOOTER).click();
        driver.findElement(FIELD_COMMENT_FOR_COURIER).sendKeys(commentForCourier);
        driver.findElement(SCOOTER_ORDER_FORM_BUTTON).click();
        driver.findElement(MAKE_ORDER_YES_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                elementToBeClickable(driver.findElement(FORM_TEXT_ORDER_IS_PLACED)));
        String actualTextOrderIsPlaced = driver.findElement(FORM_TEXT_ORDER_IS_PLACED).getText();
        Assert.assertTrue("Текст на странице не соответствует ожидаемому",
                actualTextOrderIsPlaced.contains(Constants.getExpectedTextOrderIsPlaced()));
        return this;
    }
}
