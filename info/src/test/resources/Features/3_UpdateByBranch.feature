@Transaction
@UpdateByBranch
Feature: User entering clockin details, Verifing it in Update by Branch screen

#OT Scenario
@Login
Scenario Outline: Create Missing Date in Update By Individual Screen for Update by Branch screen
    Given User is on Update By Individual for Branch
    When User Creating Missing Date for Branch "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites
    Given User doing employee prerequisites and enable schedule "<Sheet6>" and <RowNumber>
	
		Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 |       

Scenario Outline: User entering clockin details for OT Scenario in Update By Department Branch
    When User Entering the Clockin details for OT scenario in Update By Branch screen "<Sheet8>" and <RowNumber>
    Then User Recalculate the attendance Scenario for branch "<Sheet8>" and <RowNumber>
    Then User Verify the OT Scenario changes in Update By Branch screen "<Sheet8>" and <RowNumber>
    Then User changing Shift,OT type and Branch in employee master "<Sheet8>" and <RowNumber>
    Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		Then User Recalculate the attendance Scenario for branch "<Sheet8>" and <RowNumber>
		Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		Then User Verify the Flat value in Update by Branch Screen "<Sheet8>" and <RowNumber>
		Then User doing purge and reprocess activity for Branch Screen "<Sheet8>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Branch Screen "<Sheet8>" and <RowNumber>
		Then Change the employee prerequisite "<Sheet8>" and <RowNumber>
		Examples: 
      | Sheet8  				| RowNumber  |
      | Update By Branch| 0 				 |
      
#Late Scenario
Scenario Outline: Create Missing Date in Update By Individual Screen for Update by Branch screen
    Given User is on Update By Individual for Branch
    When User Creating Missing Date for Branch "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 |

Scenario Outline: User doing employee prerequisites
    Given User doing employee prerequisites and enable schedule "<Sheet6>" and <RowNumber>
	
		Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 |

Scenario Outline: User entering clockin details for Late Scenario in Update By Department Branch
    When User Entering the Clockin details for Late scenario in Update By Branch screen "<Sheet8>" and <RowNumber>
    Then User Recalculate the attendance Scenario for branch "<Sheet8>" and <RowNumber>
    Then User Verify the Late Scenario changes in Update By Branch screen "<Sheet8>" and <RowNumber>
    #Then User changing Shift,OT type and Branch in employee master "<Sheet8>" and <RowNumber>
    #Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		#Then User Recalculate the attendance Scenario for branch "<Sheet8>" and <RowNumber>
    #Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
    #Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		Then User doing purge and reprocess activity for Branch Screen "<Sheet8>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Branch Screen "<Sheet8>" and <RowNumber>
		Then Change the employee prerequisite "<Sheet8>" and <RowNumber>
		Examples: 
      | Sheet8  				| RowNumber  |
      | Update By Branch| 1 				 |    
 
#Under Scenario
Scenario Outline: Create Missing Date in Update By Individual Screen for Update by Branch screen
    Given User is on Update By Individual for Branch
    When User Creating Missing Date for Branch "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites
    Given User doing employee prerequisites and enable schedule "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 |

Scenario Outline: User entering clockin details for Under Scenario in Update By Department Branch
    When User Entering the Clockin details for Under scenario in Update By Branch screen "<Sheet8>" and <RowNumber>
    Then User Recalculate the attendance Scenario for branch "<Sheet8>" and <RowNumber>
    Then User Verify the Under Scenario changes in Update By Branch screen "<Sheet8>" and <RowNumber>
    #Then User changing Shift,OT type and Branch in employee master "<Sheet8>" and <RowNumber>
    #Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		#Then User Recalculate the attendance Scenario for branch "<Sheet8>" and <RowNumber>
		#Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		#Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		Then User doing purge and reprocess activity for Branch Screen "<Sheet8>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Branch Screen "<Sheet8>" and <RowNumber>
		Then Change the employee prerequisite "<Sheet8>" and <RowNumber>
		Examples: 
      | Sheet8  				| RowNumber  |
      | Update By Branch| 2 				 | 

#Absent and Insufficient Scenario
Scenario Outline: Create Missing Date in Update By Individual Screen for Update by Branch screen
    Given User is on Update By Individual for Branch
    When User Creating Missing Date for Branch "<Sheet5>" and <RowNumber>

		Examples: 
      | Sheet5  					  | RowNumber  |
      | Update By Individual| 0 				 | 

Scenario Outline: User doing employee prerequisites
    Given User doing employee prerequisites and enable schedule "<Sheet6>" and <RowNumber>
	
	Examples: 
      | Sheet6  					  	| RowNumber  |
      | Employee Prerequisites| 0 				 |
      
Scenario Outline: User entering clockin details for Absent and Insufficient Scenario in Update By Department Branch
    When User Entering the Clockin details for Absent and Insufficient scenario in Update By Branch screen "<Sheet8>" and <RowNumber>
    Then User Recalculate the attendance Scenario for branch "<Sheet8>" and <RowNumber>
    Then User Verify the Absent and Insufficient Scenario changes in Update By Branch screen "<Sheet8>" and <RowNumber>
    #Then User changing Shift,OT type and Branch in employee master "<Sheet8>" and <RowNumber>
    #Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		#Then User Recalculate the attendance Scenario for branch "<Sheet8>" and <RowNumber>
		#Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		#Then After Changing the employee settings User Viewing the changes in Update By Branch Screen "<Sheet8>" and <RowNumber>
		Then User doing purge and reprocess activity for Branch Screen "<Sheet8>" and <RowNumber>
		Then Post purge and reprocess User viewing the changes in update By Branch Screen "<Sheet8>" and <RowNumber>
		Then Change the employee prerequisite "<Sheet8>" and <RowNumber>
		Examples: 
      | Sheet8  				| RowNumber  |
      | Update By Branch| 3 				 | 
      
