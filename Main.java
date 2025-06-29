// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApplicationManager manager = new ApplicationManager();

        while (true) {
            System.out.println("\n🎯 Job Application Tracker");
            System.out.println("1. Add New Application");
            System.out.println("2. View All Applications");
            System.out.println("3. Filter by Status");
            System.out.println("4. Exit");
            System.out.print("👉 Enter your choice: ");

            // 🟡 Safe input handling (user agar galat input de to program crash na ho)
            String input = sc.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input); // ✅ convert string to integer
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number like 1, 2, 3...");
                continue; // 🟢 wapas menu pe chala jao
            }

            switch (choice) {
                case 1:
                    // 🔹 New Application Add karna
                    System.out.print("🔹 Company Name: ");
                    String company = sc.nextLine();
                    System.out.print("🔹 Role: ");
                    String role = sc.nextLine();
                    System.out.print("🔹 Status (Applied/Interview/Rejected/Selected): ");
                    String status = sc.nextLine();
                    System.out.print("🔹 Date (e.g., 2025-06-29): ");
                    String date = sc.nextLine();

                    Application app = new Application(company, role, status, date);
                    manager.addApplication(app);
                    System.out.println("✅ Application added!");
                    break;

                case 2:
                    // 📄 Show all saved applications
                    System.out.println("\n📄 All Applications:");
                    manager.showAllApplications();
                    break;

                case 3:
                    // 🔍 Filter by status
                    System.out.print("🔍 Enter status to filter: ");
                    String filterStatus = sc.nextLine();
                    System.out.println("\n📄 Filtered Applications:");
                    manager.filterByStatus(filterStatus);
                    break;

                case 4:
                    // 👋 Exit
                    System.out.println("👋 Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
