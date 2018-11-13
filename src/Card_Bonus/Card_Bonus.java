package Card_Bonus;

import Deck.Card;


/**
 * Class des cartes bonus du jeu
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public abstract class Card_Bonus extends Card
{
	/**
	 * Nom de la carte
	 */
	String name ;
	
	/**
	 * Constructeur de la classe
	 * @param name = nom de la carte ;
	 */
	public Card_Bonus(String name)
	{
		super(name,"Card_Bonus") ;
		this.name = name ;
	}
}