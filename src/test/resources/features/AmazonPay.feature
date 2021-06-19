Feature: Validate AmazonPay functionality

  Background:
    Given User is on the landing page with URL "https://www.amazon.in/"


  Scenario: check Amazon Pay exists
    When User should be able to click on AmazonPay
    Then Page should display with title "Amazon pay"
    And close the browser

  Scenario:: check amazon pay functionality - click on flights
    When  User should be able to click on AmazonPay
    And click on flights
    Then should ask for login
    And close the browser