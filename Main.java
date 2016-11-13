import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = null;
		Character input = null;
		HashMap <String, Integer> hm = new HashMap<String, Integer>();
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		try{
			scan = new Scanner(new File("text"));
			scan.useDelimiter("");
			while(scan.hasNext()){
				input = scan.next().charAt(0);
				String aux_in = input + "";
				if(hm.get(aux_in) == null)
					hm.put(aux_in, 1);
				else 
					hm.put(aux_in, hm.get(aux_in) + 1);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			scan.close();
		}

		Set <Entry<String, Integer>> set = hm.entrySet();
		for(Entry<String, Integer> I: set){
			Node node = new Node(I.getKey(), I.getValue(), null, null);
			queue.add(node);
		}
		
		Node root = null;
		while(queue.size() > 1){
			Node left = queue.poll();
			Node right = queue.poll();
			root = new Node(left.ch + right.ch, left.freq + right.freq, left, right);
			queue.add(root);
		}
		
		HuffmanTree huffman = new HuffmanTree(root);
		
		//Code
		/*try{
			scan = new Scanner(new File("text"));
			scan.useDelimiter("");
			PrintWriter writer = new PrintWriter("codificare", "UTF-8");
			while(scan.hasNext()){
				input = scan.next().charAt(0);	
				writer.print(huffman.getCodeOf(input));	
			}
			writer.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			scan.close();
		}
		*/
		
		//Decode
		try{
			String code = "";
			boolean found = false;
			scan = new Scanner(new File("codificare"));
			scan.useDelimiter("");
			PrintWriter writer = new PrintWriter("decodificare", "UTF-8");
			while(scan.hasNext()){
				found = false;
				code = "";
				while(scan.hasNext() && !found){
					code += scan.next().charAt(0);
					Character c = huffman.getSymbolOf(code);
					if(c != null){
						writer.print(c);	
						found = true;
					}
				}
			}
			writer.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			scan.close();
		}

	}

}
