package local.ytk.g.platformer1.level.entity;

import local.ytk.g.platformer1.level.entity.controller.EntityController;
import local.ytk.g.platformer1.level.entity.state.EntityState;
import local.ytk.g.platformer1.math.CollisionBox;

import static local.ytk.g.platformer1.level.entity.state.EntityState.*;

import com.epagagames.particles.Emitter;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh.Type;

import local.ytk.g.platformer1.client.render.GameMaterials;
import local.ytk.g.platformer1.level.LevelInstance;

public abstract class LivingEntity extends GameEntity {
    public EntityState state;
    public int width;
    public int height;
    public boolean flipped;
    protected EntityController<LivingEntity> controller;

    public LivingEntity(String name, double multiplier, LevelInstance level) {
        super(name, multiplier, level);
    }
    
    @Override
    public byte forwardVal() {
        return (byte)(flipped ? -1 : 1);
    }

    public void crouch() {
        if (state == STANDING) state = CROUCHING;
    }
    public void stand() {
        if (state == CROUCHING) state = STANDING;
    }
    public void jump() {
        x().velocity(x().velocity() + 15);
        state = JUMPING_UP;
    }

    public boolean isAtWall() {
        goForward();
        boolean colliding = collidingWithLevel();
        goBackward();
        return colliding;
    }
    public boolean isAtEdge() {
        transform.move(forwardVal() * width, -1, 0);
        boolean colliding = collidingWithLevel();
        transform.move(-forwardVal() * width, 1, 0);
        return colliding;
    }

    public void emitParticles(String name, Type type, int count) {
        new ParticleEmitter(name, type, count).emitAllParticles();

        new Emitter(name, GameMaterials.Blue, count);
    }

    public void kill() {
        emitParticles(null, Type.Triangle, height);
        node.removeFromParent();
    }

    public void tick() {
        super.tick();
        if (y().velocity() < 0) {
            if (state == WALL_SLIDING);
            if (state == JUMPING_UP) state = JUMPING_DOWN;
            else state = FALLING;
        };
        controller.move(this);
    }

    public boolean colliding(CollisionBox box) {
        return collisionBox.colliding(box);
    }
    public boolean colliding(GameEntity entity) {
        return collisionBox.colliding(entity.collisionBox);
    }
}
