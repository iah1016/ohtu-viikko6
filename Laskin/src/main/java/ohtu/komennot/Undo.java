
package ohtu.komennot;

/**
 *
 * @author Ilja Häkkinen
 */
public class Undo implements Komento {

    @Override
    public void suorita() {
        System.out.println("undo pressed");
    }
    
    @Override
    public void peru() {
    }
    
}
