package Unternehmung.Abteilungen;

import Exceptions.BankruptException;
import Exceptions.ZuWenigMitarbeiterException;
import Rules.Game;
import Unternehmung.*;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Abteilung, die für Vertrieb zuständig ist
 * Created by lucadommes on 30.12.2016.
 */
public class Vertrieb extends Abteilung {

    private Produktion produktion;
    private Map<Integer, Ausschreibung> opportunities = new HashMap<>();;
    private CopyOnWriteArrayList<Vertrag> accounts = new CopyOnWriteArrayList<>();


    public Vertrieb(Kennzahlensammlung kennzahlensammlung, Abteilung produktion) {
        super("Vertrieb",kennzahlensammlung);
        this.produktion = (Produktion) produktion;
    }

    /**
     * speichert ein Ausschreibungsobjekt mit dem index, in dem es in Game.ausschreibungen gespeichert ist ab (sofern genug Mitarbeiter vorhanden -> ein Mitarbeiter pro Bewerbung nötig)
     * @param index unter dem die Ausschreibung in der ArrayList ausschreibungen in der Klasse Game abgelegt ist
     */
    public void bewerben(int index) throws ZuWenigMitarbeiterException{
        if (this.mitarbeiter.size() > opportunities.size()) {
            List<Ausschreibung> ausschreibungen = Game.getAusschreibungen();
            opportunities.put(index, ausschreibungen.get(index));
        } else {
            throw new ZuWenigMitarbeiterException("Vertrieb");
        }
    }

    /**
     * wird aufgerufen von Game.updateAusschreibungen, wenn das Unternehmen den Zuschlag bekommt
     * @param index unter dem die Ausschreibung in der Game.ausschreibungen und in opportunities abgelegt ist
     */
    public void zuschlagBekommen(int index){
        accounts.add(opportunities.get(index).getVertrag());
    }

    /**
     * Verkauf von Produkten: Lagerbestand verringern, Umsatz erhöhen
     * ruft vertragBrechen() auf, falls nicht genügend Produkte im Lager vorhanden sind
     */
    private  void produkteVerkaufen(){
        float umsatz = 0;
        for (Vertrag vertrag : accounts){
            boolean vertragErfüllt = false;
            int menge = vertrag.getProduktlinie().getMenge();
            String id = vertrag.getProduktlinie().getId();
            // Produkt im Lager finden:
            for (Produktlinie bestand : this.produktion.getLager()) {
                if (bestand.getId().equals(id)) {
                    // Prüfen, ob Menge ausreichend ist:
                    if (menge <= bestand.getMenge()) {
                        // Menge verringern, Umsatz addieren:
                        bestand.setMenge(bestand.getMenge() - menge);
                        umsatz += vertrag.getPreis() * vertrag.getProduktlinie().getMenge();
                        vertragErfüllt = true;
                    } else {
                        // alle vorhandenen Produkte verkaufen:
                        umsatz += bestand.getMenge();
                        this.produktion.getLager().remove(bestand);
                    }
                }
            }
            if (!vertragErfüllt){
                this.vertragBrechen(vertrag);
            }
        }
        try {
            this.kennzahlensammlung.getGuv().addUmsatz(umsatz);
            this.kennzahlensammlung.getBilanz().liquiditaetAnpassen(umsatz);
        } catch (BankruptException e) {
            e.printStackTrace();
        }
    }

    /**
     * Vertragsbruch: Strafe zahlen (Liquidität verringern, Aufwendung verbuchen), Vertrag wird gekündigt (gelöscht)
     * @param vertrag, der nicht eingehalten wurde
     */
    private  void vertragBrechen(Vertrag vertrag){
        try {
            this.kennzahlensammlung.getBilanz().liquiditaetAnpassen(- vertrag.getStrafe());
            this.kennzahlensammlung.getGuv().addGeleisteterSchandsersatz(vertrag.getStrafe());
            this.accounts.remove(vertrag);
        } catch (BankruptException e){
            e.printStackTrace();
        }
    }

   @Override
    public  void update() {
        if (Game.getCalendar().get(Calendar.DAY_OF_MONTH) == Game.getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH)){
            this.produkteVerkaufen();
            for (Vertrag vertrag : this.accounts){
                if (Game.getCalendar() == vertrag.getEnd()){
                    this.accounts.remove(vertrag);
                }
            }
        }
    }


    // Getter und Setter:
    public Map<Integer, Ausschreibung> getOpportunities() {
        return opportunities;
    }

    public void clearOpportunities() {
        this.opportunities.clear();
    }

    public List<Vertrag> getAccounts() {
        return accounts;
    }

}
