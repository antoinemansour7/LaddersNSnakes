
/*--------------------------------------------------------------
 * Assignment: 1 (Due Date:4 February)
 * Question: 1
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
 * This class is the main driver of the class LadderAndSnake.java 
 * Briefly, this class just asks for an input by the user to decide how many players are going to play the game.
 *Then, the game will start.
 * @param args
 */


import java.util.Scanner;

public class PlayLadderAndSnake {
/**
 * Driver file for the LadderAndSnake class definiton file. The user will be granted an will be asked how many players are there.
 * @param args
 */
	public static void main(String[] args) {
		
		
		Scanner scan=new Scanner(System.in);
		
		int nbplayers;
		
		System.out.println("Hi, welcome to my Ladder and Snakes game!");
		System.out.println(" \nPlease enter bellow the number of players that are willing to play!");
		nbplayers=scan.nextInt();
		
		/*
		 * calling a constructor with parameter.
		 * Creating a new game
		 */
		
		LadderAndSnake G1=new LadderAndSnake(nbplayers);
		
	
														
		
		G1.play();
		/*
		 * Let the game begin!
		 */

	}

}
