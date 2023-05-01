import com.opensymphony.xwork2.Action;

import java.sql.SQLException;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class PostAction implements Action {

     String name;
     String email;

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


    public String execute() throws SQLException {

        databaseConnection.save(this);


            return SUCCESS;
        }



}

