package local.ytk.g.platformer1.level.entity.player;

import local.ytk.g.platformer1.client.render.model.ModelData;
import local.ytk.g.platformer1.data.Identifier;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.entity.LivingEntity;

public abstract class Player extends LivingEntity {
    public static final ModelData.ModelLoader MODEL_LOADER = new ModelData.ModelLoader("Entities/Player/player.j3m", "Entities/Player/player.glb");
    static Identifier ID = Identifier.ofDefault("player");
    public Player(String name, LevelInstance level) {
        super(name, 0.8, level);
    }
}
