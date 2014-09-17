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

	// 弃牌
	public Card[] discard = new Card[148];
	// 弃牌数目
	public int disNum = 0;
	// 玩家数目
	public int playerNum;
	// 电脑AI
	private String[] playerLevel = new String[7];
	// 人物颜色
	public static Paint[] color = new Paint[7];
	// 玩家信息
	public Player[] player = new Player[7];
	// 奇迹板信息
	private Board[] board = new Board[7];
	// 初始手牌总计
	public Card[] cardHand;
	// 手牌信息
	public Hand[] hand;
	// 卡牌信息初始总计
	public CardInfo ci = new CardInfo();
	// 回合数
	public int times = 1;
	// 时代
	public int age = 1;

	public KernelManager(int playerNum) {
		this.playerNum = playerNum;

		// 手牌数组
		hand = new Hand[playerNum];
		// TODO 初始化人物颜色
		color[0] = Color.RED;
		color[1] = Color.ORANGE;
		color[2] = Color.BLACK;
		color[3] = Color.YELLOWGREEN;
		color[4] = Color.GREEN;
		color[5] = Color.BLUE;
		color[6] = Color.PURPLE;
		// TODO 随机颜色及生成奇迹板
		Paint[] temp = new Paint[1];
		Board bd;

		Calendar c = Calendar.getInstance();
		Random random = new Random(c.get(Calendar.SECOND));

		BoardInfo bi = new BoardInfo();

		for (int i = 0; i < this.playerNum; i++) {
			int a = random.nextInt() % 7;
			int b = random.nextInt() % 7;
			a = Math.abs(a) % 7;
			b = Math.abs(b) % 7;
			temp[0] = color[a];
			color[a] = color[b];
			color[b] = temp[0];

			bd = bi.board[a];
			bi.board[a] = bi.board[b];
			bi.board[b] = bd;
		}
		for (int i = 0; i < this.playerNum; i++) {
			board[i] = bi.board[i];
		}
		// TODO 生成第一时代卡牌
		cardHand = ci.getCard(1, playerNum);
		// TODO 设置难度(AI)及初始化玩家
		for (int i = 0; i < this.playerNum; i++) {
			Manager m = new Manager();
			playerLevel[i] = m.getGUIManager().PlayerLevel[i]
					.getSelectionModel().getSelectedItem();
			player[i] = new Player(board[i], color[i], i);
		}
	}

	// TODO 初始化游戏
	public void initGame() {
		Manager m = new Manager();
		// TODO 清理界面，把引导界面清空
		m.getGUIManager().getGroup().getChildren().clear();
		// TODO 加入蓝分和红战斗力
		Game.setText(player);
		// TODO 生成手牌
		for (int i = 0; i < playerNum; i++) {
			hand[i] = new Hand();
			for (int j = 0; j < 7; j++) {
				hand[i].card[hand[i].cardNum++] = cardHand[i * 7 + j];
			}
		}
		// TODO 加入初始化游戏背景
		m.getGUIManager().startGame();
		// TODO 呈现玩家手牌
		for (int i = 0; i < 7; i++) {
			if (hand[0].card[i] != null) {
				Game.addCard(player[0], hand[0].card[i], i, 7);
			}
		}
		// TODO 初始化奇迹板收益
		for (int i = 0; i < playerNum; i++) {
			player[i].turn.setChoose(2);
			player[i].turn.update(player[i], player[i].board);
			MathGame.doAction(player[i]);
		}
		// TODO 玩家初始三块金币
		for (int i = 0; i < playerNum; i++) {
			player[i].Gcoin += 3;
			Game.updateCoin(player[i]);
		}
		// TODO next结束后，进行AI测试
		for (int i = 0; i < playerNum; i++) {
			if (playerLevel[i] != "Player")
				AI.Level1(player[i]);
		}
	}

	// TODO 下一回合,清理痕迹
	public void nextTurn() {
		// TODO 回合数加1
		times++;
		// TODO 买的资源只能使用一回合-清理，回合缓存中德牌及选择也清掉
		for (int i = 0; i < playerNum; i++) {
			player[i].Bbrick = 0;
			player[i].Bcloth = 0;
			player[i].Bglass = 0;
			player[i].Bore = 0;
			player[i].Bpaper = 0;
			player[i].Bstone = 0;
			player[i].Bwood = 0;
			player[i].turn.Gcoin = 0;
			player[i].turn.card = null;
			player[i].turn.choose = 0;
		}
		// TODO 换手牌
		changeHand(age);
		// TODO 显示手牌给玩家一号，即唯一的真实人物
		for (int i = 0; i < hand[0].cardNum; i++) {
			if (hand[0].card[i] != null) {
				Game.addCard(player[0], hand[0].card[i], i, hand[0].cardNum);
			}
		}
		// TODO next结束后，进行AI测试
		for (int i = 0; i < playerNum; i++) {
			if (playerLevel[i] != "Player")
				AI.Level1(player[i]);
		}
	}

	// TODO 增加弃牌
	public void addDiscard(Card card) {
		discard[disNum++] = card;
	}

	// TODO 丢失弃牌
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

	// TODO 判断是不是所有人都进行了操作
	public void checkTurn() {
		for (int i = 0; i < playerNum; i++) {
			if (player[i].turn.card == null)
				return;
			else
				System.out.print("玩家" + i + "选择出牌" + player[i].turn.card.name
						+ "\n");
		}
		System.out.print("时代" + age + "回合" + times + "\n");
		for (int i = 0; i < playerNum; i++) {
			if (player[i].turn.choose == 0) {
				MathGame.doAction(player[i], player[i].turn.card, true);
				addDiscard(player[i].turn.card);
			} else if (player[i].turn.choose == 1) {
				player[i].turn.update(player[i], player[i].turn.card);
				MathGame.doAction(player[i], player[i].turn.card);
				player[i].addCard(player[i].turn.card);
				Game.hideCard(player[i], player[i].turn.card);
			} else {
				player[i].turn.update(player[i], player[i].board);
				MathGame.doAction(player[i]);
				Game.updateStage(player[i]);
			}
			hand[i].removeHand(player[i].turn.card);
			Game.updateCoin(player[i]);
		}
		Manager m = new Manager();
		m.getGUIManager().updateDiscard();
		// TODO 更新蓝分和红战斗力
		Game.setText(player);
		m.getGUIManager().updateRedBlue();
		if (times < 6)
			nextTurn();
		else if (age < 3) {
			endAge();
			newAge();
		} else {
			endAge();
			endGame();
		}
	}

	public void endGame() {
		Manager m = new Manager();
		m.getGUIManager().ScoreBoard();
		for (int i = 0; i < playerNum; i++)
			m.getGUIManager().score(player[i]);
	}

	// TODO 结束时代
	public void endAge() {
		Manager m = new Manager();
		// TODO 把旧时代的卡牌扔入弃牌堆
		for (int i = 0; i < playerNum; i++) {
			for (int j = 0; j < hand[i].cardNum; j++)
				addDiscard(hand[i].card[j]);
		}
		// TODO 更新弃牌数目标志
		m.getGUIManager().updateDiscard();
		// TODO 时代战争
		for (int i = 0; i < playerNum; i++) {
			battle(player[i]);
		}
	}

	// TODO 新时代
	public void newAge() {
		// TODO 时代数增加
		age++;
		Manager m = new Manager();
		// TODO 改变时代标志
		m.getGUIManager().newAge(age);
		// TODO 回合数变为0
		times = 0;
		// TODO 生成新时代卡牌
		cardHand = ci.getCard(age, playerNum);
		// TODO 生成新时代手牌
		for (int i = 0; i < playerNum; i++) {
			hand[i] = new Hand();
			for (int j = 0; j < 7; j++) {
				hand[i].card[hand[i].cardNum++] = cardHand[i * 7 + j];
			}
		}
		nextTurn();
	}

	// TODO 换手牌
	public void changeHand(int age) {
		Hand h = new Hand();
		if (age == 1 || age == 3) {
			h = hand[playerNum - 1];
			for (int i = playerNum - 1; i > 0; i--) {
				hand[i] = hand[i - 1];
			}
			hand[0] = h;
		} else if (age == 2) {
			h = hand[0];
			for (int i = 0; i < playerNum - 1; i++) {
				hand[i] = hand[i + 1];
			}
			hand[playerNum - 1] = h;
		}
		for (int i = 0; i < playerNum; i++) {
			System.out.print("手牌玩家" + i + "#");
			for (int j = 0; j < hand[0].cardNum; j++)
				System.out.print(j + ":" + hand[i].card[j].name + " ");
			System.out.print("\n");
		}
	}

	public void battle(Player Aplayer) {
		Manager m = new Manager();
		if (Aplayer.index == 0) {
			if (Aplayer.Gforce > player[Aplayer.index + 1].Gforce) {
				m.getGUIManager().addLeftForce(Aplayer, age, true);
				Aplayer.GforceScore += age * 2 - 1;
			} else if (Aplayer.Gforce < player[Aplayer.index + 1].Gforce) {
				m.getGUIManager().addLeftForce(Aplayer, age, false);
				Aplayer.GforceScore -= 1;
			}
			if (Aplayer.Gforce > player[playerNum - 1].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addRightForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[playerNum - 1].Gforce) {
				Aplayer.GforceScore -= 1;
				m.getGUIManager().addRightForce(Aplayer, age, false);
			}
		} else if (Aplayer.index != playerNum - 1) {
			if (Aplayer.Gforce > player[Aplayer.index - 1].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addRightForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[Aplayer.index - 1].Gforce) {
				Aplayer.GforceScore -= 1;
				m.getGUIManager().addRightForce(Aplayer, age, false);
			}
			if (Aplayer.Gforce > player[Aplayer.index + 1].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addLeftForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[Aplayer.index + 1].Gforce) {
				Aplayer.GforceScore -= 1;
				m.getGUIManager().addLeftForce(Aplayer, age, false);
			}
		} else {
			if (Aplayer.Gforce > player[0].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addRightForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[0].Gforce) {
				Aplayer.GforceScore -= 1;
				m.getGUIManager().addRightForce(Aplayer, age, false);
			}
			if (Aplayer.Gforce > player[Aplayer.index - 1].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addLeftForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[Aplayer.index - 1].Gforce) {
				Aplayer.GforceScore -= 1;
				m.getGUIManager().addLeftForce(Aplayer, age, false);
			}
		}
	}
}
