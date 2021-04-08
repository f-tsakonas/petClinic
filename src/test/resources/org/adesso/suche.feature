@suche
Feature: Suche nach Besitzer
  Scenario: Suche nach Eduardo Rodriquez
    Given ich öffne den Browser
    When ich Suche nach Besitzer Rodriquez
    Then ich befinde mich auf der Owner Information-Seite von Rodriquez