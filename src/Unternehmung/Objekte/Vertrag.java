package Unternehmung.Objekte;

import Rules.Game;
import Unternehmung.Kennzahlensammlung;

import java.util.Calendar;

/**
 * Vertrag über monatliche Abnahme von Produkten
 * Created by oehlersj on 19.01.2017.
 */
public class Vertrag {
    private Produktlinie produktlinie;
    private float preis;
    private float strafe;
    private String kunde;
    private int laufzeit; // in Monaten! (Laufzeit = 1 bedeutet, dass es sich um eine einmalige Bestellung handelt)
    private Calendar beginn; // dies ist der Beginn des Vertrags, also gleichzeitig der Entscheidungstag der Ausschreibung, an dem entschieden wird, wer den Auftrag für sich gewonnen hat
    private Calendar end;


    public Vertrag(Produktlinie produktlinie, String kunde, int laufzeit) {
        this.produktlinie = produktlinie;
        this.kunde = kunde;
        this.laufzeit = laufzeit;
        this.beginn = (Calendar) Game.getCalendar().clone();
        this.end = (Calendar) this.beginn.clone();
        this.end.add(Calendar.MONTH, laufzeit);
        this.strafe = this.preis * 0.75f;
    }

    /**
     * // Marge von 15% multipliziert sich mit der Verkaufswahrscheinlichkeit
     * @param kennzahlensammlung des Unternehmen, das den Zuschlag bekommen hat
     */
    public void setPreisByKennzahlen(Kennzahlensammlung kennzahlensammlung){
        this.preis = (float) this.produktlinie.getProdukt().getHerstellkosten() +
                1.15f * (1 + kennzahlensammlung.getWeicheKennzahl("verkaufswahrscheinlichkeit").getWert());
    }


    // Getter und Setter:
    public Produktlinie getProduktlinie() {
        return produktlinie;
    }

    public void setProduktlinie(Produktlinie produktlinie) {
        this.produktlinie = produktlinie;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public float getStrafe() {
        return strafe;
    }

    public void setStrafe(float strafe) {
        this.strafe = strafe;
    }

    public String getKunde() {
        return kunde;
    }

    public void setKunde(String kunde) {
        this.kunde = kunde;
    }

    public int getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(int laufzeit) {
        this.laufzeit = laufzeit;
    }

    public Calendar getBeginn() {
        return beginn;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }
}
