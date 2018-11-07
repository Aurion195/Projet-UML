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
		System.out.println(type);
	}
	
	/**
	 * @return le nom de la carte
	 */
	public String getName()
	{
		return this.name ;
	}
	
	/**
	 * @return le type de la carte
	 */
	public String getType()
	{
		return this.type ;
	}
	
	/**
	 * Change le nom de la carte
	 * @param name = nouveau nom ;
	 */
	public void setName(String name)
	{
		this.name = name ;
	}
	
	/**
	 * Change le type de la carte
	 * @param type = nouveau type ;
	 */
	public void setType(String type)
	{
		this.type = type ;
	}
}
