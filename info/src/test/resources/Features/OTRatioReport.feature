#Author: Sheik.R

@OTRatioReport
Feature: Verify the OT Ratio Report

  @Individual_OTRR @Login
  Scenario Outline: User Verify the Individual OT Ratio Report for all employees
    Given User is on OT Ratio Report 
    When User enter the date range and select all employee "<OTRRSheet>" and <RowNumber> 
    Then User click the show button

    Examples: 
      |OTRRSheet        |RowNumber | 
      |OT Ratio Report  |0         |
 
  @Department_OTRR
  Scenario Outline: User Verify the Individual OT Ratio Report for Department
    When User enter the date range and select the particular department "<OTRRSheet>" and <RowNumber> 
    Then User click the show button

    Examples: 
      |OTRRSheet        |RowNumber | 
      |OT Ratio Report  |0         |
      
  @Section_OTRR
  Scenario Outline: User Verify the Individual OT Ratio Report for Section
    When User enter the date range and select the particular section "<OTRRSheet>" and <RowNumber> 
    Then User click the show button

    Examples: 
      |OTRRSheet        |RowNumber | 
      |OT Ratio Report  |0         |

  @Designation_OTRR
  Scenario Outline: User Verify the Individual OT Ratio Report for Designation
    When User enter the date range and select all designation "<OTRRSheet>" and <RowNumber> 
    Then User click the show button

    Examples: 
      |OTRRSheet        |RowNumber | 
      |OT Ratio Report  |0         |
 