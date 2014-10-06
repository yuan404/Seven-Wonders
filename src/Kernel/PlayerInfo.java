package Kernel;

import M.Manager;

/**
 * 玩家信息类
 * 
 * @author Lane
 * 
 */
public class PlayerInfo extends Item {
	/**
	 * 序号
	 */
	protected int index;
	/**
	 * 已持有卡牌
	 */
	protected Card[] card = new Card[25];
	/**
	 * 已持有卡牌数
	 */
	protected int cardNum = 0;
	/**
	 * 战争收益分数
	 */
	protected int GforceScore = 0;
	/**
	 * 战争失败次数
	 */
	protected int failTimes = 0;
	/**
	 * 奇迹板加分
	 */
	protected int GboardScore = 0;
	/**
	 * 黄牌加分
	 */
	protected int GyellowScore = 0;
	/**
	 * 紫牌加分
	 */
	protected int GpurpleScore = 0;
	/**
	 * 绿牌加分
	 */
	protected int GgreenScore = 0;
	/**
	 * 棕牌个数
	 */
	protected int brownNum = 0;
	/**
	 * 灰牌个数
	 */
	protected int grayNum = 0;
	/**
	 * 蓝牌个数
	 */
	protected int blueNum = 0;
	/**
	 * 绿牌个数
	 */
	protected int greenNum = 0;
	/**
	 * 红牌个数
	 */
	protected int redNum = 0;
	/**
	 * 黄牌个数
	 */
	protected int yellowNum = 0;
	/**
	 * 紫牌个数
	 */
	protected int purpleNum = 0;
	/**
	 * 免费牌个数
	 */
	protected int freeNum = 0;
	/**
	 * 免费牌
	 */
	protected String[] freeBuild = new String[55];

	/**
	 * 获得卡牌组
	 * 
	 * @return
	 */
	public Card[] getCard() {
		return card;
	}

	/**
	 * 向卡牌组里添加卡牌
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		this.card[cardNum++] = card;
	}

	/**
	 * 向免费卡牌组里添加卡牌
	 * 
	 * @param card
	 */
	public void addFreeCard(String card) {
		CardInfo ci = new CardInfo();
		if (ci.getCardByName(card).freeBuild[0] != null)
			this.freeBuild[freeNum++] = ci.getCardByName(card).freeBuild[0];
		if (ci.getCardByName(card).freeBuild[1] != null)
			this.freeBuild[freeNum++] = ci.getCardByName(card).freeBuild[1];
	}

	/**
	 * 从左邻居购置资源
	 */
	protected Business left = new Business();
	/**
	 * 从右邻居购置资源
	 */
	protected Business right = new Business();
	/**
	 * 奇迹板
	 */
	protected Board board;

	/**
	 * 左邻居
	 * 
	 * @return
	 */
	public PlayerInfo left() {
		Manager m = new Manager();
		return m.getKernelManager().left(this);
	}

	/**
	 * 右邻居
	 * 
	 * @return
	 */
	public PlayerInfo right() {
		Manager m = new Manager();
		return m.getKernelManager().right(this);
	}

}
