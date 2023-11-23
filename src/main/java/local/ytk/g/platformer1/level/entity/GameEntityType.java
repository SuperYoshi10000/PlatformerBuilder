package local.ytk.g.platformer1.level.entity;

import java.util.function.Function;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;

import local.ytk.g.platformer1.client.render.model.ModelData;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.LevelPlacer;
import local.ytk.g.platformer1.level.entity.player.LocalPlayer;
import local.ytk.g.platformer1.level.entity.player.Player;
import local.ytk.g.platformer1.level.phys.Position3d;

public class GameEntityType<E extends GameEntity> implements PlaceableObject<E> {
    protected final Function<LevelInstance, E> getter;
    public ModelData.ModelLoader model;

    public GameEntityType(Function<LevelInstance, E> getter) {
        this.getter = getter;
    }
    public E create(LevelInstance level, Position3d pos, AssetManager assetManager, Node rootNode) {
        E entity = getter.apply(level);
        entity.model = model.loadTo(assetManager, null);
        return entity;
    }
    public static LevelPlacer<GameEntity, GameEntityType<GameEntity>> placer(LevelInstance level, Node rootNode) {
        return new LevelPlacer<>(level);
    }

    public static final GameEntityType<Player> PLAYER = new GameEntityType<>(l -> new LocalPlayer(l));
}
