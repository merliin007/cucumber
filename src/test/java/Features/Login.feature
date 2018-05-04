Feature: LoginFeature
  This feature deals with login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the users email address as Email: admin
    And I enter the following details for Login
      | username | password      |
      | Admin    | AdminPassword |
    And I click login button
    Then I should see the user form page
    Then I navigate to Drag n Drop section
    And I drag and drop element 2 to element 5




