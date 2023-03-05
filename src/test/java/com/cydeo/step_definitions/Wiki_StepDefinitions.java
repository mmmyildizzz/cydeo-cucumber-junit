package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");

    }
    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {

        wikiSearchPage.searchBox.sendKeys(string);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {

       wikiSearchPage.searchBox.click();

    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {

        //verify actual title contains string (coming from feature file)
        assertEquals(true, Driver.getDriver().getTitle().contains(string));

    }


    @Then("User sees {string} is in the main header")
    public void user_sees_steve_jobs_is_in_the_main_header(String string) {

        assertEquals(true, wikiSearchPage.mainHeader.isDisplayed());

       assertTrue(wikiSearchPage.mainHeader.getText().equals(string));

    }
}