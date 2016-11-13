import java.util.*;
import java.util.Map.Entry;

public class HuffmanTree {
	Node root;
	HashMap<Character, String> codeMap = new HashMap<>();
	public HuffmanTree(Node root){
		this.root = root;
		assignCodes();
		toHashMap(root);
	}
	
	public void assignCodes(){
		assignCodes(root, "");
	}
	
	private void assignCodes(Node node, String code){
		if(node == null)
			return;
		node.code = code;
		assignCodes(node.left, node.code + "0");
		assignCodes(node.right,node.code + "1");
		
	}
	
	private void toHashMap(Node node){
		if(node != null){
			toHashMap(node.left);
			if(isLeaf(node))
				codeMap.put(node.ch.charAt(0), node.code);
			toHashMap(node.right);
		}

		
	}
	
	private boolean isLeaf(Node node){
		return node.left == null && node.right == null;
	}
	
	public String getCodeOf(Character c){
		return codeMap.get(c);
	}
	
	public Character getSymbolOf(String code){
		Set <Entry<Character, String>> set = codeMap.entrySet();
		for(Entry<Character, String> entry: set){
			if(entry.getValue().equals(code))
				return entry.getKey();
		}
		return null;
	}
}
