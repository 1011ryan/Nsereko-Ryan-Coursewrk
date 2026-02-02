/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package studentregistrationform;

import javax.swing.*;
import java.awt.*;

public class StudentRegistrationForm extends JFrame {

    JTextField txtFirstName, txtLastName, txtEmail, txtConfirmEmail;
    JPasswordField txtPassword, txtConfirmPassword;

    JComboBox<String> cbYear, cbMonth, cbDay;

    JRadioButton rbMale, rbFemale;
    JRadioButton rbCivil, rbCSE, rbElectrical, rbEC, rbMech;

    JTextArea outputArea;

    JButton btnSubmit, btnCancel;

    public StudentRegistrationForm() {

        setTitle("New Student Registration Form");
        setSize(950, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("New Student Registration Form", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        // ===== LEFT PANEL =====
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;

        // WIDE TEXTFIELDS
        txtFirstName = new JTextField(30);
        txtLastName = new JTextField(30);
        txtEmail = new JTextField(30);
        txtConfirmEmail = new JTextField(30);
        txtPassword = new JPasswordField(30);
        txtConfirmPassword = new JPasswordField(30);

        int y = 0;
        addRow(leftPanel, gbc, y++, "Student First Name", txtFirstName);
        addRow(leftPanel, gbc, y++, "Student Last Name", txtLastName);
        addRow(leftPanel, gbc, y++, "Email Address", txtEmail);
        addRow(leftPanel, gbc, y++, "Confirm Email Address", txtConfirmEmail);
        addRow(leftPanel, gbc, y++, "Password", txtPassword);
        addRow(leftPanel, gbc, y++, "Confirm Password", txtConfirmPassword);

        // DOB
        gbc.gridx = 0; gbc.gridy = y;
        leftPanel.add(new JLabel("Date of Birth"), gbc);

        cbYear = new JComboBox<>();
        cbMonth = new JComboBox<>();
        cbDay = new JComboBox<>();

        cbYear.addItem("Year");
        cbMonth.addItem("Month");
        cbDay.addItem("Day");

        for (int i = 2026; i >= 1950; i--)
            cbYear.addItem(String.valueOf(i));

        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        for (String m : months)
            cbMonth.addItem(m);

        for (int i = 1; i <= 31; i++)
            cbDay.addItem(String.valueOf(i));

        JPanel dobPanel = new JPanel();
        dobPanel.add(cbYear);
        dobPanel.add(cbMonth);
        dobPanel.add(cbDay);

        gbc.gridx = 1;
        leftPanel.add(dobPanel, gbc);
        y++;

        // Gender
        gbc.gridx = 0; gbc.gridy = y;
        leftPanel.add(new JLabel("Gender"), gbc);

        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        JPanel genderPanel = new JPanel();
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);

        gbc.gridx = 1;
        leftPanel.add(genderPanel, gbc);
        y++;

        // Department
        gbc.gridx = 0; gbc.gridy = y;
        leftPanel.add(new JLabel("Department"), gbc);

        rbCivil = new JRadioButton("Civil");
        rbCSE = new JRadioButton("Computer Science and Engineering");
        rbElectrical = new JRadioButton("Electrical");
        rbEC = new JRadioButton("Electronics and Communication");
        rbMech = new JRadioButton("Mechanical");

        ButtonGroup deptGroup = new ButtonGroup();
        deptGroup.add(rbCivil);
        deptGroup.add(rbCSE);
        deptGroup.add(rbElectrical);
        deptGroup.add(rbEC);
        deptGroup.add(rbMech);

        JPanel deptPanel = new JPanel(new GridLayout(5,1));
        deptPanel.add(rbCivil);
        deptPanel.add(rbCSE);
        deptPanel.add(rbElectrical);
        deptPanel.add(rbEC);
        deptPanel.add(rbMech);

        gbc.gridx = 1;
        leftPanel.add(deptPanel, gbc);
        y++;

        // Buttons
        btnSubmit = new JButton("Submit");
        btnCancel = new JButton("Cancel");

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnSubmit);
        btnPanel.add(btnCancel);

        gbc.gridx = 1; gbc.gridy = y;
        leftPanel.add(btnPanel, gbc);

        // ===== RIGHT PANEL =====
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));

        JLabel outLabel = new JLabel("Your Data is Below:");
        outLabel.setFont(new Font("Arial", Font.BOLD, 14));

        outputArea = new JTextArea(15, 30);
        outputArea.setEditable(false);

        rightPanel.add(outLabel, BorderLayout.NORTH);
        rightPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        add(leftPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        // Sample action
        btnSubmit.addActionListener(e -> {
            outputArea.setText(
                txtFirstName.getText() + " " +
                txtLastName.getText() + " | " +
                txtEmail.getText()
            );
        });
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int y,
                        String label, JComponent field) {
        gbc.gridx = 0; gbc.gridy = y;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new StudentRegistrationForm().setVisible(true)
        );
    }
}

