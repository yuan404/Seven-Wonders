package Kernel;

import GUI.Game;

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

	// TODO 建造该卡牌的可行性
	public static boolean ifBuild(Player player, Card card) {
		for (int i = 0; i < player.cardNum; i++) {
			if (card.name == player.card[i].name)
				return false;
		}
		for (int i = 0; i < player.freeNum; i++) {
			if (card.name == player.freeBuild[i]) {
				return true;
			}
		}
		int wood = player.Gwood - card.Cwood + player.Bwood;
		int stone = player.Gstone - card.Cstone + player.Bstone;
		int brick = player.Gbrick - card.Cbrick + player.Bbrick;
		int ore = player.Gore - card.Core + player.Bore;

		int cloth = player.Gcloth - card.Ccloth + player.Bcloth;
		int glass = player.Gglass - card.Cglass + player.Bglass;
		int paper = player.Gpaper - card.Cpaper + player.Bpaper;

		int coin = player.Gcoin - card.Ccoin;
		if (coin < 0)
			return false;
		if (ifBuild2(player, wood, stone, brick, ore, cloth, glass, paper))
			return true;
		return false;
	}

	public static boolean ifBuild2(Player player, int wood, int stone,
			int brick, int ore, int cloth, int glass, int paper) {
		int three = 0;
		if (cloth < 0)
			three += cloth;
		if (glass < 0)
			three += glass;
		if (paper < 0)
			three += paper;
		three += player.Gglass_cloth_paper;
		if (three < 0)
			return false;
		int wb = player.Gwood_brick;
		int ws = player.Gwood_stone;
		int wo = player.Gwood_ore;
		int sb = player.Gstone_brick;
		int so = player.Gstone_ore;
		int bo = player.Gbrick_ore;
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
		if (wood > 0)
			wood = 0;
		if (stone > 0)
			stone = 0;
		if (brick > 0)
			brick = 0;
		if (ore > 0)
			ore = 0;
		if (wood + stone + brick + ore + player.Gwood_stone_brick_ore < 0)
			return false;
		else
			return true;
	}

	public static boolean ifBuildStage(Player player) {
		int age = player.board.age;
		if (age == player.board.max)
			return false;
		int wood = player.Gwood - player.board.Cwood[age] + player.Bwood;
		int stone = player.Gstone - player.board.Cstone[age] + player.Bstone;
		int brick = player.Gbrick - player.board.Cbrick[age] + player.Bbrick;
		int ore = player.Gore - player.board.Core[age] + player.Bore;

		int cloth = player.Gcloth - player.board.Ccloth[age] + player.Bcloth;
		int glass = player.Gglass - player.board.Cglass[age] + player.Bglass;
		int paper = player.Gpaper - player.board.Cpaper[age] + player.Bpaper;

		if (ifBuild2(player, wood, stone, brick, ore, cloth, glass, paper))
			return true;
		return false;
	}

	// TODO 三种操作造成的收益
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

		player.Gcoin -= card.Ccoin;

		if (card.color == "Brown") {
			player.brownNum++;
		} else if (card.color == "Gray") {
			player.grayNum++;
		} else if (card.color == "Green") {
			player.greenNum++;
		} else if (card.color == "Blue") {
			player.blueNum++;
		} else if (card.color == "Red") {
			player.redNum++;
		} else if (card.color == "Yellow") {
			player.yellowNum++;
		} else if (card.color == "Purple") {
			player.purpleNum++;
		}
		if (card.color == "Green" && card.Gliterature == 1)
			Game.addPoint(card.color, player, 1, card);
		else if (card.color == "Green" && card.Gphysics == 1)
			Game.addPoint(card.color, player, 2, card);
		else if (card.color == "Green" && card.Gmath == 1)
			Game.addPoint(card.color, player, 3, card);
		else
			Game.addPoint(card.color, player, 0, card);

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
		player.Gwood += player.board.Gwood[age];
		player.Gstone += player.board.Gstone[age];
		player.Gbrick += player.board.Gbrick[age];
		player.Gore += player.board.Gore[age];
		player.Gglass += player.board.Gglass[age];
		player.Gcloth += player.board.Gcloth[age];
		player.Gpaper += player.board.Gpaper[age];

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
		if (player.board.FreeBuild[age] == true) {
			player.FreeBuild = true;
			Manager m = new Manager();
			for (int i = m.getKenelManager().age - 1; i < 3; i++)
				player.free[i] = 1;
		}
		if (player.board.FreeDiscard[age] == true)
			player.FreeDiscard = true;
		if (player.board.LastCard[age] == true)
			player.LastCard = true;
	}

	public static void doAction(Player player, Card card, boolean discard) {
		player.Gcoin += 3;
	}

	// TODO 判断是否能买
	public static boolean ifBuy(Player player, Buy card) {
		int wood = player.Gwood - card.Cwood + player.Bwood;
		int stone = player.Gstone - card.Cstone + player.Bstone;
		int brick = player.Gbrick - card.Cbrick + player.Bbrick;
		int ore = player.Gore - card.Core + player.Bore;

		int cloth = player.Gcloth - card.Ccloth + player.Bcloth;
		int glass = player.Gglass - card.Cglass + player.Bglass;
		int paper = player.Gpaper - card.Cpaper + player.Bpaper;

		if (ifBuy2(player, wood, stone, brick, ore, cloth, glass, paper))
			return true;
		return false;
	}

	public static boolean ifBuy2(Player player, int wood, int stone, int brick,
			int ore, int cloth, int glass, int paper) {
		int three = 0;
		if (cloth < 0)
			three += cloth;
		if (glass < 0)
			three += glass;
		if (paper < 0)
			three += paper;
		three += player.Gglass_cloth_paper;
		if (three < 0)
			return false;
		int wb = player.Gwood_brick;
		int ws = player.Gwood_stone;
		int wo = player.Gwood_ore;
		int sb = player.Gstone_brick;
		int so = player.Gstone_ore;
		int bo = player.Gbrick_ore;
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
		if (wood > 0)
			wood = 0;
		if (stone > 0)
			stone = 0;
		if (brick > 0)
			brick = 0;
		if (ore > 0)
			ore = 0;
		if (wood + stone + brick + ore < 0)
			return false;
		else
			return true;
	}

}
