Feature: User login in to the application

@LoginNew
Scenario Outline: User login in to the application
Given User is on Login Page
When User enter the login user name "<SheetName>" and password <RowNumber>

Examples:
|SheetName   |RowNumber |
|User Login  |0		    	|

