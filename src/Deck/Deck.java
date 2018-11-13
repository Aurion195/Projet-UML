package Deck;

import Card_Forward.* ;
import Card_Immu.*;
import Card_Bonus.* ;
import Card_Malus.* ;
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
		int x = card.size() -1 ;
		return card.remove(x) ;
	}
	
	/**
	 * Ajoute au vecteur toutes les cartes pour avancer
	 */
	private void addCardForwad()
	{
		for(int i = 0 ; i < 10 ; i++) this.card.addElement(new Vingt_Cinq());
		for(int i = 0 ; i < 10 ; i++) this.card.addElement(new Cinquante());
		for(int i = 0 ; i < 10 ; i++) this.card.addElement(new Soixante_Quinze());
		for(int i = 0 ; i < 12 ; i++) this.card.addElement(new Cent());
		for(int i = 0 ; i < 4 ; i++) this.card.addElement(new Deux_Cent() );
	}
	
	/**
	 * Ajoute les cartes Malus
	 */
	private void addCardMalus()
	{
		for(int i = 0 ; i < 3 ; i++) this.card.addElement(new Panne_De_Reveil());
		for(int i = 0 ; i < 3 ; i++) this.card.addElement(new Travaux());
		for(int i = 0 ; i < 3 ; i++) this.card.addElement(new Maladie());
		for(int i = 0 ; i < 3 ; i++) this.card.addElement(new Reseau_Down());
		for(int i = 0 ; i < 4 ; i++) this.card.addElement(new Fete_De_Trop());	
	}
	
	/**
	 * Ajoute les cartes Bonus
	 */
	private void addCardBonus()
	{
		for(int i = 0 ; i < 6 ; i++) this.card.addElement(new Pile_Atomique());
		for(int i = 0 ; i < 6 ; i++) this.card.addElement(new Bus_Magique());
		for(int i = 0 ; i < 6 ; i++) this.card.addElement(new Mot_Du_Docteur());
		for(int i = 0 ; i < 14 ; i++) this.card.addElement(new Reseau_Up());
		for(int i = 0 ; i < 6 ; i++) this.card.addElement(new Paracetamol());
		
	}
	
	/**
	 * Ajoute les cartes Immunité
	 */
	private void addCardImmu()
	{
		this.card.addElement(new Couche_Tot());
		this.card.addElement(new Helicoptere());
		this.card.addElement(new Sante_De_Fer());
		this.card.addElement(new Proxy());
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
