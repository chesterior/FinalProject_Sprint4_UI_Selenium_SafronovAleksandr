package ru.praktikum_services.qa_scooter;

import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;

public class ScooterOrderFormTest extends TestBase {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String commentForCourier;

    public ScooterOrderFormTest(String browserName, String firstName, String lastName, String address,
                                String phoneNumber, String commentForCourier) {
        super(browserName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.commentForCourier = commentForCourier;
    }

    @Parameterized.Parameters
    public static Object[][] getDataForForm() {
        return new Object[][]{
                {"chrome", "Иван", "Иванов", "улица Безнадёги дом 23 кв 13", "+7921112233", "Позвонить по приезде"},
                {"chrome", "Акакий", "Семёнов", "улица Работы дом 13 кв 21", "+78234356811", "Не работает домофон"},
                {"firefox", "Иван", "Иванов", "улица Безнадёги дом 23 кв 13", "+7921112233", "Позвонить по приезде"},
                {"firefox", "Акакий", "Семёнов", "улица Работы дом 13 кв 21", "+78234356811", "Не работает домофон"},
        };
    }

    @Test
    @Description("Заказ самоката, кнопка «Заказать» вверху страницы.")
    public void scooterOrderFirstButtonOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.checkCookeIsDisplayed();
        mainPage.scooterOrderFirstButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillingOutFormForWhomScooter(firstName, lastName, address,
                phoneNumber, commentForCourier);
    }

    @Test
    @Description("Заказ самоката, кнопка «Заказать» внизу страницы.")
    public void scooterOrderSecondButtonOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.checkCookeIsDisplayed();
        mainPage.scooterOrderSecondButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillingOutFormForWhomScooter(firstName, lastName, address,
                phoneNumber, commentForCourier);
    }
}
