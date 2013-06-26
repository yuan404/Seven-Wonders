package org.tjuscs.sevenwonders.kernel;
/**
 * This class represents the buy list from left and right neighbors
 * @author zxn
 *
 */

public class BuyDecision {
	public static SimpleResList buyFromLeft;
	public static SimpleResList buyFromRight;
	public static void reset() {
		buyFromLeft=null;
		buyFromRight=null;
	}
}
