package org.tjuscs.sevenwonders.kernel;

import org.tjuscs.sevenwonders.Manager;
import org.tjuscs.sevenwonders.gui.CardGroup;
import org.tjuscs.sevenwonders.gui.MainBackGround;

/**
 * The Class FreeSciSymbolAction.
 */
@SuppressWarnings("serial")
public class FreeSciSymbolAction implements Action {

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
		board.setFreeSci(board.getFreeSci() + 1);
	}
	
	public void freeBuildLast(Board board){
		int num;
		if (Manager.getKernel().getAge() == 2)
			num = (board.getIndex() - (MainBackGround.turn - 1) + Manager
					.getKernel().getNumPlayers() * 3)
					% Manager.getKernel().getNumPlayers();
		else
			num = (board.getIndex() + (MainBackGround.turn - 1) + Manager
					.getKernel().getNumPlayers() * 3)
					% Manager.getKernel().getNumPlayers();
		Hand[] hands = Manager.getKernel().getHands();
		Card cd = hands[num].get(0);
		CardGroup.player.addCard(CardGroup.cardNameMap
				.get(cd.getName()),
				cd.getColor());
		board.addCard(cd);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "free science symbol at the end of the game ";
	}

	public int points(Board brd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
