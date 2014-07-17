package org.tjuscs.sevenwonders.kernel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import org.tjuscs.sevenwonders.Manager;
import org.tjuscs.sevenwonders.gui.CardGroup;
import org.tjuscs.sevenwonders.gui.MainBackGround;
import org.tjuscs.sevenwonders.gui.ResManager;

/**
 * The Class CopyNeighborsGuildAction.
 */
@SuppressWarnings("serial")
public class CopyNeighborsGuildAction implements Action, DelayedAction {

	/** The board. */
	Board board;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tjuscs.sevenwonders.kernel.Action#activate(org.tjuscs.sevenwonders.
	 * kernel.Board)
	 */
	public void activate(Board brd) {
		board = brd;
		KernelManager.getManager().addEOGDelayedAction(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tjuscs.sevenwonders.kernel.DelayedAction#doDelayedAction()
	 */
	public void doDelayedAction() {

	}

	// 奇迹测试
	static ImageView[] bk = new ImageView[11];
	static Label[] lb = new Label[11];
	static boolean isB = false;
	static ImageView isC = new ImageView();
	static String CName;
	static Hand[] hands;
	static int Cnum;
	static ImageView[] fr = new ImageView[11];
	private static Image frame1;
	private static Image frame2;

	private static Image pic1;
	private static Image pic2;
	private static Image pic3;
	private static Image ok;
	private static Image notok;
	static boolean isA = false;

	public void freeAddCard(final Board board) {
		// 做奇迹板功能测试--免费建造每时代
		// -----

		frame1 = ResManager.getImage("frametop.png");
		frame2 = ResManager.getImage("framebottom.jpg");

		pic1 = ResManager.getImage("dist.jpg");
		pic2 = ResManager.getImage("dist2.jpg");
		pic3 = ResManager.getImage("dist3.jpg");
		ok = ResManager.getImage("ok.png");
		notok = ResManager.getImage("notok.png");
		
		isC.setImage(notok);
		isC.setLayoutX(265 - 500);
		isC.setLayoutY(33);
		
		fr[0] = new ImageView();
		fr[0].setImage(frame1);
		fr[0].setLayoutX(-500);
		fr[0].setLayoutY(0);
		
		MainBackGround.playerBoard.getChildren().add(fr[0]);
		String[] s = new String[11];
		int i = 0;
		Board neighbor = board.getLeftNeighbor();
		for (Card card : neighbor.structures) {
			if (card.getColor() == CardColor.PURPLE)
				s[i++] = card.getName();
		}

		neighbor = board.getRightNeighbor();
		for (Card card : neighbor.structures) {
			if (card.getColor() == CardColor.PURPLE)
				s[i++] = card.getName();
		}
		if (i > 0) {
			int item = 0;
			for (;i>=0;i--) {
				String str = s[i];
				++item;
				lb[item] = new Label();
				lb[item].setText(str);
				lb[item].setLayoutX(30 - 500);
				lb[item].setLayoutY(69 * item + 10);
				lb[item].setFont(Font.font("Arial", 40));
				lb[item].setTextFill(Color.LIGHTBLUE);
				bk[item] = new ImageView();
				bk[item].setImage(pic1);
				bk[item].setLayoutX(20 - 500);
				bk[item].setLayoutY(69 * item);
				fr[item] = new ImageView();
				fr[item].setImage(frame2);
				fr[item].setLayoutX(-500);
				fr[item].setLayoutY(69 * item);

				MainBackGround.playerBoard.getChildren().add(fr[item]);
				MainBackGround.playerBoard.getChildren().add(bk[item]);
				MainBackGround.playerBoard.getChildren().add(lb[item]);

				final int i2 = item;
				lb[item].addEventHandler(MouseEvent.MOUSE_CLICKED,
						new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								for (int i = 0; i < 8; i++) {
									if (bk[i] != null && i != i2)
										bk[i].setImage(pic1);
								}
								if (bk[i2].getImage() == pic2) {
									bk[i2].setImage(pic1);
									isB = false;
								} else {
									bk[i2].setImage(pic2);
									CName = lb[i2].getText();
									Cnum = i2;
									isB = true;
								}
								if (isB && !isA)
									isC.setImage(ok);
								else
									isC.setImage(notok);
							}
						});
		
			}
		}
		isC.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
						if (isB && !isA) {
							remove();
							Card cd = new Card();
							for (Card c : KernelManager.cardManager.guildDeck)
								if (c.getName().equals(CName)) {
									cd = c;
									break;
								}
							CardGroup.player.addCard(
									CardGroup.cardNameMap.get(CName),
									cd.getColor());
							board.addCard(cd);
							isB = false;
							isA = true;
						} else {
							isB = false;
							remove();
						}
					}
				});
		MainBackGround.playerBoard.getChildren().add(isC);
		// -----
	}

	public static void setIsA(boolean is) {
		isA = is;
	}

	private void remove() {
		MainBackGround.playerBoard.getChildren().removeAll(isC);
		MainBackGround.playerBoard.getChildren().removeAll(bk);
		MainBackGround.playerBoard.getChildren().removeAll(lb);
		MainBackGround.playerBoard.getChildren().remove(isB);
		MainBackGround.playerBoard.getChildren().remove(hands);
		MainBackGround.playerBoard.getChildren().removeAll(isC);
		MainBackGround.playerBoard.getChildren().removeAll(fr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "copies a neighbors guild at the end of the game";
	}

	public int points(Board brd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
