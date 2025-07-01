import java.awt.*;
import javax.swing.*;

public class ToDoApp {

    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // North panel - input field and buttons
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        topPanel.add(taskField);
        topPanel.add(addButton);
        topPanel.add(deleteButton);

        // Center panel - task list
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Action for Add Button
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a task before adding.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Action for Delete Button
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Add components to Frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Show frame
        frame.setVisible(true);
    }
}