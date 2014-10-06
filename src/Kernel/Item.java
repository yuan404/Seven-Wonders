package Kernel;

/**
 * 基础收益元素类
 * 
 * @author Lane
 *
 */
public class Item {
	/**
	 * 名字
	 */
	protected String name;

	/**
	 * 获得命名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 生产资源1-木材
	 */
	protected int getWood = 0;
	/**
	 * 生产资源2-石材
	 */
	protected int getStone = 0;
	/**
	 * 生产资源3-矿材
	 */
	protected int getOre = 0;
	/**
	 * 生产资源4-砖材
	 */
	protected int getBrick = 0;
	/**
	 * 生产资源5-玻璃
	 */
	protected int getGlass = 0;
	/**
	 * 生产资源6-布
	 */
	protected int getCloth = 0;
	/**
	 * 生产资源7-纸
	 */
	protected int getPaper = 0;
	/**
	 * 生产资源8-金币
	 */
	protected int getCoin = 0;
	/**
	 * 生产双资源1-木材 石材
	 */
	protected int getWoodStone = 0;
	/**
	 * 生产双资源2-木材 矿材
	 */
	protected int getWoodOre = 0;
	/**
	 * 生产双资源3-木材 砖材
	 */
	protected int getWoodBrick = 0;
	/**
	 * 生产双资源4-石材 矿材
	 */
	protected int getStoneOre = 0;
	/**
	 * 生产双资源5-石材 砖材
	 */
	protected int getStoneBrick = 0;
	/**
	 * 生产双资源6-矿材 砖材
	 */
	protected int getOreBrick = 0;
	/**
	 * 生产四资源-木材 石材 矿材 砖材
	 */
	protected int getWoodStoneOreBrick = 0;
	/**
	 * 生产三资源-玻璃 布 纸
	 */
	protected int getGlassClothPaper = 0;
	/**
	 * 研发科技1-文学
	 */
	protected int getLiterature = 0;
	/**
	 * 研发科技2-物理
	 */
	protected int getPhysics = 0;
	/**
	 * 研发科技3-数学
	 */
	protected int getMath = 0;
	/**
	 * 研发三科技-文学 物理 数学
	 */
	protected int getLiteraturePhysicsMath = 0;
	/**
	 * 建设武力
	 */
	protected int getForce = 0;
	/**
	 * 建设蓝色分数
	 */
	protected int getBlueScore = 0;
	/**
	 * 建设奇迹分数
	 */
	protected int getBoardScore = 0;
	/**
	 * 以半价从邻居左购买4基础资源
	 */
	protected boolean LeftCheap = false;
	/**
	 * 以半价从邻居右购买4基础资源
	 */
	protected boolean RightCheap = false;
	/**
	 * 以半价从邻居购买3灰色资源
	 */
	protected boolean GrayCheap = false;
	/**
	 * 收益邻居左+自己+邻居右的灰牌总数*2的金币
	 */
	protected boolean LRMGrayCoin = false;
	/**
	 * 收益邻居左+自己+邻居右的棕牌总数的金币
	 */
	protected boolean LRMBrownCoin = false;
	/**
	 * 收益自己的棕牌总数的黄色分数
	 */
	protected boolean BrownScore = false;
	/**
	 * 收益自己的黄牌总数的黄色分数
	 */
	protected boolean YellowScore = false;
	/**
	 * 收益自己的灰牌总数*2的黄色分数
	 */
	protected boolean GrayScore = false;
	/**
	 * 收益自己的已建奇迹阶数的黄色分数
	 */
	protected boolean StageScore = false;
	/**
	 * 收益自己的灰牌总数*2的金币
	 */
	protected boolean GrayCoin = false;
	/**
	 * 收益自己的棕牌总数的金币
	 */
	protected boolean BrownCoin = false;
	/**
	 * 收益自己的黄牌总数的金币
	 */
	protected boolean YellowCoin = false;
	/**
	 * 收益自己的已建奇迹阶数*3的金币
	 */
	protected boolean StageCoin = false;
	/**
	 * 收益自己的棕牌、灰牌、紫牌总数的紫色分数
	 */
	protected boolean GuildMixed = false;
	/**
	 * 收益邻居的棕牌总数的紫色分数
	 */
	protected boolean GuildBrown = false;
	/**
	 * 收益邻居的蓝牌总数的紫色分数
	 */
	protected boolean GuildBlue = false;
	/**
	 * 收益邻居的红牌总数的紫色分数
	 */
	protected boolean GuildRed = false;
	/**
	 * 收益邻居的黄牌总数的紫色分数
	 */
	protected boolean GuildYellow = false;
	/**
	 * 收益邻居的绿牌总数的紫色分数
	 */
	protected boolean GuildGreen = false;
	/**
	 * 收益邻居的战败标记总数的紫色分数
	 */
	protected boolean GuildForce = false;
	/**
	 * 收益邻居左、自己、邻居右的已建奇迹阶数总数的紫色分数
	 */
	protected boolean GuildStage = false;
	/**
	 * 收益邻居的灰牌总数*2的紫色分数
	 */
	protected boolean GuildGray = false;
	/**
	 * 免费从弃牌堆中建造卡牌
	 */
	protected boolean FreeDiscard = false;
	/**
	 * 免费建造卡牌在每个时代
	 */
	protected boolean FreeBuild = false;
	/**
	 * 获得使用时代结束的最后一张牌的资格
	 */
	protected boolean LastCard = false;
	/**
	 * 半价购买4资源
	 */
	protected boolean CheapBuy = false;
	/**
	 * 游戏结束时复制一个邻居的一个紫牌
	 */
	protected boolean CopyGuild = false;

	/**
	 * 设置收益
	 * 
	 * @return
	 */
	public void addFormit(String resource, int num) {
		switch (resource) {
		case "wood":
			getWood += num;
			break;
		case "stone":
			getStone += num;
			break;
		case "ore":
			getOre += num;
			break;
		case "brick":
			getBrick += num;
			break;
		case "glass":
			getGlass += num;
			break;
		case "cloth":
			getCloth += num;
			break;
		case "paper":
			getPaper += num;
			break;
		case "coin":
			getCoin += num;
			break;

		case "wood_stone":
			getWoodStone += num;
			break;
		case "wood_ore":
			getWoodOre += num;
			break;
		case "wood_brick":
			getWoodBrick += num;
			break;
		case "stone_ore":
			getStoneOre += num;
			break;
		case "stone_brick":
			getStoneBrick += num;
			break;
		case "ore_brick":
			getOreBrick += num;
			break;

		case "wood_stone_ore_brick":
			getWoodStoneOreBrick += num;
			break;
		case "glass_cloth_paper":
			getGlassClothPaper += num;
			break;

		case "literature":
			getLiterature += num;
			break;
		case "physics":
			getPhysics += num;
			break;
		case "math":
			getMath += num;
			break;

		case "literature_physics_math":
			getLiteraturePhysicsMath += num;
			break;

		case "force":
			getForce += num;
			break;
		case "blueScore":
			getBlueScore += num;
			break;
		case "boardScore":
			getBoardScore += num;
			break;

		case "LeftCheap":
			LeftCheap = true;
			break;
		case "RightCheap":
			RightCheap = true;
			break;
		case "GrayCheap":
			GrayCheap = true;
			break;

		case "LRMGrayCoin":
			LRMGrayCoin = true;
			break;
		case "LRMBrownCoin":
			LRMBrownCoin = true;
			break;

		case "BrownScore":
			BrownScore = true;
			break;
		case "YellowScore":
			YellowScore = true;
			break;
		case "GrayScore":
			GrayScore = true;
			break;
		case "StageScore":
			StageScore = true;
			break;

		case "BrownCoin":
			BrownCoin = true;
			break;
		case "YellowCoin":
			YellowCoin = true;
			break;
		case "GrayCoin":
			GrayCoin = true;
			break;
		case "StageCoin":
			StageCoin = true;
			break;

		case "GuildBrown":
			GuildBrown = true;
			break;
		case "GuildGreen":
			GuildGreen = true;
			break;
		case "GuildYellow":
			GuildYellow = true;
			break;
		case "GuildBlue":
			GuildBlue = true;
			break;
		case "GuildRed":
			GuildRed = true;
			break;
		case "GuildGray":
			GuildGray = true;
			break;
		case "GuildMixed":
			GuildMixed = true;
			break;
		case "GuildForce":
			GuildForce = true;
			break;
		case "GuildStage":
			GuildStage = true;
			break;
		case "FreeDiscard":
			FreeDiscard = true;
			break;
		case "FreeBuild":
			FreeBuild = true;
			break;
		case "LastCard":
			LastCard = true;
			break;
		case "CheapBuy":
			CheapBuy = true;
			break;
		case "CopyGuild":
			CopyGuild = true;
			break;
		default:
			System.out.print(resource + "空收益消息\n");
			break;
		}
	}

	/**
	 * 游戏细节的字符串数组
	 */
	protected String[] str = new String[24];

	protected void update(PlayerInfo info) {
		for (int i = 0; i < 24; i++)
			str[i] = new String();
		// TODO 共有23种收益值
		str[0] += "former:getWood" + info.getWood + " ";
		str[0] += "formit:getWood" + getWood + " ";
		info.getWood += getWood;
		str[0] += "result:getWood" + info.getWood + "\n";
		str[1] += "former:getStone" + info.getStone + " ";
		str[1] += "formit:getStone" + getStone + " ";
		info.getStone += getStone;
		str[1] += "result:getStone" + info.getStone + "\n";
		str[2] += "former:getOre" + info.getOre + " ";
		str[2] += "formit:getOre" + getOre + " ";
		info.getOre += getOre;
		str[2] += "result:getOre" + info.getOre + "\n";
		str[3] += "former:getBrick" + info.getBrick + " ";
		str[3] += "formit:getBrick" + getBrick + " ";
		info.getBrick += getBrick;
		str[3] += "result:getBrick" + info.getBrick + "\n";
		str[4] += "former:getGlass" + info.getGlass + " ";
		str[4] += "formit:getGlass" + getGlass + " ";
		info.getGlass += getGlass;
		str[4] += "result:getGlass" + info.getGlass + "\n";
		str[5] += "former:getCloth" + info.getCloth + " ";
		str[5] += "formit:getCloth" + getCloth + " ";
		info.getCloth += getCloth;
		str[5] += "result:getCloth" + info.getCloth + "\n";
		str[6] += "former:getPaper" + info.getPaper + " ";
		str[6] += "formit:getPaper" + getPaper + " ";
		info.getPaper += getPaper;
		str[6] += "result:getPaper" + info.getPaper + "\n";
		str[7] += "former:getCoin" + info.getCoin + " ";
		str[7] += "formit:getCoin" + getCoin + " ";
		info.getCoin += getCoin;
		str[7] += "result:getCoin" + info.getCoin + "\n";
		str[8] += "former:getWoodStone" + info.getWoodStone + " ";
		str[8] += "formit:getWoodStone" + getWoodStone + " ";
		info.getWoodStone += getWoodStone;
		str[8] += "result:getWoodStone" + info.getWoodStone + "\n";
		str[9] += "former:getWoodOre" + info.getWoodOre + " ";
		str[9] += "formit:getWoodOre" + getWoodOre + " ";
		info.getWoodOre += getWoodOre;
		str[9] += "result:getWoodOre" + info.getWoodOre + "\n";
		str[10] += "former:getWoodBrick" + info.getWoodBrick + " ";
		str[10] += "formit:getWoodBrick" + getWoodBrick + " ";
		info.getWoodBrick += getWoodBrick;
		str[10] += "result:getWoodBrick" + info.getWoodBrick + "\n";
		str[11] += "former:getStoneOre" + info.getStoneOre + " ";
		str[11] += "formit:getStoneOre" + getStoneOre + " ";
		info.getStoneOre += getStoneOre;
		str[11] += "result:getStoneOre" + info.getStoneOre + "\n";
		str[12] += "former:getStoneBrick" + info.getStoneBrick + " ";
		str[12] += "formit:getStoneBrick" + getStoneBrick + " ";
		info.getStoneBrick += getStoneBrick;
		str[12] += "result:getStoneBrick" + info.getStoneBrick + "\n";
		str[13] += "former:getOreBrick" + info.getOreBrick + " ";
		str[13] += "formit:getOreBrick" + getOreBrick + " ";
		info.getOreBrick += getOreBrick;
		str[13] += "result:getOreBrick" + info.getOreBrick + "\n";
		str[14] += "former:getWoodStoneOreBrick" + info.getWoodStoneOreBrick
				+ " ";
		str[14] += "formit:getWoodStoneOreBrick" + getWoodStoneOreBrick + " ";
		info.getWoodStoneOreBrick += getWoodStoneOreBrick;
		str[14] += "result:getWoodStoneOreBrick" + info.getWoodStoneOreBrick
				+ "\n";
		str[15] += "former:getGlassClothPaper" + info.getGlassClothPaper + " ";
		str[15] += "formit:getGlassClothPaper" + getGlassClothPaper + " ";
		info.getGlassClothPaper += getGlassClothPaper;
		str[15] += "result:getGlassClothPaper" + info.getGlassClothPaper + "\n";
		str[16] += "former:getLiterature" + info.getLiterature + " ";
		str[16] += "formit:getLiterature" + getLiterature + " ";
		info.getLiterature += getLiterature;
		str[16] += "result:getLiterature" + info.getLiterature + "\n";
		str[17] += "former:getPhysics" + info.getPhysics + " ";
		str[17] += "formit:getPhysics" + getPhysics + " ";
		info.getPhysics += getPhysics;
		str[17] += "result:getPhysics" + info.getPhysics + "\n";
		str[18] += "former:getMath" + info.getMath + " ";
		str[18] += "formit:getMath" + getMath + " ";
		info.getMath += getMath;
		str[18] += "result:getMath" + info.getMath + "\n";
		str[19] += "former:getLiteraturePhysicsMath"
				+ info.getLiteraturePhysicsMath + " ";
		str[19] += "formit:getLiteraturePhysicsMath" + getLiteraturePhysicsMath
				+ " ";
		info.getLiteraturePhysicsMath += getLiteraturePhysicsMath;
		str[19] += "result:getLiteraturePhysicsMath"
				+ info.getLiteraturePhysicsMath + "\n";
		str[20] += "former:getForce" + info.getForce + " ";
		str[20] += "formit:getForce" + getForce + " ";
		info.getForce += getForce;
		str[20] += "result:getForce" + info.getForce + "\n";
		str[21] += "former:getBlueScore" + info.getBlueScore + " ";
		str[21] += "formit:getBlueScore" + getBlueScore + " ";
		info.getBlueScore += getBlueScore;
		str[21] += "result:getBlueScore" + info.getBlueScore + "\n";
		str[22] += "former:getBoardScore" + info.getBoardScore + " ";
		str[22] += "formit:getBoardScore" + getBoardScore + " ";
		info.getBoardScore += getBoardScore;
		str[22] += "result:getBoardScore" + info.getBoardScore + "\n";
		// TODO 共有27种收益状态
		if (LeftCheap) {
			info.LeftCheap = true;
			str[23] += "LeftCheap" + " ";
		}
		if (RightCheap) {
			info.RightCheap = true;
			str[23] += "RightCheap" + " ";
		}
		if (GrayCheap) {
			info.GrayCheap = true;
			str[23] += "GrayCheap" + " ";
		}
		if (LRMGrayCoin) {
			info.LRMGrayCoin = true;
			str[23] += "LRMGrayCoin" + " ";
		}
		if (LRMBrownCoin) {
			info.LRMBrownCoin = true;
			str[23] += "LRMBrownCoin" + " ";
		}
		if (BrownScore) {
			info.BrownScore = true;
			str[23] += "BrownScore" + " ";
		}
		if (YellowScore) {
			info.YellowScore = true;
			str[23] += "YellowScore" + " ";
		}
		if (GrayScore) {
			info.GrayScore = true;
			str[23] += "GrayScore" + " ";
		}
		if (StageScore) {
			info.StageScore = true;
			str[23] += "StageScore" + " ";
		}
		if (BrownCoin) {
			info.BrownCoin = true;
			str[23] += "BrownCoin" + " ";
		}
		if (YellowCoin) {
			info.YellowCoin = true;
			str[23] += "YellowCoin" + " ";
		}
		if (GrayCoin) {
			info.GrayCoin = true;
			str[23] += "GrayCoin" + " ";
		}
		if (StageCoin) {
			info.StageCoin = true;
			str[23] += "StageCoin" + " ";
		}
		if (GuildBrown) {
			info.GuildBrown = true;
			str[23] += "GuildBrown" + " ";
		}
		if (GuildGreen) {
			info.GuildGreen = true;
			str[23] += "GuildGreen" + " ";
		}
		if (GuildYellow) {
			info.GuildYellow = true;
			str[23] += "GuildYellow" + " ";
		}
		if (GuildBlue) {
			info.GuildBlue = true;
			str[23] += "GuildBlue" + " ";
		}
		if (GuildRed) {
			info.GuildRed = true;
			str[23] += "GuildRed" + " ";
		}
		if (GuildGray) {
			info.GuildGray = true;
			str[23] += "GuildGray" + " ";
		}
		if (GuildMixed) {
			info.GuildMixed = true;
			str[23] += "GuildMixed" + " ";
		}
		if (GuildForce) {
			info.GuildForce = true;
			str[23] += "GuildForce" + " ";
		}
		if (GuildStage) {
			info.GuildStage = true;
			str[23] += "GuildStage" + " ";
		}
		if (FreeDiscard) {
			info.FreeDiscard = true;
			str[23] += "FreeDiscard" + " ";
		}
		if (FreeBuild) {
			info.FreeBuild = true;
			str[23] += "FreeBuild" + " ";
		}
		if (LastCard) {
			info.LastCard = true;
			str[23] += "LastCard" + " ";
		}
		if (CheapBuy) {
			info.CheapBuy = true;
			str[23] += "CheapBuy" + " ";
		}
		if (CopyGuild) {
			info.CopyGuild = true;
			str[23] += "CopyGuild" + "\n";
		}
	}

	/**
	 * 获取游戏细节关于收益
	 * 
	 * @return
	 */
	public String[] getDetails() {
		return str;
	}

	/**
	 * 置空函数(不完整)
	 */
	public void clear() {
		getWood = 0;
		getStone = 0;
		getOre = 0;
		getBrick = 0;
		getGlass = 0;
		getCloth = 0;
	}
}
