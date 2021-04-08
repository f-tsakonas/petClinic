package org.adesso;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Aufgabe1Loesung {
    private SelenideElement lastNameInput = $(byName("lastName"));
    private SelenideElement findOwnerTab = $(byTitle("find owners"));
    private SelenideElement findOwnerBtn = $(byText("Find Owner"));

    public void goToFindOwners(){
        $(findOwnerTab).click();
    }

    public void searchOwner(String name){  //Frage: diese Methode erwartet einen name-Wert - wo wird dieser definiert?
        $(lastNameInput).setValue(name);
        $(findOwnerBtn).click();
        $(findOwnerBtn).shouldNot(visible);
    }

    @Test
    public void sucheEduardo(){
        open("http://ad-schtes-dev01.test-server.ag:32772/");
        goToFindOwners();
        searchOwner("Rodriquez");           //Methode searchOwner setzt den Wert "Rodriquez"? klappt das von der Reihenfolge
        $(byText("Owner Information")).shouldBe(visible);
        $(byText("Eduardo Rodriquez")).shouldBe(visible);
    }
}
