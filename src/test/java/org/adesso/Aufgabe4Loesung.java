package org.adesso;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Aufgabe4Loesung {
    @Rule
    public TextReport textReport = new TextReport();

    @Before
    public void init(){
        open("http://ad-schtes-dev01.test-server.ag:32772/");
    }

    static SelenideElement lastNameInput = $(byName("lastName"));
    static SelenideElement findOwnerTab = $(byTitle("find owners"));
    static SelenideElement findOwnerBtn = $(byText("Find Owner"));
    static SelenideElement addOwnerBtn = $(byText("Add Owner"));
    static SelenideElement firstNameInput = $(byId("firstName"));
    static SelenideElement addressInput = $(byId("address"));
    static SelenideElement cityInput = $(byId("city"));
    static SelenideElement telephoneInput = $(byId("telephone"));
    static SelenideElement editOwnerBtn = $(byText("Edit Owner"));
    static SelenideElement ownerInformationHeader = $(byText("Owner Information"));
    static SelenideElement addNewPetBtn = $(byText("Add New Pet"));
    static SelenideElement petNameInput = $(byId("name"));
    static SelenideElement petBirthDateInput = $(byId("birthDate"));
    static SelenideElement petTypeSelect = $(byId("type"));
    static SelenideElement petsAndVisitsHeader = $(byText("Pets and Visits"));
    static SelenideElement addPetBtn = $(byText("Add Pet"));

      public static void goToFindOwners(){
        $(findOwnerTab).click();  
      }

      public static void searchOwner(String name){
        $(lastNameInput).setValue(name);
        findOwnerBtn.click();
    }

      public static void addNewOwner(String firstName, String lastName, String address, String city, String telephone){
        $(firstNameInput).setValue(firstName);
        $(lastNameInput).setValue(lastName);
        $(addressInput).setValue(address);
        $(cityInput).setValue(city);
        $(telephoneInput).setValue(telephone);
        $(addOwnerBtn).click();
    }

      public static void clickAddOwner(){
        $(addOwnerBtn).click();
    }

      public static void goToAddNewPet(){
        $(addNewPetBtn).click();
    }

      public static void addNewPet(String name, String birthDate, String type) {
        $(petNameInput).setValue(name);
        LocalDate dateFrom = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        DateTimeFormatter formatTo = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dateFormatted = dateFrom.format(formatTo);
        $(petBirthDateInput).setValue(dateFormatted);
        $(petBirthDateInput).pressTab();
        $(petTypeSelect).selectOption(type);
        addPetBtn.click();
    }

 //  @Test
    public static void addEduarosPet(){
        goToFindOwners();
        searchOwner("Rodriquez");
        goToAddNewPet();
        addNewPet("Lucky2", "06.07.2009", "cat");
        petsAndVisitsHeader.shouldBe(visible);
        $(byText("Lucky2")).shouldBe(visible);
    }

 //   @Test
    public static void addHarry(){
        goToFindOwners();
        clickAddOwner();
        addNewOwner("Harry", "Potter", "Ligusterweg 12", "London", "123456");
        $(editOwnerBtn).shouldBe(visible);
        $(ownerInformationHeader).shouldBe(visible);
    }

 //   @Test
    public static void sucheEduardo(){
        goToFindOwners();
        searchOwner("Rodriquez");
        $(byText("Owner Information")).shouldBe(visible);
        $(byText("Eduardo Rodriquez")).shouldBe(visible);
    }

  //  @Test
    public static void sucheDavis(){
        goToFindOwners();
        searchOwner("Davis");
        $(byText("Betty Davis")).shouldBe(visible);
        $(byText("Harold Davis")).shouldBe(visible);
    }

	@Test    //neuhinzugefügt
	public void Testsuite() {
	sucheEduardo();
	addEduarosPet();
	}
	
}