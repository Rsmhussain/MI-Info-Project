#Author: R.Sheik

@AuditLog
Feature: Verify the Audit Log Details

@Login @SendMail
Scenario Outline: User Verifying the update by individual details in Audit Log Screen for Late Scenario
Given User is on Audit Log Page
When User verifying the late scenario "<SheetName>" and <RowNumber>
    
Examples: 
      |SheetName  			|RowNumber |
      |Audit Log  			|0		     |
      
Scenario Outline: User Verifying the update by individual details in Audit Log Screen for Under Scenario
When User verifying the Under scenario "<SheetName>" and <RowNumber> 

Examples: 
      |SheetName  			|RowNumber |
      |Audit Log  			|1		     |
      
Scenario Outline: User Verifying the update by individual details in Audit Log Screen for OT Scenario
When User verifying the OT scenario "<SheetName>" and <RowNumber> 

Examples: 
      |SheetName  			|RowNumber |
      |Audit Log  			|2		     |

Scenario Outline: User Verifying the update by individual details in Audit Log Screen for Absent and Insufficient Scenario
When User verifying the Absent and Insufficient Scenario "<SheetName>" and <RowNumber> 

Examples: 
      |SheetName  			|RowNumber |
      |Audit Log  			|3		     |

#Update By Department
#Scenario Outline: User Verifying the update by department details in Audit Log Screen for Late Scenario
#When User verifying the late scenario for update by department "<SheetName>" and <RowNumber>

#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|4		     |
      
#Scenario Outline: User Verifying the update by department details in Audit Log Screen for under Scenario
#When User verifying the under scenario for update by department "<SheetName>" and <RowNumber>

#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|5		     |
      
#Scenario Outline: User Verifying the update by department details in Audit Log Screen for OT Scenario
#When User verifying the OT scenario for update by department "<SheetName>" and <RowNumber>

#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|6		     |     

#Update By Branch
#Scenario Outline: User Verifying the update by branch details in Audit Log Screen for Late Scenario
#When User verifying the late scenario for update by branch "<SheetName>" and <RowNumber>

#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|7		     |
      
#Scenario Outline: User Verifying the update by branch details in Audit Log Screen for under Scenario
#When User verifying the under scenario for update by branch "<SheetName>" and <RowNumber>
#
#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|8		     |
      
#Scenario Outline: User Verifying the update by branch details in Audit Log Screen for OT Scenario
#When User verifying the OT scenario for update by branch "<SheetName>" and <RowNumber>
#
#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|9		     |
      
#Update By Section
#Scenario Outline: User Verifying the update by section details in Audit Log Screen for update Scenario
#When User verifying the late scenario for update by section "<SheetName>" and <RowNumber>
#
#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|10		     |
      
#Scenario Outline: User Verifying the update by section details in Audit Log Screen for under Scenario
#When User verifying the under scenario for update by section "<SheetName>" and <RowNumber>
#
#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|11		     |
      #
#Scenario Outline: User Verifying the update by section details in Audit Log Screen for OT Scenario
#When User verifying the OT scenario for update by section "<SheetName>" and <RowNumber>
#
#Examples: 
      #|SheetName  			|RowNumber |
      #|Audit Log  			|12		     |      
