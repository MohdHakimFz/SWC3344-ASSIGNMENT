/*  Name : Mohd Hakim Bin Mohd Fauzi
	ID: AM2307014329
	Type: Assignment
*/
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// Custom JPanel with rounded corners
class RoundedPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int arcWidth;
    private int arcHeight;

    public RoundedPanel(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false); // Make the panel transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);
        g2d.setColor(getForeground());
        g2d.drawRoundRect(0, 0, width - 1, height - 1, arcWidth, arcHeight);
        g2d.dispose();
    }
}

public class OrderMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private ArrayList<Order> orderList; // List to store orders
    private String username; // Username of the logged-in user

    /**
     * Create the panel.
     * @param username The username of the logged-in user
     */
    public OrderMenu(String username) {
        getContentPane().setBackground(new Color(245, 222, 179)); // Set background color
        this.username = username;
        this.orderList = new ArrayList<>(); // Initialize the order list
        setTitle("E-commerce Order Management System Menu");
        setSize(800, 650);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Main label
        JLabel nameLabel = new JLabel("E-commerce Order Management System Menu");
        nameLabel.setBounds(201, 77, 559, 47);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
        getContentPane().add(nameLabel);

        // Sidebar panel with rounded corners
        RoundedPanel panel = new RoundedPanel(30, 30); // Adjust the arcWidth and arcHeight to change the curvature
        panel.setBackground(new Color(123, 104, 238)); // Set panel background color
        panel.setBounds(0, 0, 191, 617);
        getContentPane().add(panel);
        panel.setLayout(null);

        // Add button
        JButton addButton = new JButton("Add");
        addButton.setBounds(10, 152, 163, 32);
        panel.add(addButton);
        addButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderAdd orderAdd = new OrderAdd();
                orderAdd.setVisible(true); // Open the OrderAdd window
            }
        });

        // Update button
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(10, 245, 163, 32);
        panel.add(updateButton);
        updateButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderUpdate orderUpdate = new OrderUpdate();
                orderUpdate.setVisible(true); // Open the OrderUpdate window
            }
        });

        // Delete button
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(10, 342, 163, 32);
        panel.add(deleteButton);
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderDelete orderDelete = new OrderDelete();
                orderDelete.setVisible(true); // Open the OrderDelete window
            }
        });

        // Display button
        JButton displayButton = new JButton("Display");
        displayButton.setBounds(10, 439, 163, 32);
        panel.add(displayButton);
        displayButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderDisplay orderDisplay = new OrderDisplay();
                orderDisplay.setVisible(true); // Open the OrderDisplay window
            }
        });

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(10, 531, 163, 32);
        panel.add(exitButton);
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Welcome label displaying the username
        JLabel WelcomeLabel = new JLabel("Welcome, " + OrderManagementSystem.getUsername() + "!");
        WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        WelcomeLabel.setBounds(10, 110, 163, 32);
        panel.add(WelcomeLabel);
        WelcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

        // User icon label
        JLabel UserLabel = new JLabel("");
        UserLabel.setIcon(new ImageIcon("C:\\Users\\Hakim\\Downloads\\Users96.png")); // Set user icon
        UserLabel.setBounds(48, 10, 103, 99);
        panel.add(UserLabel);

        // Shopee Express logo label
        JLabel ImageXpressLabel = new JLabel("");
        ImageXpressLabel.setIcon(new ImageIcon("C:\\Users\\Hakim\\Downloads\\Shopee Express Logo.png")); // Set Shopee Express logo
        ImageXpressLabel.setBounds(289, 10, 400, 70);
        getContentPane().add(ImageXpressLabel);

        // Contact panel
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(147, 112, 219)); // Set panel background color
        panel_2.setBounds(189, 493, 597, 124);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        // "Any Trouble?" label
        JLabel TroubleLabel = new JLabel("Any Trouble?");
        TroubleLabel.setBounds(29, 10, 101, 25);
        panel_2.add(TroubleLabel);
        TroubleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

        // "Contact Us:" label
        JLabel ContactUsLabel = new JLabel("Contact Us:");
        ContactUsLabel.setBounds(29, 30, 75, 25);
        panel_2.add(ContactUsLabel);
        ContactUsLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ContactUsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // "Email:" label
        JLabel EmailLabel = new JLabel("Email:");
        EmailLabel.setBounds(67, 66, 47, 25);
        panel_2.add(EmailLabel);
        EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        EmailLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Phone number label
        JLabel PhoneLabel = new JLabel("+601599994775");
        PhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        PhoneLabel.setBounds(114, 37, 101, 13);
        panel_2.add(PhoneLabel);

        // Email address label
        JLabel EmailsLabel = new JLabel("ShopeeExpressCenter@gmail.com");
        EmailsLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        EmailsLabel.setBounds(117, 73, 186, 13);
        panel_2.add(EmailsLabel);
        
                JLabel lblNewLabel_5 = new JLabel("Made By Mohd Hakim");
                lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
                lblNewLabel_5.setBounds(421, 89, 176, 25);
                panel_2.add(lblNewLabel_5);
    }
}
