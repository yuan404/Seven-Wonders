package Kernel;

import javafx.scene.paint.Paint;

/**
 * @author Lane 玩家信息
 */

public class Player {

	public Board board;
	public Paint color;

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

	public int Gliterature_physics_math = 0;

	// 蓝牌加分
	public int GblueScore = 0;

	// 奇迹板加分
	public int GboardScore = 0;

	public int freeNum = 0;
	public String[] freeBuild = new String[55];

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

	Player(Board board, Paint color) {
		this.board = board;
		this.color = color;
	}
}
