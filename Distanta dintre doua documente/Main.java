import java.util.*;
import java.io.File;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) {
		
		HashMap<String, Integer> h1 = new HashMap<String, Integer>();
		HashMap<String, Integer> h2 = new HashMap<String, Integer>();
		
		Scanner sc = null;
		String word;
		try{
			sc = new Scanner(new File("F1"));
			sc.useDelimiter("[^A-Za-z0-9]+");
			while(sc.hasNext()){
				word = sc.next().toLowerCase();
				
				if(h1.get(word) == null)
					h1.put(word, 1);
				else 
					h1.put(word, h1.get(word) + 1);
			}
			Set <Entry<String, Integer>> set1 = h1.entrySet();
			sc.close();
			sc = new Scanner(new File("F2"));
			sc.useDelimiter("[^A-Za-z0-9]+");
			while(sc.hasNext()){
				word = sc.next().toLowerCase();
				
				if(h2.get(word) == null)
					h2.put(word, 1);
				else 
					h2.put(word, h2.get(word) + 1);
			}	
			double dcos = 0;
			
			for(Entry<String, Integer> I: set1){
				if(h2.get(I.getKey()) != null){
						dcos += I.getValue() * h2.get(I.getKey());/*J.getValue()*/;
					}
				}
			
			Set <Entry<String, Integer>> set2 = h2.entrySet();	
			double sqr1 = 0, sqr2 = 0;
			for(Entry<String, Integer> I: set1)
				sqr1 += I.getValue() * I.getValue();
			sqr1 = Math.sqrt(sqr1);
			for(Entry<String, Integer> I: set2)
				sqr2 += I.getValue() * I.getValue();
			sqr2 = Math.sqrt(sqr2);
			
			if(sqr1 * sqr2 != 0)
				dcos = dcos / (sqr1 * sqr2);
			else 
				dcos = 0;
			System.out.println("\ndcos(F1, F2) = " + dcos);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if(sc != null)
				sc.close();
		}
		
		
		

	}

}
