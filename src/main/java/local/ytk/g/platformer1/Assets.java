package local.ytk.g.platformer1;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import local.ytk.g.platformer1.level.loader.DefaultLevelLoader;
import local.ytk.g.platformer1.level.loader.LevelLoader;
import local.ytk.util.annotation.Static;

@Static
public final class Assets {
    private Assets() {}
    
    private static AssetManager assetManager;
    
    public static AssetManager assetManager() {
        return assetManager;
    }
    
    static AssetManager useAssetManager(AssetManager assetManager) {
        if (Assets.assetManager != null && assetManager != null) throw new IllegalStateException("Already defined asset manager");
        return Assets.assetManager = assetManager;
    }
    
    static void initAssetManager() {
        assetManager.registerLocator("./data/levels", FileLocator.class);
        assetManager.registerLoader(DefaultLevelLoader.class, "level");
    }
}
