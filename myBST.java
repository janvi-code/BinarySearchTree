package tree;

class Node                       //creating node structure
{
	int data;
	Node left;
	Node right;
	int count;
	Node(int val,int c)
	{
		data=val;
		left=null;
		right=null;
		count=c;
	}
}
public class myBST                              //creating own binary search tree
{
	public int size(Node x)                    // return size of a node
	{
		if(x==null)return 0;
		return x.count;
	}
    public Node insert(Node root,int val)      //insert elements into tree
    {
    	if(root==null)
    		 return new Node(val,1);
    	if(val<root.data)
    		root.left=insert(root.left,val);
    	else
    	    root.right=insert(root.right,val);
       root.count=1+size(root.left)+size(root.right);  
       return root;	
    }
    
    public boolean search(Node root,int val)          //searches for element in tree
    {
    	Node temp=root;
    	while(temp!=null)
    	{
    		if(temp.data>val)
    			temp=temp.left;
    		else if(temp.data<val)
    			temp=temp.right;
    		else if(temp.data==val)
    			return true;
    	}
    	return false;
    }
    
    public int max(Node root)                 //returns maximum value from tree
    {
    	Node t=root;
    	while(t.right!=null)
    	{
    		t=t.right;
    	}
    	return t.data;
    }
    
    public int min(Node root)                //returns minimum value from tree
    {
    	Node t=root;
    	while(t.left!=null)
    	{
    		t=t.left;
    	}
    	return t.data;
    }
    
    public int floor(Node root,int val)          //return largest value that is smaller than given value
    {
    	Node t=root;
    	Node k=null;
    	while(t!=null)
    	{
    		if(t.data>val)
    			t=t.left;
    		else if(t.data<val) 
    		{
    			k=t;
    			t=t.right;
    		}
    		else
    			return val;
    	}
    	return k.data;
    }
    
    public int ceiling(Node root,int val)             //return smallest value that is greater than given value
    {
    	Node t=root;
    	Node k=null;
    	while(t!=null)
    	{
    		if(t.data>val)
    		{
    			k=t;
    			t=t.left;
    		}
    		else if(t.data<val) 
    			t=t.right;
    		else
    			return val;
    	}
    	return k.data;
    }
    
    public int subtreeCount(Node root,int k)            //returns size of a given node's subtree
    {
    	Node t=root;
    	while(t!=null)
    	{
    		if(t.data>k)
    			t=t.left;
    		else if(t.data<k)
    			t=t.right;
    		else
    			return size(t);
    	}
    	return 0;
    }
     
    public int rank(Node root,int val)                //returns number of values that are smaller than given value
    {
    	if(val<root.data)
           return rank(root.left,val);
    	else if(val>root.data)
    	   return 1+size(root.left)+rank(root.right,val);
    	else
    		return size(root.left); 
    }
    
    public void inOrder(Node root)              //print elements of tree in inOrder fashion
    {
        if(root==null) 
        	 return;
    	inOrder(root.left);
    	System.out.println(root.data);
        inOrder(root.right);	
    }
    
    public void preOrder(Node root)         //prints elements of tree in preOrder fashion
    {
    	if(root==null)
    		 return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void postOrder(Node root)        //prints elements of tree on postOrder fashion
    {
    	if(root==null)
    		  return;
    	postOrder(root.left);
    	postOrder(root.right);
    	System.out.println(root.data);
    }
    
    public Node delete(Node root,int val)
    {
    	if(root==null)  return null;
    	if(val<root.data)
    		root.left=delete(root.left,val);
    	else if(val>root.data)
    		root.right=delete(root.right,val);
    	else
    	{
    		if(root.left==null && root.right==null)              //leaf node that is no child
    		{
    			return null;
    		}
    		else if((root.left==null && root.right!=null)||(root.left!=null && root.right==null))   //one child
    		{
    			if(root.left!=null)
    				return root.left;
    			else
    				return root.right;
    		}
    		else                               //two child
    		{
    			root.data=min(root.right);
    			root.right=delete(root.right,root.data);
    		}
    	}
    	root.count=size(root.left)+size(root.right)+1;
    	return root;
    }
}


