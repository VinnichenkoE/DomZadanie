package homework_lesson5;

import java.util.ArrayList;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        double ammount = 0;
        for (int i=0;i<5;i++){
            int element = 50 - random.nextInt(101);
            System.out.println(element);
            numbers.add(element);
            ammount +=element;
        }
        System.out.println("Среднее значение: "+ (ammount/5));
    }
}
