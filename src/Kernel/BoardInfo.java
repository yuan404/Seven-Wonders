package Kernel;

import javafx.scene.image.Image;

public class BoardInfo {

	public Board[] board = new Board[15];
	Image[] im = new Image[15];

	public BoardInfo() {
		board[0] = new Board("Babylon", 0);
		im[0] = new Image("resource/image/A.board1.png");
		board[0].iv.setImage(im[0]);
		board[0].addCost("brick", 2, 1);
		board[0].addCost("wood", 3, 2);
		board[0].addCost("brick", 4, 3);

		board[0].addFormit("brick", 1, 0);
		board[0].addFormit("score", 3, 1);
		board[0].addFormit("literature_physics_math", 1, 2);
		board[0].addFormit("score", 7, 3);

		board[1] = new Board("RHODES", 0);
		im[1] = new Image("resource/image/A.board2.png");
		board[1].iv.setImage(im[1]);
		board[1].addCost("wood", 2, 1);
		board[1].addCost("brick", 3, 2);
		board[1].addCost("ore", 4, 3);

		board[1].addFormit("ore", 1, 0);
		board[1].addFormit("score", 3, 1);
		board[1].addFormit("force", 2, 2);
		board[1].addFormit("score", 7, 3);

		board[2] = new Board("Halicarnassus", 0);
		im[2] = new Image("resource/image/A.board3.png");
		board[2].iv.setImage(im[2]);
		board[2].addCost("brick", 2, 1);
		board[2].addCost("ore", 3, 2);
		board[2].addCost("cloth", 2, 3);

		board[2].addFormit("cloth", 1, 0);
		board[2].addFormit("score", 3, 1);
		board[2].addFormit("FreeDiscard", 1, 2);
		board[2].addFormit("score", 7, 3);

		board[3] = new Board("Giza", 0);
		im[3] = new Image("resource/image/A.board4.png");
		board[3].iv.setImage(im[3]);
		board[3].addCost("stone", 2, 1);
		board[3].addCost("wood", 3, 2);
		board[3].addCost("stone", 4, 3);

		board[3].addFormit("stone", 1, 0);
		board[3].addFormit("score", 3, 1);
		board[3].addFormit("score", 5, 2);
		board[3].addFormit("score", 7, 3);

		board[4] = new Board("Alexandria", 0);
		im[4] = new Image("resource/image/A.board5.png");
		board[4].iv.setImage(im[4]);
		board[4].addCost("stone", 2, 1);
		board[4].addCost("ore", 2, 2);
		board[4].addCost("glass", 2, 3);

		board[4].addFormit("glass", 1, 0);
		board[4].addFormit("score", 3, 1);
		board[4].addFormit("wood_stone_brick_ore", 1, 2);
		board[4].addFormit("score", 7, 3);

		board[5] = new Board("Olympia", 0);
		im[5] = new Image("resource/image/A.board6.png");
		board[5].iv.setImage(im[5]);
		board[5].addCost("wood", 2, 1);
		board[5].addCost("stone", 2, 2);
		board[5].addCost("ore", 2, 3);

		board[5].addFormit("wood", 1, 0);
		board[5].addFormit("score", 3, 1);
		board[5].addFormit("FreeBuild", 1, 2);
		board[5].addFormit("score", 7, 3);

		board[6] = new Board("Ephesus", 0);
		im[6] = new Image("resource/image/A.board7.png");
		board[6].iv.setImage(im[6]);
		board[6].addCost("stone", 2, 1);
		board[6].addCost("wood", 2, 2);
		board[6].addCost("paper", 2, 3);

		board[6].addFormit("paper", 1, 0);
		board[6].addFormit("score", 3, 1);
		board[6].addFormit("coin", 9, 2);
		board[6].addFormit("score", 7, 3);

		board[7] = new Board("Babylon", 1);
		im[7] = new Image("resource/image/B.board1.png");
		board[7].iv.setImage(im[7]);
		board[7].addCost("cloth", 1, 1);
		board[7].addCost("brick", 1, 1);
		board[7].addCost("glass", 1, 2);
		board[7].addCost("wood", 2, 2);
		board[7].addCost("paper", 1, 3);
		board[7].addCost("brick", 3, 3);

		board[7].addFormit("brick", 1, 0);
		board[7].addFormit("score", 3, 1);
		board[7].addFormit("LastCard", 1, 2);
		board[7].addFormit("literature_physics_math", 1, 3);

		board[8] = new Board("Rhodes", 1);
		im[8] = new Image("resource/image/B.board2.png");
		board[8].iv.setImage(im[8]);
		board[8].addCost("stone", 3, 1);
		board[8].addCost("ore", 4, 2);

		board[8].addFormit("ore", 1, 0);
		board[8].addFormit("force", 1, 1);
		board[8].addFormit("score", 3, 1);
		board[8].addFormit("coin", 3, 1);
		board[8].addFormit("force", 1, 2);
		board[8].addFormit("score", 4, 2);
		board[8].addFormit("coin", 4, 2);

		board[9] = new Board("Halicarnassus", 1);
		im[9] = new Image("resource/image/B.board3.png");
		board[9].iv.setImage(im[9]);
		board[9].addCost("ore", 2, 1);
		board[9].addCost("brick", 3, 2);
		board[9].addCost("glass", 1, 3);
		board[9].addCost("paper", 1, 3);
		board[9].addCost("cloth", 1, 3);

		board[9].addFormit("cloth", 1, 0);
		board[9].addFormit("score", 2, 1);
		board[9].addFormit("FreeDiscard", 1, 1);
		board[9].addFormit("score", 1, 2);
		board[9].addFormit("FreeDiscard", 1, 2);
		board[9].addFormit("FreeDiscard", 1, 3);

		board[10] = new Board("Giza", 1);
		im[10] = new Image("resource/image/B.board4.png");
		board[10].iv.setImage(im[10]);
		board[10].addCost("wood", 2, 1);
		board[10].addCost("stone", 3, 2);
		board[10].addCost("brick", 3, 3);
		board[10].addCost("paper", 1, 4);
		board[10].addCost("stone", 4, 4);

		board[10].addFormit("stone", 1, 0);
		board[10].addFormit("score", 3, 1);
		board[10].addFormit("score", 5, 2);
		board[10].addFormit("score", 5, 3);
		board[10].addFormit("score", 7, 4);

		board[11] = new Board("Alexandria", 1);
		im[11] = new Image("resource/image/B.board5.png");
		board[11].iv.setImage(im[11]);
		board[11].addCost("brick", 2, 1);
		board[11].addCost("wood", 2, 2);
		board[11].addCost("stone", 3, 3);

		board[11].addFormit("glass", 1, 0);
		board[11].addFormit("wood_stone_brick_ore", 1, 1);
		board[11].addFormit("glass_cloth_paper", 1, 2);
		board[11].addFormit("score", 7, 3);

		board[12] = new Board("Olympia", 1);
		im[12] = new Image("resource/image/B.board6.png");
		board[12].iv.setImage(im[12]);
		board[12].addCost("wood", 2, 1);
		board[12].addCost("stone", 2, 2);
		board[12].addCost("cloth", 1, 3);
		board[12].addCost("ore", 2, 3);

		board[12].addFormit("wood", 1, 0);
		board[12].addFormit("CheapBuy", 1, 1);
		board[12].addFormit("score", 5, 2);
		board[12].addFormit("CopyGuild", 1, 3);

		board[13] = new Board("Ephesus", 1);
		im[13] = new Image("resource/image/B.board7.png");
		board[13].iv.setImage(im[13]);
		board[13].addCost("stone", 2, 1);
		board[13].addCost("wood", 2, 2);
		board[13].addCost("paper", 1, 3);
		board[13].addCost("cloth", 1, 3);
		board[13].addCost("glass", 1, 3);

		board[13].addFormit("paper", 1, 0);
		board[13].addFormit("score", 2, 1);
		board[13].addFormit("coin", 4, 1);
		board[13].addFormit("score", 3, 2);
		board[13].addFormit("coin", 4, 2);
		board[13].addFormit("score", 5, 3);
		board[13].addFormit("coin", 4, 3);
	}

}
