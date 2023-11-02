package local.ytk.g.platformer1.level.time;

import java.util.ArrayList;

public class Ticker implements Tickable {
    private final ArrayList<Tickable> actions = new ArrayList<>();
    @Override
    public void tick() {
        actions.forEach(a -> a.tick());
    }
    public void add(Tickable tickable) {
        actions.add(tickable);
    }
}
