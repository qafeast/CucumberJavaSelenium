package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebBasePage;

import static java.lang.String.format;

public class BankManagerPage extends WebBasePage {
    WebDriver driver;

    public BankManagerPage(WebDriver driver) {
        super(driver);
    }

    public void clickBankManagerLogInButton() {
        click(By.cssSelector("button[ng-click*='manager']"), "Customer Login button", 20);
    }

    public void clickAddCustomerTab() {
        click(By.cssSelector("button[ng-click*='addCust']"), "Add Customer tab", 20);
    }

    public void enterFirstName(String firstName) {
        enter(By.cssSelector("input[ng-model='fName']"), firstName, "First name", 20);
    }

    public void enterLastName(String lastName) {
        enter(By.cssSelector("input[ng-model='lName']"), lastName, "Last name", 20);
    }

    public void enterPostalCode(String postalCode) {
        enter(By.cssSelector("input[ng-model='postCd']"), postalCode, "Postal code", 20);
    }

    public void clickAddCustomerButton() {
        click(By.cssSelector("form[ng-submit*='addCustomer'] button[type='submit']"), "Add Customer button", 20);
    }

    public void clickOkButtonFromAlertPopup() {
        findAlertPopUp(10);
        Alert alertPopup = switchToAlertPopup();
        String alertMessage = alertPopup.getText();
        alertPopup.accept();
        if (alertMessage.toLowerCase().contains("added successfully".toLowerCase())) {
            System.out.println(format("%s is displayed", alertMessage));
        } else {
            System.out.println(format("%s isn't displayed", alertMessage));
        }
    }
    public void clickCustomersSection()
    {
        click(By.cssSelector("button[ng-click*='showCust']"), "Customers tab", 20);
    }
    public void SearchCustomer(String customerName)
    {
        enter(By.cssSelector("input[ng-model='searchCustomer']"),customerName,"search",15);
    }

    public void verifyCustomerAddedInCustomerTable(String firstName, String lastName)
    {
        if (isVisible(By.xpath(format("//table[@class='table table-bordered table-striped']//td[text()='%s']//following-sibling::td[text()='%s']",firstName,lastName)),20) )
        {
            System.out.println(format("%s %S is displayed in the table",firstName,lastName));
        }else
        {
            System.out.println(format("%s %S is not displayed in the table",firstName,lastName));
        }
    }

}
