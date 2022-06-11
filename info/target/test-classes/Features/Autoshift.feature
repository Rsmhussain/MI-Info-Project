@AutoShift
Feature: Creating Autoshift Details

@Login
Scenario: Open the Autoshuft Page
Then User Login to the application
And User Navigate to Autoshift Page

Scenario Outline: Autoshift Creation
When User enter the autoshift details "<SheetName>" and <RowNumber>
    
    
Examples: 
      |SheetName     	  |RowNumber |
      |Auto Shift Data  |0		     |
      #|Auto Shift Data	|1		     |