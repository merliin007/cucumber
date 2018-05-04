//
// File Created by miguel_aguilar on 5/4/2018 3:23 PM
//
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @FindBy(how = How.ID, using ="menu-button")
    private WebElement menu;

    @FindBy(how = How.ID, using ="Initial")
    private WebElement txtInitial;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void ClickDragNDropTab(){
        menu.findElement(By.className("last")).click();
    }

    public boolean IsLoggedIn(){
        return this.txtInitial.isDisplayed();
    }

}
