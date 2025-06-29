
    // Application.java
import java.io.Serializable;

public class Application implements Serializable {
    private String company;
    private String role;
    private String status;
    private String date;

    public Application(String company, String role, String status, String date) {
        this.company = company;
        this.role = role;
        this.status = status;
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return company + " | " + role + " | " + status + " | " + date;
    }
}


