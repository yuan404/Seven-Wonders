package org.tjuscs.sevenwonders.kernel;

public class Debugger {
	Board boardM,boardL,boardR;
	public Debugger() {
		SimpleResList res;
		//Middle Board
		res=new SimpleResList();
		res.srl[0]=3;
		res.srl[5]=1;
		res.srl[6]=1;
		res.srl[7]=1;
		boardM=new Board("Middle",Resource.STONE,3);
		boardM.resList.addResource(Resource.STONE);
		boardM.resList.addResource(Resource.CLOTH);
		boardM.resList.addResource(Resource.GLASS);
		boardM.orList.add(res);
		boardM.sellOrList.add(res);
		boardM.leftRawCost=2;
		boardM.rightRawCost=2;
		boardM.manfCost=2;
		
		//Left Board
		res=new SimpleResList();
		boardL=new Board("Left",Resource.BRICK,3);
		boardL.resList.addResource(Resource.ORE);
		boardL.resList.addResource(Resource.WOOD);
		boardL.resList.addResource(Resource.PAPYRUS);
		boardL.leftRawCost=2;
		boardL.rightRawCost=2;
		boardL.manfCost=1;


		//Right Board
		res=new SimpleResList();
		res.srl[0]=2;
		res.srl[1]=1;
		res.srl[2]=1;
		boardR=new Board("Right",Resource.ORE,3);
		boardR.resList.addResource(Resource.WOOD);
		boardR.orList.add(res);
		boardR.sellOrList.add(res);
		res=new SimpleResList();
		res.srl[0]=2;
		res.srl[3]=1;
		res.srl[4]=1;
		boardR.orList.add(res);
		boardR.sellOrList.add(res);
		
		boardR.leftRawCost=2;
		boardR.rightRawCost=1;
		boardR.manfCost=2;
				

		boardM.setLeftNeighbor(boardL);
		boardM.setRightNeighbor(boardR);
		boardL.setLeftNeighbor(boardR);
		boardL.setRightNeighbor(boardM);
		boardR.setLeftNeighbor(boardM);
		boardR.setRightNeighbor(boardL);

	}
	public static void main(String[] args) {
		SimpleResList res=new SimpleResList();
		res.srl[0]=2;
		res.srl[1]=2;
		Debugger debugger=new Debugger();
		int cost=debugger.boardM.get(res);
		System.out.println(cost);
	}
}
