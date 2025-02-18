package local.ytk.g.platformer1.level.entity.state;

import java.util.Map;

import local.ytk.g.platformer1.math.Position3d;

import static local.ytk.g.platformer1.level.entity.state.EntityModelPart.*;

public enum EntityState {
    // standing
    STANDING(),
    // waiting
    WAITING_1(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WAITING_2(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WAITING_3(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WAITING_4(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),

    // walking
    WALKING_1(
		e(ARM_LEFT, 0, 0, 0, 0, 15, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 15, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 35, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 35, 0)
	),
    WALKING_2(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WALKING_3(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WALKING_4(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WALKING_5(
		e(ARM_LEFT, 0, 0, 0, 0, 15, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 15, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 35, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 35, 0)
	),
    WALKING_6(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WALKING_7(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WALKING_8(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    WALKING_9(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),

    // running
    RUNNING_1(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 35, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 35, 0)
	),
    RUNNING_2(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    RUNNING_3(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    RUNNING_4(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    RUNNING_5(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 35, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 35, 0)
	),
    RUNNING_6(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    RUNNING_7(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    RUNNING_8(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    RUNNING_9(
		e(ARM_LEFT, 0, 0, 0, 0, -90, 50),
		e(ARM_RIGHT, 0, 0, 0, 0, -90, -50),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),

    // turning
    TURNING_1(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    TURNING_2(
		e(ARM_LEFT, 0, 0, 0, 0, 90, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 90, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    TURNING_3(
		e(ARM_LEFT, 0, 0, 0, 0, 90, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 90, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),

    // in air
    JUMPING_UP(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    JUMPING_DOWN(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    FALLING(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),

    // misc
    SLIDING(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, -75),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, -75)
	),
    PUSHING(
		e(ARM_LEFT, 0, 0, 0, 0, 0, -90),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, -90),
		e(LEG_LEFT, 0, 0, 0, 0, 20, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 20, 0)
	),
    WALL_SLIDING(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),
    SLOWING_DOWN(
		e(ARM_LEFT, 0, 0, 0, 0, 0, -30),
		e(ARM_RIGHT, 0, 0, 0, 0, 30, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, -30),
        e(LEG_RIGHT, 0, 0, 0, 0, 30, 0)
	),
    LOOKING_UP(
		e(HEAD, 0, 0, 0, 0, 30, 0)
	),
    LOOKING_DOWN(
		e(HEAD, 0, 0, 0, 0, -30, 0)
	),

    // special
    CROUCHING(
		e(ARM_LEFT, 0, 0, 0, 0, 0, 0),
		e(ARM_RIGHT, 0, 0, 0, 0, 0, 0),
		e(LEG_LEFT, 0, 0, 0, 0, 0, 0),
        e(LEG_RIGHT, 0, 0, 0, 0, 0, 0)
	),

    // rolling
    ROLLING_1(),
    ROLLING_2(
        new Position3d().rotate(0, 45, 0)
	),
    ROLLING_3(
		new Position3d().rotate(0, 90, 0)
	),
    ROLLING_4(
		new Position3d().rotate(0, 135, 0)
	),
    ROLLING_5(
		new Position3d().rotate(0, 180, 0)
	),
    ROLLING_6(
		new Position3d().rotate(0, 225, 0)
	),
    ROLLING_7(
		new Position3d().rotate(0, 270, 0)
	),
    ROLLING_8(
		new Position3d().rotate(0, 315, 0)
	),
    
    ;

    public final Map<EntityModelPart, Position3d> modelData;
    public final Position3d modifier;

    @SafeVarargs
    private EntityState(Map.Entry<EntityModelPart, Position3d>... modelData) {
        this.modifier = null;
        this.modelData = Map.ofEntries(modelData);
    }
    @SafeVarargs
    private EntityState(Position3d modifier, Map.Entry<EntityModelPart, Position3d>... modelData) {
        this.modifier = modifier;
        this.modelData = Map.ofEntries(modelData);
    }
    
    static Map.Entry<EntityModelPart, Position3d> e(EntityModelPart p, double x, double y, double z, double yaw, double pitch, double roll) {
        return Map.entry(p, new Position3d().move(x, y, z).rotate(yaw, pitch, roll));
    }
}
