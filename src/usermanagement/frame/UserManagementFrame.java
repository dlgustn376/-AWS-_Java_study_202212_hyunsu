package usermanagement.frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import usermanagement.dto.RequestDto;
import usermanagement.dto.ResponseDto;
import usermanagement.service.UserService;

public class UserManagementFrame extends JFrame {

	private List<JTextField> loginFields;
	private List<JTextField> registerFields;

	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField registerPasswordField;
	private JTextField registerUsernameField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	private static Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private BufferedReader reader;
	private PrintWriter writer;
	private Gson gson;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 9090);

					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (ConnectException e) {
					JOptionPane.showMessageDialog(null, "서버에 연결할 수 없습니다.", "접속실패", JOptionPane.ERROR_MESSAGE);

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

		try {
			inputStream = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream));
			outputStream = socket.getOutputStream();
			writer = new PrintWriter(outputStream, true);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		gson = new Gson();

		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();

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

		JLabel logoText = new JLabel("User Management");
		logoText.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 45));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(12, 10, 360, 86);
		loginPanel.add(logoText);

		JLabel loginText = new JLabel("login");
		loginText.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 40));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(12, 76, 360, 45);
		loginPanel.add(loginText);

		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(12, 166, 360, 31);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(12, 240, 360, 31);
		loginPanel.add(passwordField);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 30));
		passwordLabel.setBounds(12, 207, 360, 31);
		loginPanel.add(passwordLabel);

		JLabel usernameLabel = new JLabel("Username or email");
		usernameLabel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 30));
		usernameLabel.setBounds(12, 125, 360, 31);
		loginPanel.add(usernameLabel);

		JButton loginButton = new JButton("Login"); // 로그인 버튼

		loginButton.addMouseListener(new MouseAdapter() {
			@Override // 익명클래스
			public void mouseClicked(MouseEvent e) {
				JsonObject loginUser = new JsonObject();
				loginUser.addProperty("usernameAndEmail", usernameField.getText());
				loginUser.addProperty("password", passwordField.getText());

				UserService userService = UserService.getInstance();

				Map<String, String> response = userService.authorize(loginUser.toString());

				if (response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		loginButton.setFont(new Font("D2Coding ligature", Font.BOLD | Font.ITALIC, 20));
		loginButton.setBounds(12, 285, 360, 45);
		loginPanel.add(loginButton);

		JLabel signupDesc = new JLabel("Don't have an account?");
		signupDesc.setFont(new Font("D2Coding ligature", Font.BOLD | Font.ITALIC, 15));
		signupDesc.setBounds(54, 355, 181, 15);
		loginPanel.add(signupDesc);

		JLabel signupLink = new JLabel("Sign Up");
		signupLink.addMouseListener(new MouseAdapter() { // 익명클래스
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
				clearFields(loginFields);
			}
		});
		signupLink.setForeground(new Color(0, 255, 255));
		signupLink.setFont(new Font("D2Coding ligature", Font.BOLD | Font.ITALIC, 15));
		signupLink.setBounds(247, 355, 57, 15);
		loginPanel.add(signupLink);

		JLabel forgotPasswordLink = new JLabel("Forgot your password?");
		forgotPasswordLink.setFont(new Font("D2Coding ligature", Font.BOLD | Font.ITALIC, 15));
		forgotPasswordLink.setHorizontalAlignment(SwingConstants.CENTER);
		forgotPasswordLink.setForeground(new Color(0, 255, 255));
		forgotPasswordLink.setBounds(106, 402, 181, 15);
		loginPanel.add(forgotPasswordLink);

		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);

		JLabel registerText = new JLabel("Register");
		registerText.setBounds(12, 62, 360, 45);
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 40));
		registerPanel.add(registerText);

		JLabel SigninLink = new JLabel("Sign in");
		SigninLink.setHorizontalAlignment(SwingConstants.CENTER);
		SigninLink.setForeground(new Color(0, 128, 255));
		SigninLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		SigninLink.setFont(new Font("D2Coding ligature", Font.BOLD | Font.ITALIC, 15));
		SigninLink.setBounds(193, 425, 179, 15);
		registerPanel.add(SigninLink);

		JLabel registerLogoText = new JLabel("User Management");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 45));
		registerLogoText.setBounds(12, 10, 360, 53);
		registerPanel.add(registerLogoText);

		JLabel registerUsernameLabel = new JLabel("Username");
		registerUsernameLabel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 30));
		registerUsernameLabel.setBounds(12, 109, 360, 31);
		registerPanel.add(registerUsernameLabel);

		registerPasswordField = new JPasswordField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		registerPasswordField.setBounds(12, 224, 360, 31);
		registerPanel.add(registerPasswordField);

		registerUsernameField = new JTextField();
		registerUsernameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(12, 150, 360, 31);
		registerPanel.add(registerUsernameField);

		JLabel registerPasswordLabel = new JLabel("Password");
		registerPasswordLabel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 30));
		registerPasswordLabel.setBounds(12, 191, 360, 31);
		registerPanel.add(registerPasswordLabel);

		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 30));
		registerNameLabel.setBounds(12, 265, 360, 31);
		registerPanel.add(registerNameLabel);

		registerNameField = new JTextField();
		registerNameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerNameField.setColumns(10);
		registerNameField.setBounds(12, 306, 360, 31);
		registerPanel.add(registerNameField);

		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 30));
		registerEmailLabel.setBounds(12, 347, 360, 31);
		registerPanel.add(registerEmailLabel);

		registerEmailField = new JTextField();
		registerEmailField.setHorizontalAlignment(SwingConstants.CENTER);
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(12, 380, 360, 31);
		registerPanel.add(registerEmailField);

		JButton registerButton = new JButton("Register"); // 마우스 클릭시 행동 , textfield
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());

				RequestDto<String> requestDto = new RequestDto<String>("register", userJson.toString());
				writer.println(gson.toJson(requestDto));
				writer.flush(); // 버퍼를 싹 비우는 역할을 한다.

				try {
					String response = reader.readLine();
					System.out.println("응답옴");
					ResponseDto<?> responseDto = gson.fromJson(response, ResponseDto.class);

					if (responseDto.getCode().equals("error")) {
						JOptionPane.showMessageDialog(null, responseDto.getBody(), responseDto.getCode(),
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					JOptionPane.showMessageDialog(null, responseDto.getBody(), responseDto.getCode(),
							JOptionPane.INFORMATION_MESSAGE);
					mainCard.show(mainPanel, "loginPanel");
					clearFields(registerFields);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		registerButton.setBounds(12, 421, 97, 23);
		registerPanel.add(registerButton);

		loginFields.add(usernameField);
		loginFields.add(passwordField);

		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);

	}

	private void clearFields(List<JTextField> textFields) {
		for (JTextField field : textFields) {
			if (field.getText().isEmpty()) {
				continue;
			}
			field.setText("");
		}
	}
}
