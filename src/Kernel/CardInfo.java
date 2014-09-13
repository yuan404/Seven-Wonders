package Kernel;

public class CardInfo {
	Card[] card = new Card[149];

	public CardInfo() {
		card[0] = new Card("Theater", "Blue", 1, 3);
		card[0].addFormit("blueScore", 2);
		card[0].addFree("Statue");

		card[1] = new Card("Altar", "Blue", 1, 5);
		card[1].addFormit("blueScore", 2);
		card[1].addFree("Temple");

		card[2] = new Card("Baths", "Blue", 1, 3);
		card[2].addCost("stone", 1);
		card[2].addFormit("blueScore", 3);
		card[2].addFree("Aqueduct");

		card[3] = new Card("Baths", "Blue", 1, 7);
		card[3].addCost("stone", 1);
		card[3].addFormit("blueScore", 3);
		card[3].addFree("Aqueduct");

		card[4] = new Card("Pawnshop", "Blue", 1, 4);
		card[4].addFormit("blueScore", 3);

		card[5] = new Card("Pawnshop", "Blue", 1, 7);
		card[5].addFormit("blueScore", 3);

		card[6] = new Card("ClayPool", "Brown", 1, 3);
		card[6].addFormit("brick", 1);

		card[7] = new Card("ClayPool", "Brown", 1, 5);
		card[7].addFormit("brick", 1);

		card[8] = new Card("ClayPit", "Brown", 1, 3);
		card[8].addCost("coin", 1);
		card[8].addFormit("brick_ore", 1);

		card[9] = new Card("OreVein", "Brown", 1, 3);
		card[9].addFormit("ore", 1);

		card[10] = new Card("Excavation", "Brown", 1, 4);
		card[10].addCost("coin", 1);
		card[10].addFormit("stone_brick", 1);

		card[11] = new Card("TimberYard", "Brown", 1, 3);
		card[11].addCost("coin", 1);
		card[11].addFormit("wood_stone", 1);

		card[12] = new Card("OreVein", "Brown", 1, 4);
		card[12].addFormit("ore", 1);

		card[13] = new Card("LumberYard", "Brown", 1, 3);
		card[13].addFormit("wood", 1);

		card[14] = new Card("LumberYard", "Brown", 1, 4);
		card[14].addFormit("wood", 1);

		card[15] = new Card("TreeFarm", "Brown", 1, 6);
		card[15].addCost("coin", 1);
		card[15].addFormit("wood_brick", 1);

		card[16] = new Card("Mine", "Brown", 1, 6);
		card[16].addCost("coin", 1);
		card[16].addFormit("stone_ore", 1);

		card[17] = new Card("StonePit", "Brown", 1, 5);
		card[17].addFormit("stone", 1);

		card[18] = new Card("Glassworks", "Gray", 1, 6);
		card[18].addFormit("glass", 1);

		card[19] = new Card("Press", "Gray", 1, 3);
		card[19].addFormit("paper", 1);

		card[20] = new Card("Press", "Gray", 1, 6);
		card[20].addFormit("paper", 1);

		card[21] = new Card("Loom", "Gray", 1, 3);
		card[21].addFormit("cloth", 1);

		card[22] = new Card("Glassworks", "Gray", 1, 3);
		card[22].addFormit("glass", 1);

		card[23] = new Card("Loom", "Gray", 1, 6);
		card[23].addFormit("cloth", 1);

		card[24] = new Card("Scriptorium", "Green", 1, 3);
		card[24].addCost("paper", 1);
		card[24].addFormit("literature", 1);
		card[24].addFree("Courthouse");
		card[24].addFree("Library");

		card[25] = new Card("WorkShop", "Green", 1, 7);
		card[25].addCost("glass", 1);
		card[25].addFormit("Physics", 1);
		card[25].addFree("Laboratory");
		card[25].addFree("ArcheryRange");

		card[26] = new Card("Apothecary", "Green", 1, 3);
		card[26].addCost("cloth", 1);
		card[26].addFormit("math", 1);
		card[26].addFree("Stables");
		card[26].addFree("Dispensary");

		card[27] = new Card("Scriptorium", "Green", 1, 4);
		card[27].addCost("paper", 1);
		card[27].addFormit("literature", 1);
		card[27].addFree("Courthouse");
		card[27].addFree("Library");

		card[28] = new Card("Apothecary", "Green", 1, 5);
		card[28].addCost("cloth", 1);
		card[28].addFormit("math", 1);
		card[28].addFree("Stables");
		card[28].addFree("Dispensary");

		card[29] = new Card("WorkShop", "Green", 1, 3);
		card[29].addCost("glass", 1);
		card[29].addFormit("Physics", 1);
		card[29].addFree("Laboratory");
		card[29].addFree("ArcheryRange");

		card[30] = new Card("Theater", "Blue", 1, 6);
		card[30].addFormit("blueScore", 2);
		card[30].addFree("Statue");

		card[31] = new Card("Altar", "Blue", 1, 3);
		card[31].addFormit("blueScore", 2);
		card[31].addFree("Temple");

		card[32] = new Card("GuardTower", "Red", 1, 4);
		card[32].addCost("brick", 1);
		card[32].addFormit("force", 1);

		card[33] = new Card("GuardTower", "Red", 1, 3);
		card[33].addCost("brick", 1);
		card[33].addFormit("force", 1);

		card[34] = new Card("Barracks", "Red", 1, 3);
		card[34].addCost("ore", 1);
		card[34].addFormit("force", 1);

		card[35] = new Card("Barracks", "Red", 1, 5);
		card[35].addCost("ore", 1);
		card[35].addFormit("force", 1);

		card[36] = new Card("Stockade", "Red", 1, 7);
		card[36].addCost("wood", 1);
		card[36].addFormit("force", 1);

		card[37] = new Card("Stockade", "Red", 1, 3);
		card[37].addCost("wood", 1);
		card[37].addFormit("force", 1);

		card[38] = new Card("ForestCave", "Brown", 1, 5);
		card[38].addCost("coin", 1);
		card[38].addFormit("wood_ore", 1);

		card[39] = new Card("StonePit", "Brown", 1, 3);
		card[39].addFormit("stone", 1);

		card[40] = new Card("EastTradingPost", "Yellow", 1, 3);
		card[40].addFormit("RightCheap", 1);
		card[40].addFree("Forum");

		card[41] = new Card("WestTradingPost", "Yellow", 1, 3);
		card[41].addFormit("LeftCheap", 1);
		card[41].addFree("Forum");

		card[42] = new Card("EastTradingPost", "Yellow", 1, 7);
		card[42].addFormit("RightCheap", 1);
		card[42].addFree("Forum");

		card[43] = new Card("WestTradingPost", "Yellow", 1, 7);
		card[43].addFormit("LeftCheap", 1);
		card[43].addFree("Forum");

		card[44] = new Card("Tavern", "Yellow", 1, 4);
		card[44].addFormit("coin", 5);

		card[45] = new Card("Tavern", "Yellow", 1, 5);
		card[45].addFormit("coin", 5);

		card[46] = new Card("Tavern", "Yellow", 1, 7);
		card[46].addFormit("coin", 5);

		card[47] = new Card("Marketplace", "Yellow", 1, 6);
		card[47].addFormit("GrayCheap", 1);
		card[47].addFree("Caravansery");

		card[48] = new Card("Marketplace", "Yellow", 1, 3);
		card[48].addFormit("GrayCheap", 1);
		card[48].addFree("Caravansery");

		TestCard();
	}

	public void changeCardAgeTwo() {
		card[0] = new Card("Aqueduct", "Blue", 2, 7);
		card[0].addCost("stone", 3);
		card[0].addFormit("blueScore", 5);

		card[1] = new Card("Aqueduct", "Blue", 2, 3);
		card[1].addCost("stone", 3);
		card[1].addFormit("blueScore", 5);

		card[2] = new Card("Temple", "Blue", 2, 3);
		card[2].addCost("wood", 1);
		card[2].addCost("brick", 1);
		card[2].addCost("glass", 1);
		card[2].addFormit("blueScore", 3);
		card[2].addFree("Pantheon");

		card[3] = new Card("Statue", "Blue", 2, 3);
		card[3].addCost("ore", 2);
		card[3].addCost("wood", 1);
		card[3].addFormit("blueScore", 4);
		card[3].addFree("Gardens");

		card[4] = new Card("Temple", "Blue", 2, 6);
		card[4].addCost("wood", 1);
		card[4].addCost("brick", 1);
		card[4].addCost("glass", 1);
		card[4].addFormit("blueScore", 3);
		card[4].addFree("Pantheon");

		card[5] = new Card("Statue", "Blue", 2, 7);
		card[5].addCost("ore", 2);
		card[5].addCost("wood", 1);
		card[5].addFormit("blueScore", 4);
		card[5].addFree("Gardens");

		card[6] = new Card("Foundry", "Brown", 2, 4);
		card[6].addCost("coin", 1);
		card[6].addFormit("ore", 2);

		card[7] = new Card("Brickyard", "Brown", 2, 4);
		card[7].addCost("coin", 1);
		card[7].addFormit("brick", 2);

		card[8] = new Card("Foundry", "Brown", 2, 3);
		card[8].addCost("coin", 1);
		card[8].addFormit("ore", 2);

		card[9] = new Card("Sawmill", "Brown", 2, 4);
		card[9].addCost("coin", 1);
		card[9].addFormit("wood", 2);

		card[10] = new Card("Sawmill", "Brown", 2, 3);
		card[10].addCost("coin", 1);
		card[10].addFormit("wood", 2);

		card[11] = new Card("Quarry", "Brown", 2, 4);
		card[11].addCost("coin", 1);
		card[11].addFormit("stone", 2);

		card[12] = new Card("Press", "Gray", 2, 3);
		card[12].addFormit("paper", 1);

		card[13] = new Card("Loom", "Gray", 2, 5);
		card[13].addFormit("cloth", 1);

		card[14] = new Card("Loom", "Gray", 2, 3);
		card[14].addFormit("cloth", 1);

		card[15] = new Card("Glassworks", "Gray", 2, 5);
		card[15].addFormit("glass", 1);

		card[16] = new Card("Press", "Gray", 2, 5);
		card[16].addFormit("paper", 1);

		card[17] = new Card("Glassworks", "Gray", 2, 3);
		card[17].addFormit("glass", 1);

		card[18] = new Card("Library", "Green", 2, 6);
		card[18].addCost("stone", 2);
		card[18].addCost("cloth", 1);
		card[18].addFormit("literature", 1);
		card[18].addFree("Senate");
		card[18].addFree("University");

		card[19] = new Card("Dispensary", "Green", 2, 3);
		card[19].addCost("ore", 2);
		card[19].addCost("glass", 1);
		card[19].addFormit("math", 1);
		card[19].addFree("Lodge");
		card[19].addFree("Arena");

		card[20] = new Card("Laboratory", "Green", 2, 3);
		card[20].addCost("brick", 2);
		card[20].addCost("paper", 1);
		card[20].addFormit("physics", 1);
		card[20].addFree("Observatory");
		card[20].addFree("SiegeWorkShop");

		card[21] = new Card("School", "Green", 2, 7);
		card[21].addCost("wood", 1);
		card[21].addCost("paper", 1);
		card[21].addFormit("literature", 1);
		card[21].addFree("Academy");
		card[21].addFree("Study");

		card[22] = new Card("Library", "Green", 2, 3);
		card[22].addCost("stone", 2);
		card[22].addCost("cloth", 1);
		card[22].addFormit("literature", 1);
		card[22].addFree("Senate");
		card[22].addFree("University");

		card[23] = new Card("Dispensary", "Green", 2, 4);
		card[23].addCost("ore", 2);
		card[23].addCost("glass", 1);
		card[23].addFormit("math", 1);
		card[23].addFree("Lodge");
		card[23].addFree("Arena");

		card[24] = new Card("Brickyard", "Brown", 2, 3);
		card[24].addCost("coin", 1);
		card[24].addFormit("brick", 2);

		card[25] = new Card("School", "Green", 2, 3);
		card[25].addCost("wood", 1);
		card[25].addCost("paper", 1);
		card[25].addFormit("literature", 1);
		card[25].addFree("Academy");
		card[25].addFree("Study");

		card[26] = new Card("Courthouse", "Blue", 2, 5);
		card[26].addCost("brick", 2);
		card[26].addCost("cloth", 1);
		card[26].addFormit("blueScore", 4);

		card[27] = new Card("Laboratory", "Green", 2, 5);
		card[27].addCost("brick", 2);
		card[27].addCost("paper", 1);
		card[27].addFormit("physics", 1);
		card[27].addFree("Observatory");
		card[27].addFree("SiegeWorkShop");

		card[28] = new Card("Courthouse", "Blue", 2, 3);
		card[28].addCost("brick", 2);
		card[28].addCost("cloth", 1);
		card[28].addFormit("blueScore", 4);

		card[29] = new Card("Quarry", "Brown", 2, 3);
		card[29].addCost("coin", 1);
		card[29].addFormit("stone", 2);

		card[30] = new Card("Walls", "Red", 2, 7);
		card[30].addCost("stone", 3);
		card[30].addFormit("force", 2);
		card[30].addFree("Fortifications");

		card[31] = new Card("Walls", "Red", 2, 3);
		card[31].addCost("stone", 3);
		card[31].addFormit("force", 2);
		card[31].addFree("Fortifications");

		card[32] = new Card("TrainingGround", "Red", 2, 6);
		card[32].addCost("ore", 2);
		card[32].addCost("wood", 1);
		card[32].addFormit("force", 2);
		card[32].addFree("Circus");

		card[33] = new Card("TrainingGround", "Red", 2, 7);
		card[33].addCost("ore", 2);
		card[33].addCost("wood", 1);
		card[33].addFormit("force", 2);
		card[33].addFree("Circus");

		card[34] = new Card("ArcheryRange", "Red", 2, 6);
		card[34].addCost("wood", 2);
		card[34].addCost("ore", 1);
		card[34].addFormit("force", 2);

		card[35] = new Card("TrainingGround", "Red", 2, 4);
		card[35].addCost("ore", 2);
		card[35].addCost("wood", 1);
		card[35].addFormit("force", 2);
		card[35].addFree("Circus");

		card[36] = new Card("Stables", "Red", 2, 3);
		card[36].addCost("wood", 1);
		card[36].addCost("brick", 1);
		card[36].addCost("ore", 1);
		card[36].addFormit("force", 2);

		card[37] = new Card("Stables", "Red", 2, 5);
		card[37].addCost("wood", 1);
		card[37].addCost("brick", 1);
		card[37].addCost("ore", 1);
		card[37].addFormit("force", 2);

		card[38] = new Card("ArcheryRange", "Red", 2, 3);
		card[38].addCost("wood", 2);
		card[38].addCost("ore", 1);
		card[38].addFormit("force", 2);

		card[39] = new Card("Bazar", "Yellow", 2, 4);
		card[39].addFormit("LRMGrayCoin", 1);

		card[40] = new Card("Bazar", "Yellow", 2, 7);
		card[40].addFormit("LRMGrayCoin", 1);

		card[41] = new Card("Caravansery", "Yellow", 2, 6);
		card[41].addCost("wood", 2);
		card[41].addFormit("wood_stone_brick_ore", 1);
		card[41].addFree("Lighthouse");

		card[42] = new Card("Vineyard", "Yellow", 2, 3);
		card[42].addFormit("LRMBrownCoin", 1);

		card[43] = new Card("Vineyard", "Yellow", 2, 6);
		card[43].addFormit("LRMBrownCoin", 1);

		card[44] = new Card("Caravansery", "Yellow", 2, 5);
		card[44].addCost("wood", 2);
		card[44].addFormit("wood_stone_brick_ore", 1);
		card[44].addFree("Lighthouse");

		card[45] = new Card("Forum", "Yellow", 2, 3);
		card[45].addCost("brick", 2);
		card[45].addFormit("glass_cloth_paper", 1);
		card[45].addFree("Haven");

		card[46] = new Card("Forum", "Yellow", 2, 7);
		card[46].addCost("brick", 2);
		card[46].addFormit("glass_cloth_paper", 1);
		card[46].addFree("Haven");

		card[47] = new Card("Forum", "Yellow", 2, 6);
		card[47].addCost("brick", 2);
		card[47].addFormit("glass_cloth_paper", 1);
		card[47].addFree("Haven");

		card[48] = new Card("Caravansery", "Yellow", 2, 3);
		card[48].addCost("wood", 2);
		card[48].addFormit("wood_stone_brick_ore", 1);
		card[48].addFree("Lighthouse");
	}

	public void changeCardAgeThree() {
		card[0] = new Card("Senate", "Blue", 3, 5);
		card[0].addCost("wood", 2);
		card[0].addCost("stone", 1);
		card[0].addCost("ore", 1);
		card[0].addFormit("blueScore", 6);

		card[1] = new Card("Gardens", "Blue", 3, 4);
		card[1].addCost("brick", 2);
		card[1].addCost("wood", 1);
		card[1].addFormit("blueScore", 5);

		card[2] = new Card("TownHall", "Blue", 3, 6);
		card[2].addCost("stone", 2);
		card[2].addCost("ore", 1);
		card[2].addCost("glass", 1);
		card[2].addFormit("blueScore", 6);

		card[3] = new Card("TownHall", "Blue", 3, 5);
		card[3].addCost("stone", 2);
		card[3].addCost("ore", 1);
		card[3].addCost("glass", 1);
		card[3].addFormit("blueScore", 6);

		card[4] = new Card("Pantheon", "Blue", 3, 6);
		card[4].addCost("brick", 2);
		card[4].addCost("ore", 1);
		card[4].addCost("glass", 1);
		card[4].addCost("paper", 1);
		card[4].addCost("cloth", 1);
		card[4].addFormit("blueScore", 7);

		card[5] = new Card("Palace", "Blue", 3, 7);
		card[5].addCost("stone", 1);
		card[5].addCost("wood", 1);
		card[5].addCost("brick", 1);
		card[5].addCost("ore", 1);
		card[5].addCost("glass", 1);
		card[5].addCost("paper", 1);
		card[5].addCost("cloth", 1);
		card[5].addFormit("blueScore", 8);

		card[6] = new Card("Palace", "Blue", 3, 3);
		card[6].addCost("stone", 1);
		card[6].addCost("wood", 1);
		card[6].addCost("brick", 1);
		card[6].addCost("ore", 1);
		card[6].addCost("glass", 1);
		card[6].addCost("paper", 1);
		card[6].addCost("cloth", 1);
		card[6].addFormit("blueScore", 8);

		card[7] = new Card("Pantheon", "Blue", 3, 3);
		card[7].addCost("brick", 2);
		card[7].addCost("ore", 1);
		card[7].addCost("glass", 1);
		card[7].addCost("paper", 1);
		card[7].addCost("cloth", 1);
		card[7].addFormit("blueScore", 7);

		card[8] = new Card("Gardens", "Blue", 3, 3);
		card[8].addCost("brick", 2);
		card[8].addCost("wood", 1);
		card[8].addFormit("blueScore", 5);

		card[9] = new Card("Senate", "Blue", 3, 3);
		card[9].addCost("wood", 2);
		card[9].addCost("stone", 1);
		card[9].addCost("ore", 1);
		card[9].addFormit("blueScore", 6);

		card[10] = new Card("TownHall", "Blue", 3, 3);
		card[10].addCost("stone", 2);
		card[10].addCost("ore", 1);
		card[10].addCost("glass", 1);
		card[10].addFormit("blueScore", 6);

		card[11] = new Card("Observatory", "Green", 3, 7);
		card[11].addCost("ore", 2);
		card[11].addCost("glass", 1);
		card[11].addCost("cloth", 1);
		card[11].addFormit("physics", 1);

		card[12] = new Card("Study", "Green", 3, 5);
		card[12].addCost("wood", 1);
		card[12].addCost("paper", 1);
		card[12].addCost("cloth", 1);
		card[12].addFormit("physics", 1);

		card[13] = new Card("Academy", "Green", 3, 7);
		card[13].addCost("stone", 3);
		card[13].addCost("glass", 1);
		card[13].addFormit("math", 1);

		card[14] = new Card("Lodge", "Green", 3, 6);
		card[14].addCost("brick", 2);
		card[14].addCost("paper", 1);
		card[14].addCost("cloth", 1);
		card[14].addFormit("math", 1);

		card[15] = new Card("Study", "Green", 3, 3);
		card[15].addCost("wood", 1);
		card[15].addCost("paper", 1);
		card[15].addCost("cloth", 1);
		card[15].addFormit("physics", 1);

		card[16] = new Card("University", "Green", 3, 4);
		card[16].addCost("wood", 2);
		card[16].addCost("paper", 1);
		card[16].addCost("glass", 1);
		card[16].addFormit("literature", 1);

		card[17] = new Card("University", "Green", 3, 3);
		card[17].addCost("wood", 2);
		card[17].addCost("paper", 1);
		card[17].addCost("glass", 1);
		card[17].addFormit("literature", 1);

		card[18] = new Card("Observatory", "Green", 3, 3);
		card[18].addCost("ore", 2);
		card[18].addCost("glass", 1);
		card[18].addCost("cloth", 1);
		card[18].addFormit("physics", 1);

		card[19] = new Card("Academy", "Green", 3, 3);
		card[19].addCost("stone", 3);
		card[19].addCost("glass", 1);
		card[19].addFormit("math", 1);

		card[20] = new Card("Lodge", "Green", 3, 3);
		card[20].addCost("brick", 2);
		card[20].addCost("paper", 1);
		card[20].addCost("cloth", 1);
		card[20].addFormit("math", 1);

		card[21] = new Card("Lighthouse", "Yellow", 3, 6);
		card[21].addCost("stone", 1);
		card[21].addCost("glass", 1);
		card[21].addFormit("YellowCoin", 1);
		card[21].addFormit("YellowScore", 1);

		card[22] = new Card("Lighthouse", "Yellow", 3, 3);
		card[22].addCost("stone", 1);
		card[22].addCost("glass", 1);
		card[22].addFormit("YellowCoin", 1);
		card[22].addFormit("YellowScore", 1);

		card[23] = new Card("Haven", "Yellow", 3, 3);
		card[23].addCost("wood", 1);
		card[23].addCost("ore", 1);
		card[23].addCost("cloth", 1);
		card[23].addFormit("BrownCoin", 1);
		card[23].addFormit("BrownScore", 1);

		card[24] = new Card("Haven", "Yellow", 3, 4);
		card[24].addCost("wood", 1);
		card[24].addCost("ore", 1);
		card[24].addCost("cloth", 1);
		card[24].addFormit("BrownCoin", 1);
		card[24].addFormit("BrownScore", 1);

		card[25] = new Card("ChamberOfCommerce", "Yellow", 3, 6);
		card[25].addCost("brick", 2);
		card[25].addCost("paper", 1);
		card[25].addFormit("GrayCoin", 1);
		card[25].addFormit("GrayScore", 1);

		card[26] = new Card("ChamberOfCommerce", "Yellow", 3, 4);
		card[26].addCost("brick", 2);
		card[26].addCost("paper", 1);
		card[26].addFormit("GrayCoin", 1);
		card[26].addFormit("GrayScore", 1);

		card[27] = new Card("Arena", "Yellow", 3, 7);
		card[27].addCost("stone", 2);
		card[27].addCost("ore", 1);
		card[27].addFormit("StageCoin", 1);
		card[27].addFormit("StageScore", 1);

		card[28] = new Card("Arena", "Yellow", 3, 3);
		card[28].addCost("stone", 2);
		card[28].addCost("ore", 1);
		card[28].addFormit("StageCoin", 1);
		card[28].addFormit("StageScore", 1);

		card[29] = new Card("Arena", "Yellow", 3, 5);
		card[29].addCost("stone", 2);
		card[29].addCost("ore", 1);
		card[29].addFormit("StageCoin", 1);
		card[29].addFormit("StageScore", 1);

		card[30] = new Card("SiegeWorkShop", "Red", 3, 5);
		card[30].addCost("brick", 3);
		card[30].addCost("wood", 1);
		card[30].addFormit("force", 3);

		card[31] = new Card("SiegeWorkShop", "Red", 3, 3);
		card[31].addCost("brick", 3);
		card[31].addCost("wood", 1);
		card[31].addFormit("force", 3);

		card[32] = new Card("Arsenal", "Red", 3, 7);
		card[32].addCost("wood", 2);
		card[32].addCost("ore", 1);
		card[32].addCost("cloth", 1);
		card[32].addFormit("force", 3);

		card[33] = new Card("Arsenal", "Red", 3, 3);
		card[33].addCost("wood", 2);
		card[33].addCost("ore", 1);
		card[33].addCost("cloth", 1);
		card[33].addFormit("force", 3);

		card[34] = new Card("Arsenal", "Red", 3, 4);
		card[34].addCost("wood", 2);
		card[34].addCost("ore", 1);
		card[34].addCost("cloth", 1);
		card[34].addFormit("force", 3);

		card[35] = new Card("Fortifications", "Red", 3, 7);
		card[35].addCost("ore", 3);
		card[35].addCost("stone", 1);
		card[35].addFormit("force", 3);

		card[36] = new Card("Fortifications", "Red", 3, 3);
		card[36].addCost("ore", 3);
		card[36].addCost("stone", 1);
		card[36].addFormit("force", 3);

		card[37] = new Card("Circus", "Red", 3, 5);
		card[37].addCost("stone", 3);
		card[37].addCost("ore", 1);
		card[37].addFormit("force", 3);

		card[38] = new Card("Circus", "Red", 3, 4);
		card[38].addCost("stone", 3);
		card[38].addCost("ore", 1);
		card[38].addFormit("force", 3);

		card[39] = new Card("Circus", "Red", 3, 6);
		card[39].addCost("stone", 3);
		card[39].addCost("ore", 1);
		card[39].addFormit("force", 3);

		card[40] = new Card("ShipownersGuild", "Purple", 3, 3);
		card[40].addCost("wood", 3);
		card[40].addCost("glass", 1);
		card[40].addCost("paper", 1);
		card[40].addFormit("GuildMixed", 1);

		card[41] = new Card("TradersGuild", "Purple", 3, 3);
		card[41].addCost("glass", 1);
		card[41].addCost("paper", 1);
		card[41].addCost("cloth", 1);
		card[41].addFormit("GuildYellow", 1);

		card[42] = new Card("CraftsmensGuild", "Purple", 3, 3);
		card[42].addCost("ore", 2);
		card[42].addCost("stone", 2);
		card[42].addFormit("GuildGray", 1);

		card[43] = new Card("StrategistsGuild", "Purple", 3, 3);
		card[43].addCost("ore", 2);
		card[43].addCost("stone", 1);
		card[43].addCost("cloth", 1);
		card[43].addFormit("GuildForce", 1);

		card[44] = new Card("BuildersGuild", "Purple", 3, 3);
		card[44].addCost("stone", 2);
		card[44].addCost("brick", 2);
		card[44].addCost("glass", 1);
		card[44].addFormit("GuildStage", 1);

		card[45] = new Card("SpiesGuild", "Purple", 3, 3);
		card[45].addCost("brick", 3);
		card[45].addCost("glass", 1);
		card[45].addFormit("GuildRed", 1);

		card[46] = new Card("PhilosophersGuild", "Purple", 3, 3);
		card[46].addCost("brick", 3);
		card[46].addCost("paper", 1);
		card[46].addCost("cloth", 1);
		card[46].addFormit("GuildGreen", 1);

		card[47] = new Card("MagistratesGuild", "Purple", 3, 3);
		card[47].addCost("wood", 3);
		card[47].addCost("stone", 1);
		card[47].addCost("cloth", 1);
		card[47].addFormit("GuildBlue", 1);

		card[48] = new Card("ScientistsGuild", "Purple", 3, 3);
		card[48].addCost("wood", 2);
		card[48].addCost("ore", 2);
		card[48].addCost("paper", 1);
		card[48].addFormit("literature_physics_math", 1);

		card[49] = new Card("WorkersGuild", "Purple", 3, 3);
		card[49].addCost("ore", 2);
		card[49].addCost("brick", 1);
		card[49].addCost("stone", 1);
		card[49].addCost("wood", 1);
	}

	public void TestCard() {
		changeCardAgeThree();
		int[] num = new int[8];
		int[] color = new int[8];
		for (int i = 0; i < 50; i++) {
			if (card[i] != null) {
				num[card[i].num]++;
				if (card[i].color == "Brown")
					color[1]++;
				else if (card[i].color == "Gray")
					color[2]++;
				else if (card[i].color == "Blue")
					color[3]++;
				else if (card[i].color == "Yellow")
					color[4]++;
				else if (card[i].color == "Red")
					color[5]++;
				else if (card[i].color == "Green")
					color[6]++;
				else if (card[i].color == "Purple")
					color[7]++;
			}
		}
		for (int i = 1; i < 8; i++) {
			System.out.print(i + ":" + num[i] + " " + color[i] + "\n");
		}
	}
}
