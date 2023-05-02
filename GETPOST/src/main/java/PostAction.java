import com.opensymphony.xwork2.Action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostAction implements Action {

    String name;
    String email;

    public void setResult(String result) {
        this.result = result;
    }

    String result = String.valueOf(new ArrayList<>());

    String hobbies;

    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }


    public String execute() throws SQLException {

        return null;
    }

    public String post() throws SQLException {

        System.out.println("post called");

        databaseConnection.save(this);

        return SUCCESS;
    }

    public String get() throws SQLException{
        System.out.println("get called");

        result = databaseConnection.getInfo();


        return SUCCESS;
    }

}
