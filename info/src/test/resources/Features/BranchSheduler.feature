#Author: Sheik.R

@BranchScheduler
Feature: Creating Branch Scheduler for future date

  @Login
  Scenario Outline: User creating the branch schedule for future date
    Given User is on branch schedule screen
    When User choosed the branch and future date "<Sheet3>" and <RowNumber>
    Then User create schedule for the branch 
  
	Examples: 
      | Sheet3        			 | RowNumber |
      | Branch Scheduler     | 0         |

