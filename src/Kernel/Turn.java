package Kernel;

import GUI.Game;

/**
 * 
 * @author Lane 进入这里说明已经判断过是否足够资源或者金钱去建造卡牌或者奇迹
 * 
 */
public class Turn {

	// 所选择的卡牌
	public Card card;
	// 0代表卖牌;1代表建造卡牌;2代表建造奇迹
	public int choose = 0;
	// 玩家序号
	public int index;
	// 他人买资源所获得的金钱
	public int Gcoin = 0;

	public Turn(int i) {
		this.index = i;
	}

	public void setChoose(Card card, int choose) {
		this.card = card;
		this.choose = choose;
		System.out.print(card.name + ":" + choose + "\n");
		Manager m = new Manager();
		m.getKenelManager().checkTurn();
	}

	public void setChoose(int choose) {
		this.choose = choose;
	}

	public void update(Player player, Board board) {
		int age = board.age + 1;
		if (board.Gwood[age] > 0)
			Game.AddResource(player, "wood", board.Gwood[age]);
		else if (board.Gstone[age] > 0)
			Game.AddResource(player, "stone", board.Gstone[age]);
		else if (board.Gbrick[age] > 0)
			Game.AddResource(player, "brick", board.Gbrick[age]);
		else if (board.Gore[age] > 0)
			Game.AddResource(player, "ore", board.Gore[age]);
		else if (board.Gglass[age] > 0)
			Game.AddResource(player, "glass", board.Gglass[age]);
		else if (board.Gcloth[age] > 0)
			Game.AddResource(player, "cloth", board.Gcloth[age]);
		else if (board.Gpaper[age] > 0)
			Game.AddResource(player, "paper", board.Gpaper[age]);
		else if (board.Gwood_stone_brick_ore[age] > 0)
			Game.AddResource(player, "wood_stone_brick_ore",
					board.Gwood_stone_brick_ore[age]);
		else if (board.Gglass_cloth_paper[age] > 0)
			Game.AddResource(player, "glass_cloth_paper",
					board.Gglass_cloth_paper[age]);
	}

	public void update(Player player, Card card) {
		if (card.Gwood > 0)
			Game.AddResource(player, "wood", card.Gwood);
		else if (card.Gstone > 0)
			Game.AddResource(player, "stone", card.Gstone);
		else if (card.Gbrick > 0)
			Game.AddResource(player, "brick", card.Gbrick);
		else if (card.Gore > 0)
			Game.AddResource(player, "ore", card.Gore);
		else if (card.Gglass > 0)
			Game.AddResource(player, "glass", card.Gglass);
		else if (card.Gcloth > 0)
			Game.AddResource(player, "cloth", card.Gcloth);
		else if (card.Gpaper > 0)
			Game.AddResource(player, "paper", card.Gpaper);
		else if (card.Gwood_stone > 0)
			Game.AddResource(player, "wood_stone", card.Gwood_stone);
		else if (card.Gwood_brick > 0)
			Game.AddResource(player, "wood_brick", card.Gwood_brick);
		else if (card.Gwood_ore > 0)
			Game.AddResource(player, "wood_ore", card.Gwood_ore);
		else if (card.Gstone_brick > 0)
			Game.AddResource(player, "stone_brick", card.Gstone_brick);
		else if (card.Gstone_ore > 0)
			Game.AddResource(player, "stone_ore", card.Gstone_ore);
		else if (card.Gbrick_ore > 0)
			Game.AddResource(player, "brick_ore", card.Gbrick_ore);
		else if (card.Gwood_stone_brick_ore > 0)
			Game.AddResource(player, "wood_stone_brick_ore",
					card.Gwood_stone_brick_ore);
		else if (card.Gglass_cloth_paper > 0)
			Game.AddResource(player, "glass_cloth_paper",
					card.Gglass_cloth_paper);
	}
}