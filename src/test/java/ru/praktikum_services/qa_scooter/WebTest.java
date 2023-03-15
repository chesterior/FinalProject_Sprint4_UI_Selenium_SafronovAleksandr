package ru.praktikum_services.qa_scooter;

import org.junit.Test;
import pages.Constants;
import pages.MainPage;

public class WebTest extends TestBase {

    @Test
    public void DropdownListInSectionImportantQuestions(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickDropDown_checkTextAfterClick(Constants.getTextboxAfterDropdown());
    }
}
