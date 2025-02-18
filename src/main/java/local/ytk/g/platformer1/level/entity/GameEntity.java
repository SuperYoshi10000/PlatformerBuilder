package local.ytk.g.platformer1.level.entity;

import com.jme3.collision.Collidable;
import com.jme3.collision.CollisionResults;
import com.jme3.scene.Node;
import local.ytk.g.platformer1.Platformer1;
import local.ytk.g.platformer1.client.render.model.ModelData;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.math.CollisionBox;
import local.ytk.g.platformer1.level.object.LocatableLevelObject;
import local.ytk.g.platformer1.level.object.Movable;

public abstract class GameEntity extends LocatableLevelObject implements Collidable, Movable {
    public final LevelInstance level;
    protected CollisionBox collisionBox;
    
    public Node node;
    public ModelData model;
    
    public GameEntity(String name, double multiplier, LevelInstance level) {
        super();
        this.level = level;
        this.node = new Node(name);
    }
    
    @Override
    public LevelInstance getLevelInstance() {
        return level;
    }

    @Override
    public Node node() {
        return node;
    }
    
    @Override
    public void goLeft() {
        x().valueSub(1);
    }
    @Override
    public void goRight() {
        x().valueAdd(1);
    }
    @Override
    public void goForward() {
        x().valueAdd(forwardVal());
    }
    @Override
    public void goBackward() {
        x().valueSub(forwardVal());
    }
    @Override
    public void moveLeft() {
        x().velocitySub(1);
    }
    @Override
    public void moveRight() {
        x().velocityAdd(1);
    }
    @Override
    public void moveForward() {
        x().velocityAdd(forwardVal());
    }
    @Override
    public void moveBackward() {
        x().velocitySub(forwardVal());
    }
    @Override
    public void stopMotion() {
        x().velocity(0);
    }
    @Override
    public void accelLeft() {
        x().acceleration(-1);
    }
    @Override
    public void accelRight() {
        x().acceleration(1);
    }
    @Override
    public void accelForward() {
        x().acceleration(forwardVal());
    }
    @Override
    public void accelBackward() {
        x().acceleration(-forwardVal());
    }
    @Override
    public void stopAcceleration() {
        x().acceleration(0);
    }
    
    @Override
    public void tick() {
        // node.setPosition(x().floatValue(), y.floatValue(), z.floatValue());
        // node.setDirection(0, 0, 0);
    }


    public int collideWith(Collidable other, CollisionResults results) {
        return node.collideWith(other, results);
    }
    public boolean collidingWithLevel() {
        return Platformer1.app().getLevelDataNode().collideWith(node, new CollisionResults()) > 0;
    }
}
