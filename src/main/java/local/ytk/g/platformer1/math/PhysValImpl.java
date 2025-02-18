package local.ytk.g.platformer1.math;

import local.ytk.g.platformer1.data.tag.DoubleTag;
import local.ytk.g.platformer1.data.tag.Tag;

public class PhysValImpl implements PhysVal {
    public double value = 0;
    public double velocity = 0;
    public double acceleration = 0;
    public double multiplier = 0;

    public double doubleValue() {
        return value;
    }
    public float floatValue() {
        return (float) value;
    }
    public int intValue() {
        return (int) value;
    }
    public long longValue() {
        return (long) value;
    }

    @Override
    public PhysVal value(double value){
        this.value = value;
        return this;
    }
    @Override
    public PhysVal velocity(double value){
        this.velocity = value;
        return this;
    }
    @Override
    public PhysVal acceleration(double value){
        this.acceleration = value;
        return this;
    }
    @Override
    public PhysValImpl multiplier(double value){
        this.multiplier = value;
        return this;
    }

    @Override
    public void tick() {
        value *= multiplier;
        velocity += acceleration;
        value += velocity;
    }
    public Tag toTag() {
        return DoubleTag.of(value);
    }
    public static PhysVal readFromTag(DoubleTag tag) {return null;}
    
    @Override
    public double value() {
        return value;
    }
    @Override
    public double velocity() {
        return velocity;
    }
    @Override
    public double acceleration() {
        return acceleration;
    }
    @Override
    public double multiplier() {
        return multiplier;
    }
}
