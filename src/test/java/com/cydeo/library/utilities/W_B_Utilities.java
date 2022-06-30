package com.cydeo.library.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class W_B_Utilities {


    //sleep method is missing here
    public static void switchWindowAndVerify(String partOfexpectedURL,
                                             String expectedInTitle) {


        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String eachWindowsHandle : allWindowsHandles) {

            Driver.getDriver().switchTo().window(eachWindowsHandle);

            System.out.println("current window URL = " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(partOfexpectedURL)) {
                break;
            }

        }
//5. Assert: Title contains “Etsy”
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));

    }

//method that returns a boolean 'true' if actual title equals expected title.

    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);


    }


    public static void getMaximizeAndWait(WebDriver driver, String URL) {
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static void staticWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {

        }
    }

    /**
     * method verifies present url contains expected word given as string
     *
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * this method accepts drop down element :
     *
     * @param dropdownElement
     * @return list of strings (dropdown options that can be compared with expected list from
     * feature file
     */

    public static List<String> dropdownOptionsAsStrings(WebElement dropdownElement) {

        Select select = new Select(dropdownElement);
        List<WebElement> DropdownOptionsAsWebElements = select.getOptions();
        List<String> ActualDropdownOptionsAsStrings = new ArrayList<>();

        for (WebElement eachWebElement : DropdownOptionsAsWebElements) {
            ActualDropdownOptionsAsStrings.add(eachWebElement.getText());
        }
        return ActualDropdownOptionsAsStrings;
    }

    /**
     * this method accepts a group of radio buttons as a list of webElements and
     * loops through all the elements to find the one
     * matching the one provided as 'attributeValue'
     *
     * @param radioButtons
     * @param attributeValue
     */

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        for (WebElement eachRadioButton : radioButtons) {
            if (eachRadioButton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                eachRadioButton.click();
            }

        }

    }
}