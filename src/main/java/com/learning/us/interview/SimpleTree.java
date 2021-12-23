package com.learning.us.interview;

public class SimpleTree {

	static class Tree{
		
		int data;
		Tree left;
		Tree right;
		
		public Tree(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
		
		public Tree(int data, Tree left,Tree right) {
			this.data=data;
			this.left=left;
			this.right=right;
		}
		
	}
	
	public static void main(String[] args) {
		Tree leftLastLeftNode=new Tree(3);
		Tree leftLastRightNode=new Tree(5);
		Tree leftlastRootNode= new Tree(6, leftLastLeftNode, leftLastRightNode);
		Tree rightLastLeftNode=new Tree(1);
		Tree rightLastRightNode=new Tree(2);
		Tree rightLastRootNode=new Tree(7, rightLastLeftNode, rightLastRightNode);
		Tree mainTree=new Tree(4, leftlastRootNode, rightLastRootNode);
		//dfsPreOrder(mainTree);
		//dfsInOrder(mainTree);
		dfsPostOrder(mainTree);
	}
	
	 static void dfsPreOrder(Tree root) {
		 if(root==null)
			 return;
		 System.out.println(root.data);
		 dfsPreOrder(root.left);
		 dfsPreOrder(root.right);
	 }
	 
	 static void dfsInOrder(Tree root)
	 {
		 if(root==null)
			 return;
		 dfsInOrder(root.left);
		 System.out.println(root.data);
		 dfsInOrder(root.right);
	 }
	 
	 static void dfsPostOrder(Tree root)
	 {
		 if(root==null)
			 return;
		 dfsPostOrder(root.left);
		 dfsPostOrder(root.right);
		 System.out.println(root.data);
	 }

}

