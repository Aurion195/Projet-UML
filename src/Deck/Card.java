package Deck;

public abstract class Card 
{
	String name ;
	String type ;
	
	public Card(String name)
	{
		this.name = name ;
		this.type = this.getClass().getName() ;
	}
	
	
}
