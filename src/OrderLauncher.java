/*  Name : Mohd Hakim Bin Mohd Fauzi
	ID: AM2307014329
	Type: Assignment
*/
import java.awt.EventQueue;

public class OrderLauncher {

    public static void main(String[] args) {
        // Example usage:
        // To launch the OrderManagementSystem
        launch("OrderManagementSystem");
    }

    // Method to launch different GUI frames based on the provided class name
    public static void launch(String className) {
        switch (className) {
            case "OrderManagementSystem":
                // Launch OrderManagementSystem frame
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            OrderManagementSystem frame = new OrderManagementSystem();
                            frame.setVisible(true); // Make the frame visible
                        } catch (Exception e) {
                            e.printStackTrace(); // Print stack trace if an exception occurs
                        }
                    }
                });
                break;

            case "OrderMenu":
                // Launch OrderMenu frame
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            String username = OrderManagementSystem.getUsername(); // Get username from OrderManagementSystem
                            OrderMenu frame = new OrderMenu(username);
                            frame.setVisible(true); // Make the frame visible
                        } catch (Exception e) {
                            e.printStackTrace(); // Print stack trace if an exception occurs
                        }
                    }
                });
                break;

            case "OrderAdd":
                // Launch OrderAdd frame
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            OrderAdd frame = new OrderAdd();
                            frame.setVisible(true); // Make the frame visible
                        } catch (Exception e) {
                            e.printStackTrace(); // Print stack trace if an exception occurs
                        }
                    }
                });
                break;

            case "OrderUpdate":
                // Launch OrderUpdate frame
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            OrderUpdate frame = new OrderUpdate();
                            frame.setVisible(true); // Make the frame visible
                        } catch (Exception e) {
                            e.printStackTrace(); // Print stack trace if an exception occurs
                        }
                    }
                });
                break;

            case "OrderDelete":
                // Launch OrderDelete frame
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            OrderDelete frame = new OrderDelete();
                            frame.setVisible(true); // Make the frame visible
                        } catch (Exception e) {
                            e.printStackTrace(); // Print stack trace if an exception occurs
                        }
                    }
                });
                break;

            case "OrderDisplay":
                // Launch OrderDisplay frame
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            OrderDisplay frame = new OrderDisplay();
                            frame.setVisible(true); // Make the frame visible
                        } catch (Exception e) {
                            e.printStackTrace(); // Print stack trace if an exception occurs
                        }
                    }
                });
                break;

            default:
                // Handle unknown class names
                System.out.println("Unknown class name: " + className);
        }
    }
}
