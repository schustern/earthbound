package Unternehmung.Abteilungen;

import Unternehmung.Kennzahlensammlung;
import Unternehmung.Unternehmen;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by D064018 on 16.01.2017.
 */
public class HRTest extends TestCase {

    private HR testHR;
    private Kennzahlensammlung kennzahlensammlung;
    private Unternehmen unternehmen;

    @Before
    public void createHR(){
        unternehmen = new Unternehmen("Test_Unternehmen", "12345", 500000);
        kennzahlensammlung = unternehmen.getKennzahlensammlung();
        testHR = new HR(unternehmen, kennzahlensammlung);
        assertNotNull(testHR);
    }

    @Test
    public void getTotalGehalt() throws Exception {
        unternehmen.getAbteilung("produktion").addMitarbeiter(1, 10000);
        assertEquals(testHR.getTotalGehalt(), 10000);
    }

    @Test
    public void getDurchschnittlichesGehalt() throws Exception {
        unternehmen.getAbteilung("produktion").addMitarbeiter(2, 10000);
        assertEquals(testHR.getDurchschnittlichesGehalt(), 10000);
    }

    @Test
    public void getTotalMitarbeiterCount() throws Exception {
        unternehmen.getAbteilung("produktion").addMitarbeiter(2, 10000);
        assertEquals(testHR.getTotalMitarbeiterCount(), 2);
    }

    @Test
    public void getTotalMitarbeiter() throws Exception {
        unternehmen.getAbteilung("produktion").addMitarbeiter(2, 10000);
        assertEquals(testHR.getTotalMitarbeiter(), unternehmen.getAbteilung("produktion").getMitarbeiter());
    }

    @Test
    public void update() throws Exception {

    }

}