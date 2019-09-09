package homework_lesson5.task4;

import homework_lesson5.task4.pets.Bird;
import homework_lesson5.task4.pets.Cat;
import homework_lesson5.task4.pets.Fish;
import homework_lesson5.task4.pets.KindOfPet;

public class Person {
    private String name;
    private Pet pet;
    private KindOfPet kindOfPet;

    public Person(String name) {
        this.name = name;
    }

    public void HaveABird(String name, String size, String color) {
        if (this.pet == null) {
            this.pet = new Bird(name, size, color);
            this.kindOfPet = KindOfPet.BIRD;
        } else {
            System.out.println("У вас уже есть питомец");
        }
    }

    public void HaveACat(String name, String size, String color) {
        if (this.pet == null) {
            this.pet = new Cat(name, size, color);
            this.kindOfPet = KindOfPet.CAT;
        } else {
            System.out.println("У вас уже есть питомец");
        }
    }

    public void HaveAFish(String name, String size, String color) {
        if (this.pet == null) {
            this.pet = new Fish(name, size, color);
            this.kindOfPet = KindOfPet.FISH;
        } else {
            System.out.println("У вас уже есть питомец");
        }

    }
    public void petPlaying(){
        switch(this.kindOfPet){
            case BIRD:
                pet.birdPlaying(); break;
            case CAT:
                pet.catPlaying(); break;
            case FISH:
                pet.fishPlaying(); break;
        }

    }

}
