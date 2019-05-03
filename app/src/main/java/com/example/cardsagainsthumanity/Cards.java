package com.example.cardsagainsthumanity;

import java.util.Random;

public class Cards {
   private static String[] white = {
           "Aznar",
           "Monaguillos sin dientes",
           "Esmegma",
           "El KKK",
           "11-M",
           "11-S"};
   private static String[] white2 = new String[white.length];

   private static String[] black = {
           "La recuperación comenzó cuando me uní a un grupo de apoyo de _____",
           "Solo hay dos certezas en la vida: La muerte y _____",
           "Amarte es facil, porque eres _____"};
   private static String[] black2 = new String[black.length];


   public int getWhiteLength(){
       return white.length;
   }

   public int getBlackLength(){
       return black.length;
   }

   public static String getWhiteCard(){
        int rng = -1;
        do{
            rng = randomNumber(white.length);
        }while(white[rng].equals(""));

        white2[rng] = white[rng];
        white[rng] = "";
        return white2[rng];
   }

   public String getBlackCard(){
       int rng = -1;
       do{
           rng = randomNumber(black.length);
       }while(black[rng].equals(null));
       black2[rng] = black[rng];
       black[rng] = null;
       return black2[rng];
   }

    private static int randomNumber(int rango){
        Random random = new Random();
        return random.nextInt(rango);
    }
}
