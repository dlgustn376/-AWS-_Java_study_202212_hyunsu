package windowBuilder;

import java.awt.EventQueue;

import windowBuilder.view.frame.MainFrame;

public class UserManagementApplication {
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		
		Runnable runnable = new Runnable() { // 익명클래스
			public void run() {
				try {
					
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		EventQueue.invokeLater(runnable);
	}

	/**
	 * Create the frame.
	 */
	

}
