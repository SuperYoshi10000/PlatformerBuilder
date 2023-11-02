package local.ytk.g.platformer1.level.entity.controller;

import local.ytk.g.platformer1.level.entity.player.Player;
import static local.ytk.g.platformer1.client.window.input.UserInputHandler.*;

public class PlayerController implements EntityController<Player> {
    @Override
    public void move(Player player) {
        if (LEFT.active()) player.moveLeft();
        if (RIGHT.active()) player.moveRight();
        if (JUMP.wasPressed()) player.jump();
        if (CROUCH.active()) player.crouch();
        else player.stand();
    }
}
