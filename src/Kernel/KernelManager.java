package Kernel;

import java.util.Calendar;
import java.util.Random;

import GUI.Game;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * @author Lane 游戏进程管理
 * @备注 以单机游戏的想法暂时写的 Kelnel管理器，如果之后要改成局域网型的 这个类应该需要大改 比如分割 将统一的动作和玩家个人的动作分开
 */

public class KernelManager {

	public Card[] discard = new Card[148];
	public int disNum = 0;
	public int playerNum;
	private String[] playerLevel = new String[7];
	public static Paint[] color = new Paint[7];
	public Player[] player = new Player[7];
	private Board[] board = new Board[7];

	public KernelManager(int playerNum) {
		this.playerNum = playerNum;

		color[0] = Color.RED;
		color[1] = Color.ORANGE;
		color[2] = Color.BLACK;
		color[3] = Color.YELLOWGREEN;
		color[4] = Color.GREEN;
		color[5] = Color.BLUE;
		color[6] = Color.PURPLE;
		Paint[] temp = new Paint[1];
		Calendar c = Calendar.getInstance();
		Random random = new Random(c.get(Calendar.SECOND));
		for (int i = 0; i < this.playerNum; i++) {
			int a = random.nextInt() % 7;
			int b = random.nextInt() % 7;
			a = (a * a) % 7;
			b = (b * b) % 7;
			temp[0] = color[a];
			color[a] = color[b];
			color[b] = temp[0];

			BoardInfo bi = new BoardInfo();
			board[i] = bi.board[i];
		}

		// 随机奇迹板-或自选奇迹板

		// 设置结束

		for (int i = 0; i < this.playerNum; i++) {
			Manager m = new Manager();
			playerLevel[i] = m.getGUIManager().PlayerLevel[i]
					.getSelectionModel().getSelectedItem();
			player[i] = new Player(board[i], color[i]);
		}

	}

	public void initGame() {
		Manager m = new Manager();
		m.getGUIManager().getGroup().getChildren().clear();
		Game.setText(player);
		for (int i = 0; i < playerNum; i++) {
			player[i].turn.setChoose(2);
		}
	}

	public void nextTurn() {

	}

	public void addDiscard(Card card) {
		discard[disNum++] = card;
	}

	public void removeDiscard(Card card) {
		int i;
		for (i = 0; i < disNum; i++) {
			if (discard[i] == card)
				break;
		}
		for (; i < disNum - 1; i++)
			discard[i] = discard[i + 1];
		discard[disNum - 1] = null;
		disNum--;
	}
}
