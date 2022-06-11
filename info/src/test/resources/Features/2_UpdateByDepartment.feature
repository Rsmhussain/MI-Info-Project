@Transaction
@UpdateByDepartment
Feature: User clockin details review and Update by Department screen

#OT Scenario
@Login
Scenario Outline: Create Missing Date in Update By Individual Screen
    Given User is on Update By Individual
    When User Creating Missing Date "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites
    Given User doing employee prerequisites "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 | 

Scenario Outline: User entering clockin details for OT Scenario in Update By Department screen
    When User Entering the Clockin details for OT scenario in Update By Department screen "<Sheet7>" and <RowNumber>
    Then User Recalculate the attendance Scenario "<Sheet7>" and <RowNumber>
    Then User Verify the OT Scenario changes in Update By Department screen "<Sheet7>" and <RowNumber>
    Then User changing Shift and OT type in employee master "<Sheet7>" and <RowNumber>
    Then After Changing the employee settings User Viewing the changes in Update By Department Screen "<Sheet7>" and <RowNumber>
		Then User Recalculate the attendance Scenario "<Sheet7>" and <RowNumber> 
		Then After Changing the employee settings User Viewing the changes in Update By Department Screen "<Sheet7>" and <RowNumber>
		Then After Changing the employee settings User Viewing the changes in Update By Department Screen "<Sheet7>" and <RowNumber>
		Then User Verify the flat value in Update By Department screen "<Sheet7>" and <RowNumber>
		Then User doing purge and reprocess activity "<Sheet7>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Department Screen "<Sheet7>" and <RowNumber>
		Examples: 
      | Sheet7  					  | RowNumber  |
      | Update By Department| 0 				 | 

#Late Scenario
Scenario Outline: Create Missing Date in Update By Individual Screen
    Given User is on Update By Individual
    When User Creating Missing Date "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites
    Given User doing employee prerequisites "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 | 

Scenario Outline: User entering clockin details for Late Scenario in Update By Department screen
    When User Entering the Clockin details for Late scenario in Update By Department screen "<Sheet7>" and <RowNumber>
    Then User Recalculate the attendance Scenario "<Sheet7>" and <RowNumber>
    Then User Verify the Late Scenario changes in Update By Department screen "<Sheet7>" and <RowNumber>
    #Then User changing Shift and OT type in employee master "<Sheet7>" and <RowNumber>
    #And  After Changing the employee settings User Viewing the changes in Update By Department Screen "<Sheet7>" and <RowNumber>
		#Then User Recalculate the attendance Scenario "<Sheet7>" and <RowNumber> 
		Then User doing purge and reprocess activity "<Sheet7>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Department Screen "<Sheet7>" and <RowNumber>
		Examples: 
      | Sheet7  					  | RowNumber  |
      | Update By Department| 1 				 | 

#Under Scenario      
Scenario Outline: Create Missing Date in Update By Individual Screen
    Given User is on Update By Individual
    When User Creating Missing Date "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites
    Given User doing employee prerequisites "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 | 

Scenario Outline: User entering clockin details for Under Scenario in Update By Department screen
    When User Entering the Clockin details for Under scenario in Update By Department screen "<Sheet7>" and <RowNumber>
    Then User Recalculate the attendance Scenario "<Sheet7>" and <RowNumber>
    Then User Verify the Under Scenario changes in Update By Department screen "<Sheet7>" and <RowNumber>
    #Then User changing Shift and OT type in employee master "<Sheet7>" and <RowNumber>
    #And  After Changing the employee settings User Viewing the changes in Update By Department Screen "<Sheet7>" and <RowNumber>
		#Then User Recalculate the attendance Scenario "<Sheet7>" and <RowNumber> 
		Then User doing purge and reprocess activity "<Sheet7>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Department Screen "<Sheet7>" and <RowNumber>
		Examples: 
      | Sheet7  					  | RowNumber  |
      | Update By Department| 2 				 | 


#Absent and Insufficient Scenario
Scenario Outline: Create Missing Date in Update By Individual Screen
    Given User is on Update By Individual
    When User Creating Missing Date "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites
    Given User doing employee prerequisites "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 |       

Scenario Outline: User entering clockin details for Absent and Insufficient clocking Scenario in Update By Department screen
    When User Entering the Clockin details for Absent and Insufficient scenario in Update By Department screen "<Sheet7>" and <RowNumber>
    Then User Recalculate the attendance Scenario "<Sheet7>" and <RowNumber>
    Then User Verify the Absent and Insufficient Scenario changes in Update By Department screen "<Sheet7>" and <RowNumber>
    #Then User changing Shift and OT type in employee master "<Sheet7>" and <RowNumber>
    #And  After Changing the employee settings User Viewing the changes in Update By Department Screen "<Sheet7>" and <RowNumber>
		#Then User Recalculate the attendance Scenario "<Sheet7>" and <RowNumber> 
		Then User doing purge and reprocess activity "<Sheet7>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Department Screen "<Sheet7>" and <RowNumber>
		Examples: 
      | Sheet7  					  | RowNumber  |
      | Update By Department| 3 				 |       
      