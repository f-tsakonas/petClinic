package org.adesso;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Aufgabe4 {
    @Rule
    public TextReport textReport = new TextReport();

    private SelenideElement lastNameInput = $(By.name("lastName"));
    private SelenideElement findOwnerTab = $(byTitle("find owners"));
    private SelenideElement findOwnerBtn = $(byText("Find Owner"));
    private SelenideElement addOwnerBtn = $(byText("Add Owner"));
    private SelenideElement firstNameInput = $(byId("firstName"));
    private SelenideElement addressInput = $(byId("address"));
    private SelenideElement cityInput = $(byId("city"));
    private SelenideElement telephoneInput = $(byId("telephone"));
    private SelenideElement editOwnerBtn = $(byText("Edit Owner"));
    private SelenideElement ownerInformationHeader = $(byText("Owner Information"));
    private SelenideElement addPetBtn = $(byText("Add New Pet"));  //neu angelegt
    private SelenideElement newNamePetInput = $(By.name("name"));  //neu angelegt
    private SelenideElement birthDateInput = $(By.name("birthDate"));  //neu angelegt    
    private SelenideElement typeInput = $(By.name("type"));  //neu angelegt     
    private SelenideElement addPetBtn2 = $(byText("Add Pet"));  //neu angelegt

    
    public void goToFindOwners(){
        $(findOwnerTab).click();
    }

    public void searchOwner(String name){
        $(lastNameInput).setValue(name);
        findOwnerBtn.click();
    }

    public void addNewOwner(String firstName, String lastName, String address, String city, String telephone){
        $(firstNameInput).setValue(firstName);
        $(lastNameInput).setValue(lastName);
        $(addressInput).setValue(address);
        $(cityInput).setValue(city);
        $(telephoneInput).setValue(telephone);
        $(addOwnerBtn).click();
    }

    public void clickAddOwner(){
        $(addOwnerBtn).click();
    }

    
    public void addNewPet(String namePet, String birthDay, String type){   //neu hinzugefügt
    	$(newNamePetInput).setValue(namePet);
    	$(birthDateInput).setValue(birthDay).pressTab();
    	$(typeInput).selectOption(type);
    	addPetBtn2.click();
    }
    
    public String changeDate(){
    	LocalDate localDate = LocalDate.of(2003, 03, 02); //For reference LocalDate.now()
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	String formattedString = localDate.format(formatter);
    	return formattedString;

    }
    
    //TODO: Erweitere die vorherige Aufgabe so, dass in der Maske "Owner Information" des Besitzers über den Button "Add Pet" die Maske zum Anlegen eines neuen Haustiers aufgerufen wird. 
    //      Lege ein neues Haustier hinzu. Beachte dabei, dass das Geburtsdatum in dem Test in dem Format dd.MM.yyyy (z.B. 15.04.2009) eingegeben wird,
    //      Wobei die Anwendung ein Datum im Format yyyy/MM/dd akzeptiert. Wandle das Datum um mithilfe von Klassen Localdate und DateTimeFormatter.
    @Test
    public void addPet(){
        open("http://ad-schtes-dev01.test-server.ag:32772/");
        goToFindOwners();
        searchOwner("Steiner");       
        $(byText("Owner Information")).shouldBe(visible);
        $(byText("Bernd Steiner")).shouldBe(visible);   	
        addPetBtn.click();
        addNewPet("Mausi+LocalDateTime.now()", changeDate(), "bird");
        
      	
    }

    @Test
    public void addHarry(){
        open("http://ad-schtes-dev01.test-server.ag:32772/");
        goToFindOwners();
        clickAddOwner();
        addNewOwner("Harry", "Potter", "Ligusterweg 12", "London", "123456");
        $(editOwnerBtn).shouldBe(visible);
        $(ownerInformationHeader).shouldBe(visible);       
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
