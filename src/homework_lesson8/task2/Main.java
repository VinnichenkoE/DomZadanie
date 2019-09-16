package homework_lesson8.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String s;
        BufferedReader reader = new BufferedReader(new FileReader("src/homework_lesson8/task1/input1.txt"));
        BufferedReader reader1 = new BufferedReader(new FileReader("src/homework_lesson8/input2.txt"));
        FileWriter writer = new FileWriter("src/homework_lesson8/task2/output2.txt");
        List<Client2> list = new ArrayList<>();
        while ((s = reader.readLine()) != null){
            String[] str = s.split(" ");
            Client2 client = new Client2(str[0],Integer.parseInt(str[1]));
            list.add(client);
        }
        while ((s = reader1.readLine()) != null){
            String[] str = s.split(" ");
            for (Client2 o: list){
                if (o.getName() == str[0]){
                    int op = o.getSumm() - Integer.parseInt(str[2]);
                    o.setSumm(op) ;
                }
                if (o.getName() == str[1]){
                    int op = o.getSumm() + Integer.parseInt(str[2]);
                    o.setSumm(op);
                }
            }
        }
        for (Client2 o: list){
            String str = o.toString() + "\n";
            writer.write(str);
        }
        writer.close();
        reader.close();
    }
}



