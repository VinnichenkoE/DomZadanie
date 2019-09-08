package homework_lesson5;

import java.util.HashSet;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        HashSet<Integer> numbersInborder = new HashSet<Integer>();
        Random random = new Random();
        int border = random.nextInt(100);
        System.out.println(border);
        for (int i=0; i<10; i++){
            int element = random.nextInt(100);
            numbers.add(element);
        }
        System.out.println(numbers.toString());
        for (int a:numbers){
            if (a>border){
                numbersInborder.add(a);
            }
        }
        System.out.println(numbersInborder.toString());
    }
}
