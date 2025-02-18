package local.ytk.g.platformer1.level.entity.player;

import local.ytk.g.platformer1.data.Identifier;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.entity.EntityType;
import local.ytk.g.platformer1.level.object.ObjectProperty;

public class LocalPlayer extends Player {
    public static final EntityType<LocalPlayer> LOCAL_PLAYER = new EntityType<>(LocalPlayer::new) {
        @Override
        public Identifier getName() {
            return ID;
        }
    };
    public static LocalPlayer PLAYER;
    public LocalPlayer(LevelInstance level) {
        super("Player", level);
    }
    
    @Override
    public <T> void setProperty(ObjectProperty<?, T> property, T value) {
    
    }
}
