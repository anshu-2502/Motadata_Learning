import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class databaseConnection {

    public static int save(PostAction post) throws SQLException {

        int status =0;
        try {
            String jdbcURL = "jdbc:h2:tcp://localhost/~/test";

            String user = "sa";

            String pass = "";

            Connection connection = DriverManager.getConnection(jdbcURL, user, pass);

            System.out.println("Connected to H2 database.");


            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement("INSERT INTO HOBBIES (name, email, hobbies) VALUES(?,?,?)");

            preparedStatement.executeUpdate();

            preparedStatement.setString(1, post.getName());

            preparedStatement.setString(2, post.getEmail());

            preparedStatement.setString(3, post.getHobbies());

            status=preparedStatement.executeUpdate();
        }
        catch(Exception e){

            e.printStackTrace();

        }
        return status;

    }
}


