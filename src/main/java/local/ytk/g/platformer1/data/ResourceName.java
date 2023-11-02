package local.ytk.g.platformer1.data;

public class ResourceName {
    public final String namespace;
    public final String value;

    public ResourceName(String namespace, String value) {
        this.namespace = namespace;
        this.value = value;
    }

    public ResourceName(String name) {
        this.namespace = name.split(":")[0];
        this.value = name.replaceFirst("^.*?:", "name");
    }

    public static ResourceName of(String namespace, String value) {
        return new ResourceName(namespace, value);
    }

    public static ResourceName of(String name) {
        return new ResourceName(name);
    }

}
