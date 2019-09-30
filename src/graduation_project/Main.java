package graduation_project;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        Storage storage = new Storage();
        try {
            storage.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

