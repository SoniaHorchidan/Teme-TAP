import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String []args){
		
		BinarySearchTree<Integer> arb = new BinarySearchTree<Integer>();
		
		try{
			int element;
			Scanner in = new Scanner(new File("arbore"));
			while(in.hasNextInt()){
				element = in.nextInt();
				arb.insert(element);
			}
			in.close();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		
		//System.out.println(arb);
		
		/*BinarySearchTree<Rectangle> arbgeom = new BinarySearchTree<Rectangle>();
		Rectangle r1 = new Rectangle(2,3);
		Rectangle r2 = new Rectangle(12.22, 4.5);
		Rectangle r3 = new Rectangle(1,1);
		Square s1 = new Square(4.55);
		Square s2 = new Square(1);
		Square s3 = new Square(12.2);
		Square s4 = new Square(3.27);
		
		arbgeom.insert(r1);
		arbgeom.insert(r2);
		arbgeom.insert(r3);
		arbgeom.insert(s1);
		arbgeom.insert(s2);
		arbgeom.insert(s3);
		arbgeom.insert(s4);
		
		System.out.println(arbgeom);
		*/
		
		
		/*BinarySearchTree<Integer> arb2 = new BinarySearchTree<Integer>();
		arb2.insert(22);
		arb2.insert(13);
		arb2.insert(45);
		arb2.insert(2);
		arb2.insert(5);
		arb2.insert(19);
		arb2.insert(44);
		
		System.out.println(arb.equals(arb2));*/
		
		
		BinarySearchTree<String> arb3 = new BinarySearchTree<String>();
		arb3.insert("A");
		arb3.insert("B");
		arb3.insert("C");
		
		BinarySearchTree<String> arb4 = new BinarySearchTree<String>();
		arb4.insert("A");
		arb4.insert("B");	
		
		System.out.println(arb3.equals(arb4));
		
		
		
		
		
		
		
		
		
		
	}
}
