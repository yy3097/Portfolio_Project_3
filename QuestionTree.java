// Yao Yi
// 12/03/2015
// CSE 143 AC 
// TA: LATHE,CHLOE M.  
// 
// This class manages a yes/no questions and answers guessing game that computer 
// plays with users. 

import java.util.*;
import java.io.*;

public class QuestionTree { 
   private QuestionNode myRoot; // overall root
   private UserInterface ui; 
   private int gameCount; // record total number of games played 
   private int won; // record number of games won by computer
   
   // pre: pass in a UserInterface object for input/output. 
   //      if the UserInterface is null, throw IllegalArgumentException. 
   // post: initialize a new QuestionTree over the given UserInterface with 
   //       starts out containing only a single answer "computer" in it.
   public QuestionTree(UserInterface ui) {
      checkIfNull(ui); 
      myRoot = new QuestionNode("computer"); 
      this.ui = ui; 
   }
   
   // pre: pass in an object. 
   // post: check if the object is null. If so, throw IllegalArgumentException. 
   private void checkIfNull(Object obj) {
      if (obj == null) {
         throw new IllegalArgumentException(); 
      }
   }
   
   // post: play one complete guessing game with the user, asking yes/no questions 
   //       until reaching an answer object to guess. 
   //       If the computer wins, there will be a message saying so. 
   //       Otherwise it will ask the user for the object and a new question and answer 
   //       to improve it. 
   public void play() {
      myRoot = playGame(myRoot); 
      gameCount++; 
   }
   
   // pre: pass in a QuestionNode represents the current node works on. 
   //      if the node is null, throw IllegalArgumentException.
   // post: play one complete guessing game with the user, asking yes/no questions 
   //       until reaching an answer object to guess. 
   //       If the computer wins, print a message saying so. 
   //       Otherwise it will ask the user for the object and a new question and answer 
   //       to improve it. 
   //       return this node. 
   private QuestionNode playGame(QuestionNode root) {
      checkIfNull(root); 
      String data = root.data; 
      if (root.left != null && root.right != null) { // the node is a question
         ui.print(data); 
			if (ui.nextBoolean()) {
				root.left = playGame(root.left); // yes goes to left
			} else {
				root.right = playGame(root.right); // no goes to right
			}
		} else { // the node is an answer
         ui.print("Would your object happen to be " + data + "?"); 
         if (ui.nextBoolean()) { // computer win, print message
            ui.println("I win!"); 
            won++; 
         } else {
            root = addNewQuestion(root); // computer lose, improve the game
         }
      }
      return root; 
   }
   
   // pre: pass in a QuestionNode representing the wrong guess. 
   // post: add a new question to the game based on the wrong guess. 
   //       ask the user for the correct object, a question used to distinguish this 
   //       object, and the yes/no answer. 
   //       return the new question node based on new question and answer. 
   private QuestionNode addNewQuestion(QuestionNode root) {
      ui.print("I lose. What is your object?");
      String answer = ui.nextLine(); 
      ui.print("Type a yes/no question to distinguish your item from " + root.data + ":");
      String newQuestion = ui.nextLine(); 
      ui.print("And what is the answer for your object?");
      if (ui.nextBoolean()) {
         return new QuestionNode(newQuestion, new QuestionNode(answer), root);
      } else {
         return new QuestionNode(newQuestion, root, new QuestionNode(answer));
      }
   }
   
   // pre: pass in a PrintStream object to save the game. 
   //      if the PrintStream is null, throw IllegalArgumentException.
   // post: store the current game to an output file represented by the given PrintStream. 
   public void save(PrintStream output) {
      checkIfNull(output); 
      saveMyQuestion(output, myRoot);  
   }
   
   // pre: pass in a PrintStream object to save the game, and a QuestionNode 
   //      represents the current node works on. 
   // post: store the current game to an output file by a preorder traversal. 
   private void saveMyQuestion(PrintStream output, QuestionNode root) {
      if (root != null) {
         if (root.left != null && root.right != null) { // question
   				output.print("Q:");
         } else { // answer
   				output.print("A:");
   		}
   		output.println(root.data);
   		saveMyQuestion(output, root.left);
   		saveMyQuestion(output, root.right);
      }
   }
   
   // pre: pass in a scanner object that that reads from a file. 
   //      if the scanner is null, throw IllegalArgumentException. 
   // post: replace the current game with new questions and answers 
   //       using the information in the file.
   public void load(Scanner input) {
      checkIfNull(input); 
      myRoot = loadTree(input); 
   }
   
   // pre: pass in a scanner object that that reads from a file. 
   // post: replace the current question tree with a new tree using the information 
   //       in the file and return a QuestionNode which is the root of the tree. 
   private QuestionNode loadTree(Scanner input) {
      String replace = input.nextLine(); 
      QuestionNode newRoot = new QuestionNode(replace.substring(2)); 
      if (replace.startsWith("Q:")) {
         newRoot.left = loadTree(input); 
         newRoot.right = loadTree(input); 
      }
      return newRoot; 
   }
   
   // post: return an integer of the total number of games that have been played so far. 
   public int totalGames() { 
      return gameCount; 
   }
   
   // post: return an integer of the number of games the computer 
   //       has won by correctly guessing the object. 
   public int gamesWon() {
      return won; 
   } 
}