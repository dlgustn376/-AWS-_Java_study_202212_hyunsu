package windowBuilder.view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import windowBuilder.view.panel.MainPanel;

public class MainFrame extends JFrame {

//	private CardLayout mainCard;
//	private JPanel mainPanel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() { // 생성자
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
//		System.out.println(getWidth());

		MainPanel mainPanel = MainPanel.getInstance();
		mainPanel.init();
		setContentPane(mainPanel);
	}

}
