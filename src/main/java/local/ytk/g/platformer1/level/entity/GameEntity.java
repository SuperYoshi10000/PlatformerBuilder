package local.ytk.g.platformer1.level.entity;

import com.jme3.collision.Collidable;
import com.jme3.collision.CollisionResults;
import com.jme3.scene.Node;
import local.ytk.g.platformer1.Platformer1;
import local.ytk.g.platformer1.client.render.model.ModelData;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.LevelObject;
import local.ytk.g.platformer1.level.phys.CollisionBox;
import local.ytk.g.platformer1.level.phys.Position3d;

public abstract class GameEntity extends Position3d implements LevelObject, Collidable {
    public final LevelInstance level;
    protected CollisionBox collisionBox;
    
    public Node node;
    public ModelData model;
    
    public GameEntity(String name, double multiplier, LevelInstance level) {
        super(0.8);
        this.level = level;
        this.node = new Node();
    }
    
    @Override
    public LevelInstance getLevel() {
        return level;
    }
    
    @Override
    public void tick() {
        // node.setPosition(x.floatValue(), y.floatValue(), z.floatValue());
        // node.setDirection(0, 0, 0);
    }
    public int collideWith(Collidable other, CollisionResults results) {
        return node.collideWith(other, results);
    }
    public boolean collidingWithLevel() {
        return Platformer1.app().getLevelDataNode().collideWith(node, new CollisionResults()) > 0;
    }
}
