public class Node implements Comparable<Node>{
	int freq;
	String ch;
	Node left;
	Node right;
	String code;
	
	public Node(String ch, int freq, Node left, Node right){
		this.freq = freq;
		this.ch = ch;
		this.left = left;
		this.right = right;
	}
	
	public int compareTo(Node other){
		return this.freq - other.freq;
	}
}
