package local.ytk.g.platformer1.level.entity;

import local.ytk.g.platformer1.level.LevelInstance;

public abstract class NonlivingEntity extends GameEntity {
    public NonlivingEntity(String name, LevelInstance level) {
        super(name, 0.8, level);
    }
    
}
