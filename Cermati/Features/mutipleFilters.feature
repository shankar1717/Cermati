Feature: Product search on eBay

@tag1

  Scenario: Accessing a product via category with multiple filters
    Given User navigates to eBay homepage
    When User selects "Electronics" from the category dropdown
    And User selects Cell Phones & accessories 
    And User clicks on "Cell Phones & Smartphones" in the left-hand side navigation
    And User clicks on All Filters
    And User adds 3 filters: Condition, Price, and Item location
    And User clicks on Apply
    Then User verifies that the filter tags are applied
