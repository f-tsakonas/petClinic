package org.adesso;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Aufgabe1c {
    
    //TODO: Suche den Besitzer Eduardo Rodriquez anhand seines Nachnamens mithilfe von einer Such-Methode.
    @Test
    public void sucheEduardo(){
    	open("http://ad-schtes-dev01.test-server.ag:32772/");
    	$(byText("Find owners")).shouldBe(visible);
    	$(byText("Find owners")).click();
    	
    	
    }
}
