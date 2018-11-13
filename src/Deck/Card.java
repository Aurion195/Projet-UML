package Deck;

import java.util.Vector;

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
	public Card(String name, String type)
	{
		this.name = name ;
		this.type = type ;
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
	
	public abstract boolean canDefend(Vector<Vector<Card>> x) ;
	public abstract boolean canForward(Vector<Vector<Card>> x) ;
	public abstract boolean canAttaque(Vector<Vector<Card>> x) ;
	public abstract boolean canImmu(Vector<Vector<Card>> x) ;
}
