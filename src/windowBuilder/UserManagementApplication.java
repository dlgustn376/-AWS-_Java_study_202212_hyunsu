package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import windowBuilder.view.frame.MainFrame;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class UserManagementApplication {

	private CardLayout mainCard;
	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
//	public UserManagementApplication() { // 생성자
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 600, 500);
//
//		mainCard = new CardLayout();
//		
//		mainPanel = new JPanel(); // 전체 컨텐츠의 패널
//		mainPanel.setLayout(mainCard);
//		mainPanel.setBorder(null);
//
//		setContentPane(mainPanel);
//	}

}
