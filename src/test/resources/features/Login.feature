Feature: Validate Login Page

  Background:
    Given User is on the landing page with URL "https://www.amazon.in/"

# driver object ->
  Scenario Outline: Check login functionality
    When send the username with "<Username>"
    Then  user unable to login with error "There was a problem"


    Examples:
      |Username      | password |
      |abc | 1234     |

  Scenario Outline: Check login functionality with correct username
    When send the username with "<Username>"
    Then  user should able to enter password "<password>"

    Examples:
      |Username      | password |
      |abc@gmail.com | 1234     |

