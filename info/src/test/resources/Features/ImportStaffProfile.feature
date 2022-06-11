#Author: Sheik.R

@ImportStaffProfile
Feature: User Importing the bulk staff profile details in excel

  @Login
  Scenario: User Importing the bulk staff profile details in excel
    Given User is on import staff profile page
    When Importing the excel file in to the system

