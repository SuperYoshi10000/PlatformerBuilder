package local.ytk.g.platformer1.level.time;

import java.util.ArrayList;

public class Ticker implements Tickable {
    protected final ArrayList<Tickable> actions = new ArrayList<>();
    @Override
    public void tick() {
        actions.forEach(Tickable::tick);
    }
    public void add(Tickable tickable) {
        actions.add(tickable);
    }
}
