package iview.wsienski.androidtestintegration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
public class Scores {
    Map<String, String> scoeres;

    public Scores() {
        scoeres = new HashMap<String, String>();
    }
    public void add(final String name, final String score) {
        scoeres.put(name, score);
    }
    public String getScore(final String name) {
        return scoeres.get(name);
    }
}
