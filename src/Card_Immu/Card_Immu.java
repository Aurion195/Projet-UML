package Card_Immu;

import java.util.*;
import Deck.Card;

public abstract class Card_Immu extends Card
{
	String name ;
	
	public Card_Immu(String name)
	{
		super(name,"Card_Immu") ;
		this.name = name ;
	}
	
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
