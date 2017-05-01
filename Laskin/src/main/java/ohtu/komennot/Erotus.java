package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author Ilja Häkkinen
 */
public class Erotus extends Laskutoimitus {

    private Sovelluslogiikka sovellus;

    public Erotus(Sovelluslogiikka sovellus,
            JTextField syotekentta, JTextField tuloskentta) {
        super(sovellus, syotekentta, tuloskentta);
        this.sovellus = sovellus;
    }

    @Override
    protected void laske(int arvo) {
        sovellus.miinus(arvo);
    }
}
