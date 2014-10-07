package Kernel;

/**
 * 带有消耗信息的元素类
 * 
 * @author Lane
 * 
 */
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

	/**
	 * 获取游戏细节关于消费
	 * 
	 * @return
	 */
	public String getDetailsCost() {
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

	/**
	 * 判断是否能够建造
	 * 
	 * @param info
	 * @return
	 */
	public boolean judge(PlayerInfo info) {
		int wood = info.getWood - putWood + info.left.putWood
				+ info.right.putWood;
		int stone = info.getStone - putStone + info.left.putStone
				+ info.right.putStone;
		int ore = info.getOre - putOre + info.left.putOre + info.right.putOre;
		int brick = info.getBrick - putBrick + info.left.putBrick
				+ info.right.putBrick;
		int glass = info.getGlass - putGlass + info.left.putGlass
				+ info.right.putGlass;
		int cloth = info.getCloth - putCloth + info.left.putCloth
				+ info.right.putCloth;
		int paper = info.getPaper - putPaper + info.left.putPaper
				+ info.right.putPaper;
		int coin = info.getCoin - putCoin;
		if (coin < 0)
			return false;
		int wb = info.getWoodBrick;
		int ws = info.getWoodStone;
		int wo = info.getWoodOre;
		int sb = info.getStoneBrick;
		int so = info.getStoneOre;
		int bo = info.getOreBrick;
		for (int i = 0; i < 6; i++) {
			if (wb > 0) {
				if (wood < 0 && brick >= 0) {
					wood++;
					wb--;
				} else if (wood >= 0 && brick < 0) {
					brick++;
					wb--;
				}
			}
			if (ws > 0) {
				if (wood < 0 && stone >= 0) {
					wood++;
					ws--;
				} else if (wood >= 0 && stone < 0) {
					stone++;
					ws--;
				}
			}
			if (wo > 0) {
				if (wood < 0 && ore >= 0) {
					wood++;
					wo--;
				} else if (wood >= 0 && ore < 0) {
					ore++;
					wo--;
				}
			}
			if (sb > 0) {
				if (stone < 0 && brick >= 0) {
					stone++;
					sb--;
				} else if (brick < 0 && stone >= 0) {
					brick++;
					sb--;
				}
			}
			if (so > 0) {
				if (stone < 0 && ore >= 0) {
					stone++;
					so--;
				} else if (ore < 0 && stone >= 0) {
					ore++;
					so--;
				}
			}
			if (bo > 0) {
				if (brick < 0 && ore >= 0) {
					brick++;
					bo--;
				} else if (ore < 0 && brick >= 0) {
					ore++;
					bo--;
				}
			}
		}
		if (wb > 0) {
			if (wood < 0) {
				wood++;
				wb--;
			} else if (brick < 0) {
				brick++;
				wb--;
			}
		}
		if (ws > 0) {
			if (wood < 0) {
				wood++;
				ws--;
			} else if (stone < 0) {
				stone++;
				ws--;
			}
		}
		if (wo > 0) {
			if (wood < 0) {
				wood++;
				wo--;
			} else if (ore < 0) {
				ore++;
				wo--;
			}
		}
		if (sb > 0) {
			if (stone < 0) {
				stone++;
				sb--;
			} else if (brick < 0) {
				brick++;
				sb--;
			}
		}
		if (so > 0) {
			if (stone < 0) {
				stone++;
				so--;
			} else if (ore < 0) {
				ore++;
				so--;
			}
		}
		if (bo > 0) {
			if (brick < 0) {
				brick++;
				bo--;
			} else if (ore < 0) {
				ore++;
				bo--;
			}
		}
		int four = 0;
		if (wood < 0)
			four += wood;
		if (stone < 0)
			four += stone;
		if (ore < 0)
			four += ore;
		if (brick < 0)
			four += brick;
		int three = 0;
		if (glass < 0)
			three += glass;
		if (cloth < 0)
			three += cloth;
		if (paper < 0)
			three += paper;
		if (four + getWoodStoneOreBrick >= 0 && three + getGlassClothPaper >= 0)
			return true;
		if (wood >= 0 && stone >= 0 && ore >= 0 && brick >= 0 && glass >= 0
				&& cloth >= 0 && paper >= 0 && coin >= 0)
			return true;
		return false;
	}

}
