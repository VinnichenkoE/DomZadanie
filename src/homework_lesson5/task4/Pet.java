package homework_lesson5.task4;

import homework_lesson5.task4.pets.KindOfPet;

public  class Pet {
    private String size;
    private String color;
    public Pet(String size,String color){
        this.size = size;
        this.color = color;
    }
    public void birdPlaying(){
        System.out.println("Птичка летает");
    }
    public void catPlaying(){
        System.out.println("Кот бегает");
    }
    public void fishPlaying(){
        System.out.println("Рыба плавает");
    }
}


