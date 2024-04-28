### Using `Class.forName()` with `DriverManager`

https://dev.mysql.com/downloads/file/?id=525081

#### Hands onPractice


**maven**

```xml
 <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>
    </dependencies>
```

`Main.java`

```java
public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            PersonService personService = PersonService.getInstance();

            personService.addPerson("0019", "Nashu1");
            System.out.println("Insertion Successfully");

            ResultSet queryResult = personService.getPersonList();

            String ID, name;
            while (queryResult.next()) {
                ID = queryResult.getString("ID");
                name = queryResult.getString("name");
                System.out.println("Id: "+ ID + "name: "+ name);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }
}
```

`config/DatabaseConnectionManager.java`

```java
// using **Class.forName()** with **DriverManager**
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "mocha123";

    // Load the  database driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException err) {
            System.out.println("Error loading driver: " + err.getMessage());
        }
    }

    // Provide a method to get a database  connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
                // Optionally, you can check if the connection is closed
                if (connection.isClosed()) {
                    System.out.println("However, the connection is currently closed.");
                } else {
                    System.out.println("Connection is active.");
                }
                // Close the connection
                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
```

`repository/PersonRepositoryImp.java`

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRepositoryImp implements PersonRepository{
  
// ...

    @Override
    public void addPerson(Person person) {
        String sql = "INSERT into person (id, name, mother, father) values (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getID());
      
			//...
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public ResultSet getAllPersonsInfo() throws SQLException {
        String sql = "SELECT * FROM person";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        return resultSet;
    }
}
```

### Using `DataSource`

**Step 1:** Install the Database Plugin (If Not Already Installed) First, ensure that the Database Tools and SQL plugin is enabled in IntelliJ IDEA:

1. Go to File > Settings (or IntelliJ IDEA > Preferences on macOS).
2. Navigate to Plugins.
3. Search for “Database Tools and SQL”.
4. f not already installed, find it and click Install.
5. Restart IntelliJ IDEA if needed.

**Step 2:** Open Database Tool Window

1. Click on the Database tab on the right-hand side of the IDE or go to View > Tool Windows > Database.

**Step 3:** Add a New Data Source

1. In the Database tool window, click the `+`` (plus) icon to add a new data source.
2. Select your database type (e.g., MySQL, PostgreSQL, Oracle, etc.).

**Step 4:** Configure the Data Source

1. Enter the necessary connection details:

- Host: Usually localhost unless your database is remote.
- Port: The default port on which your database listens (e.g., 3306 for MySQL).
- User: Your database username.
- Password: Your database password.
- Database: The name of the database you want to connect to.

2. You can also use the URL tab to enter the JDBC URL directly if you prefer or know the exact URL.

**Step 5:** Download Drivers

1. IntelliJ IDEA may prompt you to download the JDBC driver if it's not already available. Allow it to download the necessary files.

Step 6: Test Connection

1. Click Test Connection to ensure all settings are correct and IntelliJ IDEA can connect to the database.
2. If the test is successful, you’ll see a message indicating the connection was successful. If not, it will show an error, and you’ll need to check your settings.

**Step 7:** Apply and OK

1. Click Apply and then OK to save the datasource configuration.
