import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;


public class databaseConnection {

    static List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
    public static String save(PostAction post) {
        try {
            String jdbcURL = "jdbc:h2:tcp://localhost/~/test";

            String user = "sa";

            String pass = "";

            Connection connection = DriverManager.getConnection(jdbcURL, user, pass);

            System.out.println("Connected to H2 database.");


            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO HOBBIES VALUES(?,?,?)");

            preparedStatement.setString(1, post.name);

            preparedStatement.setString(2, post.email);

            preparedStatement.setString(3, post.hobbies);

            preparedStatement.execute();

            return "SUCCESS";
        }
        catch(Exception e){

            e.printStackTrace();

        }
        return null;

    }



    public static String getInfo(){

        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";

        String user = "sa";

        String pass = "";




    try(Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa",""))
    {
        if (connection  != null)
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from HOBBIES");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                Map<String, Object> map = new HashMap<String, Object>();

                map.put("name", resultSet.getString("name"));

                map.put("email", resultSet.getString("email"));

                map.put("hobbies", resultSet.getString("hobbies"));

                result.add(map);
            }

            Gson gson = new Gson();

            JsonArray jArray = gson.toJsonTree(result).getAsJsonArray();

            String jString= jArray.toString();

            System.out.println(jString);

            return jString;
        }

        else
        {
            System.out.println("not connected");
        }

    }

    catch (Exception exception)
    {
        exception.printStackTrace();
    }

 return null;
}


}


