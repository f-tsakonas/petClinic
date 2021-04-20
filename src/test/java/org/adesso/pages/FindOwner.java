package org.adesso.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class FindOwner {
    /**
     * Find Owners Seite wird aufgerufen
     */
    private static SelenideElement findOwnerTab = $(byTitle("find owners"));
    private static SelenideElement lastNameInput = $(byName("lastName"));
    private static SelenideElement findOwnerBtn = $(byText("Find Owner"));
    private static SelenideElement addOwnerBtn = $(byText("Add Owner"));


    public void goToFindOwners(){
        $(findOwnerTab).click();
    }

    /**
     * Für aktuelle Seite wird geprüft, ob es sich um Find Owners Seite handelt
     */
    public void verifyFindOwnersPageLoaded(){
        $(lastNameInput).shouldBe(visible);
        $(findOwnerBtn).shouldBe(visible);
    }

    /**
     * Für aktuelle Seite wird geprüft, ob es sich nicht (mehr) um Seite Find Owners handelt
     */
    public void verifyFindOwnersPageLeft(){
        $(lastNameInput).shouldNotBe(visible);
        $(findOwnerBtn).shouldNotBe(visible);
    }

    /**
     * Seite Add New Owner wird aufgerufen
     */
    public void clickAddNewOwner(){
        $(addOwnerBtn).click();

    }

    /**
     * Ein Besitzer wird gesucht
     * @param name Nachname des Besitzers
     */
    public void search(String name){
        verifyFindOwnersPageLoaded();
        $(lastNameInput).setValue(name);
        $(findOwnerBtn).click();
        verifyFindOwnersPageLeft();

    }

}
