# AI
```
* boolean checkChoice(String card, int choose);
  choose == 1  => Build the card;
  choose == 2  => Build the stage;
  choose == 3  => Sold the card;
```
```
* boolean setChoice(String card, int choose);
  choose == 1  => Build the card;
  choose == 2  => Build the stage;
  choose == 3  => Sold the card;
  If the return is false, the action would be illegal.
```
* int getIndex();
```
* boolean checkBuy(String resource, int num, int side);
  check buy resource from your neighbors;
  side == 0 => buy from left;
  side == 1 => buy from right.
```
```
* boolean buy(String resource, int num, int side);
  buy resource from your neighbors;
  side == 0 => buy from left;
  side == 1 => buy from right;
  If the return is false, the action would be illegal.
```
```
* String[] getHands();
  get the names of hand cards;
```
```
* int getHandNum();
  get the num of hand cards;
```
```
* int howMuch(String resource,int side);
  ask the num of resource of players;
  side == 0 => yourself;
  side == 1 => left;
  side == 2 => left.left;
  side == -1 => right;
  side == -2 => right.right;
  Item : 
	"wood"		=> resource
	"stone" 	=> resource
	"ore"		=> resource
	"brick"		=> resource
	"glass"		=> resource
	"cloth"		=> resource
	"paper"		=> resource
	"coin"		=> resource/money
	"wood_stone"	=> double resource(option)
	"wood_ore"		=> double resource(option)
	"wood_brick"	=> double resource(option)
	"stone_ore"		=> double resource(option)
	"stone_brick"	=> double resource(option)
	"ore_brick"		=> double resource(option)
	"wood_stone_ore_brick"	=> four resource(option)
	"glass_cloth_paper"		=> three resource(option)
	"literature"		=> science
	"physics"			=> science
	"math"				=> science
	"literature_physics_math"	=> science(option)
	"force"				=> army/shields
	"blueScore"			=> scores
	"boardScore"		=> scores
	"cardNum"			=> num of cards of built
	"brownNum"			=> num of brown cards of built 
	"grayNum"			=> num of gray cards of built 
	"redNum"			=> num of red cards of built 
	"blueNum"			=> num of blue cards of built 
	"yellowNum"			=> num of yellow cards of built 
	"purpleNum"			=> num of purple cards of built 
	"greenNum"			=> num of green cards of built 
  If you ask the item without the list, the action would be error.
```
```
* int howMuchCost(String resource,String cardName);
  ask the cost of card;
  Item : 
	"wood"		=> resource
	"stone" 	=> resource
	"ore"		=> resource
	"brick"		=> resource
	"glass"		=> resource
	"cloth"		=> resource
	"paper"		=> resource
	"coin"		=> resource/money
```
```
* int getStageCost(String resource);
  ask the cost of stage building;
  Item is same with howManyCost;
```
```
* String[] getCards();
  ask the cards name of the built cards
```
```
* int getCardsNum();
  ask the num of the built cards
```
```
* int getFeeOfBuild(String card)
  get how much coin would be paid if you want to build the card
```
```
* void payFeeOfBuild(String card)
  You want to pay money for building card.
```