package com.sbi;

import com.sbi.view.WelcomePage;

import javax.swing.*;

public class MainApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(WelcomePage::new);
    }
}
