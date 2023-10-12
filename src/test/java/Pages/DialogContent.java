package Pages;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends MyMethods {

    public DialogContent() {
        PageFactory.initElements(ParameterDriver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]//section[@id='content-collapsible-block-4']//table/tbody/tr/td[2]/a")
    public List<WebElement> listOfHostCountries;

}
