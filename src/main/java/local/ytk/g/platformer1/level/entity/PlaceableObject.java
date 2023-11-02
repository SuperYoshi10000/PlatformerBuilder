package local.ytk.g.platformer1.level.entity;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;

import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.LevelObject;
import local.ytk.g.platformer1.level.phys.Position3d;

public interface PlaceableObject<O extends LevelObject> {
    public O create(LevelInstance level, Position3d position, AssetManager assetManager, Node rootNode);
}
