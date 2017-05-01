package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author Ilja Häkkinen
 */
public class Summa extends Laskutoimitus {

    private Sovelluslogiikka sovellus;

    public Summa(Sovelluslogiikka sovellus,
            JTextField syotekentta, JTextField tuloskentta) {
        super(sovellus, syotekentta, tuloskentta);
        this.sovellus = sovellus;
    }

    @Override
    protected void laske(int arvo) {
        sovellus.plus(arvo);
    }

}
