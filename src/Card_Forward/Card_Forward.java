package Card_Forward;

import Deck.Card;
import java.util.*;

public abstract class Card_Forward extends Card
{
	String name ;
	
	public Card_Forward(String name)
	{
		super(name,"Card_Forward") ;
		this.name = name ;
	}
	
	
}
