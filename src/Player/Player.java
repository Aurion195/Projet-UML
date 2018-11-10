package Player;
import Deck.*;
import java.util.* ;

/**
 * Classe player
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 */

public abstract class Player 
{
	/**
	 * Nom du joueur
	 */
	String name ;
	
	/**
	 * Type du joueur (IA / humain)
	 */
	String type ;
	
	/**
	 * Pseudo du joueur
	 */
	String pseudo ;
	
	/**
	 * Score du joueur
	 */
	int scorePlayer ;
	
	/**
	 * Vector contenant toutes les cartes du joueur
	 */
	Vector<Card> card ;
	
	/**
	 * Tableau du joueur, chaque joueur en a un
	 */
	Vector<Vector<Card>> plateau ;
	
	
	/**
	 * Constructeur du Player
	 * @param name = nom du joueur ;
	 * @param pseudo = pseudo du joueur ;
	 */
	public Player(String name, String pseudo)
	{
		this.name = name ;
		this.pseudo = pseudo ;
		this.scorePlayer = 0 ;
		this.type = this.getClass().getName() ;
		this.card = new Vector<Card>() ;
		this.constructeurPlateau() ;
	}
	
	/**
	 * Initialise le plateau du joueur, en y insérant le vector de card
	 */
	public void constructeurPlateau()
	{
		plateau = new Vector<Vector<Card>>() ;
		plateau.addElement(new Vector<Card>());
		plateau.addElement(new Vector<Card>());
		plateau.addElement(new Vector<Card>());
		plateau.addElement(new Vector<Card>());
	}
	
	/**
	 * @return true / false si le joueur à atteint les 1000go
	 */
	public boolean win()
	{
		return(this.scorePlayer == 1000 ? true : false) ;
	}

	/**
	 * Ajoute une carte au deck du joueur
	 * @param e = carte à ajouter ;
	 */
	public void addCard(Card e)
	{
			card.addElement(e);
	}
	
	/**
	 * Affiche le vector de carte du joueur
	 */
	public void displayDeck()
	{
		for(int i = 0 ; i < card.size() ; i++)
		{
			System.out.println(card.elementAt(i).getName());
		}
	}
	
	/**
	 * Affiche le plateau de chaque joueur
	 */
	public void displayPlateau()
	{
		for(int i = 0 ; i < plateau.size() ; i++)
		{
			System.out.print(i+" - ");
			for(int j = 0 ; j < plateau.elementAt(i).size() ; j++)
			{
				System.out.print(plateau.elementAt(i).elementAt(j).getName()+"            ");
			}
			System.out.println();
		}
		
		System.out.println("\n \n");
	}
	
	/**
	 * Va vérifier que tmp peut être un string contenu dans la vecteur de card
	 * @param tmp = string contenant le choix du joueur ;
	 * @return true s'il a choisit la bonne carte
	 */
	private boolean chooseCard(String tmp)
	{
		int x = 0 ;
		
		try {
			x = Integer.parseInt(tmp) ;
			return((x >= 0 && x < card.size()) ? true : false) ;
		}
		catch(Exception e)
		{
			System.out.println("erreur");
			System.out.println(e.getMessage());
			return false ;
		}

	}
	
	/**
	 * Cette fonction supprime la carte choisit par le personnage, permet d'éviter de perdre
	 * des cartes au cour du jeu
	 * @param e = carte choisit par le joueur ;
	 */
	public void delCard(Card e)
	{
		for(int i = 0 ; i < card.size() ; i++)
		{
			if(card.elementAt(i).getName().equals(e.getName()))
			{
				card.removeElementAt(i);
			}
		}
	}
	/**
	 * Regarde si le joueur n'a pas de carte RU, s'il n'en a pas 
	 * le jeu va proposer au joueur de lui poser !
	 * @return true / false 
	 */
	private Card reseauUp()
	{
		String tmp = "" ;

		do {
			Scanner sc = new Scanner(System.in) ;
			System.out.println("Voullez-vous poser la carte Réseau Up ? (o/n)");
			tmp = sc.nextLine() ;
		}while(!tmp.equals("o") && !tmp.equals("n")) ;

		if(tmp.equals("o"))
		{
			for(int i = 0 ; i < card.size() ; i++)
			{
				if(card.elementAt(i).getName().equals("Réseau Up"))
				{
					Card e = card.elementAt(i) ;
					return e ;
				}
			}
		}

		return null ;
	}
	
	/**
	 * @return la carte que le joueur a choisit de jouer
	 */
	public Card chooseCard()
	{
		String tmp = "" ;
		
		if(plateau.elementAt(0).isEmpty())
		{
			Card e = this.reseauUp() ;
			if(e != null)
			{
				System.out.println("Le joueur pose la carte Réseau Up");
				return  e ;
			}
		}
		
		do {
			Scanner sc = new Scanner(System.in) ;
			for(int i = 0 ; i < card.size() ; i++)
			{
				System.out.println(i+" -          "+card.elementAt(i).getName());
			}
			
			System.out.println("\n"+"Entrer une valeur : ");
			tmp = sc.nextLine() ;
		} while(!this.chooseCard(tmp)) ;
		
		Card e = card.elementAt(Integer.parseInt(tmp)) ;
		return e ;
	}
	
	/**
	 * @param tmp = String contenant le choix du joueur ;
	 * @param i = taille du vector de joueur
	 * @return true s'il a bien choisit un joueur / false sinons
	 */
	private boolean choosePlayer(String tmp, int i) throws Exception
	{
		int x = 0 ;
		
		try {
			x = Integer.parseInt(tmp) ;
			return(x >= 0 && x < i ? true : false) ;
		}
		catch(Exception e)
		{
			System.out.println("Entrer un chiffre");
			return false ;
		}
	}
	
	/**
	 * @param p = vector de joueur de la partie ;
	 * @param x = Entier contenant la position du joueurs courant ;
	 * @return le plateau du joueur qui a été choisi
	 * @throws Exception 
	 */
	public Vector<Vector<Card>> choosePlayer(Vector<Player> p, int x) throws Exception
	{
		String tmp = ""; 
		
		do {
			Scanner sc = new Scanner(System.in) ;
			for(int i = 0 ; i < p.size(); i++)
			{
				if(i != x) System.out.println(i+" -             "+p.elementAt(i).getName());
			}
			System.out.println("\n"+"Choisissez un joueur : ");
			tmp = sc.nextLine() ;
		} while(!this.choosePlayer(tmp, p.size())) ;
		
		return p.elementAt(Integer.parseInt(tmp)).getPlateau() ;
 	}
	
	
	/**
	 * @param tmp = String contenant le type ;
	 * @return true s'il peut attaquer / false sinon 
	 */
	private boolean canAttaque(String tmp,Vector<Player> p)
	{
		if(tmp.equals("Dack.Fete_De_Trop")) return true ;
		
		for(int i = 0 ; i < p.size() ; i++)
		{
			Vector<Vector<Card>> x = p.elementAt(i).getPlateau() ;
			if(!x.isEmpty())
			{
				if(!x.elementAt(0).isEmpty() && tmp.equals("Deck.Card_Malus"))
				{
					return true ;
				}
			}
		}
		return false ;
	}
	
	/**
	 * @param tmp = String contenant le nom de la carte
	 * @return true s'il peur avanacer / false sinon
	 */
	private boolean canForward(String tmp)
	{
		return((tmp.equals("25") || tmp.equals("50") || tmp.equals("75") || 
				tmp.equals("100") || tmp.equals("200")) ? true : false ) ;
	}
	
	private boolean cardRuActive(Vector<Player> p)
	{
		for(int i = 0 ; i < p.size() ; i++)
		{
			Vector<Vector<Card>> tmp = p.elementAt(i).getPlateau() ;
			for(int j = 0 ; j < tmp.size() ; i++)
			{
				if(!tmp.elementAt(0).isEmpty()) return true ;
			}
		}
		
		return false ;
	}
	
	/**
	 * Permet de regarder si le player peut jouer ou non, en fonction du
	 * tableau du player
	 * @return true si le joueur peut jouer / false s'il ne peut pas
	 */
	public boolean canPlay(Vector<Player> p)
	{
		if(plateau.elementAt(0).isEmpty())
		{
			for(int i = 0 ; i < card.size(); i++)
			{
				if(card.elementAt(i).getName().equals("Réseau Up") || (this.canAttaque(card.elementAt(i).getName(),p) && this.cardRuActive(p)))
				{
					return true ;
				}
			}
		}
		else
		{
			for(int i = 0 ; i < card.size(); i++)
			{
				if(this.plateau.elementAt(2).isEmpty() && this.canForward(card.elementAt(i).getName())) return true ;
				
				if(this.canAttaque(card.elementAt(i).getName(), p)) return true ;
				
				if(this.card.elementAt(i).getName().equals("Fête de trop")) return true ;
			}
		}
		
		return false ;
	}
	
	/**
	 * Place une card dans le plateau de joueur ;
	 * @param e = card à placer ;
	 * @param x = int ou on va placer la card ;
	 */
	public void placeCard(Card e, int x)
	{
		if(x == 1)
		{
			scorePlayer += Integer.parseInt(e.getName()) ;
			
		}
		this.delCard(e) ;
		plateau.elementAt(x).addElement(e);
	}
	/**
	 * Ajoute une carte à la pioche
	 * @param e = carte à ajouter ;
	 */
	public void pioche(Card e)
	{
		this.card.addElement(e);
	}
	
	/**
	 * @param tmp = choix du joueur ;
	 * @return true si le joueur valide / false sinon
	 */
	private boolean valideJetteCard(String tmp)
	{
		return((tmp.equals("y") || tmp.equals("n") || tmp.equals("Y") || tmp.equals("N")) ? true : false) ;
	}
	
	/**
	 * Le joueur va jeter une card de son deck, la fonction va donc permettre de choisir la carte
	 * et de la supprimer du vecteur de carte du joueur
	 */
	public Card jetteCard()
	{
		int x = 0 ;
		String tmp = "" ;
		String choix = "" ;
		
		do {
			Scanner sc = new Scanner(System.in) ;
			
			boolean ok = false ;
			
			do {
				for(int i = 0 ; i < card.size() ; i++)
				{
					System.out.println(i+" -             "+card.elementAt(i).getName());
				}
				System.out.println("Entrer le numéro de la carte : ");
				tmp = sc.nextLine() ;

				try {
					x = Integer.parseInt(tmp) ;
					if(x >= 0 && x < card.size()) ok = true ;
				}
				catch(Exception e)
				{
					System.out.println("Entrer une valeur entière ! ");
				}
			} while(!ok) ;
			
			
			System.out.println("Etes-vous sur ? (y/n) :");
			choix = sc.nextLine() ;
		} while(this.valideJetteCard(choix)) ;
		
		Card e = card.elementAt(x) ;									//On envoie la carte que l'on veut enlever
		card.removeElementAt(x);										//On supprime la carte du vecteur
		
		return e ;
	}
	
	/**
	 * @return le nom du joueur
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @return le type du joueur
	 */
	public String getType() 
	{
		return type;
	}

	/**
	 * @return le pseudo du joueur
	 */
	public String getPseudo() 
	{
		return pseudo;
	}

	/**
	 * @return le score du joueur
	 */
	public int getScorePlayer() 
	{
		return scorePlayer;
	}

	public Vector<Vector<Card>> getPlateau()
	{
		return this.plateau ;
	}
	
	/**
	 * @param name the name to set
	 */
 	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Change le type de Player
	 * @param type = nouveau type ;
	 */
	public void setType(String type) 
	{
		this.type = type;
	}

	/**
	 * change le pseudo du player
	 * @param pseudo = nouveau pseudo ;
	 */
	public void setPseudo(String pseudo) 
	{
		this.pseudo = pseudo;
	}

	/**
	 * Change le score du player
	 * @param scorePlayer = nouveau score ;
	 */
	public void setScorePlayer(int scorePlayer) 
	{
		this.scorePlayer = scorePlayer;
	}
	
	
}
