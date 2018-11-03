package application.database;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
    private static Properties defaultProperties = new Properties();
    static {
        try {
            FileInputStream in = new FileInputStream("db.conf");
            defaultProperties.load(in);
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
