package Kernel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
	 * 时间字符串
	 */
	String time;
	/**
	 * 时间格式
	 */
	SimpleDateFormat df;
	/**
	 * 写入文件句柄-总
	 */
	FileWriter fileWriter;
	FileWriter[] fw = new FileWriter[5];

	/**
	 * 构造函数
	 * 
	 */
	public KernelManager() {
	}

	/**
	 * AI名称
	 */
	String[] a;
	AI AI0;
	AI AI1;
	AI AI2;
	AI AI3;
	AI AI4;

	/**
	 * AI-init
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void initAI(Class<?> ai0, Class<?> ai1, Class<?> ai2, Class<?> ai3,
			Class<?> ai4, String[] a) throws InstantiationException,
			IllegalAccessException {
		AI0 = (AI) ai0.newInstance();
		AI1 = (AI) ai1.newInstance();
		AI2 = (AI) ai2.newInstance();
		AI3 = (AI) ai3.newInstance();
		AI4 = (AI) ai4.newInstance();
		this.a = a;
	}

	/**
	 * 预加载函数
	 * 
	 * @param num
	 * @throws IOException
	 */
	public void init(int num, String t) throws IOException {
		playerNum = num;
		infos = new PlayerInfo[num];
		players = new Player[num];
		CardInfo ci = new CardInfo();
		String[] cards = ci.getCardofHand(1, num);
		hands = new String[num][7];
		BoardInfo bi = new BoardInfo();
		bi.shuffle(0, 7);
		// TODO 得到当前时间
		df = new SimpleDateFormat("yyyyMMddHHmmss");
		time = df.format(System.currentTimeMillis());
		int k = 0;
		File file = new File("D:\\workspace\\result" + "-" + a[0] + "-" + a[1]
				+ "-" + a[2] + "-" + a[3] + "-" + a[4] + "-" + t);
		file.mkdirs();

		for (int i = 0; i < num; i++) {
			infos[i] = new PlayerInfo(i);
			players[i] = new Player(i);
			infos[i].board = bi.board[i];
			infos[i].board.cards[0].update(infos[i]);
			// for (int n = 0; n < 24; n++)
			// System.out.print(infos[i].board.cards[0].getDetails()[n]);
			for (int j = 0; j < 7; j++) {
				hands[i][j] = cards[k++];
			}
			infos[i].getCoin += 3;
		}
		// TODO Log
		try {
			// TODO 句柄地址
			fileWriter = new FileWriter("D:\\workspace/result" + "-" + a[0]
					+ "-" + a[1] + "-" + a[2] + "-" + a[3] + "-" + a[4] + "-"
					+ t + "/" + time + "-total.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO AI
		while (turnNum != 7) {
			if (turnNum == 1)
				if (age == 1) {
					for (int i = 0; i < num; i++)
						fw[i] = new FileWriter("D:\\workspace/result" + "-"
								+ a[0] + "-" + a[1] + "-" + a[2] + "-" + a[3]
								+ "-" + a[4] + "-" + t + "/" + time + "-" + i
								+ ".txt");
				}
			fileWriter.write(1 + "\r\n");
			AI0.load(players[0]);
			AI1.load(players[1]);
			AI2.load(players[2]);
			AI3.load(players[3]);
			AI4.load(players[4]);
		}
		fileWriter.flush();
		fileWriter.close();
		for (int i = 0; i < num; i++) {
			fw[i].flush();
			fw[i].close();
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
		try {
			fileWriter.write(str + "\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	 * @throws IOException
	 */
	public void updateTurn(Player player) throws IOException {
		int i = player.getIndex();
		if (player.choose == 1) {
			CardInfo.getCardByName(player.card)
					.update(infos[player.getIndex()]);
			CardInfo.getCardByName(player.card).addColor(
					infos[player.getIndex()]);
			infos[player.getIndex()].addFreeCard(player.card);
			infos[i].addCard(CardInfo.getCardByName(player.card));
			fw[i].write(CardInfo.getCardByName(player.card).getDetailsCost()
					+ "\r\n");
		} else if (player.choose == 2) {
			infos[player.getIndex()].board.cards[infos[player.getIndex()].board.age + 1]
					.update(infos[i]);
			infos[player.getIndex()].board.age++;
			fw[i].write(infos[player.getIndex()].board.cards[infos[player
					.getIndex()].board.age + 1].getDetailsCost() + "\r\n");
		} else {
			infos[player.getIndex()].getCoin += 3;
			addString(disCard, player.card);
			disNum++;
		}
		if (player.choose == 1) {
			fileWriter.write(infos[i].board.getName()
					+ space(infos[i].board.getName(), 20) + " build ");
			fw[i].write("build ");
		} else if (player.choose == 2) {
			fileWriter.write(infos[i].board.getName()
					+ space(infos[i].board.getName(), 20) + " stage ");
			fw[i].write("stage ");
		} else {
			fileWriter.write(infos[i].board.getName()
					+ space(infos[i].board.getName(), 20) + " sold ");
			fw[i].write("sold ");
		}
		fw[i].write(infos[i].getDetail());
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
	 * 
	 * @throws IOException
	 */
	public void endTurn() throws IOException {
		for (int i = 0; i < playerNum; i++) {
			// TODO Error punish
			if (players[i].aiChoose == true && players[i].choose != 3) {
				players[i].setChoose(hands[i][0], 3);
				fw[i].write("\r\nError\r\n");
				players[i].aiChoose = false;
			}
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
		fileWriter.write(turnNum + "\r\n");
	}

	/**
	 * 更新时代
	 * 
	 * @throws IOException
	 */
	public void updateAge(PlayerInfo info) throws IOException {
		if (info.getForce < info.left().getForce) {
			info.failTimes++;
			info.GforceScore -= 1;
			fileWriter.write(info.getForce + " " + info.board.getName() + " "
					+ info.left().getForce + " " + info.left().board.getName()
					+ " " + age + " " + "\r\n");
		} else if (info.getForce > info.left().getForce) {
			info.GforceScore += age * 2 - 1;
			fileWriter.write(info.getForce + " " + info.board.getName() + " "
					+ info.left().getForce + " " + info.left().board.getName()
					+ " " + age + " " + "\r\n");
		} else
			fileWriter.write(info.getForce + " " + info.board.getName() + " "
					+ info.left().getForce + " " + info.left().board.getName()
					+ " " + age + " " + "\r\n");
		if (info.getForce < info.right().getForce) {
			info.failTimes++;
			info.GforceScore -= 1;
			fileWriter.write(info.getForce + " " + info.board.getName() + " "
					+ info.right().getForce + " "
					+ info.right().board.getName() + " " + age + " " + "\r\n");
		} else if (info.getForce > info.right().getForce) {
			info.GforceScore += age * 2 - 1;
			fileWriter.write(info.getForce + " " + info.board.getName() + " "
					+ info.right().getForce + " "
					+ info.right().board.getName() + " " + age + " " + "\r\n");
		} else
			fileWriter.write(info.getForce + " " + info.board.getName() + " "
					+ info.right().getForce + " "
					+ info.right().board.getName() + " " + age + " " + "\r\n");
	}

	/**
	 * 结束时代
	 * 
	 * @throws IOException
	 */
	public void endAge() throws IOException {
		for (int i = 0; i < playerNum; i++)
			updateAge(infos[i]);
		fileWriter.write("\r\n");
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
	 * 
	 * @throws IOException
	 */
	public void endGame() throws IOException {
		fileWriter.write("name" + space("name", 20) + "red   " + "  coin  "
				+ "  stage " + "  blue  " + "  yellow" + "  purple"
				+ "  green " + "  total " + "\r\n");
		for (int i = 0; i < playerNum; i++) {
			// TODO 绿分
			getGreenScore(infos[i]);
			// TODO 黄分和紫分
			checkScore(infos[i]);

			fileWriter.write(infos[i].board.getName()
					+ space(infos[i].board.getName(), 20)
					+ infos[i].GforceScore + space("", 7) + infos[i].getCoin
					/ 3 + space("", 7) + infos[i].getBoardScore + space("", 7)
					+ infos[i].getBlueScore + space("", 7)
					+ infos[i].GyellowScore + space("", 7)
					+ infos[i].GpurpleScore + space("", 7)
					+ infos[i].GgreenScore + space("", 7));
			fileWriter.write(infos[i].GforceScore + infos[i].getCoin / 3
					+ infos[i].getBoardScore + infos[i].getBlueScore
					+ infos[i].GyellowScore + infos[i].GpurpleScore
					+ infos[i].GgreenScore + "\r\n");
		}
		fileWriter.write("name" + space("name", 20) + "red   " + " brown "
				+ "  gray  " + "  blue  " + "  yellow" + "  purple"
				+ "  green " + "  stage " + "\r\n");
		for (int i = 0; i < playerNum; i++) {
			fileWriter.write(infos[i].board.getName()
					+ space(infos[i].board.getName(), 20) + infos[i].redNum
					+ space("", 7) + infos[i].brownNum + space("", 7)
					+ infos[i].grayNum + space("", 7) + infos[i].blueNum
					+ space("", 7) + infos[i].yellowNum + space("", 7)
					+ infos[i].purpleNum + space("", 7) + infos[i].greenNum
					+ space("", 7) + infos[i].board.age + "\r\n");
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
