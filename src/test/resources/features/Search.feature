Feature: Validate search functionality

  Background:
    Given User is on the landing page with URL "https://www.amazon.in/"

  Scenario Outline:: Search for a Product and apply price filter
    When User should be able to search for product "<productName>"
    And  User should be able to apply search filter "<minPrice>" and "<maxPrice>"
    Then check filter is applied
    And close the browser

    Examples:
      | productName | minPrice | maxPrice |
      | phone      | 10000 | 20000       |


  Scenario Outline:: Search for a Product and apply brand filter
    When User should be able to search for product "<productName>"
    And  User should be able to apply search filter "<brand>"
    Then check brand is selected in filter criteria
    And close the browser
    Examples:
      | productName | brand |
       | phone      | OnePlus |

    Scenario: Check Sort Feature in which price is from low to high
      When User should be able to search for product "phone"
      And User should be able to apply sort feature price low to high
      Then User is able to apply sort feature price low to high
