package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println();
        m = new And(new Or(new HasFewerThan(4, "goals"),
                new HasFewerThan(9, "assists")),
                new PlaysIn("DET")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        System.out.println();
        m = new And(new HasAtLeast(40, "goals"),
                new HasAtLeast(20, "assists"),
                new Not(new PlaysIn("WSH"))
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
