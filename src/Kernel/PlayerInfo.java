package Kernel;

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

	public PlayerInfo(int n) {
		index = n;
	}

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
		if (CardInfo.getCardByName(card).freeBuild[0] != null)
			this.freeBuild[freeNum++] = CardInfo.getCardByName(card).freeBuild[0];
		if (CardInfo.getCardByName(card).freeBuild[1] != null)
			this.freeBuild[freeNum++] = CardInfo.getCardByName(card).freeBuild[1];
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
		return m.getKernelManager().left(index);
	}

	/**
	 * 右邻居
	 * 
	 * @return
	 */
	public PlayerInfo right() {
		Manager m = new Manager();
		return m.getKernelManager().right(index);
	}

	/**
	 * 获得弃牌组
	 * 
	 * @return
	 */
	public String[] getDisCard() {
		Manager m = new Manager();
		return m.getKernelManager().disCard;
	}

	/**
	 * 获得弃牌数
	 * 
	 * @return
	 */
	public int getDisCardNum() {
		Manager m = new Manager();
		return m.getKernelManager().disNum;
	}

	public String getDetail() {
		String str = new String();
		Manager m = new Manager();
		str += m.getKernelManager().players[index].card
				+ "-"
				+ (m.getKernelManager().age * 6 + m.getKernelManager().turnNum - 7)
				+ "-Have:\r\n" + "    wood:" + getWood + "\r\n" + "    stone:"
				+ getStone + "\r\n" + "    ore:" + getOre + "\r\n"
				+ "    brick:" + getBrick + "\r\n" + "    glass:" + getGlass
				+ "\r\n" + "    cloth:" + getCloth + "\r\n" + "    paper:"
				+ getPaper + "\r\n" + "    coin:" + getCoin + "\r\n"
				+ "    wood_stone:" + getWoodStone + "\r\n" + "    wood_ore:"
				+ getWoodOre + "\r\n" + "    wood_brick:" + getWoodBrick
				+ "\r\n" + "    stone_ore:" + getStoneOre + "\r\n"
				+ "    stone_brick:" + getStoneBrick + "\r\n"
				+ "    ore_brick:" + getOreBrick + "\r\n"
				+ "    wood_stone_ore_brick:" + getWoodStoneOreBrick + "\r\n"
				+ "    glass_cloth_paper:" + getGlassClothPaper + "\r\n";
		return str;
	}
}
