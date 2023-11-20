// Yao Yi
// 12/03/2015
// CSE 143 AC 
// TA: LATHE,CHLOE M.  
// 
// This class represents a single node of a binary tree. 

public class QuestionNode { 
   public String data; 
	public QuestionNode left; // left branch
	public QuestionNode right; // right branch
	
	// pre: pass in a string of given data. 
   // post: initialize a single node of the tree over the given data. 
	public QuestionNode(String data) {
		this(data, null, null);
	}
	
	// pre: pass in a string of given data, and 2 other QuestionNode which will be the branches. 
   // post: initialize a single node of the tree with the given data, and links it to the two 
   //       nodes by left and right sides seperately. 
	public QuestionNode(String data, QuestionNode left, QuestionNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}