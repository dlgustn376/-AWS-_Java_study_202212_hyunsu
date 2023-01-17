package usermanagement.frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserManagementFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernameField;
	private JTextField registerNameField;
	private JTextField registerPasswordField;
	private JTextField registerEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));
		
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		JLabel logoText = new JLabel("UserManagement");
		logoText.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(90, 50, 190, 30);
		loginPanel.add(logoText);
		
		JLabel loginText = new JLabel("Login");
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		loginText.setBounds(150, 90, 60, 30);
		loginPanel.add(loginText);
		
		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.LEFT);
		usernameField.setBounds(80, 195, 230, 30);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(80, 248, 230, 30);
		loginPanel.add(passwordField);
		
		JLabel usernameLabel = new JLabel("Username or email");
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setFont(new Font("굴림", Font.BOLD, 12));
		usernameLabel.setBounds(80, 175, 159, 20);
		loginPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("굴림", Font.BOLD, 12));
		passwordLabel.setBounds(80, 233, 66, 15);
		loginPanel.add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		loginButton.setBounds(80, 296, 230, 30);
		loginPanel.add(loginButton);
		
		JLabel signupDesc = new JLabel("Don`t have an account?");
		signupDesc.setHorizontalAlignment(SwingConstants.CENTER);
		signupDesc.setBounds(100, 336, 138, 15);
		loginPanel.add(signupDesc);
		
		JLabel signupLink = new JLabel("Sing up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
			}
		});
		signupLink.setHorizontalAlignment(SwingConstants.CENTER);
		signupLink.setForeground(new Color(0, 0, 255));
		signupLink.setBounds(242, 336, 47, 15);
		loginPanel.add(signupLink);
		
		JLabel forgorPasswordLink = new JLabel("Forgot yout password or email?");
		forgorPasswordLink.setHorizontalAlignment(SwingConstants.CENTER);
		forgorPasswordLink.setForeground(Color.BLUE);
		forgorPasswordLink.setBounds(99, 350, 190, 15);
		loginPanel.add(forgorPasswordLink);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);
		
		JLabel registerSigninLink = new JLabel("Sign in");
		registerSigninLink.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		registerSigninLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
			}
		});
		registerSigninLink.setForeground(new Color(0, 0, 255));
		registerSigninLink.setHorizontalAlignment(SwingConstants.CENTER);
		registerSigninLink.setBounds(134, 382, 122, 30);
		registerPanel.add(registerSigninLink);
		
		JLabel registerLogoText = new JLabel("UserManagement");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		registerLogoText.setBounds(90, 50, 190, 30);
		registerPanel.add(registerLogoText);
		
		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		registerText.setBounds(140, 90, 94, 30);
		registerPanel.add(registerText);
		
		JLabel registerUsernameLabel = new JLabel("Username");
		registerUsernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerUsernameLabel.setFont(new Font("굴림", Font.BOLD, 12));
		registerUsernameLabel.setBounds(80, 130, 74, 15);
		registerPanel.add(registerUsernameLabel);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setHorizontalAlignment(SwingConstants.LEFT);
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(80, 150, 230, 30);
		registerPanel.add(registerUsernameField);
		
		JLabel registerPasswordLabel = new JLabel("password");
		registerPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerPasswordLabel.setFont(new Font("굴림", Font.BOLD, 12));
		registerPasswordLabel.setBounds(80, 185, 66, 15);
		registerPanel.add(registerPasswordLabel);
		
		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerNameLabel.setFont(new Font("굴림", Font.BOLD, 12));
		registerNameLabel.setBounds(80, 237, 159, 15);
		registerPanel.add(registerNameLabel);
		
		registerNameField = new JTextField();
		registerNameField.setHorizontalAlignment(SwingConstants.LEFT);
		registerNameField.setColumns(10);
		registerNameField.setBounds(80, 257, 230, 30);
		registerPanel.add(registerNameField);
		
		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerEmailLabel.setFont(new Font("굴림", Font.BOLD, 12));
		registerEmailLabel.setBounds(80, 295, 66, 15);
		registerPanel.add(registerEmailLabel);
		
		registerPasswordField = new JTextField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.LEFT);
		registerPasswordField.setColumns(10);
		registerPasswordField.setBounds(80, 201, 230, 30);
		registerPanel.add(registerPasswordField);
		
		registerEmailField = new JTextField();
		registerEmailField.setHorizontalAlignment(SwingConstants.LEFT);
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(80, 309, 230, 30);
		registerPanel.add(registerEmailField);
		
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		registerButton.setBackground(Color.WHITE);
		registerButton.setBounds(80, 349, 230, 30);
		registerPanel.add(registerButton);
	}
}
