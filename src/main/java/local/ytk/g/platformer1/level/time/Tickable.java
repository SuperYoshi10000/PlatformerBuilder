package local.ytk.g.platformer1.level.time;

@FunctionalInterface
public interface Tickable {
    public void tick();
    public default void tickOn(Ticker ticker) {
        ticker.add(this);
    }
}
