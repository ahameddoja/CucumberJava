package page_Objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private static final Logger LOGGER = LogManager.getLogger(Home.class);
    String monthlyPaymentLocator;

    private final By HomeValue = By.id("homeval");
    private final By DownPayment = By.id("downpayment");
    private final By DownPaymentInDollar = By.xpath("//*[@id='calc']//input[@name='param[downpayment_type]'][@value='money']");
    private final By LoanAmount = By.id("loanamt");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTerm = By.id("loanterm");
    private final By StartDateMonth = By.name("param[start_month]");
    private final By StartDateYear = By.id("start_year");
    private final By PropertyTax = By.id("pptytax");
    private final By PMI = By.id("pmi");
    private final By HomeInsurance = By.id("hoi");
    private final By MonthlyHoa = By.id("hoa");
    private final By LoanType = By.name("param[milserve]");
    private final By BuyorRefi = By.name("param[refiorbuy]");
    private final By Calculate = By.name("cal");
    private final By TotalMonthlyPayment = By.xpath("//*[@id='calc']//h3[text()='$1,611.85']");

    public Home(WebDriver driver) {
        super(driver);
    }

    //Enter Home Value "300000"
    public Home typeHomePrice(String value) {
        LOGGER.debug("Entered Home Price is: " + value);
        ActOn.element(driver, HomeValue).setValue(value);
        return this;
    }

    //Enter Down Payment "60000"
    public Home typeDownPayment(String value) {
        ActOn.wait(driver, DownPayment).waitForElementToBEVisible();
        LOGGER.debug("Entered Down Payment is: " + value);
        ActOn.element(driver, DownPayment). setValue(value);
        return this;
    }

    //Click on the $ radio button for the Down payment option
    public Home clickDownPaymentInDollar() {
        LOGGER.debug("Clicked on the Down payment in Dollar");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    //Loan Amount "240000"
    public Home typeLoanAmount(String value) {
        LOGGER.debug("Entered Loan Amount is: " + value);
        ActOn.element(driver, LoanAmount).setValue(value);
        return this;
    }
    //Interest Rate 3.0%
    public Home typeInterestRate(String value) {
        LOGGER.debug("Entered Interest Rate is: " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    //Enter Loan Terms
    public Home typeLoanTermInYears(String value) {
        LOGGER.debug("Entered loan term is: " + value);
        ActOn.element(driver, LoanTerm).setValue(value);
        return this;
    }

    //Select Month
    public Home selectMonth(String month) {
        LOGGER.debug("Selected month is: " + month);
        ActOn.element(driver, StartDateMonth).selectValue(month);
        return this;
    }

    //Enter year
    public Home typeYear(String year) {
        LOGGER.debug("Entered year is: " + year);
        ActOn.element(driver, StartDateYear).setValue(year);
        return this;
    }

    //Property Tax "5000"
    public Home typePropertyTax(String value) {
        LOGGER.debug("Entered property tax is: " + value);
        ActOn.element(driver, PropertyTax).setValue(value);
        return this;
    }

    //PMI is "0.5"
    public Home typePMI(String value) {
        LOGGER.debug("Entered pmi is: " + value);
        ActOn.element(driver, PMI).setValue(value);
        return this;
    }

    //Home Insurance "1000"
    public Home typeHOI(String value) {
        LOGGER.debug("Entered homeowner insurance is: " + value);
        ActOn.element(driver, HomeInsurance).setValue(value);
        return this;
    }

    //Monthly HOA "100"
    public Home typeHOA(String value) {
        LOGGER.debug("Entered homeowner association is: " + value);
        ActOn.element(driver, MonthlyHoa). setValue(value);
        return this;
    }

    //Loan Type "FHA"
    public Home selectLoanType(String value) {
        LOGGER.debug("Selected loan type is: " + value);
        ActOn.element(driver, LoanType).selectValue(value);
        return this;
    }

    //Select "Buy" option
    public Home selectBuyOrRefi(String value) {
        LOGGER.debug("Selected Buy or Rafi option is: " + value);
        ActOn.element(driver, BuyorRefi).selectValue(value);
        return this;
    }

    //Click on calculate Button
    public Home clickOnCalculateButton() {
        LOGGER.debug("Clicked on the Calculate button");
        ActOn.element(driver, Calculate). click();
        return this;
    }

    //Validating that total Monthly Payment is accurate
    public Home validateMonthlyPayment(String totalMonthlyPayment) {
        LOGGER.debug("Validating total monthly payment "+ totalMonthlyPayment);
        By monthlyPaymentLocator = By.xpath("//*[@id='calc']//h3[text()='"+ totalMonthlyPayment +"']");
        AssertThat.elementAssertions(driver, monthlyPaymentLocator).elementExist();
        return this;
    }
}
