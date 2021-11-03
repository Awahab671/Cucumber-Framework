Feature: Add Employee
  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @1027
  Scenario: first scenario of adding the employee
    When user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @1028
  Scenario: adding an employee from feature file
    When user enters "Abdul222" "Wahab222" and "Rahmati222"
    And user clicks on save button
    Then employee added successfully

    @1027
  Scenario: second scenario of adding the employee
    And user enters firstname middlename and lastname
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully

    @1027
  Scenario: third scenario of adding employee
    And user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirmpassword
    And user clicks on save button
    Then employee added successfully

  @examples
  Scenario Outline: adding an employee from feature file
    When user enters "<firstname>" "<middlename>" and "<lastname>" for an employee
    And user clicks on save button
    Then employee added successfully
    Examples:
    |firstname|middlename|lastname|
    |Abdul3543    |Wahab233|Rahmati342|
    |Masoud34908  |generoud890|Popal  |
    |Fawad        |Jawan453   |Rahmati9874|

    @datatable
    Scenario: adding an employee using data table
      When I add multiple employees and verify them that user been added successfully
        |firstname|middlename|lastname|
        |Waheed232    |jare234|kabir42|
        |asoud349408  |gnerou4d890|Popal4  |
        |awad4       |Jaw4453   |Rahmi98744|
        |soud349085446  |generd8904564|pal4564  |
        |wad4564        |awan45344565  |ahmati94657874|

