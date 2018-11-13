package Card_Malus;

import java.util.*;
import Deck.Card;

public class Fete_De_Trop extends Card_Malus 
{
	public Fete_De_Trop()
	{
		super("Fête de trop") ;
	}
	
	public boolean canAttaque(Vector<Vector<Card>> x)
	{
		if(!super.sameCard(x,this) && this.notImmu(x,"Proxy"))
		{
			x.elementAt(2).addElement(this);
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