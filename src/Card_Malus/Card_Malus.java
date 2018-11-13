package Card_Malus;

import Deck.Card;
import java.util.*;

public abstract class Card_Malus extends Card
{
	public Card_Malus(String name)
	{
		super(name,"Card_Malus") ;
	}
	
	protected boolean sameCard(Vector<Vector<Card>> x, Card e)
	{
		for(int i = 0 ; i < x.elementAt(2).size() ; i++)
		{
			if(x.elementAt(2).elementAt(i).getName().equals(e.getName())) return true ;
		}
		
		return false ;
	}
	
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
