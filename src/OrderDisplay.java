/*  Name : Mohd Hakim Bin Mohd Fauzi
	ID: AM2307014329
	Type: Assignment
*/
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class OrderDisplay extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    /**
     * Create the frame.
     */
    public OrderDisplay() {
        setTitle("Order Display System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 792, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create a JScrollPane to hold the JTable
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 758, 453);
        contentPane.add(scrollPane);

        // Read data from orders.txt and populate JTable
        try {
            String[] columnNames = {"Order ID", "Customer Name", "Customer Address", "Product Name", "Quantity", "Price", "Total", "Status"};
            Object[][] data = readDataFromFile();

            // Create JTable with data and column names
            table = new JTable(data, columnNames);
            scrollPane.setViewportView(table);
            
            // Add a BackButton to return to OrderMenu
            JButton BackButton = new JButton("Back");
            BackButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
            BackButton.setBounds(328, 473, 105, 30);
            contentPane.add(BackButton);
            
            // Add ActionListener to the BackButton
            BackButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    goToOrderMenu(); // Method to go back to OrderMenu
                }
            });
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to read data from orders.txt and return as a 2D array
    private Object[][] readDataFromFile() throws Exception {
        String filePath = "C:\\Users\\Hakim\\Downloads\\orders.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int rows = 0;
        while (reader.readLine() != null) rows++;
        reader.close();

        Object[][] data = new Object[rows][8];
        reader = new BufferedReader(new FileReader(filePath));
        int row = 0;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            for (int i = 0; i < parts.length; i++) {
                data[row][i] = parts[i].trim();
            }
            row++;
        }
        reader.close();
        return data;
    }

    // Method to switch back to OrderMenu
    private void goToOrderMenu() {
        OrderMenu orderMenu = new OrderMenu(null); // Create a new OrderMenu frame
        orderMenu.setVisible(true); // Display the OrderMenu frame
        this.dispose(); // Close the current frame (OrderDisplay)
    }
}
