package local.ytk.g.platformer1.data;

public class Identifier {
    public static String defaultNamespace = "";

    public final String namespace;
    public final String value;

    public Identifier(String namespace, String value) {
        this.namespace = namespace;
        this.value = value;
    }

    public Identifier(String name) {
        String[] split = name.split(":", 2);
        this.namespace = split[0];
        this.value = split[1];
    }

    public static Identifier of(String namespace, String value) {
        return new Identifier(namespace, value);
    }

    public static Identifier of(String name) {
        return new Identifier(name);
    }

    public static Identifier ofDefault(String value) {
        return new Identifier(defaultNamespace, value);
    }
    
    public static boolean isValid(String name) {
        return isValidNamespace(name.split(":")[0]) && isValidValue(name.replaceFirst("^.*?:", ""));
    }
    public static boolean isValidNamespace(String namespace) {
        return namespace.matches("[\\w.+-]");
    }
    public static boolean isValidValue(String value) {
        return value.matches("[\\w./$+-]");
    }
}
