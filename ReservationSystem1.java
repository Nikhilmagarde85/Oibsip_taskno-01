import java.util.Scanner;

public class ReservationSystem1 {
    private static boolean[] seats;
    private static final int NUM_SEATS = 10;

    public static void main(String[] args) {
        seats = new boolean[NUM_SEATS]; // Initialize all seats as available

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. View available seats");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeat(scanner);
                    break;
                case 2:
                    displayAvailableSeats();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.println("\nSeat Reservation");

        System.out.print("Enter seat number (1-10): ");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > NUM_SEATS) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }

        if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved. Please choose another seat.");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("Seat " + seatNumber + " reserved successfully.");
        }
    }

    private static void displayAvailableSeats() {
        System.out.println("\nAvailable Seats:");

        for (int i = 0; i < NUM_SEATS; i++) {
            if (!seats[i]) {
                System.out.println("Seat " + (i + 1));
            }
        }
    }
}