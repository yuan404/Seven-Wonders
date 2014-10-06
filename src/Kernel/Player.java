package Kernel;

import M.Manager;

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
	String card = new String();
	/**
	 * 选项 0是无选择，1是建造卡牌，2是升级奇迹，3是弃牌
	 */
	int choose = 0;

	/**
	 * 选择
	 */
	public boolean setChoose(String card, int choose) {
		this.card = card;
		this.choose = choose;
		Manager m = new Manager();
		CardInfo ci = new CardInfo();
		if (choose == 1) {
			if (ci.getCardByName(card).judge(m.getKernelManager().infos[index])) {
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
	 * 置空
	 */
	public void clear() {
		card = new String();
		choose = 0;
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
			if (((resource == "wood") || (resource == "stone")
					|| (resource == "ore") || (resource == "brick"))
					&& (m.getKernelManager().infos[index].LeftCheap || m
							.getKernelManager().infos[index].CheapBuy))
				m.getKernelManager().infos[index].left.putCoin += 1 * num;
			else if (m.getKernelManager().infos[index].GrayCheap)
				m.getKernelManager().infos[index].left.putCoin += 1 * num;
			else
				m.getKernelManager().infos[index].left.putCoin += 2 * num;
			m.getKernelManager().infos[index].left.buy(resource, num);
			if (!m.getKernelManager().infos[index].left.judgeBuy(m
					.getKernelManager().infos[index])) {
				m.getKernelManager().infos[index].left.buy(resource, num * -1);
				return false;
			}
		} else {
			if (((resource == "wood") || (resource == "stone")
					|| (resource == "ore") || (resource == "brick"))
					&& (m.getKernelManager().infos[index].RightCheap || m
							.getKernelManager().infos[index].CheapBuy))
				m.getKernelManager().infos[index].right.putCoin += 1 * num;
			else if (m.getKernelManager().infos[index].GrayCheap)
				m.getKernelManager().infos[index].right.putCoin += 1 * num;
			else
				m.getKernelManager().infos[index].right.putCoin += 2 * num;
			m.getKernelManager().infos[index].right.buy(resource, num);
			if (!m.getKernelManager().infos[index].right.judgeBuy(m
					.getKernelManager().infos[index])) {
				m.getKernelManager().infos[index].right.buy(resource, num * -1);
				return false;
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

}
