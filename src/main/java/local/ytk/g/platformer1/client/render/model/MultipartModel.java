package local.ytk.g.platformer1.client.render.model;

import java.util.HashMap;
import java.util.Map;

import local.ytk.g.platformer1.client.render.Screen;
import local.ytk.g.platformer1.level.phys.Position3d;
import local.ytk.g.platformer1.util.SequentialCollector;

public class MultipartModel implements Model {
    public MultipartModel(Model baseModel, HashMap<ModelPart, Position3d> subModelParts, HashMap<ModelPart, Model> subModels) {
        super();
        this.baseModel = baseModel;
    
        subModels.forEach((k, v) -> this.subModels.put(k, v));
    }
    
    public final Model baseModel;
    public final HashMap<ModelPart, Position3d> subModelParts = new HashMap<>();
    public final HashMap<ModelPart, Model> subModels = new HashMap<>();

    @Override
    public ModelInstance instance() {
        return new Instance();
    }

    public class Instance implements ModelInstance {
        protected long frame;
        public final ModelInstance baseModelInstance = baseModel.instance();
        public final HashMap<ModelPart, ModelInstance> subModelInstances = subModels
            .entrySet().stream()
            .map(e -> (Map.Entry<ModelPart, ModelInstance>) Map.entry(e.getKey(), e.getValue().instance()))
            .collect(SequentialCollector.create(() -> new HashMap<>(), (a, b) -> a.put(b.getKey(), b.getValue())));

        public Instance() {
            super();
        }

        @Override
        public void render(Screen screen, Position3d position) {
            baseModelInstance.render(screen, position);
            // subModelInstances.forEach((p, m) -> screen.render(m, p));
        }

        @Override
        public void tick() {
            frame++;
            subModelInstances.forEach((k, v) -> v.tick());
        }
    }
}
