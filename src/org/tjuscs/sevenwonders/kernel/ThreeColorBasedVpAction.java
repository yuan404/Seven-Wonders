package org.tjuscs.sevenwonders.kernel;

import org.tjuscs.sevenwonders.Manager;

/**
 * The Class ThreeColorBasedVpAction.
 */
@SuppressWarnings("serial")
public class ThreeColorBasedVpAction implements Action, DelayedAction {

	/** The vps. */
	int vps = 1;

	/** The board. */
	Board board;

	/** The current count. */
	int currentCount;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tjuscs.sevenwonders.core.Action#activate(org.tjuscs.sevenwonders.
	 * core.Board)
	 */
	public void activate(Board brd) {
		System.out.println(this.getClass().getName() + " - activate() - "
				+ brd.brdName);
		board = brd;
		// TODO Changed by zxn 4-7
		Manager.getKernel().addEOGDelayedAction(this);
		/*
		 * Original Version GameManager.getManager().addEOTDelayedAction(this);
		 * currentCount = board.getColorCount(CardColor.BROWN) +
		 * board.getColorCount(CardColor.GREY) +
		 * board.getColorCount(CardColor.PURPLE); board.addToVPs(currentCount);
		 */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tjuscs.sevenwonders.core.DelayedAction#doDelayedAction()
	 */
	public void doDelayedAction() {
		System.out.println(this.getClass().getName() + " - doDelayedAction()");
		// TODO Changed by zxn 4-7 bug-11
		int newCount = board.getColorCount(CardColor.BROWN)
				+ board.getColorCount(CardColor.GREY)
				+ board.getColorCount(CardColor.PURPLE);

		board.GuildVps += newCount * vps;
		board.addToVPs(newCount * vps);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "vps for brown, grey, and purple building built";
	}

	public int points(Board brd) {
		board = brd;
		int newCount = board.getColorCount(CardColor.BROWN)
				+ board.getColorCount(CardColor.GREY)
				+ board.getColorCount(CardColor.PURPLE);
		return newCount * vps;
	}
}
