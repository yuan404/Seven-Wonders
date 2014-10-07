package Kernel;

import AI.AI0;

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
	 */
	public KernelManager() {

	}

	/**
	 * 预加载函数
	 * 
	 * @param num
	 */
	public void init(int num) {
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
			// System.out.print(infos[i].board.getName() + "\n");
			// for (int n = 0; n < 24; n++)
			// System.out.print(infos[i].board.cards[0].getDetails()[n]);
			for (int j = 0; j < 7; j++) {
				hands[i][j] = cards[k++];
			}
			infos[i].getCoin += 3;
		}
		for (int n = 0; n < 3; n++) {
			for (int j = 0; j < 6; j++) {
				for (int i = 0; i < playerNum; i++) {
					AI0 ai0 = new AI0();
					ai0.load(players[i]);
				}
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
	 * 从字符串中添加一个元素
	 * 
	 * @param strs
	 * @param str
	 */
	public void addString(String[] strs, String str) {
		int i = 0;
		while (strs[i] != null) {
			i++;
		}
		strs[i] = str;
	}

	/**
	 * 从字符串中删除目标元素
	 * 
	 * @param strs
	 * @param str
	 */
	public void removeString(String[] strs, String str) {
		int i = 0;
		System.out.print(str + "\n");
		while (strs[i] != str) {
			i++;
		}
		for (; i < strs.length - 1; i++)
			strs[i] = strs[i + 1];
		strs[strs.length - 1] = null;
	}

	/**
	 * 弃牌卡牌
	 */
	String[] disCard = new String[150];
	/**
	 * 弃牌数
	 */
	int disNum = 0;

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
			addString(disCard, player.card);
			disNum++;
		}
		System.out.print(player.choose + " ");
		removeString(hands[i], player.card);
		player.clear();
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

	/**
	 * 时代阶数
	 */
	public int age = 1;
	/**
	 * 回合阶数
	 */
	protected int turnNum = 1;

	/**
	 * 回合结束
	 */
	public void endTurn() {
		for (int i = 0; i < playerNum; i++) {
			if (players[i].card == null || players[i].card == "")
				return;
		}
		turnNum++;
		for (int i = 0; i < playerNum; i++) {
			updateTurn(players[i]);
		}
		for (int i = 0; i < playerNum; i++) {
			infos[i].getCoin += infos[i].right().left.getCoin
					- infos[i].right().left.realCoin;
			infos[i].getCoin += infos[i].left().right.getCoin
					- infos[i].left().right.realCoin;
		}
		if (turnNum == 7) {
			endAge();
			return;
		}
		if (age == 2) {
			String[] temp = hands[0];
			for (int i = 0; i < playerNum - 1; i++) {
				hands[i] = hands[i + 1];
			}
			hands[playerNum - 1] = temp;
		} else {
			String[] temp = hands[playerNum - 1];
			for (int i = playerNum - 1; i > 0; i--) {
				hands[i] = hands[i - 1];
			}
			hands[0] = temp;
		}
		System.out.print(turnNum + "\n");
	}

	/**
	 * 更新时代
	 */
	public void updateAge() {

	}

	/**
	 * 结束时代
	 */
	public void endAge() {
		System.out.print("\n");
		age++;
		if (age == 4) {
			endGame();
			return;
		}
		CardInfo ci = new CardInfo();
		String[] cards = ci.getCardofHand(age, playerNum);
		int k = 0;
		for (int i = 0; i < playerNum; i++) {
			for (int j = 0; j < 7; j++) {
				hands[i][j] = cards[k++];
			}
		}
		turnNum = 1;
	}

	/**
	 * 游戏结束
	 */
	public void endGame() {
		System.out.print("name" + " red" + " coin" + " stage" + " blue"
				+ " yellow" + " purple" + " green" + " total" + "\n");
		for (int i = 0; i < playerNum; i++) {
			System.out.print(infos[i].board.getName() + " "
					+ infos[i].GforceScore + " " + infos[i].getCoin / 3 + " "
					+ infos[i].getBoardScore + " " + infos[i].getBlueScore
					+ " " + infos[i].GyellowScore + " " + infos[i].GpurpleScore
					+ " " + infos[i].GgreenScore + " ");
			System.out.print(infos[i].GforceScore + infos[i].getCoin / 3
					+ infos[i].getBoardScore + infos[i].getBlueScore
					+ infos[i].GyellowScore + infos[i].GpurpleScore
					+ infos[i].GgreenScore + "\n");
		}
	}
}
