package local.ytk.g.platformer1.level.phys;

import local.ytk.g.platformer1.data.tag.DoubleTag;
import local.ytk.g.platformer1.data.tag.Tag;
import local.ytk.g.platformer1.data.tag.TagRepresentable;
import local.ytk.g.platformer1.level.time.Tickable;

public class PhysVal extends Number implements Tickable, TagRepresentable {
    public double value = 0;
    public double velocity = 0;
    public double acceleration = 0;
    public double multiplier = 0;

    @Override
    public double doubleValue() {
        return value;
    }
    @Override
    public float floatValue() {
        return (float) value;
    }
    @Override
    public int intValue() {
        return (int) value;
    }
    @Override
    public long longValue() {
        return (long) value;
    }

    public PhysVal value(double value){
        this.value = value;
        return this;
    }
    public PhysVal velocity(double value){
        this.velocity = value;
        return this;
    }
    public PhysVal acceleration(double value){
        this.acceleration = value;
        return this;
    }
    public PhysVal multiplier(double value){
        this.multiplier = value;
        return this;
    }

    @Override
    public void tick() {
        value *= multiplier;
        velocity += acceleration;
        value += velocity;
    }
    @Override
    public Tag saveToTag() {
        return DoubleTag.of(value);
    }
    public static PhysVal readFromTag(DoubleTag tag) {return null;}
}
