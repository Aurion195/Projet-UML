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
	 * @param type = permet de définir le type de la carte ;
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
	
	/**
	 * Fonction qui est propre au carte de défense, elle permet de savoir si le joeur peut se défendre avec la carte qu'il a choisit
	 * @param x = plateau du joueur ;
	 * @return true s'il peut / false sinon
	 */
	public abstract boolean canDefend(Vector<Vector<Card>> x) ;
	
	/**
	 * Fonction qui est propre au carte d'avance elle permet de savoir si le joeur avancer avec la carte qu'il a choisit
	 * @param x = plateau du joueur ;
	 * @return true s'il peut / false sinon
	 */
	public abstract boolean canForward(Vector<Vector<Card>> x) ;
	
	/**
	 * Fonction qui est propre au carte de d'attaque, elle permet de savoir si le joeur attaquer peut se recevoir ce malus
	 * @param x = plateau du joueur adverse ;
	 * @return true s'il peut / false sinon
	 */
	public abstract boolean canAttaque(Vector<Vector<Card>> x) ;
	
	/**
	 * Fonction qui est propre au carte d'immunité, elle permet de savoir si le joeur peut poser la carte et être immunis avec tout cela
	 * @param x = plateau du joueur ;
	 * @return true s'il peut / false sinon
	 */
	public abstract boolean canImmu(Vector<Vector<Card>> x) ;
}
