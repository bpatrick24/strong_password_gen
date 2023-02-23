import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class PasswordGenerator implements ActionListener, Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PasswordGenerator());
    }

    private JCheckBox upperCheckBox, lowerCheckBox, numCheckBox, symbolCheckBox;

    private JTextField textGenPassword;

    @Override
    public void run() {
        JFrame frame = new JFrame("Strong Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(createTitlePanel(), BorderLayout.NORTH);
        frame.add(createConfigurationPanel(), BorderLayout.WEST);
        frame.add(createMainPanel(), BorderLayout.CENTER);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setBackground(new Color(25, 25, 25));
        titlePanel.setPreferredSize(new Dimension(100, 60));

        JLabel title = new JLabel("Strong Password Generator");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Roboto", Font.BOLD, 20));
        titlePanel.add(title);

        return titlePanel;
    }

    private JPanel createConfigurationPanel() {
        JPanel configPanel = new JPanel(new GridLayout(0, 1, 20, 10));

        JLabel configTitle = new JLabel("  Configuration Settings  ");
        configTitle.setHorizontalAlignment(SwingConstants.CENTER);
        configTitle.setAlignmentX(JLabel.CENTER);
        configTitle.setForeground(Color.BLACK);
        configTitle.setBorder(new EmptyBorder(20, 0, 0, 0));
        configPanel.add(configTitle);

        Color backgroundColor = new Color(107, 208, 255);

        // uppercase group
        JLabel configUpperLabel = new JLabel();
        configUpperLabel.setText("Uppercase Letters");
        configUpperLabel.setHorizontalAlignment(SwingConstants.CENTER);
        configPanel.add(configUpperLabel);

        upperCheckBox = new JCheckBox();
        upperCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        upperCheckBox.setBackground(backgroundColor);
        configPanel.add(upperCheckBox);

        // lowercase group
        JLabel configLowerLabel = new JLabel("Lowercase Letters");
        configLowerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        configPanel.add(configLowerLabel);

        lowerCheckBox = new JCheckBox();
        lowerCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        lowerCheckBox.setBackground(backgroundColor);
        configPanel.add(lowerCheckBox);

        // num group
        JLabel configNumLabel = new JLabel("Numbers: ( e.g. 123)");
        configNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        configPanel.add(configNumLabel);

        numCheckBox = new JCheckBox();
        numCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        numCheckBox.setBackground(backgroundColor);
        configPanel.add(numCheckBox);

        // symbol group
        JLabel configSymbolLabel = new JLabel("Symbols: ( e.g. ! @ $)");
        configSymbolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        configPanel.add(configSymbolLabel);

        symbolCheckBox = new JCheckBox();
        symbolCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        symbolCheckBox.setBackground(backgroundColor);
        configPanel.add(symbolCheckBox);

        return configPanel;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(255, 255, 255));

        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = 0;
        textFieldConstraints.insets = new Insets(5, 5, 5, 5);

        textGenPassword = new JTextField(20);
        mainPanel.add(textGenPassword, textFieldConstraints);

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonConstraints.insets = new Insets(5, 5, 5, 5);

        JButton genButton = new JButton("Generate Password");
        genButton.addActionListener(this);
        mainPanel.add(genButton, buttonConstraints);

        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
        String combinedChars = "";

        if (upperCheckBox.isSelected()) {
            combinedChars += upper;
        }

        if (lowerCheckBox.isSelected()) {
            combinedChars += lower;
        }

        if (numCheckBox.isSelected()) {
            combinedChars += numbers;
        }

        if (symbolCheckBox.isSelected()) {
            combinedChars += symbols;
        }

        if (combinedChars.isEmpty()) {
            return;
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(16);

        for (int i = 0; i < 16; i++) {
            int num = random.nextInt(combinedChars.length());
            password.append(combinedChars.charAt(num));
        }

        textGenPassword.setText(password.toString());
    }

}


