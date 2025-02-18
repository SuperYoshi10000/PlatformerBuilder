package local.ytk.g.platformer1.client.window;

import com.jme3.input.ChaseCamera;
import com.jme3.input.FlyByCamera;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Node;
import com.jme3.scene.control.CameraControl;
import local.ytk.g.platformer1.level.LevelInstance;

public class GameLevelWindow extends GameWindow {
    final LevelInstance level;
    Camera camera;
    FlyByCamera flyCam;
    ChaseCamera chaseCam;
    Node target;
    CameraNode camNode;
    Vector3f translation = new Vector3f(0, 5, -5);
    CamMode camMode = CamMode.FLY;

    public GameLevelWindow(LevelInstance level, Camera camera, FlyByCamera flyCam, ChaseCamera chaseCam) {
        this.level = level;
        this.camera = camera;
        this.flyCam = flyCam;
        this.camNode = new CameraNode("CameraNode", camera);
        this.chaseCam = chaseCam;

        camNode.setControlDir(CameraControl.ControlDirection.SpatialToCamera);
    }
    void target(Node newTarget) {
        target = newTarget;
    }

    void useNodeCam() {
        flyCam.setEnabled(false);
        chaseCam.setEnabled(false);
        camNode.setEnabled(true);
        camMode = CamMode.NODE;
    }
    void useNodeCam(Node newTarget) {
        flyCam.setEnabled(false);
        chaseCam.setEnabled(false);

        target = newTarget;
        target.attachChild(camNode);
        camNode.setLocalTranslation(translation);
        camNode.lookAt(target.getLocalTranslation(), Vector3f.UNIT_Y);
        camNode.setEnabled(true);
        camMode = CamMode.NODE;
    }
    void useChaseCam() {
        camNode.setEnabled(false);
        flyCam.setEnabled(false);
        chaseCam.setEnabled(true);
        camMode = CamMode.CHASE;
    }
    void useChaseCam(Node newTarget) {
        camNode.removeFromParent();
        camNode.setEnabled(false);
        flyCam.setEnabled(false);

        target = newTarget;
        chaseCam.setSpatial(target);
        chaseCam.setEnabled(true);
        camMode = CamMode.CHASE;
    }
    void useDefaultFlyCam() {
        useFlyCam();
        target = null;
        camNode.removeFromParent();
    }
    void useFlyCam() {
        camNode.setEnabled(false);
        chaseCam.setEnabled(false);
        flyCam.setEnabled(true);
        camMode = CamMode.FLY;
    }

    public CamMode getCamMode() {
        return camMode;
    }

    public void setCamMode(CamMode camMode) {
        switch (camMode) {
            case FLY -> useFlyCam();
            case CHASE -> useChaseCam();
            case NODE -> useNodeCam();
            default -> throw new NullPointerException("Mode must not be null");
        }
    }
    public void setMode(CamMode camMode, Node newTarget) {
        target(newTarget);
        switch (camMode) {
            case FLY -> useFlyCam();
            case CHASE -> useChaseCam(newTarget);
            case NODE -> useNodeCam(newTarget);
            default -> throw new NullPointerException("Mode must not be null");
        }
    }

    public enum CamMode {
        FLY,
        CHASE,
        NODE,
    }
}
