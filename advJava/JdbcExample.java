import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        // JDBC connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try {
            // Step 1: Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a query
            String query = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the result set
            System.out.println("Results from basic statement:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Step 6: Close resources
            resultSet.close();
            statement.close();

            // Parameterized query using PreparedStatement
            String preparedQuery = "SELECT * FROM your_table WHERE age > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setInt(1, 25); // Set the parameter value
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            System.out.println("Results from prepared statement:");
            while (resultSet.next()) { 
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // CallableStatement example for calling a stored procedure
            String callProcedure = "{CALL get_employee_count(?)}"; // Assuming a stored procedure named get_employee_count
            CallableStatement callableStatement = connection.prepareCall(callProcedure);
            callableStatement.registerOutParameter(1, Types.INTEGER); // Registering OUT parameter
            callableStatement.execute();       
            int employeeCount = callableStatement.getInt(1);
            System.out.println("Total employee count: " + employeeCount);

            // Close resources
            callableStatement.close();

            // Step 7: Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
