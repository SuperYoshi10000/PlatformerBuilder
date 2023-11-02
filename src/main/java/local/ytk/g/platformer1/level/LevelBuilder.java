package local.ytk.g.platformer1.level;

import javax.annotation.Nullable;

import com.jme3.scene.Node;

import local.ytk.g.platformer1.Platformer1;
import local.ytk.g.platformer1.client.render.model.ModelData;
import local.ytk.g.platformer1.level.entity.GameEntity;
import local.ytk.g.platformer1.level.entity.GameEntityType;

public abstract class LevelBuilder {
    protected String name;
    @Nullable
    public LevelInstance level;

    ModelData.ModelLoader model;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LevelInstance load() {
        LevelInstance level = new LevelInstance();
        Node rootNode = Platformer1.app().getRootNode();
        setup(GameEntityType.placer(level, rootNode));
        return level;
    }
    public abstract void setup(
        LevelPlacer<GameEntity, GameEntityType<GameEntity>> entities
    );
}
