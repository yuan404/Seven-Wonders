package org.tjuscs.sevenwonders.kernel;

/**
 * The Class StageIncAndVpAction.
 */
@SuppressWarnings("serial")
public class StageIncAndVpAction implements Action, DelayedAction {

	/** The board. */
	Board board;

	/** The stage count. */
	int stageCount;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tjuscs.sevenwonders.core.Action#activate(org.tjuscs.sevenwonders.
	 * core.Board)
	 */
	public void activate(Board brd) {
		board = brd;
		stageCount = board.getStagesCompleted();
		board.addToCoins(stageCount * 3);
		board.addToVPs(stageCount);

		board.CommerceVps += stageCount; // TODO Added by zxn 4-8 bug-13

		KernelManager.getManager().addEOTDelayedAction(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tjuscs.sevenwonders.core.DelayedAction#doDelayedAction()
	 */
	public void doDelayedAction() {
		int newStageCount = board.getStagesCompleted();
		int newStages = 0;

		if (newStageCount > stageCount) {
			newStages = newStageCount - stageCount;
			stageCount = newStageCount;
		}
		if (newStages != 0) {
			board.CommerceVps += newStages;
			board.addToVPs(newStages);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "coins and vps for the number of stages completed";
	}

	public int points(Board brd) {
		board = brd;
		int stages = board.getStagesCompleted();
		return stages;
	}
} // end of StageIncAndVpAction class
