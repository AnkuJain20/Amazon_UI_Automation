Feature: Validate AddToCart functionality

  Background:
    Given User is on the landing page with URL "https://www.amazon.in/"


  Scenario:: Search for a Product and add to cart
    When User should be able to search for product "Samsung Galaxy M12 (Black,6GB RAM, 128GB Storage) 6000 mAh with 8nm Processor | True 48 MP Quad Camera | 90Hz Refresh Rate"
    And  click on cart
    Then product should be in cart
    And close the browser