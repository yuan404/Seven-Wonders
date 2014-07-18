package org.tjuscs.sevenwonders.kernel;

import java.util.*;

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
 * The Class FreeDiscardBuildAction.
 */
@SuppressWarnings("serial")
public class FreeDiscardBuildAction implements Action, DelayedAction {

	/** The board. */
	Board board;
	// 处理对话框
	static ImageView[] bk = new ImageView[100];
	static Label[] lb = new Label[100];
	static boolean isB = false;
	static ImageView isC;
	static String CName;
	static Hand[] hands;
	static int Cnum;

	static ImageView[] fr = new ImageView[100];
	private static Image frame1;
	private static Image frame2;

	private static Image pic1;
	private static Image pic2;
	private static Image pic3;
	private static Image ok;
	private static Image notok;
	static boolean isA = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tjuscs.sevenwonders.core.Action#activate(org.tjuscs.sevenwonders.
	 * core.Board)
	 */
	public void activate(Board brd) {
		board = brd;
		KernelManager.getManager().addEOTDelayedAction(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tjuscs.sevenwonders.core.DelayedAction#doDelayedAction()
	 */
	public void doDelayedAction() {
		
	}
	public void FreeBuild(final Board board) {
		// Card[] discards = KernelManager.getManager().getCardManager()
		// .getDiscardedCards();
		// CommandOption[] options = new CommandOption[discards.length];
		// int i = 0;
		// for (Card crd : discards) {
		// //options[i] = new CommandOption(crd, 0, null, null, null, true,
		// true);
		// i++;
		// }

		// action
		/**
		 * 触发从弃牌堆中选牌的效果
		 * 
		 * @author wanting
		 */
		// 获得弃牌链表
		LinkedList<Card> myCard = KernelManager.getCardManager()
				.getDiscardedCards2();
		LinkedList<Card> myCard2 = KernelManager.getCardManager()
				.getDiscardedCards2();
		Iterator<Card> it = myCard.iterator();
		// 计算链表长度
		int lenOfDiscard = 0;
		for (lenOfDiscard = 0; it.hasNext(); ++lenOfDiscard) {
			it.next();
		}
		if (lenOfDiscard != 0 && isA == false) {
			if (GamePlayer.getBoard().getName() == "Halicarnassus") {
				// 用作弹出弃牌框的对话
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

				isC = new ImageView();
				isC.setImage(notok);
				isC.setLayoutX(265 - 500);
				isC.setLayoutY(33);

				MainBackGround.playerBoard.getChildren().add(fr[0]);

				String[] s = new String[lenOfDiscard + 1];
				Iterator<Card> it2 = myCard.iterator();
				Set<Card> structures = new HashSet<Card>();
				int i = 0;
				while (it2.hasNext()) {
					Card tmpCard = it2.next();
					s[i] = tmpCard.getName();
					i++;
				}
				structures = board.getStructure();
				Boolean isSame = false;
				int i1 = 0;
				for (String str : s) {
					++item;
					++i1;
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
					lb[item].setFont(Font.font("Arial", 40));
					lb[item].setTextFill(Color.LIGHTBLUE);
					bk[item] = new ImageView();
					bk[item].setImage(pic1);
					
					fr[item] = new ImageView();
					fr[item].setImage(frame2);
					if(item <= 7){
						fr[item].setLayoutX(-500);
						fr[item].setLayoutY(69 * item);
						bk[item].setLayoutX(20 - 500);
						bk[item].setLayoutY(69 * item);
						lb[item].setLayoutX(30 - 500);
						lb[item].setLayoutY(69 * item + 10);
					}else{
						fr[item].setLayoutX(-500-380);
						fr[item].setLayoutY(69 * (item-7));
						bk[item].setLayoutX(20 - 500-380);
						bk[item].setLayoutY(69 * (item-7));
						lb[item].setLayoutX(30 - 500-380);
						lb[item].setLayoutY(69 * (item-7) + 10);
					}
					MainBackGround.playerBoard.getChildren().add(fr[item]);
					MainBackGround.playerBoard.getChildren().add(bk[item]);
					MainBackGround.playerBoard.getChildren().add(lb[item]);

					final int i2 = item;
					lb[item].addEventHandler(MouseEvent.MOUSE_CLICKED,
							new EventHandler<MouseEvent>() {
								public void handle(MouseEvent e) {
									for (int i = 0; i < 30; i++) {
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
					isC.addEventHandler(MouseEvent.MOUSE_CLICKED,
							new EventHandler<MouseEvent>() {
								public void handle(MouseEvent e) {
									Card cd = new Card();
									if (isB && !isA) {
										remove();

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
										CardGroup.player.addCard(
												CardGroup.cardNameMap
														.get(CName), cd
														.getColor());
										board.addCard(cd);
										MainBackGround.addCardGivenUp(-1);
										isB = false;
										isA = true;
									} else {
										isB = false;
										remove();
									}
									KernelManager.getCardManager()
											.removeFromDiscard(cd);
									remove();
									remove();
									remove();
									if (fr != null) {
										for (ImageView f : fr) {
											if (f != null)
												f.setOpacity(0);
										}
									}
									if (lb != null) {
										for (Label l : lb) {
											if (l != null)
												l.setOpacity(0);
										}
									}
									if (bk != null) {
										for (ImageView b : bk) {
											if (b != null)
												b.setOpacity(0);
										}
									}
									if (isC != null) {
										isC.setOpacity(0);
									}
								}
							});
				}
				MainBackGround.playerBoard.getChildren().add(isC);
			} else {
				if (lenOfDiscard <= 0){
					isA = true;
					return;
				}
				else {
					Random rm = new Random(lenOfDiscard);
					int i = rm.nextInt(lenOfDiscard - 1);
					Card c2 = myCard2.get(i);
					board.addCard(c2);
					KernelManager.getCardManager().removeFromDiscard(c2);
				}
			}
			MainBackGround.addCardGivenUp(-1);
		} else
			isA = true;
	}

	public static void setIsA(boolean is) {
		isA = is;
	}

	public static void remove() {
		MainBackGround.playerBoard.getChildren().removeAll(isC);
		MainBackGround.playerBoard.getChildren().remove(isC);
		MainBackGround.playerBoard.getChildren().removeAll(bk);
		MainBackGround.playerBoard.getChildren().removeAll(lb);
		MainBackGround.playerBoard.getChildren().remove(isB);
		MainBackGround.playerBoard.getChildren().remove(hands);
		MainBackGround.playerBoard.getChildren().removeAll(fr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "free build from the discard pile at the end of this turn";
	}

	public int points(Board brd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
