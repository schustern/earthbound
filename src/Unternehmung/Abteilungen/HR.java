package Unternehmung.Abteilungen;


import Unternehmung.Abteilung;
import Unternehmung.Kennzahlensammlung;
import Unternehmung.Mitarbeiter;
import Unternehmung.Unternehmen;

import java.util.ArrayList;

/**
 * Abteilung Human Resources
 */
public class HR extends Abteilung {
    private final Unternehmen unternehmen;

    // TODO was soll hier passieren? - Ist es nicht besser Funktionen wie "Mitarbeiter entlassen", "Mitarbeiter von
    // TODO Abteilung X in Abteilung Y verschieben" oder "Gehalt bearbeiten" in der Klasse Mitarbeiter zu implementieren?

    /**
     * Konstruktor, zum Erstellen der Abteilung Human Resources
     *
     * @param kennzahlensammlung Kennzahlenobjekt wird später benötigt, um Kennzahlensammlung laufend fortzuschreiben / zu berechnen
     */
    public HR(Unternehmen unternehmen, Kennzahlensammlung kennzahlensammlung) {
        super("Human-Resources" ,kennzahlensammlung);

        this.unternehmen = unternehmen;
    }

    public float getDurchschnittlichesGehalt() {
        float gehalt = 0;
        float anzahl = 0;
        for (Abteilung abteilung : unternehmen.getAbteilungen().values()) {
            for (Mitarbeiter arbeiter : abteilung.getMitarbeiter()) {
                anzahl++;
                gehalt += (float) arbeiter.getGehalt();
            }
        }
        if(anzahl==0)return -1;
        return (gehalt / anzahl);
    }
    public int getTotalMitarbeiterCount()
    {
        int count = 0;
        for (Abteilung abteilung : unternehmen.getAbteilungen().values()) {
            count+=abteilung.getMitarbeiterAnzahl();
        }
        return count;
    }
    public ArrayList<Mitarbeiter> getTotalMitarbeiter()
    {
        ArrayList<Mitarbeiter> erg = new ArrayList<>();
        for (Abteilung abteilung : unternehmen.getAbteilungen().values()) {
            erg.addAll(abteilung.getMitarbeiter());
        }
        return erg;
    }
}
