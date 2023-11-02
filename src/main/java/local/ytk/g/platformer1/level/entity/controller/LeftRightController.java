package local.ytk.g.platformer1.level.entity.controller;

import local.ytk.g.platformer1.level.entity.LivingEntity;

public class LeftRightController<E extends LivingEntity> implements EntityController<E> {
    public boolean flipAtEdge;
    @Override
    public void move(E entity) {
        entity.moveForward();
        if (entity.isAtWall() || (flipAtEdge && entity.isAtEdge())) entity.flipped = !entity.flipped;
    }
    
}
