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
			infos[i] = new PlayerInfo(i);
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
	public PlayerInfo left(int index) {
		return infos[(index + playerNum + 1) % playerNum];
	}

	/**
	 * 得到右邻居玩家信息
	 */
	public PlayerInfo right(int index) {
		return infos[(index + playerNum - 1) % playerNum];
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
					.update(infos[i]);
			infos[player.getIndex()].board.age++;
		} else {
			infos[player.getIndex()].getCoin += 3;
			addString(disCard, player.card);
			disNum++;
		}
		if (player.choose == 1)
			System.out.print("build ");
		else if (player.choose == 2)
			System.out.print("stage ");
		else
			System.out.print("sold ");
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
			infos[i].getCoin += infos[i].right().left.putCoin
					- infos[i].right().left.realCoin;
			infos[i].getCoin += infos[i].left().right.putCoin
					- infos[i].left().right.realCoin;
		}
		if (turnNum == 7) {
			endAge();
			return;
		}
		// TODO BUG!!!
		if (turnNum == 8)
			return;
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
	public void updateAge(PlayerInfo info) {
		if (info.getForce < info.left().getForce) {
			info.failTimes++;
			info.GforceScore -= 1;
			System.out.print(info.getForce + " " + info.board.getName() + " "
					+ info.left().getForce + " " + info.left().board.getName()
					+ " " + age + " " + "\n");
		} else if (info.getForce > info.left().getForce) {
			info.GforceScore += age * 2 - 1;
			System.out.print(info.getForce + " " + info.board.getName() + " "
					+ info.left().getForce + " " + info.left().board.getName()
					+ " " + age + " " + "\n");
		} else
			System.out.print(info.getForce + " " + info.board.getName() + " "
					+ info.left().getForce + " " + info.left().board.getName()
					+ " " + age + " " + "\n");
		if (info.getForce < info.right().getForce) {
			info.failTimes++;
			info.GforceScore -= 1;
			System.out.print(info.getForce + " " + info.board.getName() + " "
					+ info.right().getForce + " "
					+ info.right().board.getName() + " " + age + " " + "\n");
		} else if (info.getForce > info.right().getForce) {
			info.GforceScore += age * 2 - 1;
			System.out.print(info.getForce + " " + info.board.getName() + " "
					+ info.right().getForce + " "
					+ info.right().board.getName() + " " + age + " " + "\n");
		} else
			System.out.print(info.getForce + " " + info.board.getName() + " "
					+ info.right().getForce + " "
					+ info.right().board.getName() + " " + age + " " + "\n");
	}

	/**
	 * 结束时代
	 */
	public void endAge() {
		for (int i = 0; i < playerNum; i++)
			updateAge(infos[i]);
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
		System.out.print("name" + space("name", 20) + "red   " + "  coin  "
				+ "  stage " + "  blue  " + "  yellow" + "  purple"
				+ "  green " + "  total " + "\n");
		for (int i = 0; i < playerNum; i++) {
			// TODO 绿分
			getGreenScore(infos[i]);
			// TODO 黄分和紫分
			checkScore(infos[i]);

			System.out.print(infos[i].board.getName()
					+ space(infos[i].board.getName(), 20)
					+ infos[i].GforceScore + space("", 7) + infos[i].getCoin
					/ 3 + space("", 7) + infos[i].getBoardScore + space("", 7)
					+ infos[i].getBlueScore + space("", 7)
					+ infos[i].GyellowScore + space("", 7)
					+ infos[i].GpurpleScore + space("", 7)
					+ infos[i].GgreenScore + space("", 7));
			System.out.print(infos[i].GforceScore + infos[i].getCoin / 3
					+ infos[i].getBoardScore + infos[i].getBlueScore
					+ infos[i].GyellowScore + infos[i].GpurpleScore
					+ infos[i].GgreenScore + "\n");
		}
		System.out.print("name" + space("name", 20) + "red   " + " brown "
				+ "  gray  " + "  blue  " + "  yellow" + "  purple"
				+ "  green " + "  stage " + "\n");
		for (int i = 0; i < playerNum; i++) {
			System.out.print(infos[i].board.getName()
					+ space(infos[i].board.getName(), 20) + infos[i].redNum
					+ space("", 7) + infos[i].brownNum + space("", 7)
					+ infos[i].grayNum + space("", 7) + infos[i].blueNum
					+ space("", 7) + infos[i].yellowNum + space("", 7)
					+ infos[i].purpleNum + space("", 7) + infos[i].greenNum
					+ space("", 7) + infos[i].board.age + "\n");
		}
	}

	/**
	 * 获得绿色科技分
	 * 
	 * @param info
	 * @return
	 */
	public void getGreenScore(PlayerInfo info) {
		while (info.getLiteraturePhysicsMath > 0) {
			int a = checkGreen(info.getLiterature + 1, info.getPhysics,
					info.getMath);
			int b = checkGreen(info.getLiterature, info.getPhysics + 1,
					info.getMath);
			int c = checkGreen(info.getLiterature, info.getPhysics,
					info.getMath + 1);
			info.getLiteraturePhysicsMath--;
			if (a > b && a > c) {
				info.getLiterature++;
			} else if (b > a && b > c) {
				info.getPhysics++;
			} else
				info.getMath++;
		}
		info.GgreenScore = checkGreen(info.getLiterature, info.getPhysics,
				info.getMath);
	}

	/**
	 * 科技计算函数
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int checkGreen(int a, int b, int c) {
		int green = 0;
		green += a * a;
		green += b * b;
		green += c * c;
		int series = Math.min(a, b);
		series = Math.min(series, c);
		green += 7 * series;
		return green;
	}

	/**
	 * 黄分和紫分计算
	 * 
	 * @param Aplayer
	 */
	public void checkScore(PlayerInfo Aplayer) {
		if (Aplayer.GrayScore == true) {
			Aplayer.GyellowScore += Aplayer.grayNum * 2;
		}
		if (Aplayer.BrownScore == true) {
			Aplayer.GyellowScore += Aplayer.brownNum;
		}
		if (Aplayer.YellowScore == true) {
			Aplayer.GyellowScore += Aplayer.yellowNum;
		}
		if (Aplayer.StageScore == true) {
			Aplayer.GyellowScore += Aplayer.board.age;
		}
		if (Aplayer.GuildBlue == true) {
			Aplayer.GpurpleScore += Aplayer.right().blueNum;
			Aplayer.GpurpleScore += Aplayer.left().blueNum;
		}
		if (Aplayer.GuildBrown == true) {
			Aplayer.GpurpleScore += Aplayer.right().brownNum;
			Aplayer.GpurpleScore += Aplayer.left().brownNum;
		}
		if (Aplayer.GuildGray == true) {
			Aplayer.GpurpleScore += Aplayer.right().grayNum * 2;
			Aplayer.GpurpleScore += Aplayer.left().grayNum * 2;
		}
		if (Aplayer.GuildYellow == true) {
			Aplayer.GpurpleScore += Aplayer.right().yellowNum;
			Aplayer.GpurpleScore += Aplayer.left().yellowNum;
		}
		if (Aplayer.GuildGreen == true) {
			Aplayer.GpurpleScore += Aplayer.right().greenNum;
			Aplayer.GpurpleScore += Aplayer.left().greenNum;
		}
		if (Aplayer.GuildRed == true) {
			Aplayer.GpurpleScore += Aplayer.right().redNum;
			Aplayer.GpurpleScore += Aplayer.left().redNum;
		}
		if (Aplayer.GuildForce == true) {
			Aplayer.GpurpleScore += Aplayer.right().failTimes;
			Aplayer.GpurpleScore += Aplayer.left().failTimes;
		}
		if (Aplayer.GuildMixed == true) {
			Aplayer.GpurpleScore += Aplayer.brownNum;
			Aplayer.GpurpleScore += Aplayer.grayNum;
			Aplayer.GpurpleScore += Aplayer.purpleNum;
		}
		if (Aplayer.GuildStage == true) {
			Aplayer.GpurpleScore += Aplayer.board.age;
			Aplayer.GpurpleScore += Aplayer.right().board.age;
			Aplayer.GpurpleScore += Aplayer.left().board.age;
		}
	}

	public String space(String str, int num) {
		int n = 0;
		if (str.length() < num) {
			n = num - str.length();
		}
		String s = new String();
		for (int i = 0; i < n; i++)
			s += " ";
		return s;
	}
}
