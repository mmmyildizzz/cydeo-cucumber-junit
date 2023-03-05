package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cydeo.utilities.Driver.getDriver;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep for given duration (Browser sleep method)
     */

    public static void sleep(int second) {
        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }


    }

    /*
    This method below accept 3 arguments:
    Arg1: WebDriver
    Arg2: expectedInUrl: for verify if the url contains given string
                        if condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
    */
    public static void switchWindowAndVerify( String expectedInUrl, String expectedInTitle){

        Set<String> allWindowsHandles = getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            getDriver().switchTo().window(each);

            System.out.println("Current URL: "+ getDriver().getCurrentUrl());

            if (getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }


        //5. Assert: Title contains “expectedInTitle”
        String actualTitle = getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    /*
    This method accept a string "expectedTitle" and assert if it is true
     */
    public static void verifyTitle( String expectedTitle){
        Assert.assertEquals(getDriver().getTitle(), expectedTitle);

    }


    /**
     * This method will accept a String as expected value and verify with actual URL which contains the value
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * This method will accept a dropdown as a WebElement and return all of the options' text in a List of String
     * @param dropdownElement
     * @return
     */

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);

        //List of all Actual month <option> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all Actual month <option> as a string
        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());

        }
        return actualOptionsAsString;

    }


    /**
     * This method accept a group of radio buttons as a list of WebElement.
     * It will loop through the List,and click to the radio button with provided attributeValue.
     * @param radioButton
     * @param attributeValue
     */

    public static void clickRadioButton(List<WebElement> radioButton, String attributeValue){



        for (WebElement each : radioButton) {

            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }

        }

    }


    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle){
        String origin = getDriver().getWindowHandle();
        for(String handle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(handle);
            if(getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        getDriver().switchTo().window(origin);
    }


    /**
     * Moves the mouse to given element
     * @param element on which to hover
     */
    public static void hover(WebElement element){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }


    /**
     * return a list of string from a list of elements
     * @param list of WebElements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list){
        List<String> elemTexts = new ArrayList<>();
        for(WebElement el : list){
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Extract text from list of elements matching the provided locator into new List<String>
     * @param locator
     * @return list of strings
     */
    public static List<String> getElementsText(By locator){

        List<WebElement> elems = getDriver().findElements(locator);
        List<String> elemsText = new ArrayList<>();

        for(WebElement el : elems){
            elemsText.add(el.getText());
        }
        return elemsText;
    }


    /**
     * performs a pause
     * @param seconds
     */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    /**
     * Waits for the provided element to be visible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     */
     public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
     }


    /**
     * Waits for element matching the locator to be visible on the page
     * @param locator
     * @param timeOut
     * @return
     */
     public static WebElement waitForVisibility(By locator, int timeOut){
         WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
         return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
     }


    /**
     * Waits for provided element to be clickable
     * @param element
     * @param timeOut
     * @return
     */
     public static WebElement waitForClickAbility(WebElement element, int timeOut){
         WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
         return wait.until(ExpectedConditions.elementToBeClickable(element));
     }


    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param timeOut
     * @return
     */
     public static WebElement waitForClickAbility(By locator, int timeOut){
         WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
         return wait.until(ExpectedConditions.elementToBeClickable(locator));
     }




}
