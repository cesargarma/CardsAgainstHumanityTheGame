package com.example.cardsagainsthumanity;

import com.example.cardsagainsthumanity.Cards;

/**
 * Constructor de los jugadores<br/>
 * tiene datos preestablecidos para generar jugadores por default<br/>
 * Es una clase "intermediaria" ya que los jugadores una vez son creados como tal,
 * solo se les incrementa la puntuacion, y se les cambia el rango de master<br/>
 * Por lo que quitando eso, esta clase solo es un "enlaze" entre el juego y las cartas, que son las verdaderas protagonistas
 *
 * @author Golthork
 * @author Daasty
 * @version 1.0
 */



public class Player {

    /**
     * Nombre del jugador <br/>
     * Por defecto pone el nombre Player (0...n)<br/>
     * El numero es el turno en el que jugaría.
     */
    private String name = "Player";

    /**
     * Turno en el que juega cada jugador
     */
    private int turn = 0;

    /**
     * Numero de cartas en la mano
     */
    private int nCards = 0;

    /**
     * Indica si es el turno del jugador. <br/>
     * Los master de cada turno, lo deben tener en FALSE durante todo ese turno.
     */
    private boolean myTurn = false;

    /**
     * Puntuacion de cada jugador
     */
    private int score = 0;

    /**
     * Indica si es el master de esta ronda
     */
    private boolean master = false;

    /**
     * Cartas en la mano del jugador
     */
    private String[] cards = new String[10];

    /**
     * En caso de que sea master, es la carta negra elegida para esa ronda.
     */
    private String blackCard = "";

    ///////////////
    //CONSTRUCTOR//
    ///////////////

    /**
     * Crea un jugador con los datos por defecto
     *
     * @see #Player(String, int)
     */
    @Deprecated
    public Player() {
    }


    //overload

    /**
     * Crea el objeto jugador, dandole un nombre y los demas valores por defecto.
     *
     * @param name  Es el nombre que se le asigna al objeto Player
     *
     * @see #Player(String, int)
     */
    @Deprecated
    public Player(String name) {
        this.name = name;
    }

    /**
     * Sobrecarga del contructor, este es el metodo utilizado en caso de querer asignar un nombre al jugador<br/>
     * Asigna el nombre, la cantidad de cartas en mano, y crea un vector para guardas las cartas que tiene en la mano.
     *
     * @param name  Nombre que se le asigna al jugador
     * @param nCards    Numero de cartas en la mano, y tamaño del vector que almacena dichas cartas
     */
    public Player(String name, int nCards) {
        this.name = name;
        this.nCards = nCards;
        this.cards = new String[nCards];
    }

    public Player(int nCards) {
        this.nCards = nCards;
        this.cards = new String[nCards];
    }

    ///////////
    //SETTERS//
    ///////////

    public void setTurn(int turn) {
        this.turn = turn;
        this.name = name + " " + this.turn;
    }

    public void setMaster() {
        this.master = !this.master;
    }

   /* public void setMasterFalse(){
        this.master = false;
    }*/

    //Le das una posicion (indica la posicion de la carta en el array de cartas en mano
    //y solicita una nueva carta para esa posicion.

    /**
     * Le pasamos una posicion del array, y solicitamos una nueva carta para poner en esa posicion.
     *
     * @param pos   Posicion del array en el que queremos poner la nueva carta.
     */
    public void setCards(int pos) {
        this.cards[pos] = Cards.getWhiteCard();
    }

    /**
     * Hace lo mismo que el metodo setCards() pero con cartas negras, al ser solo una carta negra, no es necesario pasarle una posicion
     *
     * @see #setCards(int)
     */
    public void setBlackCards() {
        this.blackCard = Cards.getBlackCard();
    }

    public void setScore(){
        this.score++;
    }

    ///////////
    //GETTERS//
    ///////////

    public String getName() {
        return name;
    }

    public int getnCards() {
        return nCards;
    }

    public int getTurn() {
        return turn;
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public int getScore() {
        return score;
    }

    public boolean isMaster() {
        return master;
    }

    public String getCards(int pos) {
        return this.cards[pos];
    }

    public int getnCardsOnHand(){
        return this.cards.length;
    }

    public String getBlackCard(){
        return this.blackCard;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nNumber of cards: " + nCards + "\nScore: " + score + "\nMaster: " + isMaster();
    }
}
