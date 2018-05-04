//
// File Created by miguel_aguilar on 5/3/2018 5:03 PM
//
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "UserName")
    private WebElement txtUserName;

    @FindBy(how = How.NAME, using ="Password")
    private WebElement txtPassword;

    @FindBy(how = How.NAME, using = "Login")
    private WebElement btnLogin;



    public void Login(String userName, String password){
        this.txtUserName.sendKeys(userName);
        this.txtPassword.sendKeys(password);
    }

    public void ClickLogin(){
        this.btnLogin.submit();
    }


}
