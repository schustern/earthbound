package Unternehmung.Abteilungen;

import Unternehmung.Abteilung;
import Unternehmung.Kennzahlen;

/**
 * Klasse, die eine Abteilung repräsentiert, die für soziale Leistungen verantwortlich ist
 * Created by lucadommes on 29.12.2016.
 */
public class SozialeLeistungen extends Abteilung {

    /**
     * Konstruktor, zum Erstellen der Abteilung für soziale Leistungen
     * @param kennzahlen Kennzahlenobjekt wird später benötigt, um Kennzahlen laufend fortzuschreiben / zu berechnen
     */
    public SozialeLeistungen(Kennzahlen kennzahlen) {
        super(kennzahlen);
    }

    /**
     * Einrichten / Ausbau einer Kantine
     * erhöht Mitarbeiterzufriedenheit / Reputation
     * @param kosten der Investition
     */
    public static void kantine (int kosten) {
        // TODO Mitarbeiterzufriedenheit erhöhen
    }
}