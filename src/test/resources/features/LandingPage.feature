Feature: Validate landing page

Background:
  Given User is on the landing page with URL "https://www.amazon.in/"


  Scenario: Open Amazon home page
    Then Home Page should display with title "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"



  Scenario Outline:: Search for a Product
    When User should be able to search for product "<productName>"
    Then Product page should be displayed with title "<pageTitle>"

    Examples:
      | productName | pageTitle |
      | iphone      | Amazon.in : iphone |
      | handbag      | Amazon.in : handbag |

#  Scenario: change language
#    When User should be able to click on language change icon
#    And User should be able to select hindi
#    Then User should see hindi info
#    And close the browser

  Scenario: select address
    When User should be able to click on select address
    And user should be able to enter pincode "560103"
    And user should able to click on apply
    Then user should see the updated address


#  Scenario: check Search bar exists
#    When User should be able to select search bar
#    Then Page should display with title "Amazon pay"
#    And close the browser

