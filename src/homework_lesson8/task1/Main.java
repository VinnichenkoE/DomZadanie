package homework_lesson8.task1;

import homework_lesson8.task1.Client;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        String s;
        Comparator<Client> comp = new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getSumm().compareTo(o2.getSumm());
            }
        };
        TreeSet<Client> list = new TreeSet<>(comp);
        FileWriter writer = new FileWriter("src/homework_lesson8/task1/output1.txt");
        BufferedReader reader = new BufferedReader(new FileReader("src/homework_lesson8/task1/input1.txt"));

        try {

            while ((s = reader.readLine()) != null){
                String[] str = s.split(" ");
                Client client = new Client(str[0],str[1]);
                list.add(client);
                }

            for (Client o1: list){
                String str = o1.toString() + "\n";
                writer.write(str);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            writer.close();
            reader.close();
        }

    }

}
