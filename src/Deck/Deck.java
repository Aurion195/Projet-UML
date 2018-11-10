package Deck;
import java.util.*;

/**
 * Classe réprésentant la pioche du jeu, contient toutes les cartes au début
 * puis aprés distribution va les donner au Player
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 */
public class Deck 
{
	/**
	 * vector contenant toutes les cartes
	 */
	Vector<Card> card ;
	
	/**
	 * Constructeur de la classe Deck
	 */
	public Deck() 
	{
		this.card = new Vector<Card> () ;
		this.addCard();
	}

	/**
	 * Vérifie si le vector de card est vide
	 * @return true s'il y a plus de carte / false sinon
	 */
	public boolean vide()
	{
		return(card.isEmpty() ? true : false) ;
	}
	
	/**
	 * Rajoute la carte jétée par le joueur au début du jeu
	 * @param e = carte jetée par la personne ;
	 */
	public void jetteCard(Card e)
	{
		this.card.insertElementAt(e, 0);
	}
	
	/**
	 * Pioche une carte
	 * @return le premier élément de la pioche
	 */
	public Card pioche()
	{
		return card.remove(card.size()-1) ;
	}
	
	/**
	 * Ajoute au vecteur toutes les cartes pour avancer
	 */
	private void addCardForwad()
	{
		for(int i = 0 ; i < 10 ; i++)
		{
			this.card.addElement(new Card_Forward("25"));
		}
		
		for(int i = 0 ; i < 10 ; i++)
		{
			this.card.addElement(new Card_Forward("50"));
		}
		
		for(int i = 0 ; i < 10 ; i++)
		{
			this.card.addElement(new Card_Forward("75"));
		}
		
		for(int i = 0 ; i < 12 ; i++)
		{
			this.card.addElement(new Card_Forward("100"));
		}
		
		for(int i = 0 ; i < 4 ; i++)
		{
			this.card.addElement(new Card_Forward("200"));
		}	
	}
	
	/**
	 * Ajoute les cartes Malus
	 */
	private void addCardMalus()
	{
		for(int i = 0 ; i < 3 ; i++)
		{
	
			this.card.addElement(new Card_Malus("Panne de réveil"));
		}
		
		for(int i = 0 ; i < 3 ; i++)
		{
			this.card.addElement(new Card_Malus("Travaux"));
		}
		
		for(int i = 0 ; i < 3 ; i++)
		{
			this.card.addElement(new Card_Malus("Maladie"));
		}
		
		for(int i = 0 ; i < 3 ; i++)
		{
			this.card.addElement(new Card_Malus("Réseaux down"));
		}
		
		for(int i = 0 ; i < 4 ; i++)
		{
			this.card.addElement(new Card_Malus("Fête de trop"));
		}	
	}
	
	/**
	 * Ajoute les cartes Bonus
	 */
	private void addCardBonus()
	{
		for(int i = 0 ; i < 6 ; i++)
		{
			this.card.addElement(new Card_Bonus("Pile Atomique"));
		}
		
		for(int i = 0 ; i < 6 ; i++)
		{
			this.card.addElement(new Card_Bonus("Bus Magique"));
		}
		
		for(int i = 0 ; i < 6 ; i++)
		{
			this.card.addElement(new Card_Bonus("Mot du docteur"));
		}
		
		for(int i = 0 ; i < 14 ; i++)
		{
			this.card.addElement(new Card_Bonus("Réseau Up"));
		}
		
		for(int i = 0 ; i < 6 ; i++)
		{
			this.card.addElement(new Card_Bonus("Paracétamol"));
		}
	}
	
	/**
	 * Ajoute les cartes Immunité
	 */
	private void addCardImmu()
	{
		this.card.addElement(new Card_Immu("Couche-tôt"));
		this.card.addElement(new Card_Immu("Hélicoptère"));
		this.card.addElement(new Card_Immu("Santé de fer"));
		this.card.addElement(new Card_Immu("Proxy"));
	}
	
	/**
	 * Ajoute les cartes au DECK
	 */
	public void addCard()
	{
		this.addCardForwad() ;
		this.addCardBonus() ;
		this.addCardMalus() ;
		this.addCardImmu() ;
		
		Collections.shuffle(card);
	}
}
