import java.util.Stack;

public class BinarySearchTree <Key extends Comparable<Key>/*, Value*/>{
	
	private Node root;
	
	private class Node{
		private Key key;
		//private Value val;
		private Node left;
		private Node right;
		
		
		public Node(Key _key/*, Value _val*/){
			key = _key;
		//	val = _val;
			left = null;
			right = null;	
		}
	}
	
	public boolean insert(Key key/*, Value value*/){
		Node node = new Node(key/*, value*/);
		if(root == null){
			root = node;
			return true;
		}
		else{
			Node current  = root;
			Node parent = null;
			while(true){
				parent = current;
				if(key.compareTo(current.key) == 0)
					return false;
				else 
					if(key.compareTo(current.key) < 0){
						current = current.left;
						if(current == null){
							current = node;
							parent.left = current;
							return true;
						}
					}
					else{
						current = current.right;
						if(current == null){
							current = node;
							parent.right = current;
							return true;
						}
					}
			
			}	
		}
	}

	public String toString(){
		return SRD(root);
	}
	
	private String SRD(Node nroot){
		String srd = new String();
		if(nroot == null)
			return null;
		Stack <Node> stack = new Stack <Node>();
		Node current = nroot;
		while(current != null || !stack.isEmpty()){
			if(current != null){
				 stack.push(current);  
				 current=current.left;  
			}  
			else{  
			    Node node = stack.pop();  
			    srd += node.key + " "/* +  node.val*/;
			   // srd += '\n';
			    current = node.right;  
			}
		
		}
		return srd;
	}
	
	public boolean equals(BinarySearchTree<Key> Tree){
		return equals(this.root, Tree.root);
	}
	
	private boolean equals(Node node1, Node node2){
		if(node1 == null && node2 == null)
			return true;
		else 
			if((node1 == null && node2 != null) || (node1 != null && node2 == null))
				return false;
			else{
				if(node1.key.compareTo(node2.key) == 0)
					return (equals(node1.left, node2.left) && equals(node1.right, node2.right));
				else 
					return false;
			}
	}

	@Override
	//????
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		return result;
	}
}
