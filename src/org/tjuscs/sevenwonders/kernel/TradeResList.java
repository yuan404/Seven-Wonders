/**
 * This class represents Trading resource list.
 * Added by zxn 4-8 Bug-09
 */

package org.tjuscs.sevenwonders.kernel;

public class TradeResList {
	public SimpleResList buyFromLeft;
	public SimpleResList buyFromRight;
	public int leftRawCost,rightRawCost,manfCost;
	public int cost;
	public TradeResList() {
		buyFromLeft=new SimpleResList();
		buyFromRight=new SimpleResList();
		cost=0;
		leftRawCost=2;rightRawCost=2;manfCost=2;
	}
	public TradeResList(int left,int right,int manf) {
		buyFromLeft=new SimpleResList();
		buyFromRight=new SimpleResList();
		cost=0;
		leftRawCost=left;
		rightRawCost=right;
		manfCost=manf;
	}
	public TradeResList(TradeResList list) {
		buyFromLeft=list.buyFromLeft;
		buyFromRight=list.buyFromRight;
		cost=list.cost;
		leftRawCost=list.leftRawCost;
		rightRawCost=list.rightRawCost;
		manfCost=list.manfCost;
	}
	public void merge(TradeResList list) {
		cost+=list.cost;
		for (int i=0;i<8;i++) {
			buyFromLeft.srl[i]+=list.buyFromLeft.srl[i];
			buyFromRight.srl[i]+=list.buyFromRight.srl[i];
		}
	}
	public String toString() {
		return this.getClass().getName()+" - TradeResList cost="+cost+" leftRawCost="+leftRawCost+" rightRawCost="+rightRawCost+" manfCost="+manfCost+"\n"
				+buyFromLeft.toString()+"\n"
				+buyFromRight.toString()+"\n";
	}

}
