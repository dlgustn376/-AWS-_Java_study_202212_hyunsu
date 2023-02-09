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
	
	/**
	 * 
	 */
	// 소켓 통신에 필요한 것
	private static Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private BufferedReader reader;
	private PrintWriter writer;
	private Gson gson;
	
	private List<JTextField> loginFields;
	private List<JTextField> registerFields;
	
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
					socket = new Socket("127.0.0.1", 9090);
					
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				}catch (ConnectException e){ 
					JOptionPane.showMessageDialog(null, "서버에 연결할 수 없습니다.","접속실패", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e) {
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
			writer = new PrintWriter(outputStream,true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		gson = new Gson();
		
		loginFields = new  ArrayList<>();
		registerFields = new  ArrayList<>();
		
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
		
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject loginUser = new JsonObject();
				loginUser.addProperty("usernameAndEmail", usernameField.getText());
				loginUser.addProperty("password", passwordField.getText());
				
				UserService userService = UserService.getInstance();
				
				Map<String, String> response = userService.autorize(loginUser.toString());
				if(response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"),"error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
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
				clearFields(loginFields);
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
				clearFields(registerFields);
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
		
		registerPasswordField = new JTextField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.LEFT);
		registerPasswordField.setColumns(10);
		registerPasswordField.setBounds(80, 201, 230, 30);
		registerPanel.add(registerPasswordField);
		
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
		
		
		registerEmailField = new JTextField();
		registerEmailField.setHorizontalAlignment(SwingConstants.LEFT);
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(80, 309, 230, 30);
		registerPanel.add(registerEmailField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());
				
				RequestDto<String> requestDto = new RequestDto<String>("register",userJson.toString());
				writer.println(gson.toJson(requestDto));
				writer.flush();

				try {
					String response = reader.readLine();
					System.out.println("응답옴!");
					ResponseDto<?> responseDto = gson.fromJson(response, ResponseDto.class);
					if(responseDto.getCode().equals("error")) {
						JOptionPane.showMessageDialog(null, responseDto.getBody(), responseDto.getCode(), JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					JOptionPane.showMessageDialog(null, responseDto.getBody(), responseDto.getCode(), JOptionPane.INFORMATION_MESSAGE);
					mainCard.show(mainPanel, "loginPanel"); // 화면 전환 후 필드를 지워야 함.
					clearFields(registerFields);
					
//					System.out.println(responseDto);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
//				서비스 작업이 서버로 넘어감
				UserService userService = UserService.getInstance();
				Map<String, String> response = userService.register(userJson.toString());
			}
		});
		registerButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		registerButton.setBackground(Color.WHITE);
		registerButton.setBounds(80, 349, 230, 30);
		registerPanel.add(registerButton);
		
		loginFields.add(usernameField);
		loginFields.add(passwordField);
		
		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);
		
	}
	
	private void clearFields (List<JTextField> textFields) {
		for(JTextField field : textFields) {
			if(field.getText().isEmpty()) {
				continue;
			}
			field.setText("");
		}
		
	}
	
	
}
