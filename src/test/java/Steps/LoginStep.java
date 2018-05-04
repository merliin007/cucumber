package Steps;//
// File Created by miguel_aguilar on 5/3/2018 10:42 AM
//

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.DraggingPage;
import pages.LandingPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil{
    private BaseUtil base;
    private LoginPage page;
    private LandingPage landingPage;
    private DraggingPage draggingPage;

    public LoginStep(BaseUtil base) {
        this.base = base;
        page = new LoginPage(base.driver);


    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigating to login page");
        base.driver.navigate().to("http://executeautomation.com/demosite/Login.html");
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        page.ClickLogin();

    }

    @Then("^I should see the user form page$")
    public void iShouldSeeTheUserFormPage() throws Throwable {
        Assert.assertEquals("Is not displayed", landingPage.IsLoggedIn(), true);
        landingPage = new LandingPage(base.driver);
        base.GrabScreenShot();
    }


    @And("^I enter the following details for Login$")
    public void iEnterTheFollowingDetailsForLogin(DataTable table) throws Throwable {

        System.out.println("Entering method");

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);


        for (User user : users) {
            page.Login(user.username, user.password);
        }
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String passWord) throws Throwable {
        System.out.println("Username is: " + userName);
        System.out.println("Password is: " + passWord);
    }

    @And("^I enter the users email address as Email: ([^\"]*)")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("The email address is:" + email);
    }

    @And("^I verify the count of my salary digits for Pesos (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransformer.class) int salary) throws Throwable {
        System.out.println("My salary digits count is: " + salary);
    }

    @And("^I navigate to Drag n Drop section$")
    public void iNavigateToDragNDropSection() throws Throwable {
        System.out.println("Drag and Drop");
        landingPage.ClickDragNDropTab();
        draggingPage = new DraggingPage(base.driver);
    }

    @And("^I drag and drop element (\\d+) to element (\\d+)$")
    public void iDragAndDropElementToElement(int arg0, int arg1) throws Throwable {
        draggingPage.DragAndDrop(base.driver);
        base.GrabScreenShot();
    }

    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}
