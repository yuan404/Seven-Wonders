package Kernel;

import javafx.scene.image.Image;

public class BoardInfo {
	/**
	 * 奇迹板
	 */
	Board[] board = new Board[16];
	/**
	 * 类内图
	 */
	Image[] im = new Image[15];

	public BoardInfo() {
		// TODO A面奇迹板
		board[0] = new Board("Babylon", 0);
		im[0] = new Image("resource/image/A.board1.png");
		board[0].iv.setImage(im[0]);
		for (int i = 0; i < 5; i++)
			board[0].cards[i] = new Card(board[0].getName() + i, "Black", 8, 4);
		board[0].cards[1].addCost("brick", 2);
		board[0].cards[2].addCost("wood", 3);
		board[0].cards[3].addCost("brick", 4);

		board[0].cards[0].addFormit("brick", 1);
		board[0].cards[1].addFormit("boardScore", 3);
		board[0].cards[2].addFormit("literature_physics_math", 1);
		board[0].cards[3].addFormit("boardScore", 7);

		board[1] = new Board("Rhodes", 0);
		im[1] = new Image("resource/image/A.board2.png");
		board[1].iv.setImage(im[1]);
		for (int i = 0; i < 5; i++)
			board[1].cards[i] = new Card(board[1].getName() + i, "Black", 8, 4);
		board[1].cards[1].addCost("wood", 2);
		board[1].cards[2].addCost("brick", 3);
		board[1].cards[3].addCost("ore", 4);

		board[1].cards[0].addFormit("ore", 1);
		board[1].cards[1].addFormit("boardScore", 3);
		board[1].cards[2].addFormit("force", 2);
		board[1].cards[3].addFormit("boardScore", 7);

		board[2] = new Board("Halicarnassus", 0);
		im[2] = new Image("resource/image/A.board3.png");
		board[2].iv.setImage(im[2]);
		for (int i = 0; i < 5; i++)
			board[2].cards[i] = new Card(board[2].getName() + i, "Black", 8, 4);
		board[2].cards[1].addCost("brick", 2);
		board[2].cards[2].addCost("ore", 3);
		board[2].cards[3].addCost("cloth", 2);

		board[2].cards[0].addFormit("cloth", 1);
		board[2].cards[1].addFormit("boardScore", 3);
		board[2].cards[2].addFormit("FreeDiscard", 1);
		board[2].cards[3].addFormit("boardScore", 7);

		board[3] = new Board("Giza", 0);
		im[3] = new Image("resource/image/A.board4.png");
		board[3].iv.setImage(im[3]);
		for (int i = 0; i < 5; i++)
			board[3].cards[i] = new Card(board[3].getName() + i, "Black", 8, 4);
		board[3].cards[1].addCost("stone", 2);
		board[3].cards[2].addCost("wood", 3);
		board[3].cards[3].addCost("stone", 4);

		board[3].cards[0].addFormit("stone", 1);
		board[3].cards[1].addFormit("boardScore", 3);
		board[3].cards[2].addFormit("boardScore", 5);
		board[3].cards[3].addFormit("boardScore", 7);

		board[4] = new Board("Alexandria", 0);
		im[4] = new Image("resource/image/A.board5.png");
		board[4].iv.setImage(im[4]);
		for (int i = 0; i < 5; i++)
			board[4].cards[i] = new Card(board[4].getName() + i, "Black", 8, 4);
		board[4].cards[1].addCost("stone", 2);
		board[4].cards[2].addCost("ore", 2);
		board[4].cards[3].addCost("glass", 2);

		board[4].cards[0].addFormit("glass", 1);
		board[4].cards[1].addFormit("boardScore", 3);
		board[4].cards[2].addFormit("wood_stone_ore_brick", 1);
		board[4].cards[3].addFormit("boardScore", 7);

		board[5] = new Board("Olympia", 0);
		im[5] = new Image("resource/image/A.board6.png");
		board[5].iv.setImage(im[5]);
		for (int i = 0; i < 5; i++)
			board[5].cards[i] = new Card(board[5].getName() + i, "Black", 8, 4);
		board[5].cards[1].addCost("wood", 2);
		board[5].cards[2].addCost("stone", 2);
		board[5].cards[3].addCost("ore", 2);

		board[5].cards[0].addFormit("wood", 1);
		board[5].cards[1].addFormit("boardScore", 3);
		board[5].cards[2].addFormit("FreeBuild", 1);
		board[5].cards[3].addFormit("boardScore", 7);

		board[6] = new Board("Ephesus", 0);
		im[6] = new Image("resource/image/A.board7.png");
		board[6].iv.setImage(im[6]);
		for (int i = 0; i < 5; i++)
			board[6].cards[i] = new Card(board[6].getName() + i, "Black", 8, 4);
		board[6].cards[1].addCost("stone", 2);
		board[6].cards[2].addCost("wood", 2);
		board[6].cards[3].addCost("paper", 2);

		board[6].cards[0].addFormit("paper", 1);
		board[6].cards[1].addFormit("boardScore", 3);
		board[6].cards[2].addFormit("coin", 9);
		board[6].cards[3].addFormit("boardScore", 7);
		// TODO B面奇迹板
		board[7] = new Board("Babylon", 1);
		im[7] = new Image("resource/image/B.board1.png");
		board[7].iv.setImage(im[7]);
		for (int i = 0; i < 5; i++)
			board[7].cards[i] = new Card(board[7].getName() + i, "Black", 8, 4);
		board[7].cards[1].addCost("cloth", 1);
		board[7].cards[1].addCost("brick", 1);
		board[7].cards[2].addCost("glass", 1);
		board[7].cards[2].addCost("wood", 2);
		board[7].cards[3].addCost("paper", 1);
		board[7].cards[3].addCost("brick", 3);

		board[7].cards[0].addFormit("brick", 1);
		board[7].cards[1].addFormit("boardScore", 3);
		board[7].cards[2].addFormit("LastCard", 1);
		board[7].cards[3].addFormit("literature_physics_math", 1);

		board[8] = new Board("Rhodes", 1);
		im[8] = new Image("resource/image/B.board2.png");
		board[8].iv.setImage(im[8]);
		for (int i = 0; i < 5; i++)
			board[8].cards[i] = new Card(board[8].getName() + i, "Black", 8, 4);
		board[8].cards[1].addCost("stone", 3);
		board[8].cards[2].addCost("ore", 4);
		board[8].max = 2;

		board[8].cards[0].addFormit("ore", 1);
		board[8].cards[1].addFormit("force", 1);
		board[8].cards[1].addFormit("boardScore", 3);
		board[8].cards[1].addFormit("coin", 3);
		board[8].cards[2].addFormit("force", 1);
		board[8].cards[2].addFormit("boardScore", 4);
		board[8].cards[2].addFormit("coin", 4);

		board[9] = new Board("Halicarnassus", 1);
		im[9] = new Image("resource/image/B.board3.png");
		board[9].iv.setImage(im[9]);
		for (int i = 0; i < 5; i++)
			board[9].cards[i] = new Card(board[9].getName() + i, "Black", 8, 4);
		board[9].cards[1].addCost("ore", 2);
		board[9].cards[2].addCost("brick", 3);
		board[9].cards[3].addCost("glass", 1);
		board[9].cards[3].addCost("paper", 1);
		board[9].cards[3].addCost("cloth", 1);

		board[9].cards[0].addFormit("cloth", 1);
		board[9].cards[1].addFormit("boardScore", 2);
		board[9].cards[1].addFormit("FreeDiscard", 1);
		board[9].cards[2].addFormit("boardScore", 1);
		board[9].cards[2].addFormit("FreeDiscard", 1);
		board[9].cards[3].addFormit("FreeDiscard", 1);

		board[10] = new Board("Giza", 1);
		im[10] = new Image("resource/image/B.board4.png");
		board[10].iv.setImage(im[10]);
		for (int i = 0; i < 5; i++)
			board[10].cards[i] = new Card(board[10].getName() + i, "Black", 8,
					4);
		board[10].cards[1].addCost("wood", 2);
		board[10].cards[2].addCost("stone", 3);
		board[10].cards[3].addCost("brick", 3);
		board[10].cards[4].addCost("paper", 1);
		board[10].cards[4].addCost("stone", 4);
		board[10].max = 4;

		board[10].cards[0].addFormit("stone", 1);
		board[10].cards[1].addFormit("boardScore", 3);
		board[10].cards[2].addFormit("boardScore", 5);
		board[10].cards[3].addFormit("boardScore", 5);
		board[10].cards[4].addFormit("boardScore", 7);

		board[11] = new Board("Alexandria", 1);
		im[11] = new Image("resource/image/B.board5.png");
		board[11].iv.setImage(im[11]);
		for (int i = 0; i < 5; i++)
			board[11].cards[i] = new Card(board[11].getName() + i, "Black", 8,
					4);
		board[11].cards[1].addCost("brick", 2);
		board[11].cards[2].addCost("wood", 2);
		board[11].cards[3].addCost("stone", 3);

		board[11].cards[0].addFormit("glass", 1);
		board[11].cards[1].addFormit("wood_stone_ore_brick", 1);
		board[11].cards[2].addFormit("glass_cloth_paper", 1);
		board[11].cards[3].addFormit("boardScore", 7);

		board[12] = new Board("Olympia", 1);
		im[12] = new Image("resource/image/B.board6.png");
		board[12].iv.setImage(im[12]);
		for (int i = 0; i < 5; i++)
			board[12].cards[i] = new Card(board[12].getName() + i, "Black", 8,
					4);
		board[12].cards[1].addCost("wood", 2);
		board[12].cards[2].addCost("stone", 2);
		board[12].cards[3].addCost("cloth", 1);
		board[12].cards[3].addCost("ore", 2);

		board[12].cards[0].addFormit("wood", 1);
		board[12].cards[1].addFormit("CheapBuy", 1);
		board[12].cards[2].addFormit("boardScore", 5);
		board[12].cards[3].addFormit("CopyGuild", 1);

		board[13] = new Board("Ephesus", 1);
		im[13] = new Image("resource/image/B.board7.png");
		board[13].iv.setImage(im[13]);
		for (int i = 0; i < 5; i++)
			board[13].cards[i] = new Card(board[13].getName() + i, "Black", 8,
					4);
		board[13].cards[1].addCost("stone", 2);
		board[13].cards[2].addCost("wood", 2);
		board[13].cards[3].addCost("paper", 1);
		board[13].cards[3].addCost("cloth", 1);
		board[13].cards[3].addCost("glass", 1);

		board[13].cards[0].addFormit("paper", 1);
		board[13].cards[1].addFormit("boardScore", 2);
		board[13].cards[1].addFormit("coin", 4);
		board[13].cards[2].addFormit("boardScore", 3);
		board[13].cards[2].addFormit("coin", 4);
		board[13].cards[3].addFormit("boardScore", 5);
		board[13].cards[3].addFormit("coin", 4);
	}

	/**
	 * 随机打乱
	 * 
	 * @param a
	 * @param b
	 */
	public void shuffle(int a, int b) {
		for (int i = a; i < b; i++) {
			int m = (int) Math.floor(Math.random() * (b - a)) + a;
			int n = (int) Math.floor(Math.random() * (b - a)) + a;
			board[15] = board[m];
			board[m] = board[n];
			board[n] = board[15];
		}
	}
}
