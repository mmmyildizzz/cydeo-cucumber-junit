package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLOutput;

public class Login_StepDefinitions {

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters librarian username");
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("User enters librarian password");
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("User should see the dashboard");
    }

    @When("user enters student username")
    public void user_Enters_Student_Username() {
        System.out.println("User enters student username");
    }

    @And("user enters student password")
    public void user_Enters_Student_Password() {
        System.out.println("User enters student password");
    }

    @When("user enters admin username")
    public void user_Enters_Admin_Username() {
        System.out.println("User enters admin username");
    }

    @And("user enters admin password")
    public void user_Enters_Admin_Password() {
        System.out.println("User enters admin password");
    }

    @Given("user is on the library login page")
    public void user_Is_On_The_Library_Login_Page() {
        System.out.println("User is on lhe library login page");
    }
}
