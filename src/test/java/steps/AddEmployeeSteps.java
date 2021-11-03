package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashboardPage;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashboardPage dashboardPage = new DashboardPage();
        click(dashboardPage.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashboardPage dashboardPage = new DashboardPage();
        click(dashboardPage.addEmployeeButton);
    }
    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firtName, "Abdul");
        sendText(addEmployeePage.middleName, "Rahmati");
        sendText(addEmployeePage.lastName, "Wahab");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
      AddEmployeePage addEmployeePage = new AddEmployeePage();
      click(addEmployeePage.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }
    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeId.clear();
    }
    @When("user selects checkbox")
    public void user_selects_checkbox() {
       AddEmployeePage addEmployeePage = new AddEmployeePage();
       click(addEmployeePage.createLoginCheckBox);
    }
    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.createUsername, "wahab12323243");
        sendText(addEmployeePage.createPassword, "abdul3245768912");
        sendText(addEmployeePage.createPassword, "abdul3245768912");
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstname, String middlename, String lastname) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firtName, firstname);
        sendText(addEmployeePage.middleName, middlename);
        sendText(addEmployeePage.lastName, lastname);
    }

    @When("user enters {string} {string} and {string} for an employee")
    public void userEntersAndForAnEmployee(String firstname, String middlename, String lastname) {

        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firtName, firstname);
        sendText(addEmployeePage.middleName, middlename);
        sendText(addEmployeePage.lastName, lastname);
    }

    @When("I add multiple employees and verify them that user been added successfully")
    public void i_add_multiple_employees_and_verify_them_that_user_been_added_successfully(DataTable employees) throws InterruptedException {

        List<Map<String, String>> employeeNames = employees.asMaps();
        for(Map<String, String> employeeName: employeeNames){
            String valueOfFirstname =   employeeName.get("firstName");
            String valueOfMiddlename =   employeeName.get("middlename");
            String valueOfLastname =   employeeName.get("lastname");

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firtName, valueOfFirstname);
            sendText(addEmployeePage.middleName, valueOfMiddlename);
            sendText(addEmployeePage.lastName, valueOfLastname);

            click(addEmployeePage.saveBtn);
            DashboardPage dashboardPage = new DashboardPage();
            click(dashboardPage.addEmployeeButton);
            Thread.sleep( 3000);
        }
    }
}
