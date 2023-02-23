import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Main implements ActionListener{
	
	public final static String LOWER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public final static String UPPER = "abcdefghijklmnopqrstuvwxyz";
	public final static String NUMBERS = "0123456789";
	public final static String SYMBOLS = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
	static JButton genButton;
	static JTextField textGenPassword;
	static generatePassword password;
	static JCheckBox upperCheckBox;
	static JCheckBox lowerCheckBox;
	static JCheckBox numCheckBox;
	static JCheckBox symbolCheckBox;


	public static void main(String[] args) {
		
		
		password = new generatePassword();
		
		JFrame frame = new JFrame();
		JPanel titlePanel = new JPanel();	
		JPanel configPanel = new JPanel(); 
		JPanel mainPanel = new JPanel();
		JLabel title = new JLabel();
		JLabel configTitle = new JLabel();
		JCheckBox upperCheckBox = new JCheckBox();
		JCheckBox lowerCheckBox = new JCheckBox();
		JCheckBox numCheckBox = new JCheckBox();
		JCheckBox symbolCheckBox = new JCheckBox();
		JLabel configUpperLabel = new JLabel();
		JLabel configLowerLabel = new JLabel();
		JLabel configNumLabel = new JLabel();
		JLabel configSymbolLabel = new JLabel();
		textGenPassword = new JTextField();
		genButton = new JButton("Generate Password");
		
		//Title panel
		titlePanel.setBackground(new Color(25, 25, 25));
		titlePanel.setPreferredSize(new Dimension(100,100));
		titlePanel.add(title);
		titlePanel.setLayout(new GridBagLayout());
		
		title.setText("Strong Password Generator");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Roboto", Font.BOLD, 20));
		
		//Config Panel
		configPanel.add(configTitle);
		configPanel.setLayout(new GridLayout(9,1,20,10));
		configTitle.setText("Configuration Settings");
		configTitle.setHorizontalAlignment(SwingConstants.CENTER);
		configTitle.setAlignmentX(JLabel.CENTER);
		configTitle.setForeground(Color.BLACK);
		Border configBorder = new EmptyBorder(20, 0, 0, 0);
		configTitle.setBorder(configBorder);
		
		
		//upercase group
		configPanel.add(configUpperLabel);
		configUpperLabel.setText("Uppercase Letters");
		configUpperLabel.setHorizontalAlignment(SwingConstants.CENTER);
		configPanel.add(upperCheckBox);
		upperCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		upperCheckBox.setBackground(new Color(107, 208, 255));
		

		//lowercase group
		configPanel.add(configLowerLabel);
		configLowerLabel.setText("Lowercase Letters");
		configLowerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		configPanel.add(lowerCheckBox);
		lowerCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		lowerCheckBox.setBackground(new Color(107, 208, 255));
		
		//num group
		configPanel.add(configNumLabel);
		configNumLabel.setText("Numbers: ( e.g. 123)");
		configNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		configPanel.add(numCheckBox);
		numCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		numCheckBox.setBackground(new Color(107, 208, 255));
		
		//symbol group
		configPanel.add(configSymbolLabel);
		configSymbolLabel.setText("Symbols: ( e.g. ! @ $)");
		configSymbolLabel.setHorizontalAlignment(SwingConstants.CENTER);
		configPanel.add(symbolCheckBox);
		symbolCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		symbolCheckBox.setBackground(new Color(107, 208, 255));

		
		configPanel.setBackground(new Color(107, 208, 255));
		configPanel.setPreferredSize(new Dimension(200,150));
	

		//Main panel
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setPreferredSize(new Dimension(200, 150));

		textGenPassword.setPreferredSize(new Dimension(250, 25));
		textGenPassword.setLocation(100, 100);
		textGenPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
		genButton.addActionListener(password);

		//gridbag constraints
		GridBagConstraints textFieldConstraints = new GridBagConstraints();
		textFieldConstraints.gridx = 0; 
		textFieldConstraints.gridy = 0; 
		textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
		textFieldConstraints.insets = new Insets(5, 5, 5, 5); 

		
		mainPanel.add(textGenPassword, textFieldConstraints);

		
		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.gridx = 0; 
		buttonConstraints.gridy = 1; 
		buttonConstraints.insets = new Insets(5, 5, 5, 5); 

		mainPanel.add(genButton, buttonConstraints);
		
		frame.setSize(900,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		
		frame.add(titlePanel,BorderLayout.NORTH);
		frame.add(configPanel,BorderLayout.WEST);
		frame.add(mainPanel,BorderLayout.CENTER);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == genButton) {
			textGenPassword.setText(password.genPassword());
		}
		
	}



}


