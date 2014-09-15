package Kernel;

/**
 * 
 * @author Lane 进入这里说明已经判断过是否足够资源或者金钱去建造卡牌或者奇迹
 * 
 */
public class Turn {

	public Card card;
	// 0代表卖牌;1代表建造卡牌;2代表建造奇迹
	public int choose = 0;

	public Turn() {

	}

	public void setChoose(Card card, int choose) {
		this.card = card;
		this.choose = choose;
	}

	public void setChoose(int choose) {
		this.choose = choose;
	}

	public void update() {

	}
}
