package org.adesso;

import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest {

    @Rule
    public TextReport textReport = new TextReport();
    
    @Test
    public void userCanSearch() {
        open("https://google.com/ncr");
        new GooglePage().searchFor("selenide");

        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
