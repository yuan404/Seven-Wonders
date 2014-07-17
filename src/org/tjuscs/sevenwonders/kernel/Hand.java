package org.tjuscs.sevenwonders.kernel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Class Hand.
 */
@SuppressWarnings("serial")
public class Hand implements Serializable {

	/** The hand. */
	ArrayList<Card> hand;

	/**
	 * Instantiates a new hand.
	 */
	public Hand() {
		hand = new ArrayList<Card>();
	}

	/**
	 * Gets the.
	 * 
	 * @param ind
	 *            the ind
	 * @return the card
	 */
	public Card get(int ind) {
		return hand.get(ind);
	}

	/**
	 * Removes the.
	 * 
	 * @param ind
	 *            the ind
	 * @return the card
	 */
	Card remove(int ind) {
		return hand.remove(ind);
	}

	/**
	 * Removes the.
	 * 
	 * @param str
	 *            the str
	 * @return the card
	 */
	public Card remove(String str) {

		for (Card crd : hand) {
			if (crd.getName().equals(str)) {
				hand.remove(crd);
				return crd;
			}
		}
		return null;
	}

	/**
	 * Sets the.
	 * 
	 * @param ind
	 *            the ind
	 * @param crd
	 *            the crd
	 * @return the card
	 */
	Card set(int ind, Card crd) {
		return hand.set(ind, crd);
	}

	/**
	 * Adds the.
	 * 
	 * @param c
	 *            the c
	 * @return true, if successful
	 */
	boolean add(Card c) {
		return hand.add(c);
	}

	/**
	 * Size.
	 * 
	 * @return the int
	 */
	public int size() {
		return hand.size();
	}
	/**
	 * Get Name of cards for hand
	 * 
	 * @return string
	 */
	public String[] getNames(){
		String[] str = new String[hand.size()];
		int i = 0;
		for (Card c : hand){
			str[i] = new String();
			str[i++] = c.getName();
		}
		return str;
	}

	public Card getCardByName(String str){
		Card cd = new Card();
		for (Card c : hand){
			if(c.getName().equals(str)){
				cd = c;
				return cd;
			}
		}
		return cd;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder str = new StringBuilder("Hand: Contains: " + hand.size()
				+ " cards\n");
		for (Card c : hand)
			str.append(c.toString() + "\n");
		return str.toString();
	}

}
