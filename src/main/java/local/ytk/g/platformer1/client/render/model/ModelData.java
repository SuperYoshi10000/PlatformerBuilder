package local.ytk.g.platformer1.client.render.model;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class ModelData {
    public Material material;
    public Spatial model;

    public static class ModelLoader {
        public String materialPath;
        public String modelPath;

        public ModelLoader(String material, String model) {
            super();
            materialPath = material;
            modelPath = model;
        }

        public ModelLoader material(String materialPath) {
            this.materialPath = materialPath;
            return this;
        }
        public ModelLoader model(String modelPath) {
            this.modelPath = modelPath;
            return this;
        }

        public ModelData load(AssetManager assetManager, Node rootNode) {
            ModelData modelData = new ModelData();
            modelData.material = assetManager.loadMaterial(materialPath);
            modelData.model = assetManager.loadModel(modelPath);

            modelData.model.setMaterial(modelData.material);
            rootNode.attachChild(modelData.model);

            return modelData;
        }
    }

    public static ModelLoader loader(String material, String model) {
        return new ModelLoader(material, model);
    }
}
