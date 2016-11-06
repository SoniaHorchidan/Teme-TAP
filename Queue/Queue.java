import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
	private Node head;
	private Node tail;
	private int dim;
	
	class Node{
		T info;
		Node next;
		Node(T info, Node next){
			this.info = info;
			this.next = next;
		}
	}
	
	public Queue(){
		head = null;
		tail = null;
		dim = 0;
	}
	public void add(T info){
		Node node = new Node(info, null);
		if(head == null){
			head = node;
			head.next = null;
			tail = head;
		}
		else 
		{
			tail.next = node;
			node.next = null;
			tail = node;
		}
		dim++;
	}
	
	public void remove(){
		if(head == null)
			throw new QueueException("Coada goala!");
		else
		{
			head = head.next;
			dim--;
		}
	}
	
	public T peek(){
		if(head == null)
			throw new QueueException("Coada goala!");
		else 
			return head.info;
	}
	
	public String toString(){
		Node node = head;
		String string = new String();
		while(node != null){
			string += node.info + " ";
			node = node.next;
		}
		return string;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int size(){
		return dim;
	}
	
	public Iterator<T> iterator(){
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<T>{
		private Node current = head;
		
		public boolean hasNext() { 
			return current != null;
		}
		public void remove() { throw new QueueException("EROARE");}
		
		public T next() {
			if(!hasNext())
				throw new QueueException("Coada goala!");
			else {
				Node node = current;
				current = current.next;
				return node.info;
			}
				
		}
	}

}
