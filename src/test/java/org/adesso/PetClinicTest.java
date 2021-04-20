package org.adesso;

import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PetClinicTest {

    @Test
    public void addEduarosPet() {
        Aufgabe4Loesung.goToFindOwners();
        Aufgabe4Loesung.searchOwner("Rodriquez");
        Aufgabe4Loesung.goToAddNewPet();
        Aufgabe4Loesung.addNewPet("Lucky2", "06.07.2009", "cat");
        Aufgabe4Loesung.petsAndVisitsHeader.shouldBe(visible);
        $(byText("Lucky2")).shouldBe(visible);
    }

    @Test
    public void addHarry() {
        Aufgabe4Loesung.goToFindOwners();
        Aufgabe4Loesung.clickAddOwner();
        Aufgabe4Loesung.addNewOwner("Harry", "Potter", "Ligusterweg 12", "London", "123456");
        $(Aufgabe4Loesung.editOwnerBtn).shouldBe(visible);
        $(Aufgabe4Loesung.ownerInformationHeader).shouldBe(visible);
    }

    @Test
    public void sucheEduardo() {
        Aufgabe4Loesung.goToFindOwners();
        Aufgabe4Loesung.searchOwner("Rodriquez");
        $(byText("Owner Information")).shouldBe(visible);
        $(byText("Eduardo Rodriquez")).shouldBe(visible);
    }

    @Test
    public void sucheDavis() {
        Aufgabe4Loesung.goToFindOwners();
        Aufgabe4Loesung.searchOwner("Davis");
        $(byText("Betty Davis")).shouldBe(visible);
        $(byText("Harold Davis")).shouldBe(visible);
    }

}
