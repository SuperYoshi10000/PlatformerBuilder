package local.ytk.g.platformer1.util.ref;

import java.nio.IntBuffer;

public class IntReference {
    protected int[] intArray = new int[]{0};
    protected IntBuffer intBuffer = IntBuffer.wrap(intArray);
    protected int value;
    
    public IntReference() {}
    public IntReference(int value) {
        set(value);
    }
    
    public IntBuffer intBuffer() {
        return intBuffer;
    }
    
    public int[] intArray() {
        return intArray;
    }

    public int set(int value) {
        int old = this.value;
        this.value = intArray[0] = value;
        return old;
    }
    public int get() {
        return value = intArray[0];
    }
}
