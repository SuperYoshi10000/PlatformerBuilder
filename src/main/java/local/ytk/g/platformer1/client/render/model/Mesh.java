package local.ytk.g.platformer1.client.render.model;

import java.util.ArrayList;

import local.ytk.g.platformer1.client.render.texture.Texture;
import local.ytk.g.platformer1.util.ref.IntReference;

public class Mesh {
    public ArrayList<Vertex> vertices;
    public ArrayList<MeshFace> faces;
    public ArrayList<Texture> textures;

    protected IntReference
        VAO = new IntReference(),
        VBO = new IntReference(),
        EBO = new IntReference();
    
    public Mesh(ArrayList<Vertex> vertices, ArrayList<MeshFace> faces, ArrayList<Texture> textures) {
        this.vertices = vertices;
        this.faces = faces;
        this.textures = textures;
        setupMesh();
    }
    
    protected void setupMesh() {
        // glGenVertexArrays(VAO.intArray());
        // glGenBuffers(VBO.intArray());
        // glGenBuffers(EBO.intArray());
        // glBindVertexArray(VAO.get());
        // glBindBuffer(GL_ARRAY_BUFFER, VBO.get());
        // glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        // glDraw();
        
    }

    public Vertex vertexAt(float x, float y, float z) {
        return new Vertex();
    }

    public static abstract class MeshFace {}
    public static class TriangleMeshFace extends MeshFace {
        protected Vertex v1;
        protected Vertex v2;
        protected Vertex v3;
        protected Texture.Mapping textureMapping;

        public static TriangleMeshFace points(
            float x1, float y1, float z1,
            float x2, float y2, float z2,
            float x3, float y3, float z3
        ) {
            TriangleMeshFace x = new TriangleMeshFace();
            x.v1 = new Vertex(x1, y1, z1);
            x.v2 = new Vertex(x2, y2, z2);
            x.v3 = new Vertex(x3, y3, z3);
            return x;
        }
    }
    public static class CombinedMeshFace extends MeshFace {
        protected MeshFace face1;
        protected MeshFace face2;
        public CombinedMeshFace(MeshFace face1, MeshFace face2) {
            this.face1 = face1;
            this.face2 = face2;
        }
    }
    public static class RectangleMeshFace extends CombinedMeshFace {
        public RectangleMeshFace(TriangleMeshFace face1, TriangleMeshFace face2) {
            super(face1, face2);
        }

        protected Vertex v1;
        protected Vertex v2;
        protected Vertex v3;
        protected Vertex v4;
        protected Texture.Mapping textureMapping;

        public static RectangleMeshFace points(
            float x1, float y1, float z1,
            float x2, float y2, float z2,
            float x3, float y3, float z3,
            float x4, float y4, float z4
        ) {
            RectangleMeshFace x = new RectangleMeshFace(
                TriangleMeshFace.points(x1, y1, z1, x2, y2, z2, x3, y3, z3),
                TriangleMeshFace.points(x1, y1, z1, x3, y3, z3, x4, y4, z4));
            x.v1 = new Vertex(x1, y1, z1);
            x.v2 = new Vertex(x2, y2, z2);
            x.v3 = new Vertex(x3, y3, z3);
            x.v4 = new Vertex(x4, y4, z4);
            return x;
        }
    }
}
