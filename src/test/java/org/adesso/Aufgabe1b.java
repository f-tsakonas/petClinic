package org.adesso;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit.TextReport;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class Aufgabe1b {                          //Definition einer Klasse, erster Buchstabe immer Groß geschrieben

    @Rule
    public TextReport textReport = new TextReport();  //Regel, einen Report in der Konsole auszugeben
	
	private String suchstring = "Rodriquez";      //Definition von Variablen (Datentyp + Name der Variable, erster Buchstabe immer klein geschrieben
	private String suchergebnis = "Eduardo Rodriquez";
	private String findbutton = "Find owners";
	
    //TODO: Suche mit Variablen den Besitzer Eduardo Rodriquez andhand seines Nachnamens. Erweitere Aufgabenteil A indem Du Elemente auslagerst.
    @Test                                         //ist eine JUnit-Konvention, bedeutet, dass nachfolgende Methode einen Test darstellt
    public void sucheEduardo(){                   //void bedeutet, dass diese Methode nichts zurück gibt, leere Klammer bedeutet, dass sie keinen Wert erwartet
    	open("http://ad-schtes-dev01.test-server.ag:32772/");
    	$(byText(findbutton)).shouldBe(visible);  //suche auf der Seite den Text "Find owners" und prüfe, ob dieser verfügbar ist
    	$(byText(findbutton)).click();            //suche auf der Seite den Text "Find owners" und klicke diesen an
    	$(byName("lastName")).setValue(suchstring).pressEnter(); //suche nach Name "lastName", befülle mit Variable suchstring und drück enter
        $(byText(suchergebnis)).shouldBe(visible);   // suche nach Variable suchergebnis und prüfe, ob dieser verfügbar ist
    }
}

//Beispiel für eine Methode, die einen Wert erwartet: public void sucheEduardo(String Passwort)
// public int bedeutet, diese Methode muss eine Wert vom Datentyp int zurück geben
//weitere JUnit-Konvention: @before - um z.B. vorgelagerte Testbedinungen herzustellen