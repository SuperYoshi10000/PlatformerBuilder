package local.ytk.g.platformer1.math;

import local.ytk.g.platformer1.data.tag.TagRepresentable;
import local.ytk.g.platformer1.level.time.Tickable;

public interface PhysVal extends Tickable, TagRepresentable {
    PhysVal value(double value);
    PhysVal velocity(double value);
    PhysVal acceleration(double value);
    PhysVal multiplier(double value);
    
    default PhysVal valueAdd(double value) { return value(value() + value); }
    default PhysVal velocityAdd(double value) { return value(value() + value); }
    default PhysVal accelerationAdd(double value) { return value(value() + value); }
    default PhysVal multiplierAdd(double value) { return value(value() + value); }
    
    default PhysVal valueSub(double value) { return value(value() - value); }
    default PhysVal velocitySub(double value) { return value(value() - value); }
    default PhysVal accelerationSub(double value) { return value(value() - value); }
    default PhysVal multiplierSub(double value) { return value(value() - value); }
    
    default PhysVal valueMul(double value) { return value(value() * value); }
    default PhysVal velocityMul(double value) { return value(value() * value); }
    default PhysVal accelerationMul(double value) { return value(value() * value); }
    default PhysVal multiplierMul(double value) { return value(value() * value); }
    
    default PhysVal valueDiv(double value) { return value(value() / value); }
    default PhysVal velocityDiv(double value) { return value(value() / value); }
    default PhysVal accelerationDiv(double value) { return value(value() / value); }
    default PhysVal multiplierDiv(double value) { return value(value() / value); }
    
    double value();
    double velocity();
    double acceleration();
    double multiplier();
}
