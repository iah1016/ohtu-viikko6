package ohtu;

import ohtu.komennot.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tapahtumankuuntelija implements ActionListener {

    private JButton nollaa;
    private JButton undo;
    private Sovelluslogiikka sovellus;
    private Map<JButton, Komento> komennot;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa,
            JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<>();
        komennot.put(plus, new Summa(sovellus, syotekentta, tuloskentta));
        komennot.put(miinus, new Erotus(sovellus, syotekentta, tuloskentta));
        komennot.put(nollaa, new Nollaus(sovellus, syotekentta, tuloskentta));
        komennot.put(undo, new Undo());
        this.nollaa = nollaa;
        this.undo = undo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Komento komento = komennot.get(ae.getSource());
        komento.suorita();

        nollaa.setEnabled(sovellus.tulos() != 0);
        undo.setEnabled(true);
    }

}
