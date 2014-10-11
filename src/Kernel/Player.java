package Kernel;

import java.io.IOException;

/**
 * 玩家类
 * 
 * @author Lane
 * 
 */
public class Player {
	/**
	 * 序号
	 */
	private int index;

	/**
	 * 构造函数
	 * 
	 * @param id
	 */
	public Player(int id) {
		index = id;
	}

	/**
	 * 获取序号
	 * 
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * 选择卡牌
	 */
	protected String card = null;
	/**
	 * 选项 0是无选择，1是建造卡牌，2是升级奇迹，3是弃牌
	 */
	protected int choose = 0;
	/**
	 * AI-illegal
	 */
	protected boolean aiChoose = false;

	/**
	 * 判定选择
	 */
	public boolean checkChoose(String card, int choose) {
		this.card = card;
		this.choose = choose;
		Manager m = new Manager();
		int temp = 0;
		for (temp = 0; temp < getHandNum(); temp++) {
			if (card == getHands()[temp])
				break;
		}
		if (temp == getHandNum())
			return false;
		if (choose == 1) {
			PlayerInfo pi = m.getKernelManager().infos[index];
			for (int i = 0; i < pi.cardNum; i++) {
				if (pi.card[i].getName() == card) {
					clear();
					return false;
				}
			}
			for (int i = 0; i < pi.freeNum; i++) {
				if (pi.freeBuild[i] == card) {
					return true;
				}
			}
			if (CardInfo.getCardByName(card).judge(
					m.getKernelManager().infos[index])) {
				return true;
			}
		} else if (choose == 2) {
			if (m.getKernelManager().infos[index].board.cards[m
					.getKernelManager().infos[index].board.age + 1].judge(m
					.getKernelManager().infos[index])
					&& (m.getKernelManager().infos[index].board.age < m
							.getKernelManager().infos[index].board.max)) {
				return true;
			}
		} else {
			return true;
		}
		clear();
		return false;
	}

	/**
	 * 选择
	 */
	public boolean setChoose(String card, int choose) {
		this.card = card;
		this.choose = choose;
		Manager m = new Manager();
		int temp = 0;
		for (temp = 0; temp < getHandNum(); temp++) {
			if (card == getHands()[temp])
				break;
		}
		if (temp == getHandNum()) {
			aiChoose = true;
			return false;
		}
		if (choose == 1) {
			PlayerInfo pi = m.getKernelManager().infos[index];
			for (int i = 0; i < pi.cardNum; i++) {
				if (pi.card[i].getName() == card) {
					clear();
					aiChoose = true;
					return false;
				}
			}
			for (int i = 0; i < pi.freeNum; i++) {
				if (pi.freeBuild[i] == card) {
					try {
						m.getKernelManager().fw[index].write("\r\nFree\r\n");
						m.getKernelManager().endTurn();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return true;
				}
			}
			if (CardInfo.getCardByName(card).judge(
					m.getKernelManager().infos[index])) {
				try {
					m.getKernelManager().endTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		} else if (choose == 2) {
			if (m.getKernelManager().infos[index].board.cards[m
					.getKernelManager().infos[index].board.age + 1].judge(m
					.getKernelManager().infos[index])
					&& (m.getKernelManager().infos[index].board.age < m
							.getKernelManager().infos[index].board.max)) {
				try {
					m.getKernelManager().endTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		} else {
			try {
				m.getKernelManager().endTurn();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		clear();
		aiChoose = true;
		return false;
	}

	/**
	 * 置空
	 */
	public void clear() {
		card = null;
		choose = 0;
	}

	/**
	 * 判定side == 0 左边 side == 1 右边 购买资源从邻居
	 * 
	 * @param resource
	 * @param num
	 * @param side
	 */
	public boolean checkBuy(String resource, int num, int side) {
		Manager m = new Manager();
		if (side == 0) {
			m.getKernelManager().infos[index].left.buy(resource, num);
			if (!m.getKernelManager().infos[index].left.judgeBuy(m
					.getKernelManager().infos[index])) {
				m.getKernelManager().infos[index].left.buy(resource, num * -1);
				return false;
			} else {
				m.getKernelManager().infos[index].left.buy(resource, num * -1);
				return true;
			}
		} else {
			m.getKernelManager().infos[index].right.buy(resource, num);
			if (!m.getKernelManager().infos[index].right.judgeBuy(m
					.getKernelManager().infos[index])) {
				m.getKernelManager().infos[index].right.buy(resource, num * -1);
				return false;
			} else {
				m.getKernelManager().infos[index].right.buy(resource, num * -1);
				return true;
			}
		}
	}

	/**
	 * side == 0 左边 side == 1 右边 购买资源从邻居
	 * 
	 * @param resource
	 * @param num
	 * @param side
	 */
	public boolean buy(String resource, int num, int side) {
		Manager m = new Manager();
		if (side == 0) {
			m.getKernelManager().infos[index].left.buy(resource, num);
			if (!m.getKernelManager().infos[index].left.judgeBuy(m
					.getKernelManager().infos[index])) {
				m.getKernelManager().infos[index].left.buy(resource, num * -1);
				aiChoose = true;
				return false;
			}
			if (((resource == "wood") || (resource == "stone")
					|| (resource == "ore") || (resource == "brick"))
					&& (m.getKernelManager().infos[index].LeftCheap || m
							.getKernelManager().infos[index].CheapBuy)) {
				m.getKernelManager().infos[index].left.putCoin += 1 * num;
				m.getKernelManager().infos[index].getCoin -= 1 * num;
			} else if (m.getKernelManager().infos[index].GrayCheap) {
				m.getKernelManager().infos[index].left.putCoin += 1 * num;
				m.getKernelManager().infos[index].getCoin -= 1 * num;
			} else {
				m.getKernelManager().infos[index].left.putCoin += 2 * num;
				m.getKernelManager().infos[index].getCoin -= 2 * num;
			}
		} else {
			m.getKernelManager().infos[index].right.buy(resource, num);
			if (!m.getKernelManager().infos[index].right.judgeBuy(m
					.getKernelManager().infos[index])) {
				m.getKernelManager().infos[index].right.buy(resource, num * -1);
				aiChoose = true;
				return false;
			}
			if (((resource == "wood") || (resource == "stone")
					|| (resource == "ore") || (resource == "brick"))
					&& (m.getKernelManager().infos[index].RightCheap || m
							.getKernelManager().infos[index].CheapBuy)) {
				m.getKernelManager().infos[index].right.putCoin += 1 * num;
				m.getKernelManager().infos[index].getCoin -= 1 * num;
			} else if (m.getKernelManager().infos[index].GrayCheap) {
				m.getKernelManager().infos[index].right.putCoin += 1 * num;
				m.getKernelManager().infos[index].getCoin -= 1 * num;
			} else {
				m.getKernelManager().infos[index].right.putCoin += 2 * num;
				m.getKernelManager().infos[index].getCoin -= 2 * num;
			}
		}
		return true;
	}

	/**
	 * 得到手牌
	 * 
	 * @return
	 */
	public String[] getHands() {
		Manager m = new Manager();
		return m.getKernelManager().getHands(index);
	}

	/**
	 * 得到当前手牌数
	 * 
	 * @return
	 */
	public int getHandNum() {
		Manager m = new Manager();
		return (8 - m.getKernelManager().turnNum);
	}

	/**
	 * 查询玩家的资源- side == 0 查询自己 side == -1 右邻居 side == 1 左邻居
	 * 
	 * @param resource
	 * @param side
	 * @return
	 */
	public int howMany(String resource, int side) {
		PlayerInfo pi;
		Manager m = new Manager();
		if (side == 0) {
			pi = m.getKernelManager().infos[index];
		} else if (side == 1) {
			pi = m.getKernelManager().infos[index].left();
		} else if (side == 2) {
			pi = m.getKernelManager().infos[index].left().left();
		} else if (side == -1) {
			pi = m.getKernelManager().infos[index].right();
		} else if (side == -2) {
			pi = m.getKernelManager().infos[index].right().right();
		} else {
			pi = m.getKernelManager().infos[index];
		}
		switch (resource) {
		case "wood":
			return pi.getWood;
		case "stone":
			return pi.getStone;
		case "ore":
			return pi.getOre;
		case "brick":
			return pi.getBrick;
		case "glass":
			return pi.getGlass;
		case "cloth":
			return pi.getCloth;
		case "paper":
			return pi.getPaper;
		case "coin":
			return pi.getCoin;

		case "wood_stone":
			return pi.getWoodStone;
		case "wood_ore":
			return pi.getWoodOre;
		case "wood_brick":
			return pi.getWoodBrick;
		case "stone_ore":
			return pi.getStoneOre;
		case "stone_brick":
			return pi.getStoneBrick;
		case "ore_brick":
			return pi.getOreBrick;

		case "wood_stone_ore_brick":
			return pi.getWoodStoneOreBrick;
		case "glass_cloth_paper":
			return pi.getGlassClothPaper;

		case "literature":
			return pi.getLiterature;
		case "physics":
			return pi.getPhysics;
		case "math":
			return pi.getMath;

		case "literature_physics_math":
			return pi.getLiteraturePhysicsMath;

		case "force":
			return pi.getForce;
		case "blueScore":
			return pi.getBlueScore;
		case "boardScore":
			return pi.getBoardScore;

		case "cardNum":
			return pi.cardNum;

		case "brownNum":
			return pi.brownNum;
		case "grayNum":
			return pi.grayNum;
		case "redNum":
			return pi.redNum;
		case "blueNum":
			return pi.blueNum;
		case "yellowNum":
			return pi.yellowNum;
		case "purpleNum":
			return pi.purpleNum;
		case "greenNum":
			return pi.greenNum;
		default:
			aiChoose = true;
		}
		return 0;
	}

	/**
	 * 查询卡牌消耗资源
	 * 
	 * @param resource
	 * @param cardName
	 * @return
	 */
	public int howManyCost(String resource, String cardName) {
		Card card = CardInfo.getCardByName(cardName);
		switch (resource) {
		case "wood":
			return card.putWood;
		case "stone":
			return card.putStone;
		case "ore":
			return card.putOre;
		case "brick":
			return card.putBrick;
		case "glass":
			return card.putGlass;
		case "cloth":
			return card.putCloth;
		case "paper":
			return card.putPaper;
		case "coin":
			return card.putCoin;
		default:
			aiChoose = true;
		}
		return 0;
	}

	/**
	 * 当前建造奇迹的损耗
	 * 
	 * @return
	 */
	public int howManyCostStage(String resource) {
		Manager m = new Manager();
		int age = m.getKernelManager().infos[index].board.age;
		if (age >= m.getKernelManager().infos[index].board.max)
			return 0;
		Card card = m.getKernelManager().infos[index].board.cards[age + 1];
		switch (resource) {
		case "wood":
			return card.putWood;
		case "stone":
			return card.putStone;
		case "ore":
			return card.putOre;
		case "brick":
			return card.putBrick;
		case "glass":
			return card.putGlass;
		case "cloth":
			return card.putCloth;
		case "paper":
			return card.putPaper;
		case "coin":
			return card.putCoin;
		default:
			aiChoose = true;
		}
		return 0;
	}

	/**
	 * 获取已建造卡牌
	 */
	public String[] getCards() {
		Manager m = new Manager();
		int num = m.getKernelManager().infos[index].cardNum;
		String[] str = new String[num];
		for (int i = 0; i < num; i++)
			str[i] = m.getKernelManager().infos[index].card[i].getName();
		return str;
	}

	/**
	 * 获取已建造卡牌数量
	 */
	public int getCardsNum() {
		Manager m = new Manager();
		return m.getKernelManager().infos[index].cardNum;
	}
}
