package homework_lesson5.task4;

import homework_lesson5.task4.pets.Bird;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Vasya");
        person1.HaveABird("Kesha","middle","green");
        person1.HaveACat("Barsik","small","white");
        person1.petPlaying();
    }
}
