import java.util.ArrayList;
import java.util.Scanner;

public class TicketTracker {

    public static void main(String[] args) {

        ArrayList<Ticket> tickets = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int ticketCounter = 1;
        boolean running = true;

        while (running) {

            System.out.println("------------------------");
            System.out.println("Choose an option:");
            System.out.println("1. Add Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Resolve Ticket");
            System.out.println("4. Search Ticket");
            System.out.println("5. Exit");
            System.out.println("------------------------");
            System.out.print("Enter choice: ");

            int userChoice = input.nextInt();
            input.nextLine();
            System.out.println();

            if (userChoice == 1) {
                System.out.println("----- Add Ticket -----");

                System.out.print("Enter user name: ");
                String name = input.nextLine();

                System.out.print("Enter issue type: ");
                String issue = input.nextLine();

                System.out.print("Enter priority: ");
                String priority = input.nextLine();

                Ticket newTicket = new Ticket(ticketCounter, name, issue, priority, false);
                tickets.add(newTicket);

                ticketCounter++;

                System.out.println();
                System.out.println("Ticket added successfully.");
                System.out.println();
            }

            else if (userChoice == 2) {
                System.out.println("----- View Tickets -----");

                if (tickets.isEmpty()) {
                    System.out.println();
                    System.out.println("No tickets available.");
                    System.out.println();
                } else {
                    System.out.println();
                    for (Ticket t : tickets) {
                        t.displayTicket();
                    }
                }
            }

            else if (userChoice == 3) {
                System.out.println("----- Resolve Ticket -----");

                System.out.print("Enter ticket ID to resolve: ");
                int id = input.nextInt();
                input.nextLine();

                boolean found = false;

                for (Ticket t : tickets) {
                    if (t.getTicketID() == id) {
                        t.resolveTicket();
                        System.out.println();
                        System.out.println("Ticket resolved.");
                        System.out.println();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println();
                    System.out.println("Ticket not found.");
                    System.out.println();
                }
            }

            else if (userChoice == 4) {
                System.out.println("----- Search Ticket -----");
                System.out.println("1. Search by Ticket ID");
                System.out.println("2. Search by User Name");
                System.out.print("Enter choice: ");

                int searchChoice = input.nextInt();
                input.nextLine();
                System.out.println();

                boolean found = false;

                if (searchChoice == 1) {
                    System.out.print("Enter ticket ID: ");
                    int searchID = input.nextInt();
                    input.nextLine();
                    System.out.println();

                    for (Ticket t : tickets) {
                        if (t.getTicketID() == searchID) {
                            t.displayTicket();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching ticket found.");
                        System.out.println();
                    }
                }

                else if (searchChoice == 2) {
                    System.out.print("Enter user name: ");
                    String searchName = input.nextLine();
                    System.out.println();

                    for (Ticket t : tickets) {
                        if (t.getUserName().equalsIgnoreCase(searchName)) {
                            t.displayTicket();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching ticket found.");
                        System.out.println();
                    }
                }

                else {
                    System.out.println("Invalid search option.");
                    System.out.println();
                }
            }

            else if (userChoice == 5) {
                System.out.println();
                System.out.println("Exiting program.");
                running = false;
            }

            else {
                System.out.println();
                System.out.println("Invalid option.");
                System.out.println();
            }
        }

        input.close();
    }
}