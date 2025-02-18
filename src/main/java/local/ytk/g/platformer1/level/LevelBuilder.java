package local.ytk.g.platformer1.level;

import javax.annotation.Nullable;

import com.jme3.scene.Node;

import local.ytk.g.platformer1.Platformer1;
import local.ytk.g.platformer1.client.render.model.ModelData;
import local.ytk.g.platformer1.level.entity.GameEntity;
import local.ytk.g.platformer1.level.entity.EntityType;
import local.ytk.g.platformer1.level.object.ObjectPlacer;

public abstract class LevelBuilder {
    protected String name;
    @Nullable
    public Level level;

    ModelData.ModelLoader model;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LevelInstance load() {
        LevelInstance instance = new LevelInstance(level);
        Node rootNode = Platformer1.app().getRootNode();
        setup(EntityType.placer(instance, rootNode));
        return instance;
    }
    public abstract void setup(
        ObjectPlacer<GameEntity, EntityType<GameEntity>> entities
    );
}
