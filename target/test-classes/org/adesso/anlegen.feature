@anlegen
Feature: Anlegen von Besitzern
  Scenario Template: Neue Besitzer anlegen
    Given ich öffne den Browser
    When ich einen neuen Besitzer mit Vorname:<vorname>, Nachname:<nachname>, Adresse:<adresse>, Ort:<ort>, Telefonnummer:<telefonnummer> anlege

    Examples:
      | vorname | nachname | adresse | ort | telefonnummer |
      | Harry | Potter | Ligusterweg | London | 1234567 |