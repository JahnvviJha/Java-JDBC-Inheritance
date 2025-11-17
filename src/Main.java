import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Load OLD MySQL Driver (for connector 5.1.49)
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "javauser",
                "mypassword"
            );

            // SQL Query
            String sql = "SELECT id, name, salary FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("Employee Data:");
            System.out.println("-----------------------------------");

            // Creating Manager objects (multilevel inheritance)
            while (rs.next()) {
                Manager mgr = new Manager(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"),
                    "Software Department"
                );

                mgr.display();
                System.out.println("-----------------------------------");
            }

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
