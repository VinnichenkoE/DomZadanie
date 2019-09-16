package homework_lesson8.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/homework_lesson8/task3/input3.txt"));
        FileWriter writer = new FileWriter("src/homework_lesson8/task3/output3.txt");
        String s;
        List<Contacts> list = new ArrayList<>();
        String[] sort = new String[3];

        try {
            while ((s = reader.readLine()) != null) {
                Contacts contacts = new Contacts(null, null, null);
                String[] str = s.split(" ", 3);
                for (String l : str) {
                    if (l.contains("@")) {
                        sort[2] = l;
                    } else if (l.contains("+")) {
                        sort[1] = l;
                    } else {
                        sort[0] = l;
                    }
                }
                contacts.setName(sort[0]);
                contacts.setTelepnonNumber(sort[1]);
                contacts.setEmail(sort[2]);
                list.add(contacts);
            }

            for (Object o : list) {
                String line = o.toString() + "\n";
                writer.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            reader.close();
        }

    }
}
