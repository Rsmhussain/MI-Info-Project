#Author: Sheik.R

@EmployeeScheduler
Feature: Creating Employee Scheduler for future date

  @Login
  Scenario Outline: User creating the employee scheduler for future date
    Given User is on employee scheduler screen
    When User filtered the employee and edited the details "<Sheet4>" and <RowNumber>
    Then User enter the from and to date and create the schedule "<Sheet4>" and <RowNumber>

    Examples: 
      | Sheet4  					 | RowNumber | 
      | Employee Scheduler | 0         |
   
