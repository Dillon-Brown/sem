package com.napier.sem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportGenerator {

    private JButton runReportButton;
    private JPanel MainPanel;
    private JTextField inputField;
    private JTextArea textOutput;
    private JComboBox reportType;
    private String reportText;
    /**
     * Generate the report.
     */
    private ReportGenerator() {
        runReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportText = (reportType.getSelectedItem().toString());

                if (reportText == "World Population"){

                }
            }
        });
    }

    /**
     * Displays the main report generator form.
     */
    protected static void mainForm() {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new ReportGenerator().MainPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}