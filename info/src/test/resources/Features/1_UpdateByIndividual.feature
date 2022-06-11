#Author: Sheik.R
@Transaction
@Updatebyindividual
Feature: User clockin details review and update by individual screen
 
	@Login
  Scenario Outline: User clockin details review and update by individual screen
    Given User is on update by individual screen
    When fill the clock in and clock out "<Sheet5>" and <RowNumber>

    Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 
      
  @Recalculate 
  Scenario Outline: User doing Recalculate  Attendance
    Given User is on Recalculate Attendance screen
    When User given the date range and recaulate the attendance for the selected employee "<Sheet5>" and <RowNumber>
    Then User verify the changes in update by individual "<Sheet5>" and <RowNumber>
    
    Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 
  
 @PurgeandReprocess
 Scenario Outline: User changing the employee details and purge and reprocess
    Given User is on basic employee master screen
    When User Change the shift and ot settings "<Sheet5>" and <RowNumber>
   	Then User Verify the change in Update By Individual Screen "<Sheet5>" and <RowNumber>
    Then User navigate to purge and reprocess screen "<Sheet5>" and <RowNumber>
    Then User Verify the change in Update By Individual Screen "<Sheet5>" and <RowNumber>
    
     Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 