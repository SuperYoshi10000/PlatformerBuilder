package local.ytk.g.platformer1.level.entity.player;

import local.ytk.g.platformer1.client.render.model.ModelData.ModelLoader;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.entity.GameEntityType;

public class LocalPlayer extends Player {
    public static final GameEntityType<LocalPlayer> TYPE = new GameEntityType<>(level -> new LocalPlayer(level));
    public static final ModelLoader MODEL_LOADER = new ModelLoader("Entities/Player/material.j3m", "Entities/Player/model.");
    public static LocalPlayer PLAYER;
    public LocalPlayer(LevelInstance level) {
        super("Player", level);
    }
}
