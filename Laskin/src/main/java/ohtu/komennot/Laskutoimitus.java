package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author Ilja Häkkinen
 */
public abstract class Laskutoimitus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField syotekentta;
    private JTextField tuloskentta;
    private int edellinenArvo;

    public Laskutoimitus(Sovelluslogiikka sovellus,
            JTextField syotekentta, JTextField tuloskentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        edellinenArvo = sovellus.tulos();
        laske(otaArvoSyotekentasta());
        paivitaKentat();
    }

    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinenArvo);
        paivitaKentat();
    }

    private void paivitaKentat() {
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
    private int otaArvoSyotekentasta() {
        try {
            return Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    protected abstract void laske(int arvo);
}
