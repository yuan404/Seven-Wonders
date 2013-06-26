package org.tjuscs.sevenwonders.kernel;

import java.util.ArrayList;
import java.util.Random;

import org.tjuscs.sevenwonders.gui.MainBackGround;

//import org.tjuscs.sevenwonders.gui.MainBackGround;

/**
 * The Class RandBot.
 */
@SuppressWarnings("serial")
public class RandBot extends GamePlayer {

	public Difficulty difficulty;
	
	public RandBot(int index){
		this.index = index;
		this.name = "RandBot_"+index;
		this.difficulty=Difficulty.EASY;	//TODO added by zxn	4-5 new-1
		System.out.println("Bot "+index);
		
	}
	/**
	 * TODO Added by zxn 4-5 new-1
	 */
	public RandBot(int index, Difficulty diff) {
		this.index=index;
		this.name= "RandBot_"+index;
		this.difficulty=diff;
		System.out.println("Bot "+index+" "+diff);
	}

	public RandBot() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tjuscs.sevenwonders.core.Player#makeChoice(org.tjuscs.sevenwonders
	 * .core.CommandOption[])
	 */
	@Override
	public CommandOption makeAChoice(CommandOption[] options) {
		if (this.difficulty==Difficulty.EASY)
			//return easyTestingMode(options);	//TODO Test for changing ai difficulty only by zxn
			return easyMode(options); 
		else if (this.difficulty==Difficulty.NORMAL)
			return normalMode(options);
		else
			return hardMode(options);
	}
	
	private CommandOption easyMode(CommandOption[] options) {
		System.out.println(RandBot.class.getName()+" - easyMode() ");
		int buildCnt = 0;
		for (CommandOption opt : options) {
			if (opt.isBuildable())
				buildCnt++;
		}
		if (board.canBuildNextStage()) {
			System.out.println("RandBot::Stage is buildable"); 
		}

		System.out.println("MakeChoice:has " + buildCnt + " buildable cards");
		Random rand = new Random();
		if (buildCnt != 0) {
			int num = rand.nextInt(buildCnt); // TODO buildCnt can be 0, then we
												// need to build Stage or sell
												// card

			buildCnt = 0;
			for (CommandOption opt : options) {
				if (opt.isBuildable()) {
					if (buildCnt == num) {
						System.out.println("MakeChoice:chose " + num
								+ " which is " + opt.card);
						/**
						 * changed by zxn
						 * @author zxn
						 */
						if (!opt.isAvailableFree() && opt.isOptions()) {
							this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
						}
						
						//End
						opt.setCommand(Command.BUILD_CARD);
						return opt;
					}
					buildCnt++;
				}
			}
		} else { // no cards are buildable and so randomly chooses to sell a
					// card TODO should also see if Stage is buildable
			int num = rand.nextInt(options.length);
			options[num].setCommand(Command.SELL_CARD);
			System.out.println("MakeChoice:noBuildable so sell "
					+ options[num].card);
			return options[num];
		}

		// error in selecting and so sell first card
		options[0].setCommand(Command.SELL_CARD);
		return options[0];
	}		

private CommandOption normalMode(CommandOption[] options) {
		Random rand=new Random();

		if (MainBackGround.age==1) {
			//AGE I
			//Check for the yellow card
			ArrayList<CommandOption> yellowCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> resCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> blueCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> orCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> restCards=new ArrayList<CommandOption>();

			
			for (CommandOption opt : options) if (opt.isBuildable()) {
				if (opt.getCard().getColor()==CardColor.YELLOW)
					yellowCards.add(opt);
				else if ((opt.getCard().getColor()==CardColor.BROWN || opt.getCard().getColor()==CardColor.GREY) && opt.getNeedToBuild()==0)
					resCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.BLUE)
					blueCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.BROWN && opt.getNeedToBuild()>0)
					orCards.add(opt);
				else if (opt.getCard().getColor()!=CardColor.GREEN)
					restCards.add(opt);
			}
			CommandOption opt;
			//	Has buildable yellow card
			if (yellowCards.size()>0) {
				int num=rand.nextInt(yellowCards.size());
				opt=yellowCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;
			}
			//Optional Res cards
			if (orCards.size()>0) {
				int num=rand.nextInt(orCards.size());
				opt=orCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;
			}
			
		
			//Check for the free brown or gray card
			if (resCards.size()>0) {
				int num=rand.nextInt(resCards.size());
				opt=resCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;
			}
			
			
			
			//Randomly select red cards
			if (restCards.size()>0) {
				int num=rand.nextInt(restCards.size());
				opt=restCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;
			}
			
			//Blue card
			if (blueCards.size()>0) {
				int num=rand.nextInt(blueCards.size());
				opt=blueCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;
			}

			int num=rand.nextInt(options.length);
			opt=options[num];

			if (board.canBuildNextStage()) 
				opt.setCommand(Command.BUILD_STAGE);				
			else			
				opt.setCommand(Command.SELL_CARD);
			System.out.println("NormalZXN MakeChoice: "+opt);
			return opt;
			
		} else if (MainBackGround.age==2) {
			ArrayList<CommandOption> freeList=new ArrayList<CommandOption>();
			ArrayList<CommandOption> buildList=new ArrayList<CommandOption>();
			ArrayList<CommandOption> doubleResCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> freeResCards=new ArrayList<CommandOption>();
			for (CommandOption opt: options) if (opt.isBuildable() && opt.getCard().getColor()!=CardColor.GREEN) {
				if (opt.getCard().getColor()==CardColor.BROWN && opt.getNeedToBuild()==1) {
					SimpleResList tmp=opt.getCard().getResList();
					SimpleResList boardList=board.getResList();
					boolean needed=true;
					for (int i=1;i<8;i++)
						if (tmp.srl[i]>0 && tmp.srl[i]+boardList.srl[i]>2) {
							needed=false;
							break;
						}
					if (needed)
						doubleResCards.add(opt);
				}
				else if (opt.getCard().getColor()==CardColor.BROWN || opt.getCard().getColor()==CardColor.GREY) {
					SimpleResList tmp=opt.getCard().getResList();
					SimpleResList boardList=board.getResList();
					boolean needed=true;
					for (int i=1;i<8;i++)
						if (tmp.srl[i]>0 && tmp.srl[i]+boardList.srl[i]>2) {
							needed=false;
							break;
						}
					if (needed)
						freeResCards.add(opt);
				}
				else if (opt.isAvailableFree() || opt.getNeedToBuild()==0) 
					freeList.add(opt);
				buildList.add(opt);
			}
				
			
			CommandOption opt;

			//Double Res cards
			if (doubleResCards.size()>0) {
				int num=rand.nextInt(doubleResCards.size());
				opt=doubleResCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;
			}
			
			//Check for the free brown or gray card
			if (freeResCards.size()>0) {
				int num=rand.nextInt(freeResCards.size());
				opt=freeResCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;
			}
			
			
			// Free build cards
			if (freeList.size()>0) {
				int num=rand.nextInt(freeList.size());
				opt=freeList.get(num);
				opt.setCommand(Command.BUILD_CARD);
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;				
			}
			//Randomly select from the rest except green card
			if (buildList.size()>0) {
				int num=rand.nextInt(buildList.size());
				opt=buildList.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;				
			}
			//Build wonder or sell card
			int num=rand.nextInt(options.length);
			opt=options[num];

			if (board.canBuildNextStage()) 
				opt.setCommand(Command.BUILD_STAGE);				
			else			
				opt.setCommand(Command.SELL_CARD);
			System.out.println("NormalZXN MakeChoice: "+opt);
			return opt;
		} else {
			//Age III
			ArrayList<CommandOption> purpleCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> freeList=new ArrayList<CommandOption>();
			ArrayList<CommandOption> buildList=new ArrayList<CommandOption>();
			for (CommandOption opt: options) 
				if (opt.isBuildable() && opt.getCard().getColor()!=CardColor.GREEN) {
					if (opt.getCard().getColor()==CardColor.PURPLE)
						purpleCards.add(opt);
					else if (opt.isAvailableFree() || opt.getNeedToBuild()==0)
						freeList.add(opt);
					buildList.add(opt);
				}
			CommandOption opt;
			if (purpleCards.size()>0) {
				int num=rand.nextInt(purpleCards.size());
				opt=purpleCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;
			}
			
			
			if (freeList.size()>0) {
				int num=rand.nextInt(freeList.size());
				opt=freeList.get(num);
				opt.setCommand(Command.BUILD_CARD);
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;				
			}
			if (buildList.size()>0) {
				int num=rand.nextInt(buildList.size());
				opt=buildList.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("NormalZXN MakeChoice: "+opt);
				return opt;				
			}
			//Build wonder or sell card
			int num=rand.nextInt(options.length);
			opt=options[num];

			if (board.canBuildNextStage()) 
				opt.setCommand(Command.BUILD_STAGE);				
			else			
				opt.setCommand(Command.SELL_CARD);
			System.out.println("NormalZXN MakeChoice: "+opt);
			return opt;
			
		}
		
		
	}
	

private CommandOption hardMode(CommandOption[] options) {
		Random rand=new Random();

		if (MainBackGround.age==1) {
			//AGE I
			//Check for the yellow card
			ArrayList<CommandOption> yellowCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> freeRedCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> redCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> brownCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> greyCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> blueCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> orCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> freeGreenCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> restCards=new ArrayList<CommandOption>();

			
			for (CommandOption opt : options) if (opt.isBuildable()) {
				if (opt.getCard().getColor()==CardColor.YELLOW)
					yellowCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.RED) {
					redCards.add(opt);
					if (opt.getNeedToBuild()==0)
						freeRedCards.add(opt);
				}
				else if (opt.getCard().getColor()==CardColor.BROWN) {
					if (opt.getNeedToBuild()==0)
						brownCards.add(opt);
					else
						orCards.add(opt);
				}
				else if (opt.getCard().getColor()==CardColor.GREY)
					greyCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.BLUE)
					blueCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.GREEN && opt.getNeedToBuild()==0)
					freeGreenCards.add(opt);
				else
					restCards.add(opt);
			}
			CommandOption opt;
			//	No yellow, has buildable yellow card
			if (board.getColorCount(CardColor.YELLOW)==0 && yellowCards.size()>0) {
				int num=0;
				for (int i=0;i<yellowCards.size();i++)
					if (yellowCards.get(i).getCard().getName().equals("Marketplace")) 
						num=i;
				opt=yellowCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			int left=(board.leftNeighbor.goods.containsKey(Resource.SHEILD))?board.leftNeighbor.goods.get(Resource.SHEILD):0;
			int right=(board.rightNeighbor.goods.containsKey(Resource.SHEILD))?board.rightNeighbor.goods.get(Resource.SHEILD):0;
			int self=(board.goods.containsKey(Resource.SHEILD))?board.goods.get(Resource.SHEILD):0;

			// No shield, Red is free
			if (left+right!=0 && freeRedCards.size()>0) {
				int num=0;
				// The card that can build by the left neighbor have a higher order
				for (int i=0;i<freeRedCards.size();i++) {
					SimpleResList tmp=freeRedCards.get(i).getCard().getResList();
					int j=1;
					while (j<8 && tmp.srl[j]==0) j++;
					if (j<8 && board.leftNeighbor.getResList().srl[j]>0)
						num=i;
				}
				opt=freeRedCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;				
			}
			
			// Your neighbor have one shield
			System.out.println("***"+left+" "+right);
			if (self==0 && left+right!=0 && (redCards.size()>0)) {
				int num=0;
				// The card that can build by the left neighbor have a higher order
				for (int i=0;i<freeRedCards.size();i++) {
					SimpleResList tmp=freeRedCards.get(i).getCard().getResList();
					int j=1;
					while (tmp.srl[j]==0) j++;
					if (board.leftNeighbor.getResList().srl[j]>0)
						num=i;
				}
				opt=redCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;								
			}
			
			//Res card is buildable
			if (brownCards.size()>0 || greyCards.size()>0 || orCards.size()>0) {
				ArrayList<CommandOption> higherOrderList=new ArrayList<CommandOption>();
				ArrayList<CommandOption> lowerOrderList=new ArrayList<CommandOption>();
				ArrayList<CommandOption> lastOrderList=new ArrayList<CommandOption>();
				System.out.println("Brown :"+brownCards);
				System.out.println("Or :"+orCards);
				for (int i=0;i<orCards.size();i++) {
					SimpleResList tmp=orCards.get(i).getCard().getResList();
					int j=1;
					while (tmp.srl[j]==0) j++;
					int k=j+1;
					while (tmp.srl[k]==0) k++;
					if (board.getResList().srl[j]+board.getResList().srl[k]==0)
						higherOrderList.add(orCards.get(i));
					else if (board.getResList().srl[j]+board.getResList().srl[k]==1)
						lowerOrderList.add(orCards.get(i));
					else
						lastOrderList.add(orCards.get(i));
				}
				for (int i=0;i<brownCards.size();i++) {
					SimpleResList tmp=brownCards.get(i).getCard().getResList();
					System.out.println(tmp);
					int j=1;
					while (tmp.srl[j]==0) j++;
					if (board.getResList().srl[j]==0)
						higherOrderList.add(brownCards.get(i));
					else
						lastOrderList.add(brownCards.get(i));
				}
				for (int i=0;i<greyCards.size();i++) {
					SimpleResList tmp=greyCards.get(i).getCard().getResList();
					int j=1;
					while (tmp.srl[j]==0) j++;
					if (board.getResList().srl[j]==0) 
						higherOrderList.add(greyCards.get(i));
					else
						lastOrderList.add(greyCards.get(i));
				}
				if (higherOrderList.size()>0)
					opt=higherOrderList.get(0);
				else if (lowerOrderList.size()>0) 
					opt=lowerOrderList.get(0);
				else 
					opt=lastOrderList.get(rand.nextInt(lastOrderList.size()));
				opt.setCommand(Command.BUILD_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;								
			}
			
			
			// Build Yellow
			if (yellowCards.size()>0) {
				int num=rand.nextInt(yellowCards.size());
				opt=yellowCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
				
			}
			

			// Build Free Green
			if (freeGreenCards.size()>0) {
				int num=rand.nextInt(freeGreenCards.size());
				opt=freeGreenCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
				
			}
			//Sell the rest
			int num=rand.nextInt(options.length);
			opt=options[num];

			//Build Stage
			if (board.canBuildNextStage()) 
				opt.setCommand(Command.BUILD_STAGE);
			else			
				opt.setCommand(Command.SELL_CARD);
			System.out.println("Hard MakeChoice: "+opt);
			return opt;
			
		} else if (MainBackGround.age==2) {
			//AGE II
			ArrayList<CommandOption> freeYellowCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> blueCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> higherBrownCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> lowerBrownCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> greyCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> redCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> freeRedCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> greenCards=new ArrayList<CommandOption>();
			for (CommandOption opt: options) if (opt.isBuildable()) {
				if (opt.getCard().getColor()==CardColor.BROWN) {
					SimpleResList tmp=opt.getCard().getResList();
					SimpleResList boardList=board.getResList();
					boolean higher=false;
					for (int i=1;i<8;i++)
						if (tmp.srl[i]>0) {
							if (boardList.srl[i]==0) 
								higher=true;
							else
								higher=false;
							break;
						}
					if (higher)
						higherBrownCards.add(opt);
					else
						lowerBrownCards.add(opt);
				}
				else if (opt.getCard().getColor()==CardColor.GREY) {
					SimpleResList tmp=opt.getCard().getResList();
					boolean needed=true;
					for (int i=1;i<8;i++)
						if (tmp.srl[i]>0 && tmp.srl[i]!=0) {
							needed=false;
							break;
						}
					if (needed)
						greyCards.add(opt);
				}
				else if (opt.getCard().getColor()==CardColor.RED) {
					if (opt.getNeedToBuild()==0)
						freeRedCards.add(opt);
					redCards.add(opt);
				} else if (opt.getCard().getColor()==CardColor.YELLOW && opt.getNeedToBuild()==0)
					freeYellowCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.BLUE) 
					blueCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.GREEN && opt.getNeedToBuild()==0)
					greenCards.add(opt);
			}
				
			
			CommandOption opt;
			
			//* build red
			int self=(board.goods.containsKey(Resource.SHEILD))?board.goods.get(Resource.SHEILD):0;
			int left=(board.leftNeighbor.goods.containsKey(Resource.SHEILD))?board.leftNeighbor.goods.get(Resource.SHEILD):0;
			int right=(board.rightNeighbor.goods.containsKey(Resource.SHEILD))?board.rightNeighbor.goods.get(Resource.SHEILD):0;
			if ((self<=left || self<=right) && redCards.size()>0) {
				int num=0;
				for (int i=1;i<redCards.size();i++)
					if (redCards.get(i).getNeedToBuild()<redCards.get(num).getNeedToBuild())
						num=i;
				opt=redCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			//** Build Brown Not in board
			if (higherBrownCards.size()>0) {
				int num=rand.nextInt(higherBrownCards.size());
				opt=higherBrownCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			//*** Build Grey Card
			if (greyCards.size()>0) {
				int num=rand.nextInt(greyCards.size());
				opt=greyCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			//**** Free Red Cards 
			if (freeRedCards.size()>0) {
				int num=rand.nextInt(freeRedCards.size());
				opt=freeRedCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			//***** Rest Brown Cards
			if (lowerBrownCards.size()>0) {
				int num=rand.nextInt(lowerBrownCards.size());
				opt=lowerBrownCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;				
			}
			
			//****** Free Yellow Cards
			if (freeYellowCards.size()>0) {
				ArrayList<CommandOption> coin=new ArrayList<CommandOption>();
				ArrayList<CommandOption> res=new ArrayList<CommandOption>();
				for (int i=0;i<freeYellowCards.size();i++)
					if (freeYellowCards.get(i).getCard().getName().equals("Forum") || freeYellowCards.get(i).getCard().getName().equals("Caravansery"))
						res.add(freeYellowCards.get(i));
					else
						coin.add(freeYellowCards.get(i));
				if (board.goods.get(Resource.COIN)<3 && coin.size()>0)
					opt=coin.get(0);
				else if (res.size()>0)
					opt=res.get(0);
				else
					opt=freeYellowCards.get(rand.nextInt(freeYellowCards.size()));
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;								
			}
			
			//******* Blue Cards
			if (blueCards.size()>0) {
				int num=0;
				for (int i=1;i<blueCards.size();i++)
					if (blueCards.get(i).getCard().goods.get(Resource.VP)>blueCards.get(num).getCard().goods.get(Resource.VP))
						num=i;
				opt=blueCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;								
			}
			
			//Build wonder
			if (board.stagesCompleted==0) {
				int num=rand.nextInt(options.length);
				opt=options[num];
				
				if (board.canBuildNextStage()) { 
					opt.setCommand(Command.BUILD_STAGE);
					System.out.println("Hard MakeChoice: "+opt);
					return opt;
				}
			}
			
			//Build Free Green
			if (greenCards.size()>0 && board.goods.get(Resource.COIN)>=6) {
				int num=rand.nextInt(greenCards.size());
				opt=greenCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;				
				
			}
			//Sell Red
			for (int i=0;i<options.length;i++) if (options[i].getCard().getColor()==CardColor.RED) {
				opt=options[i];
				opt.setCommand(Command.SELL_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			//Sell Blue
			for (int i=0;i<options.length;i++) if (options[i].getCard().getColor()==CardColor.BLUE) {
				opt=options[i];
				opt.setCommand(Command.SELL_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			//Sell Green
			for (int i=0;i<options.length;i++) if (options[i].getCard().getColor()==CardColor.GREEN) {
				opt=options[i];
				opt.setCommand(Command.SELL_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			//Sell Rest
			int num=rand.nextInt(options.length);
			opt=options[num];
			opt.setCommand(Command.SELL_CARD);
			System.out.println("Hard MakeChoice: "+opt);
			return opt;
		} else {
			//Age III
			ArrayList<CommandOption> yellowCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> blueCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> purpleCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> redCards=new ArrayList<CommandOption>();
			ArrayList<CommandOption> freeRedCards=new ArrayList<CommandOption>();
			for (CommandOption opt: options) if (opt.isBuildable()) {
				if (opt.getCard().getColor()==CardColor.RED) {
					if (opt.getNeedToBuild()==0)
						freeRedCards.add(opt);
					redCards.add(opt);
				} else if (opt.getCard().getColor()==CardColor.YELLOW)
					yellowCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.BLUE) 
					blueCards.add(opt);
				else if (opt.getCard().getColor()==CardColor.PURPLE && !opt.getCard().getName().equals("Scientists Guild"))
					purpleCards.add(opt);
			}
			
			CommandOption opt;
			
			//Build Red
			int self=(board.goods.containsKey(Resource.SHEILD))?board.goods.get(Resource.SHEILD):0;
			int left=(board.leftNeighbor.goods.containsKey(Resource.SHEILD))?board.leftNeighbor.goods.get(Resource.SHEILD):0;
			int right=(board.rightNeighbor.goods.containsKey(Resource.SHEILD))?board.rightNeighbor.goods.get(Resource.SHEILD):0;
			if ((self<left || self<right) && redCards.size()>0) {
				int num=0;
				for (int i=1;i<redCards.size();i++)
					if (redCards.get(i).getNeedToBuild()<redCards.get(num).getNeedToBuild())
						num=i;
				opt=redCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			if (freeRedCards.size()>0 &&(self-left<=3 || self-right<=3)) {
				int num=rand.nextInt(freeRedCards.size());
				opt=freeRedCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;				
			}
			
			// Select the most points card from purple yellow blue
			if (purpleCards.size()>0 || blueCards.size()>0 || yellowCards.size()>0) {
				opt=null;
				int points=0;
				for (int i=0;i<blueCards.size();i++) 
					if (blueCards.get(i).getCard().goods.get(Resource.VP)>points) {
						points=blueCards.get(i).getCard().goods.get(Resource.VP);
						opt=blueCards.get(i);
					}
				for (int i=0;i<purpleCards.size();i++) 
					if (purpleCards.get(i).getCard().action.points(board)>points) {
						points=purpleCards.get(i).getCard().action.points(board);
						opt=purpleCards.get(i);
					}
				for (int i=0;i<yellowCards.size();i++)
					if (yellowCards.get(i).getCard().action.points(board)>points) {
						points=yellowCards.get(i).getCard().action.points(board);
						opt=yellowCards.get(i);
					}
				if (opt!=null) {
					opt.setCommand(Command.BUILD_CARD);
					if (!opt.isAvailableFree() && opt.isOptions()) {
						this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
					}
					System.out.println("Hard MakeChoice: "+opt);
					return opt;									
				}
			}
			
			//Build Free Red
			if (freeRedCards.size()>0) {
				int num=rand.nextInt(freeRedCards.size());
				opt=freeRedCards.get(num);
				opt.setCommand(Command.BUILD_CARD);
				if (!opt.isAvailableFree() && opt.isOptions()) {
					this.makeABuyDecision(SimpleResList.buildCostList(opt.getCard()), opt.leftSRL, opt.rightSRL);
				}
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}

			
			
			
			
			//Sell Blue
			for (int i=0;i<options.length;i++) if (options[i].getCard().getColor()==CardColor.BLUE) {
				opt=options[i];
				opt.setCommand(Command.SELL_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			//Sell Red
			for (int i=0;i<options.length;i++) if (options[i].getCard().getColor()==CardColor.RED) {
				opt=options[i];
				opt.setCommand(Command.SELL_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			//Sell Purple
			for (int i=0;i<options.length;i++) if (options[i].getCard().getColor()==CardColor.PURPLE) {
				opt=options[i];
				opt.setCommand(Command.SELL_CARD);
				System.out.println("Hard MakeChoice: "+opt);
				return opt;
			}
			
			//Sell Rest
			int num=rand.nextInt(options.length);
			opt=options[num];
			opt.setCommand(Command.SELL_CARD);
			System.out.println("Hard MakeChoice: "+opt);
			return opt;
			
		}
		
		
	}
	
	


























	/**
	 * TODO Changed by zxn 4-2, 4-5, bug-2
	 * Calculate resources needed to buy from neighbors
	 * TODO Need to improve
	 */
	public void makeABuyDecision(SimpleResList needs, SimpleResList leftGoods,
			SimpleResList rightGoods) {
		//TODO Changed by zxn 4-2, 4-5, Bug-2

		System.out.println(RandBot.class.getName()+" - makeABuyDecision()");
		
		SimpleResList tmp;
		SimpleResList buyFromLeft,buyFromRight;
		
		needs.subtract(this.board.getResourceList());
		SimpleResList smpList;
		for (int i=0;i<board.orList.size();i++) {
			smpList=board.orList.get(i);
			for (int j=1;j<8;j++) if (needs.srl[j]>0)
				if (smpList.srl[j]>0) {
					needs.srl[j]-=smpList.srl[j];
					break;
				}
		}
		
		tmp=new SimpleResList(needs);
		
		if (board.leftRawCost<=board.rightRawCost) {
		
			tmp.subtract(leftGoods);
			buyFromLeft=new SimpleResList(needs);		
			buyFromLeft.subtract(tmp);
			needs.subtract(buyFromLeft);

			tmp=new SimpleResList(needs);
			tmp.subtract(rightGoods);
			buyFromRight=new SimpleResList(needs);
			needs.subtract(buyFromRight);
		} else {

			tmp.subtract(rightGoods);
			buyFromRight=new SimpleResList(needs);
			needs.subtract(buyFromRight);

			tmp=new SimpleResList(needs);
			tmp.subtract(leftGoods);
			buyFromLeft=new SimpleResList(needs);		
			buyFromLeft.subtract(tmp);
			needs.subtract(buyFromLeft);


			
		}
		BuyDecision.buyFromLeft=buyFromLeft;
		BuyDecision.buyFromRight=buyFromRight;
	}

	/**
	 * This is used to test only
	 * @param options
	 * @return
	 */
//	private CommandOption easyTestingMode(CommandOption[] options) {
////		System.out.println(RandBot.class.getName()+" - easyMode() ");
//		Random rand = new Random();
//		int num = rand.nextInt(options.length);
//		options[num].setCommand(Command.SELL_CARD);
//		return options[num];
//		
//	}
}
