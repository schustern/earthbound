package Unternehmung.Abteilungen;

import Unternehmung.Abteilung;
import Unternehmung.Kennzahlensammlung;
import Unternehmung.Marketingkampagne;
import Unternehmung.Marktforschung;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasse, die die Abteilung Marketing repräsentiert, hier können Marketingkampagnen und Marktforschung durchgeführt werden
 * Created by lucadommes on 29.12.2016.
 */
public class Marketing extends Abteilung {

    Map<String, Marketingkampagne> kampagnen = new HashMap<String, Marketingkampagne>(); // <art, Marketingkampagne>
    Map<Integer, Marktforschung> mafos = new HashMap<Integer, Marktforschung>(); // <umfang, Marktforschung>

    /**
     * Konstruktor, zum Erstellen der Abteilung Marketing
     * @param kennzahlensammlung Kennzahlenobjekt wird später benötigt, um Kennzahlensammlung laufend fortzuschreiben / zu berechnen
     */
    public Marketing(Kennzahlensammlung kennzahlensammlung) {
        super("Marketing",kennzahlensammlung);
    }

    /**
     * Werbekampagne. Falls eine Kampagne dieser Art bereits läuft wird diese um die entsprechende Laufzeit verlängert
     * @param art Art der Kampagne, etwa Plakate, Print, Radio oder TV (unterschiedlich teuer und unterschiedlich effektiv)
     * @param laufzeit in timer counts
     */
    public void marketingkampagneStartenOderVerlängern(String art, int laufzeit){
        if (this.kampagnen.get(art) == null) {
            Marketingkampagne kampagne = new Marketingkampagne(art, laufzeit);
            this.kampagnen.put(art, kampagne);
            System.out.println("Marketingkampagne \"" + art + "\" gestartet. Kosten: " + kampagne.getKosten()
                    + " € pro Tag, Bekanntheitsgrad steigt um " + kampagne.getImpact());
        } else {
            this.kampagnen.get(art).setLaufzeit(this.kampagnen.get(art).getLaufzeit() + laufzeit);
            System.out.println("Marketingkampagne \"" + art + "\" wurde verlängert.");
        }
    }


    public void marketingkampagneAbbrechen(String art) {
        this.kampagnen.remove(art);
    }

    /**
     * Methode zur Durchführung von Marktforschung. Hierdurch können z.B. besser Zielgruppen angesprochen werden,
     * wodurch sich Produkte besser verkaufen lassen (Absatzrate steigt)
     * @param umfang drei verschiedene "Größen" mit unterschiedlichen Dauer und Effektivität
     */
    public void marktforschungStarten(int umfang){
        if (this.mafos.get(umfang) == null){
            this.mafos.put(umfang, new Marktforschung(umfang));
        } else {
            System.out.println("Martforschung Stufe " + umfang + " läuft bereits.");
        }
    }

    /**
     * Bricht das Marktforschungsprojekt ab -> das Geld wurde umsonst ausgegeben, da Mafos erst ganz am Ende einen Effekt haben
     * @param umfang 1, 2 oder 3
     */
    public void marktforschungAbbrechen(int umfang){
        this.kampagnen.remove(umfang);
    }

    @Override
    public void update(){
        updateMarketingkampagnen();
        updateMafos();
        // TODO Kosten weitergeben
        // TODO impact weitergeben
    }

    @Override
    public float getKosten(){
        float taeglichKosten = 0;
        for (Map.Entry<String, Marketingkampagne> kampagne : this.kampagnen.entrySet()) {
            taeglichKosten += kampagne.getValue().getKosten();
        }
        for (Map.Entry<Integer, Marktforschung> mafo : this.mafos.entrySet()){
            taeglichKosten += mafo.getValue().getKosten();
        }
        return taeglichKosten;
    }

    // Hilfsmethoden:
    /**
     * zählt die verbleibende Laufzeit runter und löscht Projekt, wenn Laufzeit vorbei
     */
    private void updateMarketingkampagnen() {
        for (Map.Entry<String, Marketingkampagne> kampagne : this.kampagnen.entrySet()) {
            int bisherigeLaufzeit = kampagne.getValue().getLaufzeit();
            kampagne.getValue().setLaufzeit(bisherigeLaufzeit - 1);
            if (kampagne.getValue().getLaufzeit() == 0) {
                // TODO impact weitergeben
                this.kampagnen.remove(kampagne.getKey());
            }
        }
    }

    /**
     * zählt die verbleibende Dauer runter und löscht Projekt, wenn Dauer vorbei
     */
    private void updateMafos(){
        for (Map.Entry<Integer, Marktforschung> mafo : this.mafos.entrySet()){
            int dauer = mafo.getValue().getDauer();
            mafo.getValue().setDauer(dauer - 1);
            if (mafo.getValue().getDauer() == 0){
                // TODO impact weitergeben
                this.mafos.remove(mafo.getKey());
            }
        }
    }

}
