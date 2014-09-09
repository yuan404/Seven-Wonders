package Kernel;

/*
 * @author Lane 奇迹板信息
 */

public class Board {

	String name;
	int age = 0;

	// 0 是 A面,1是B面。
	int side;

	// 升级花费
	public int[] Cwood = new int[3];
	public int[] Cstone = new int[3];
	public int[] Cbrick = new int[3];
	public int[] Core = new int[3];
	public int[] Cglass = new int[3];
	public int[] Ccloth = new int[3];
	public int[] Cpaper = new int[3];

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
}
