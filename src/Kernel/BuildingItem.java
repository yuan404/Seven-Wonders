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
		str += "Cost:" + "\r\n" + "    wood:" + putWood + "\r\n";
		str += "    stone:" + putStone + "\r\n";
		str += "    ore:" + putOre + "\r\n";
		str += "    brick:" + putBrick + "\r\n";
		str += "    glass:" + putGlass + "\r\n";
		str += "    cloth:" + putCloth + "\r\n";
		str += "    paper:" + putPaper + "\r\n";
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

	int leftFee = 0;
	int rightFee = 0;

	// TODO 乱入的函数
	/**
	 * 判断是否能够建造
	 * 
	 * @param info
	 * @return
	 */
	public int bigJudge(PlayerInfo info) {
		int wood = info.getWood - putWood;
		int stone = info.getStone - putStone;
		int ore = info.getOre - putOre;
		int brick = info.getBrick - putBrick;
		int glass = info.getGlass - putGlass;
		int cloth = info.getCloth - putCloth;
		int paper = info.getPaper - putPaper;
		int coin = info.getCoin - putCoin;
		if (coin < 0)
			return putCoin;
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
		int lefttotal1 = 0;
		int lefttotal2 = 0;
		int righttotal1 = 0;
		int righttotal2 = 0;
		PlayerInfo left = info.left();
		PlayerInfo right = info.right();
		int per = 2;
		if (info.LeftCheap || info.CheapBuy) {
			per = 1;
		}
		while (wood < 0 && left.getWood > 0) {
			wood++;
			left.getWood--;
			lefttotal1 += per;
		}
		while (stone < 0 && left.getStone > 0) {
			stone++;
			left.getStone--;
			lefttotal1 += per;
		}
		while (ore < 0 && left.getOre > 0) {
			ore++;
			left.getOre--;
			lefttotal1 += per;
		}
		while (brick < 0 && left.getBrick > 0) {
			brick++;
			left.getBrick--;
			lefttotal1 += per;
		}
		wb = left.getWoodBrick;
		ws = left.getWoodStone;
		wo = left.getWoodOre;
		sb = left.getStoneBrick;
		so = left.getStoneOre;
		bo = left.getOreBrick;
		for (int i = 0; i < 6; i++) {
			if (wb > 0) {
				if (wood < 0 && brick >= 0) {
					wood++;
					wb--;
					lefttotal1 += per;
				} else if (wood >= 0 && brick < 0) {
					brick++;
					wb--;
					lefttotal1 += per;
				}
			}
			if (ws > 0) {
				if (wood < 0 && stone >= 0) {
					wood++;
					ws--;
					lefttotal1 += per;
				} else if (wood >= 0 && stone < 0) {
					stone++;
					ws--;
					lefttotal1 += per;
				}
			}
			if (wo > 0) {
				if (wood < 0 && ore >= 0) {
					wood++;
					wo--;
					lefttotal1 += per;
				} else if (wood >= 0 && ore < 0) {
					ore++;
					wo--;
				}
			}
			if (sb > 0) {
				if (stone < 0 && brick >= 0) {
					stone++;
					sb--;
					lefttotal1 += per;
				} else if (brick < 0 && stone >= 0) {
					brick++;
					sb--;
					lefttotal1 += per;
				}
			}
			if (so > 0) {
				if (stone < 0 && ore >= 0) {
					stone++;
					so--;
					lefttotal1 += per;
				} else if (ore < 0 && stone >= 0) {
					ore++;
					so--;
					lefttotal1 += per;
				}
			}
			if (bo > 0) {
				if (brick < 0 && ore >= 0) {
					brick++;
					bo--;
					lefttotal1 += per;
				} else if (ore < 0 && brick >= 0) {
					ore++;
					bo--;
					lefttotal1 += per;
				}
			}
		}
		if (wb > 0) {
			if (wood < 0) {
				wood++;
				wb--;
				lefttotal1 += per;
			} else if (brick < 0) {
				brick++;
				wb--;
				lefttotal1 += per;
			}
		}
		if (ws > 0) {
			if (wood < 0) {
				wood++;
				ws--;
				lefttotal1 += per;
			} else if (stone < 0) {
				stone++;
				ws--;
				lefttotal1 += per;
			}
		}
		if (wo > 0) {
			if (wood < 0) {
				wood++;
				wo--;
				lefttotal1 += per;
			} else if (ore < 0) {
				ore++;
				wo--;
				lefttotal1 += per;
			}
		}
		if (sb > 0) {
			if (stone < 0) {
				stone++;
				sb--;
				lefttotal1 += per;
			} else if (brick < 0) {
				brick++;
				sb--;
				lefttotal1 += per;
			}
		}
		if (so > 0) {
			if (stone < 0) {
				stone++;
				so--;
				lefttotal1 += per;
			} else if (ore < 0) {
				ore++;
				so--;
				lefttotal1 += per;
			}
		}
		if (bo > 0) {
			if (brick < 0) {
				brick++;
				bo--;
				lefttotal1 += per;
			} else if (ore < 0) {
				ore++;
				bo--;
				lefttotal1 += per;
			}
		}

		if (info.RightCheap || info.CheapBuy) {
			per = 1;
		} else
			per = 2;
		while (wood < 0 && right.getWood > 0) {
			wood++;
			right.getWood--;
			righttotal1 += per;
		}
		while (stone < 0 && right.getStone > 0) {
			stone++;
			right.getStone--;
			righttotal1 += per;
		}
		while (ore < 0 && right.getOre > 0) {
			ore++;
			right.getOre--;
			righttotal1 += per;
		}
		while (brick < 0 && right.getBrick > 0) {
			brick++;
			right.getBrick--;
			righttotal1 += per;
		}
		wb = right.getWoodBrick;
		ws = right.getWoodStone;
		wo = right.getWoodOre;
		sb = right.getStoneBrick;
		so = right.getStoneOre;
		bo = right.getOreBrick;
		for (int i = 0; i < 6; i++) {
			if (wb > 0) {
				if (wood < 0 && brick >= 0) {
					wood++;
					wb--;
					righttotal1 += per;
				} else if (wood >= 0 && brick < 0) {
					brick++;
					wb--;
					righttotal1 += per;
				}
			}
			if (ws > 0) {
				if (wood < 0 && stone >= 0) {
					wood++;
					ws--;
					righttotal1 += per;
				} else if (wood >= 0 && stone < 0) {
					stone++;
					ws--;
					righttotal1 += per;
				}
			}
			if (wo > 0) {
				if (wood < 0 && ore >= 0) {
					wood++;
					wo--;
					righttotal1 += per;
				} else if (wood >= 0 && ore < 0) {
					ore++;
					wo--;
					righttotal1 += per;
				}
			}
			if (sb > 0) {
				if (stone < 0 && brick >= 0) {
					stone++;
					sb--;
					righttotal1 += per;
				} else if (brick < 0 && stone >= 0) {
					brick++;
					sb--;
					righttotal1 += per;
				}
			}
			if (so > 0) {
				if (stone < 0 && ore >= 0) {
					stone++;
					so--;
					righttotal1 += per;
				} else if (ore < 0 && stone >= 0) {
					ore++;
					so--;
					righttotal1 += per;
				}
			}
			if (bo > 0) {
				if (brick < 0 && ore >= 0) {
					brick++;
					bo--;
					righttotal1 += per;
				} else if (ore < 0 && brick >= 0) {
					ore++;
					bo--;
					righttotal1 += per;
				}
			}
		}
		if (wb > 0) {
			if (wood < 0) {
				wood++;
				wb--;
				righttotal1 += per;
			} else if (brick < 0) {
				brick++;
				wb--;
				righttotal1 += per;
			}
		}
		if (ws > 0) {
			if (wood < 0) {
				wood++;
				ws--;
				righttotal1 += per;
			} else if (stone < 0) {
				stone++;
				ws--;
				righttotal1 += per;
			}
		}
		if (wo > 0) {
			if (wood < 0) {
				wood++;
				wo--;
				righttotal1 += per;
			} else if (ore < 0) {
				ore++;
				wo--;
				righttotal1 += per;
			}
		}
		if (sb > 0) {
			if (stone < 0) {
				stone++;
				sb--;
				righttotal1 += per;
			} else if (brick < 0) {
				brick++;
				sb--;
				righttotal1 += per;
			}
		}
		if (so > 0) {
			if (stone < 0) {
				stone++;
				so--;
				righttotal1 += per;
			} else if (ore < 0) {
				ore++;
				so--;
				righttotal1 += per;
			}
		}
		if (bo > 0) {
			if (brick < 0) {
				brick++;
				bo--;
				righttotal1 += per;
			} else if (ore < 0) {
				ore++;
				bo--;
				righttotal1 += per;
			}
		}

		if (info.GrayCheap) {
			per = 1;
		} else
			per = 2;
		while (glass < 0 && right.getGlass > 0) {
			glass++;
			right.getGlass--;
			righttotal2 += per;
		}
		while (paper < 0 && right.getPaper > 0) {
			paper++;
			right.getPaper--;
			righttotal2 += per;
		}
		while (cloth < 0 && right.getCloth > 0) {
			cloth++;
			right.getCloth--;
			righttotal2 += per;
		}
		while (glass < 0 && left.getGlass > 0) {
			glass++;
			left.getGlass--;
			lefttotal2 += per;
		}
		while (paper < 0 && left.getPaper > 0) {
			paper++;
			left.getPaper--;
			lefttotal2 += per;
		}
		while (cloth < 0 && left.getCloth > 0) {
			cloth++;
			left.getCloth--;
			lefttotal2 += per;
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
		while (four == 0 && getWoodStoneOreBrick > 0) {
			if (lefttotal1 > 0 && !(info.CheapBuy || info.LeftCheap)) {
				lefttotal1 -= 2;
				getWoodStoneOreBrick--;
				continue;
			} else if (righttotal1 > 0 && !(info.CheapBuy || info.RightCheap)) {
				righttotal1 -= 2;
				getWoodStoneOreBrick--;
				continue;
			} else if (lefttotal1 > 0) {
				lefttotal1--;
				getWoodStoneOreBrick--;
				continue;
			} else if (righttotal1 > 0) {
				righttotal1--;
				getWoodStoneOreBrick--;
				continue;
			} else
				break;
		}
		while (three == 0 && getGlassClothPaper > 0) {
			if (lefttotal2 > 0 && !(info.GrayCheap)) {
				lefttotal2 -= 2;
				getGlassClothPaper--;
				continue;
			} else if (righttotal2 > 0 && !(info.GrayCheap)) {
				righttotal2 -= 2;
				getGlassClothPaper--;
				continue;
			} else if (lefttotal2 > 0) {
				lefttotal2--;
				getGlassClothPaper--;
				continue;
			} else if (righttotal2 > 0) {
				righttotal2--;
				getGlassClothPaper--;
				continue;
			} else {
				break;
			}

		}
		leftFee = lefttotal1 + lefttotal2;
		rightFee = righttotal1 + righttotal2;
		return lefttotal1 + lefttotal2 + righttotal1 + righttotal2;
	}
}
