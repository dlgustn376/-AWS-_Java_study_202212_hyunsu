package simplechatting.client;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChattingClient extends JFrame {
	
	private Socket socket;
	private String username;
	
	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList userList;
	private DefaultListModel<String> userListModel;
	
	
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
		setBounds(100, 100, 570, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(319, 10, 116, 30);
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
					socket = new Socket(ip,port);
					
					JOptionPane.showMessageDialog(null, 
							socket.getInetAddress() + "서버 접속", 
							"접속성공", 
							JOptionPane.INFORMATION_MESSAGE);
					
					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream)); 
					
					if(in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null, 
										"사용자 이름을 입력하세요", 
										JOptionPane.INFORMATION_MESSAGE);
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						
						// 다중 Thread를 할 때 전부 줘야 함.
						out.println(username);

						ipInput.setText("");
						portInput.setText("");
					}
					
					Thread thread = new Thread(()->{
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(input));
							
							while(true) {
								String message = reader.readLine();
								if(message.startsWith("@welcome")) {
									int tokenIndex = message.indexOf("/");
//									substring(시작, 끝 전까지) 인덱스 부터 잘라라.
									message = message.substring(tokenIndex + 1);
								}else if(message.startsWith("@userList")) {
									int tokenIndex = message.indexOf("/");
//									substring(시작, 끝 전까지) 인덱스 부터 잘라라.
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userListModel.clear();
									for(String username : usernames) {
//										addElement 인덱스 자동 증가
										userListModel.addElement(username);
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
					
				}catch (ConnectException e1) {
						
					JOptionPane.showMessageDialog(null, 
							"서버 접속 실패", 
							"접속실패", 
							JOptionPane.ERROR_MESSAGE);
						
				} catch (UnknownHostException e1) {
					
					JOptionPane.showMessageDialog(null, 
							"서버 접속 실패", 
							"접속실패", 
							JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		connectButton.setBounds(483, 9, 59, 31);
		contentPane.add(connectButton);
		
		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(436, 10, 45, 30);
		contentPane.add(portInput);
		portInput.setColumns(10);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 10, 295, 342);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(319, 50, 223, 302);
		contentPane.add(userListScroll);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 362, 437, 39);
		contentPane.add(messageScroll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(!messageInput.getText().isBlank()) {
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter out = new PrintWriter(outputStream, true);
							
							out.println(username + ':' + messageInput.getText());
							messageInput.setText("");
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!messageInput.getText().isBlank()) {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						
						out.println(username + ':' + messageInput.getText());
						messageInput.setText("");
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		sendButton.setBounds(450, 362, 92, 39);
		contentPane.add(sendButton);
	}
}
