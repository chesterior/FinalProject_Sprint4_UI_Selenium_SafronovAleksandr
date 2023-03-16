package ru.praktikum_services.qa_scooter;

import org.junit.Test;
import pages.Constants;
import pages.MainPage;
import pages.OrderPage;

public class WebTest extends TestBase {

    public WebTest(String browserName) {
        super(browserName);
    }

    @Test
    public void dropdownListInSectionImportantQuestions(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.checkCookeIsDisplayed();
        mainPage.clickDropDown_checkTextAfterClick(Constants.getTextboxAfterDropdown());
    }

    @Test
    public void scooterOrder(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.checkCookeIsDisplayed();
        mainPage.scooterOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillingOutFormForWhomScooter();

    }
}
