#Author: Sheik.R

@SavedCustomReports
Feature: Verify the saved custom report
  
  Scenario Outline: Verify the saved custom report for Master Report
    Given User is on saved custom report page
    When User click the edit button
    Then User update the select period details for Master Report "<SCRSheet>" and <RowNumber>
		And User update the select report column details for Master Report "<SCRSheet>" and <RowNumber>
		And User update the Add filter details for Master Report "<SCRSheet>" and <RowNumber>
		Then User Generate the report "<SCRSheet>" and <RowNumber>
		
    Examples: 
      |SCRSheet           |RowNumber   |
      |SavedCustomReport  |0					 |
      
