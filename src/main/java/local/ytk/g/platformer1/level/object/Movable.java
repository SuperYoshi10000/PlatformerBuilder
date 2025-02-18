package local.ytk.g.platformer1.level.object;

import local.ytk.g.platformer1.level.entity.HasTransform;

public interface Movable extends HasTransform {
    void goLeft();
    void goRight();
    void goForward();
    void goBackward();
    void moveLeft();
    void moveRight();
    void moveForward();
    void moveBackward();
    void stopMotion();
    void accelLeft();
    void accelRight();
    void accelForward();
    void accelBackward();
    void stopAcceleration();
}
