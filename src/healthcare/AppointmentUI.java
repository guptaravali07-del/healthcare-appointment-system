package healthcare;

import javax.swing.*;
import java.awt.*;

public class AppointmentUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setTitle("Healthcare Appointment System");
        frame.setSize(650, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        panel.setLayout(new GridLayout(6, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel nameLabel = new JLabel("Patient Name:");
        JTextField nameField = new JTextField();

        JLabel ageLabel = new JLabel("Patient Age:");
        JTextField ageField = new JTextField();

        JLabel doctorLabel = new JLabel("Select Doctor:");

        String[] doctors = {
            "Dr. Smith - Cardiologist",
            "Dr. Harsha - Neurologist",
            "Dr. John - Dermatologist"
        };

        JComboBox<String> doctorBox = new JComboBox<>(doctors);

        JLabel dateLabel = new JLabel("Appointment Date:");
        JTextField dateField = new JTextField();

        JLabel timeLabel = new JLabel("Appointment Time:");

        String[] times = {
            "9:00 AM",
            "10:00 AM",
            "11:00 AM",
            "12:00 PM",
            "2:00 PM",
            "3:00 PM",
            "4:00 PM"
        };

        JComboBox<String> timeBox = new JComboBox<>(times);

        JButton bookButton = new JButton("Book Appointment");
        JButton cancelButton = new JButton("Cancel");
       
        bookButton.setBackground(new Color(0, 102, 153));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFocusPainted(false);

        cancelButton.setBackground(new Color(220, 53, 69));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(ageLabel);
        panel.add(ageField);

        panel.add(doctorLabel);
        panel.add(doctorBox);

        panel.add(dateLabel);
        panel.add(dateField);

        panel.add(timeLabel);
        panel.add(timeBox);

        panel.add(bookButton);
        panel.add(cancelButton);
        bookButton.addActionListener(e -> {

            String name = nameField.getText();
            String age = ageField.getText();
            String doctor = (String) doctorBox.getSelectedItem();
            String date = dateField.getText();
            String time = (String) timeBox.getSelectedItem();

            if (name.isBlank() || age.isBlank() || date.isBlank()) {

                JOptionPane.showMessageDialog(frame,
                        "Please fill in all fields.");
                return;
            }

            try {

                int patientAge = Integer.parseInt(age);

                if (patientAge <= 0 || patientAge > 120) {

                    JOptionPane.showMessageDialog(frame,
                            "Please enter an age between 1 and 120.");
                    return;
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(frame,
                        "Please enter a valid numeric age.");
                return;
            }

            JOptionPane.showMessageDialog(frame,
                    "Appointment booked successfully!\n\n"
                    + "Patient: " + name + "\n"
                    + "Age: " + age + "\n"
                    + "Doctor: " + doctor + "\n"
                    + "Date: " + date + "\n"
                    + "Time: " + time);
        });
        
        cancelButton.addActionListener(e -> {

            nameField.setText("");
            ageField.setText("");
            dateField.setText("");

            doctorBox.setSelectedIndex(0);
            timeBox.setSelectedIndex(0);

            JOptionPane.showMessageDialog(frame,
                    "Appointment form cleared.");
        });
        
        JLabel header = new JLabel("Healthcare Appointment System");

        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setBackground(new Color(0, 102, 153));
        header.setForeground(Color.WHITE);
        header.setOpaque(true);
        header.setPreferredSize(new Dimension(600, 70));

        frame.add(header, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}