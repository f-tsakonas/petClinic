package org.adesso;

import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleAdessoTest {

    @Rule
    public TextReport textReport = new TextReport();

    @Test
    public void adessoTest(){
        open("https://www.google.com/");
        $(byName("q")).setValue("adesso SE").pressEnter();
        $(byText("www.adesso.de")).shouldBe(visible);
        $(byValue("Google Suche")).shouldNot(visible);
    }
}
