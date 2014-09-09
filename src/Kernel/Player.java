package Kernel;

/*
 * @author Lane 玩家信息
 */

public class Player {

	public Board board;

	// 资源生产
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

	// 蓝牌加分
	public int GblueScore = 0;

	Player(Board board) {
		this.board = board;
	}
}
