/*  Name : Mohd Hakim Bin Mohd Fauzi
	ID: AM2307014329
	Type: Assignment
*/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JComboBox;

public class OrderUpdate extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField OrderIdLabel1;
    private JTextField CNameLabel;
    private JTextField CAddrLabel;
    private JTextField ProductNmeLabel;
    private JTextField QOrderedLabel;
    private JTextField PricePULabel;
    private JTextField TPLabel;
    private JComboBox<String> statusComboBox;

    /**
     * Create the frame.
     */
    public OrderUpdate() {
        setTitle("Update Customer Order System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 792, 550);
        setLocationRelativeTo(null); // Center the frame
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 235, 205));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Update Customer Order");
        lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(244, 66, 264, 28);
        contentPane.add(lblNewLabel);

        // Add and configure the labels and text fields
        JLabel IdLabel = new JLabel("Order ID:");
        IdLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        IdLabel.setBounds(170, 106, 76, 13);
        contentPane.add(IdLabel);

        OrderIdLabel1 = new JTextField();
        OrderIdLabel1.setColumns(10);
        OrderIdLabel1.setBounds(308, 104, 181, 20);
        contentPane.add(OrderIdLabel1);

        JLabel CustomerLabel = new JLabel("Customer Name:");
        CustomerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        CustomerLabel.setBounds(170, 142, 116, 20);
        contentPane.add(CustomerLabel);

        CNameLabel = new JTextField();
        CNameLabel.setEditable(false);
        CNameLabel.setColumns(10);
        CNameLabel.setBounds(308, 144, 181, 20);
        contentPane.add(CNameLabel);

        JLabel CusAddLabel = new JLabel("Customer Address:");
        CusAddLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        CusAddLabel.setBounds(170, 180, 144, 26);
        contentPane.add(CusAddLabel);

        CAddrLabel = new JTextField();
        CAddrLabel.setColumns(10);
        CAddrLabel.setBounds(308, 185, 181, 20);
        contentPane.add(CAddrLabel);

        JLabel ProductLabel = new JLabel("Product Name:");
        ProductLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        ProductLabel.setBounds(170, 225, 97, 20);
        contentPane.add(ProductLabel);

        ProductNmeLabel = new JTextField();
        ProductNmeLabel.setEditable(false);
        ProductNmeLabel.setColumns(10);
        ProductNmeLabel.setBounds(308, 227, 181, 20);
        contentPane.add(ProductNmeLabel);

        JLabel QuantityLabel = new JLabel("Quantity Ordered :");
        QuantityLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        QuantityLabel.setBounds(170, 266, 127, 20);
        contentPane.add(QuantityLabel);

        QOrderedLabel = new JTextField();
        QOrderedLabel.setEditable(false);
        QOrderedLabel.setColumns(10);
        QOrderedLabel.setBounds(308, 268, 181, 20);
        contentPane.add(QOrderedLabel);

        JLabel PPUnitLabel = new JLabel("Price Per Unit:");
        PPUnitLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        PPUnitLabel.setBounds(170, 304, 116, 23);
        contentPane.add(PPUnitLabel);

        PricePULabel = new JTextField();
        PricePULabel.setEditable(false);
        PricePULabel.setColumns(10);
        PricePULabel.setBounds(308, 307, 181, 20);
        contentPane.add(PricePULabel);

        JLabel TotalLabel = new JLabel("Total Price:");
        TotalLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        TotalLabel.setBounds(170, 340, 93, 20);
        contentPane.add(TotalLabel);

        TPLabel = new JTextField();
        TPLabel.setEditable(false);
        TPLabel.setColumns(10);
        TPLabel.setBounds(308, 342, 179, 20);
        contentPane.add(TPLabel);

        JLabel StatusLabel = new JLabel("Order Status:");
        StatusLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        StatusLabel.setBounds(170, 385, 107, 20);
        contentPane.add(StatusLabel);

        // Add and configure the confirm button
        JButton ConfirmButton = new JButton("Confirm");
        ConfirmButton.setBounds(439, 440, 85, 21);
        contentPane.add(ConfirmButton);
        ConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateOrder(); // Update the order information
                dispose(); // Close the current frame
                OrderMenu orderMenu = new OrderMenu(null); // Instantiate OrderMenu
                orderMenu.setVisible(true); // Open the OrderMenu frame
            }
        });

        // Add and configure the reset button
        JButton ResetButton = new JButton("Reset");
        ResetButton.setBounds(229, 440, 85, 21);
        contentPane.add(ResetButton);
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields(); // Clear all input fields when reset button is pressed
            }
        });

        // Add and configure the combo box for order status
        statusComboBox = new JComboBox<>();
        statusComboBox.setBounds(308, 386, 181, 19);
        statusComboBox.addItem("Pending");
        statusComboBox.addItem("Shipped");
        statusComboBox.addItem("Delivered");
        statusComboBox.addItem("Cancelled");
        contentPane.add(statusComboBox);

        // Add and configure the enter button
        JButton EnterButton = new JButton("Enter");
        EnterButton.setBounds(499, 104, 85, 21);
        contentPane.add(EnterButton);

        EnterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderID = OrderIdLabel1.getText().trim();
                if (!orderID.isEmpty()) {
                    retrieveOrder(orderID); // Retrieve the order information for the given order ID
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter an Order ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Method to retrieve order information from the file
    private void retrieveOrder(String orderID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hakim\\Downloads\\orders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String currentOrderID = parts[0].trim();

                if (currentOrderID.equals(orderID)) {
                    // Populate the text fields with the order information
                    CNameLabel.setText(parts[1].trim());
                    CAddrLabel.setText(parts[2].trim());
                    ProductNmeLabel.setText(parts[3].trim());
                    QOrderedLabel.setText(parts[4].trim());
                    PricePULabel.setText(parts[5].trim());
                    TPLabel.setText(parts[6].trim());
                    statusComboBox.setSelectedItem(parts[7].trim());
                    return;
                }
            }
            // If the order ID is not found
            JOptionPane.showMessageDialog(null, "Order ID not found", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Method to update order information in the file
    private void updateOrder() {
        String orderID = OrderIdLabel1.getText().trim();
        String customerAddress = CAddrLabel.getText().trim();
        String orderStatus = (String) statusComboBox.getSelectedItem();

        if (orderID.isEmpty() || customerAddress.isEmpty()) {
            // If any field is empty, display an error message
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File file = new File("C:\\Users\\Hakim\\Downloads\\orders.txt");

        // Read the contents of orders.txt and store them in a StringBuilder
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String currentOrderID = parts[0].trim();

                if (currentOrderID.equals(orderID)) {
                    // Update the order details
                    line = orderID + "," + CNameLabel.getText().trim() + "," + customerAddress + "," + ProductNmeLabel.getText().trim()
                            + "," + QOrderedLabel.getText().trim() + "," + PricePULabel.getText().trim() + "," + TPLabel.getText().trim()
                            + "," + orderStatus;
                }

                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update order", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Write the updated contents back to orders.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update order", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Display success message
        JOptionPane.showMessageDialog(null, "Order updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to clear all input fields
    private void resetFields() {
        OrderIdLabel1.setText("");
        CNameLabel.setText("");
        CAddrLabel.setText("");
        ProductNmeLabel.setText("");
        QOrderedLabel.setText("");
        PricePULabel.setText("");
        TPLabel.setText("");
        statusComboBox.setSelectedIndex(0);
    }
}
