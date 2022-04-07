package ss5_access_modifier_static_method_static_property.thuc_hanh.StaticProperty;

public class StaticProperty {
    private String name;

    private String engine;

    public static int numberOfCars;

    public StaticProperty(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }
}
