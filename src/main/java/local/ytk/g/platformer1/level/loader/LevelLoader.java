package local.ytk.g.platformer1.level.loader;

import com.jme3.asset.AssetInfo;
import com.jme3.asset.AssetKey;
import com.jme3.asset.AssetLoader;
import local.ytk.g.platformer1.level.Level;
import local.ytk.g.platformer1.level.LevelInstance;

import java.io.IOException;

public interface LevelLoader extends AssetLoader {
    @Override
    LevelInstance load(AssetInfo assetInfo) throws IOException;
}
