package local.ytk.g.platformer1.level.entity.player;

import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.entity.LivingEntity;

public abstract class Player extends LivingEntity {
    public Player(String name, LevelInstance level) {
        super(name, 0.8, level);
    }

    
}
