package homework_lesson5;

import java.util.ArrayList;

public class Task2 {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Мама");
        arrayList.add("мылы");
        arrayList.add("раму");
        arrayList.add("!");

        for (String element : arrayList) {
            System.out.print(element + " ");
        }
        System.out.println("");
        for (String element : arrayList) {
            String upElement = element.toUpperCase();
            System.out.print(upElement + " ");
        }
    }
}