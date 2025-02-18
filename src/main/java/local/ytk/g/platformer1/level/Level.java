package local.ytk.g.platformer1.level;

import com.jme3.asset.AssetManager;
import local.ytk.g.platformer1.data.Identifier;
import local.ytk.g.platformer1.data.tag.CompoundTag;

import java.util.Objects;

public record Level(Identifier id, CompoundTag levelData) {
    public LevelInstance instance() {
        return new LevelInstance(this);
    }
    
    @Override
    public String toString() {
        return "Level(%s)".formatted(id);
    }
}
