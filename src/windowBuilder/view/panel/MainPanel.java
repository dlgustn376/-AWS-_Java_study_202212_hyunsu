package windowBuilder.view.panel;

import java.awt.CardLayout;

import lombok.Data;

@Data
public class MainPanel extends InitPanel{
//	메인 패널 안에서 화면 전환이 일어남
//	싱글톤으로 만들어야 함
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout mainCard;
	private static MainPanel instance;
	
	public static MainPanel getInstance() {
		if(instance == null) {
			instance = new MainPanel();
		}
		return instance;
	}
	
	
	public MainPanel() {
		mainCard = new CardLayout();
		setLayout(mainCard);
	}
	
	public void init() {
		LoginPanel loginPanel = new LoginPanel();
		add(loginPanel, "loginPanel");

		RegisterPanel registerPanel = new RegisterPanel();
		add(registerPanel, "registerPanel");
	}
	
	
}
