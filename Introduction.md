# AI

* boolean setChoose(String card, int choose);
  choose == 1  => Build the card;
  choose == 2  => Build the stage;
  choose == 3  => Sold the card;
  If the card is not in the hand cards, it would be not built.
 
* int getIndex();
  
* boolean buy(String resource, int num, int side);
  buy resource from your neighbors.
  side == 0 => buy from left;
  side == 1 => buy from right;
  
* String[] getHands();
  get the names of hand cards;
  
* int getHandNum();
  get the num of hand cards;