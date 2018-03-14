public class BinaryTree{
	
	static TreeNode root;
	
	public static class TreeNode{
		static TreeNode left;
		static TreeNode right;
		static int data;
		
		TreeNode(int value){
			left = null;
			right = null;
			data =  value;
		}
	}
	
	static TreeNode insert(int key){
		TreeNode current = root;
		TreeNode newnode = new TreeNode(key);
		TreeNode parent  = null;
		if(current == null){
			root = newnode;
			return root;
		}
		
		while(true){
			parent = current;
			if(key<current.data){
				current = current.left;
				if(current == null){
					parent.left = newnode;
					return newnode;
				}
			}else{
				current = current.right;
				if(current == null){
					parent.right = newnode;
					return newnode;
				}
			}
		}
		
	}

	static TreeNode search(int key){
		TreeNode  current = root;
		while(current != null && current.data != key){
			if(current.data > key){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return current;
	}
}