package org.adesso;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class Aufgabe1a {

    //TODO: Suche den Besitzer Eduardo Rodriquez anhand seines Nachnamens. Erwartetes Ergebnis: Es wird die Detailseite von Eduardo Rodriquez angezeigt.
    @Test
    public void sucheEduardo(){
    	open("http://localhost:8080/");
    	$(byText("Find owners")).shouldBe(visible);
    	$(byText("Find owners")).click();
    	$(byName("lastName")).setValue("Rodriquez").pressEnter();
        $(byText("Eduardo Rodriquez")).shouldBe(visible);
    	

    }
}

