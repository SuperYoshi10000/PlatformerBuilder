package local.ytk.g.platformer1.level.entity.controller;

import local.ytk.g.platformer1.level.entity.LivingEntity;

@FunctionalInterface
public interface EntityController<E extends LivingEntity> {
    public void move(E entity);
    public default int frame() {
        return 0;
    }
}
