Feature: Mortgage Calculator

  @CalculateApr
  Scenario: Calculate Real Apr rate
    Given user is in the mortgage calculator homepage
    And user navigate to Real Apr page
    When user clicks on calculate button upon entering data
    |HomePrice|DownPayment|InterestRate|
    |200000   |15000      |3           |
    Then the real apr rate is "3.139%"