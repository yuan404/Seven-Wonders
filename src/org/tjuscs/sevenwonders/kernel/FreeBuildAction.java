package org.tjuscs.sevenwonders.kernel;

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
import org.tjuscs.sevenwonders.kernel.RecManager.TurnInfo;

@SuppressWarnings("serial")
public class FreeBuildAction implements Action {

	/** The board. */
	Board board;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tjuscs.sevenwonders.core.Action#activate(org.tjuscs.sevenwonders.
	 * core.Board)
	 */
	public void activate(Board brd) {
		board = brd;
		board.canfreebuild = true;
	}

	public int points(Board brd) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// 奇迹测试
		static ImageView[] bk = new ImageView[8];
		static Label[] lb = new Label[8];
		static boolean isB = false;
		static ImageView isC = new ImageView();
		static String CName;
		static Hand[] hands;
		static int Cnum;
		
		static ImageView[] fr = new ImageView[8];
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

			hands = Manager.getKernel().getHands();

			int item = 0;

			fr[0] = new ImageView();
			fr[0].setImage(frame1);
			fr[0].setLayoutX(-500);
			fr[0].setLayoutY(0);

			isC.setImage(notok);
			isC.setLayoutX(265-500);
			isC.setLayoutY(33);

			MainBackGround.playerBoard.getChildren().add(fr[0]);

			int num;
			if (Manager.getKernel().getAge() == 2)
				num = (board.getIndex() - (MainBackGround.turn - 1) + Manager
						.getKernel().getNumPlayers() * 3)
						% Manager.getKernel().getNumPlayers();
			else
				num = (board.getIndex() + (MainBackGround.turn - 1) + Manager
						.getKernel().getNumPlayers() * 3)
						% Manager.getKernel().getNumPlayers();
			String[] s = hands[num].getNames();
			Set<Card> structures = new HashSet<Card>();
			structures = board.getStructure();
			Boolean isSame = false;
			int i1 = 0;
			for (String str : s) {
				++item;++i1;
				for (Card crd : structures) {
					if (crd.getName().equals(str)) {
						isSame = true;
						break;
					}
				}
				if (isSame) {
					--item;
					isSame = false;
					continue;
				}
				lb[item] = new Label();
				lb[item].setText(str);
				lb[item].setLayoutX(30-500);
				lb[item].setLayoutY(69 * item + 10);
				lb[item].setFont(Font.font("Arial", 40));
				lb[item].setTextFill(Color.LIGHTBLUE);
				bk[item] = new ImageView();
				bk[item].setImage(pic1);
				bk[item].setLayoutX(20-500);
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
				final int num2 = num;
				final int i3 = i1;
				isC.addEventHandler(MouseEvent.MOUSE_CLICKED,
						new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								if (isB && !isA ) {
									remove();
									Card cd = new Card();
									for (Card c : KernelManager.cardManager.deck)
										if (c.getName().equals(CName)) {
											cd = c;
											break;
										}
									for (Card c : KernelManager.cardManager.guildDeck)
										if (c.getName().equals(CName)) {
											cd = c;
											break;
										}
									CardGroup.player.addCard(CardGroup.cardNameMap
											.get(CName),
											cd.getColor());
									board.addCard(cd);
									hands[num2].remove(CName);
									MainBackGround.nextTurn();
									isB = false;
									isA = true;
								} else{
									isB = false;
									remove();
								}
							}
						});
			}
			MainBackGround.playerBoard.getChildren().add(isC);
			// -----
		}
		public static void setIsA(boolean is){
			isA = is;
		}
		public void remove() {
			MainBackGround.playerBoard.getChildren().removeAll(isC);
			MainBackGround.playerBoard.getChildren().removeAll(bk);
			MainBackGround.playerBoard.getChildren().removeAll(lb);
			MainBackGround.playerBoard.getChildren().remove(isB);
			MainBackGround.playerBoard.getChildren().remove(hands);
			MainBackGround.playerBoard.getChildren().removeAll(isC);
			MainBackGround.playerBoard.getChildren().removeAll(fr);
		}

}
