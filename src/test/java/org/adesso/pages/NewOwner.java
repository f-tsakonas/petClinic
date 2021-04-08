package org.adesso.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class NewOwner {



    private static SelenideElement newOwnerHeader = $(withText("New Owner"));
    private static SelenideElement firstNameInput = $(byId("firstName"));
    private static SelenideElement addressInput = $(byId("address"));
    private static SelenideElement cityInput = $(byId("city"));
    private static SelenideElement telephoneInput = $(byId("telephone"));
    private static SelenideElement lastNameInput = $(byName("lastName"));
    private static SelenideElement addOwnerBtn = $(byText("Add Owner"));


    /**
     * Für aktuelle Seite wird geprüft, ob es sich um Add New Owner Seite handelt
     */
    public void verifyAddNewOwnerPageLoaded(){
        $(newOwnerHeader).shouldBe(visible);
    }

    /**
     * Für aktuelle Seite wird geprüft, ob es sich nicht (mehr) um die Add New Owner Seite handelt
     */
    public void verifyAddNewOwnerPageLeft(){
        $(newOwnerHeader).shouldNotBe(visible);
    }

    /**
     * Ein neuen Besitzer wird angelegt
     * @param firstName Vorname des Besitzers
     * @param lastName Nachname des Besitzers
     * @param address Adresse des Besitzers
     * @param city Stadt des Besitzers
     * @param telephone Telefonnummer des Besitzers
     */
    public void fillAddNewOwnerForm(String firstName, String lastName, String address, String city, String telephone){
        verifyAddNewOwnerPageLoaded();
        $(firstNameInput).setValue(firstName);
        $(lastNameInput).setValue(lastName);
        $(addressInput).setValue(address);
        $(cityInput).setValue(city);
        $(telephoneInput).setValue(telephone);
    }

    /**
     * Add Owner Button wird geclickt, d.h. Add Owner Formular wird abgeschickt
     */
    public void clickAddOwner(){
        $(addOwnerBtn).click();
        verifyAddNewOwnerPageLeft();
    }

}
