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
	
	public void addScore(int x)
	{
		this.scorePlayer += x ;
	}
	/**
	 * Vérifie si un joueur a atteint les 1000go
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
			return((x >= 0 && x <= card.size()) ? true : false) ;
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
				return ;
			}
		}
	}
	
	/**
	 * Permet au joueur de choisir une carte
	 * @return la carte que le joueur a choisit de jouer
	 */
	public Card chooseCard()
	{
		String tmp = "" ;
		
		do {
			Scanner sc = new Scanner(System.in) ;
			for(int i = 0 ; i < card.size() ; i++)
			{
				System.out.println(i+" -          "+card.elementAt(i).getName());
			}
			System.out.println(card.size()+" -          jetter une carte");
			System.out.println("\n"+"Entrer une valeur : ");
			tmp = sc.nextLine() ;
		} while(!this.chooseCard(tmp)) ;
		
		if(Integer.parseInt(tmp) == card.size())
		{
			this.jetteCard() ;
			return null ;
		}
		Card e = card.elementAt(Integer.parseInt(tmp)) ;
		return e ;
	}
	
	/**
	 * Permet de valider si le choix du joueur est un int ou non
	 * @param tmp = String contenant le choix du joueur ;
	 * @param i = taille du vector de joueur
	 * @param joueur = int contenant la place du joeur (eviter de se choisir)
	 * @return true s'il a bien choisit un joueur / false sinons
	 * @throws Exception = attrape l'exception !
	 */
	private boolean choosePlayer(String tmp, int i, int joueur) throws Exception
	{
		int x = 0 ;
		
		try {
			x = Integer.parseInt(tmp) ;
			return(x >= 0 && x < i && x != joueur ? true : false) ;
		}
		catch(Exception e)
		{
			System.out.println("Entrer un chiffre");
			return false ;
		}
	}
	
	/**
	 * Permet de choisir le joueur que l'on veut attaquer
	 * @param p = vector de joueur de la partie ;
	 * @param x = Entier contenant la position du joueurs courant ;
	 * @return le plateau du joueur qui a été choisi
	 * @throws Exception = attrape l'exception
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
		} while(!this.choosePlayer(tmp, p.size(), x) ) ;
		
		return p.elementAt(Integer.parseInt(tmp)).getPlateau() ;
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
	 * Fonction permettant de valider un choix
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
	 * @return la carte a jeter 
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
	 * Nom du joueur
	 * @return le nom du joueur
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Type du joueur
	 * @return le type du joueur
	 */
	public String getType() 
	{
		return type;
	}

	/**
	 * Pseudo du joueur
	 * @return le pseudo du joueur
	 */
	public String getPseudo() 
	{
		return pseudo;
	}

	/**
	 * Score du playeur
	 * @return le score du joueur
	 */
	public int getScorePlayer() 
	{
		return scorePlayer;
	}

	/**
	 * Plateau du joueur
	 * @return le plateau du joueur
	 */
	public Vector<Vector<Card>> getPlateau()
	{
		return this.plateau ;
	}
	
	/**
	 * Change le nom du joueur
	 * @param name = nouveau nom ;
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
