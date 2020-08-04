import java.sql.*;

public class draft {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://180.76.142.171:3306/HRMS", "root", "sigechoupijiang");
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM emp ");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}
