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
		// TODO 呈现玩家手牌
		for (int i = 0; i < 7; i++) {
			if (hand[0].card[i] != null) {
				Game.addCard(player[0], hand[0].card[i], i, 7);
				if (MathGame.ifBuild(player[0], hand[0].card[i])) {
					m.getGUIManager().addOK(hand[0].card[i], i);
				}
			}
		}
		// TODO next结束后，进行AI测试
		for (int i = 0; i < playerNum; i++) {
			if (playerLevel[i] != "Player")
				AI.Level1(player[i]);
		}
		Game.setBuy(player[0]);
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
		Manager m = new Manager();
		// TODO 清理买卖
		m.getGUIManager().removeDis();
		for (int i = 0; i < hand[0].cardNum; i++) {
			if (hand[0].card[i] != null && playerLevel[0] == "Player") {
				Game.addCard(player[0], hand[0].card[i], i, hand[0].cardNum);
				for (int j = 0; j < player[0].freeNum; j++) {
					if (hand[0].card[i].name == player[0].freeBuild[j]) {
						m.getGUIManager().addFreeOK(hand[0].card[i], i);
						break;
					}
				}
				if (MathGame.ifBuild(player[0], hand[0].card[i])) {
					m.getGUIManager().addOK(hand[0].card[i], i);
				}
				for (int j = 0; j < player[0].cardNum; j++) {
					if (hand[0].card[i].name == player[0].card[j].name) {
						m.getGUIManager().addnotOK(hand[0].card[i], i);
					}
				}
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
		Manager m = new Manager();
		for (int i = 0; i < playerNum; i++) {
			if (player[i].turn.card == null)
				return;
			else if (player[i].LastCard && times == 6 && hand[i].cardNum != 1) {
				update(player[i]);
				if (i == 0)
					lastCard();
				else
					AI.Level1(player[i]);
				return;
			}
		}
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
			checkCoin(player[i]);
			Game.updateCoin(player[i]);
		}
		m.getGUIManager().updateDiscard();
		// TODO 更新蓝分和红战斗力
		Game.setText(player);
		m.getGUIManager().updateRedBlue();
		m.getGUIManager().removeOK();
		if (times < 6)
			nextTurn();
		else if (age < 3) {
			endAge();
			newAge();
		} else {
			endAge();
			for (int i = 0; i < playerNum; i++) {
				if (player[i].board.name == "Olympia"
						&& player[i].board.side == 1
						&& player[i].board.age == 3) {
					if (i == 0) {
						if (m.getGUIManager().addPurple(player[i]))
							return;
						else {
							endGame();
							return;
						}
					} else {
						// TODO bug2
					}
				}
			}
			endGame();
		}
	}

	public void endGame() {
		Manager m = new Manager();
		m.getGUIManager().ScoreBoard();
		for (int i = 0; i < playerNum; i++) {
			checkScore(player[i]);
			while (player[i].Gliterature_physics_math > 0) {
				int a = checkGreen(player[i].Gliterature + 1,
						player[i].Gphysics, player[i].Gmath);
				int b = checkGreen(player[i].Gliterature,
						player[i].Gphysics + 1, player[i].Gmath);
				int c = checkGreen(player[i].Gliterature, player[i].Gphysics,
						player[i].Gmath + 1);
				player[i].Gliterature_physics_math--;
				if (a > b && a > c) {
					player[i].Gliterature++;
				} else if (b > a && b > c) {
					player[i].Gphysics++;
				} else
					player[i].Gmath++;
			}
			player[i].GgreenScore = checkGreen(player[i].Gliterature,
					player[i].Gphysics, player[i].Gmath);
			m.getGUIManager().score(player[i]);
		}
	}

	// TODO 计算科技分
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

	// TODO 特殊时代间隙

	// TODO 特殊游戏间隙

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
				Aplayer.failTimes++;
			}
			if (Aplayer.Gforce > player[playerNum - 1].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addRightForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[playerNum - 1].Gforce) {
				Aplayer.GforceScore -= 1;
				Aplayer.failTimes++;
				m.getGUIManager().addRightForce(Aplayer, age, false);
			}
		} else if (Aplayer.index != playerNum - 1) {
			if (Aplayer.Gforce > player[Aplayer.index - 1].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addRightForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[Aplayer.index - 1].Gforce) {
				Aplayer.GforceScore -= 1;
				Aplayer.failTimes++;
				m.getGUIManager().addRightForce(Aplayer, age, false);
			}
			if (Aplayer.Gforce > player[Aplayer.index + 1].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addLeftForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[Aplayer.index + 1].Gforce) {
				Aplayer.GforceScore -= 1;
				Aplayer.failTimes++;
				m.getGUIManager().addLeftForce(Aplayer, age, false);
			}
		} else {
			if (Aplayer.Gforce > player[0].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addRightForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[0].Gforce) {
				Aplayer.GforceScore -= 1;
				Aplayer.failTimes++;
				m.getGUIManager().addRightForce(Aplayer, age, false);
			}
			if (Aplayer.Gforce > player[Aplayer.index - 1].Gforce) {
				Aplayer.GforceScore += age * 2 - 1;
				m.getGUIManager().addLeftForce(Aplayer, age, true);
			} else if (Aplayer.Gforce < player[Aplayer.index - 1].Gforce) {
				Aplayer.GforceScore -= 1;
				Aplayer.failTimes++;
				m.getGUIManager().addLeftForce(Aplayer, age, false);
			}
		}
	}

	// TODO 结算金钱-每回合
	public void checkCoin(Player Aplayer) {
		if (Aplayer.LRMGrayCoin == true) {
			Aplayer.LRMGrayCoin = false;
			Aplayer.turn.Gcoin += Aplayer.grayNum * 2;
			Aplayer.turn.Gcoin += player[(Aplayer.index + playerNum - 1)
					% playerNum].grayNum * 2;
			Aplayer.turn.Gcoin += player[(Aplayer.index + playerNum + 1)
					% playerNum].grayNum * 2;
		}
		if (Aplayer.LRMBrownCoin == true) {
			Aplayer.LRMBrownCoin = false;
			Aplayer.turn.Gcoin += Aplayer.brownNum;
			Aplayer.turn.Gcoin += player[(Aplayer.index + playerNum - 1)
					% playerNum].brownNum;
			Aplayer.turn.Gcoin += player[(Aplayer.index + playerNum + 1)
					% playerNum].brownNum;
		}
		if (Aplayer.GrayCoin == true) {
			Aplayer.GrayCoin = false;
			Aplayer.turn.Gcoin += Aplayer.grayNum * 2;
		}
		if (Aplayer.BrownCoin == true) {
			Aplayer.BrownCoin = false;
			Aplayer.turn.Gcoin += Aplayer.brownNum;
		}
		if (Aplayer.YellowCoin == true) {
			Aplayer.YellowCoin = false;
			Aplayer.turn.Gcoin += Aplayer.yellowNum;
		}
		if (Aplayer.StageCoin == true) {
			Aplayer.StageCoin = false;
			Aplayer.turn.Gcoin += Aplayer.board.age * 3;
		}
	}

	// TODO 结算分数-游戏结束
	public void checkScore(Player Aplayer) {

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
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum - 1)
					% playerNum].blueNum;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum + 1)
					% playerNum].blueNum;
		}
		if (Aplayer.GuildBrown == true) {
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum - 1)
					% playerNum].brownNum;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum + 1)
					% playerNum].brownNum;
		}
		if (Aplayer.GuildGray == true) {
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum - 1)
					% playerNum].grayNum * 2;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum + 1)
					% playerNum].grayNum * 2;
		}
		if (Aplayer.GuildYellow == true) {
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum - 1)
					% playerNum].yellowNum;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum + 1)
					% playerNum].yellowNum;
		}
		if (Aplayer.GuildGreen == true) {
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum - 1)
					% playerNum].greenNum;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum + 1)
					% playerNum].greenNum;
		}
		if (Aplayer.GuildRed == true) {
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum - 1)
					% playerNum].redNum;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum + 1)
					% playerNum].redNum;
		}
		if (Aplayer.GuildForce == true) {
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum - 1)
					% playerNum].failTimes;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum + 1)
					% playerNum].failTimes;
		}
		if (Aplayer.GuildMixed == true) {
			Aplayer.GpurpleScore += Aplayer.brownNum;
			Aplayer.GpurpleScore += Aplayer.grayNum;
			Aplayer.GpurpleScore += Aplayer.purpleNum;
		}
		if (Aplayer.GuildStage == true) {
			Aplayer.GpurpleScore += Aplayer.board.age;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum - 1)
					% playerNum].board.age;
			Aplayer.GpurpleScore += player[(Aplayer.index + playerNum + 1)
					% playerNum].board.age;
		}
	}

	// TODO 奇迹板特殊属性-最后一张牌
	public void lastCard() {
		Manager m = new Manager();
		if (player[0].LastCard == true) {
			for (int i = 0; i < hand[0].cardNum; i++) {
				if (hand[0].card[i] != null) {
					Game.addCard(player[0], hand[0].card[i], i, hand[0].cardNum);
					for (int j = 0; j < player[0].freeNum; j++) {
						if (hand[0].card[i].name == player[0].freeBuild[j]) {
							m.getGUIManager().addFreeOK(hand[0].card[i], i);
							break;
						}
					}
					if (MathGame.ifBuild(player[0], hand[0].card[i])) {
						m.getGUIManager().addOK(hand[0].card[i], i);
					}
					for (int j = 0; j < player[0].cardNum; j++) {
						if (hand[0].card[i].name == player[0].card[j].name) {
							m.getGUIManager().addnotOK(hand[0].card[i], i);
						}
					}
				}
			}
		}
	}

	public void update(Player Aplayer) {
		Manager m = new Manager();
		if (Aplayer.turn.choose == 0) {
			MathGame.doAction(Aplayer, Aplayer.turn.card, true);
			addDiscard(Aplayer.turn.card);
		} else if (Aplayer.turn.choose == 1) {
			Aplayer.turn.update(Aplayer, Aplayer.turn.card);
			MathGame.doAction(Aplayer, Aplayer.turn.card);
			Aplayer.addCard(Aplayer.turn.card);
			if (!(Aplayer.board.name == "Olympia" && Aplayer.board.side == 1 && Aplayer.board.age == 3))
				Game.hideCard(Aplayer, Aplayer.turn.card);
		} else {
			Aplayer.turn.update(Aplayer, Aplayer.board);
			MathGame.doAction(Aplayer);
			Game.updateStage(Aplayer);
		}
		hand[Aplayer.index].removeHand(Aplayer.turn.card);
		checkCoin(Aplayer);
		m.getGUIManager().updateDiscard();
		Game.updateCoin(Aplayer);
		Game.setText(player);
		m.getGUIManager().updateRedBlue();
	}
}
