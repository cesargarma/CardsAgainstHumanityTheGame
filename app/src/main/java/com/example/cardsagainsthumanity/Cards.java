package com.example.cardsagainsthumanity;

import java.util.Random;

/**
 * Estaclase es utilizada casi como si fuese una base de datos
 * Almacena dos arrays con los Strings de las cartas blancas y negras
 * Para cartas blncas y negras, tiene dos arrays para cada uno,
 * Se podrian apliar a 3 para cada uno con el tiempo
 * En el segundo array se almacenan las cartas que ya se han jugado
 * Tiene los metodos de elegir una carta aleatoria y cambiarla de array
 *
 * POSIBILIDADES:
 *      Crear un tercer array intermediario donde almacenar las cartas en mano de los jugadores que no han sido jugadas aun
 *
 *      No crear un tercer array, y poner un metodo que cuando se vacie el primero, automaticamente vuelva a llenarlo
 *              PROBLEMAS:
 *                  Posibilidad de cartas repetidas en mano de los jugadores
 *              VENTAJAS:
 *                  Si no se limita el numero de cartas blancas en mano, este metodo quita quebraderos de cabeza
 *
 * @author Golthork
 * @author Daasty
 * @version 1.0
 */



public class Cards {
   private static String[] white = {
            "Aznar",
            "Monaguillos sin dientes",
            "Esmegma",
            "El KKK",
            "11-M",
            "11-S",
            "Una piscina llena de bebés muertos",
            "Cosas nazis",
            "Cards Against Humanity",
            "Vin Diesel",
            "Lesbianas nazis borrachas que dan palizas",
            "Notre Dame on fire",
            "Un trabajo penoso",
            "Despertarse medio desnudo en el parking del Burguer King",
            "Esclavitud",
            "Una orgía en la que una persona tiene sida",
            "Su Majestad la Reina Isabel II"};

   private static String[] white2 = new String[white.length];

   private static String[] black = {
            "La recuperación comenzó cuando me uní a un grupo de apoyo de _____",
            "Solo hay dos certezas en la vida: La muerte y _____",
            "Amarte es facil, porque eres _____",
            "La vida de los indios americanos cambió cuando los colonizadores introdujeron _____"};

   private static String[] black2 = new String[black.length];


   public static String getWhiteCard(){
        int rng = -1;
        do{
            rng = randomNumber(white.length);
        }while(white[rng].equals(""));

        white2[rng] = white[rng];
        white[rng] = "";
        refillArray(white, white2);
        return white2[rng];
   }


   public static String getBlackCard(){
       int rng = -1;
       do{
           rng = randomNumber(black.length);
       }while(black[rng].equals(""));

       black2[rng] = black[rng];
       black[rng] = "";
       refillArray(black,black2);
       return black2[rng];
   }

    private static int randomNumber(int rango){
        Random random = new Random();
        return random.nextInt(rango);
    }

    /**
     * recibe dos arrays,correspondientes a los dos de cartas blancas o los dos de cartas negras
     * si en el primer array no quedan cartas, copia el segundo array en el primero
     *
     * @param array Array primario, donde empiezan todas las cartas
     * @param array2    Array secundario, donde se almacenan aquellas cartas ya usadas.
     */
    private static void refillArray(String [] array, String [] array2){
       boolean sw = true;

        for (int i = 0; i < array.length; i++) {
            if(array[i] != ""){
                sw = false;
                break;
            }
        }
        if(sw){
            for (int i = 0; i < array.length; i++) {
                array[i] = array2[i];
            }
        }
    }
}
