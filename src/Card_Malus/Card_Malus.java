package Card_Malus;

import Deck.Card;
import java.util.*;

/**
 * Class des cartes pour attaquer les autres
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public abstract class Card_Malus extends Card
{
	/**
	 * Nom de la carte
	 */
	String name ;
	
	public Card_Malus(String name)
	{
		super(name,"Card_Malus") ;
		this.name = name ;
	}
	
	/**
	 * Regarde si le vecteur de carte possède déjà deux fois le même malus
	 * @param x = plateau du joueur ;
	 * @param e = carte choisit par le joueur ;
	 * @return true s'il peut / false sinon
	 */
	protected boolean sameCard(Vector<Vector<Card>> x, Card e)
	{
		for(int i = 0 ; i < x.elementAt(2).size() ; i++)
		{
			if(x.elementAt(2).elementAt(i).getName().equals(e.getName())) return true ;
		}
		
		return false ;
	}
	
	/**
	 * Regarde si le joueur n'est pas immunisé contre cette attaque
	 * @param x = plateau du joueur ;
	 * @param immu = nom de la carte immunité ;
	 * @return true s'il peut jouer / false sinon 
	 */
	protected boolean notImmu(Vector<Vector<Card>> x, String immu)
	{
		if(!x.elementAt(3).isEmpty())
		{
			for(int i = 0 ; i < x.elementAt(3).size() ; i++)
			{
				if(x.elementAt(3).elementAt(i).getName().equals(immu)) return false ;
			}
		}
		
		return true ;
	}
}
