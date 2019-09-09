package homework_lesson5.task4.pets;

import homework_lesson5.task4.Pet;

public class Fish extends Pet {
    private String name;
    public Fish(String name, String size, String color){
        super(size, color);
        this.name = name;
    }
}
