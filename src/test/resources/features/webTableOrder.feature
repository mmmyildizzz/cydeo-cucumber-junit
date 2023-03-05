Feature: Web table user order feature


  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user select product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "Mastercard"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table


  @wip
  Scenario Template: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user select product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipcode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table

    @femaleScientists
    Examples: Famous female scientists
      | productType | quantity | customerName       | street  | city   | state   | zipcode | cardType | cardNumber       | expDate | expectedName       |
      | MoneyCog    | 2        | Marie Curie        | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Marie Curie        |
      | Familybea   | 3        | Rosalind Franklin  | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Rosalind Franklin  |
      | Screenable  | 4        | List Meitner       | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | List Meitner       |
      | MoneyCog    | 5        | Chien-Shiung Wu    | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Chien-Shiung Wu    |
      | MoneyCog    | 6        | Barbara McClintock | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Barbara McClintock |

    @maleScientists
    Examples: Famous male scientists
      | productType | quantity | customerName        | street  | city   | state   | zipcode | cardType | cardNumber       | expDate | expectedName        |
      | MoneyCog    | 2        | Charles Darwin      | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Charles Darwin      |
      | Familybea   | 3        | Albert Einstein     | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Albert Einstein     |
      | Screenable  | 4        | CV Raman            | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | CV Raman            |
      | MoneyCog    | 5        | Galileo             | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Galileo             |
      | MoneyCog    | 6        | Isaac Newton        | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Isaac Newton        |
      | MoneyCog    | 7        | Arnold Shavanegezer | Londont | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Arnold Shavanegezer |