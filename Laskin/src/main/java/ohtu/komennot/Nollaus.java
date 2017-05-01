package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author Ilja Häkkinen
 */
public class Nollaus extends Laskutoimitus {

    private Sovelluslogiikka sovellus;

    public Nollaus(Sovelluslogiikka sovellus,
            JTextField syotekentta, JTextField tuloskentta) {
        super(sovellus, syotekentta, tuloskentta);
        this.sovellus = sovellus;
    }

    @Override
    protected void laske(int arvo) {
        sovellus.nollaa();
    }

}
