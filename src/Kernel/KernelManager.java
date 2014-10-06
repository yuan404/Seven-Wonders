package Kernel;

/**
 * 游戏管理者类
 * 
 * @author Lane
 *
 */
public class KernelManager {
	/**
	 * 玩家信息组
	 */
	PlayerInfo[] infos;
	/**
	 * 玩家组
	 */
	Player[] players;
	/**
	 * 玩家总人数
	 */
	int playerNum;

	/**
	 * 构造函数
	 * 
	 * @param num
	 */
	public KernelManager(int num) {
		playerNum = num;
		infos = new PlayerInfo[num];
		players = new Player[num];
		CardInfo ci = new CardInfo();
		String[] cards = ci.getCardofHand(1, num);
		hands = new String[num][7];
		BoardInfo bi = new BoardInfo();
		bi.shuffle(0, 7);
		int k = 0;
		for (int i = 0; i < num; i++) {
			infos[i] = new PlayerInfo();
			players[i] = new Player(i);
			infos[i].board = bi.board[i];
			ci.getCardByName(infos[i].getName() + 0).update(infos[i]);
			System.out.print(ci.getCardByName(infos[i].getName() + 0)
					.getDetails());
			for (int j = 0; j < 7; j++) {
				hands[i][j] = cards[k++];
			}
		}

	}

	/**
	 * 得到玩家信息
	 */
	public PlayerInfo getInfo(int num) {
		return infos[num];
	}

	/**
	 * 得到左邻居玩家信息
	 */
	public PlayerInfo left(PlayerInfo info) {
		return infos[(info.index + playerNum + 1) % playerNum];
	}

	/**
	 * 得到右邻居玩家信息
	 */
	public PlayerInfo right(PlayerInfo info) {
		return infos[(info.index + playerNum - 1) % playerNum];
	}

	/**
	 * 手牌组
	 */
	String[][] hands;
}
