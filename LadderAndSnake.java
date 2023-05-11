
	/*--------------------------------------------------------------
	 * Assignment: 1 (Due Date 4 February)
	 * Question: 2
	 * Written by: Antoine Mansour 40250454
	 * --------------------------------------------------------------
	 */
	/**
	 * 
	 * @author 
	 * Antoine Mansour 40250454
	 * COMP249
	 * Assignment #1
	 * Due February 3rd
	 *
	 */




	  /**
	   * This is the class definition file of our LadderNSnakes game. Briefly, it begins by stating the variables that we are going to use throughout the program.
	   * Then, we will create a default constructor and a constructor with int as a parameter. The game can only be played by two players, so if the users input more then 2, the program will automatically set number of players to 2, and if the user inputs an integer lower then2, then the program will end.
	   * We then have all the methods to run the game. First, we have the RollDice method which returns a random number between 1-6 to "roll" the dice and let the players move up the board.
	   *After, we have the play method, which holds the basics components of the game. Each player will roll the dice on time, and the one with the highest number will start. If both numbers are equal, a while loop is entered until one of the two players gets a dice value higher then the other.
	   *If the pre-game dice roll of player 1 is higher then player 2's, then he will start. Then, both player 1 and player 2 will keep on throwing the dice, one at a time, until one of them reaches square 100 with the use of a while loop.
	   *I created two added methods called UpOrDown and isWin.
	   *The first one is a method that will evaluate the position of the players and based on them will move them up (with ladders) or down (with snakes).
	   *The second one is a method that will evaluate once again the position of the players and if they got to case 100 or above, they won the game and the program will end.
	   */
	    
	    


	/**
	*import Scanner for user tasks
	 */


	import java.util.Scanner;




	public class LadderAndSnake {
		
		
		//private attributes used for the basic flow of the game.
		
		
		
		/**
		 * Number of players that will play the game inputed by the user.
		 */
		private int numofPlayers;
		/**
		 * Indicates that the players need to hold 100 to win the game.
		 */
		private static final int win = 100;
		/**
		 * Used to hold the position of the player1 during the game.
		 */
		int player1 = 0;
		/**
		 * Used to hold the position of the player2 during the game.
		 */
		int player2=0;
		/**
		 * Used to hold the position of the dice rolls of player1 during the game.
		 */
		int dicep1;
		/**
		 * Used to hold the position of the dice rolls of player2 during the game.
		 */
		int dicep2;
		/**
		 * Used to hold the position of the pre-game dice roll of player1.
		 */
		private int pregamedicep1;
		/**
		 * Used to hold the position of the pre-game dice roll player2 .
		 */
		private int pregamedicep2;
		/**
		 * Used to hold the name of player1
		 */
		private String namep1;
		/**
		 * Used to hold the name of player2
		 */
		private String namep2;
		
	/*
	 * Scanner used for inputs by user.
	 */
		Scanner scan = new Scanner(System.in);
		
		/**
		 * Board 10x10 that will serve as the main playing board and movements of the two players. 
		 */
		private static final int[][] board = { 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }, 
				{ 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
				{ 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 }, 
				{ 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 },
				{ 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 }, 
				{ 61, 62, 63, 64, 65, 66, 67, 68, 69, 70 },
				{ 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 }, 
				{ 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 },
				{ 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 }

		};

		
		
		/**
		 * Default constructor that will automatically set the numbers of player to 2.
		 */
		
		public LadderAndSnake() {
			System.out.println("The number of players is set to 2. Good luck!");
			this.numofPlayers = 2;
		}
		
		
		/**
		 * 
		 * @param player Number of players playing the game
		 * Constructor used for asking the user how many players are going to play the game.
		 * Based on the inputs, severals statements can be executed:
		 * If there is less then two players, the program will terminate
		 * If there is more then two players, the program will automatically set the number of players to two.
		 * If there is exactly two players, the game begins
		 */
		public LadderAndSnake(int player) {
			
		
			
			if (player < 2) {
				
				System.out.println("Error: The game cannot be played by less then 2 players. The program will now exit!");
				System.out.println("\nEnd of program");
				System.exit(0);
			}
			

			else if (player > 2) {

				System.out.println("Initialisation was attempted for " + player
						+ " number of player; however, this is only expected for an extended version of the game");
				System.out.println("\nThe value will be set to 2 players");

				this.numofPlayers = 2;
			}

			else {

				System.out.println("\nThe number of players is set to " + player
						+ " . Good luck to the 2 players and may the best one win! ");
				this.numofPlayers = player;
			}

		}

		
		
	/**
	 * 
	 * @return A random number between 1-6
	 * 
	 * The flipDice() method generates a random number between 1-6 and returns it.
	 */
		
		public int flipDice() {
			int n = (int) (Math.random() * 6) + 1;
			return n;

		}

		/**
		* Main playing method method
		* 
		*Assigning pregamedicep1 and pregamedicep2 to the method flipDice that returns a random integer between 1-6. Based on these results, the player assigned to the highest number will start.
		*If equal, a while loop is called, and both players are rolling the dice until someone gets a higher integer.
		* The program will first ask user to press "Enter" to roll the dice.
		* Then will display the result and the case that the Player is currently at.
		* After, it will check if the position that the Player is in has snakes or ladders and if he won the game, by setting player 2's case to the two methods UpOrDown and isWin.
		* 
		*/
		
		
		
		public void play() {
			System.out.println("\nWelcome to my SnakeNLadders programmed game!");//Brief welcome note
			System.out.println(
					"\nThe game can only be played by 2 players, a later version of the game will soon be playable by 3 people!");
			System.out.println("\nPlayer 1, please enter your name:");
			namep1 = scan.nextLine();
			System.out.println("\nHi " + namep1 + " and good luck!");//ask user for the names of the two players
			System.out.println("\nPlayer 2, please enter your name:");
			namep2 = scan.nextLine();
			System.out.println("\nHi " + namep2 + " and good luck!");

			System.out.println("\nNow that we have our 2 players, let the game begin!");

			System.out.println(
					"Let's see which player will begin the game. Each one of you will roll the dice once, and the one with the highest number will start the game.");
			
			
			 
			
			pregamedicep1 = this.flipDice();//setting the pregamedice roll to the flipDice() method because it returns a random integer between 1-6.
			pregamedicep2 = this.flipDice();
			int dicecount = 0;

			System.out.println("\n"+namep1 + " got a dice value of " + pregamedicep1 + " and " + namep2 + " got a dice value of "
					+ pregamedicep2);

			while (pregamedicep1 == pregamedicep2) {
				++dicecount;
				System.out.println(
						"\nA tie was achieved between " + namep1 + " and " + namep2 + ". Attempting to brake the tie... ");
				pregamedicep1 = this.flipDice();
				pregamedicep2 = this.flipDice();
				System.out.println("\n"+namep1 + " got a dice value of " + pregamedicep1 + " and " + namep2
						+ " got a dice value of " + pregamedicep2);

			}

			System.out.println("\nA final decision has been made regarding the order that the 2 players will play.");
			
			/**
			 * The real game begins now. If pre-game roll of player 1 is higher then player 2's, then the following statements are executed.
			 */

			if (pregamedicep1 > pregamedicep2) {

				System.out.println("\n"+namep1 + " will start " + " and will be followed by " + namep2);
				System.out.println("\nIt took " + dicecount + " tries before a decision could be made!");

			
				/**
				 * While loop that will keep asking user to roll the dice until someone wins the game.
				 */
				
				

				while (true) {
					
					System.out.println("=======================================================================================");
					System.out.println("\nHi " + namep1
							+ ", please press Enter to throw the dice! You are currently at case number " + player1);
					String empty = scan.nextLine();
					/**
					*Ask for user input to keep Rolling the dice by pressing "Enter"
					**/

					System.out.println("\nOk. Now throwing dice!");
					dicep1 = this.flipDice();
					System.out.println("\n"+namep1 + " rolled the dice and got " + dicep1 + ".");
					/**
					*Showing result and case number for player that rolled the dice
					*/
					
					player1 += dicep1;
					System.out.println(namep1 + " is now at case number " + player1);
					
					/**
					 * Check for UpOrDown and isWin method for player1. 
					 */
					
					
					player1=UpOrDown(player1);

					player1=isWin(player1,namep1);

					System.out.println("\nGame not over, rolling again...");
					
					/**
					 * Check if Player 1 got to Player 2's current case. If yes, player 2 goes back to 0.
					 */
					
					if (player1 == player2) {
						player2 = 0;
						System.out.println(namep1 + " just kicked " + namep2 + " back to square 0!");

					}
					System.out.println("========================================================================================");
					
					
					
					
					
					//Player 2 turn.
					System.out.println("\nHi " + namep2
							+ ", please press Enter to throw the dice! You are currently at case number " + player2);
					String empty2 = scan.nextLine();

					System.out.println("\nOk. Now throwing dice!");
					dicep2 = this.flipDice();
					System.out.println("\n"+namep2 + " rolled the dice and got " + dicep2 + ".");
					player2 += dicep2;
					System.out.println(namep2 + " is now at case number " + player2);

					player2=UpOrDown(player2);

					player2=isWin(player2,namep2);
					
					System.out.println("\nGame not over, rolling again...");

					if (player2 == player1) {
						player1 = 0;
						System.out.println(namep2 + " just kicked " + namep1 + " back to square 0!");

					}

				}

			}
			
			
			
			 //If pre-game roll of player2 is higher, then pre-game roll of player1, then the following series of statements are executed.
			 
			

			else {
				System.out.println("\n"+namep2 + " will start " + " and will be followed by " + namep1);
				System.out.println("\nIt took " + dicecount + " tries before a decision could be made!");
				
				
				while (true) {//while loop that will keep the players playing until one of them reaches square 100.
					System.out.println("=======================================================================================");
					System.out.println("\nHi " + namep2
							+ ", please press Enter to throw the dice! You are currently at case number " + player2);
					String empty = scan.nextLine();

					System.out.println("\nOk. Now throwing dice!");
					dicep2 = this.flipDice();
					System.out.println("\n"+namep2 + " rolled the dice and got " + dicep2 + ".");
					player2 += dicep2;
					System.out.println(namep2 + " is now at case number " + player2);

					player2=UpOrDown(player2);

					player2=isWin(player2,namep2);
					
					System.out.println("\nGame not over, rolling again...");

					if (player2 == player1) {
						player1 = 0;
						System.out.println(namep1 + " just kicked " + namep2 + " back to square 0!");

					}
					System.out.println("=======================================================================================");
					System.out.println("\nHi " + namep1
							+ ", please press Enter to throw the dice! You are currently at case number " + player1);
					String empty2 = scan.nextLine();

					System.out.println("\nOk. Now throwing dice!");
					dicep1 = this.flipDice();
					System.out.println("\n"+namep1 + " rolled the dice and got " + dicep1 + ".");
					player1 += dicep1;
					System.out.println(namep1 + " is now at case number " + player1);

					player1=UpOrDown(player1);

					player1=isWin(player1,namep1);
					
					System.out.println("\nGame not over, rolling again...");

					if (player1 == player2) {
						player2 = 0;
						System.out.println(namep1 + " just kicked " + namep2 + " back to square 0!");

					}

				}
							
				
				
				
			}

			
			
			
		}
		
		
		 
		
		
		/**
		 * Private method that will check if there is any snakes or ladders at the case that the Player 1 or 2 arrives. 
		 * In this method, I will express the playing board as the 2D array I created by assigning the snakes and ladders to corresponding Integers in the 2d array.
		 * @param position, an Integer value that indicates the position of the player.
		 * @return The positions of the players after using a snake or a ladder.
		 * 
		 */
		private static int UpOrDown(int position) {
			
			if (position==1) {//Ladders
				position=board[3][7];
				System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
				return position;
				
			}
			
			else if (position==4) {
					position=board[1][3];
					System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
					return position;
					
				}
			
			else if (position==9) {
				position=board[3][0];
				System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
				return position;
				
			}
			
			else if (position==21) {
				position=board[4][1];
				System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
				return position;
				
			}
			
			else if (position==28) {
				position=board[8][3];
				System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
				return position;
				
			}
			
			else if (position==36) {
				position=board[4][3];
				System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
				return position;
				
			}
			
			else if (position==71) {
				position=board[9][0];
				System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
				return position;
				
			}else if (position==51) {
				position=board[6][6];
				System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
				return position;
				
			}
			else if (position==80) {
				position=board[9][9];
				System.out.println("\nYay! You just arrived at a case with a ladder. You are now up at "+ position);
				return position;
				}
			
			else if (position==16) {//Snakes
				position=board[0][5];
				System.out.println("\nWoops! You just arrived at a case with a snake. You are now down at case "+ position);
				return position;
				}
			else if (position==48) {
				position=board[2][9];
				System.out.println("\nWoops! You just arrived at a case with a snake. You are now down at case "+ position);
				return position;
				}
			else if (position==64) {
				position=board[5][9];
				System.out.println("\nWoops! You just arrived at a case with a snake. You are now down at case "+ position);
				return position;
				}
			else if (position==79) {
				position=board[1][8];
				System.out.println("\nWoops! You just arrived at a case with a snake. You are now down at case "+ position);
				return position;
				}
			else if (position==93) {
				position=board[6][7];
				System.out.println("\nWoops! You just arrived at a case with a snake. You are now down at case "+ position);
				return position;
				}
			else if (position==95) {
				position=board[2][3];
				System.out.println("\nWoops! You just arrived at a case with a snake. You are now down at case "+ position);
				return position;
				}
			else if (position==97) {
				position=board[7][5];
				System.out.println("\nWoops! You just arrived at a case with a snake. You are now down at case "+ position);
				return position;
				}
			else if (position==98) {
				position=board[7][7];
				System.out.println("\nWoops! You just arrived at a case with a snake. You are now down at case "+ position);
				return position;}
				
			
			else
				return position;
				
				
				}
			
			
			
			
		
		
		 
		
		
		
		
		/**
		 * 
		 * @param player, A String value of the name of the player.
		 * @param position, an Integer value that indicates the position of the player
		 * @return The position of the player.
		 * Method that will check if player1 or player2 got to case 100.
		 *if the player got to a case higher then 100, then he will automatically come back to the winning square.
		 *if the player got to case[9][9], or case 100, then he/she has won.
		 *Then, the game will end.
		 */
		private static int isWin(int position,String player) {
			
			if (position>board[9][9]) {//if position>100, it's value will get subtracted by the amount it surpasses 100.
				int temp=position-board[9][9];
				position-=temp;
				return position;
			}
			
			
			if (position==board[9][9]) {//if player reaches 100, then he won the game.
			System.out.println("Congratulations, "+ player+", you just won the game!!");
			System.out.println("\nThanks to the both of you to play the Demo of the LadderNSnakes game!");
			System.out.println("\nThe game will now end.");
			System.exit(0);//System will exit.
				
			}
			
			
			
			
			
			return position;
		
		
	}}


