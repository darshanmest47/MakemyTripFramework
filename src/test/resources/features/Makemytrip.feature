Feature: Make My trip feature

  @Regression @Author_Darshan
  Scenario Outline: Opening Make My Trip and Booking Flight
    Given I am already on make my trip website
    When I click on dismiss icon for login
    Then login window should get closed
    And I click on dismiss icon for AI Chat bot
    Then AI chat bot should get closed
    And I print <testdata>

    Examples:
      | testdata | testdata1 |
    | "Darshan" | "Darshan Mesta"|