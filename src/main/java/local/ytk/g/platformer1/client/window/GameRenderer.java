package local.ytk.g.platformer1.client.window;

public class GameRenderer {
    public static final String GR_NAME = "GameRenderer";

    // public static final ApplicationContext context = new ApplicationContext(GameWindow.DEFAULT_NAME);
    // public static final Root root = context.getRoot();
    // public static final SceneManager sceneManager = root.createSceneManager();
    // public static final SceneNode rootSceneNode = sceneManager.getRootSceneNode();
    // public static final ShaderGenerator shaderGenerator = ShaderGenerator.getSingleton();

    // public static final Light light = create(sceneManager::createLight, "MainLight");
    // public static final Camera camera = create(sceneManager::createCamera, c -> {
    //     c.setNearClipDistance(5);
    //     c.setAutoAspectRatio(true);
    // }, "MainCamera");

    // public static final SceneNode lightNode = node(light, 0, 10, 15);
    // public static final SceneNode cameraNode = node(camera, c -> c.lookAt(new Vector3(0, 0, -1), Node.TransformSpace.TS_PARENT), 0, 0, 15);
    
    // // creating objects
    // public static <M extends MovableObject> M create(Function<String, M> generator, String name) {
    //     return generator.apply(GR_NAME + ":" + name);
    // }
    // public static <M extends MovableObject> M create(Function<String, M> generator, Modifier<M> callback, String name) {
    //     return callback.apply(generator.apply(GR_NAME + ":" + name));
    // }

    // // creating nodes
    // public static SceneNode node() {
    //     return sceneManager.createSceneNode();
    // }
    // public static SceneNode node(MovableObject object) {
    //     SceneNode node = node();
    //     node.attachObject(object);
    //     return node;
    // }
    // public static SceneNode node(MovableObject object, float x, float y, float z) {
    //     SceneNode node = node(object);
    //     node.setPosition(x, y, z);
    //     return node;
    // }
    // public static SceneNode node(MovableObject object, Modifier<SceneNode> callback, float x, float y, float z) {
    //     return callback.apply(node(object, x, y, z));
    // }

    public static void init() {
    //     shaderGenerator.addSceneManager(sceneManager);
    //     context.getRenderWindow().addViewport(camera);
    }
    protected GameRenderer() {}

    
}
