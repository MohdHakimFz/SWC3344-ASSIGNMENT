
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class OrderAdd extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField OrderField;
    private JTextField CustomerField;
    private JTextField CAddField;
    private JTextField PNameField;
    private JTextField QuantityField;
    private JTextField PriceField;
    private JTextField TotalField;
    private JComboBox<String> StatusComboBox;
    private String username; // Add a field to store the username
    private List<Order> orderList = new ArrayList<>();

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public OrderAdd() {
        // Set the title of the frame
        setTitle("Add Order System");
        // Set the default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Set the bounds of the frame
        setBounds(100, 100, 750, 596);
        // Center the frame on the screen
        setLocationRelativeTo(null);
        // Initialize contentPane and set its properties
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 218, 185));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Add and configure the labels and text fields
        JLabel IdLabel = new JLabel("Order ID:");
        IdLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        IdLabel.setBounds(121, 99, 76, 13);
        contentPane.add(IdLabel);

        JLabel CustomerLabel = new JLabel("Customer Name:");
        CustomerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        CustomerLabel.setBounds(121, 135, 116, 20);
        contentPane.add(CustomerLabel);

        JLabel CusAddLabel = new JLabel("Customer Address:");
        CusAddLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        CusAddLabel.setBounds(121, 173, 144, 26);
        contentPane.add(CusAddLabel);

        JLabel ProductLabel = new JLabel("Product Name:");
        ProductLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        ProductLabel.setBounds(121, 218, 97, 20);
        contentPane.add(ProductLabel);

        JLabel QuantityLabel = new JLabel("Quantity Ordered :");
        QuantityLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        QuantityLabel.setBounds(121, 259, 127, 20);
        contentPane.add(QuantityLabel);

        JLabel PPUnitLabel = new JLabel("Price Per Unit:");
        PPUnitLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        PPUnitLabel.setBounds(121, 297, 116, 23);
        contentPane.add(PPUnitLabel);

        JLabel TotalLabel = new JLabel("Total Price:");
        TotalLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        TotalLabel.setBounds(121, 333, 93, 20);
        contentPane.add(TotalLabel);

        JLabel StatusLabel = new JLabel("Order Status:");
        StatusLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        StatusLabel.setBounds(121, 378, 107, 20);
        contentPane.add(StatusLabel);

        OrderField = new JTextField();
        OrderField.setBounds(259, 97, 181, 20);
        contentPane.add(OrderField);
        OrderField.setColumns(10);

        CustomerField = new JTextField();
        CustomerField.setBounds(259, 137, 181, 20);
        contentPane.add(CustomerField);
        CustomerField.setColumns(10);

        CAddField = new JTextField();
        CAddField.setColumns(10);
        CAddField.setBounds(259, 178, 181, 20);
        contentPane.add(CAddField);

        PNameField = new JTextField();
        PNameField.setColumns(10);
        PNameField.setBounds(259, 220, 181, 20);
        contentPane.add(PNameField);

        QuantityField = new JTextField();
        QuantityField.setColumns(10);
        QuantityField.setBounds(259, 261, 181, 20);
        contentPane.add(QuantityField);

        PriceField = new JTextField();
        PriceField.setColumns(10);
        PriceField.setBounds(259, 300, 181, 20);
        contentPane.add(PriceField);

        TotalField = new JTextField();
        TotalField.setEditable(false);
        TotalField.setColumns(10);
        TotalField.setBounds(259, 335, 179, 20);
        contentPane.add(TotalField);

        // Add and configure the combo box for order status
        StatusComboBox = new JComboBox<>();
        StatusComboBox.setBounds(259, 380, 181, 20);
        StatusComboBox.addItem("Pending");
        StatusComboBox.addItem("Shipped");
        StatusComboBox.addItem("Delivered");
        StatusComboBox.addItem("Cancelled");
        contentPane.add(StatusComboBox);

        // Add and configure the reset button
        JButton ResetButton = new JButton("Reset");
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields(); // Clear all input fields when reset button is pressed
            }
        });
        ResetButton.setBounds(180, 433, 85, 21);
        contentPane.add(ResetButton);

        // Add and configure the confirm button
        JButton ConfirmButton = new JButton("Confirm");
        ConfirmButton.setBounds(390, 433, 85, 21);
        contentPane.add(ConfirmButton);
        ConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Confirm the action and save the order information
                int option = JOptionPane.showConfirmDialog(OrderAdd.this, "Are you sure you want to save this information?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    calculateTotalPrice(); // Calculate total price before saving
                    saveOrderInformation(); // Save order information
                    loadDataFromFile(); // Load data from file after saving
                    dispose(); // Close the OrderAdd frame
                    // Retrieve username and pass it to OrderMenu constructor
                    String username = OrderManagementSystem.getUsername();
                    OrderMenu orderMenu = new OrderMenu(username);
                    orderMenu.setVisible(true); // Display OrderMenu
                }
            }
        });

        // Add and configure the title label
        JLabel TitleLabel = new JLabel("Add A New Order");
        TitleLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setBounds(259, 40, 181, 20);
        contentPane.add(TitleLabel);
    }

    // Method to save order information to the file
    private void saveOrderInformation() {
        String newOrderID = OrderField.getText().trim();

        // Check if any required fields are empty
        if (newOrderID.isEmpty() || CustomerField.getText().trim().isEmpty() || 
            CAddField.getText().trim().isEmpty() || PNameField.getText().trim().isEmpty() || 
            QuantityField.getText().trim().isEmpty() || PriceField.getText().trim().isEmpty() || 
            TotalField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the new order ID already exists in the orderList
        for (Order order : orderList) {
            if (order.getOrderId() == Integer.parseInt(newOrderID)) {
                JOptionPane.showMessageDialog(null, "Order with ID " + newOrderID + " already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                OrderField.requestFocusInWindow(); // Return focus to Order ID field
                return; // Exit the method if a duplicate is found
            }
        }

        // Check if the new order ID already exists in the file
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hakim\\Downloads\\orders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(newOrderID)) {
                    JOptionPane.showMessageDialog(null, "Order with ID " + newOrderID + " already exists in the file!", "Error", JOptionPane.ERROR_MESSAGE);
                    OrderField.requestFocusInWindow(); // Return focus to Order ID field
                    return; // Exit the method if a duplicate is found in the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading data from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if an error occurs while reading the file
        }

        // If no duplicate is found and all fields are valid, proceed to save the new order information
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Hakim\\Downloads\\orders.txt", true))) {
            double price = Double.parseDouble(PriceField.getText().trim());
            int quantity = Integer.parseInt(QuantityField.getText().trim());
            double total = price * quantity;

            String orderInfo = newOrderID + "," +
                               CustomerField.getText().trim() + "," +
                               CAddField.getText().trim() + "," +
                               PNameField.getText().trim() + "," +
                               quantity + "," +
                               price + "," +
                               total + "," +
                               StatusComboBox.getSelectedItem().toString();

            writer.write(orderInfo); // Write order information to file
            writer.newLine(); // Add a new line after writing each order
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving data to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear all input fields
    private void clearFields() {
        OrderField.setText("");
        CustomerField.setText("");
        CAddField.setText("");
        PNameField.setText("");
        QuantityField.setText("");
        PriceField.setText("");
        TotalField.setText("");
        StatusComboBox.setSelectedIndex(0); // Set selected index to default (Pending)
    }

    // Method to calculate the total price
    private void calculateTotalPrice() {
        try {
            int quantity = Integer.parseInt(QuantityField.getText().trim());
            double price = Double.parseDouble(PriceField.getText().trim());
            double total = quantity * price;
            TotalField.setText(String.valueOf(total));
        } catch (NumberFormatException ex) {
            TotalField.setText("");
        }
    }

    // Method to load data from the file
    private void loadDataFromFile() {
        orderList.clear(); // Clear existing data
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hakim\\Downloads\\orders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8) { // Ensure the line has at least 8 parts
                    try {
                        int orderId = Integer.parseInt(parts[0].trim());
                        String customerName = parts[1].trim();
                        String customerAddress = parts[2].trim();
                        String productName = parts[3].trim();
                        int quantity = Integer.parseInt(parts[4].trim());
                        double price = Double.parseDouble(parts[5].trim());
                        double total = Double.parseDouble(parts[6].trim());
                        String status = parts[7].trim();
                        orderList.add(new Order(orderId, customerName, customerAddress, productName, quantity, price, total, status));
                    } catch (NumberFormatException e) {
                        // Handle parsing errors
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error parsing data: " + e.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid data format in file: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }
}
