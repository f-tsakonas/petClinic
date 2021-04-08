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

    private statics SelenideElement lastNameInput = $(byName("lastName"));
    private SelenideElement findOwnerTab = $(byTitle("find owners"));
    private SelenideElement findOwnerBtn = $(byText("Find Owner"));
    private SelenideElement addOwnerBtn = $(byText("Add Owner"));
    private SelenideElement firstNameInput = $(byId("firstName"));
    private SelenideElement addressInput = $(byId("address"));
    private SelenideElement cityInput = $(byId("city"));
    private SelenideElement telephoneInput = $(byId("telephone"));
    private SelenideElement editOwnerBtn = $(byText("Edit Owner"));
    private SelenideElement ownerInformationHeader = $(byText("Owner Information"));
    private SelenideElement addNewPetBtn = $(byText("Add New Pet"));
    private SelenideElement petNameInput = $(byId("name"));
    private SelenideElement petBirthDateInput = $(byId("birthDate"));
    private SelenideElement petTypeSelect = $(byId("type"));
    private SelenideElement petsAndVisitsHeader = $(byText("Pets and Visits"));
    private SelenideElement addPetBtn = $(byText("Add Pet"));

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

      public void goToAddNewPet(){
        $(addNewPetBtn).click();
    }

      public void addNewPet(String name, String birthDate, String type) {
        $(petNameInput).setValue(name);
        LocalDate dateFrom = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        DateTimeFormatter formatTo = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dateFormatted = dateFrom.format(formatTo);
        $(petBirthDateInput).setValue(dateFormatted);
        $(petBirthDateInput).pressTab();
        $(petTypeSelect).selectOption(type);
        addPetBtn.click();
    }
}