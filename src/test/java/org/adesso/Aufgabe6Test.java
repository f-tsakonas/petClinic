package org.adesso;

import com.codeborne.selenide.junit.TextReport;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class Aufgabe6Test extends Aufgabe6uc{
    @Rule
    public TextReport textReport = new TextReport();

    @Before
    public void init(){
        open("http://ad-schtes-dev01.test-server.ag:32781/");
    }

    @Test
    public void addOwnerHarryPotter(){
        String firstName = "Frodo";
        String lastName = "Baggins";
        String address = "Harry Potter str. 12";
        String city = "Harry Potter City";
        String telephone = "1234567";
        addNewOwner(firstName, lastName, address, city, telephone);
    }

    @Test
    public void addHarrysPet(){
        String owner = "Baggins";
        String name = "supercat";
        String birthDate = "08.08.2008";
        String type = "bird";
        searchOwner(owner);
        addNewPet(name, birthDate, type);
    }
}
