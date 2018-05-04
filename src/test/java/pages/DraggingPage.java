//
// File Created by miguel_aguilar on 5/4/2018 3:31 PM
//
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DraggingPage {

    @FindBy(how = How.ID, using="draggable")
    private WebElement lblDrag;


    @FindBy(how = How.ID, using = "item2")
    private WebElement item2;

    @FindBy(how = How.ID, using = "item5")
    private WebElement item5;

    public DraggingPage(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    public void DragAndDrop(WebDriver _driver){
        Actions action = new Actions(_driver);
        action.dragAndDrop(item2,item5).perform();
    }

}
