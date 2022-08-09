package ss7_abtract_interface.practise.practise1.controller;

import ss7_abtract_interface.practise.practise1.models.Animal;
import ss7_abtract_interface.practise.practise1.models.Chicken;
import ss7_abtract_interface.practise.practise1.models.Edible;
import ss7_abtract_interface.practise.practise1.models.Tiger;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if(animal instanceof Chicken){
                Edible edibler = (Edible) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
