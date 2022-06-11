#Author: Sheik.R
@IndividalAttendanceReport
Feature: Verify the Individual Attendance Report

@Login
@IndividualOption_IAR
Scenario Outline: User Verify the Normal OT type and check with all options available for individual of the individual attendance report
    Given User is on Individual Attendance Report 
    When User enter the date range, Normal OT type and select all filter by option "<IARSheet>" and <RowNumber> 
    And User select the sort by drop down based on employee code and ascending "<IARSheet>" and <RowNumber>
    Then User click the Preview button and Export button
	
	Examples:
		|IARSheet   								  |RowNumber   |
		|Individual Attendance Report |0           |
 
Scenario Outline: User Verify the Weekly OT type and with specific options available for individual of the individual attendance report
		When User enter the date range, Weekly OT type and default filter option "<IARSheet>" and <RowNumber> 
   	And User select the sort by drop down based on employee code and ascending "<IARSheet>" and <RowNumber>
    Then User click the Preview button and Export button
    
  Examples:
		|IARSheet   								  |RowNumber   |
		|Individual Attendance Report |0           |
		
Scenario Outline: User Verify the Normal OT type and with specific options available for department of the individual attendance report
	  When User enter the date range, Normal OT type and default filter option "<IARSheet>" and <RowNumber>
	  And User Select the sort by drop down based on employee name and descending "<IARSheet>" and <RowNumber>
	  Then User click the Preview button and Export button
	  
	Examples:
		|IARSheet   								  |RowNumber   |
		|Individual Attendance Report |0           |

Scenario Outline: User Verify the Normal OT type and with all options available for Section of the individual attendance report
	  When User enter the date range, Normal OT type and all filter option "<IARSheet>" and <RowNumber>
	  And User Select the sort by drop down based on employee code and descending "<IARSheet>" and <RowNumber>
	  Then User click the Preview button and Export button
	  
	Examples:
		|IARSheet   								  |RowNumber   |
		|Individual Attendance Report |0           | 
		
Scenario Outline: User Verify the Normal OT type and with specific options available for designation of the individual attendance report
	  When User enter the date range, Normal OT type and default filter option for designation "<IARSheet>" and <RowNumber>
	  And User Select the sort by drop down based on employee name and ascending for designation "<IARSheet>" and <RowNumber>
	  Then User click the Preview button and Export button
	  
	Examples:
		|IARSheet   								  |RowNumber   |
		|Individual Attendance Report |0           |
		
Scenario Outline: User Verify the Normal OT type and with specific options available for category of the individual attendance report
	  When User enter the date range, Normal OT type and default filter option for category "<IARSheet>" and <RowNumber>
	  And User Select the sort by drop down based on employee name and ascending for category "<IARSheet>" and <RowNumber>
	  Then User click the Preview button and Export button
	  
	Examples:
		|IARSheet   								  |RowNumber   |
		|Individual Attendance Report |0           |		
		
Scenario Outline: User Verify the Normal OT type and with specific options available for extra classification of the individual attendance report
	  When User enter the date range, Normal OT type and default filter option for extra classification "<IARSheet>" and <RowNumber>
	  And User Select the sort by drop down based on employee name and ascending for extra classification "<IARSheet>" and <RowNumber>
	  Then User click the Preview button and Export button
	  
	Examples:
		|IARSheet   								  |RowNumber   |
		|Individual Attendance Report |0           |	
