// ApplicationManager.java
import java.io.*;
import java.util.*;

public class ApplicationManager {
    private List<Application> applications;
    private final String FILE_NAME = "applications.txt";

    public ApplicationManager() {
        applications = new ArrayList<>();
        loadApplications();
    }

    // Add new application
    public void addApplication(Application app) {
        applications.add(app);
        saveApplications();
    }

    // Show all applications
    public void showAllApplications() {
        if (applications.isEmpty()) {
            System.out.println("⚠️ No applications found.");
            return;
        }

        for (Application app : applications) {
            System.out.println(app);
        }
    }

    // Filter applications by status
    public void filterByStatus(String status) {
        boolean found = false;
        for (Application app : applications) {
            if (app.getStatus().equalsIgnoreCase(status)) {
                System.out.println(app);
                found = true;
            }
        }

        if (!found) {
            System.out.println("⚠️ No applications found with status: " + status);
        }
    }

    // Save to file
    private void saveApplications() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Application app : applications) {
                writer.write(app.getCompany() + "," + app.getRole() + "," + app.getStatus() + "," + app.getDate());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving to file.");
        }
    }

    // Load from file
    private void loadApplications() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 4);
                if (parts.length == 4) {
                    Application app = new Application(parts[0], parts[1], parts[2], parts[3]);
                    applications.add(app);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading from file.");
        }
    }
}
