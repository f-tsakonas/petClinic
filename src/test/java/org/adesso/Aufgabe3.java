package org.adesso;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Aufgabe3 {

    @Rule
    public TextReport textReport = new TextReport();

    private SelenideElement lastNameInput = $(By.name("lastName"));
    private SelenideElement firstNameInput = $(By.name("firstName"));
    private SelenideElement addressInput = $(By.name("address"));
    private SelenideElement cityInput = $(By.name("city"));    
    private SelenideElement telefonInput = $(By.name("telephone"));    
    private SelenideElement findOwnerTab = $(byTitle("find owners"));
    private SelenideElement findOwnerBtn = $(byText("Find Owner"));
    private SelenideElement addbutton = $(byText("Add Owner"));
	
    public void goToFindOwners(){
        $(findOwnerTab).click();
    }

    public void searchOwner(String name){
        $(lastNameInput).setValue(name);
        $(findOwnerBtn).click();
        $(findOwnerBtn).shouldNot(visible);
    }

    //TODO: Füge einen neuen Besitzer hinzu. Trage die Besitzerinformationen ein. 
    @Test
    public void addOwner(){
        open("http://ad-schtes-dev01.test-server.ag:32772/");
        goToFindOwners();
        $(addbutton).click();
    	$(firstNameInput).setValue("Bernd");
    	$(lastNameInput).setValue("Steiner");       
    	$(addressInput).setValue("daheim"); 
    	$(cityInput).setValue("Berlin"); 
    	$(telefonInput).setValue("12345"); 
        $(addbutton).click();
        $(byText("Owner Information")).shouldBe(visible);
        $(byText("Owner Information")).shouldBe(visible);
        $(byText("Bernd Steiner")).shouldBe(visible);
    
    }

    @Test
    public void sucheEduardo(){
        open("http://ad-schtes-dev01.test-server.ag:32772/");
        goToFindOwners();
        searchOwner("Rodriquez");
        $(byText("Owner Information")).shouldBe(visible);
        $(byText("Eduardo Rodriquez")).shouldBe(visible);
    }

    @Test
    public void sucheDavis(){
        open("http://ad-schtes-dev01.test-server.ag:32772/");
        goToFindOwners();
        searchOwner("Davis");
        $(byText("Betty Davis")).shouldBe(visible);
        $(byText("Harold Davis")).shouldBe(visible);
    }
}
