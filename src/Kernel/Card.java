package Kernel;

import javafx.scene.image.ImageView;

/**
 * @author Lane 卡牌信息类
 */

public class Card {
	// 卡牌颜色
	public String color;
	// 卡牌时代
	public int age;
	// 卡牌名称
	public String name;
	// 卡牌开启人数
	public int num;

	public ImageView iv = new ImageView();

	// 卡牌花费
	public int Cwood = 0;
	public int Cstone = 0;
	public int Cbrick = 0;
	public int Core = 0;
	public int Cglass = 0;
	public int Ccloth = 0;
	public int Cpaper = 0;
	public int Ccoin = 0;

	// 卡牌收益
	public int Gwood = 0;
	public int Gstone = 0;
	public int Gbrick = 0;
	public int Gore = 0;

	public int Gglass = 0;
	public int Gcloth = 0;
	public int Gpaper = 0;

	public int Gcoin = 0;

	public int Gwood_stone = 0;
	public int Gwood_brick = 0;
	public int Gwood_ore = 0;
	public int Gstone_brick = 0;
	public int Gstone_ore = 0;
	public int Gbrick_ore = 0;

	public int Gwood_stone_brick_ore = 0;
	public int Gglass_cloth_paper = 0;

	public int Gforce = 0;

	// 科技分为 文学-造字 物理-轮子 数学-卡尺
	public int Gliterature = 0;
	public int Gphysics = 0;
	public int Gmath = 0;

	public int Gliterature_physics_math = 0;

	public String[] freeBuild = new String[2];

	public boolean LeftCheap = false;
	public boolean RightCheap = false;
	public boolean GrayCheap = false;

	public boolean LRMGrayCoin = false;
	public boolean LRMBrownCoin = false;

	public boolean BrownScore = false;
	public boolean YellowScore = false;
	public boolean GrayScore = false;
	public boolean StageScore = false;

	public boolean GrayCoin = false;
	public boolean BrownCoin = false;
	public boolean YellowCoin = false;
	public boolean StageCoin = false;

	public boolean GuildMixed = false;
	public boolean GuildBrown = false;
	public boolean GuildBlue = false;
	public boolean GuildRed = false;
	public boolean GuildYellow = false;
	public boolean GuildGreen = false;
	public boolean GuildForce = false;
	public boolean GuildStage = false;
	public boolean GuildGray = false;

	// 蓝牌加分
	public int GblueScore = 0;

	public Card(String name, String color, int age, int num) {
		this.name = name;
		this.color = color;
		this.age = age;
		this.num = num;
	}

	public void addCost(String str, int num) {
		switch (str) {
		case "wood":
			Cwood += num;
			break;
		case "stone":
			Cstone += num;
			break;
		case "brick":
			Cbrick += num;
			break;
		case "ore":
			Core += num;
			break;

		case "glass":
			Cglass += num;
			break;
		case "cloth":
			Ccloth += num;
			break;
		case "paper":
			Cpaper += num;
			break;

		case "coin":
			Ccoin += num;
			break;
		}
	}

	public void addFormit(String str, int num) {
		switch (str) {
		case "wood":
			Gwood += num;
			break;
		case "stone":
			Gstone += num;
			break;
		case "brick":
			Gbrick += num;
			break;
		case "ore":
			Gore += num;
			break;

		case "glass":
			Gglass += num;
			break;
		case "cloth":
			Gcloth += num;
			break;
		case "paper":
			Gpaper += num;
			break;

		case "coin":
			Gcoin += num;
			break;

		case "wood_stone":
			Gwood_stone += num;
			break;
		case "wood_brick":
			Gwood_brick += num;
			break;
		case "wood_ore":
			Gwood_ore += num;
			break;
		case "stone_brick":
			Gstone_brick += num;
			break;
		case "stone_ore":
			Gstone_ore += num;
			break;
		case "brick_ore":
			Gbrick_ore += num;
			break;

		case "wood_stone_brick_ore":
			Gwood_stone_brick_ore += num;
			break;
		case "glass_cloth_paper":
			Gglass_cloth_paper += num;
			break;

		case "force":
			Gforce += num;
			break;

		case "literature":
			Gliterature += num;
			break;
		case "physics":
			Gphysics += num;
			break;
		case "math":
			Gmath += num;
			break;

		case "literature_physics_math":
			Gliterature_physics_math += num;
			break;

		case "blueScore":
			GblueScore += num;
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
			BrownScore = true;
			break;
		case "YellowCoin":
			YellowScore = true;
			break;
		case "GrayCoin":
			GrayScore = true;
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
		}

	}

	public void addFree(String name) {
		if (freeBuild[0] == null)
			freeBuild[0] = name;
		else
			freeBuild[1] = name;
	}
}
