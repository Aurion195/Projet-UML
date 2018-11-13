package Card_Forward;

import Deck.Card;
import java.util.*;

/**
 * Class des cartes pour avancer du jeu
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public abstract class Card_Forward extends Card
{
	/**
	 * Nom de la carte
	 */
	String name ;
	
	/**
	 * Constructeur de la classe
	 * @param name = nom de la carte ;
	 */
	public Card_Forward(String name)
	{
		super(name,"Card_Forward") ;
		this.name = name ;
	}
	
}
