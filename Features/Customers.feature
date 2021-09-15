Feature: Customers

  Scenario: Add a new Customer

    Given User launch chrome browser
    When User opens URL"http://admin-demo.nopcommerce.com/login"
    And User enters Email as " admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers Menu
    When click on customers Menu Item
    When click on Add new button
    Then User can view Add new customers page
    When User enter customer info
    When click on Save button
    Then User can view confirmation message
    And close browser