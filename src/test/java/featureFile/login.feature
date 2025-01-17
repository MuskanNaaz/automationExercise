#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login with valid credentials
  I want to use this template for my feature file

  Scenario Outline: Login to the Automation Exercise
    Given I landed on Login page
    When Logged in the username "<userId>" and pasword "<password>"
    And clicks the login button
    Then the user should landed on the Features Items page and see feature Page "<message>"

    Examples: 
      | userId         | password  | message           |
      | rozi@gmail.com | rozi@1234 | Logged in as Rozi |

  @tag1
  Scenario Outline: Login to the Automation Exercise with invalid credentials
    Given I landed on Login page
    When Logged in the username "<userId>" and pasword "<password>"
    And clicks the login button
    Then Error "<message>" is displayed

    Examples: 
      | userId         | password | message                              |
      | rozi@gmail.com |  1234567 | Your email or password is incorrect! |

  @tag2
  Scenario Outline: New User signUp with Name and Email
    Given I landed on Login page
    When Enter user  "<name>" and email "<email>"
    And clicks the signUp button
    Then The user should enter in SignUp page "<message>" is displayed

    Examples: 
      | name | email       | message                   |
      | Sam  | ropee@gmail.com | Enter Account Information |
