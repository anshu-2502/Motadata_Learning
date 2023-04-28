import java.sql.SQLException;

public class PostAction {

    private String name;
    private String email;

    private String hobbies;

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

        int i=databaseConnection.save(this);

        if(i>0){

            return  "success";
        }

        return "error";
    }



}
