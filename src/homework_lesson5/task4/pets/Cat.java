package homework_lesson5.task4.pets;

import homework_lesson5.task4.Pet;

public class Cat extends Pet {
    private String name;
    public Cat(String name, String size, String color){
        super(size, color);
        this.name = name;
    }
}
