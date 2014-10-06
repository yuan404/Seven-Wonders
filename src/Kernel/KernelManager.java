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
			infos[i].board.cards[0].update(infos[i]);
			System.out.print(infos[i].board.getName() + "\n");
			for (int n = 0; n < 24; n++)
				System.out.print(infos[i].board.cards[0].getDetails()[n]);
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
	protected String[][] hands;

	/**
	 * 得到手牌
	 * 
	 * @return
	 */
	public String[] getHands(int num) {
		return hands[num];
	}

	/**
	 * 回合更新
	 * 
	 * @param player
	 */
	public void updateTurn(Player player) {
		int i = player.getIndex();
		CardInfo ci = new CardInfo();
		if (player.choose == 1) {
			ci.getCardByName(player.card).update(infos[player.getIndex()]);
			ci.getCardByName(player.card).addColor(infos[player.getIndex()]);
			infos[player.getIndex()].addFreeCard(player.card);
		} else if (player.choose == 2) {
			infos[player.getIndex()].board.cards[infos[player.getIndex()].board.age + 1]
					.update(infos[player.getIndex()]);
			infos[player.getIndex()].board.age++;
		} else {
			infos[player.getIndex()].getCoin += 3;
		}
		if (infos[i].LRMGrayCoin == true) {
			infos[i].LRMGrayCoin = false;
			infos[i].getCoin += infos[i].grayNum * 2;
			infos[i].getCoin += infos[i].right().grayNum * 2;
			infos[i].getCoin += infos[i].left().grayNum * 2;
		}
		if (infos[i].LRMBrownCoin == true) {
			infos[i].LRMBrownCoin = false;
			infos[i].getCoin += infos[i].brownNum;
			infos[i].getCoin += infos[i].right().brownNum;
			infos[i].getCoin += infos[i].left().brownNum;
		}
		if (infos[i].GrayCoin == true) {
			infos[i].GrayCoin = false;
			infos[i].getCoin += infos[i].grayNum * 2;
		}
		if (infos[i].BrownCoin == true) {
			infos[i].BrownCoin = false;
			infos[i].getCoin += infos[i].brownNum;
		}
		if (infos[i].YellowCoin == true) {
			infos[i].YellowCoin = false;
			infos[i].getCoin += infos[i].yellowNum;
		}
		if (infos[i].StageCoin == true) {
			infos[i].StageCoin = false;
			infos[i].getCoin += infos[i].board.age * 3;
		}
	}

	public void updateAge() {

	}
}
