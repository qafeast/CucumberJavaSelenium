package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.BankManagerPage;

import static StepDefs.Hooks.driver;

public class BankManagerStepDef {
    BankManagerPage bankManagerPage=new BankManagerPage(driver);
    @Given("Login to bank manager account")
    public void loginToBankmanagerAccount() {
        bankManagerPage.clickBankManagerLogInButton();

    }

    @Then("navigate to add customer section")
    public void navigateToAddCustomerSection() {
        bankManagerPage.clickAddCustomerTab();
    }

    @Then("enter firstname as {string} lastname as {string} and postal code as {string}")
    public void enterFirstnameAsUILastnameAsTesterAndPostalCodeAs(String firstName,String lastName,String postalCode) {
        bankManagerPage.enterFirstName(firstName);
        bankManagerPage.enterLastName(lastName);
        bankManagerPage.enterPostalCode(postalCode);
    }

    @When("click add customer button")
    public void clickAddCustomerButton() {
        bankManagerPage.clickAddCustomerButton();
        bankManagerPage.clickOkButtonFromAlertPopup();
    }


    @Then("customer {string} {string} should be added to the customer list")
    public void customerShouldBeAddedToTheCustomerList(String firstName, String lastName) {
        bankManagerPage.clickCustomersSection();
        bankManagerPage.verifyCustomerAddedInCustomerTable(firstName, lastName);
    }

}
