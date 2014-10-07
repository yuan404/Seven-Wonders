package Kernel;

import javafx.scene.image.Image;

/**
 * 卡牌信息类
 * 
 * @author Lane
 * 
 */
public class CardInfo {
	private Image[] im = new Image[149];
	private Card[] card = new Card[149];

	public CardInfo() {
		for (int i = 1; i <= 75; i++) {
			im[i] = new Image("resource/image/" + (i) + ".jpg");
		}
		// TODO 第一时代卡牌
		card[0] = new Card("Theater", "Blue", 1, 3);
		card[0].addFormit("blueScore", 2);
		card[0].addFree("Statue");
		card[0].iv.setImage(im[31]);

		card[1] = new Card("Altar", "Blue", 1, 5);
		card[1].addFormit("blueScore", 2);
		card[1].addFree("Temple");
		card[1].iv.setImage(im[30]);

		card[2] = new Card("Baths", "Blue", 1, 3);
		card[2].addCost("stone", 1);
		card[2].addFormit("blueScore", 3);
		card[2].addFree("Aqueduct");
		card[2].iv.setImage(im[29]);

		card[3] = new Card("Baths", "Blue", 1, 7);
		card[3].addCost("stone", 1);
		card[3].addFormit("blueScore", 3);
		card[3].addFree("Aqueduct");
		card[3].iv.setImage(im[29]);

		card[4] = new Card("Pawnshop", "Blue", 1, 4);
		card[4].addFormit("blueScore", 3);
		card[4].iv.setImage(im[28]);

		card[5] = new Card("Pawnshop", "Blue", 1, 7);
		card[5].addFormit("blueScore", 3);
		card[5].iv.setImage(im[28]);

		card[6] = new Card("ClayPool", "Brown", 1, 3);
		card[6].addFormit("brick", 1);
		card[6].iv.setImage(im[3]);

		card[7] = new Card("ClayPool", "Brown", 1, 5);
		card[7].addFormit("brick", 1);
		card[7].iv.setImage(im[3]);

		card[8] = new Card("ClayPit", "Brown", 1, 3);
		card[8].addCost("coin", 1);
		card[8].addFormit("ore_brick", 1);
		card[8].iv.setImage(im[7]);

		card[9] = new Card("OreVein", "Brown", 1, 3);
		card[9].addFormit("ore", 1);
		card[9].iv.setImage(im[4]);

		card[10] = new Card("Excavation", "Brown", 1, 4);
		card[10].addCost("coin", 1);
		card[10].addFormit("stone_brick", 1);
		card[10].iv.setImage(im[6]);

		card[11] = new Card("TimberYard", "Brown", 1, 3);
		card[11].addCost("coin", 1);
		card[11].addFormit("wood_stone", 1);
		card[11].iv.setImage(im[8]);

		card[12] = new Card("OreVein", "Brown", 1, 4);
		card[12].addFormit("ore", 1);
		card[12].iv.setImage(im[4]);

		card[13] = new Card("LumberYard", "Brown", 1, 3);
		card[13].addFormit("wood", 1);
		card[13].iv.setImage(im[1]);

		card[14] = new Card("LumberYard", "Brown", 1, 4);
		card[14].addFormit("wood", 1);
		card[14].iv.setImage(im[1]);

		card[15] = new Card("TreeFarm", "Brown", 1, 6);
		card[15].addCost("coin", 1);
		card[15].addFormit("wood_brick", 1);
		card[15].iv.setImage(im[5]);

		card[16] = new Card("Mine", "Brown", 1, 6);
		card[16].addCost("coin", 1);
		card[16].addFormit("stone_ore", 1);
		card[16].iv.setImage(im[10]);

		card[17] = new Card("StonePit", "Brown", 1, 5);
		card[17].addFormit("stone", 1);
		card[17].iv.setImage(im[2]);

		card[18] = new Card("Glassworks", "Gray", 1, 6);
		card[18].addFormit("glass", 1);
		card[18].iv.setImage(im[16]);

		card[19] = new Card("Press", "Gray", 1, 3);
		card[19].addFormit("paper", 1);
		card[19].iv.setImage(im[17]);

		card[20] = new Card("Press", "Gray", 1, 6);
		card[20].addFormit("paper", 1);
		card[20].iv.setImage(im[17]);

		card[21] = new Card("Loom", "Gray", 1, 3);
		card[21].addFormit("cloth", 1);
		card[21].iv.setImage(im[15]);

		card[22] = new Card("Glassworks", "Gray", 1, 3);
		card[22].addFormit("glass", 1);
		card[22].iv.setImage(im[16]);

		card[23] = new Card("Loom", "Gray", 1, 6);
		card[23].addFormit("cloth", 1);
		card[23].iv.setImage(im[15]);

		card[24] = new Card("Scriptorium", "Green", 1, 3);
		card[24].addCost("paper", 1);
		card[24].addFormit("literature", 1);
		card[24].addFree("Courthouse");
		card[24].addFree("Library");
		card[24].iv.setImage(im[66]);

		card[25] = new Card("WorkShop", "Green", 1, 7);
		card[25].addCost("glass", 1);
		card[25].addFormit("physics", 1);
		card[25].addFree("Laboratory");
		card[25].addFree("ArcheryRange");
		card[25].iv.setImage(im[65]);

		card[26] = new Card("Apothecary", "Green", 1, 3);
		card[26].addCost("cloth", 1);
		card[26].addFormit("math", 1);
		card[26].addFree("Stables");
		card[26].addFree("Dispensary");
		card[26].iv.setImage(im[64]);

		card[27] = new Card("Scriptorium", "Green", 1, 4);
		card[27].addCost("paper", 1);
		card[27].addFormit("literature", 1);
		card[27].addFree("Courthouse");
		card[27].addFree("Library");
		card[27].iv.setImage(im[66]);

		card[28] = new Card("Apothecary", "Green", 1, 5);
		card[28].addCost("cloth", 1);
		card[28].addFormit("math", 1);
		card[28].addFree("Stables");
		card[28].addFree("Dispensary");
		card[28].iv.setImage(im[64]);

		card[29] = new Card("WorkShop", "Green", 1, 3);
		card[29].addCost("glass", 1);
		card[29].addFormit("physics", 1);
		card[29].addFree("Laboratory");
		card[29].addFree("ArcheryRange");
		card[29].iv.setImage(im[65]);

		card[30] = new Card("Theater", "Blue", 1, 6);
		card[30].addFormit("blueScore", 2);
		card[30].addFree("Statue");
		card[30].iv.setImage(im[31]);

		card[31] = new Card("Altar", "Blue", 1, 3);
		card[31].addFormit("blueScore", 2);
		card[31].addFree("Temple");
		card[31].iv.setImage(im[30]);

		card[32] = new Card("GuardTower", "Red", 1, 4);
		card[32].addCost("brick", 1);
		card[32].addFormit("force", 1);
		card[32].iv.setImage(im[43]);

		card[33] = new Card("GuardTower", "Red", 1, 3);
		card[33].addCost("brick", 1);
		card[33].addFormit("force", 1);
		card[33].iv.setImage(im[43]);

		card[34] = new Card("Barracks", "Red", 1, 3);
		card[34].addCost("ore", 1);
		card[34].addFormit("force", 1);
		card[34].iv.setImage(im[42]);

		card[35] = new Card("Barracks", "Red", 1, 5);
		card[35].addCost("ore", 1);
		card[35].addFormit("force", 1);
		card[35].iv.setImage(im[42]);

		card[36] = new Card("Stockade", "Red", 1, 7);
		card[36].addCost("wood", 1);
		card[36].addFormit("force", 1);
		card[36].iv.setImage(im[41]);

		card[37] = new Card("Stockade", "Red", 1, 3);
		card[37].addCost("wood", 1);
		card[37].addFormit("force", 1);
		card[37].iv.setImage(im[41]);

		card[38] = new Card("ForestCave", "Brown", 1, 5);
		card[38].addCost("coin", 1);
		card[38].addFormit("wood_ore", 1);
		card[38].iv.setImage(im[9]);

		card[39] = new Card("StonePit", "Brown", 1, 3);
		card[39].addFormit("stone", 1);
		card[39].iv.setImage(im[2]);

		card[40] = new Card("EastTradingPost", "Yellow", 1, 3);
		card[40].addFormit("RightCheap", 1);
		card[40].addFree("Forum");
		card[40].iv.setImage(im[53]);

		card[41] = new Card("WestTradingPost", "Yellow", 1, 3);
		card[41].addFormit("LeftCheap", 1);
		card[41].addFree("Forum");
		card[41].iv.setImage(im[54]);

		card[42] = new Card("EastTradingPost", "Yellow", 1, 7);
		card[42].addFormit("RightCheap", 1);
		card[42].addFree("Forum");
		card[42].iv.setImage(im[53]);

		card[43] = new Card("WestTradingPost", "Yellow", 1, 7);
		card[43].addFormit("LeftCheap", 1);
		card[43].addFree("Forum");
		card[43].iv.setImage(im[54]);

		card[44] = new Card("Tavern", "Yellow", 1, 4);
		card[44].addFormit("coin", 5);
		card[44].iv.setImage(im[52]);

		card[45] = new Card("Tavern", "Yellow", 1, 5);
		card[45].addFormit("coin", 5);
		card[45].iv.setImage(im[52]);

		card[46] = new Card("Tavern", "Yellow", 1, 7);
		card[46].addFormit("coin", 5);
		card[46].iv.setImage(im[52]);

		card[47] = new Card("Marketplace", "Yellow", 1, 6);
		card[47].addFormit("GrayCheap", 1);
		card[47].addFree("Caravansery");
		card[47].iv.setImage(im[55]);

		card[48] = new Card("Marketplace", "Yellow", 1, 3);
		card[48].addFormit("GrayCheap", 1);
		card[48].addFree("Caravansery");
		card[48].iv.setImage(im[55]);
		// TODO 第二时代卡牌
		card[49] = new Card("Aqueduct", "Blue", 2, 7);
		card[49].addCost("stone", 3);
		card[49].addFormit("blueScore", 5);
		card[49].iv.setImage(im[32]);

		card[50] = new Card("Aqueduct", "Blue", 2, 3);
		card[50].addCost("stone", 3);
		card[50].addFormit("blueScore", 5);
		card[50].iv.setImage(im[32]);

		card[51] = new Card("Temple", "Blue", 2, 3);
		card[51].addCost("wood", 1);
		card[51].addCost("brick", 1);
		card[51].addCost("glass", 1);
		card[51].addFormit("blueScore", 3);
		card[51].addFree("Pantheon");
		card[51].iv.setImage(im[33]);

		card[52] = new Card("Statue", "Blue", 2, 3);
		card[52].addCost("ore", 2);
		card[52].addCost("wood", 1);
		card[52].addFormit("blueScore", 4);
		card[52].addFree("Gardens");
		card[52].iv.setImage(im[34]);

		card[53] = new Card("Temple", "Blue", 2, 6);
		card[53].addCost("wood", 1);
		card[53].addCost("brick", 1);
		card[53].addCost("glass", 1);
		card[53].addFormit("blueScore", 3);
		card[53].addFree("Pantheon");
		card[53].iv.setImage(im[33]);

		card[54] = new Card("Statue", "Blue", 2, 7);
		card[54].addCost("ore", 2);
		card[54].addCost("wood", 1);
		card[54].addFormit("blueScore", 4);
		card[54].addFree("Gardens");
		card[54].iv.setImage(im[34]);

		card[55] = new Card("Foundry", "Brown", 2, 4);
		card[55].addCost("coin", 1);
		card[55].addFormit("ore", 2);
		card[55].iv.setImage(im[14]);

		card[56] = new Card("Brickyard", "Brown", 2, 4);
		card[56].addCost("coin", 1);
		card[56].addFormit("brick", 2);
		card[56].iv.setImage(im[13]);

		card[57] = new Card("Foundry", "Brown", 2, 3);
		card[57].addCost("coin", 1);
		card[57].addFormit("ore", 2);
		card[57].iv.setImage(im[14]);

		card[58] = new Card("Sawmill", "Brown", 2, 4);
		card[58].addCost("coin", 1);
		card[58].addFormit("wood", 2);
		card[58].iv.setImage(im[11]);

		card[59] = new Card("Sawmill", "Brown", 2, 3);
		card[59].addCost("coin", 1);
		card[59].addFormit("wood", 2);
		card[59].iv.setImage(im[11]);

		card[60] = new Card("Quarry", "Brown", 2, 4);
		card[60].addCost("coin", 1);
		card[60].addFormit("stone", 2);
		card[60].iv.setImage(im[12]);

		card[61] = new Card("Press", "Gray", 2, 3);
		card[61].addFormit("paper", 1);
		card[61].iv.setImage(im[17]);

		card[62] = new Card("Loom", "Gray", 2, 5);
		card[62].addFormit("cloth", 1);
		card[62].iv.setImage(im[15]);

		card[63] = new Card("Loom", "Gray", 2, 3);
		card[63].addFormit("cloth", 1);
		card[63].iv.setImage(im[15]);

		card[64] = new Card("Glassworks", "Gray", 2, 5);
		card[64].addFormit("glass", 1);
		card[64].iv.setImage(im[16]);

		card[65] = new Card("Press", "Gray", 2, 5);
		card[65].addFormit("paper", 1);
		card[65].iv.setImage(im[17]);

		card[66] = new Card("Glassworks", "Gray", 2, 3);
		card[66].addFormit("glass", 1);
		card[66].iv.setImage(im[16]);

		card[67] = new Card("Library", "Green", 2, 6);
		card[67].addCost("stone", 2);
		card[67].addCost("cloth", 1);
		card[67].addFormit("literature", 1);
		card[67].addFree("Senate");
		card[67].addFree("University");
		card[67].iv.setImage(im[69]);

		card[68] = new Card("Dispensary", "Green", 2, 3);
		card[68].addCost("ore", 2);
		card[68].addCost("glass", 1);
		card[68].addFormit("math", 1);
		card[68].addFree("Lodge");
		card[68].addFree("Arena");
		card[68].iv.setImage(im[67]);

		card[69] = new Card("Laboratory", "Green", 2, 3);
		card[69].addCost("brick", 2);
		card[69].addCost("paper", 1);
		card[69].addFormit("physics", 1);
		card[69].addFree("Observatory");
		card[69].addFree("SiegeWorkShop");
		card[69].iv.setImage(im[68]);

		card[70] = new Card("School", "Green", 2, 7);
		card[70].addCost("wood", 1);
		card[70].addCost("paper", 1);
		card[70].addFormit("literature", 1);
		card[70].addFree("Academy");
		card[70].addFree("Study");
		card[70].iv.setImage(im[70]);

		card[71] = new Card("Library", "Green", 2, 3);
		card[71].addCost("stone", 2);
		card[71].addCost("cloth", 1);
		card[71].addFormit("literature", 1);
		card[71].addFree("Senate");
		card[71].addFree("University");
		card[71].iv.setImage(im[69]);

		card[72] = new Card("Dispensary", "Green", 2, 4);
		card[72].addCost("ore", 2);
		card[72].addCost("glass", 1);
		card[72].addFormit("math", 1);
		card[72].addFree("Lodge");
		card[72].addFree("Arena");
		card[72].iv.setImage(im[67]);

		card[73] = new Card("Brickyard", "Brown", 2, 3);
		card[73].addCost("coin", 1);
		card[73].addFormit("brick", 2);
		card[73].iv.setImage(im[13]);

		card[74] = new Card("School", "Green", 2, 3);
		card[74].addCost("wood", 1);
		card[74].addCost("paper", 1);
		card[74].addFormit("literature", 1);
		card[74].addFree("Academy");
		card[74].addFree("Study");
		card[74].iv.setImage(im[70]);

		card[75] = new Card("Courthouse", "Blue", 2, 5);
		card[75].addCost("brick", 2);
		card[75].addCost("cloth", 1);
		card[75].addFormit("blueScore", 4);
		card[75].iv.setImage(im[39]);

		card[76] = new Card("Laboratory", "Green", 2, 5);
		card[76].addCost("brick", 2);
		card[76].addCost("paper", 1);
		card[76].addFormit("physics", 1);
		card[76].addFree("Observatory");
		card[76].addFree("SiegeWorkShop");
		card[76].iv.setImage(im[68]);

		card[77] = new Card("Courthouse", "Blue", 2, 3);
		card[77].addCost("brick", 2);
		card[77].addCost("cloth", 1);
		card[77].addFormit("blueScore", 4);
		card[77].iv.setImage(im[39]);

		card[78] = new Card("Quarry", "Brown", 2, 3);
		card[78].addCost("coin", 1);
		card[78].addFormit("stone", 2);
		card[78].iv.setImage(im[12]);

		card[79] = new Card("Walls", "Red", 2, 7);
		card[79].addCost("stone", 3);
		card[79].addFormit("force", 2);
		card[79].addFree("Fortifications");
		card[79].iv.setImage(im[44]);

		card[80] = new Card("Walls", "Red", 2, 3);
		card[80].addCost("stone", 3);
		card[80].addFormit("force", 2);
		card[80].addFree("Fortifications");
		card[80].iv.setImage(im[44]);

		card[81] = new Card("TrainingGround", "Red", 2, 6);
		card[81].addCost("ore", 2);
		card[81].addCost("wood", 1);
		card[81].addFormit("force", 2);
		card[81].addFree("Circus");
		card[81].iv.setImage(im[45]);

		card[82] = new Card("TrainingGround", "Red", 2, 7);
		card[82].addCost("ore", 2);
		card[82].addCost("wood", 1);
		card[82].addFormit("force", 2);
		card[82].addFree("Circus");
		card[82].iv.setImage(im[45]);

		card[83] = new Card("ArcheryRange", "Red", 2, 6);
		card[83].addCost("wood", 2);
		card[83].addCost("ore", 1);
		card[83].addFormit("force", 2);
		card[83].iv.setImage(im[50]);

		card[84] = new Card("TrainingGround", "Red", 2, 4);
		card[84].addCost("ore", 2);
		card[84].addCost("wood", 1);
		card[84].addFormit("force", 2);
		card[84].addFree("Circus");
		card[84].iv.setImage(im[45]);

		card[85] = new Card("Stables", "Red", 2, 3);
		card[85].addCost("wood", 1);
		card[85].addCost("brick", 1);
		card[85].addCost("ore", 1);
		card[85].addFormit("force", 2);
		card[85].iv.setImage(im[49]);

		card[86] = new Card("Stables", "Red", 2, 5);
		card[86].addCost("wood", 1);
		card[86].addCost("brick", 1);
		card[86].addCost("ore", 1);
		card[86].addFormit("force", 2);
		card[86].iv.setImage(im[49]);

		card[87] = new Card("ArcheryRange", "Red", 2, 3);
		card[87].addCost("wood", 2);
		card[87].addCost("ore", 1);
		card[87].addFormit("force", 2);
		card[87].iv.setImage(im[50]);

		card[88] = new Card("Bazar", "Yellow", 2, 4);
		card[88].addFormit("LRMGrayCoin", 1);
		card[88].iv.setImage(im[59]);

		card[89] = new Card("Bazar", "Yellow", 2, 7);
		card[89].addFormit("LRMGrayCoin", 1);
		card[89].iv.setImage(im[59]);

		card[90] = new Card("Caravansery", "Yellow", 2, 6);
		card[90].addCost("wood", 2);
		card[90].addFormit("wood_stone_ore_brick", 1);
		card[90].addFree("Lighthouse");
		card[90].iv.setImage(im[57]);

		card[91] = new Card("Vineyard", "Yellow", 2, 3);
		card[91].addFormit("LRMBrownCoin", 1);
		card[91].iv.setImage(im[58]);

		card[92] = new Card("Vineyard", "Yellow", 2, 6);
		card[92].addFormit("LRMBrownCoin", 1);
		card[92].iv.setImage(im[58]);

		card[93] = new Card("Caravansery", "Yellow", 2, 5);
		card[93].addCost("wood", 2);
		card[93].addFormit("wood_stone_ore_brick", 1);
		card[93].addFree("Lighthouse");
		card[93].iv.setImage(im[57]);

		card[94] = new Card("Forum", "Yellow", 2, 3);
		card[94].addCost("brick", 2);
		card[94].addFormit("glass_cloth_paper", 1);
		card[94].addFree("Haven");
		card[94].iv.setImage(im[56]);

		card[95] = new Card("Forum", "Yellow", 2, 7);
		card[95].addCost("brick", 2);
		card[95].addFormit("glass_cloth_paper", 1);
		card[95].addFree("Haven");
		card[95].iv.setImage(im[56]);

		card[96] = new Card("Forum", "Yellow", 2, 6);
		card[96].addCost("brick", 2);
		card[96].addFormit("glass_cloth_paper", 1);
		card[96].addFree("Haven");
		card[96].iv.setImage(im[56]);

		card[97] = new Card("Caravansery", "Yellow", 2, 3);
		card[97].addCost("wood", 2);
		card[97].addFormit("wood_stone_ore_brick", 1);
		card[97].addFree("Lighthouse");
		card[97].iv.setImage(im[57]);
		// TODO 第三时代卡牌
		card[98] = new Card("Senate", "Blue", 3, 5);
		card[98].addCost("wood", 2);
		card[98].addCost("stone", 1);
		card[98].addCost("ore", 1);
		card[98].addFormit("blueScore", 6);
		card[98].iv.setImage(im[40]);

		card[98 + 1] = new Card("Gardens", "Blue", 3, 4);
		card[98 + 1].addCost("brick", 2);
		card[98 + 1].addCost("wood", 1);
		card[98 + 1].addFormit("blueScore", 5);
		card[98 + 1].iv.setImage(im[36]);

		card[98 + 2] = new Card("TownHall", "Blue", 3, 6);
		card[98 + 2].addCost("stone", 2);
		card[98 + 2].addCost("ore", 1);
		card[98 + 2].addCost("glass", 1);
		card[98 + 2].addFormit("blueScore", 6);
		card[98 + 2].iv.setImage(im[37]);

		card[98 + 3] = new Card("TownHall", "Blue", 3, 5);
		card[98 + 3].addCost("stone", 2);
		card[98 + 3].addCost("ore", 1);
		card[98 + 3].addCost("glass", 1);
		card[98 + 3].addFormit("blueScore", 6);
		card[98 + 3].iv.setImage(im[37]);

		card[98 + 4] = new Card("Pantheon", "Blue", 3, 6);
		card[98 + 4].addCost("brick", 2);
		card[98 + 4].addCost("ore", 1);
		card[98 + 4].addCost("glass", 1);
		card[98 + 4].addCost("paper", 1);
		card[98 + 4].addCost("cloth", 1);
		card[98 + 4].addFormit("blueScore", 7);
		card[98 + 4].iv.setImage(im[35]);

		card[98 + 5] = new Card("Palace", "Blue", 3, 7);
		card[98 + 5].addCost("stone", 1);
		card[98 + 5].addCost("wood", 1);
		card[98 + 5].addCost("brick", 1);
		card[98 + 5].addCost("ore", 1);
		card[98 + 5].addCost("glass", 1);
		card[98 + 5].addCost("paper", 1);
		card[98 + 5].addCost("cloth", 1);
		card[98 + 5].addFormit("blueScore", 8);
		card[98 + 5].iv.setImage(im[38]);

		card[98 + 6] = new Card("Palace", "Blue", 3, 3);
		card[98 + 6].addCost("stone", 1);
		card[98 + 6].addCost("wood", 1);
		card[98 + 6].addCost("brick", 1);
		card[98 + 6].addCost("ore", 1);
		card[98 + 6].addCost("glass", 1);
		card[98 + 6].addCost("paper", 1);
		card[98 + 6].addCost("cloth", 1);
		card[98 + 6].addFormit("blueScore", 8);
		card[98 + 6].iv.setImage(im[38]);

		card[98 + 7] = new Card("Pantheon", "Blue", 3, 3);
		card[98 + 7].addCost("brick", 2);
		card[98 + 7].addCost("ore", 1);
		card[98 + 7].addCost("glass", 1);
		card[98 + 7].addCost("paper", 1);
		card[98 + 7].addCost("cloth", 1);
		card[98 + 7].addFormit("blueScore", 7);
		card[98 + 7].iv.setImage(im[35]);

		card[98 + 8] = new Card("Gardens", "Blue", 3, 3);
		card[98 + 8].addCost("brick", 2);
		card[98 + 8].addCost("wood", 1);
		card[98 + 8].addFormit("blueScore", 5);
		card[98 + 8].iv.setImage(im[36]);

		card[98 + 9] = new Card("Senate", "Blue", 3, 3);
		card[98 + 9].addCost("wood", 2);
		card[98 + 9].addCost("stone", 1);
		card[98 + 9].addCost("ore", 1);
		card[98 + 9].addFormit("blueScore", 6);
		card[98 + 9].iv.setImage(im[40]);

		card[98 + 10] = new Card("TownHall", "Blue", 3, 3);
		card[98 + 10].addCost("stone", 2);
		card[98 + 10].addCost("ore", 1);
		card[98 + 10].addCost("glass", 1);
		card[98 + 10].addFormit("blueScore", 6);
		card[98 + 10].iv.setImage(im[37]);

		card[98 + 11] = new Card("Observatory", "Green", 3, 7);
		card[98 + 11].addCost("ore", 2);
		card[98 + 11].addCost("glass", 1);
		card[98 + 11].addCost("cloth", 1);
		card[98 + 11].addFormit("physics", 1);
		card[98 + 11].iv.setImage(im[72]);

		card[98 + 12] = new Card("Study", "Green", 3, 5);
		card[98 + 12].addCost("wood", 1);
		card[98 + 12].addCost("paper", 1);
		card[98 + 12].addCost("cloth", 1);
		card[98 + 12].addFormit("physics", 1);
		card[98 + 12].iv.setImage(im[75]);

		card[98 + 13] = new Card("Academy", "Green", 3, 7);
		card[98 + 13].addCost("stone", 3);
		card[98 + 13].addCost("glass", 1);
		card[98 + 13].addFormit("math", 1);
		card[98 + 13].iv.setImage(im[74]);

		card[98 + 14] = new Card("Lodge", "Green", 3, 6);
		card[98 + 14].addCost("brick", 2);
		card[98 + 14].addCost("paper", 1);
		card[98 + 14].addCost("cloth", 1);
		card[98 + 14].addFormit("math", 1);
		card[98 + 14].iv.setImage(im[71]);

		card[98 + 15] = new Card("Study", "Green", 3, 3);
		card[98 + 15].addCost("wood", 1);
		card[98 + 15].addCost("paper", 1);
		card[98 + 15].addCost("cloth", 1);
		card[98 + 15].addFormit("physics", 1);
		card[98 + 15].iv.setImage(im[75]);

		card[98 + 16] = new Card("University", "Green", 3, 4);
		card[98 + 16].addCost("wood", 2);
		card[98 + 16].addCost("paper", 1);
		card[98 + 16].addCost("glass", 1);
		card[98 + 16].addFormit("literature", 1);
		card[98 + 16].iv.setImage(im[73]);

		card[98 + 17] = new Card("University", "Green", 3, 3);
		card[98 + 17].addCost("wood", 2);
		card[98 + 17].addCost("paper", 1);
		card[98 + 17].addCost("glass", 1);
		card[98 + 17].addFormit("literature", 1);
		card[98 + 17].iv.setImage(im[73]);

		card[98 + 18] = new Card("Observatory", "Green", 3, 3);
		card[98 + 18].addCost("ore", 2);
		card[98 + 18].addCost("glass", 1);
		card[98 + 18].addCost("cloth", 1);
		card[98 + 18].addFormit("physics", 1);
		card[98 + 18].iv.setImage(im[72]);

		card[98 + 19] = new Card("Academy", "Green", 3, 3);
		card[98 + 19].addCost("stone", 3);
		card[98 + 19].addCost("glass", 1);
		card[98 + 19].addFormit("math", 1);
		card[98 + 19].iv.setImage(im[74]);

		card[98 + 20] = new Card("Lodge", "Green", 3, 3);
		card[98 + 20].addCost("brick", 2);
		card[98 + 20].addCost("paper", 1);
		card[98 + 20].addCost("cloth", 1);
		card[98 + 20].addFormit("math", 1);
		card[98 + 20].iv.setImage(im[71]);

		card[98 + 21] = new Card("Lighthouse", "Yellow", 3, 6);
		card[98 + 21].addCost("stone", 1);
		card[98 + 21].addCost("glass", 1);
		card[98 + 21].addFormit("YellowCoin", 1);
		card[98 + 21].addFormit("YellowScore", 1);
		card[98 + 21].iv.setImage(im[61]);

		card[98 + 22] = new Card("Lighthouse", "Yellow", 3, 3);
		card[98 + 22].addCost("stone", 1);
		card[98 + 22].addCost("glass", 1);
		card[98 + 22].addFormit("YellowCoin", 1);
		card[98 + 22].addFormit("YellowScore", 1);
		card[98 + 22].iv.setImage(im[61]);

		card[98 + 23] = new Card("Haven", "Yellow", 3, 3);
		card[98 + 23].addCost("wood", 1);
		card[98 + 23].addCost("ore", 1);
		card[98 + 23].addCost("cloth", 1);
		card[98 + 23].addFormit("BrownCoin", 1);
		card[98 + 23].addFormit("BrownScore", 1);
		card[98 + 23].iv.setImage(im[60]);

		card[98 + 24] = new Card("Haven", "Yellow", 3, 4);
		card[98 + 24].addCost("wood", 1);
		card[98 + 24].addCost("ore", 1);
		card[98 + 24].addCost("cloth", 1);
		card[98 + 24].addFormit("BrownCoin", 1);
		card[98 + 24].addFormit("BrownScore", 1);
		card[98 + 24].iv.setImage(im[60]);

		card[98 + 25] = new Card("ChamberOfCommerce", "Yellow", 3, 6);
		card[98 + 25].addCost("brick", 2);
		card[98 + 25].addCost("paper", 1);
		card[98 + 25].addFormit("GrayCoin", 1);
		card[98 + 25].addFormit("GrayScore", 1);
		card[98 + 25].iv.setImage(im[62]);

		card[98 + 26] = new Card("ChamberOfCommerce", "Yellow", 3, 4);
		card[98 + 26].addCost("brick", 2);
		card[98 + 26].addCost("paper", 1);
		card[98 + 26].addFormit("GrayCoin", 1);
		card[98 + 26].addFormit("GrayScore", 1);
		card[98 + 26].iv.setImage(im[62]);

		card[98 + 27] = new Card("Arena", "Yellow", 3, 7);
		card[98 + 27].addCost("stone", 2);
		card[98 + 27].addCost("ore", 1);
		card[98 + 27].addFormit("StageCoin", 1);
		card[98 + 27].addFormit("StageScore", 1);
		card[98 + 27].iv.setImage(im[63]);

		card[98 + 28] = new Card("Arena", "Yellow", 3, 3);
		card[98 + 28].addCost("stone", 2);
		card[98 + 28].addCost("ore", 1);
		card[98 + 28].addFormit("StageCoin", 1);
		card[98 + 28].addFormit("StageScore", 1);
		card[98 + 28].iv.setImage(im[63]);

		card[98 + 29] = new Card("Arena", "Yellow", 3, 5);
		card[98 + 29].addCost("stone", 2);
		card[98 + 29].addCost("ore", 1);
		card[98 + 29].addFormit("StageCoin", 1);
		card[98 + 29].addFormit("StageScore", 1);
		card[98 + 29].iv.setImage(im[63]);

		card[98 + 30] = new Card("SiegeWorkShop", "Red", 3, 5);
		card[98 + 30].addCost("brick", 3);
		card[98 + 30].addCost("wood", 1);
		card[98 + 30].addFormit("force", 3);
		card[98 + 30].iv.setImage(im[51]);

		card[98 + 31] = new Card("SiegeWorkShop", "Red", 3, 3);
		card[98 + 31].addCost("brick", 3);
		card[98 + 31].addCost("wood", 1);
		card[98 + 31].addFormit("force", 3);
		card[98 + 31].iv.setImage(im[51]);

		card[98 + 32] = new Card("Arsenal", "Red", 3, 7);
		card[98 + 32].addCost("wood", 2);
		card[98 + 32].addCost("ore", 1);
		card[98 + 32].addCost("cloth", 1);
		card[98 + 32].addFormit("force", 3);
		card[98 + 32].iv.setImage(im[48]);

		card[98 + 33] = new Card("Arsenal", "Red", 3, 3);
		card[98 + 33].addCost("wood", 2);
		card[98 + 33].addCost("ore", 1);
		card[98 + 33].addCost("cloth", 1);
		card[98 + 33].addFormit("force", 3);
		card[98 + 33].iv.setImage(im[48]);

		card[98 + 34] = new Card("Arsenal", "Red", 3, 4);
		card[98 + 34].addCost("wood", 2);
		card[98 + 34].addCost("ore", 1);
		card[98 + 34].addCost("cloth", 1);
		card[98 + 34].addFormit("force", 3);
		card[98 + 34].iv.setImage(im[48]);

		card[98 + 35] = new Card("Fortifications", "Red", 3, 7);
		card[98 + 35].addCost("ore", 3);
		card[98 + 35].addCost("stone", 1);
		card[98 + 35].addFormit("force", 3);
		card[98 + 35].iv.setImage(im[46]);

		card[98 + 36] = new Card("Fortifications", "Red", 3, 3);
		card[98 + 36].addCost("ore", 3);
		card[98 + 36].addCost("stone", 1);
		card[98 + 36].addFormit("force", 3);
		card[98 + 36].iv.setImage(im[46]);

		card[98 + 37] = new Card("Circus", "Red", 3, 5);
		card[98 + 37].addCost("stone", 3);
		card[98 + 37].addCost("ore", 1);
		card[98 + 37].addFormit("force", 3);
		card[98 + 37].iv.setImage(im[47]);

		card[98 + 38] = new Card("Circus", "Red", 3, 4);
		card[98 + 38].addCost("stone", 3);
		card[98 + 38].addCost("ore", 1);
		card[98 + 38].addFormit("force", 3);
		card[98 + 38].iv.setImage(im[47]);

		card[98 + 39] = new Card("Circus", "Red", 3, 6);
		card[98 + 39].addCost("stone", 3);
		card[98 + 39].addCost("ore", 1);
		card[98 + 39].addFormit("force", 3);
		card[98 + 39].iv.setImage(im[47]);

		card[98 + 40] = new Card("ShipownersGuild", "Purple", 3, 3);
		card[98 + 40].addCost("wood", 3);
		card[98 + 40].addCost("glass", 1);
		card[98 + 40].addCost("paper", 1);
		card[98 + 40].addFormit("GuildMixed", 1);
		card[98 + 40].iv.setImage(im[24]);

		card[98 + 41] = new Card("TradersGuild", "Purple", 3, 3);
		card[98 + 41].addCost("glass", 1);
		card[98 + 41].addCost("paper", 1);
		card[98 + 41].addCost("cloth", 1);
		card[98 + 41].addFormit("GuildYellow", 1);
		card[98 + 41].iv.setImage(im[20]);

		card[98 + 42] = new Card("CraftsmensGuild", "Purple", 3, 3);
		card[98 + 42].addCost("ore", 2);
		card[98 + 42].addCost("stone", 2);
		card[98 + 42].addFormit("GuildGray", 1);
		card[98 + 42].iv.setImage(im[19]);

		card[98 + 43] = new Card("StrategistsGuild", "Purple", 3, 3);
		card[98 + 43].addCost("ore", 2);
		card[98 + 43].addCost("stone", 1);
		card[98 + 43].addCost("cloth", 1);
		card[98 + 43].addFormit("GuildForce", 1);
		card[98 + 43].iv.setImage(im[23]);

		card[98 + 44] = new Card("BuildersGuild", "Purple", 3, 3);
		card[98 + 44].addCost("stone", 2);
		card[98 + 44].addCost("brick", 2);
		card[98 + 44].addCost("glass", 1);
		card[98 + 44].addFormit("GuildStage", 1);
		card[98 + 44].iv.setImage(im[27]);

		card[98 + 45] = new Card("SpiesGuild", "Purple", 3, 3);
		card[98 + 45].addCost("brick", 3);
		card[98 + 45].addCost("glass", 1);
		card[98 + 45].addFormit("GuildRed", 1);
		card[98 + 45].iv.setImage(im[22]);

		card[98 + 46] = new Card("PhilosophersGuild", "Purple", 3, 3);
		card[98 + 46].addCost("brick", 3);
		card[98 + 46].addCost("paper", 1);
		card[98 + 46].addCost("cloth", 1);
		card[98 + 46].addFormit("GuildGreen", 1);
		card[98 + 46].iv.setImage(im[21]);

		card[98 + 47] = new Card("MagistratesGuild", "Purple", 3, 3);
		card[98 + 47].addCost("wood", 3);
		card[98 + 47].addCost("stone", 1);
		card[98 + 47].addCost("cloth", 1);
		card[98 + 47].addFormit("GuildBlue", 1);
		card[98 + 47].iv.setImage(im[26]);

		card[98 + 48] = new Card("ScientistsGuild", "Purple", 3, 3);
		card[98 + 48].addCost("wood", 2);
		card[98 + 48].addCost("ore", 2);
		card[98 + 48].addCost("paper", 1);
		card[98 + 48].addFormit("literature_physics_math", 1);
		card[98 + 48].iv.setImage(im[25]);

		card[98 + 49] = new Card("WorkersGuild", "Purple", 3, 3);
		card[98 + 49].addCost("ore", 2);
		card[98 + 49].addCost("brick", 1);
		card[98 + 49].addCost("stone", 1);
		card[98 + 49].addCost("wood", 1);
		card[98 + 49].addFormit("GuildBrown", 1);
		card[98 + 49].iv.setImage(im[18]);
	}

	/**
	 * 由名称得到卡牌
	 * 
	 * @param name
	 * @return
	 */
	public Card getCardByName(String name) {
		for (int i = 0; i < 147; i++) {
			if (card[i].getName() == name) {
				return card[i];
			}
		}
		return null;
	}

	/**
	 * 生成时代牌组
	 * 
	 * @param age
	 * @param num
	 *            玩家人数
	 * @return
	 */
	public String[] getCardofHand(int age, int num) {
		int n = num * 7;
		String[] ageCard = new String[n + 1];
		if (age < 3) {
			if (age == 1)
				shuffle(0, 49);
			else
				shuffle(49, 49 * 2);
			int i = -1;
			for (int j = 0; j < n; j++) {
				i++;
				for (; i < 138; i++) {
					if (card[i].getNum() <= num && card[i].getAge() == age) {
						ageCard[j] = card[i].getName();
						break;
					}
				}
			}
		} else {
			shuffle(49 * 2, 138);
			shuffle(138, 49 * 3);
			int i = -1;
			for (int j = 0; j < n - num - 2; j++) {
				i++;
				for (; i < 138; i++) {
					if (card[i].getNum() <= num && card[i].getAge() == age) {
						ageCard[j] = card[i].getName();
						break;
					}
				}
			}
			i = 138;
			for (int j = n - num - 2; j < n; j++) {
				ageCard[j] = card[i++].getName();
			}
			for (int q = 0; q < n; q++) {
				int m = (int) Math.floor(Math.random() * (n));
				int p = (int) Math.floor(Math.random() * (n));
				ageCard[n] = ageCard[m];
				ageCard[m] = ageCard[p];
				ageCard[p] = ageCard[n];
			}
		}
		return ageCard;
	}

	/**
	 * 随机打乱
	 * 
	 * @param a
	 * @param b
	 */
	private void shuffle(int a, int b) {
		for (int i = a; i < b; i++) {
			int m = (int) Math.floor(Math.random() * (b - a)) + a;
			int n = (int) Math.floor(Math.random() * (b - a)) + a;
			card[148] = card[m];
			card[m] = card[n];
			card[n] = card[148];
		}
	}
}
