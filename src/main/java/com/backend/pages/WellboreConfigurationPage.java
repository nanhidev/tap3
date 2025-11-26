
package com.backend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.default_project.utils.ElementUtils;
import org.junit.Assert;

public class WellboreConfigurationPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    public WellboreConfigurationPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "wellboreConfigTab")
    private WebElement wellboreConfigTab;

    @FindBy(id = "drilledHoleTab")
    private WebElement drilledHoleTab;

    @FindBy(id = "topMDField")
    private WebElement topMDField;

    @FindBy(id = "bottomMDField")
    private WebElement bottomMDField;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    @FindBy(id = "refreshButton")
    private WebElement refreshButton;

    @FindBy(id = "casingTab")
    private WebElement casingTab;

    @FindBy(id = "lengthField")
    private WebElement lengthField;

    @FindBy(id = "casingField")
    private WebElement casingField;

    @FindBy(id = "gradeField")
    private WebElement gradeField;

    @FindBy(id = "addRowButton")
    private WebElement addRowButton;

    @FindBy(id = "inputField")
    private WebElement inputField;

    @FindBy(id = "otherField")
    private WebElement otherField;

    // Navigate to Wellbore Configuration Tab
    public void navigateToWellboreConfigurationTab() {
        try {
            elementUtils.clickElement(wellboreConfigTab);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Select Drilled Hole Tab
    public void selectDrilledHoleTab() {
        try {
            elementUtils.clickElement(drilledHoleTab);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Enter Top MD
    public void enterTopMD(String top_md) {
        try {
            elementUtils.clearAndSendKeys(topMDField, top_md);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Enter Bottom MD
    public void enterBottomMD(String bottom_md) {
        try {
            elementUtils.clearAndSendKeys(bottomMDField, bottom_md);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Save Configuration
    public void saveConfiguration() {
        try {
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Refresh Page
    public void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Select Casing Tab
    public void selectCasingTab() {
        try {
            elementUtils.clickElement(casingTab);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Enter Length
    public void enterLength(String length) {
        try {
            elementUtils.clearAndSendKeys(lengthField, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Enter Casing
    public void enterCasing(String casing) {
        try {
            elementUtils.clearAndSendKeys(casingField, casing);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Enter Grade
    public void enterGrade(String grade) {
        try {
            elementUtils.clearAndSendKeys(gradeField, grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Validate data display status
    public void isDataDisplayedCorrectly() {
        try {
            String actualData = elementUtils.getElementText(topMDField);
            String expectedData = "Expected Data"; // Replace with actual expected data logic
            Assert.assertEquals(actualData, expectedData, "Data does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Validate data retention
    public void isDataRetainedCorrectly() {
        try {
            String actualData = elementUtils.getElementText(casingField);
            String expectedData = "Expected Casing Data"; // Replace with actual expected data logic
            Assert.assertEquals(actualData, expectedData, "Casing data does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Rows with Valid Data
    public void addRowsWithValidData(int rowCount) {
        try {
            for (int i = 0; i < rowCount; i++) {
                elementUtils.clickElement(addRowButton);
                elementUtils.clearAndSendKeys(inputField, "Valid Data " + (i + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Observe Other Fields State
    public void observeOtherFieldsState() {
        try {
            boolean isDisplayed = elementUtils.isElementDisplayed(otherField);
            Assert.assertTrue(isDisplayed, "Other field is not displayed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Check if Other Fields are Enabled
    public void areOtherFieldsEnabled() {
        try {
            boolean isEnabled = otherField.isEnabled();
            Assert.assertTrue(isEnabled, "Other field is not enabled!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Additional Rows Until Limit
    public void addAdditionalRowsUntilLimit() {
        try {
            int limit = 5; // Assuming there is a limit defined
            for (int i = 0; i < limit; i++) {
                elementUtils.clickElement(addRowButton);
                elementUtils.clearAndSendKeys(inputField, "Additional Row Data " + (i + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}