package Kernel;

public class PlayerInfo extends Item{
	/**
	 * 序号
	 */
	private int index;
	/**
	 * 已持有卡牌
	 */
	private Card[] card = new Card[25];
	/**
	 * 已持有卡牌数
	 */
	private int cardNum = 0;

	// 当回合已买资源
	private int Bwood = 0;
	private int Bstone = 0;
	private int Bbrick = 0;
	private int Bore = 0;

	private int Bglass = 0;
	private int Bcloth = 0;
	private int Bpaper = 0;

	
	private int GforceScore = 0;
	private int failTimes = 0;

	
	// 奇迹板加分
	private int GboardScore = 0;

	// 黄牌加分
	private int GyellowScore = 0;
	private int GpurpleScore = 0;
	private int GgreenScore = 0;

	private int brownNum = 0;
	private int grayNum = 0;
	private int blueNum = 0;
	private int greenNum = 0;
	private int redNum = 0;
	private int yellowNum = 0;
	private int purpleNum = 0;

	private int freeNum = 0;
	private String[] freeBuild = new String[55];
	
	public Card[] getCard() {
		return card;
	}
	public void addCard(Card card) {
		this.card[cardNum++] = card;
	}
}
