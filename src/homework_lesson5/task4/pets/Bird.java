package homework_lesson5.task4.pets;

import homework_lesson5.task4.Pet;

public class Bird extends Pet {
    private String name;
    public Bird(String name, String size, String color){
        super(size, color);
        this.name = name;
    }
}
