import java.util.ArrayDeque;

public class Graf {
	int V;
	int E;
	Node []nodes;
	
	class Node{
		ArrayDeque<Node> list = new ArrayDeque<Node>(); 
		int id;
		public Node(int id){
			this.id = id;
		}
		public void add(int id){
			Node node = new Node(id);
			this.list.add(node);
		}
		public String toString(){
			return Integer.toString(id);
		}
	}
	
	public Graf(int V, int E){
		this.V = V;
		this.E = E;
		nodes = new Node[V+2];
		for(int i = 1; i <= V; i++)
			nodes[i] = new Node(i);
	}
	
	public void add(int x, int y){
		nodes[x].add(y);
		nodes[y].add(x);
	}
	
	public String toString(){
		String string = new String();
		for(int i=1; i <= V; i++){
			string += i + ": ";
			string += nodes[i].list;
			string += "\n";
		}
		return string;
	}
	
	public String BFS(int start){
		String string = new String();
		ArrayDeque<Node> queue = new ArrayDeque <Node>(); 
		int viz[] = new int[V+2];
		Node s = nodes[start];
		viz[start] = 1;
		queue.add(s);
		string += start + " ";
		while(!queue.isEmpty()){
			Node current = queue.peek();
			queue.remove();
			for(int i = 0; i < nodes[current.id].list.size(); i++){
				Node temp =  nodes[current.id].list.peek();
				if(viz[temp.id] == 0){
					string += nodes[current.id].list.peek() + " ";
					queue.add(temp);
					nodes[current.id].list.remove();
					nodes[current.id].list.add(temp);
					viz[temp.id] = 1;
				}
				else{
					nodes[current.id].list.remove();
					nodes[current.id].list.add(temp);
				}
				
			}	
		}
		return string;
	}
	
}
