package Kernel;

/**
 * 贸易类
 * 
 * @author Lane
 * 
 */
public class Business extends BuildingItem {
	/**
	 * 真实使用资源-金币
	 */
	protected int realCoin = 0;

	/**
	 * 置空
	 */
	public void clear() {
		putWood = 0;
		putStone = 0;
		putOre = 0;
		putBrick = 0;
		putGlass = 0;
		putCloth = 0;
		putPaper = 0;
		putCoin = 0;
		realCoin = 0;
	}

	/**
	 * 判断是否能够买的起
	 * 
	 * @param info
	 * @return
	 */
	public boolean judgeBuy(PlayerInfo info) {
		int wood = info.getWood - putWood;
		int stone = info.getStone - putStone;
		int ore = info.getOre - putOre;
		int brick = info.getBrick - putBrick;
		int glass = info.getGlass - putGlass;
		int cloth = info.getCloth - putCloth;
		int paper = info.getPaper - putPaper;
		int coin = info.getCoin - putCoin;
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
		if (wood >= 0 && stone >= 0 && ore >= 0 && brick >= 0 && glass >= 0
				&& cloth >= 0 && paper >= 0 && coin >= 0)
			return true;
		return false;
	}

	/**
	 * 执行买
	 * 
	 * @param resource
	 * @param num
	 */
	public void buy(String resource, int num) {
		addCost(resource, num);
	}
}
