package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Ilja Häkkinen
 */
public class Not implements Matcher {

    private Matcher matcher;

    public Not(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Player p) {
        return !matcher.matches(p);
    }

}
