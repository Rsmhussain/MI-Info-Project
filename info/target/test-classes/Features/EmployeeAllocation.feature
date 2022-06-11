#Author: Sheik.R
@EmoployeeAllocation
Feature: Creating Employee Allocation for Branch
  User will mapp the particular branch to the employee in this screen

  @Login
  Scenario Outline: mapping the branch to the employee
    Given User is on employee allocation screen
    When User creating the new employee allocation for the branch "<Sheet2>" and <RowNumber>
    Then User should validate and save the employee allocation record
   
    Examples: 
      | Sheet2        			| RowNumber |
      | Employee Allocation | 0         |


