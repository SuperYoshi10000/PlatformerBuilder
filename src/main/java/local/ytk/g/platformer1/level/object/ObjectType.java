package local.ytk.g.platformer1.level.object;

import com.jme3.asset.AssetManager;

import local.ytk.g.platformer1.data.Identifier;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.math.Transform;

public interface ObjectType<O extends LevelObject> {
    O create(LevelInstance instance, Transform transform, AssetManager assetManager);

    Identifier getName();
}
