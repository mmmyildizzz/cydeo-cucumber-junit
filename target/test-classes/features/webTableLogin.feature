Feature: user should be able to login using correct credentials

  Background: user is on the login page
    Given user is on the login page of the web table app

  Scenario: Positive login scenario
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains orders


  Scenario: Positive login scenario
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains orders

    #1 implement this new step
    #2 create login method in WebTableLoginPage
    # this login method should have multiple different overloaded version


  Scenario: User should be able to see all 12 months in months dropdown
    When User enters below credentials
      | username     | Test   |
      | password     | Tester |
    Then user should see url contains orders

