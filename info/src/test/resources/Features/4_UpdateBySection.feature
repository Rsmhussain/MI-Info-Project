#Author: Sheik.R
@Transaction
@UpdateBySection
Feature: User entering clockin details, Verifing it in Update by Section screen

#OT Scenario
#@Login
Scenario Outline: Create Missing Date in Update By Section Screen
    Given User is on Update By Individual for Section
    When User Creating Missing Date for Section "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites for Section
    Given User doing employee prerequisites and enable schedule for Section "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 | 

Scenario Outline: User entering clockin details for OT Scenario in Update By Section screen
    When User Entering the Clockin details for OT scenario in Update By Section screen "<Sheet9>" and <RowNumber>
    Then User Recalculate the attendance Scenario for Section "<Sheet9>" and <RowNumber>
    Then User Verify the OT Scenario changes in Update By Section screen "<Sheet9>" and <RowNumber>
    Then User changing Shift and OT type and Section in employee master "<Sheet9>" and <RowNumber>
    Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		Then User Recalculate the attendance Scenario for Section "<Sheet9>" and <RowNumber> 
		Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		Then User Verify the Fat value "<Sheet9>" and <RowNumber>
		Then User doing purge and reprocess activity for Section "<Sheet9>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Section Screen "<Sheet9>" and <RowNumber>
		Then Change the employee prerequisite for section "<Sheet9>" and <RowNumber>
		Examples: 
      | Sheet9  				 | RowNumber  |
      | Update By Section| 0 				  | 

#Late Scenario      
Scenario Outline: Create Missing Date in Update By Section Screen
    Given User is on Update By Individual for Section
    When User Creating Missing Date for Section "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites for Section
    Given User doing employee prerequisites and enable schedule for Section "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 | 

Scenario Outline: User entering clockin details for Late Scenario in Update By Section screen
    When User Entering the Clockin details for Late scenario in Update By Section screen "<Sheet9>" and <RowNumber>
    Then User Recalculate the attendance Scenario for Section "<Sheet9>" and <RowNumber>
    Then User Verify the Late Scenario changes in Update By Section screen "<Sheet9>" and <RowNumber>
    #Then User changing Shift and OT type and Section in employee master "<Sheet9>" and <RowNumber>
    #Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		#Then User Recalculate the attendance Scenario for Section "<Sheet9>" and <RowNumber> 
		#Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		#Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		Then User doing purge and reprocess activity for Section "<Sheet9>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Section Screen "<Sheet9>" and <RowNumber>
		Then Change the employee prerequisite for section "<Sheet9>" and <RowNumber>
		Examples: 
      | Sheet9  				 | RowNumber  |
      | Update By Section| 1 				  |       
      
#Under Scenario
Scenario Outline: Create Missing Date in Update By Section Screen
    Given User is on Update By Individual for Section
    When User Creating Missing Date for Section "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites for Section
    Given User doing employee prerequisites and enable schedule for Section "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 | 

Scenario Outline: User entering clockin details for Under Scenario in Update By Section screen
    When User Entering the Clockin details for Under scenario in Update By Section screen "<Sheet9>" and <RowNumber>
    Then User Recalculate the attendance Scenario for Section "<Sheet9>" and <RowNumber>
    Then User Verify the Under Scenario changes in Update By Section screen "<Sheet9>" and <RowNumber>
    #Then User changing Shift and OT type and Section in employee master "<Sheet9>" and <RowNumber>
    #Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		#Then User Recalculate the attendance Scenario for Section "<Sheet9>" and <RowNumber> 
		#Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		#Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		Then User doing purge and reprocess activity for Section "<Sheet9>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Section Screen "<Sheet9>" and <RowNumber>
		Then Change the employee prerequisite for section "<Sheet9>" and <RowNumber>
		Examples: 
      | Sheet9  				 | RowNumber  |
      | Update By Section| 2 				  | 
      
      
#Absent and Insufficient Scenario
Scenario Outline: Create Missing Date in Update By Section Screen
    Given User is on Update By Individual for Section
    When User Creating Missing Date for Section "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites for Section
    Given User doing employee prerequisites and enable schedule for Section "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 | 

Scenario Outline: User entering clockin details for Absent and Insufficient Scenario in Update By Section screen
    When User Entering the Clockin details for Absent and Insufficient scenario in Update By Section screen "<Sheet9>" and <RowNumber>
    Then User Recalculate the attendance Scenario for Section "<Sheet9>" and <RowNumber>
    Then User Verify the Absent and Insufficient Scenario changes in Update By Section screen "<Sheet9>" and <RowNumber>
    #Then User changing Shift and OT type and Section in employee master "<Sheet9>" and <RowNumber>
    #Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		#Then User Recalculate the attendance Scenario for Section "<Sheet9>" and <RowNumber> 
		#Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		#Then After Changing the employee settings User Viewing the changes in Update By Section Screen "<Sheet9>" and <RowNumber>
		Then User doing purge and reprocess activity for Section "<Sheet9>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Section Screen "<Sheet9>" and <RowNumber>
		Then Change the employee prerequisite for section "<Sheet9>" and <RowNumber>
		Examples: 
      | Sheet9  				 | RowNumber  |
      | Update By Section| 3 				  |      
      