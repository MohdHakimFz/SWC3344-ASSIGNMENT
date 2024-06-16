/*  Name : Mohd Hakim Bin Mohd Fauzi
	ID: AM2307014329
	Type: Assignment
*/
import java.awt.EventQueue;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class OrderDelete extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField EnterOrderIdLabel;

    /**
     * Create the frame.
     */
    public OrderDelete() {
        setTitle("Delete Order System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 792, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(244, 164, 96));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Add and configure the Delete Order label
        JLabel DeleteLabel = new JLabel("Delete Order ");
        DeleteLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
        DeleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        DeleteLabel.setBounds(262, 35, 186, 13);
        contentPane.add(DeleteLabel);

        // Add and configure the Order ID label
        JLabel IdLabel1 = new JLabel("Order ID:");
        IdLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
        IdLabel1.setBounds(178, 84, 63, 16);
        contentPane.add(IdLabel1);

        // Add and configure the text field for entering Order ID
        EnterOrderIdLabel = new JTextField();
        EnterOrderIdLabel.setBounds(251, 81, 212, 19);
        contentPane.add(EnterOrderIdLabel);
        EnterOrderIdLabel.setColumns(10);

        // Add and configure the Confirm button
        JButton ConfirmButton = new JButton("Confirm");
        ConfirmButton.setBounds(489, 80, 85, 21);
        contentPane.add(ConfirmButton);

        // Add action listener to the Confirm button
        ConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderId = EnterOrderIdLabel.getText().trim();
                deleteOrder(orderId); // Delete the order

                // Close the OrderDelete frame
                dispose();

                // Create and display the OrderMenu frame
                String username = OrderManagementSystem.getUsername();
                OrderMenu orderMenu = new OrderMenu(username);
                orderMenu.setVisible(true);
            }
        });
    }

    // Method to delete an order from the file
    private void deleteOrder(String orderId) {
        try {
            // File containing orders
            File inputFile = new File("C:\\Users\\Hakim\\Downloads\\orders.txt");
            // Temporary file to store updated orders
            File tempFile = new File("C:\\Users\\Hakim\\Downloads\\temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = orderId; // Order ID to be deleted
            String currentLine;

            // Read the file line by line
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.startsWith(lineToRemove)) continue; // Skip the line to be deleted
                writer.write(currentLine + System.getProperty("line.separator")); // Write other lines to temp file
            }
            writer.close();
            reader.close();

            // Delete the original file
            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            // Rename the temporary file to the original file
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename file");
            }
            
            // Display success message
            JOptionPane.showMessageDialog(this, "Order with ID " + orderId + " has been deleted successfully.");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "File not found: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading/writing file: " + ex.getMessage());
        }
    }
}
