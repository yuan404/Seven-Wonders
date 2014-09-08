package Kernel;

/**
 * @author Lane 游戏进程管理
 */

public class KernelManager {

	private int playerNum;
	private String[] playerLevel = new String[7];

	public KernelManager(int playerNum) {
		this.playerNum = playerNum;
		for (int i = 0; i < playerNum; i++) {
			Manager m = new Manager();
			playerLevel[i] = m.getGUIManager().PlayerLevel[i]
					.getSelectionModel().getSelectedItem();
		}
	}

	public void initGame() {
		System.out.print(playerNum);
	}

	public void nextTurn() {

	}
}
