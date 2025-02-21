package com.sbi.view;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

import com.sbi.database.DBConnection;

public class AdminDashboard extends JFrame {

    private JLabel lblName, lblEmail, lblPhone, lblRole, lblPhoto;
    private JTextField txtName, txtEmail, txtPhone, txtRole;
    private ImageIcon profileImage;

    public AdminDashboard(String username) {
        setTitle("State Bank of India");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for content
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Labels
        lblName = new JLabel("Full Name:");
        lblEmail = new JLabel("Email:");
        lblPhone = new JLabel("Phone:");
        lblRole = new JLabel("Role:");
        lblPhoto = new JLabel();

        // Text Fields (Non-editable)
        txtName = new JTextField(20);
        txtEmail = new JTextField(20);
        txtPhone = new JTextField(20);
        txtRole = new JTextField(10);

        txtName.setEditable(false);
        txtEmail.setEditable(false);
        txtPhone.setEditable(false);
        txtRole.setEditable(false);

        // Load Data
        loadAdminData(username);

        // Layout Management
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblName, gbc);
        gbc.gridx = 1; panel.add(txtName, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblEmail, gbc);
        gbc.gridx = 1; panel.add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblPhone, gbc);
        gbc.gridx = 1; panel.add(txtPhone, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblRole, gbc);
        gbc.gridx = 1; panel.add(txtRole, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2; panel.add(lblPhoto, gbc);

        // Adding Panel
        add(panel, BorderLayout.CENTER);

        // Display the frame
        setVisible(true);
    }

    private void loadAdminData(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT full_name, email, phone, role, passport_photo FROM users WHERE username=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Set text fields
                txtName.setText(rs.getString("full_name"));
                txtEmail.setText(rs.getString("email"));
                txtPhone.setText(rs.getString("phone"));
                txtRole.setText(rs.getString("role"));

                // Load image from database
                Blob blob = rs.getBlob("passport_photo");
                if (blob != null) {
                    byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                    ImageIcon icon = new ImageIcon(imageBytes);
                    Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    lblPhoto.setIcon(new ImageIcon(img));
                } else {
                    lblPhoto.setText("No Photo");
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AdminDashboard("admin");
    }
}
