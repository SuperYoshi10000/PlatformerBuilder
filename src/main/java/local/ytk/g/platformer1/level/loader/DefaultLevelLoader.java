package local.ytk.g.platformer1.level.loader;

import com.jme3.asset.AssetInfo;
import com.jme3.asset.AssetKey;
import com.jme3.asset.AssetManager;
import local.ytk.g.platformer1.Assets;
import local.ytk.g.platformer1.data.tag.CompoundTag;
import local.ytk.g.platformer1.level.Level;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.util.annotation.Singleton;

import java.io.IOException;
import java.io.InputStream;

@Singleton
public final class DefaultLevelLoader implements LevelLoader {
    public static LevelLoader INSTANCE;
    public final AssetManager assetManager;

    private DefaultLevelLoader() {
        assetManager = Assets.assetManager();
        INSTANCE = this;
    }
    
    public static LevelLoader getInstance() {
        return INSTANCE;
    }
    
    @Override
    public LevelInstance load(AssetInfo assetInfo) throws IOException {
        try (InputStream stream = assetInfo.openStream()) {
            String value = new String(stream.readAllBytes());
            
        }
        return null;
    }
}
