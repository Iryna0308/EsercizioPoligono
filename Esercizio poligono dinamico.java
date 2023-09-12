package classePoligono;

/**
 * Si rende disponibile una classe Punto caratterizzata 
 * da un nome di un solo carattere e due coordinate di 
 * tipo double con i seguenti metodi
 * 
 * COSTRUTTORI
 * *** public Punto(char , double , double ) 
 * Crea un oggetto di tipo Punto con nome e 
 * coordinate
 * 
 * *** public Punto (char ) -> Crea un oggetto di tipo
 * punto col solo nome: le coordinate andranno date
 * con i metodi forniti.
 * 
 * ALTRI METODI
 * *** public double muovi (double , double )
 * Sposta il punto alle nuove coordinate e restituisce 
 * la distanza rispetto al punto precedente
 * 
 * *** public double muovi (char , double )
 * Sposta il punto su una coordinata data, x o y,
 * e restituisce la nuova coordinata
 * 
 * *** public double calcolaDistanza (double , double )
 * Prende le coordinate di un altro punto e restituisce 
 * la distanza di questo rispetto al nostro
 * 
 * *** public double calcolaDistanza (Punto )
 * Prende un oggetto di tipo Punto e restituisce la
 * distanza di questo rispetto al nostro
 * 
 * GETTER
 * 
 * *** public char getNome() -> Da il valore del nome 
 * del nostro punto 
 * 
 * *** public double getX() -> Da il valore della
 * coordinata x del nostro punto
 * 
 * *** public double getY() -> Da il valore della
 * coordinata y del nostro punto
 * 
 * SETTER
 * 
 * *** public void setNome(char ) -> Permette di
 * modificare il nome con quello preso in input
 * 
 * *** public void setX(double ) -> Permette di
 * modificare la coordinata x con quella presa
 * in input
 * 
 * *** public void setY(double ) -> Permette di
 * modificare la coordinata y con quella presa
 * in input
 * 
 * STAMPA - toString
 * 
 * *** public String toString() -> Restituisce il
 * punto in formato scrtinga secondo lo schema
 * nome(x, y);
 * 
 * @author Roberto Musa
 *
 */

/**
 * Data la classe Punto documentata sopra si crei
 * una CLASSE Poligono che, presi in input il 
 * numero di lati della figura memorizzi i suoi 
 * punti e permetta di conoscere tramite appositi
 * metodi il perimetro e l'elenco dei punti agli 
 * angoli della figura.
 * 
 * @author Roberto Musa
 *
 */

/**
 * Con la classe Poligono creata si proceda a 
 * chiedere tramite input da tastiera il numero
 * di lati della figura, i suoi angoli e si 
 * scrivano su schermo l'elenco dei punti ed il 
 * perimetro.
 * 
 * @author Roberto Musa
 *
 */

public class ClassePoligono {
	
	public static class Punto {
		// Dichiarazione degli Attributi
		private char nome;
		private double x, y;
		/**
		 *  Gli attributi devono essere private per proteggerli
		 *  da manipolazione esterna e vanno gestiti tramite
		 *  metodi public (incapsulamento)
		 */
		
		// metodo costruttore
		/**
		 * Il costruttore è un metodo particolare che restituisce
		 * un oggetto del tipo della classe che stiamo definendo,
		 * per questo non si indica il tipo restituito.
		 * Può prendere come input dei parametri che vanno a 
		 * caratterizzare l'ggetto. Nel nostro caso:
		 * @param nome
		 * @param x
		 * @param y
		 * Nel nostro esempio riempiremo gli attributi dell'oggetto
		 * in creazione con i valori passati.
		 * Per richiamare il costruttore fuori dalla definizione della
		 * classe si usa il comando new Classe(), per richiamarlo 
		 * internamente alla definizione della classe usiamo this().
		 */
		public Punto(char nome, double x, double y) {
			super(); 
			/** 
			 * Non è necessario richiamare il costruttore di Object,
			 * da cui stiamo ereditando implicitamente, ma il costruttore 
			 * del genitore, nel caso, si richiama con il comando "super()"
			 */
			setNome(nome);
			setX(x);
			setY(y);
			/** 
			 * Internamente alla classe potrei manipolare gli attributi ma
			 * posso anche usare i metodi definiti (in questo caso i setter
			 * dei miei attributi privati
			 */
		}
		
		public Punto (char nome) {
			/**
			 * setNome(nome);
			 * setX(0);
			 * setY(0);
			 */
			this(nome, 0, 0);
			/**
			 * Tramite this(), a cui passiamo gli opportuni parametri,
			 * possiamo chiamare i costruttori della nostra classe.
			 * In questo caso va a semplificare le azioni nel primo 
			 * commento perché, di fatto, sono le stesse istruzioni del
			 * primo costruttore ma con x ed y a 0.
			 */
		}
		
		// altri metodi
		
		/**
		 * Il metodo muovi è pubblico, prende in input le nuove coordinate
		 * @param x
		 * @param y
		 * @return distanza dal punto precedente corrispondente all'ipotenusa 
		 * del triangolo ideale formato da questa e dalla differenza tra le 
		 * coordinate x ed y dei due punti
		 */
		
		public double muovi (double x, double y) {
			// sposta il punto e restituisce la distanza di cui si è mosso
			double cateto1 = this.x - x;
			double cateto2 = this.y - y;
			this.x = x;
			this.y = y;
			return Math.sqrt((cateto1*cateto1)+(cateto2*cateto2));
		}
		
		/**
		 * Muove un punto in una direzione orizzontale (x) o verticale (y)
		 * @param coord -  Quale coordinata voglio variare
		 * @param val - di quanto voglio variare la coordinata
		 * @return la nuova coordinata
		 */
		
		public double muovi (char coord, double val) {
			if (coord == 'x') {
				x = x + val;
				return x;
			} else if (coord == 'y') {
				y = y + val;
				return y;
			} else {
				return 0.0;
			}
		}
		
		/**
		 * Il metodo calcolaDistanza è pubblico, 
		 * prende in input le coordinate rispetto 
		 * a cui calcolare la distanza
		 * @param x
		 * @param y
		 * @return distanza dal punto passato
		 */
		
		public double calcolaDistanza (double x, double y) {
			double cateto1 = this.x - x;
			double cateto2 = this.y - y;
			return Math.sqrt((cateto1*cateto1)+(cateto2*cateto2));
		}
		
		/**
		 * Polimorfismo -  Variante di calcolaDistanza()
		 * @param p di tipo Punto da cui estrarre
		 * le coordinate X ed Y tramite i rispettivi
		 * getter per richiamare l'altra calcolaDistanza
		 */
		
		public double calcolaDistanza (Punto p) {
			return calcolaDistanza(p.getX(), p.getY());
		}
		
		// Metodi getter e setter
		
		/**
		 * Questi metodi servono alla lettura o scrittura
		 * degli attributi private.
		 * In questo caso x ed y accettano tutti i numeri reali
		 * (double) quindi non serve un controllo ma i setter,
		 * le funzioni di scrittura, possono fare un controllo
		 * preventivo alla modifica per verificare se il valore
		 * che si vuole scrivere è valido (Es. Sesso, in una classe
		 * persona è 'm' o 'f' non esiste un sesso 'z').
		 */

		public char getNome() {
			return nome;
		}

		public void setNome(char nome) {
			this.nome = nome;
		}
		
		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}
		
		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
		
		public String toString() {
			return getNome() + "(" + getX()+", "+getY()+");\n";
		}
	}

	public static void main(String[] args) {

	}

}
