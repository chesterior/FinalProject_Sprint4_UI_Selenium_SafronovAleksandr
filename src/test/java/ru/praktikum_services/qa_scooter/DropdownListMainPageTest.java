package ru.praktikum_services.qa_scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Constants;
import pages.MainPage;

@RunWith(Parameterized.class)
public class DropdownListMainPageTest extends TestBase {

    public DropdownListMainPageTest(String browserName) {
        super(browserName);
    }

    @Test
    public void dropdownListInSectionImportantQuestions() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.checkCookeIsDisplayed();
        mainPage.clickDropDown_checkTextAfterClick(Constants.getTextboxAfterDropdown());
    }
}
