package Kernel;

import javafx.scene.image.ImageView;

/**
 * @author Lane 奇迹板信息
 */

public class Board {

	public String name;
	public int age = -1;

	public ImageView iv = new ImageView();

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

	public int[] Gcoin = new int[5];

	public int[] Gwood_stone_brick_ore = new int[5];
	public int[] Gglass_cloth_paper = new int[5];

	public int[] Gforce = new int[5];

	public int[] Gliterature_physics_math = new int[5];

	// 加分
	public int[] Gscore = new int[5];

	// 特殊效果
	// halicarnassus-build now a discarded building for free
	public boolean[] FreeDiscard = new boolean[5];
	// olympia-build 1 free building for each age
	public boolean[] FreeBuild = new boolean[5];
	// babylon-play the last card of each age
	public boolean[] LastCard = new boolean[5];
	// olympia-cheap buy
	public boolean[] CheapBuy = new boolean[5];
	// olympia-copy any guild from a neighbour
	public boolean[] CopyGuild = new boolean[5];

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

		case "literature_physics_math":
			Gliterature_physics_math[age] += num;
			break;

		case "score":
			Gscore[age] += num;
			break;

		case "FreeDiscard":
			FreeDiscard[age] = true;
			break;
		case "FreeBuild":
			FreeBuild[age] = true;
			break;
		case "LastCard":
			LastCard[age] = true;
			break;
		case "CheapBuy":
			CheapBuy[age] = true;
			break;
		case "CopyGuild":
			CopyGuild[age] = true;
			break;
		}
	}
}
