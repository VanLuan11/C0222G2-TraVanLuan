package ss5_access_modifier_static_method_static_property.thuc_hanh.StaticProperty;

public class MainStaticProperty {
    public static void main(String[] args) {

        StaticProperty car1 = new StaticProperty("Mazda 3", "Skyactiv 3");

        System.out.println(StaticProperty.numberOfCars);

        StaticProperty car2 = new StaticProperty("Mazda 6", "Skyactiv 6");

        System.out.println(StaticProperty.numberOfCars);

    }
}
