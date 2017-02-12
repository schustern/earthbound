package Exceptions;

/**
 * Exception, die beim Kaufen von Maschinen geworfen wird, falls nicht gengend Maschinenstellpltze (= Produktionshallen) vorhanden sind
 * Created by lucadommes on 19.01.2017.
 */
public class ZuWenigMaschinenstellplatzException extends Exception {

    public ZuWenigMaschinenstellplatzException() {
        super("Es sind zu wenige Maschinenstellpltze vorhanden! Kaufen Sie eine weitere Produktionshalle");
    }

}
