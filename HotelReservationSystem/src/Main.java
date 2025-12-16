import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Amiz123";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- HOTEL RESERVATION SYSTEM ---");
                System.out.println("1. Reserve Room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservation");
                System.out.println("5. Delete Reservation");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        reserveRoom(connection, scanner);
                        break;
                    case 2:
                        viewReservations(connection);
                        break;
                    case 3:
                        getRoomNumber(connection, scanner);
                        break;
                    case 4:
                        updateReservation(connection, scanner);
                        break;
                    case 5:
                        deleteReservation(connection, scanner);
                        break;
                    case 0:
                        exit();
                        scanner.close();
                        connection.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CREATE
    private static void reserveRoom(Connection connection, Scanner scanner) {
        try {
            scanner.nextLine();
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room number: ");
            int roomNumber = scanner.nextInt();

            System.out.print("Enter contact number: ");
            String contactNumber = scanner.next();

            String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) " +
                    "VALUES ('" + guestName + "', " + roomNumber + ", '" + contactNumber + "')";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Room reserved successfully.");

        } catch (SQLException e) {
            System.out.println("Reservation failed.");
        }
    }

    // READ
    private static void viewReservations(Connection connection) {
        try {
            String sql = "SELECT * FROM reservations";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            System.out.println("\n--- Current Reservations ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("reservation_id") + " | " +
                                rs.getString("guest_name") + " | Room " +
                                rs.getInt("room_number") + " | " +
                                rs.getString("contact_number")
                );
            }

        } catch (SQLException e) {
            System.out.println("Unable to fetch reservations.");
        }
    }

    // READ (SPECIFIC)
    private static void getRoomNumber(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter reservation ID: ");
            int id = scanner.nextInt();

            scanner.nextLine();
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();

            String sql = "SELECT room_number FROM reservations " +
                    "WHERE reservation_id=" + id +
                    " AND guest_name='" + name + "'";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Room number: " + rs.getInt("room_number"));
            } else {
                System.out.println("Reservation not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving room number.");
        }
    }

    // UPDATE
    private static void updateReservation(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter reservation ID: ");
            int id = scanner.nextInt();

            if (!reservationExists(connection, id)) {
                System.out.println("Reservation not found.");
                return;
            }

            scanner.nextLine();
            System.out.print("Enter new guest name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter new room number: ");
            int newRoom = scanner.nextInt();

            System.out.print("Enter new contact number: ");
            String newContact = scanner.next();

            String sql = "UPDATE reservations SET guest_name='" + newName +
                    "', room_number=" + newRoom +
                    ", contact_number='" + newContact +
                    "' WHERE reservation_id=" + id;

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Reservation updated successfully.");

        } catch (SQLException e) {
            System.out.println("Update failed.");
        }
    }

    // DELETE
    private static void deleteReservation(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter reservation ID: ");
            int id = scanner.nextInt();

            if (!reservationExists(connection, id)) {
                System.out.println("Reservation not found.");
                return;
            }

            String sql = "DELETE FROM reservations WHERE reservation_id=" + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Reservation deleted successfully.");

        } catch (SQLException e) {
            System.out.println("Deletion failed.");
        }
    }

    // HELPER
    private static boolean reservationExists(Connection connection, int id) {
        try {
            String sql = "SELECT reservation_id FROM reservations WHERE reservation_id=" + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    // EXIT WITH THREAD
    private static void exit() throws InterruptedException {
        System.out.print("Exiting");
        for (int i = 0; i < 4; i++) {
            Thread.sleep(600);
            System.out.print(".");
        }
        System.out.println("\nThank you for using Hotel Reservation System.");
    }
}
