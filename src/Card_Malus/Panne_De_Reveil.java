package Card_Malus;

import java.util.*;
import Deck.Card;

public class Panne_De_Reveil extends Card_Malus 
{
	public Panne_De_Reveil()
	{
		super("Panne de réveil") ;
	}
	
	public boolean canAttaque(Vector<Vector<Card>> x)
	{
		if(!x.elementAt(0).isEmpty() && !super.sameCard(x,this)  && this.notImmu(x, "Couche-tôt"))
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
