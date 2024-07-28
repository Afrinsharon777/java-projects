import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AttendanceManagementSystem {
    private Map<String, Boolean> attendance;

    public AttendanceManagementSystem() {
        this.attendance = new HashMap<>();
    }

    public void markAttendance(String name, boolean isPresent) {
        attendance.put(name, isPresent);
    }

    public void viewAttendance() {
        for (Map.Entry<String, Boolean> entry : attendance.entrySet()) {
            String name = entry.getKey();
            boolean isPresent = entry.getValue();
            System.out.println(name + ": " + (isPresent ? "Present" : "Absent"));
        }
    }

    public static void main(String[] args) {
        AttendanceManagementSystem attendanceManagementSystem = new AttendanceManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Is " + name + " present? (yes/no): ");
                    boolean isPresent = scanner.nextLine().equalsIgnoreCase("yes");
                    attendanceManagementSystem.markAttendance(name, isPresent);
                    break;
                case 2:
                    attendanceManagementSystem.viewAttendance();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}