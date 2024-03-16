Feature: Access a Product via Search
@tag1
  Scenario: Access a Product via Search
    Given User is on the eBay homepage
    When User types "MacBook" in the search bar
    And User changes the search category and clicks Search
    Then User verifies that the page loads completely
    And User verifies that the first result name matches with the search string
