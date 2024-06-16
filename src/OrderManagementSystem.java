/*  Name : Mohd Hakim Bin Mohd Fauzi
	ID: AM2307014329
	Type: Assignment
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderManagementSystem extends JFrame {
    private ArrayList<Order> orderList; // List to store orders
    private JTextField usernameField; // Text field for username input
    private JPasswordField passwordField; // Password field for password input
    private static String username; // Static variable to store the logged-in username

    public OrderManagementSystem() {
        super("E-commerce Order Management System Login");
        setFont(new Font("Arial", Font.PLAIN, 12));
        orderList = new ArrayList<>(); // Initialize the order list
        // Removed loadDataFromFile() to simplify the example
        addGuiComponents(); // Add GUI components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 650);
        setVisible(true); // Set JFrame visible
        setLocationRelativeTo(null); // Center the window on the screen
    }

    private void addGuiComponents() {
        // Login Page Panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(255, 160, 122)); // Set background color
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, 850, 650); // Setting bounds to fit the frame

        // Username label
        JLabel UsernameLabel = new JLabel("Username:");
        UsernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        UsernameLabel.setBounds(209, 328, 87, 35);
        loginPanel.add(UsernameLabel);

        // Username text field
        usernameField = new JTextField();
        usernameField.setBounds(306, 329, 231, 35);
        loginPanel.add(usernameField);

        // Password label
        JLabel PasswordLabel = new JLabel("Password:");
        PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        PasswordLabel.setBounds(209, 404, 87, 35);
        loginPanel.add(PasswordLabel);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setBounds(306, 405, 231, 35);
        loginPanel.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 23));
        loginButton.setBounds(0, 530, 840, 87);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the username and password entered by the user
                String usernameText = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Check if the username and password match
                if (usernameText.equals("Hakim") && password.equals("Password123")) {
                    // Store the username in the static variable
                    username = usernameText;
                    dispose(); // Close the login window
                    OrderMenu orderMenu = new OrderMenu(username); // Pass the username
                    orderMenu.setVisible(true); // Show OrderMenu
                } else {
                    // Show an error message if the credentials are invalid
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
        loginPanel.add(loginButton);

        getContentPane().setLayout(null);
        getContentPane().add(loginPanel);
        
        // Label for the logo image
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hakim\\Downloads\\Shopee.png")); // Set icon image
        lblNewLabel.setBounds(306, 66, 220, 201);
        loginPanel.add(lblNewLabel);
    }

    // Getter method for the static username variable
    public static String getUsername() {
        return username;
    }
}
