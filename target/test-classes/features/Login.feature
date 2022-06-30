Feature: Library app login feature
  User Story: As a user, I should be able to login with correct credentials
  to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page

    @librarian @employee
      Scenario: Login as librarian
      When user enters librarian username
      And user enters librarian password
      Then user should see the dashboard