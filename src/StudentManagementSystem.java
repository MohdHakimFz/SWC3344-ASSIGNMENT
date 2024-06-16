import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    private String name;
    private int id;
    private String contactNumber;

    public Student(String name, int id, String contactNumber) {
        this.name = name;
        this.id = id;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

public class StudentManagementSystem extends JFrame implements ActionListener {
    private ArrayList<Student> students;
    private JTextField nameField, idField, contactField;
    private JTextArea displayArea;

    public StudentManagementSystem() {
        students = new ArrayList<>();

        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Contact Number:"));
        contactField = new JTextField();
        inputPanel.add(contactField);
        add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        buttonPanel.add(updateButton);
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);
        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(this);
        buttonPanel.add(displayButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Add")) {
            addStudent();
        } else if (command.equals("Update")) {
            updateStudent();
        } else if (command.equals("Delete")) {
            deleteStudent();
        } else if (command.equals("Display")) {
            displayStudents();
        }
    }

    private void addStudent() {
        String name = nameField.getText();
        int id;
        try {
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException e) {
            displayArea.append("Please enter a valid ID.\n");
            return;
        }
        String contactNumber = contactField.getText();
        Student student = new Student(name, id, contactNumber);
        students.add(student);
        clearFields();
        displayArea.append("Student added successfully.\n");
    }

    private void updateStudent() {
        int id;
        try {
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException e) {
            displayArea.append("Please enter a valid ID.\n");
            return;
        }
        for (Student student : students) {
            if (student.getId() == id) {
                student = new Student(nameField.getText(), id, contactField.getText());
                clearFields();
                displayArea.append("Student updated successfully.\n");
                return;
            }
        }
        displayArea.append("Student not found.\n");
    }

    private void deleteStudent() {
        int id;
        try {
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException e) {
            displayArea.append("Please enter a valid ID.\n");
            return;
        }
        for (Student student : students) {
            if (student.getId() == id) {
                int choice = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete this student?", "Confirm Delete",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    students.remove(student);
                    clearFields();
                    displayArea.append("Student deleted successfully.\n");
                    return;
                }
            }
        }
        displayArea.append("Student not found.\n");
    }

    private void displayStudents() {
        displayArea.setText("");
        for (Student student : students) {
            displayArea.append("Name: " + student.getName() + ", ID: " + student.getId() +
                    ", Contact Number: " + student.getContactNumber() + "\n");
        }
    }

    private void clearFields() {
        nameField.setText("");
        idField.setText("");
        contactField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentManagementSystem().setVisible(true);
            }
        });
    }
}
