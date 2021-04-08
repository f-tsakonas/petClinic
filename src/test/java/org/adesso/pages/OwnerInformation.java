package org.adesso.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class OwnerInformation {

    /**
     * Für aktuelle Seite wird geprüft, ob es sich um Owner Information Seite handelt
     */
    public void verifyOwnerInformationPageLoaded(){
        $(byText("Owner Information")).shouldBe(visible);
    }

    /**
     * Für aktuelle Seite wird geprüft, dass es sich nicht (mehr) um Owner Information Seite handelt
     */
    public void verifyOwnerInformationPageLeft(){
        $(byText("Owner Information")).shouldNotBe(visible);
    }

    /**
     * Für aktuelle Owner Information Seite wird geprüft, dass es um die Detailseite des übergebenen Benutzers handelt
     * @param lastName Nachname des Besitzers
     */
    public void verifyOwnerInformationPageBelongs(String lastName){
        $(byText(lastName)).shouldBe(visible);
    }

    /**
     * Seite Add New Pet wird aufgerufen
     */
    public void clickAddNewPet(){
        $(byText("Add New Pet")).click();
    }

    public void ownerHasPet(String name){
        $(byText(name)).shouldBe(visible);
    }
}
