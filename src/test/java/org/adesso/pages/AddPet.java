package org.adesso.pages;

import com.codeborne.selenide.SelenideElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class AddPet {
    /**
     * Für aktuelle Seite wird geprüft, ob es sich um Add New Pet Seite handelt
     */
    public void verifyAddNewPetPageLoaded() {
        $(byText("New Pet")).shouldBe(visible);
    }

    /**
     * Für aktuelle Seite wird geprüft, dass es sich nicht (mehr) um die Add New Pet Seite handelt
     */
    public void verifyAddNewPetPageLeft() {
        $(byText("New Pet")).shouldNotBe(visible);
    }

    /**
     * Ein Formular mit Haustierdaten wird ausgefüllt
     *
     * @param name      Name des Haustiers
     * @param birthDate Geburtsdatum des Haustiers
     * @param type      Art des Haustiers
     */
    public void fillAddNewPetForm(String name, String birthDate, String type) {
        $(byName("name")).setValue(name);
        LocalDate gerDT = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        DateTimeFormatter engDT = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String stringDT = gerDT.format(engDT);
        $(byName("birthDate")).setValue(stringDT).pressTab();
        $(byName("type")).selectOption(type);
    }

    /**
     * Add Pet Button wird geclickt, d.h. Add New Pet Formular wird abgeschickt
     */
    public void clickAddPet() {
        $(byText("Add Pet")).click();
    }
}