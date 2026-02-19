Feature: WordPress Mini Project

  Scenario: Verify WordPress site functionality
    Given user launches WordPress website
    Then verify page title
    When user navigates to Get WordPress page
    Then verify Get WordPress text
    When user navigates to Photo Directory
    And user searches photo "nature"
    Then verify photos are displayed
