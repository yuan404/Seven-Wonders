package org.tjuscs.sevenwonders.kernel;

/**
 * The Class NeighborDefeatVpAction.
 */
@SuppressWarnings("serial")
public class NeighborDefeatVpAction implements Action, DelayedAction {

	/** The board. */
	Board board;

	/** The right count. */
	int leftCount, rightCount;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tjuscs.sevenwonders.core.Action#activate(org.tjuscs.sevenwonders.
	 * core.Board)
	 */
	public void activate(Board brd) {
		board = brd;
		KernelManager.getManager().addEOADelayedAction(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tjuscs.sevenwonders.core.DelayedAction#doDelayedAction()
	 */
	//TODO Changed by zxn bug-16
	public void doDelayedAction() {
		leftCount = board.getLeftNeighbor().getNumberOfDefeats();
		rightCount = board.getRightNeighbor().getNumberOfDefeats();

		int defeats = leftCount+rightCount;
		board.GuildVps += defeats;
		board.addToVPs(defeats);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "vps for the amount of defeats suffered by neighbors";
	}

	@Override
	public int points(Board brd) {
		board=brd;
		int leftCount = board.getLeftNeighbor().getNumberOfDefeats();
		int rightCount = board.getRightNeighbor().getNumberOfDefeats();

		int defeats = leftCount+rightCount;
		return defeats;
	}
} // end of NeighborDefeatVpAction class
