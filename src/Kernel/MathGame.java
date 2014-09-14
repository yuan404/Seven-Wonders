package Kernel;

/**
 * 
 * @author Lane 数学逻辑函数
 * 
 */
public class MathGame {
	public MathGame() {

	}

	public static double getCircleX(double angle, double X, double Y,
			double radius) {
		double x = X + radius * Math.sin(angle * Math.PI / 180);
		return x;
	}

	public static double getCircleY(double angle, double X, double Y,
			double radius) {
		double y = Y - radius * Math.cos(angle * Math.PI / 180);
		return y;
	}

	// 三种操作的判断
	public static boolean ifBuy() {
		
		return false;
	}

	public static boolean ifBuild() {
		return false;
	}

	public static boolean ifBuildStage() {
		return false;
	}

	// 三种操作造成的收益
	public static void doAction(Player player, Card card) {
		player.GblueScore += card.GblueScore;
		player.Gbrick += card.Gbrick;
		player.Gbrick_ore += card.Gbrick_ore;
		player.Gcloth += card.Gcloth;
		player.Gcoin += card.Gcoin;
		player.Gforce += card.Gforce;
		player.Gglass += card.Gglass;
		player.Gglass_cloth_paper += card.Gglass_cloth_paper;
		player.Gliterature += card.Gliterature;
		player.Gmath += card.Gmath;
		player.Gore += card.Gore;
		player.Gpaper += card.Gpaper;
		player.Gphysics += card.Gphysics;
		player.Gstone += card.Gstone;
		player.Gstone_brick += card.Gstone_brick;
		player.Gstone_ore += card.Gstone_ore;
		player.Gwood += card.Gwood;
		player.Gwood_brick += card.Gwood_brick;
		player.Gwood_ore += card.Gwood_ore;
		player.Gwood_stone += card.Gwood_stone;
		player.Gwood_stone_brick_ore += card.Gwood_stone_brick_ore;

		if (card.freeBuild[0] != null) {
			player.freeBuild[player.freeNum++] = card.freeBuild[0];
			if (card.freeBuild[1] != null)
				player.freeBuild[player.freeNum++] = card.freeBuild[1];
		}

		if (card.LeftCheap == true)
			player.LeftCheap = true;
		if (card.RightCheap == true)
			player.RightCheap = true;
		if (card.GrayCheap == true)
			player.GrayCheap = true;

		if (card.LRMGrayCoin == true)
			player.LRMGrayCoin = true;
		if (card.LRMBrownCoin == true)
			player.LRMBrownCoin = true;

		if (card.BrownScore == true)
			player.BrownScore = true;
		if (card.YellowScore == true)
			player.YellowScore = true;
		if (card.GrayScore == true)
			player.GrayScore = true;
		if (card.StageScore == true)
			player.StageScore = true;

		if (card.GrayCoin == true)
			player.GrayCoin = true;
		if (card.BrownCoin == true)
			player.BrownCoin = true;
		if (card.YellowCoin == true)
			player.YellowCoin = true;
		if (card.StageCoin == true)
			player.StageCoin = true;

		if (card.GuildMixed == true)
			player.GuildMixed = true;
		if (card.GuildBrown == true)
			player.GuildBrown = true;
		if (card.GuildBlue == true)
			player.GuildBlue = true;
		if (card.GuildRed == true)
			player.GuildRed = true;
		if (card.GuildYellow == true)
			player.GuildYellow = true;
		if (card.GuildGreen == true)
			player.GuildGreen = true;
		if (card.GuildForce == true)
			player.GuildForce = true;
		if (card.GuildStage == true)
			player.GuildStage = true;
		if (card.GuildGray == true)
			player.GuildGray = true;
	}

	public static void doAction(Player player) {
		player.board.age++;
		int age = player.board.age;
		player.Gwood_stone_brick_ore += player.board.Gwood_stone_brick_ore[age];
		player.Gglass_cloth_paper += player.board.Gglass_cloth_paper[age];
		player.Gliterature_physics_math += player.board.Gliterature_physics_math[age];
		player.Gcoin += player.board.Gcoin[age];
		player.Gforce += player.board.Gforce[age];
		player.GboardScore += player.board.Gscore[age];
		if (player.board.CheapBuy[age] == true)
			player.CheapBuy = true;
		if (player.board.CopyGuild[age] == true)
			player.CopyGuild = true;
		if (player.board.FreeBuild[age] == true)
			player.FreeBuild = true;
		if (player.board.FreeDiscard[age] == true)
			player.FreeDiscard = true;
		if (player.board.LastCard[age] == true)
			player.LastCard = true;
	}

	public static void doAction(Player player, Card card, boolean discard) {
		player.Gcoin += 3;
	}
}
