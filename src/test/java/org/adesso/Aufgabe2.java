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
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class Aufgabe2 {
    //TODO: Erweitere Aufgabe 1 so, dass den Besitzer Davis anhand seines Nachnamens gesucht wird. Erwartetes Ergebnis: Es wird eine Tabelle mit allen Besitzern mit dem Nachnamen Davis angezeigt.
    //      Zusatzaufgabe: Wird nach dem Davis gesucht, so erscheinen zwei Ergebnisse: Harold Davis und Betty Davis. Erweitere den Testfall so, dass auch geprüft wird, dass beide Ergebnisse gefunden werden.

    @Rule
    public TextReport textReport = new TextReport();	
	
	private String suchstring = "Davis";   
	private String suchergebnis1 = "Harold Davis";
	private String suchergebnis2 = "Betty Davis";
	private String findbutton = "Find owners";    
    
	@Test
    public void sucheDavis(){
    	open("http://ad-schtes-dev01.test-server.ag:32772/");
    	$(byText(findbutton)).shouldBe(visible);		
    	$(byText(findbutton)).click();		
    	$(byName("lastName")).setValue(suchstring).pressEnter();		
        $(byText(suchergebnis1)).shouldBe(visible);		
        $(byText(suchergebnis2)).shouldBe(visible);		
        $$(byId("qwnersTabelle")).shouldHaveSize(2);
        
	}
}
