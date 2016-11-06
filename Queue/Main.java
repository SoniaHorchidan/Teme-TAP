
public class Main {

	public static void main(String[] args) {
		Queue<String> queue1 = new Queue<String>();
		queue1.add("A");
		queue1.add("B");
		queue1.add("C");
		queue1.remove();
		queue1.add("D");
		System.out.println(queue1);
		
		
		Queue<Integer> queue2 = new Queue<Integer>();
		queue2.add(11);
		queue2.add(22);
		queue2.add(33);
		queue2.remove();
		queue2.remove();
		queue2.add(44);
		queue2.add(55);
		System.out.println(queue2);
		
		Queue< Queue<Integer> > queue3 = new Queue< Queue<Integer> >();
		Queue <Integer> temp1 = new Queue<Integer>();
		temp1.add(2);
		temp1.add(12);
		temp1.add(4);
		Queue <Integer> temp2 = new Queue<Integer>();
		temp2.add(24);
		temp2.add(13);
		temp2.add(1);
		temp2.add(3);
		temp2.add(15);
		
		queue3.add(temp1);
		queue3.add(queue2);
		queue3.add(temp2);
		queue3.remove();
		System.out.println(queue3);
		
		
		
		/*Iterator i = queue1.iterator();
		
		while (i.hasNext())
		{
			String s = i.next().toString();
			System.out.print(s + " ");
		}*/
		
	}

}
