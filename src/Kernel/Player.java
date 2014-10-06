package Kernel;

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
		if (choose == 1) {

		} else if (choose == 2) {

		} else {

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
}
