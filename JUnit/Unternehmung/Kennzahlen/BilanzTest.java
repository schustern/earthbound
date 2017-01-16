package Unternehmung.Kennzahlen;

import Unternehmung.Unternehmen;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by D064018 on 16.01.2017.
 */
public class BilanzTest extends TestCase{

    private Bilanz testBilanz;
    private GuV guv;

    @Before
    public void bilanzErstellen(){
        Unternehmen testUnternehmen = new Unternehmen( "Test Unternehmen", "12345", 600000);
        testBilanz = new Bilanz(testUnternehmen);
        guv = new GuV(testUnternehmen);
        assertNotNull(testBilanz);
    }


    @Test
    public void berechnen() throws Exception {

    }

    @Test
    public void addEigenkapital() throws Exception {

    }

    @Test
    public void addLiquideMittel() throws Exception {

    }

    @Test
    public void getGuv() throws Exception {
assertEquals(testBilanz.getGuv(), guv);
    }

    @Test
    public void setGuv() throws Exception {
        testBilanz.setGuv(guv);
assertSame(testBilanz.getGuv(), guv);
    }

    @Test
    public void getTaMaschWert() throws Exception {
        double neuerTaMaschWert = 30500;
        testBilanz.setTaMaschWert(neuerTaMaschWert);
assertEquals(testBilanz.getTaMaschWert(), neuerTaMaschWert);
    }

  //  @Test
    //  public void setTaMaschWert() throws Exception {    }

    @Test
    public void getGebäudeWert() throws Exception {
        double neuerGebäudeWert = 100000;
        testBilanz.setGebäudeWert(neuerGebäudeWert);
        assertEquals(testBilanz.getGebäudeWert(), neuerGebäudeWert);
    }

  //  @Test
 //   public void setGebäudeWert() throws Exception {    }

    @Test
    public void getFEWert() throws Exception {
        double neuerFEWert = 30500;
        testBilanz.setFEWert(neuerFEWert);
        assertEquals(testBilanz.getFEWert(), neuerFEWert);
    }

 //   @Test
   // public void setFEWert() throws Exception {}

    @Test
    public void getLiquideMittel() throws Exception {
        double neueLiquideMittel = 30500;
        testBilanz.setLiquideMittel(neueLiquideMittel);
        assertEquals(testBilanz.getLiquideMittel(), neueLiquideMittel);
    }

 //   @Test
   // public void setLiquideMittel() throws Exception {}

    @Test
    public void getEigenkapital() throws Exception {
        double neuesEigenkapital = 30500;
        testBilanz.setEigenkapital(neuesEigenkapital);
        assertEquals(testBilanz.getEigenkapital(), neuesEigenkapital);
    }

   // @Test
    //public void setEigenkapital() throws Exception {}

    @Test
    public void getFremdkapital() throws Exception {
        double neuesFremdkapital = 30500;
        testBilanz.setFremdkapital(neuesFremdkapital);
        assertEquals(testBilanz.getFremdkapital(), neuesFremdkapital);
    }

  //  @Test
   // public void setFremdkapital() throws Exception {}

}