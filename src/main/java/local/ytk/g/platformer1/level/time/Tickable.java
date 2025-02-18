package local.ytk.g.platformer1.level.time;

@FunctionalInterface
public interface Tickable {
    void tick();
    default Tickable tickOn(Ticker ticker) {
        ticker.add(this);
        return this;
    }
}
