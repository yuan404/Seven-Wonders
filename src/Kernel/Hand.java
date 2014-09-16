package Kernel;

public class Hand {

	public Card[] card = new Card[7];
	public int cardNum = 0;

	public Hand() {

	}

	public void removeHand(Card usedCard) {
		int i;
		for (i = 0; i < cardNum; i++)
			if (card[i] == usedCard)
				break;
		for (; i < cardNum - 1; i++)
			card[i] = card[i + 1];
		card[--cardNum] = null;
	}
}
