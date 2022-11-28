// Programmer: Nam Le & James Chen
// Date: 9/25/22
// Class: CS 145
// Assignment: Lab 1 Guessing Game
// Purpose: Create a guessing game
// Extra Credit: CRASH RESISTANT, TRY-CATCH STATEMENT, CREATIVITY

// Note: WE TRIED TO MAKE THE METHODS AS SMALL AS POSSIBLE, BUT RAN INTO
//       SOME DIFFICULTY SINCE WE COULDNT RETURN MULTIPLE VALUES,
//       WE FOUND THE WAIT METHOD ONLINE BECAUSE WE WANTED TO IMPLEMENT 
//       A LOADING SCREEN TO MAKE IT FEEL LIKE AN AUTHENTIC GAME

import java.util.Random; //allows you to generate a random number
import java.util.Scanner; // allows you to use the scanner to read user input

public class NLJCGuess {

    private static final int EASY = 25;
    private static final int MEDIUM = 50;
    private static final int HARD = 100;

    public static void main(String[] args) { 
      
      String answer = "";
      String question = "";
      int totalnumTries = 0;
      int numTries = 0;
      int gameCount = 0;
      int totalGuessCount = 0;
      int bestGuess = 10000000;
      int limit = 0;
      boolean firstgame = true; // determines pathway if it is their first game

      guessingGame(answer, question, totalnumTries, numTries, gameCount, 
      totalGuessCount, bestGuess, limit, firstgame);
    } // ends main


      // GUESSING GAME METHOD, 
      // based on the user's input either play the game or print results
      // NOTE: WE DON'T KNOW HOW TO MAKE THIS SMALLER
      public static void guessingGame(String answer, String question, int totalnumTries, int numTries,
      int gameCount, int totalGuessCount, int bestGuess, int limit, boolean firstgame) {
    
      int loop = 0;
      while (loop != 1) {
      
         answer = firstGame(firstgame, question, answer);

         if (answer.equalsIgnoreCase("Y")) { // ignores if y (the first character) is uppercase or lowercase
            limit = answerYes(limit, firstgame);
            numTries = playGame(limit,0); // returns numTries after the game has been played
            if (numTries < bestGuess) { 
               bestGuess = numTries; 
            }
            else {
            }
            totalnumTries += numTries; // adds the numtries to the total
            gameCount++;
            firstgame = false; // since this would be the first game played.
         } 
         else if (answer.equalsIgnoreCase("N")) {
           loop = answerNo(firstgame, gameCount, totalnumTries, bestGuess, loop);
         }
         else {
         invalid();
         wait(1500); // wait 1.5 seconds
         }
        } // end while loop
       } // ends main



      //FIRST GAME METHOD
      public static String firstGame(Boolean firstgame, String question, String answer) {

         Scanner game = new Scanner(System.in);  

         if (firstgame == true) {
            mainMenu();
            question = game.next();
            answer = question.substring(0,1); // finds the first character
         }
         else {
            question = game.next();
            answer = question.substring(0,1); // finds the first character
         }      
         return answer;
      }



      // ANSWER YES METHOD
      // if their answer starts with "y" print loading screen, instructions, and difficulty screen.
      public static int answerYes(int limit, boolean firstgame) {

         if(firstgame == true) { // if its their first game, print the loading screen.
            loadingScreen();
            wait(2000); // waits 2000 miliseconds or 2 seconds
            limit = difficulty(0);// returns limit
            instructions(limit); // uses the limit returned, in the instructions.
            wait(5000); // waits 5000 miliseconds or 4 seconds
         }
         else {
            limit = difficulty(0);
            instructions(limit);
            wait(5000); // waits 5 seconds before starting the game
         }
         return limit;
         }
      


      // ANSWER NO METHOD
      // If their answer starts with "n" print results or goodbye menu, and ends the loop
      public static int answerNo(boolean firstgame, int gameCount, int totalnumTries, 
      int bestGuess, int loop) {
       
         if (firstgame == false) {  
         results(gameCount, totalnumTries, bestGuess);
         }
         else { 
         goodBye();
         }
         loop++; 
         return loop;
         }
       


      // MAIN MENU METHOD
      public static void mainMenu() {
    
         for (int topDashes = 1; topDashes < 47; topDashes++) {
            System.out.print("~");
         }
            System.out.print("\n|                                            |");
            System.out.print("\n|                                            |");
            System.out.print("\n|               Guessing Game                |");
            System.out.print("\n|                  1 2 3...                  |");
            System.out.print("\n|                                            |");
            System.out.print("\n|                                            |");
            System.out.print("\n|                                            |");
            System.out.print("\n| Enter Yes to Start or No to Close The Game |\n");
         for (int bottomDashes = 1; bottomDashes < 47; bottomDashes++) {
         System.out.print("~");
         }
         System.out.println();
      } // end maiNMenu
     
      

      // LOADING SCREEN METHOD
      public static void loadingScreen() {
      
         for (int topDashes = 1; topDashes < 32; topDashes++) {
               System.out.print("~");
         }
               System.out.print("\n|                             |");
               System.out.print("\n|                             |");
               System.out.print("\n|           Loading           |");
               System.out.print("\n|            Game...          |");
               System.out.print("\n|                             |");
               System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
               System.out.print("~");
         }
         System.out.println();
       } // end loadingScreen
        

        
      // DIFFICULTY SCREEN METHOD
      public static void difficultyScreen() {
         
         for (int topDashes = 1; topDashes < 32; topDashes++) {
               System.out.print("~");
         }
               System.out.print("\n|                             |");
               System.out.print("\n|                             |");
               System.out.print("\n| Please Select a Difficulty! |");
               System.out.print("\n|    Easy, Medium or Hard!    |");
               System.out.print("\n|                             |");
               System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
               System.out.print("~");
         }
         System.out.println();
      } // end difficulty screen
      
      
      
      // GOODBYE SCREEN METHOD
      public static void goodBye() {
      
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|           Good              |");
            System.out.print("\n|             Bye!            |");
            System.out.print("\n|                             |");
            System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
      } // end goodBye
      

      
      // INVALID SCREEN METHOD
      // Pprints this menu for invalid responses
      public static void invalid() {
         
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
            System.out.print("\n|                             |");
            System.out.print("\n|     Please Enter Either     |");
            System.out.print("\n|          Yes Or No          |");
            System.out.print("\n|             ...             |");
            System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
         System.out.println(); 
      } // ends invalid


      
      // INSTRUCTION METHOD
      public static int instructions(int limit) {
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
         if (limit > 99) {
          System.out.print("\n|                             |");
            System.out.print("\n|  I Will Think Of A Number   |");
            System.out.print("\n|      Between 1 And " + limit + "      |");
            System.out.print("\n|   Guess The Number To Win!  |");
            System.out.print("\n|            ...              |");
            System.out.print("\n|                             |\n");
         }
         else {
            System.out.print("\n|                             |");
            System.out.print("\n|  I Will Think Of A Number   |");
            System.out.print("\n|      Between 1 And " + limit + "       |");
            System.out.print("\n|   Guess The Number To Win!  |");
            System.out.print("\n|            ...              |");
            System.out.print("\n|                             |\n");
         }
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
         return limit;
         } // ends instruction
    


    // DIFFICULT METHOD
    // determines difficulty based on user's input
    public static int difficulty(int limit) {
      
      Scanner game = new Scanner(System.in); 
      String difficultyAnswer;
      String difficulty;
      int difficultyLoop = 1;

      while (difficultyLoop == 1) {
         difficultyScreen();
         difficultyAnswer = game.next();
         difficulty = difficultyAnswer.substring(0,1);
                  
         if (difficulty.equalsIgnoreCase("E")) {
            limit = EASY;
            difficultyLoop++;
         }   
         else if (difficulty.equalsIgnoreCase("M")) {
            limit = MEDIUM;
            difficultyLoop++;
         }    
         else if (difficulty.equalsIgnoreCase("H")) {
            limit = HARD;
            difficultyLoop++;
         }
         else {
         }
    }
    return limit;
    }

    

    // PLAY GAME METHOD
    // generates a random number and asks user for guesses.
    // determines if the guess is correct or incorrect and displays
    // appropriate screens.
    // NOTE: WE DONT KNOW HOW TO MAKE THIS ANY SMALLER SINCE
    //       WE CAN'T RETURN MULTIPLE INTS
    public static int playGame(int limit, int numTries) {
    
      Scanner game = new Scanner(System.in); 
      int random = 0;
      random = numberChosen(limit, random);
      int guess;
      guess = game.nextInt(); // guess is the next integer typed
      int closeLower = random - 5; 
      int closeHigher = random + 5;
      numTries = guesses(random, guess, closeLower, closeHigher, numTries);
      numTries++;      
      
      if (numTries == 1) { // if player guesses the number in one guess print the following
         oneGuess();
      }
      else { // if the player guesses more than once
         guessScreens(numTries);
      } // end else
      System.out.println();    
      return numTries;
      } // ends playgame method
      

      
      // NUMBER CHOSEN METHOD
      public static int numberChosen(int limit, int random) {

         Random number = new Random();
         int maximum = limit;
         random = number.nextInt(maximum);
         random += 1;

         System.out.println();
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
            System.out.print("\n|                             |");
            System.out.print("\n|                             |");
            System.out.print("\n|   I Have Chosen A Number!   |");
            System.out.print("\n|          Guess It!          |");
            System.out.print("\n|                             |");
            System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
         System.out.println();
         return random;
      }



      // GUESSES METHOD
      // compares user's guess to the random number generated and prints
      // appropriate screens
      public static int guesses(int random, int guess, int closeLower,
      int closeHigher, int numTries) {

         Scanner game = new Scanner(System.in); 

         while (random != guess) { // while loop if the guess does not equal to the random number
            if (guess <= closeHigher && guess >= random) { 
               guess = closeMenuLower(guess);
               numTries++;
            } // ends if
            else if (guess > random) { // if the guess is higher than the random generated number
               guess = lowerMenu(guess);
               numTries++;
            }
            else if (guess <= random && guess >= closeLower) {
               guess = closeMenuHigher(guess);
               numTries++;
            }
            else { //  if the guess is lower than the random generated number
               guess = higherMenu(guess);
               numTries++;
            }
         }
         return numTries;
      }



      // CLOSE MENU LOWER METHOD
      public static int closeMenuLower(int guess) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|        You're Close!        |");
            System.out.print("\n|     But It's a bit lower!   |");
            System.out.print("\n|         Guess Again!        |");
            System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
         System.out.println();

         Scanner game = new Scanner(System.in); 
         guess = game.nextInt();
         return guess;
      }



      // LOWER MENU METHOD
      public static int lowerMenu(int guess) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|        It's lower!          |");
            System.out.print("\n|          Guess Again!       |");
            System.out.print("\n|                             |");
            System.out.print("\n|                             |\n");
            for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
            }
            System.out.println();

            Scanner game = new Scanner(System.in); 
            guess = game.nextInt();
            return guess;
      }



      // CLOSE MENU HIGHER METHOD
      public static int closeMenuHigher(int guess) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|        You're Close!        |");
            System.out.print("\n|      It's A Bit Higher!     |");
            System.out.print("\n|         Guess Again!        |");
            System.out.print("\n|                             |\n");
            for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
            }
         System.out.println();

         Scanner game = new Scanner(System.in); 
         guess = game.nextInt();   
         return guess;
      }



      // HIGHER MENU METHOD
      public static int higherMenu(int guess) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|       It's Higher!          |");
            System.out.print("\n|          Guess Again!       |");
            System.out.print("\n|                             |");
            System.out.print("\n|                             |\n");
            for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
            }
            System.out.println();

            Scanner game = new Scanner(System.in); 
            guess = game.nextInt();
            return guess;
      }



      // ONE GUESS METHOD
      public static void oneGuess() {
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
            System.out.print("\n|                             |");
            System.out.print("\n|         ** WOW! **          |");
            System.out.print("\n|   You got it in one guess!  |");
            System.out.print("\n|     Want to play again?     |");
            System.out.print("\n|                             |\n");
            for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
               System.out.print("~");
               }
         } // ends if
      


      // ONE DIGIT GUESSES METHOD
      public static void oneDigitGuesses(int numTries) {

         System.out.print("\n|                             |");
         System.out.print("\n|       * You got it! *       |");
         System.out.print("\n|     It Took You " + numTries + " Tries!    |");
         System.out.print("\n|     Want to play again?     |");
         System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
      }



      //TWO DIGIT GUESSES METHOD
      public static void twoDigitGuesses(int numTries) {

         System.out.print("\n|                             |");
         System.out.print("\n|       * You got it! *       |");
         System.out.print("\n|     It Took You " + numTries + " Tries!   |");
         System.out.print("\n|     Want to play again?     |");
         System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
      }



      // THREE DIGIT GUESSES METHOD
      public static void threeDigitGuesses(int numTries) {

         System.out.print("\n|                             |");
         System.out.print("\n|       * You got it! *       |");
         System.out.print("\n|     It Took You " + numTries + " Tries!  |");
         System.out.print("\n|     Want to play again?     |");
         System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
      }

      
      
      //GUESS SCREENS METHOD
      // PRINTS SCREEN BASED ON THE NUMBER OF GUESSES
      public static int guessScreens(int numTries) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
            if (numTries < 9) {
               oneDigitGuesses(numTries);
            }
            else if (numTries > 99) { 
               threeDigitGuesses(numTries);
               }
            else { // if the number is between 9 - 99 or has 2 digits remove 1 space
               twoDigitGuesses(numTries);
            }
            return numTries;
      }



      // RESULTS METHOD
      // calculates the average, and prints the gameCount, totalnumTries, and bestGuess
      public static int results(double gameCount, double totalnumTries, int bestGuess) {
      
         double average = totalnumTries/gameCount; 
      
         resultsMenu();
         gameCount(gameCount);
         totalnumTries(totalnumTries);
         bestGuess(bestGuess);
         average(average);

      return bestGuess;
      }

      

      // RESULTS MENU METHOD
      public static void resultsMenu() {
         for (int topDashes = 1; topDashes <30; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|          RESULTS:         |");
            System.out.print("\n|                           |");
      }



      // GAMECOUNT METHOD
      public static void gameCount(Double gameCount) {

         if (gameCount < 9) {
         System.out.printf("%n| Total Games: %.0f", gameCount);
         System.out.print("            |");
         } 
         else if (gameCount > 99) { // if gameCount is greater than 99 print the following.
         System.out.printf("%n| Total Games: %.0f", gameCount);
         System.out.print("          |");
         } 
         else {
         System.out.printf("%n| Total Games: %.0f", gameCount);
         System.out.print("           |");
         } 
      }



      // TOTAL NUM TRIES METHOD
      public static void totalnumTries(Double totalnumTries) {

         if (totalnumTries < 9) {
            System.out.printf("%n| Total Guesses: %.0f", totalnumTries);
            System.out.print("          |");
            }
            else if (totalnumTries > 99) {
            System.out.printf("%n| Total Guesses: %.0f", totalnumTries);
            System.out.print("        |");
            }
            else {
            System.out.printf("%n| Total Guesses: %.0f", totalnumTries);
            System.out.print("         |");
            }
      }


      // BEST GUESS METHOD
      public static void bestGuess(int bestGuess) {

         if (bestGuess < 9) {
            System.out.print("\n| Best Game: " + bestGuess);
            System.out.print("              |");
            }
            else if (bestGuess > 99) {
            System.out.print("\n| Best Game: " + bestGuess);
            System.out.print("            |");
            }
            else {
            System.out.print("\n| Best Game: " + bestGuess);
            System.out.print("             |");
            }
      }

      
      // AVERAGE METHOD
      public static void average(double average) {

         if (average < 9) {
            System.out.printf("%n| Average Guesses: %.2f", average);
            System.out.print("     |");
            }
         else if (average > 99) {
            System.out.printf("%n| Average Guesses: %.2f", average);
            System.out.print("   |");
            }
         else {
            System.out.printf("%n| Average Guesses: %.2f", average);
            System.out.print("    |");
            }
         
            // bottom dashes
            System.out.print("\n|                           |\n");
         for (int bottomDashes = 1; bottomDashes <30; bottomDashes++) {
            System.out.print("~");
            }
      }



      // WAIT METHOD, INTERUPTS AND SUSPENDS THE EXECUTION
      // NOTE: FOUND THIS ONLINE BECAUSE WE WANTED TO IMPLEMENT
      //       A LOADING SCREEN FEATURE
      public static void wait(int ms) {

         try {
            Thread.sleep(ms); 
         }
         catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
         }
      } // ends wait method
      
   } // ends class