package org.tjuscs.sevenwonders.kernel;

/**
 * The Class StageVpAction.
 */
@SuppressWarnings("serial")
public class StageVpAction implements Action, DelayedAction {

	/** The west board. */
	Board board, eastBoard, westBoard;

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
		westBoard = board.getLeftNeighbor();
		eastBoard = board.getRightNeighbor();

		stageCount = board.getStagesCompleted()
				+ eastBoard.getStagesCompleted()
				+ westBoard.getStagesCompleted();
		board.GuildVps += stageCount; // TODO added by zxn
		board.addToVPs(stageCount);
		KernelManager.getManager().addEOTDelayedAction(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tjuscs.sevenwonders.core.DelayedAction#doDelayedAction()
	 */
	public void doDelayedAction() {
		int newStageCount = board.getStagesCompleted()
				+ eastBoard.getStagesCompleted()
				+ westBoard.getStagesCompleted();
		int newStages = 0;

		if (newStageCount > stageCount) {
			newStages = newStageCount - stageCount;
			stageCount = newStageCount;
		}
		if (newStages != 0) {
			board.GuildVps += newStages;
			board.addToVPs(newStages);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "vps for the number of stages neighbors have completed";
	}

	public int points(Board brd) {
		board = brd;
		Board westBoard = board.getLeftNeighbor();
		Board eastBoard = board.getRightNeighbor();

		int stageCount = board.getStagesCompleted()
				+ eastBoard.getStagesCompleted()
				+ westBoard.getStagesCompleted();
		return stageCount;
	}
} // end of StageVpActions class

