package simplechatting.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChattingClient extends JFrame {

	private Socket socket;
	private String username;

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList userList;
	private DefaultListModel<String> userlistModel;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(353, 10, 170, 32);
		contentPane.add(ipInput);
		ipInput.setColumns(10);

		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;

				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());

				try {
					socket = new Socket(ip, port);

					JOptionPane.showMessageDialog(null, socket.getInetAddress() + "서버 접속", "접속 성공",
							JOptionPane.INFORMATION_MESSAGE);

					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

					if (in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null, "사용자이름을 입력하세요.", JOptionPane.INFORMATION_MESSAGE);

						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);

						out.println(username);
					}

					Thread thread = new Thread(() -> {
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(input));

							while (true) {
								String message = reader.readLine();
								if (message.startsWith("@welcome")) { // out.println("@welcome/" + username + "님이
																		// 접속하였습니다.");
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1); // substring -> 해당 인덱스부터 문자열을 자르는 기능
								} else if (message.startsWith("@userList")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userlistModel.clear();
									for (String username : usernames) {
										userlistModel.addElement(username);
									}
									continue; 
								}
								contentView.append(message + "\n");
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					});

					thread.start();

				} catch (ConnectException e1) {
					JOptionPane.showMessageDialog(null, "서버 접속 실패", "접속 실패", JOptionPane.ERROR_MESSAGE);

				} catch (UnknownHostException e1) {
					e1.printStackTrace();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.setBounds(606, 9, 80, 33);
		contentPane.add(connectButton);

		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(535, 10, 59, 32);
		contentPane.add(portInput);
		portInput.setColumns(10);

		JScrollPane contentsScroll = new JScrollPane();
		contentsScroll.setBounds(12, 10, 329, 406);
		contentPane.add(contentsScroll);

		contentView = new JTextArea();
		contentsScroll.setViewportView(contentView);

		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(353, 52, 339, 364);
		contentPane.add(userListScroll);

		userlistModel = new DefaultListModel<>();

		userList = new JList();
		userListScroll.setViewportView(userList);

		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 455, 582, 46);
		contentPane.add(messageScroll);

		messageInput = new JTextField(); // 채팅입력 후 Enter키 입력 시 동작
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);

						out.println(username + " : " + messageInput.getText());
						messageInput.setText("");

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		messageScroll.setViewportView(messageInput);

		JButton sendButton = new JButton("전송"); // 텍스트 -> 서버로 전달
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!messageInput.getText().isBlank()) { // 비어있지 않을 때만 동작
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);

						out.println(username + " : " + messageInput.getText());
						messageInput.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		sendButton.setBounds(600, 455, 86, 46);
		contentPane.add(sendButton);
	}
}
