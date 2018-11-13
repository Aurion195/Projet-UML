package Card_Immu;

import java.util.*;
import Deck.Card;

/**
 * Class des cartes pour s'immuniser
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public abstract class Card_Immu extends Card
{
	/**
	 * Nom de la carte
	 */
	String name ;
	
	/**
	 * Constructeur de la classe
	 * @param name = nom de la carte ;
	 */
	public Card_Immu(String name)
	{
		super(name,"Card_Immu") ;
		this.name = name ;
	}
	
	/**
	 * Enlève les malus du joueur s'il en a, en fonction de la carte immunité
	 * @param x = plateau du joueur ;
	 * @param malus = malus à enlever ;
	 */
	protected void delMalus(Vector<Vector<Card>> x, String malus)
	{
		if(!x.elementAt(2).isEmpty())
		{
			for(int i = 0 ; i < x.elementAt(2).size() ; i++)
			{
				if(x.elementAt(2).elementAt(i).getName().equals(malus))
				{
					x.elementAt(2).removeElementAt(i);
				}
			}
		}
	}
}
