package Kernel;

/**
 * @author Lane 奇迹板信息
 */

public class Board {

	String name;
	int age = 0;

	// 0 是 A面,1是B面。
	int side;

	// 升级花费
	public int[] Cwood = new int[4];
	public int[] Cstone = new int[4];
	public int[] Cbrick = new int[4];
	public int[] Core = new int[4];
	public int[] Cglass = new int[4];
	public int[] Ccloth = new int[4];
	public int[] Cpaper = new int[4];

	public int[] Gwood = new int[5];
	public int[] Gstone = new int[5];
	public int[] Gbrick = new int[5];
	public int[] Gore = new int[5];

	public int[] Gglass = new int[5];
	public int[] Gcloth = new int[5];
	public int[] Gpaper = new int[5];

	public int[] Gcoin = new int[5];

	public int[] Gwood_stone_brick_ore = new int[5];
	public int[] Gglass_cloth_paper = new int[5];

	public int[] Gforce = new int[5];

	// 科技分为 文学-造字 物理-轮子 数学-卡尺
	public int[] Gliterature = new int[5];
	public int[] Gphysics = new int[5];
	public int[] Gmath = new int[5];

	public int[] Gliterature_physics_math = new int[5];

	// 加分
	public int[] Gscore = new int[5];

	// 特殊效果
	// halicarnassus-build now a discarded building for free
	public boolean FreeDiscard = false;
	// olympia-build 1 free building for each age
	public boolean FreeBuild = false;
	// babylon-play the last card of each age
	public boolean LastCard = false;
	// olympia-cheap buy
	public boolean CheapBuy = false;
	// olympia-copy any guild from a neighbour
	public boolean CopyGuild = false;

	Board(String name, int side) {
		this.name = name;
		this.side = side;
	}

	public void addCost(String str, int num, int age) {
		switch (str) {
		case "wood":
			Cwood[age - 1] += num;
			break;
		case "stone":
			Cstone[age - 1] += num;
			break;
		case "brick":
			Cbrick[age - 1] += num;
			break;
		case "ore":
			Core[age - 1] += num;
			break;

		case "glass":
			Cglass[age - 1] += num;
			break;
		case "cloth":
			Ccloth[age - 1] += num;
			break;
		case "paper":
			Cpaper[age - 1] += num;
			break;
		}
	}

	public void addFormit(String str, int num, int age) {
		switch (str) {
		case "wood":
			Gwood[age] += num;
			break;
		case "stone":
			Gstone[age] += num;
			break;
		case "brick":
			Gbrick[age] += num;
			break;
		case "ore":
			Gore[age] += num;
			break;

		case "glass":
			Gglass[age] += num;
			break;
		case "cloth":
			Gcloth[age] += num;
			break;
		case "paper":
			Gpaper[age] += num;
			break;

		case "coin":
			Gcoin[age] += num;
			break;

		case "wood_stone_brick_ore":
			Gwood_stone_brick_ore[age] += num;
			break;
		case "glass_cloth_paper":
			Gglass_cloth_paper[age] += num;
			break;

		case "force":
			Gforce[age] += num;
			break;

		case "literature":
			Gliterature[age] += num;
			break;
		case "physics":
			Gphysics[age] += num;
			break;
		case "math":
			Gmath[age] += num;
			break;

		case "literature_physics_math":
			Gliterature_physics_math[age] += num;
			break;

		case "score":
			Gscore[age] += num;
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
		}
	}
}
