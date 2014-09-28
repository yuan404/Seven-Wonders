package Kernel;

public class BuildingItem extends Item {
	/**
	 * 消耗资源1-木材
	 */
	protected int putWood = 0;
	/**
	 * 消耗资源2-石材
	 */
	protected int putStone = 0;
	/**
	 * 消耗资源3-矿材
	 */
	protected int putOre = 0;
	/**
	 * 消耗资源4-砖材
	 */
	protected int putBrick = 0;
	/**
	 * 消耗资源5-玻璃
	 */
	protected int putGlass = 0;
	/**
	 * 消耗资源6-布
	 */
	protected int putCloth = 0;
	/**
	 * 消耗资源7-纸
	 */
	protected int putPaper = 0;
	/**
	 * 消耗资源8-金币
	 */
	protected int putCoin = 0;

	/**
	 * 设置消耗
	 * 
	 * @return
	 */
	public void addCost(String resource, int num) {
		switch (resource) {
		case "wood":
			putWood += num;
			break;
		case "stone":
			putStone += num;
			break;
		case "ore":
			putOre += num;
			break;
		case "brick":
			putBrick += num;
			break;
		case "glass":
			putGlass += num;
			break;
		case "cloth":
			putCloth += num;
			break;
		case "paper":
			putPaper += num;
			break;
		case "coin":
			putCoin += num;
			break;
		}
	}

	public String toString() {
		String str = new String();
		str += putWood + " ";
		str += putStone + " ";
		str += putOre + " ";
		str += putBrick + " ";
		str += putGlass + " ";
		str += putCloth + " ";
		str += putPaper + "\n";
		return str;
	}
}
