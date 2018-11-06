package Deck;

/**
 * Classe abstraite de carte qui va servir a définir toutes les autres cartes
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 */
public abstract class Card 
{
	/**
	 * Nom de la carte
	 */
	String name ;
	
	/**
	 * Type de la carte
	 */
	String type ;
	
	
	
	/**
	 * Constructeur de la classe card
	 * @param name = nom de la carte ;
	 */
	public Card(String name)
	{
		this.name = name ;
		this.type = this.getClass().getName() ;
	}
	
	
}
