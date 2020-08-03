package draft;
import java.sql.*;

import java.sql.Statement;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        get(new String("d"));
    }
    static <T> void get(T t) {
        System.out.println(t.getClass().getName());
    }
}
