package Card_Malus;

import java.util.*;
import Deck.Card;

public class Reseau_Down extends Card_Malus 
{
	public Reseau_Down()
	{
		super("Réseau down") ;
	}
	
	public boolean canAttaque(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(0).isEmpty() && !super.sameCard(x,this) && this.notImmu(x,"Proxy"))
		{
			x.elementAt(0).removeElementAt(0);
			return true ;
		}
		
		return false ;
	}
	
	public boolean canDefend(Vector<Vector<Card>> x)
	{
		return false ;
	}
	
	public boolean canForward(Vector<Vector<Card>> x)
	{
		return false ;
	}
	
	public boolean canImmu(Vector<Vector<Card>> x)
	{
		return false ;
	}
}