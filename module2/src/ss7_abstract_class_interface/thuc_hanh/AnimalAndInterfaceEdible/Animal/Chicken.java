package ss7_abstract_class_interface.thuc_hanh.AnimalAndInterfaceEdible.Animal;

import ss7_abstract_class_interface.thuc_hanh.AnimalAndInterfaceEdible.Edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
    @Override
    public String howToEat() {
        return "could be fried";
    }
}
